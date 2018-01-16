package cn.edu.lingnan.shop.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.lingnan.shop.dao.TallyDao;
import cn.edu.lingnan.shop.pojo.Tally;
import cn.edu.lingnan.shop.service.TallyService;
import cn.edu.lingnan.shop.utils.DateFormatUtils;

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
		return this.tallyDao.findById(DateFormatUtils.format(date));
	}

	@Override
	public Serializable saveTally(Tally tally) {
		return this.tallyDao.save(tally);
	}

	@Override
	public List<Tally> getAllTally() {
		
		return this.tallyDao.getListByHQL("from Tally order by id asc");
	}

}
