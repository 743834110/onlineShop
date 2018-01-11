package cn.edu.lingnan.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.dao.ClothesDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.ProductImagesDao;
import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.Product;
import cn.edu.lingnan.shop.pojo.ProductExtend;
import cn.edu.lingnan.shop.pojo.ProductImages;
import cn.edu.lingnan.shop.service.ProductService;
import cn.edu.lingnan.shop.utils.OrderKeyGen;

@Transactional
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ClothesDao clothesDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductImagesDao productImagesDao;
	
	@Override
	public List<Category> findAllCates() {
		return categoryDao.getListByHQL("from Category");
	}

	@Override
	public Long saveClothes(Clothes clothes) {
		return (Long) clothesDao.save(clothes);
	}

	@Override
	public Category getCateById(Long id) {
		return categoryDao.findById(id);
	}

//	@Override
//	public void saveProductBySql(Product product) {
//		productDao.insertByHQL(product);
//	}

	@Override
	public Product getProductById(Long id) {
		return productDao.findById(id);
	}

	@Override
	public void saveImages(ProductImages productImages) {
		productImagesDao.save(productImages);
		
	}

	@Override
	public void saveProduct(Product product) {
		OrderKeyGen.preFix = product.getId();
		productDao.save(product);
	}

	@Override
	public List<Product> finaAllProduct() {
		return productDao.getListByHQL("from Product");
	}
	
	@Override
	public List<String> getProductByNameWithLimit(String keyword, int limitSize) {
		String hqlString = "from Product where name like ?";
		List<Product> products = this.productDao.queryListObjectAllForPage(limitSize,
				1, hqlString, "%" + keyword + "%");
		List<String> names = new ArrayList<String>();
		for (Product product: products)
			names.add(product.getName());
		return names;
	}

	@Override
	public List<Product> getProductByName(String keyword, int limitSize) {
		String hqlString = "from Product where name like ?";
		List<Product> products = this.productDao.queryListObjectAllForPage(limitSize, 1, hqlString,
							"%" + keyword + "%");
		return products;
	}

	@Override

	public List<Product> getProductByCondition(ProductExtend cond, int pageNo,
			int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductSizeByCondition(ProductExtend cond) {
		// TODO Auto-generated method stub
		return null;
	}
	public Clothes getClotheById(Long id) {
		return clothesDao.findById(id);
	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
	}

	@Override
	public void updateClothes(Clothes clothe) {
		clothesDao.update(clothe);
	}

	@Override
	public void updateImages(ProductImages productImages) {
		productImagesDao.update(productImages);
	}


}
