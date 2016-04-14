package com.lichking.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lichking.logicalprocessor.MenuProcessor;
import com.lichking.util.DateFormatUtil;
import com.lichking.util.FileUtil;

/**
 * 这是测试controller
 * @author LichKing
 */

@Controller
@RequestMapping("/test")
public class TestController {

	
	@RequestMapping(value = "testupload", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String uploadFile(@RequestParam("pic") CommonsMultipartFile pic,
			HttpServletRequest req, HttpServletResponse response)
			throws IOException {
		//log.info("进入/test/testupload");
		System.out.println("进入/test/testupload");
		// 设置文件保存的本地路径
		String filePath = req.getSession().getServletContext()
				.getRealPath("/upload/image");
		String fileName = pic.getOriginalFilename();
		String fileType = fileName.split("[.]")[1];
		// 为了避免文件名重复，在文件名前加UUID
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String uuidFileName = uuid + fileName;
		@SuppressWarnings("unused")
		File f = new File(filePath + "/" + uuid + "." + fileType);
		// 将文件保存到服务器
		FileUtil.upFile(pic.getInputStream(), uuidFileName, filePath);
		return uuidFileName;
	}
	
	@RequestMapping("/upload")
	public String vUpload(){
		//log.info("访问upload");
		System.out.println("访问upload");
		return "test/testupload";
	}
	@RequestMapping("/testck")
	public String vTestCK(){
		//log.info("访问upload");
		//System.out.println("访问upload");
		return "test/testck";
	}
	
	@RequestMapping("/createmenu")
	public String vCreateMenu(){
		MenuProcessor.doMenuProcess();
		return "test/test";
	}
	
	@RequestMapping("/test")
	public String vTest(){
		String dt = DateFormatUtil.getDateTime();
		System.out.println(dt);
		return "test/test";
	}
	
}
