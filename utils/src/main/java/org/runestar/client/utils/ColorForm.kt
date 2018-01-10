package org.runestar.client.utils

import java.awt.Color
import java.util.function.Supplier

data class ColorForm(
        val alpha: Int = 255,
        val red: Int = 255,
        val green: Int = 255,
        val blue: Int = 255
) : Supplier<Color> {

    @Transient
    private val value = Color(red, green, blue, alpha)

    override fun get() = value
}