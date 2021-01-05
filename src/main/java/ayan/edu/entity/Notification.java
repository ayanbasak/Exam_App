package ayan.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "notification")
public class Notification {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "noti")
	private String noti;

	@Column(name = "date")
	private String date;

	public Notification() {

	}

	public Notification(int id, String noti, String date) {

		this.id = id;
		this.noti = noti;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoti() {
		return noti;
	}

	public void setNoti(String noti) {
		this.noti = noti;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", noti=" + noti + ", date=" + date + "]";
	}

}
