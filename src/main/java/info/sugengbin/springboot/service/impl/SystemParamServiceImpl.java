package info.sugengbin.springboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.sugengbin.springboot.dao.ISystemParamConfigDao;
import info.sugengbin.springboot.model.SystemParamConfig;
import info.sugengbin.springboot.service.ISystemParamService;

/**
 * 
 *
 * Date:     2017年2月24日<br/> 
 * @author   sugengbin
 */
@Service
@Transactional
public class SystemParamServiceImpl implements ISystemParamService {

	@Autowired
	private ISystemParamConfigDao systemParamConfigDao;

	@Override
	public List<SystemParamConfig> getAll() {
		return systemParamConfigDao.findAll();
	}

}
