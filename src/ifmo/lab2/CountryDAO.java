package ifmo.lab2;

import ifmo.lab1.Country;
import ifmo.lab2.entity.ResponseCode;
import lombok.val;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryDAO extends ifmo.lab1.CountryDAO {

    public CountryDAO(Connection connection) {
        super(connection);
    }

    public String addCountry(Country country) {
        try (val conn = getConnection()) {
            val code = country.getCode();
            if (code == null || code.equals("")) {
                val name = country.getName();
                if (name != null && !name.equals("")) {
                    country.setCode(name.substring(0, Math.min(3, name.length())).toUpperCase());
                }
            }
            val query = "INSERT INTO country (code, name, continent, region, surfacearea, population,localname, governmentform, headofstate, code2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            val stmt = conn.prepareStatement(query);
            stmt.setString(1, country.getCode());
            stmt.setString(2, country.getName());
            stmt.setString(3, country.getContinent());
            stmt.setString(4, country.getRegion());
            stmt.setFloat(5, country.getSurfaceArea());
            stmt.setFloat(6, country.getPopulation());
            stmt.setString(7, country.getLocalName());
            stmt.setString(8, country.getGovernmentForm());
            stmt.setString(9, country.getHeadOfState());
            stmt.setString(10, country.getCode2());
            stmt.executeUpdate();
            stmt.close();
            return country.getCode();
        } catch (SQLException ex) {
            Logger.getLogger(ifmo.lab1.CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResponseCode updateCountry(Country country) {
        try (val conn = getConnection()) {
            val query = "UPDATE country " +
                    "SET code = ?, name = ?, continent = ?, surfacearea = ?, population = ?, localname = ?, " +
                    "governmentform = ?, headofstate = ? " +
                    "WHERE code = ?";
            val stmt = conn.prepareStatement(query);
            stmt.setString(1, country.getCode());
            stmt.setString(2, country.getName());
            stmt.setString(3, country.getContinent());
            stmt.setFloat(4, country.getSurfaceArea());
            stmt.setFloat(5, country.getPopulation());
            stmt.setString(6, country.getLocalName());
            stmt.setString(7, country.getGovernmentForm());
            stmt.setString(8, country.getHeadOfState());
            stmt.setString(9, country.getCode());
            boolean updated = stmt.executeUpdate() > 0;
            stmt.close();
            if (updated) {
                return new ResponseCode(200, "Successfully updated country");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ifmo.lab1.CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseCode(500, "Couldn't update the country");
    }

    public ResponseCode deleteCountry(String code) {
        try (val conn = getConnection()) {
            val queryLang = String.format("DELETE FROM countrylanguage WHERE countrycode = '%S'", code);
            val queryCountry = String.format("DELETE FROM country WHERE code = '%S'", code);
            val stmt = conn.createStatement();
            try {
                stmt.executeQuery(queryLang);
            }catch (SQLException e) {
                // Ignore
            }
            stmt.executeQuery(queryCountry);
            stmt.close();
            return new ResponseCode(200, "Successfully deleted country");
        } catch (SQLException ex) {
            Logger.getLogger(ifmo.lab1.CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ResponseCode(500, "Couldn't delete the country");
    }
}