package cn.edu.lingnan.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.CategoryDao;
import cn.edu.lingnan.shop.dao.ClothesDao;
import cn.edu.lingnan.shop.dao.DownProductDao;
import cn.edu.lingnan.shop.dao.ProductDao;
import cn.edu.lingnan.shop.dao.ProductImagesDao;
import cn.edu.lingnan.shop.pojo.Category;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.pojo.DownProduct;
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
		List<Product> products = null;
		if (limitSize != 0)
			products = this.productDao.queryListObjectAllForPage(limitSize, 1, hqlString,
							"%" + keyword + "%");
		if (limitSize == 0)
			products = this.productDao.getListByHQL(hqlString, "%" + keyword + "%");
		return products;
	}


	/**
	 * 根据条件进行分页
	 */
	public List<Product> getProductByCondition(Product cond, int pageNo,
			int size, Order order) {
		return this.productDao.getResultForPage(cond, size, pageNo, order);
	}

	@Override
	public long getProductSizeByCondition(Product cond) {
		
//		return this.productDao.getUniqueResultForPage(cond);
		return (long) this.productDao.uniqueResultForPages(cond);
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

	@Override
	public List<Product> getPageById(int pageSize, int pageNo, Long id,int flag) {
		String hql = "from Product where 1=1";
		List<Object> values = new ArrayList<>();
		values.add(id);
		hql += " and user.id = ?";
		if(flag == 0)
			hql += " and offshelf = 0";
		else if(flag == 1){
			hql += " and offshelf = 1 or offshelf = 2";
		}
		List<Product> list = productDao.queryListObjectAllForPage(pageSize, pageNo, hql, values.toArray());
		return list;
	}

	@Override
	public Long getAllCount(Long id,int flag) {
		String hql = "select count(p) from Product p where 1=1";
		hql += " and user.id = ?";
		if(flag == 0)
			hql += " and offshelf = 0";
		else if(flag == 1){
			hql += " and offshelf = 1 or offshelf = 2";
		}
		List<Object> values = new ArrayList<>();
		values.add(id);
		Long count = (Long) productDao.uniqueResult(hql, values.toArray());
		return count;
	}


}
