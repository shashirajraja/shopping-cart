package com.shashi.service;

import java.io.InputStream;
import java.util.List;

import com.shashi.beans.ProductBean;

public interface ProductService {

	public String addProduct(String prodName, String prodType, String prodInfo, double prodPrice, int prodQuantity,
			InputStream prodImage,int used);

	public String addProduct(ProductBean product);

	public String removeProduct(String prodId);

	public String updateProduct(ProductBean prevProduct, ProductBean updatedProduct);

	public String updateProductPrice(String prodId, double updatedPrice);

	public List<ProductBean> getAllProducts();

	public List<ProductBean> getAllProductsByType(String type);

	public List<ProductBean> searchAllProducts(String search);

	public byte[] getImage(String prodId);

	public ProductBean getProductDetails(String prodId);

	public String updateProductWithoutImage(String prevProductId, ProductBean updatedProduct);

	public double getProductPrice(String prodId);

	public boolean sellNProduct(String prodId, int n);

	public int getProductQuantity(String prodId);


	public List<ProductBean> getMostSelling();

	public boolean increaseSoldQ(String prodId,int n);

	public List<ProductBean> getAllUsed();

	//Selects the top 5 most selling products and applies a discount to them (if they have not already been discounted)
	public List<ProductBean> displayDiscounts();

	//Suggests the top 5 most selling items which have not already been discounted
	public List<ProductBean> suggestDiscounts();

	//Suggests restocking of all products with <=3 quantity in stock
	public List<ProductBean> suggestRestock();
	
	//Applies a discount to a product based on its soldQ and sets the value of discounted to true
	public boolean applyDiscount(String prodId, double newPrice);
}
