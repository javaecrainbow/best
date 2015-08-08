package com.salk.best.lucene;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchEvent.Modifier;
import java.util.Iterator;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * @author salk
 *
 * 2015年6月14日
 */
public class IndexCreate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        //指定索引分词技术，这里使用的是标准分词  
		Analyzer anlyzer = new StandardAnalyzer(Version.LUCENE_43);
		//indexwriter 配置信息  
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(Version.LUCENE_43,anlyzer);
        //索引的打开方式，没有索引文件就新建，有就打开  
        indexWriterConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);  
        Directory directory = null;  
        IndexWriter indexWrite = null;  
        try {  
            //指定索引硬盘存储路径  
            directory = FSDirectory.open(new File("/study/index/testindex")); 
            
            //如果索引处于锁定状态，则解锁  
            if (IndexWriter.isLocked(directory)){  
                IndexWriter.unlock(directory);  
            }  
            //指定所以操作对象indexWrite  
            indexWrite = new IndexWriter(directory, indexWriterConfig);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        //创建文档一  
        Document doc1 = new Document();  
        //对name域赋值“测试标题”，存储域值信息  
        doc1.add(new TextField("name", "测试标题", Store.YES));  
        //对content域赋值“测试标题”，存储域值信息  
        doc1.add(new TextField("content", "测试内容", Store.YES));  
        try {  
            //将文档写入到索引中  
            indexWrite.addDocument(doc1);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //创建文档二  
        Document doc2 = new Document();  
        doc2.add(new TextField("name", "基于lucene的案例开发：索引数学模型", Store.YES));  
        doc2.add(new TextField("content", "lucene将一篇文档分成若干个域，每个域又分成若干个词元，通过词元在文档中的重要程度，将文档转化为N维的空间向量，通过计算两个向量之间的夹角余弦值来计算两个文档的相似程度", Store.YES));  
        try {  
            //将文档写入到索引中  
            indexWrite.addDocument(doc2);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
          
        //将indexWrite操作提交，如果不提交，之前的操作将不会保存到硬盘  
        try {  
            //这一步很消耗系统资源，所以commit操作需要有一定的策略  
            indexWrite.commit();  
            //关闭资源  
            indexWrite.close();  
            directory.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}

}
