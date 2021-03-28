package com.ibm.shop;
public class ShoppingCart {
	private double cartTotal;
	private Product[] items;
	private int idx;
	private int discountAmount;
	
	String[][] coupons = {{"HOLI200","200"},{"WKND100","100"},{"APRIL150","5000"}};
	public ShoppingCart() {
		items =  new Product[5];
	}
	
	public void addProdcut(Product p) throws OutOfTheStockException {
		if(idx<items.length) {
			items[idx++]=p;
			cartTotal+= p.getPrice();
			
		}
		else
			System.out.println("Your cart is full");
	}
	
	public void checkout(String coupon) throws PaymentException, CouponException{
		if(idx == 0)
			//System.out.println("your cart is empty!");
			throw new PaymentException("your cart is empty!");
		else 
		{
			//System.out.println("Products in your cart");
			//throw new PaymentException("Products in your cart!");
			
//			for(int i=0;i<idx;i++)
//				System.out.println(items[i].getTitle()+ ":"+items[i].getPrice());
//			
			int flag =0;
			
			for(int i=0;i<coupons.length;i++) {
				if(coupons[i][0].equals(coupon)) {
					discountAmount=Integer.parseInt(coupons[i][1]);
					flag=1;
				}
			}
			if(flag==0) {
				throw new CouponException("Coupon not valid!");
			}
			System.out.println("Cart Total:"+ (cartTotal-discountAmount));
			
		}
	}
	
		public void checkout() throws PaymentException{
			if(idx == 0)
				//System.out.println("your cart is empty!");
				throw new PaymentException("your cart is empty!");
			else 
			{
				System.out.println("Products in your cart");
				//throw new PaymentException("Products in your cart!");
				
				for(int i=0;i<idx;i++)
					System.out.println(items[i].getTitle()+ ":"+items[i].getPrice());
				
				System.out.println("Cart Total:"+ (cartTotal-discountAmount));
				
			}
	}
}
