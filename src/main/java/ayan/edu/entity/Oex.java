package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "onlineex")
public class Oex {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private int oid;

	@Column(name = "subject")
	private String subject;

	@Column(name = "exname")
	private String exname;

	@Column(name = "stid")
	private int stid;

	@Column(name = "enid")
	private int enid;

	public Oex() {

	}

	public Oex(int oid, String subject, String exname, int stid, int enid) {

		this.oid = oid;
		this.subject = subject;
		this.exname = exname;
		this.stid = stid;
		this.enid = enid;
	}

	public Oex(String subject, String exname, int stid, int enid) {

		this.subject = subject;
		this.exname = exname;
		this.stid = stid;
		this.enid = enid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getExname() {
		return exname;
	}

	public void setExname(String exname) {
		this.exname = exname;
	}

	public int getStid() {
		return stid;
	}

	public void setStid(int stid) {
		this.stid = stid;
	}

	public int getEnid() {
		return enid;
	}

	public void setEnid(int enid) {
		this.enid = enid;
	}

	@Override
	public String toString() {
		return "Oex [oid=" + oid + ", subject=" + subject + ", exname=" + exname + ", stid=" + stid + ", enid=" + enid
				+ "]";
	}

}
