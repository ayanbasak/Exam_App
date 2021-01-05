package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sname")
	private String sname;

	@Column(name = "ns")
	private int ns;

	public Subject() {

	}

	public Subject(int id, String sname, int ns) {
	
		this.id = id;
		this.sname = sname;
		this.ns = ns;
	}

	public Subject(String sname, int ns) {
		
		this.sname = sname;
		this.ns = ns;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getNs() {
		return ns;
	}

	public void setNs(int ns) {
		this.ns = ns;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", sname=" + sname + ", ns=" + ns + "]";
	}

}
