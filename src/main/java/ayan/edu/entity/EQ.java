package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eq")
public class EQ {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "eid")
	private int eid;

	@Column(name = "qid")
	private int qid;

	public EQ() {

	}

	public EQ(int eid, int qid) {

		this.eid = eid;
		this.qid = qid;
	}

	public EQ(int id, int eid, int qid) {

		this.id = id;
		this.eid = eid;
		this.qid = qid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	@Override
	public String toString() {
		return "EQ [id=" + id + ", eid=" + eid + ", qid=" + qid + "]";
	}

}
