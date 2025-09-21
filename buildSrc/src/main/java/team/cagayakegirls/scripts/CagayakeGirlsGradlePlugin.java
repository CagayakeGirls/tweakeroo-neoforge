package team.cagayakegirls.scripts;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.dsl.RepositoryHandler;
import org.gradle.api.initialization.Settings;
import org.gradle.api.invocation.Gradle;
import org.gradle.api.plugins.PluginAware;

public final class CagayakeGirlsGradlePlugin implements Plugin<PluginAware> {
    @Override
    public void apply(PluginAware target) {
        switch (target) {
            case Settings settings -> {
                additionalRepositories(settings.getDependencyResolutionManagement().getRepositories());

                settings.getGradle().getPluginManager().apply(CagayakeGirlsGradlePlugin.class);
            }
            case Project project -> {
                project.getExtensions().create("forgifiedFabricApi", ForgifiedFabricApiExtension.class);
                //project.getExtensions().create("cagayakeGirls", CagayakeGirlsGradleExtension.class);
                project.getExtensions().create("extraMappings", MappingsExtension.class);

                additionalRepositories(project.getRepositories());
            }
            case Gradle gradle -> {
                return;
            }
            default ->
                    throw new IllegalArgumentException("Expected target to be a Project or Settings, but was a " + target.getClass());
        }
    }

    public void additionalRepositories(RepositoryHandler repositories) {
        repositories.maven(repo -> {
            repo.setName("NeoForge");
            repo.setUrl("https://maven.neoforged.net/releases/");
        });
        repositories.maven(repo -> {
            repo.setName("KTTMavenSnapshots");
            repo.setUrl("https://maven.kessokuteatime.work/snapshots/");
        });
        repositories.maven(repo -> {
            repo.setName("KTTMavenReleases");
            repo.setUrl("https://maven.kessokuteatime.work/releases/");
        });
    }
}
