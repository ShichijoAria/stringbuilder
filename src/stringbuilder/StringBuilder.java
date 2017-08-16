package stringbuilder;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by aria on 17-8-2.
 */
public class StringBuilder {

    public void OA365(Map map,String name){//name 拼接后字符串变量名
        try {
            File writeName = new File("src/stringbuilder/finish.html"); // 相对路径，如果没有则要建立一个新的output。txt文件
            writeName.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writeName));

            //读取要拼接的代码
            String pathname = "src/stringbuilder/demo.html"; //读取路径
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(
                    new FileInputStream(filename)); // 建立一个输入流对象reader
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
            Set set = map.entrySet();
            out.write("var "+name+" ='';\r");
            String line = "";
            line = br.readLine();
            if (line!=null){
                out.write(name+"+=\""+line+"\";\r");
            }
            while (line != null) {
                line = br.readLine(); // 一次读入一行数据
                if (line != null) {
                    line = line.replaceAll("\"", "\\\\" + "\"");
                    for(Iterator iter = set.iterator(); iter.hasNext();) {
                        Map.Entry entry = (Map.Entry) iter.next();
                        line = line.replaceAll((String) entry.getKey(), "\"+" + entry.getValue() + "+\"");
                    }
                    out.write(name+"+=\"" + line + "\";\r"); // \r\n即为换行
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
