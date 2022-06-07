package org.mekenzh.release_manager.controller

import org.mekenzh.release_manager.model.ServiceVersion
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class VersionController {
    @PostMapping("deploy")
    fun deploy(serviceVersion: ServiceVersion): Int {
        return 1
    }
}