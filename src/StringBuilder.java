import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by aria on 17-8-2.
 */
public class StringBuilder {

    public void OA365(Map map){
        try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

            File writeName = new File("src/finish.html"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writeName.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));

            /* 读入TXT文件 */
            String pathname = "src/demo.html"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
            File filename = new File(pathname); // 要读取以上路径的input。txt文件
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            String line = "";
            line = br.readLine();
            Set set = map.entrySet();
            for(Iterator iter = set.iterator(); iter.hasNext();) {
                Map.Entry entry = (Map.Entry) iter.next();
                out.write("var " + entry.getKey() + "=''\r");
                while (line != null) {
                    line = br.readLine(); // 一次读入一行数据
                    if (line != null) {
                        line = line.replaceAll("\"", "\\\\" + "\"");
                        line = line.replaceAll("variable", "\"+" + entry.getValue() + "+\"");
                        out.write(entry.getKey() + "+=\"" + line + "\"\r"); // \r\n即为换行
                    }
                }
            }
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
            System.out.println("stringbuilder完成");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
