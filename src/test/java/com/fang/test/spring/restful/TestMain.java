package com.fang.test.spring.restful;


public class TestMain {

//	private OrderService os;
//	private GoodsService goodsService;
//	@Before
//	public void setup() {
//		try {
//			ApplicationContext context = new ClassPathXmlApplicationContext("spring_test.xml");
//			os = context.getBean("orderService", OrderService.class);
//			goodsService = context.getBean("goodsService", GoodsService.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//
//	//@Test
//	public void testPlaceAnOrder() {
//
//		try {
//			UserDetail detail = new UserDetail();
//			detail.setName("Abby");
//			Order order = new Order();
//			order.setUser(detail);
//
//			OrderItem item = new OrderItem();
//			item.setPrice(1.2);
//			item.setQunty(10);
//			Goods goods = new Goods();
//			goods.setId(1);
//			item.setGoods(goods);
//			item.setOrder(order);
//			order.getItems().add(item);
//
//			item = new OrderItem();
//			item.setPrice(5.0);
//			item.setQunty(15);
//			goods = new Goods();
//			goods.setId(3);
//			item.setOrder(order);
//			item.setGoods(goods);
//			order.getItems().add(item);
//
//			os.placeAnOrder(order);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//	
//	//@Test
//	public void testCancelAnOrder() {
//		try {
//			os.cancelAnOrder(8);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
//	
//	@Test
//	public void testCloseAnOrder() {
//		try {
//			Goods g11 = goodsService.getGoodsById(1);
//			Goods g21 = goodsService.getGoodsById(3);
//			os.closeAnOrder(10);
//			
//			Goods g12 = goodsService.getGoodsById(1);
//			Goods g22 = goodsService.getGoodsById(3);
//			
//			Assert.assertEquals(10, g11.getQunty()-g12.getQunty());
//			Assert.assertEquals(15, g21.getQunty()-g22.getQunty());
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw e;
//		}
//	}
}
