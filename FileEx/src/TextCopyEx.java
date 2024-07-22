import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopyEx {

	public static void main(String[] args) {

		File src= new File("c:\\windows\\system.ini"); // �������ϰ�θ�
		File dest= new File("c:\\Temp\\system.txt"); // �������ϰ�θ�
		int c;
		try {
			FileReader fr= new FileReader(src);
			FileWriter fw= new FileWriter(dest); 
			while((c = fr.read()) != -1) { // �����ϳ��а�
				fw.write((char)c); // �����ϳ�����
			}
			fr.close(); fw.close();
			System.out.println(src.getPath()+ "��" + dest.getPath()+ "�� �����Ͽ����ϴ�.");
		} catch (IOException e) {
			System.out.println("���Ϻ������");
		}
	}

}