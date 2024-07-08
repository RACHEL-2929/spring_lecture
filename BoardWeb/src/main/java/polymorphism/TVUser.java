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
		// bean���� ��ϵǾ� �ִ� id�� ���ؼ� ������ ��
		// TV tv2 = (TV) factory.getBean("tv");
		// �⺻������ �̱��� �����̱� ������ �ϳ��� ��ü�� �޸𸮿� ����� 
		// ���� �������� ��ü�� ����� �ϰ� �ʹٸ� bean �±׿��� scope �Ӽ��� prototype���� �ָ� �ȴ�.
		
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
