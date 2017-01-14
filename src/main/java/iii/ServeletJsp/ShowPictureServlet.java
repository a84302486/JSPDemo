package iii.ServeletJsp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowPicturePicture
 */
@WebServlet("/showPicture.do")
public class ShowPictureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] sa ={"s1.jpg","s2.jpg","s3.jpg","s4.jpg","s5.jpg",
			"s6.jpg","s7.jpg","s9.jpg","s10.jpg"};
	
	List<String> list = new Vector<String>(Arrays.asList(sa));
	
	synchronized protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(list.size()==0){
			list = new Vector<String>(Arrays.asList(sa));
		}
		
		int idx = (int)(Math.random()*list.size());
		String filename = list.get(idx);
		list.remove(idx);
		
		ServletContext context = getServletContext();
		String mimeType = context.getMimeType(filename);
		response.setContentType(mimeType);
		String path = "/images/" + filename;
		try(
			InputStream is = context.getResourceAsStream(path);
			OutputStream os = response.getOutputStream();
			){
			byte[] b = new byte[8192];
			int len = 0;
			while((len = is.read(b) )!=-1){
				os.write(b, 0 , len);
			}
		}
	}
}
