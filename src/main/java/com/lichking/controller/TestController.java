package com.lichking.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.lichking.itf.service.IOrderInfoService;
import com.lichking.logicalprocessor.MenuProcessor;
import com.lichking.pojo.web.OrderInfoVO;
import com.lichking.util.DateUtil;
import com.lichking.util.FileUtil;

/**
 * 这是测试controller
 * @author LichKing
 */

@Controller
@RequestMapping("/test")
public class TestController {

	Logger log = Logger.getLogger(TestController.class);
	
	@Resource
	private IOrderInfoService orderInfoService;
	
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
		log.info("createmenu");
		MenuProcessor.doMenuProcess();
		return "test/test";
	}
	
	@RequestMapping("/test")
	public String vTest(){
		System.out.println("现在："+DateUtil.getDateTime(new Date()));
		System.out.println("今天0点："+DateUtil.getDateTime(DateUtil.getTodayZero()));
		System.out.println("明天0点："+DateUtil.getDateTime(DateUtil.getTomorrowZero()));
		System.out.println("本周第一天0点："+DateUtil.getDateTime(DateUtil.getThisWeekZero()));
		System.out.println("上周第一天0点："+DateUtil.getDateTime(DateUtil.getLastWeekZero()));
		HashMap<String,Date> map = new HashMap<String,Date>();
		map.put("before", DateUtil.getLastWeekZero());
		map.put("after", DateUtil.getThisWeekZero());
		List<OrderInfoVO> oivo_list = this.orderInfoService.selectByDate(map);
		for(OrderInfoVO oivo : oivo_list){
			System.out.println(oivo.getValue()+" "+oivo.getDealtime());
		} 
		return "test/test";
	}
	
}
