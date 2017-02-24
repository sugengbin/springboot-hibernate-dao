package info.sugengbin.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import info.sugengbin.springboot.Application;
import info.sugengbin.springboot.service.ISystemParamService;

/**
 * 
 *
 * Date:     2017年2月24日<br/> 
 * @author   sugengbin
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class HibernateTest {

	@Autowired
	private ISystemParamService systemParamService;
	
	@Test
	public void testDao(){
		Assert.assertTrue(systemParamService.getAll().size() == 17);
	}
}
