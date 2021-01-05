package ayan.edu.entity;

public class Answer {

	private String gans;

	public Answer() {

	}

	public Answer(String gans) {

		this.gans = gans;
	}

	public String getGans() {
		return gans;
	}

	public void setGans(String gans) {
		this.gans = gans;
	}

	@Override
	public String toString() {
		return "Answer [gans=" + gans + "]";
	}

}
