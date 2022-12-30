package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Scanner;

import vendingmachine.view.ProductView;
import vendingmachine.vo.ProductDAO;
import vendingmachine.vo.ProductVO;

public class ProductController {
	public static final int STOP = 0;

	public static void main(String[] args) {
//		자판기에 제품 채우기
		ProductDAO dao = new ProductDAO();
		String[] names = {"사이다", "콜라", "오렌지웰치스", "포도웰치스", "제로콜라", "초록매실", "오렌지쥬스", "비락식혜", "비타500"}; 
		int[] prices = {800, 900, 1100, 1100, 1500, 1600, 2000, 1000, 700};
		ProductVO vo = null;
		ArrayList<ProductVO> productList = dao.select();
		for (int i=0; i<names.length; i++) {
			vo = new ProductVO();
			vo.setName(names[i]);
			vo.setPrice(prices[i]);
			vo.setProductNum(i);
			vo.setStockNum(10);
			productList.add(vo);
		}
		
//		자판기 화면 출력
		ProductView view = new ProductView();
		view.setProductList(productList);
		view.displayProducts();
//		자판기 제품 구매 화면
		Scanner s1 = view.getS1();
		while(true) {
			view.inputPurchase();
			System.out.print("!!제품을 계속 구매하시겠습니까?(Continue:1, Stop:0) :");
			int state = s1.nextInt();
			if(state == STOP)
				break;
			view.displayProducts();
		}
		
		s1.close();
	}

}
