package fr.iutinfo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class DownloadTest {

	@Test
	public void test() throws IOException {
		assertTrue(Download.download("http://loacalhost:8080"));
	}

}
