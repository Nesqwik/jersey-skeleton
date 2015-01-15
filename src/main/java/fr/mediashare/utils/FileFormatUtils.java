package fr.mediashare.utils;

import java.util.ArrayList;

public class FileFormatUtils {


	private static ArrayList<String> audio = new ArrayList<>();
	private static ArrayList<String> image= new ArrayList<>();
	private static ArrayList<String> video = new ArrayList<>();

	static {
		audio.add("mp3");
		audio.add("wav");
		audio.add("flac");
		audio.add("ogg");
		audio.add("wma");

		image.add("jpg");
		image.add("jpeg");
		image.add("bmp");
		image.add("gif");
		image.add("png");

		//video.add("3gp");
		video.add("mp4");
		//video.add("avi");
	}
	
	public static boolean isAudioFile(String file) {
		String[] ext = file.split("\\.");
		return audio.contains(ext[ext.length - 1]);
	}
	
	public static boolean isVideoFile(String file) {
		String[] ext = file.split("\\.");
		return video.contains(ext[ext.length - 1]);
	}
	
	public static boolean isPdfFile(String file) {
		String[] ext = file.split("\\.");
		return ext[ext.length - 1].equals("pdf");
	}
	
	public static boolean isImageFile(String file) {
		String[] ext = file.split("\\.");
		return image.contains(ext[ext.length - 1]);
	}
	
	public static String getUniqFileName(String fileName) {
		return System.currentTimeMillis() + "_" + fileName;
	}

	public static String getFormatOf(String fileName) {
		if(isAudioFile(fileName))
			return "audio";
		if(isVideoFile(fileName))
			return "video";
		if(isImageFile(fileName))
			return "image";
		if(isPdfFile(fileName))
			return "pdf";
		
		return "autre";
	}
}
