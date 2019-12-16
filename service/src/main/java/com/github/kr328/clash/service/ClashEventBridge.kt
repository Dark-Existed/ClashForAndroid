package com.github.kr328.clash.service

import com.github.kr328.clash.core.event.*

class ClashEventBridge(val service: ClashService): ClashProfileService.Master,
    ClashEventService.Master, ClashEventPoll.Master {
    val eventService: ClashEventService = ClashEventService(this)

    override fun preformProfileChanged() {
        eventService.performProfileChangedEvent(ProfileChangedEvent())
    }

    override fun acquireEvent(event: Int) {
        service.acquireEvent(event)
    }

    override fun releaseEvent(event: Int) {
        service.releaseEvent(event)
    }

    fun onProcessChanged(event: ProcessEvent) {
        eventService.performProcessEvent(event)
    }

    override fun onLogEvent(event: LogEvent) {
        eventService.performLogEvent(event)
    }

    override fun onTrafficEvent(event: TrafficEvent) {
        eventService.performSpeedEvent(event)
    }

    override fun onBandwidthEvent(event: BandwidthEvent) {
        eventService.performBandwidthEvent(event)
    }
}