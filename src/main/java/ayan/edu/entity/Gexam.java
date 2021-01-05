package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gexam")
public class Gexam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "sname")
	private String sname;

	@Column(name = "ename")
	private String ename;

	public Gexam() {

	}

	public Gexam(int id, String sname, String ename) {

		this.id = id;
		this.sname = sname;
		this.ename = ename;
	}

	public Gexam(String sname, String ename) {

		this.sname = sname;
		this.ename = ename;
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

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Gexam [id=" + id + ", sname=" + sname + ", ename=" + ename + "]";
	}

}
