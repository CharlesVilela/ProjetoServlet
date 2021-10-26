package br.upe.pIII;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(displayName = "/RoboHash")
public class RoboHash extends HttpServlet {

	RoboHashModel roboHash = new RoboHashModel();
	RoboHashService service = new RoboHashService();
	RoboHashReposytory roboRepository = RoboHashReposytory.getRepository();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		String nome = roboRepository.Select(id); 
		
		if (nome != null) {
			
			InputStream avatar = service.GerarAvatar(nome);
			resp.setContentType("image/png");
			OutputStream os = resp.getOutputStream();

			byte[] b = new byte[2048];
			int length;

			while ((length = avatar.read(b)) != -1) {
				os.write(b, 0, length);
			}

			resp.setContentLength(length);
			byte[] buffer = new byte[10240];

			try (InputStream input = avatar; OutputStream output = os;) {
				for (int length2 = 0; (length = input.read(buffer)) > 0;) {
					output.write(buffer, 0, length2);
				}
			} 
		} else {
			resp.setHeader("Content-Type", "application/json; charset=utf-8;");
			resp.getWriter().write("O ID não existe!");
			
		}
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		resp.setContentType("application/json");
		int id = roboRepository.Insert(nome);
		resp.getOutputStream().print("{ \"nome\": \"" + nome + "\", \"id\": \"" + id + "\" }");

	}

}
