package com.didicms.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelUtil {
	static class Inner {
		Connection conn;
		PreparedStatement pstmt;

		public Inner(Connection conn, PreparedStatement pstmt) {
			this.conn = conn;
			this.pstmt = pstmt;
		}

		public Inner() {
		};

		public void preExecute(String sql, Workbook workbook) throws SQLException {
			conn = DBUtil.getConn();
			pstmt = conn.prepareStatement(sql);
		}

		public void postExecute() throws SQLException {
			pstmt.executeBatch();
			DBUtil.closeStmt(pstmt);
			DBUtil.closeConn(conn);

		}
	}

	private static String excelFileURL = "i:/db0506temp.xlsx";

	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		Workbook workbook = new XSSFWorkbook(new FileInputStream(excelFileURL));
		executeDriver(workbook);
	}
	private static void executeOrder(Workbook workbook) throws SQLException {
		String sql = "INSERT INTO `didicms`.`order`(`order_driver_id`,`order_date`,`order_quantity`,`order_transaction_amount`,`order_charging_time`,`order_bad_review`,`order_driver_score`,`order_driver_grade`,`order_reward`)VALUES(?,?,?,?,?,?,?,?,?)";
		Sheet sheet = workbook.getSheet("order");
		Inner inner = new Inner();

		try {
			inner.preExecute(sql, workbook);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				//inner.pstmt.setInt(1, (int) row.getCell(0).getNumericCellValue());
				inner.pstmt.setString(1, row.getCell(1).getStringCellValue());
				inner.pstmt.setDate(2, new java.sql.Date(new Date().getTime()));
				inner.pstmt.setInt(3, (int) row.getCell(3).getNumericCellValue());
				inner.pstmt.setDouble(4, row.getCell(4).getNumericCellValue());
				inner.pstmt.setDouble(5, row.getCell(5).getNumericCellValue());
				inner.pstmt.setDouble(6, row.getCell(6).getNumericCellValue());
				inner.pstmt.setDouble(7, row.getCell(7).getNumericCellValue());
				inner.pstmt.setString(8, row.getCell(8).getStringCellValue());
				inner.pstmt.setDouble(9, row.getCell(9).getNumericCellValue());
				inner.pstmt.addBatch();
			}
		} finally {
			inner.postExecute();
		}

	}
	private static void executeCompany(Workbook workbook) throws SQLException {
		String sql = "insert into company (company_id,company_name,company_owner,company_tel,company_email,company_public_account)"
				+ "values(?,?,?,?,?,?)";
		Sheet sheet = workbook.getSheet("company");
		Inner inner = new Inner();
		inner.preExecute(sql, workbook);
		Row rows = sheet.getRow(2);
		System.out.println(rows.getCell(3).getStringCellValue());
		try {
			inner.preExecute(sql, workbook);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				inner.pstmt.setInt(1, (int) row.getCell(0).getNumericCellValue());
				inner.pstmt.setString(2, row.getCell(1).getStringCellValue());
				inner.pstmt.setString(3, row.getCell(2).getStringCellValue());
				inner.pstmt.setString(4, row.getCell(3).getStringCellValue());
				inner.pstmt.setString(5, row.getCell(4).getStringCellValue());
				inner.pstmt.setInt(6, (int) row.getCell(5).getNumericCellValue());
				inner.pstmt.addBatch();

			}
		} finally {
			inner.postExecute();
		}

	}

	private static void executeAccount(Workbook workbook) throws SQLException {
		String sql = "insert into account(account_id,account_password,account_company_id)" + "values(?,?,?)";
		Inner inner = new Inner();

		Sheet sheet = workbook.getSheet("account");
		try {
			inner.preExecute(sql, workbook);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				inner.pstmt.setString(1, row.getCell(0).getStringCellValue());
				inner.pstmt.setString(2, row.getCell(1).getStringCellValue());
				inner.pstmt.setInt(3, (int) row.getCell(2).getNumericCellValue());
				inner.pstmt.addBatch();
			}
		} finally {
			inner.postExecute();
		}

	}

	private static void executeCar(Workbook workbook) throws SQLException {
		String sql = "insert into car (car_id,car_number,car_model,car_displacement,car_color,car_company_id,car_image)"
				+ "values (?,?,?,?,?,?,?)";
		Sheet sheet = workbook.getSheet("car");
		Inner inner = new Inner();
		inner.preExecute(sql, workbook);
		Row rows = sheet.getRow(1);
		//System.out.println(Integer.parseInt(rows.getCell(0).getStringCellValue()));
		try {
			inner.preExecute(sql, workbook);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				//int cell0 = Integer.parseInt(row.getCell(0).getStringCellValue());
				inner.pstmt.setString(1, row.getCell(0).getStringCellValue());
				inner.pstmt.setString(2, row.getCell(1).getStringCellValue());
				inner.pstmt.setString(3, row.getCell(2).getStringCellValue());
				inner.pstmt.setString(4, "2.5L");
				inner.pstmt.setString(5, row.getCell(3).getStringCellValue());
				inner.pstmt.setInt(6, (int) row.getCell(4).getNumericCellValue());
				inner.pstmt.setString(7, "");
				inner.pstmt.addBatch();

			}
		} finally {
			inner.postExecute();
		}

	}

	private static void executeFinance(Workbook workbook) throws SQLException {
		String sql = "insert into finance (finance_company_id,finance_amount,finance_status,finance_date,finance_oprator_id)"
				+ "values(?,?,?,?,?)";
		Sheet sheet = workbook.getSheet("finance");
		Inner inner = new Inner();

		try {
			inner.preExecute(sql, workbook);
			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i);
				inner.pstmt.setInt(1, (int) row.getCell(0).getNumericCellValue());
				inner.pstmt.setBigDecimal(2, new BigDecimal(row.getCell(1).getNumericCellValue()));
				inner.pstmt.setString(3, "待确定");
				inner.pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				inner.pstmt.setString(5, "dididalian");
				inner.pstmt.addBatch();
			}
		} finally {
			inner.postExecute();
		}

	}
	

	private static void executeDriver(Workbook workbook) throws SQLException {
		/*
		String sql = "insert into driver (driver_id,driver_number,driver_name,driver_gender,driver_age,driver_image,driver_company_id,driver_bind_car_id,"
				+ "driver_order_quantity,driver_transaction_amount,driver_charging_time,driver_bad_review,driver_score,driver_grade)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Sheet sheet = workbook.getSheet("driver");
		Inner inner = new Inner();
		inner.preExecute(sql, workbook);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			inner.pstmt.setString(1, row.getCell(0).getStringCellValue());
			inner.pstmt.setString(2, row.getCell(1).getStringCellValue());
			inner.pstmt.setString(3, row.getCell(2).getStringCellValue());
			inner.pstmt.setString(4, row.getCell(3).getStringCellValue());
			inner.pstmt.setInt(5, (int) row.getCell(4).getNumericCellValue());
			inner.pstmt.setString(6, "");
			inner.pstmt.setInt(7, (int) row.getCell(6).getNumericCellValue());
			if (row.getCell(7) != null) {
				inner.pstmt.setInt(8, Integer.parseInt(row.getCell(7).getStringCellValue()));
				inner.pstmt.setInt(9, (int) row.getCell(8).getNumericCellValue());
				inner.pstmt.setDouble(10, row.getCell(9).getNumericCellValue());
				inner.pstmt.setDouble(11, row.getCell(10).getNumericCellValue());
				inner.pstmt.setDouble(12, row.getCell(11).getNumericCellValue());
				inner.pstmt.setDouble(13, row.getCell(12).getNumericCellValue());
				inner.pstmt.setString(14, row.getCell(13).getStringCellValue());
				inner.pstmt.addBatch();
			}
		}
		inner.postExecute();
		*/
		
		String sql = "insert into driver (driver_id,driver_number,driver_name,driver_gender,driver_age,driver_image,driver_company_id,driver_bind_car_id)"
				+ "values(?,?,?,?,?,?,?,?)";
		Sheet sheet = workbook.getSheet("driver");
		Inner inner = new Inner();
		inner = new Inner();
		inner.preExecute(sql, workbook);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i);
			inner.pstmt.setString(1, row.getCell(0).getStringCellValue());
			inner.pstmt.setString(2, row.getCell(1).getStringCellValue());
			inner.pstmt.setString(3, row.getCell(2).getStringCellValue());
			inner.pstmt.setString(4, row.getCell(3).getStringCellValue());
			inner.pstmt.setInt(5, (int) row.getCell(4).getNumericCellValue());
			inner.pstmt.setString(6, "");
			inner.pstmt.setInt(7, (int) row.getCell(6).getNumericCellValue());
			
			if (row.getCell(7) != null) {
				inner.pstmt.setString(8, row.getCell(7).getStringCellValue());
			}
			inner.pstmt.addBatch();
		}
		inner.postExecute();

	}
}
