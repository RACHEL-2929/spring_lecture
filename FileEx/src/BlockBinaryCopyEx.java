import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BlockBinaryCopyEx {

	public static void main(String[] args) {

		File src = new File("c:\\Windows\\Web\\Wallpaper\\Theme1\\img1.jpg");
		File dest =  new File("c:\\Temp\\desert.jpg");
		try {
			FileInputStream fi = new FileInputStream(src);
			FileOutputStream fo = new FileOutputStream(dest);
			byte[] buf = new byte[1024*10];
			while(true) {
				int n = fi.read(buf);//버퍼 크기만큼 읽어오기 
				fo.write(buf,0,n);//버퍼 크기만큼 쓰기
				if(n< buf.length)
					break;
			}
			fi.close();
			fo.close();
			System.out.println(src.getPath() + "를" + dest.getPath() + " 로 복사하였습니다.");
			
		} catch (IOException e) { System.out.println("파일복사오류"); }
		
	}

}
