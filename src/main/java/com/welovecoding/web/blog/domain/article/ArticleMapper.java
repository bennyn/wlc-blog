package com.welovecoding.web.blog.domain.article;

import com.welovecoding.web.blog.util.FileUtility;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArticleMapper {

  public void mapArticle(String repositoryPath, String filePath) {
    Path path = Paths.get(repositoryPath, filePath);
    String absolutePath = path.toAbsolutePath().toString();

    if (absolutePath.endsWith(".md")) {

    }
  }

  private void parseMarkdownArticle(String absolutePath) {

  }

}
