package com.edsonwisses.Teste;

public class VirtualFile {
	private String name;
	private String content;

	public VirtualFile(String name, String content) {
		this.name = name;
		this.content = content;
	}

	// Getters e Setters
	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
