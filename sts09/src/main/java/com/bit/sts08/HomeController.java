package com.bit.sts08;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest req, Model model) throws IOException {
		String uploadPath = req.getRealPath("/resources/upload");
		System.out.println("call Upload" + uploadPath);
//		Iterator<String> ite = req.getFileNames();
//		while (ite.hasNext()) {
//			System.out.println(ite.next());
//			
//		}
		MultipartFile mfile = req.getFile("file");
		String origin = mfile.getOriginalFilename();
		System.out.println(origin);
		
		InputStream is = mfile.getInputStream();
		
//		File file = new File("C:\\dev\\framework\\sts09\\src\\main\\webapp\\resources\\upload\\" + origin);
		File file = new File(uploadPath + "/" + origin);
		OutputStream os = new FileOutputStream(file);
		
		while(true) {
			int su = is.read();
			if(su==-1) break;
			os.write(su);
		}
		model.addAttribute("filename", origin);
		return "down";
	}

}
