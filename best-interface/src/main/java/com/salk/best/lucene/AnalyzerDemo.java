package com.salk.best.lucene;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cjk.CJKAnalyzer;
import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import com.google.common.collect.Lists;

/**
 * @author salk
 *
 *
 *
 *
 * 2015年6月14日
 */
public class AnalyzerDemo {

	public static void main(String[] args) throws IOException {
		 //需要处理的测试字符串  
        String str = "这是一个分词器测试程序，希望大家继续关注我的个人系列博客：基于Lucene的案例开发，这里加一点带空格的标签 LUCENE java 分词器";  
        //StandardAnalyzer标准分词器，如果用来处理中文，和ChineseAnalyzer有一样的效果，这也许就是之后的版本弃用ChineseAnalyzer的一个原因。用StandardAnalyzer处理英文效果还不错，
        //但是对中文的处理只是将其分成单个汉字，并不存在任何语义或词性，如果实在没有其他的分词器，用StandardAnalyzer来处理中文还是可以的
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_43);  
        //标准分词器，如果用来处理中文，和ChineseAnalyzer有一样的效果，这也许就是之后的版本弃用ChineseAnalyzer的一个原因  
        //第三方中文分词器，有下面2中构造方法。  
        //analyzer = new IKAnalyzer();  
        //analyzer = new IKAnalyzer(false);  
        //analyzer = new IKAnalyzer(true);  
        //空格分词器，对字符串不做如何处理  
        /**
         *  WhitespaceAnalyzer空格分词，这个分词技术就相当于按照空格简单的切分字符串，对形成的子串不做其他的操作，结果同string.split(" ")的结果类似
         *  这种分词技术也许你会绝对没有太大的作用，它对输入的字符串几乎没有做太多的处理，对语句的处理结果也不是太好，如果这样想就错了，下面就简单的想一下这个问题，这篇博客的标签是 lucene、java、分词器，那这三个词在索引中又该如何的存储，
         *  	采用何种分词技术呢？这里不做任何解答，自己思考下，在以后的小说案例中会对标签这个域提出具体的解决方案。
         */
        Analyzer analyzer2 = new WhitespaceAnalyzer(Version.LUCENE_43);  
        //简单分词器，一段一段话进行分词  
        /**
         * SimpleAnalyzer简单分词器，与其说是一段话进行分词，不如说是一句话就是一个词，遇到标点、空格等，就将其之前的内容当作一个词。
         * 
         */
        Analyzer analyzer3 = new SimpleAnalyzer(Version.LUCENE_43);  
        //二分法分词器，这个分词方式是正向退一分词(二分法分词)，同一个字会和它的左边和右边组合成一个次，每个人出现两次，除了首字和末字  
        /**
         * CJKAnalyzer是二分法分词器，这个分词方式是正向退一分词(二分法分词)，同一个字会和它的左边和右边组合成一个次，每个人出现两次，除了首字和末字，
         * 也就是说会将任何两个相邻的汉字当作是一个词，这种分词技术会产生大量的无用词组。
         */
        Analyzer analyzer4 = new CJKAnalyzer(Version.LUCENE_43);  
        //关键字分词器，把处理的字符串当作一个整体 
        /**
         * KeywordAnalyzer关键字分词器，把处理的字符串当作一个整体，这个分词器，在lucene之前的版本中或许还有点作用，但最近的几个版本中，
         * Lucene对域的类型做了细分，它的作用就不是太大了，不做在luke中，还是相当重要的。
         */
        Analyzer analyzer5 = new KeywordAnalyzer();  
        //被忽略的词分词器  
        /**
         * StopAnalyzer被忽略的词分词器，被忽略的词就是在分词结果中，被丢弃的字符串，如标点、空格等。
         */
        Analyzer analyzer6 = new StopAnalyzer(Version.LUCENE_43);  
        //Lists.newArrayList(new Analyzer[] {analyzer3，analyzer4，analyzer5，analyzer6})；
        ArrayList<Analyzer> analyzers = Lists.newArrayList(analyzer,analyzer2,analyzer3,analyzer4,analyzer5,analyzer6);
        //ArrayList<Analyzer> analyzers = Lists.newArrayList(analyzer2);
        //使用分词器处理测试字符串  
       
        //输出分词器和处理结果  
        for (Analyzer ana : analyzers) {
            System.out.println(ana.getClass());  
            StringReader reader = new StringReader(str);  

        	 TokenStream  tokenStream  = ana.tokenStream("", reader);  
             tokenStream.reset();  
             CharTermAttribute  term = tokenStream.getAttribute(CharTermAttribute.class);  
             int l = 0;  
        while(tokenStream.incrementToken()){    
            System.out.print(term.toString() + "|");  
            l += term.toString().length();  
            //如果一行输出的字数大于30，就换行输出  
            if (l > 30) {  
                System.out.println();  
                l = 0;  
            }  
        }  
        
        System.out.println();  
	}
	}
}
