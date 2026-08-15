package com.opencart.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DbUtils {

    private static final Logger logger =
            LogManager.getLogger(DbUtils.class);

    private static final String URL =
            "jdbc:mariadb://localhost:3306/opencart";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "";

    public static String getProductName(int productId)
            throws SQLException {

        String query =
                "SELECT name FROM oc_product_description " +
                        "WHERE product_id = ?";

        logger.info(
                "Fetching product name for productId: {}",
                productId
        );

        try (
                Connection connection =
                        DriverManager.getConnection(
                                URL,
                                USERNAME,
                                PASSWORD
                        );

                PreparedStatement preparedStatement =
                        connection.prepareStatement(query)
        ) {

            logger.info("Database connection established");

            preparedStatement.setInt(1, productId);

            try (ResultSet resultSet =
                         preparedStatement.executeQuery()) {

                if (resultSet.next()) {

                    String productName =
                            resultSet.getString("name");

                    logger.info(
                            "Product found for productId: {}",
                            productId
                    );

                    return productName;
                }
            }
        }

        logger.warn(
                "No product found for productId: {}",
                productId
        );

        return null;
    }
}
