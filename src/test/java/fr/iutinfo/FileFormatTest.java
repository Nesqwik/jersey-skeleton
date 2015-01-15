package fr.iutinfo;


import org.junit.Test;
import static org.junit.Assert.*;

import fr.mediashare.utils.FileFormatUtils;

public class FileFormatTest {

	
	@Test
	public void testAudioFormat() {
		assertTrue(FileFormatUtils.isAudioFile("toto.mp3"));
		assertTrue(FileFormatUtils.isAudioFile("toto.ogg"));
		assertFalse(FileFormatUtils.isAudioFile("toto.toto"));
		assertFalse(FileFormatUtils.isAudioFile("titi.mp4"));
	}
	
	@Test
	public void testVideoFormat() {
		assertTrue(FileFormatUtils.isVideoFile("toto.mp4"));
		assertFalse(FileFormatUtils.isVideoFile("toto.toto"));
	}
	
	@Test
	public void testImageFormat() {
		assertTrue(FileFormatUtils.isImageFile("toto.png"));
		assertTrue(FileFormatUtils.isImageFile("toto.jpg"));
		assertTrue(FileFormatUtils.isImageFile("toto.gif"));
		assertTrue(FileFormatUtils.isImageFile("toto.png"));
		assertFalse(FileFormatUtils.isImageFile("toto.toto"));
	}
}
