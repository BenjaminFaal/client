package org.runestar.client.plugins.std.debug

import org.runestar.client.game.api.live.Game
import org.runestar.client.plugins.PluginSettings
import org.runestar.client.utils.DisposablePlugin

class GameStateLogger : DisposablePlugin<PluginSettings>() {

    override val defaultSettings = PluginSettings()

    override fun start() {
        add(Game.stateChanges.subscribe {
            ctx.logger.info(it.toString())
        })
    }
}