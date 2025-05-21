package com.knf.dev.librarymanagementsystem.constant;

import java.util.Arrays;
import java.util.Optional;

public enum Item {


	private final String name;
	private final String fileName;

	Item(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public String getFileName() {
		return fileName;
	}

	public static Optional<Item> getItemByValue(String value) {
		return Arrays.stream(Item.values())
				.filter(accStatus -> accStatus.name.equals(value) || accStatus.fileName.equals(value)).findFirst();
	}
}
