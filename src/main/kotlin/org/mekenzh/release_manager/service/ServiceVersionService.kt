package org.mekenzh.release_manager.service

import org.mekenzh.release_manager.entity.ServiceEntity
import org.mekenzh.release_manager.entity.SystemVersionEntity
import org.mekenzh.release_manager.model.Service
import org.mekenzh.release_manager.repository.ServiceRepository
import org.mekenzh.release_manager.repository.SystemVersionRepository
import org.mekenzh.release_manager.utils.SYSTEM_VERSION_STUB
import org.springframework.stereotype.Component

@Component
class ServiceVersionService(
    val serviceRepository: ServiceRepository,
    val systemVersionRepository: SystemVersionRepository
) {
    fun calculateSystemVersion(service: Service): Int {
        val serviceEntity =
            serviceRepository.findByNameAndVersion(service.name, service.version)
                .orElseGet { serviceRepository.save(ServiceEntity(service)) }

        val currentSystemVersion = systemVersionRepository.findFirstByOrderByVersionDesc()
            .orElseGet { SYSTEM_VERSION_STUB }
        val services = currentSystemVersion.services

        val systemVersion = if (services.contains(service.name)) {
            if (services[service.name]!!.version != service.version) {
                val newServices = mutableMapOf<String, ServiceEntity>()
                newServices.putAll(services)
                newServices[service.name] = serviceEntity
                systemVersionRepository.save(SystemVersionEntity(null, newServices, currentSystemVersion.version + 1))
            } else {
                currentSystemVersion
            }
        } else {
            val newServices = mutableMapOf<String, ServiceEntity>()
            newServices.putAll(services)
            newServices[service.name] = serviceEntity
            systemVersionRepository.save(SystemVersionEntity(null, newServices, currentSystemVersion.version + 1))
        }
        return systemVersion.version

    }
}