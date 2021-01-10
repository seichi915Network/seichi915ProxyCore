package net.seichi915.seichi915proxycore.command

import net.md_5.bungee.api.CommandSender
import net.md_5.bungee.api.chat.TextComponent
import net.md_5.bungee.api.connection.ProxiedPlayer
import net.md_5.bungee.api.plugin.{Command, TabExecutor}
import net.seichi915.seichi915proxycore.Seichi915ProxyCore
import net.seichi915.seichi915proxycore.util.Implicits._

import java.lang
import java.util.Collections

class HubCommand extends Command("hub") with TabExecutor {
  override def execute(sender: CommandSender, args: Array[String]): Unit = {
    if (!sender.isInstanceOf[ProxiedPlayer]) {
      sender.sendMessage(
        TextComponent
          .fromLegacyText("このコマンドはプレイヤーのみが実行できます。".toErrorMessage): _*)
      return
    }
    if (args.length != 0) {
      sender.sendMessage(
        TextComponent.fromLegacyText("コマンドの使用法が間違っています。".toErrorMessage): _*)
      return
    }
    val player = sender.asInstanceOf[ProxiedPlayer]
    player.connect(Seichi915ProxyCore.instance.getProxy.getServerInfo("hub"))
  }

  override def onTabComplete(sender: CommandSender,
                             args: Array[String]): lang.Iterable[String] =
    Collections.emptyList()
}
