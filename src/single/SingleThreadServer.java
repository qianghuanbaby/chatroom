package single;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Author:qh
 * Created:2019/8/14
 */

public class SingleThreadServer {
    public static void main(String[] args) throws IOException {
        //1.建立基站
        ServerSocket server = new ServerSocket(6666);  //提供给端口号
        //2. 等待客户端连接
        System.out.println("等待客户端连接...");
        Socket socket = server.accept();   //方法一直阻塞，等待客户端连接，返回连接线

        //3. 建立连接后，进行数据的输入输出
        //输出用printStream，输入用Scanner
        //建立连接，服务器给客户端输出数据
        PrintStream printStream = new PrintStream(socket.getOutputStream(),
                true,"UTF-8");
        printStream.print("hello i am Server!");

        //拿到客户端输入到服务器的数据
        Scanner scanner = new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("客户端发来的信息为："+scanner.nextLine());
        }

        //关闭流
        scanner.close();
        printStream.close();
        server.close();
    }
}
