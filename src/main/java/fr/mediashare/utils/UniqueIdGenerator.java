package fr.mediashare.utils;


public class UniqueIdGenerator {

	public static int currentId = 0;
	
	public static int getUniqueId() {
		return currentId++;
	}
}
