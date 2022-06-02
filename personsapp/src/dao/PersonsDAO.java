package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Persons;


public class PersonsDAO {
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	private void connect() throws NamingException,SQLException {
		Context context =new InitialContext();         //アプリの情報取得?コンテキスト情報を見ている
		DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
		this.db = ds.getConnection();
	}

	private void disconnect() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (db != null) {
				db.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Persons> findAll(){
		List<Persons> list = new ArrayList<>();
		try {
			this.connect();
			ps = db.prepareStatement("SELECT * FROM persons");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Persons persons = new Persons(id,name,age);
				list.add(persons);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return list;
	}

	public void insertOne(Persons persons) {
		try {
			this.connect();
			ps=db.prepareStatement
					("INSERT INTO persons(name,age)VALUES(?,?)");
			ps.setString(1,persons.getName());
			ps.setInt(2,persons.getAge());
			ps.execute();
			System.out.println(ps);

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public Persons findOne(int id) {
		Persons persons =null;
		try {
			this.connect();
			ps=db.prepareStatement("SELECT * FROM persons WHERE id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			if(rs.next()) {
				String name =rs.getString("name");
				int age     =rs.getInt("age");
				persons=new Persons(id,name,age);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
		return persons;
	}

	public void updateOne(Persons persons) {
		try {
			this.connect();
			ps=db.prepareStatement("UPDATE persons SET name=?,age=? WHERE id=?");
			ps.setString(1,persons.getName());
			ps.setInt(2,persons.getAge());
			ps.setInt(3,persons.getId());
			ps.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}

	public void deleteOne(int id) {
		try {
			this.connect();
			ps=db.prepareStatement("DELETE FROM persons WHERE id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			this.disconnect();
		}
	}
}
