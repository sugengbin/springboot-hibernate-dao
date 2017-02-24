package info.sugengbin.springboot.service;

import java.util.List;

import info.sugengbin.springboot.model.SystemParamConfig;

/**
 * 
 *
 * Date:     2017年2月24日<br/> 
 * @author   sugengbin
 */
public interface ISystemParamService {

	/**
	 * 
	 * @return
	 */
	List<SystemParamConfig> getAll();
	
}
