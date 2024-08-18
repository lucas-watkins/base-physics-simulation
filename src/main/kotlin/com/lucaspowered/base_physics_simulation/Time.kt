package com.lucaspowered.base_physics_simulation

import kotlin.time.Duration
import kotlin.time.TimeSource.Monotonic.ValueTimeMark
import kotlin.time.TimeSource

class Time {
    private var time: ValueTimeMark

    init {
        time = TimeSource.Monotonic.markNow()
    }

    val secondsSinceReset: Double
        get() {
            return time.elapsedNow().inWholeMilliseconds.toDouble() / 1000
        }

    fun reset(){
        time = TimeSource.Monotonic.markNow()
    }

    operator fun plusAssign(seconds: Double){
        time -= Duration.parse("${seconds}s")
    }

    operator fun minusAssign(seconds: Double){
        // let's not have negative time (for now)
        time += if ((time.elapsedNow().inWholeMilliseconds.toDouble() / 1000) - seconds > 0)
            Duration.parse("${seconds}s") else Duration.ZERO
    }
}