package fr.mediashare;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.*;


import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;

import uk.co.caprica.vlcj.player.MediaDetails;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.TrackDescription;



public class MetaData {
	
	public static void choixLecteur(File f) throws IOException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
		String[] tab=f.getAbsolutePath().split("\\.");
		System.out.println(f.getAbsolutePath());
		
		
		ArrayList<String> audio = new ArrayList<>();
		audio.add("mp3");
		audio.add("wav");
		audio.add("flac");
		audio.add("ogg");
		audio.add("wma");
		
		ArrayList<String> image= new ArrayList<>();
		image.add("jpg");
		image.add("jpeg");
		image.add("bmp");
		image.add("gif");
		image.add("png");
		
		ArrayList<String> video = new ArrayList<>();
		video.add("3gp");
		video.add("mp4");
		video.add("avi");
		
		if(audio.contains(tab[tab.length-1]))
			lireMetaAudio(f);
		
		else if(image.contains(tab[tab.length-1]))
			System.out.println("redirection");
		
		else if(tab[tab.length-1].equals("pdf"))
			System.out.println("todo");
		
		else if(tab[tab.length-1].equals("txt"))
			lireMetaTxt(f);
		
		else if(video.contains(tab[tab.length-1]))
			System.out.println("redirection");
	}
	
	public static ArrayList<String> lireMetaAudio(File f) throws  IOException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
		
		ArrayList<String> array = new ArrayList<>();
		
		
		AudioFile test = AudioFileIO.read(f);
		if(test.getTag().getFirst(FieldKey.ARTIST).isEmpty()){
			array.add(test.getTag().getFirst(FieldKey.ARTIST));
			System.out.println("pas d'artiste");}
		else{
			array.add(test.getTag().getFirst(FieldKey.ARTIST));
		System.out.println(test.getTag().getFirst(FieldKey.ARTIST));}
		
		if(test.getTag().getFirst(FieldKey.ALBUM).isEmpty()){
			array.add(test.getTag().getFirst(FieldKey.ALBUM));
			System.out.println("pas d'album");}
		else{
			array.add(test.getTag().getFirst(FieldKey.ALBUM));
		System.out.println(test.getTag().getFirst(FieldKey.ALBUM));}
		
		if(test.getTag().getFirst(FieldKey.YEAR).isEmpty()){
			array.add(test.getTag().getFirst(FieldKey.YEAR));
			System.out.println("pas d'annee");}
		else{
			array.add(test.getTag().getFirst(FieldKey.YEAR));
		System.out.println(test.getTag().getFirst(FieldKey.YEAR));}
		
		if(test.getTag().getFirst(FieldKey.GENRE).isEmpty()){
			array.add(test.getTag().getFirst(FieldKey.GENRE));
			System.out.println("pas de genre");}
		else{
			array.add(test.getTag().getFirst(FieldKey.GENRE));
		System.out.println(test.getTag().getFirst(FieldKey.GENRE));}
		return array;

		
	}
	
	
	
	public static  long  lireMetaTxt(File f){
		return f.length();
		
	}
	
	
	public static void main(String[] args) throws IOException, CannotReadException, TagException, ReadOnlyFileException, InvalidAudioFrameException{
		MetaData test = new MetaData();
		
		test.lireMetaAudio(new File("/tmp/bulteela/workspace/mediashare/00014.mp3"));
		
		
		test.choixLecteur(new File("/home/infoetu/bulteela/Téléchargements/travail.jpg"));
		test.choixLecteur(new File("/home/infoetu/bulteela/group.txt"));
		test.choixLecteur(new File("/home/infoetu/bulteela/Téléchargements/azert.3gp"));
	}

}
