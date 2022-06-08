package org.mekenzh.release_manager.controller

import org.mekenzh.release_manager.model.Service
import org.mekenzh.release_manager.model.SystemVersion
import org.mekenzh.release_manager.service.ServiceVersionService
import org.mekenzh.release_manager.service.SystemVersionService
import org.springframework.web.bind.annotation.*

@RestController
class ServiceVersionController(
    val serviceVersionService: ServiceVersionService,
    val systemVersionService: SystemVersionService
) {
    @PostMapping("deploy")
    fun deploy(@RequestBody service: Service): Int {
        return serviceVersionService.calculateSystemVersion(service)
    }

    @GetMapping("services")
    fun getSystemVersion(@RequestParam systemVersion: Int): SystemVersion {
        return systemVersionService.getSystemVersion(systemVersion)
    }

}