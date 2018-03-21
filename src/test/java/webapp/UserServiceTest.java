package webapp;

import org.junit.Before;
import org.junit.Test;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unicom.busi.service.UserService;
import com.unicom.busi.service.impl.UserServiceImpl;

public class UserServiceTest {
	
	private UserService service;
	
	private CacheManager cm;
	
	@Before
	public void setUp(){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		service = context.getBean("userServiceImpl", UserServiceImpl.class);
		cm = context.getBean("cacheManager",CompositeCacheManager.class);
	}
	
	@Test
	public void test(){
		System.out.println("first call...");
		service.getUserById(3);
		System.out.println("second call...");
		service.getUserById(3);
		/*SysUser user = new SysUser();
		user.setId(3);
		user.setName("zhangsan");
		user.setAge(28);
		user.setMailAddr("fsjfsfjlsfjl");
		service.update(user);
		System.out.println("third call...");
		service.getUserById(3);
		
		Cache cache = cm.getCache("userCache");
		user = cache.get(3, SysUser.class);
		if(user != null){
			System.out.println(user);
		}else{
			System.out.println("value is null");
		}*/
		
	}
}
