package org.mekenzh.release_manager.service

import org.mekenzh.release_manager.entity.ServiceEntity
import org.mekenzh.release_manager.entity.SystemVersionEntity
import org.mekenzh.release_manager.model.Service
import org.mekenzh.release_manager.repository.ServiceRepository
import org.mekenzh.release_manager.repository.SystemVersionRepository
import org.springframework.stereotype.Component
import java.util.Collections

@Component
class ServiceVersionService(
    val serviceRepository: ServiceRepository,
    val systemVersionRepository: SystemVersionRepository
) {
    fun calculateSystemVersion(service: Service): Int {
        val serviceEntity =
            serviceRepository.findByNameAndVersion(service.name, service.version)
                ?: serviceRepository.save(ServiceEntity(service))

        return if (serviceEntity.systemVersionEntities.isEmpty()) {
            val prevSystemVersion = systemVersionRepository.findFirstByOrderByIdDesc()
            val services = mutableSetOf<ServiceEntity>()
            prevSystemVersion?.services?.let { services.addAll(it) }
            services.add(serviceEntity)
            serviceRepository.save(serviceEntity)
            val systemVersionEntity = SystemVersionEntity(null, services)
            systemVersionRepository.save(systemVersionEntity).id ?: 0
        } else {
            Collections.max(serviceEntity.systemVersionEntities).id ?: 0
        }

    }
}