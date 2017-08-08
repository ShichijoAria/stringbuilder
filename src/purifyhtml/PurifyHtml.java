package purifyhtml;

import java.io.*;

public class PurifyHtml {

    public void purify() throws IOException {
        File writeName = new File("src/purifyhtml/finish.html"); // 相对路径，如果没有则要建立一个新的output。txt文件
        writeName.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writeName));

            /* 读入TXT文件 */
        String pathname = "src/purifyhtml/demo.html"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
        File filename = new File(pathname); // 要读取以上路径的input。txt文件
        InputStreamReader reader = new InputStreamReader(
                new FileInputStream(filename)); // 建立一个输入流对象reader
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line = "";
        line = br.readLine();
        line=line.replaceAll(" class=\"[a-zA-Z\\s]*\"","");
        line=line.replaceAll(" valign=\"[a-zA-Z\\s]*\"","");
        out.write(line+"\n");
        while (line != null) {
            line = br.readLine(); // 一次读入一行数据
            if (line != null) {
                line=line.replaceAll(" class=\"[a-zA-Z\\s]*\"","");
                line=line.replaceAll(" valign=\"[a-zA-Z\\s]*\"","");
                out.write(line+"\n");
            }
        }
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
        System.out.println("stringbuilder完成");
    }

}
