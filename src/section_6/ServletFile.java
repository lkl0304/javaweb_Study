package section_6;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class ServletFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter w = resp.getWriter();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");
		
		try {
			List<FileItem> items = upload.parseRequest(req);
			for (FileItem fileItem : items) {
				if (fileItem.isFormField()) {
					w.print(fileItem.getFieldName() + " 上传者: " + fileItem.getString());
				} else {
					String name = fileItem.getName(); // 文件路径名
					w.print("<br>文件所在路径: " + name);
					name = name.substring(name.lastIndexOf(File.separator) + 1);
					w.print("<br>文件名: " + name);
					
					String filepath = getServletContext().getRealPath(File.separator + "upload" + File.separator + UUID.randomUUID() + "_" + name);
					System.out.println(filepath);
					
					File file = new File(filepath); // 根据文件路径创建文件
					if (!file.getParentFile().exists()) {
						file.getParentFile().mkdirs();
					}
					file.createNewFile(); // 创建用于接收的空文件
					
					InputStream in = fileItem.getInputStream();
					OutputStream out = new FileOutputStream(file);
					int len = 0;
					byte[] b = new byte[1024];
					while ((len = in.read(b)) != -1) {
						out.write(b, 0, len);
					}
					out.flush();
					out.close();
					in.close();
					fileItem.delete();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
