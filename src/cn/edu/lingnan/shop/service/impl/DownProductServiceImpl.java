package cn.edu.lingnan.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.DownProductDao;
import cn.edu.lingnan.shop.pojo.DownProduct;
import cn.edu.lingnan.shop.service.DownProductService;

@Transactional
@Service
public class DownProductServiceImpl implements DownProductService {
	
	@Autowired
	private DownProductDao downProductDao;
	
	@Override
	public void saveDwonProduct(DownProduct downProduct) {
		downProductDao.save(downProduct);
	}

	@Override
	public List<DownProduct> findAllDownProduct() {
		return downProductDao.getListByHQL("from DownProduct");
	}



	
}
