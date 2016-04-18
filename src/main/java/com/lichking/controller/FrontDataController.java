package com.lichking.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.ICustomerInfoService;
import com.lichking.pojo.web.CustomerInfoVO;
import com.lichking.pojo.web.ResultVO;
import com.lichking.pojo.web.co.AddressListVO;


@Controller
@RequestMapping("/front/data")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class FrontDataController {

	@Resource
	private ICustomerInfoService customerInfoService;
	
	private Logger logger = Logger.getLogger(FrontDataController.class);
	
	/**
	 * 获取当前用户的信息  手机号码  收货地址
	 * @param civo
	 * @return
	 */
	@RequestMapping(value="/getCustomerInfo",method=RequestMethod.GET)
	public @ResponseBody ResultVO vgetAddressInfo(HttpServletRequest req){
		logger.info("请求json数据：/front/data/getCustomerInfo");
		
		String appid = (String)req.getSession().getAttribute("openid");
		ResultVO result = new ResultVO();
		if(appid == null || appid == "" || appid.equals("")){
			result.setResult(false);
			result.setMsg("未能获取到appid");
			return result;
		}
		CustomerInfoVO new_civo = new CustomerInfoVO();
		new_civo.setAppid(appid);
		
		List<CustomerInfoVO> civo_list = this.customerInfoService.selectByWhere(new_civo);
		
		if(civo_list.size() == 0){
			result.setResult(false);
			result.setMsg("0");
		}else if(civo_list.size() == 1){
			result.setResult(true);
			result.setT(civo_list.get(0));
		}else{
			result.setResult(false);
			result.setMsg("1");
		}
		
		return result;
		
	}
	
	/**
	 * 新增收货地址
	 * @param address
	 * @param req
	 * @return
	 */
	@RequestMapping(value="addAddress",method=RequestMethod.POST)
	public @ResponseBody ResultVO vaddAddress(@RequestBody String address,HttpServletRequest req){
		logger.info("/front/data/addAddress");
		ResultVO result = new ResultVO();
		//logger.info("address:"+address);
		String openid = (String)req.getSession().getAttribute("openid");
		CustomerInfoVO civo = new CustomerInfoVO();
		civo.setAppid(openid);
		List<CustomerInfoVO> civo_list = this.customerInfoService.selectByWhere(civo);
		//之前有数据
		if(civo_list.size() == 1){
			civo = civo_list.get(0);
			String jsonaddress = civo.getAddress();
			JSONObject jsonObject = JSONObject.fromObject(jsonaddress);
			AddressListVO alvo = (AddressListVO)JSONObject.toBean(jsonObject, AddressListVO.class);
			List<String> address_list = alvo.getAddress_list();
			address_list.add(address);
			alvo = new AddressListVO();
			alvo.setAddress_list(address_list);
			jsonObject = JSONObject.fromObject(alvo);
			String newjsonaddress = jsonObject.toString();
			civo.setAddress(newjsonaddress);
			int r = this.customerInfoService.updateByPKSelective(civo);
			if(r == 1){
				result.setResult(true);
				result.setMsg("新增成功");
			}else{
				result.setResult(false);
				result.setMsg("新增失败");
			}
		}else if(civo_list.size() == 0){//之前没数据
			List<String> address_list = new ArrayList<String>();
			address_list.add(address);
			AddressListVO alvo = new AddressListVO();
			alvo.setAddress_list(address_list);
			JSONObject jsonObject = JSONObject.fromObject(alvo);
			String newjsonaddress = jsonObject.toString();
			civo.setAddress(newjsonaddress);
			int r = this.customerInfoService.insertSelective(civo);
			if(r == 1){
				result.setResult(true);
				result.setMsg("新增成功");
			}else{
				result.setResult(false);
				result.setMsg("新增失败");
			}
		}else{
			result.setResult(false);
			result.setMsg("出现异常");
		}
		
		
		return result;
	}
	
	
}
