package pe.autonoma.app.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import pe.autonoma.app.entity.Persona;

public class PersonaModel {
	public List<Persona> listPersonas(DataSource dataSource) {
		// Step 1: Initialize connection objects
		List<Persona> listPersonas = new ArrayList<>(); 
        Connection connect = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
			connect = dataSource.getConnection();
			
			// Step 2: Create a SQL statements string
			String query = "Select * from personas";
			stmt = connect.createStatement();

			// Step 3: Execute SQL query
			rs = stmt.executeQuery(query);
         
			// Step 4: Process the result set
			while(rs.next()){
				listPersonas.add(new Persona(rs.getInt("persona_id"), 
											rs.getString("nombres"),
											rs.getString("apellidos"),
											rs.getInt("edad"),
											rs.getString("hobbies")));
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return listPersonas;
	}

}
