package com.opencart.automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReaderUtility {

    private static final Logger logger =
            LogManager.getLogger(ExcelReaderUtility.class);

    public static Object[][] getExcelData(
            String path,
            String sheetName) throws IOException {

        logger.info(
                "Reading Excel test data from file: {}",
                path
        );

        logger.info(
                "Reading sheet: {}",
                sheetName
        );

        try (
                FileInputStream fis =
                        new FileInputStream(path);

                Workbook workbook =
                        WorkbookFactory.create(fis)
        ) {

            Sheet sheet =
                    workbook.getSheet(sheetName);

            if (sheet == null) {

                logger.error(
                        "Sheet not found: {}",
                        sheetName
                );

                throw new IllegalArgumentException(
                        "Sheet not found: " + sheetName
                );
            }

            int rows =
                    sheet.getPhysicalNumberOfRows();

            int columns =
                    sheet.getRow(0)
                            .getPhysicalNumberOfCells();

            logger.info(
                    "Excel sheet loaded. Rows: {}, Columns: {}",
                    rows,
                    columns
            );

            Object[][] data =
                    new Object[rows - 1][columns];

            for (int i = 1; i < rows; i++) {

                for (int j = 0; j < columns; j++) {

                    Cell cell =
                            sheet.getRow(i).getCell(j);

                    if (cell == null) {

                        data[i - 1][j] = "";

                    } else {

                        data[i - 1][j] =
                                cell.toString();
                    }
                }
            }

            logger.info(
                    "Excel test data read successfully"
            );

            return data;
        }
    }
}