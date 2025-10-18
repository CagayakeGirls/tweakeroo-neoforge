<center><div align="center">

<img height="100" src="src/main/resources/icon.png" width="100"/>

# Tweakerge for NeoForge

Tweakeroo unofficial NeoForge port.

<img alt="neoforge" height="56" src="https://raw.githubusercontent.com/KessokuTeaTime/badges-extra/main/assets/cozy/supported/neoforge_vector.svg">

<a href="https://modrinth.com/mod/tweakerge">
<img alt="modrinth" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg">
</a>
<a href="https://www.curseforge.com/minecraft/mc-mods/tweakerge">
<img alt="curseforge" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/curseforge_vector.svg">
</a>

</div></center>

Tweakerge is a client-side Minecraft mod using NeoForge. It adds a selection of miscellaneous, configurable, client-side tweaks to the game. Some examples of these are the "flexible block placement" tweak and the "fast block placement" tweak. For more information and the downloads (compiled builds), see

[Original Repo Readme](Original-README.md)

## Development

This mod use modrinth maven.

```gradle
repositories {
    maven { url 'https://api.modrinth.com/maven' }
}

dependencies {
    modImplementation "maven.modrinth:tweakerge:${tweakerge_version}"
}
```

or use KessokuTeaTime maven (only 0.4.0 and above)

```gradle
repositories {
    maven { url 'https://maven.kessokuteatime.work/releases' }
}

dependencies {
    modImplementation "team.cagayakegirls.tweakerge:tweakerge:${tweakerge_version}"
}
```

> Note: "${tweakerge_version}" can be found in [Modrinth](https://modrinth.com/mod/tweakerge)

## Compiling
- Clone the repository
- Open a command prompt/terminal to the repository directory
- run 'gradlew build'
- The built jar file will be in build/libs/

## Credits
- [maruohon/tweakeroo](https://github.com/maruohon/tweakeroo)
- [sakura-ryoko/tweakeroo](https://github.com/sakura-ryoko/tweakeroo)
