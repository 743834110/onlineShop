package cn.edu.lingnan.shop.service;

import java.io.Serializable;
import java.util.Date;

import cn.edu.lingnan.shop.pojo.Tally;

public interface TallyService {
	
	//添加或更新信息的统计
	public void mergeTally(Tally tally);
	//通过日期获取tally实例
	public Tally getTallyByDate(Date date);
	//
	public Serializable saveTally(Tally tally);
}
