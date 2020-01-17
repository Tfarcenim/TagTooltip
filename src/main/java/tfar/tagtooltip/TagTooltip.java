package tfar.tagtooltip;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Set;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TagTooltip.MODID)
public class TagTooltip {
  public static final String MODID = "tagtooltip";

  @Mod.EventBusSubscriber(value = Dist.CLIENT)
  public static class TooltipEvent {
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent e) {

      if(!Screen.hasControlDown())return;
      List<ITextComponent> tooltips = e.getToolTip();
      Item item = e.getItemStack().getItem();
      Set<ResourceLocation> taglist = item.getTags();
      for (ResourceLocation entry: taglist){
          tooltips.add(new StringTextComponent(entry.toString()).applyTextStyle(TextFormatting.DARK_GRAY));
      }
    }
  }
}