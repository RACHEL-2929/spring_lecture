import java.net.InetAddress;
import java.net.UnknownHostException;

public class AddressTest {
	
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ad = InetAddress.getLocalHost();
		System.out.println("��ǻ�� �̸���  : " + ad.getHostName());
		System.out.println("��ǻ�� IP �ּ� : " + ad.getHostAddress());
		
		
		System.out.println("----------------------------");
		ad = InetAddress.getByName("www.naver.com");
		System.out.println("���̹� �̸���  : " + ad.getHostName());
		System.out.println("���̹� �ּ� : " + ad.getHostAddress());
		
		System.out.println("----------------------------");
		InetAddress all[] = InetAddress.getAllByName("www.naver.com");
		for (int i = 0; i < all.length; i++) {
			System.out.println(all[i]);
		}
		
	}

}
