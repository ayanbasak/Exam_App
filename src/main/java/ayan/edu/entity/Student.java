package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private int sid;

	@Column(name = "sname")
	private String sname;

	@Column(name = "subi")
	private String subi;

	@Column(name = "subii")
	private String subii;

	@Column(name = "subiii")
	private String subiii;

	@Column(name = "subiv")
	private String subiv;

	@Column(name = "subv")
	private String subv;

	@Column(name = "subvi")
	private String subvi;

	@Column(name = "subvii")
	private String subvii;

	@Column(name = "subviii")
	private String subviii;

	@Column(name = "email")
	private String email;

	@Column(name = "dob")
	private String dob;

	@Column(name = "class")
	private String cls;

	@Column(name = "mlang")
	private String mlang;

	@Column(name = "cno")
	private int cno;

	public Student() {

	}

	public Student(int sid, String sname, String subi, String subii, String subiii, String subiv, String subv,
			String subvi, String subvii, String subviii, String email, String dob, String cls, String mlang,
			int cno) {

		this.sid = sid;
		this.sname = sname;
		this.subi = subi;
		this.subii = subii;
		this.subiii = subiii;
		this.subiv = subiv;
		this.subv = subv;
		this.subvi = subvi;
		this.subvii = subvii;
		this.subviii = subviii;
		this.email = email;
		this.dob = dob;
		this.cls = cls;
		this.mlang = mlang;
		this.cno = cno;
	}

	public Student(String sname, String subi, String subii, String subiii, String subiv, String subv, String subvi,
			String subvii, String subviii, String email, String dob, String cls, String mlang, int cno) {

		this.sname = sname;
		this.subi = subi;
		this.subii = subii;
		this.subiii = subiii;
		this.subiv = subiv;
		this.subv = subv;
		this.subvi = subvi;
		this.subvii = subvii;
		this.subviii = subviii;
		this.email = email;
		this.dob = dob;
		this.cls = cls;
		this.mlang = mlang;
		this.cno = cno;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSubi() {
		return subi;
	}

	public void setSubi(String subi) {
		this.subi = subi;
	}

	public String getSubii() {
		return subii;
	}

	public void setSubii(String subii) {
		this.subii = subii;
	}

	public String getSubiii() {
		return subiii;
	}

	public void setSubiii(String subiii) {
		this.subiii = subiii;
	}

	public String getSubiv() {
		return subiv;
	}

	public void setSubiv(String subiv) {
		this.subiv = subiv;
	}

	public String getSubv() {
		return subv;
	}

	public void setSubv(String subv) {
		this.subv = subv;
	}

	public String getSubvi() {
		return subvi;
	}

	public void setSubvi(String subvi) {
		this.subvi = subvi;
	}

	public String getSubvii() {
		return subvii;
	}

	public void setSubvii(String subvii) {
		this.subvii = subvii;
	}

	public String getSubviii() {
		return subviii;
	}

	public void setSubviii(String subviii) {
		this.subviii = subviii;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCls() {
		return cls;
	}

	public void setCls(String cls) {
		this.cls = cls;
	}

	public String getMlang() {
		return mlang;
	}

	public void setMlang(String mlang) {
		this.mlang = mlang;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", subi=" + subi + ", subii=" + subii + ", subiii=" + subiii
				+ ", subiv=" + subiv + ", subv=" + subv + ", subvi=" + subvi + ", subvii=" + subvii + ", subviii="
				+ subviii + ", email=" + email + ", dob=" + dob + ", cls=" + cls + ", mlang=" + mlang + ", cno=" + cno
				+ "]";
	}

}
