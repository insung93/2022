package com.bit.sts10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	String upPath = "C:/dev/framework/sts10/src/upload/";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String upload(MultipartFile file, HttpServletRequest req) throws IllegalStateException, IOException {
		String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
//		System.out.println(file.getOriginalFilename());

		file.transferTo(new File(upPath + filename));
		req.setAttribute("origin", file.getOriginalFilename());
		req.setAttribute("filename", filename);

		return "down";
	}
	
	//<a href="down?file=${filename }"
	@RequestMapping(value = "/down", method = RequestMethod.GET)
	public void down1(HttpServletResponse res, @RequestParam("file") String filename) {
		File file = new File(upPath + filename);
		try (OutputStream os = res.getOutputStream(); InputStream is = new FileInputStream(file);) {
			while (true) {
				int su = is.read();
				if (su == -1)
					break;
				os.write(su);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
