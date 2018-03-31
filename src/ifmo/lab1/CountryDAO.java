package ifmo.lab1;


import ifmo.lab3.exception.CountriesServiceFault;
import ifmo.lab3.exception.NotFoundException;
import lombok.val;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CountryDAO {

    private Connection connection;

    public CountryDAO(Connection connection) {
        this.connection = connection;
    }

    public Country getCountry(String code) throws NotFoundException {
        try (val conn = getConnection()) {
            val stmt = conn.createStatement();
            val query = "SELECT * FROM country WHERE code='" + code + "'";
            val rs = stmt.executeQuery(query);
            if (rs.next()) {
                return convert(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new NotFoundException("No country with code" + code,
                new CountriesServiceFault("Conutry not found"));
    }

    public List<Country> getCountries(String term) {
        List<Country> countries = new ArrayList<>();
        try (val conn = getConnection()) {
            val stmt = conn.createStatement();
            val query = new StringBuilder("SELECT * FROM country WHERE ");
            for (val key : Country.STRING_KEYS) {
                query.append("LOWER(");
                query.append(key);
                query.append(") LIKE '%");
                query.append(term.toLowerCase());
                query.append("%' OR ");
            }
            try {
                double number = Double.valueOf(term);
                for (val key : Country.NUMBER_KEYS) {
                    query.append(key);
                    query.append("=");
                    query.append(term);
                    query.append(" OR ");
                }
            } catch (NumberFormatException e) {
                // not a number
            }
            // remove last or
            if (query.length() >= 3) {
                query.setLength(query.length() - 3);
            }
            val rs = stmt.executeQuery(query.toString());

            while (rs.next()) {
                val country = convert(rs);
                countries.add(country);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return countries;
    }

    private Country convert(ResultSet rs) throws SQLException {
        return Country.builder()
                .code(rs.getString(Country.KEY_CODE))
                .name(rs.getString(Country.KEY_NAME))
                .continent(rs.getString(Country.KEY_CONTINENT))
                .region(rs.getString(Country.KEY_REGION))
                .surfaceArea(rs.getFloat(Country.KEY_SURFACE_AREA))
                .population(rs.getLong(Country.KEY_POPULATION))
                .localName(rs.getString(Country.KEY_LOCAL_NAME))
                .governmentForm(rs.getString(Country.KEY_GOVERNMENT_FORM))
                .headOfState(rs.getString(Country.KEY_HEAD_OF_STATE))
                .build();
    }

    public Connection getConnection() {
        return connection;
    }
}