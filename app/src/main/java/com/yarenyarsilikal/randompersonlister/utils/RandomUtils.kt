package com.yarenyarsilikal.randompersonlister.utils

import kotlin.random.Random


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
object RandomUtils {

    fun generateRandomInt(range: ClosedRange<Int>): Int =
        Random.nextInt(range.start, range.endInclusive)

    fun generateRandomDouble(range: ClosedRange<Double>): Double =
        Random.nextDouble(range.start, range.endInclusive)

    fun roll(probability: Double): Boolean {
        val random = Random.nextDouble(0.0, 1.0)
        return random <= probability
    }
}