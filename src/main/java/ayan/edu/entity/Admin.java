package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aid")
	private int aid;
	
	@Column(name="aname")
	private String aname;
	
	@Column(name="link")
	private int link;
	
	@Column(name="subc")
	private String subc;
	
	@Column(name="qmc")
	private String qmc;

	public Admin() {
		
	}

	public Admin(int aid, String aname, int link, String subc, String qmc) {
		
		this.aid = aid;
		this.aname = aname;
		this.link = link;
		this.subc = subc;
		this.qmc = qmc;
	}

	public Admin(String aname, int link, String subc, String qmc) {
		
		this.aname = aname;
		this.link = link;
		this.subc = subc;
		this.qmc = qmc;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public int getLink() {
		return link;
	}

	public void setLink(int link) {
		this.link = link;
	}

	public String getSubc() {
		return subc;
	}

	public void setSubc(String subc) {
		this.subc = subc;
	}

	public String getQmc() {
		return qmc;
	}

	public void setQmc(String qmc) {
		this.qmc = qmc;
	}

	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", aname=" + aname + ", link=" + link + ", subc=" + subc + ", qmc=" + qmc + "]";
	}
}
