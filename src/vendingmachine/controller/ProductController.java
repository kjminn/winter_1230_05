package vendingmachine.controller;

import java.util.ArrayList;

import vendingmachine.view.ProductView;
import vendingmachine.vo.ProductDAO;
import vendingmachine.vo.ProductVO;

public class ProductController {

	public static void main(String[] args) {
//		자판기에 제품 채우기
		ProductDAO dao = new ProductDAO();
		String[] names = {"사  이  다", "콜      라", "오렌지웰치스", "포도  웰치스", "제로  콜라", "초록  매실", "오렌지  쥬스", "비 락 식 혜", "비타  500"}; 
		int[] prices = {800, 900, 1100, 1100, 1500, 1600, 2000, 1000, 700};
		ProductVO vo = null;
		ArrayList<ProductVO> productList = dao.select();
		for (int i=0; i<names.length; i++) {
			vo = new ProductVO();
			vo.setName(names[i]);
			vo.setPrice(prices[i]);
			vo.setStockNum(10);
			productList.add(vo);
		}
		
//		자판기 화면 출력
		ProductView view = new ProductView();
		view.setProductList(productList);
		view.displayProducts();
//		자판기 제품 구매 화면
		view.inputPurchase();
		
	}

}
