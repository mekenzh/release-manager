package org.mekenzh.release_manager.service

import org.mekenzh.release_manager.entity.SystemVersionEntity
import org.mekenzh.release_manager.model.SystemVersion
import org.mekenzh.release_manager.repository.SystemVersionRepository
import org.springframework.stereotype.Service

@Service
class SystemVersionService(val systemVersionRepository: SystemVersionRepository) {
    fun getSystemVersion(version: Int): SystemVersion {
        return SystemVersion(systemVersionRepository.findById(version)
            .orElseGet { SystemVersionEntity(0, mutableMapOf()) })
    }
}