package net.seichi915.seichi915proxycore.listener

import net.md_5.bungee.api.ChatColor
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.event.PostLoginEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler

class PostLoginListener extends Listener {
  @EventHandler
  def onPostLogin(event: PostLoginEvent): Unit =
    event.getPlayer.setTabHeader(
      TextComponent
        .fromLegacyText(s"${ChatColor.GREEN}-= seichi915Network =-"),
      TextComponent.fromLegacyText("www.seichi915.net"))
}
