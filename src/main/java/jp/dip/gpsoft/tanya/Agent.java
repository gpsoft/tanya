package jp.dip.gpsoft.tanya;

public class Agent {

	private String name;

	public Agent(String name) {
		this.name = name;
	}

	public void help() {
		System.out.println(name + ": Done!!");
	}
}
