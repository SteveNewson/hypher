package net.bitbadger.hypher.plugin.language;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class GeneratorPlugin implements Plugin<Project> {

  @Override
  public void apply(Project project) {
    project.getPlugins().apply("base");
    project.getTasks().create("generate", GeneratorTask.class);
  }
}