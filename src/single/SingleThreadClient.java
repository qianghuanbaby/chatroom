package single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:qh
 * Created:2019/8/14
 */

public class SingleThreadClient {
    public static void main(String[] args) throws IOException {
        //1.建立连接
        Socket socket = new Socket("127.0.0.1",6666);   //服务器端根据指定IP和端口号连接服务器

        PrintStream printStream = new PrintStream(socket.getOutputStream(),
                true,"UTF-8");
        Scanner in = new Scanner(System.in);
        String str = "";
        System.out.println("请输入向服务器发送的信息");
        if(in.hasNext()){
            str = in.nextLine();
        }
        printStream.println(str);

        //2. 进行数据的输入输出
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("从服务器发来的信息为："+scanner.nextLine());
        }
        //3. 关闭流
        printStream.close();
        scanner.close();
        socket.close();
    }
}
