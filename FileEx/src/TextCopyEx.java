import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopyEx {

	public static void main(String[] args) {

		File src= new File("c:\\windows\\system.ini"); // 원본파일경로명
		File dest= new File("c:\\Temp\\system.txt"); // 복사파일경로명
		int c;
		try {
			FileReader fr= new FileReader(src);
			FileWriter fw= new FileWriter(dest); 
			while((c = fr.read()) != -1) { // 문자하나읽고
				fw.write((char)c); // 문자하나쓰고
			}
			fr.close(); fw.close();
			System.out.println(src.getPath()+ "를" + dest.getPath()+ "로 복사하였습니다.");
		} catch (IOException e) {
			System.out.println("파일복사오류");
		}
	}

}
