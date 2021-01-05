package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "eid")
	private int eid;

	@Column(name = "sid")
	private int sid;

	@Column(name = "ename")
	private String ename;

	@Column(name = "score")
	private int score;

	@Column(name = "tmarks")
	private int tmarks;

	@Column(name = "ehr")
	private float ehr;

	@Column(name = "qmodel")
	private String qmodel;

	public Exam() {

	}

	public Exam(int eid, int sid, String ename, int score, int tmarks, float ehr, String qmodel) {

		this.eid = eid;
		this.sid = sid;
		this.ename = ename;
		this.score = score;
		this.tmarks = tmarks;
		this.ehr = ehr;
		this.qmodel = qmodel;
	}

	public Exam(int sid, String ename, int score, int tmarks, float ehr, String qmodel) {

		this.sid = sid;
		this.ename = ename;
		this.score = score;
		this.tmarks = tmarks;
		this.ehr = ehr;
		this.qmodel = qmodel;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTmarks() {
		return tmarks;
	}

	public void setTmarks(int tmarks) {
		this.tmarks = tmarks;
	}

	public float getEhr() {
		return ehr;
	}

	public void setEhr(float ehr) {
		this.ehr = ehr;
	}

	public String getQmodel() {
		return qmodel;
	}

	public void setQmodel(String qmodel) {
		this.qmodel = qmodel;
	}

	@Override
	public String toString() {
		return "Exam [eid=" + eid + ", sid=" + sid + ", ename=" + ename + ", score=" + score + ", tmarks=" + tmarks
				+ ", ehr=" + ehr + ", qmodel=" + qmodel + "]";
	}

}
