package test;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.junit.jupiter.api.Test;
import org.wltea.analyzer.cfg.Configuration;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.StringReader;
import java.util.Arrays;

//import org.junit.Test;

public class TestIk {


    @Test
    public void test(){
        System.out.println("for the best");
    }

    @Test
    public void testAnalyzer() throws Exception{
//        String text = "hello world";
        String text = "80VACto305VAC/113VDCto430VDC";

        Configuration configuration = new Configuration(false, false, true);

        //创建分词对象
        Analyzer analyzer = new IKAnalyzer(configuration);
        StringReader reader = new StringReader(text);
        //分词
        TokenStream ts = analyzer.tokenStream("", reader);
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        //遍历分词数据
        ts.reset();
        while(ts.incrementToken()){
            System.out.print(term.toString() + "|");
        }
        reader.close();
        System.out.println();
    }


    @Test
    public void testBinarySearch() throws Exception{
        char[] Num_Connector = new char[]{',' , '.'};

        String input = ".0805";
        System.out.println(input.charAt(0));

        int index = Arrays.binarySearch(Num_Connector, input.charAt(0));
        System.out.println(index);
    }
}
