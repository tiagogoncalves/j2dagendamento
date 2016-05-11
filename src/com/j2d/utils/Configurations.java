package com.j2d.utils;

public class Configurations {

	private int windowWidth,windowHeigh,numRegistros;
	private boolean searchByKeypress=false;

	public int getWindowWidth() {
		return windowWidth;
	}

	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}

	public int getWindowHeigh() {
		return windowHeigh;
	}

	public void setWindowHeigh(int windowHeigh) {
		this.windowHeigh = windowHeigh;
	}

	public int getNumRegistros() {
		return numRegistros;
	}

	public void setNumRegistros(int numRegistros) {
		this.numRegistros = numRegistros;
	}

	public void setSearchByKeypress(boolean searchByKeypress) {
		this.searchByKeypress = searchByKeypress;
	}

	public boolean isSearchByKeypress() {
		return searchByKeypress;
	}
	
	
	
}
