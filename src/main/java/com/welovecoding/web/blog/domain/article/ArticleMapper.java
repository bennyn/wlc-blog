package com.welovecoding.web.blog.domain.article;

import com.welovecoding.web.blog.markdown.meta.BufferedMarkdownMetaParser;
import com.welovecoding.web.blog.markdown.meta.MarkdownMetaData;
import static com.welovecoding.web.blog.markdown.meta.MarkdownMetaParser.META_END;
import static com.welovecoding.web.blog.markdown.meta.MarkdownMetaParser.META_START;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.markdown4j.Markdown4jProcessor;

public class ArticleMapper {

  private static final Logger LOG = Logger.getLogger(ArticleMapper.class.getName());
  private Markdown4jProcessor markdown4jProcessor = new Markdown4jProcessor();

  public void mapArticleFromMarkdownFile(String absolutePath) {

    if (absolutePath.endsWith(".md")) {
      File markdownFile = new File(absolutePath);
      parseMarkdownFile(markdownFile);
    }
  }

  private void parseMarkdownFile(File markdownFile) {
    BufferedMarkdownMetaParser metaParser = new BufferedMarkdownMetaParser();
    boolean readMetaData = false;

    StringBuilder content = new StringBuilder();
    String line;

    try (
            FileInputStream fis = new FileInputStream(markdownFile);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");) {

      BufferedReader reader = new BufferedReader(isr);

      while ((line = reader.readLine()) != null) {
        if (line.equals(META_START)) {
          readMetaData = true;
        }

        if (readMetaData) {
          metaParser.parse(line);
        } else {
          String markDownLine = markdown4jProcessor.process(line);
          content.append(markDownLine);
        }

        if (line.equals(META_END)) {
          readMetaData = false;
        }
      }

      // Assign data
      Article article = new Article();
      Map<String, MarkdownMetaData> metaData = metaParser.getData();

      MarkdownMetaData title = metaData.get("title");
      if (title != null) {
        article.setTitle(title.getValues()[0]);
      }

      MarkdownMetaData description = metaData.get("description");
      if (description != null) {
        article.setDescription(description.getValues()[0]);
      }

      MarkdownMetaData tags = metaData.get("tags");
      if (tags != null) {
        article.setTags(Arrays.asList(tags.getValues()));
      }

      article.setHtml(content.toString());

      // Demo
      System.out.println(article.toString());

    } catch (FileNotFoundException | UnsupportedEncodingException ex) {
      LOG.log(Level.SEVERE, "Error while opening the file: {0}", ex.getMessage());
    } catch (IOException ex) {
      LOG.log(Level.SEVERE, "Error while reading the file: {0}", ex.getMessage());
    }

  }

}
