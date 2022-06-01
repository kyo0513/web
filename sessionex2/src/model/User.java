
package model;

import java.io.Serializable;

public class User implements Serializable{

	private String meil,name,query;

	public User() {
		super();
	}

	public User(String meil, String name, String query) {
		super();
		this.meil = meil;
		this.name = name;
		this.query = query;
	}

	public String getMeil() {
		return meil;
	}

	public String getName() {
		return name;
	}

	public String getQuery() {
		return query;
	}



}