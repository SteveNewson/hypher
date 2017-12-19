package net.bitbadger.hypher.plugin.language;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputDirectories;
import org.gradle.api.tasks.TaskAction;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class GeneratorTask extends DefaultTask {

  @OutputDirectories
  private String outputDirectory = "";

  @Input
  private String inputDirectory = "";

  @TaskAction
  public void generate() {
    try {
      Files.list(Paths.get(inputDirectory))
          .filter(f -> f.toString().endsWith(".json"))
          .forEach(f -> convert(f, outputDirectory));
    } catch (IOException e) {
      throw new IllegalStateException("Failed to generate languages from directory " + inputDirectory, e);
    }
  }

  public void setOutputDirectory(String outputDirectory) {
    this.outputDirectory = outputDirectory;
  }

  public void setInputDirectory(String inputDirectory) {
    this.inputDirectory = inputDirectory;
  }

  private void convert(Path sourceFile, String outputDirectory) {
    final Gson gson = new GsonBuilder().create();

    try (BufferedReader reader = Files.newBufferedReader(sourceFile)) {
      final JsonLanguageFile jsonLanguageFile = gson.fromJson(reader, JsonLanguageFile.class);

      final Properties properties = new Properties();
      properties.setProperty("leftmin", Integer.toString(jsonLanguageFile.getLeftmin()));
      properties.setProperty("rightmin", Integer.toString(jsonLanguageFile.getRightmin()));
      properties.setProperty("id", jsonLanguageFile.getId());
      final List<Integer> lengths = new ArrayList<>(jsonLanguageFile.getPatterns().keySet());
      Collections.sort(lengths);
      for (Integer length : lengths) {
        properties.setProperty("patterns." + length, jsonLanguageFile.getPatterns().get(length));
      }

      final String outputFilename = sourceFile.getFileName().toString().replaceAll("\\.json$", ".properties");

      final File file = new File(outputDirectory, outputFilename);
      try {
        file.getParentFile().mkdirs();
        file.createNewFile();
        try (final FileOutputStream fileOutputStream = new FileOutputStream(file)) {
          properties.store(fileOutputStream, "");
        }
      } catch (IOException e) {
        throw new IllegalArgumentException("Failed to create the output file " + file, e);
      }

    } catch (IOException e) {
      throw new IllegalArgumentException("Failed to read source file " + sourceFile, e);
    }

  }
}
