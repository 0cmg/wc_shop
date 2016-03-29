package com.lichking.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lichking.itf.service.ICommodityInfoService;
import com.lichking.itf.service.ICommodityTypeService;
import com.lichking.pojo.web.ComIMVO;
import com.lichking.pojo.web.CommodityInfoVO;
import com.lichking.pojo.web.CommodityTypeVO;
import com.lichking.pojo.web.OptionVO;
import com.lichking.pojo.web.ResultVO;
import com.lichking.pojo.web.co.SimpleComVO;

/**
 * 用于前后台的数据交互
 * @author LichKing
 *
 */
@Controller
@RequestMapping("/back/data")
public class BMDataContronller {
	
	@Resource
	private ICommodityTypeService commodityTypeService;
	@Resource
	private ICommodityInfoService commodityInfoService;
	
	private Logger log = Logger.getLogger(BMDataContronller.class);
	
	/**
	 * 查询所有商品类型
	 * @param res
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/getAllTypes")
	public @ResponseBody ResultVO<List> getAllCommodityTypes(HttpServletResponse res) throws Exception{
		log.info("请求json数据：/back/data/getAllTypes");
		
		ResultVO result = getTypes();
		return result;
	}
	
	/**
	 * 新增商品类型
	 * @param res
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/addTypes")
	public @ResponseBody ResultVO<List> addCommodityTypes(HttpServletResponse res,@RequestBody CommodityTypeVO type){
		log.info("添加商品类型：/back/data/addTypes");
		if(canAdd(type)){
			this.commodityTypeService.insertComType(type);
			ResultVO result = getTypes();
			result.setMsg("新增商品成功!");
			log.info("新增商品成功!");
			return result;
		}
		ResultVO result = new ResultVO<>();
		result.setMsg("该商品类型已存在！新增失败！");
		result.setResult(false);
		log.info("该商品类型已存在！新增失败！");
		return result;
	}
	
	/**
	 * 新增商品
	 * @param com
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/addCom")
	public @ResponseBody ResultVO addCommodity(@RequestBody CommodityInfoVO com){
		log.info("请求/back/data/addCom");
		int r = this.commodityInfoService.insertComWithNull(com);
		ResultVO result = new ResultVO<>();
		if(r == 1){
			result.setMsg("新增商品成功");
			result.setResult(true);
		}else{
			result.setMsg("新增商品失败");
			result.setResult(false);
		}
		return result;
	}
	
	/**
	 * 按条件查询商品
	 * @param com
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/queryComByWhere")
	public @ResponseBody ResultVO<List> queryComByWhere(@RequestBody CommodityInfoVO com){
		log.info("请求:/back/data/queryComByWhere");
		List<CommodityInfoVO> list = this.commodityInfoService.selectByWhere(com);
		ResultVO<List> result = new ResultVO<List>();
		for(CommodityInfoVO c : list){
			String img_url = c.getImageurl();
			String[] urls = img_url.split(";");
			c.setImageurl(urls[0]);
			c.setDescdetails("");
			//c.setType("");
		}
		if(list.size() > 0){
			result.setMsg("查询成功");
			result.setResult(true);
			result.setT(list);
		}else{
			result.setMsg("查询失败");
			result.setResult(false);
		}
		return result;
	}
	
	@RequestMapping("/queryComByPK")
	public @ResponseBody ResultVO<CommodityInfoVO> getComByPK(@RequestBody Integer comid){
		log.info("请求:/back/data/queryComByPK");
		CommodityInfoVO com = this.commodityInfoService.selectByPK(comid);
		ResultVO<CommodityInfoVO> result = new ResultVO<CommodityInfoVO>();
		if(!com.getName().equals("") && com.getName() != null){
			result.setResult(true);
			result.setMsg("查询成功");
			result.setT(com);
		}else{
			result.setResult(false);
			result.setMsg("查询失败");
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/updateComByPKSelective")
	public @ResponseBody ResultVO updateCom(@RequestBody CommodityInfoVO com){
		log.info("请求路径：/back/data/updateComByPKSelective");
		int r = this.commodityInfoService.updateComByPKSelective(com);
		System.out.println(r);
		ResultVO result = new ResultVO();
		if(r == 1){
			result.setMsg("更新商品成功");
			result.setResult(true);
		}else{
			result.setMsg("更新商品失败");
			result.setResult(false);
		}
		return result;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/deleteComByPK")
	public @ResponseBody ResultVO<CommodityInfoVO> deleteComByPK(@RequestBody Integer comid){
		log.info("请求:/back/data/deleteComByPK");
		int r = this.commodityInfoService.deleteComByPK(comid);
		ResultVO result = new ResultVO();
		if(r == 1){
			result.setResult(true);
			result.setMsg("删除成功");
		}else{
			result.setResult(false);
			result.setMsg("查询失败");
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/ComOnOff")
	public @ResponseBody ResultVO editComStatus(@RequestBody OptionVO op){
		log.info("请求：/back/data/ComOnOff");
		ResultVO result = new ResultVO();
		Integer comid_need = op.getId();
		CommodityInfoVO com = this.commodityInfoService.selectByPK(comid_need);
		Byte com_status = com.getIsonline();
		if(com_status == 0 && op.getO().equals("online")){
			log.info("请求商品上架操作");
			CommodityInfoVO new_com = new CommodityInfoVO();
			Byte b = 1;
			new_com.setIsonline(b);
			new_com.setCommodityid(comid_need);
			int r = this.commodityInfoService.updateComByPKSelective(new_com);
			if (r ==1){
				log.info("操作成功");
				result.setMsg("操作成功");
				result.setResult(true);
			}else{
				log.info("操作失败");
				result.setMsg("操作失败");
				result.setResult(false);
			}
		}else if(com_status == 1 && op.getO().equals("offline")){
			log.info("请求商品下架操作");
			CommodityInfoVO new_com = new CommodityInfoVO();
			Byte b = 0;
			new_com.setIsonline(b);
			new_com.setCommodityid(comid_need);
			int r = this.commodityInfoService.updateComByPKSelective(new_com);
			if (r ==1){
				log.info("操作成功");
				result.setMsg("操作成功");
				result.setResult(true);
			}else{
				log.info("操作失败");
				result.setMsg("操作失败");
				result.setResult(false);
			}
		}else{
			log.info("操作错误");
			result.setMsg("操作错误");
			result.setResult(false);
		}
		return result;
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping("/ComIM")
	public @ResponseBody ResultVO vComIM(@RequestBody ComIMVO comim){
		log.info("请求：/back/data/ComIM");
		ResultVO result = new ResultVO();
		
		String op = comim.getOp();
		List<SimpleComVO> list = comim.getList();
		if(op.equals("addI")){
			log.info("库存add操作");
			for(SimpleComVO scom : list){
				Integer comid = scom.getCommodityid();
				CommodityInfoVO com = this.commodityInfoService.selectByPK(comid);
				log.info("原库存："+com.getRestno()+" 需添加数量："+scom.getNumber());
				Integer new_no = com.getRestno()+scom.getNumber();
				com.setRestno(new_no);
				this.commodityInfoService.updateComByPKSelective(com);
			}
			result.setMsg("操作成功");
			result.setResult(true);
		}else if(op.equals("setI")){
			log.info("库存set操作");
			for(SimpleComVO scom : list){
				Integer comid = scom.getCommodityid();
				CommodityInfoVO com = this.commodityInfoService.selectByPK(comid);
				com.setRestno(scom.getNumber());
				this.commodityInfoService.updateComByPKSelective(com);
			}
			result.setMsg("操作成功");
			result.setResult(true);
		}else{
			log.info("请求操作符异常 请检查");
			result.setMsg("请求操作符异常 请检查");
			result.setResult(false);
		}
		
		return result;
	}
	
	/**
	 * 获取商品类型 常用 所以写成方法
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ResultVO<List> getTypes(){
		List<CommodityTypeVO> c_list = this.commodityTypeService.getAllTypes();
		ResultVO result = new ResultVO<>();
		result.setMsg("");
		result.setResult(true);
		result.setT(c_list);
		return result;
	}

	
	/**
	 * 检查要新增的商品类型是否已经存在
	 * @param type
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean canAdd(CommodityTypeVO type){
		ResultVO result = getTypes();
		//log.info(type.getType());
		List<CommodityTypeVO> list = (List<CommodityTypeVO>) result.getT();
		for(CommodityTypeVO t : list){
			//log.info(t.getType());
			if(t.getType().equals(type.getType())){
				return false;
			}
		}
		return true;
	}
	
}
