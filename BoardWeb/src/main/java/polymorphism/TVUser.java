package polymorphism;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {

		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		TV tv = (TV) factory.getBean("tv");
		// bean에서 등록되어 있는 id를 통해서 가지고 옴
		// TV tv2 = (TV) factory.getBean("tv");
		// 기본적으로 싱글톤 패턴이기 때문에 하나의 객체만 메모리에 생긴다 
		// 만약 여러개의 객체를 생기게 하고 싶다면 bean 태그에서 scope 속성을 prototype으로 주면 된다.
		
		  tv.powerOn(); tv.volumeUp(); tv.volumeDown(); tv.powerOff();
		 
		
		factory.close();

		/*
		 * BeanFactory factory = new BeanFactory();
		 * 
		 * TV tv = (TV)factory.getBean(args[0]); tv.powerOn(); tv.volumeUp();
		 * tv.volumeDown(); tv.powerOff();
		 */

	}

}
