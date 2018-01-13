package cn.edu.lingnan.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.ClothesDao;
import cn.edu.lingnan.shop.pojo.Clothes;
import cn.edu.lingnan.shop.service.ClothesService;

@Transactional
@Service
public class ClothesServiceImpl implements ClothesService{
	
	@Autowired
	private ClothesDao clothesDao;
	
	@Override
	public Clothes findClothesById(long id) {
		System.out.println(id);
		return this.clothesDao.findById(id);
	}

}
