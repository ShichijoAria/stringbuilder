package purifyhtml;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
       // new PurifyHtml().purify();
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=format.parse("2017-8-8 0:0:0");
        System.out.println(date.getTime());
    }
}
