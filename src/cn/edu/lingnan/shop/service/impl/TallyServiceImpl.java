package cn.edu.lingnan.shop.service.impl;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.TallyDao;
import cn.edu.lingnan.shop.pojo.Tally;
import cn.edu.lingnan.shop.service.TallyService;

@Transactional
@Service
public class TallyServiceImpl implements TallyService {

	@Autowired
	private TallyDao tallyDao;
	
	public void mergeTally(Tally tally) {
		this.tallyDao.merge(tally);
	}

	@Override
	public Tally getTallyByDate(Date date) {
		return this.tallyDao.findById(date);
	}

	@Override
	public Serializable saveTally(Tally tally) {
		return this.tallyDao.save(tally);
	}

}
