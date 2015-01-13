package fr.mediashare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Download {
	public static boolean download(String lien) throws IOException{
		InputStream input = null;
        FileOutputStream writeFile = null;
		try{
			URL url = new URL(lien);
			URLConnection connection = url.openConnection();
            int fileLength = connection.getContentLength();
            if (fileLength == -1)
            {
                System.out.println("Invalide URL or file.");
                return false;
            }
            input = connection.getInputStream();
            String fileName = url.getFile().substring(url.getFile().lastIndexOf('/') + 1);
            writeFile = new FileOutputStream("C:/Downloads/"+fileName);
            byte[] buffer = new byte[1024];
            int read;
            while ((read = input.read(buffer)) > 0)
                writeFile.write(buffer, 0, read);
            writeFile.flush();
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			try
            {
                writeFile.close();
                input.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
		}
		return true;
	}
}
