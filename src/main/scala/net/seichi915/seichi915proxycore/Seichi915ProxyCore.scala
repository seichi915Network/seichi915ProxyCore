package net.seichi915.seichi915proxycore

import net.md_5.bungee.api.plugin.Plugin
import net.seichi915.seichi915proxycore.command._
import net.seichi915.seichi915proxycore.listener._

object Seichi915ProxyCore {
  var instance: Seichi915ProxyCore = _
}

class Seichi915ProxyCore extends Plugin {
  Seichi915ProxyCore.instance = this

  override def onEnable(): Unit = {
    Seq(
      new ChatListener,
      new PostLoginListener
    ).foreach(getProxy.getPluginManager.registerListener(this, _))
    Seq(
      new HubCommand
    ).foreach(getProxy.getPluginManager.registerCommand(this, _))

    getLogger.info("seichi915ProxyCoreが有効になりました。")
  }

  override def onDisable(): Unit = {
    getLogger.info("seichi915ProxyCoreが無効になりました。")
  }
}
