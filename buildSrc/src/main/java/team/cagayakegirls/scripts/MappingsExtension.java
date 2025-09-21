package team.cagayakegirls.scripts;

import net.fabricmc.loom.LoomGradleExtension;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.dsl.DependencyHandler;

import javax.inject.Inject;

public abstract class MappingsExtension {
    @Inject
    protected abstract Project getProject();

    /**
     * Yarn mappings v1 only support fabric.
     *
     * @param version yarn mappings version
     * @param isV1 use yarn mappings v1? NOTE: V1 ONLY SUPPORT FABRIC
     * @return yarn mappings
     */
    public Dependency yarn(String version, boolean isV1) {
        Project project = this.getProject();
        DependencyHandler dependencies = project.getDependencies();
        LoomGradleExtension loomExtension = LoomGradleExtension.get(project);

        if (isV1 == true && !loomExtension.isForge() && !loomExtension.isNeoForge()) {
            return dependencies.create("net.fabricmc:yarn:"  + version + ":v1");
        }

        return dependencies.create("net.fabricmc:yarn:"  + version + ":v2");
    }

    /**
     * Yarn mappings patch only support (Neo)Forge, because (Neo)Forge patches broken with yarn mappings.
     * Support 1.20.5 and above NeoForge version, but MinecraftForge version only support 1.20.3~1.20.4.
     *
     * @param yarnVersion yarn mappings version
     * @param patchVersion yarn mappings patch version
     * @return yarn-mappings-patch layered yarn mappings
     */
    public Dependency yarnWithPatch(String yarnVersion, String patchVersion) {
        Project project = this.getProject();
        LoomGradleExtension loomExtension = LoomGradleExtension.get(project);

        return loomExtension.layered(builder -> {
            builder.mappings("net.fabricmc:yarn:"  + yarnVersion + ":v2");
            if (loomExtension.isNeoForge()) {
                builder.mappings("dev.architectury:yarn-mappings-patch-neoforge:" + patchVersion);
            } else if (loomExtension.isForge()) {
                builder.mappings("dev.architectury:yarn-mappings-patch-forge:" + patchVersion);
            }
        });
    }

    /**
     * Parchment mappings only support with mojmap (official mappings).
     *
     * @param mcVersion parchment mappings supported minecraft version
     * @param mappingsVersion parchment mappings version
     * @return parchment mappings layered official mappings
     */
    public Dependency parchment(String mcVersion, String mappingsVersion) {
        Project project = this.getProject();
        LoomGradleExtension loomExtension = LoomGradleExtension.get(project);

        return loomExtension.layered(builder -> {
            builder.officialMojangMappings();
            builder.parchment("org.parchmentmc.data:parchment-" + mcVersion + ":" + mappingsVersion + "@zip");
        });
    }
}
