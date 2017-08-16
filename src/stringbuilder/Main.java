package stringbuilder;

import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map map=new HashMap<String,String>();
        map.put("url","http://baidu.com");
        map.put("btn","url");
        new StringBuilder().OA365(map,"rtn");
    }
}
