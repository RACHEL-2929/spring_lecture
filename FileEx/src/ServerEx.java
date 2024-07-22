import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerEx {

	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		ServerSocket listener = null;
		Socket socket= null;
		Scanner scanner= new Scanner(System.in); // 키보드에서읽을scanner 객체생성
		try {
			listener = new ServerSocket(9000); // 서버소켓생성
			System.out.println("연결을기다리고있습니다.....");
			socket = listener.accept(); // 클라이언트로부터연결요청대기
			System.out.println("연결되었습니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
			while (true) {
				String inputMessage= in.readLine(); // 클라이언트로부터한행읽기
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("클라이언트가 종료를 하였습니다.");
					break; // "bye"를받으면연결종료
				}
				System.out.println("클라이언트에서 보내온 메세지 : " + inputMessage);
				System.out.print("보내기>>"); // 프롬프트
				String outputMessage= scanner.nextLine(); // 키보드에서한행읽기
				out.write(outputMessage+ "\n"); // 키보드에서읽은문자열전송
				out.flush(); // out의스트림버퍼에있는모든문자열전송
			}
		}catch (IOException e) { System.out.println(e.getMessage());}
		finally {
			try {
				scanner.close(); // scanner 닫기
				socket.close(); // 통신용소켓닫기
				listener.close(); // 서버소켓닫기
				} catch (IOException e) { System.out.println("클라이언트와채팅중오류가발생했습니다."); }
		 }
		
	}
	
}
