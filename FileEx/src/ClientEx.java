import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientEx {

	public static void main(String[] args) {

		BufferedReader in = null;
		BufferedWriter out = null;
		
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			socket = new Socket("192.168.1.33",9000);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			while(true) {
				String outputMessage = sc.nextLine();
				
				if(outputMessage.equalsIgnoreCase("bye")) {//��ҹ��ڸ� �������� �ʰ� bye��� ġ��
					out.write(outputMessage + "\n");
					out.flush();
					break;
				}
				
				out.write(outputMessage + "\n");
				out.flush();
				String inputMessage = in.readLine();
				System.out.println("���� : " + inputMessage);
			}
		}catch(Exception e){
			 System.out.println(e.getMessage());
		}finally {
			 try {
				 sc.close();
				 if(socket != null) socket.close(); // Ŭ���̾�Ʈ���ϴݱ�
				} catch (IOException e) {
				 System.out.println("������ä���߿������߻��߽��ϴ�.");
				 }
		}
	}

}
