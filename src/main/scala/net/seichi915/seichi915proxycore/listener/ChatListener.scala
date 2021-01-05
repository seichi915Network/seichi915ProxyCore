package net.seichi915.seichi915proxycore.listener

import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.event.ChatEvent
import net.md_5.bungee.api.plugin.Listener
import net.md_5.bungee.event.EventHandler
import net.seichi915.seichi915bungeelogger.Seichi915BungeeLogger

class ChatListener extends Listener {
  @EventHandler
  def onChat(event: ChatEvent): Unit =
    if (event.isProxyCommand)
      event.getSender match {
        case proxiedPlayer: ProxiedPlayer =>
          Seichi915BungeeLogger.getAPI.logProxyCommand(proxiedPlayer.getServer,
                                                       proxiedPlayer,
                                                       event.getMessage)
        case _ =>
      }
}
