package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "qid")
	private int qid;

	@Column(name = "qmodel")
	private String qmodel;

	@Column(name = "opi")
	private String opi;

	@Column(name = "opii")
	private String opii;

	@Column(name = "opiii")
	private String opiii;

	@Column(name = "opiv")
	private String opiv;

	@Column(name = "ans")
	private String ans;

	@Column(name = "rating")
	private int rating;

	@Column(name = "subject")
	private String subject;

	@Column(name = "question")
	private String qus;

	@Column(name = "qmark")
	private int qmark;

	private String rans;

	public Question() {

	}

	public Question(String qmodel, String opi, String opii, String opiii, String opiv, String ans, int rating,
			String subject, String qus, int qmark, String rans) {

		this.qmodel = qmodel;
		this.opi = opi;
		this.opii = opii;
		this.opiii = opiii;
		this.opiv = opiv;
		this.ans = ans;
		this.rating = rating;
		this.subject = subject;
		this.qus = qus;
		this.qmark = qmark;
		this.rans = rans;
	}

	public Question(int qid, String qmodel, String opi, String opii, String opiii, String opiv, String ans, int rating,
			String subject, String qus, int qmark, String rans) {

		this.qid = qid;
		this.qmodel = qmodel;
		this.opi = opi;
		this.opii = opii;
		this.opiii = opiii;
		this.opiv = opiv;
		this.ans = ans;
		this.rating = rating;
		this.subject = subject;
		this.qus = qus;
		this.qmark = qmark;
		this.rans = rans;
	}

	public Question(int qid, String qmodel, String opi, String opii, String opiii, String opiv, String ans, int rating,
			String subject, String qus, int qmark) {

		this.qid = qid;
		this.qmodel = qmodel;
		this.opi = opi;
		this.opii = opii;
		this.opiii = opiii;
		this.opiv = opiv;
		this.ans = ans;
		this.rating = rating;
		this.subject = subject;
		this.qus = qus;
		this.qmark = qmark;
	}

	public Question(String qmodel, String opi, String opii, String opiii, String opiv, String ans, int rating,
			String subject, String qus, int qmark) {

		this.qmodel = qmodel;
		this.opi = opi;
		this.opii = opii;
		this.opiii = opiii;
		this.opiv = opiv;
		this.ans = ans;
		this.rating = rating;
		this.subject = subject;
		this.qus = qus;
		this.qmark = qmark;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQmodel() {
		return qmodel;
	}

	public void setQmodel(String qmodel) {
		this.qmodel = qmodel;
	}

	public String getOpi() {
		return opi;
	}

	public void setOpi(String opi) {
		this.opi = opi;
	}

	public String getOpii() {
		return opii;
	}

	public void setOpii(String opii) {
		this.opii = opii;
	}

	public String getOpiii() {
		return opiii;
	}

	public void setOpiii(String opiii) {
		this.opiii = opiii;
	}

	public String getOpiv() {
		return opiv;
	}

	public void setOpiv(String opiv) {
		this.opiv = opiv;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getQus() {
		return qus;
	}

	public void setQus(String qus) {
		this.qus = qus;
	}

	public int getQmark() {
		return qmark;
	}

	public void setQmark(int qmark) {
		this.qmark = qmark;
	}

	public String getRans() {
		return rans;
	}

	public void setRans(String rans) {
		this.rans = rans;
	}

	@Override
	public String toString() {
		return "Question [qid=" + qid + ", qmodel=" + qmodel + ", opi=" + opi + ", opii=" + opii + ", opiii=" + opiii
				+ ", opiv=" + opiv + ", ans=" + ans + ", rating=" + rating + ", subject=" + subject + ", qus=" + qus
				+ ", qmark=" + qmark + "]";
	}

}
