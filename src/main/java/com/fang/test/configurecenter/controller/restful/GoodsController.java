package com.fang.test.configurecenter.controller.restful;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/goods")
public class GoodsController {

//	private GoodsService goodsService;
//
//	@Inject
//	public GoodsController(GoodsService goodsService) {
//		this.goodsService = goodsService;
//	}
//
//	// @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	// public String getGoods(@PathVariable("id") int id, Model model) {
//	// model.addAttribute(goodsService.getGoodsById(id));
//	// return "goods/view";
//	// }
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
//	public @ResponseBody
//	Goods getGoods(@PathVariable("id") int id, HttpServletResponse response) {
//
//		Goods goods = goodsService.getGoodsById(id);
//		//response.setHeader("Location", "/goods/" + goods.getId());
//		return goods;
//	}
//	
//	
//	@RequestMapping(method = RequestMethod.GET)
//	public @ResponseBody
//	List<Goods> getAllGoods(HttpServletResponse response) {
//
//		List<Goods> goods = goodsService.getAllGoods();
//		//response.setHeader("Location", "/goods/" + goods.getId());
//		return goods;
//	}
//	
//	@RequestMapping(value = "/category/{category}", method = RequestMethod.GET)
//	public @ResponseBody
//	List<Goods> getGoodsByGategory(@PathVariable("category") String category) {
//
//		List<Goods> goods = goodsService.getGoodsByCategory(category);
//		//response.setHeader("Location", "/goods/" + goods.getId());
//		return goods;
//	}
//	
////	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
////	public @ResponseBody String getGoods(@PathVariable("id") int id, HttpServletRequest req,HttpServletResponse response) {
////
////		Goods goods = goodsService.getGoodsById(id);
////		//response.setHeader("Location", "/goods/" + goods.getId());
////		return "123";
////	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
//	@ResponseStatus(org.springframework.http.HttpStatus.NO_CONTENT)
//	public void putGoods(@PathVariable("id") int id,
//			@RequestBody @Valid Goods goods) {
//		goods.setId(id);
//		goodsService.saveGoods(goods);
//	}
//
//	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void deleteGoods(@PathVariable("id") int id) {
//		goodsService.deleteGoods(id);
//	}
//
//	@RequestMapping(method = RequestMethod.POST)
//	@ResponseStatus(HttpStatus.CREATED)
//	public @ResponseBody
//	Goods createGoods(@RequestBody @Valid Goods goods, BindingResult result,
//			HttpServletResponse response) throws BindException {
//		if (result.hasErrors()) {
//			throw new BindException(result);
//		}
//		goodsService.createGoods(goods);
//		response.setHeader("Location", "/goods/" + goods.getId());
//		return goods;
//	}
}
