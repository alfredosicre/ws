package com.cursogetafe.dixml;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test04 {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		
//		Properties prop = new Properties();
//		prop.load(new FileReader("src/main/resources/app.properties"));
//		
//		BasicDataSource bds = new BasicDataSource();
//		bds.setUrl(prop.getProperty("bbdd.url"));
//		bds.setDriverClassName(prop.getProperty("bbdd.driver"));
//		bds.setUsername(prop.getProperty("bbdd.user"));
//		bds.setPassword(prop.getProperty("bbdd.pass"));

		BeanFactory ctx = new ClassPathXmlApplicationContext("a04_ctx.xml");
		
		DataSource ds = ctx.getBean("dataSource", DataSource.class);

		
		
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from productos");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			System.out.println(rs.getInt(1) + ": " + rs.getString(2));
		}
		
		con.close();
	}
}
