package cn.edu.lingnan.shop.service;

import cn.edu.lingnan.shop.pojo.Clothes;

public interface ClothesService {
	
	//通过id获取衣服
	public Clothes findClothesById(long id);
}
