package com.runesuite.client.game.live

import com.runesuite.client.base.Client.accessor
import com.runesuite.client.base.access.XClient
import io.reactivex.Observable

object Game {

    val state get() = checkNotNull(State.LOOKUP[accessor.gameState]) { accessor.gameState }

    val stateChanges: Observable<Pair<Game.State, Game.State>> = XClient.updateGameState.ENTER.map {
        state to checkNotNull(State.LOOKUP[it.arguments[0]]) { it.arguments[0] }
    }

    val cycle get() = accessor.cycle

    val plane get() = accessor.plane

    val runEnergy get() = accessor.runEnergy

    val weight get() = accessor.weight

    val windowMode get() = checkNotNull(WindowMode.LOOKUP[accessor.clientPreferences.windowMode]) { accessor.clientPreferences.windowMode }

    enum class State(val id: Int) {

        NONE(0),
        STARTING(5),
        TITLE(10),
        LOGGING_IN(20),
        LOADING(25),
        LOGGED_IN(30),
        CONNECTION_LOST(40),
        CHANGING_WORLD(45);

        companion object {
            val LOOKUP = values().associateBy { it.id }
        }
    }

    enum class WindowMode(val id: Int) {

        FIXED(1),
        RESIZABLE(2);

        companion object {
            val LOOKUP = values().associateBy { it.id }
        }
    }
}