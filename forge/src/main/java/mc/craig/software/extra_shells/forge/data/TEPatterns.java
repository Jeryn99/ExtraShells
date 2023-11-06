package mc.craig.software.extra_shells.forge.data;

import com.google.common.base.Preconditions;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import mc.craig.software.extra_shells.ExtraShells;
import mc.craig.software.extra_shells.TEShellThemes;
import net.minecraft.ChatFormatting;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import whocraft.tardis_refined.TardisRefined;
import whocraft.tardis_refined.common.tardis.themes.ConsoleTheme;
import whocraft.tardis_refined.common.tardis.themes.ShellTheme;
import whocraft.tardis_refined.common.util.Platform;
import whocraft.tardis_refined.patterns.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class TEPatterns implements DataProvider {

    protected final DataGenerator generator;
    private static Map<ResourceLocation, ShellPatternCollection> PATTERNS = new HashMap<>();

    public TEPatterns(DataGenerator generator) {
        Preconditions.checkNotNull(generator);
        this.generator = generator;
    }

    /** To be used by child classes to add new patterns after defaults are registered*/
    protected void addPatterns(){
        addDefaultPattern(TEShellThemes.ELLEN, "default", true);
        addDefaultPattern(TEShellThemes.ENGINEERS, "default", true);
        addDefaultPattern(TEShellThemes.SEA_BLUE, "default", true);

        addDefaultPattern(TEShellThemes.MOFFAT, "default", true);
        addDefaultPattern(TEShellThemes.MOFFAT, "twelfth", true);
    }

    @Override
    public void run(CachedOutput arg) throws IOException {

        this.addPatterns();

        if (!PATTERNS.isEmpty()){
            PATTERNS.entrySet().forEach(entry -> {
                try {
                    ShellPatternCollection patternCollection = entry.getValue();


                    JsonObject currentPatternCollection = ShellPatternCollection.CODEC.encodeStart(JsonOps.INSTANCE, patternCollection).get()
                            .ifRight(right -> {
                                TardisRefined.LOGGER.error(right.message());
                            }).orThrow().getAsJsonObject();
                    Path output = getPath(patternCollection.themeId());
                    DataProvider.saveStable(arg, currentPatternCollection, output);
                } catch (Exception exception) {
                    TardisRefined.LOGGER.debug("Issue writing ShellPatternCollection {}! Error: {}", entry.getValue().themeId(), exception.getMessage());
                }
            });
        }
    }

    private static ShellPattern addDefaultPattern(ShellTheme theme, ShellPattern datagenPattern, boolean isEmmsive) {
        ResourceLocation themeId = new ResourceLocation("tardis_refined", theme.getSerializedName().toLowerCase(Locale.ENGLISH));
        ShellPattern pattern = (ShellPattern)datagenPattern.setThemeId(themeId);
        ShellPatternCollection collection;
        if (PATTERNS.containsKey(themeId)) {
            collection = PATTERNS.get(themeId);
            List<ShellPattern> currentList = new ArrayList();
            currentList.addAll(collection.patterns());
            currentList.add(pattern);
            collection.setPatterns(currentList);
            PATTERNS.replace(themeId, collection);
        } else {
            collection = (ShellPatternCollection)(new ShellPatternCollection(List.of(pattern))).setThemeId(themeId);
            PATTERNS.put(themeId, collection);
        }

        if (!Platform.isProduction()) {
            TardisRefined.LOGGER.info("Adding Shell Pattern {} for {}", pattern.id(), themeId);
        }

        return pattern;
    }

    private static ShellPattern addDefaultPattern(ShellTheme theme, String patternId, boolean hasEmissiveTexture) {
        ResourceLocation themeId = new ResourceLocation(ExtraShells.MODID, theme.getSerializedName().toLowerCase(Locale.ENGLISH));
        ShellPattern pattern = (ShellPattern)(new ShellPattern(patternId, new PatternTexture(exteriorTextureLocation(theme, patternId), hasEmissiveTexture), new PatternTexture(interiorTextureLocation(theme, patternId), hasEmissiveTexture))).setThemeId(themeId);
        return addDefaultPattern(theme, pattern, hasEmissiveTexture);
    }

    private static ResourceLocation exteriorTextureLocation(ShellTheme shellTheme, String textureName) {
        String var10003 = shellTheme.getSerializedName().toLowerCase(Locale.ENGLISH);
        return new ResourceLocation(ExtraShells.MODID, "textures/blockentity/shell/" + var10003 + "/" + textureName + ".png");
    }

    private static ResourceLocation interiorTextureLocation(ShellTheme shellTheme, String textureName) {
        String var10003 = shellTheme.getSerializedName().toLowerCase(Locale.ENGLISH);
        return new ResourceLocation(ExtraShells.MODID, "textures/blockentity/shell/" + var10003 + "/" + textureName + "_interior.png");
    }

    protected Path getPath(ResourceLocation themeId) {
        return generator.getOutputFolder().resolve("data/" + TardisRefined.MODID + "/" + TardisRefined.MODID + "/patterns/shell/" + themeId.getPath() + ".json");
    }

    @Override
    public String getName() {
        return "Shell Patterns";
    }
}
