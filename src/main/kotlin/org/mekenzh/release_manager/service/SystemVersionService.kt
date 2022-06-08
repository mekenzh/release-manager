package org.mekenzh.release_manager.service

import org.mekenzh.release_manager.model.SystemVersion
import org.mekenzh.release_manager.repository.SystemVersionRepository
import org.mekenzh.release_manager.utils.SYSTEM_VERSION_STUB
import org.springframework.stereotype.Service

@Service
class SystemVersionService(val systemVersionRepository: SystemVersionRepository) {
    fun getSystemVersion(version: Int): SystemVersion {
        return SystemVersion(systemVersionRepository.findByVersion(version)
            .orElseGet { SYSTEM_VERSION_STUB })
    }
}