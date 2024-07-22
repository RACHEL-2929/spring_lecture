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
		Scanner scanner= new Scanner(System.in); // Ű���忡������scanner ��ü����
		try {
			listener = new ServerSocket(9000); // �������ϻ���
			System.out.println("��������ٸ����ֽ��ϴ�.....");
			socket = listener.accept(); // Ŭ���̾�Ʈ�κ��Ϳ����û���
			System.out.println("����Ǿ����ϴ�.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"));
			while (true) {
				String inputMessage= in.readLine(); // Ŭ���̾�Ʈ�κ��������б�
				if (inputMessage.equalsIgnoreCase("bye")) {
					System.out.println("Ŭ���̾�Ʈ�� ���Ḧ �Ͽ����ϴ�.");
					break; // "bye"�������鿬������
				}
				System.out.println("Ŭ���̾�Ʈ���� ������ �޼��� : " + inputMessage);
				System.out.print("������>>"); // ������Ʈ
				String outputMessage= scanner.nextLine(); // Ű���忡�������б�
				out.write(outputMessage+ "\n"); // Ű���忡���������ڿ�����
				out.flush(); // out�ǽ�Ʈ�����ۿ��ִ¸�繮�ڿ�����
			}
		}catch (IOException e) { System.out.println(e.getMessage());}
		finally {
			try {
				scanner.close(); // scanner �ݱ�
				socket.close(); // ��ſ���ϴݱ�
				listener.close(); // �������ϴݱ�
				} catch (IOException e) { System.out.println("Ŭ���̾�Ʈ��ä���߿������߻��߽��ϴ�."); }
		 }
		
	}
	
}
