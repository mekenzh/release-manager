package org.mekenzh.release_manager.model

import org.mekenzh.release_manager.entity.SystemVersionEntity

data class SystemVersion(val version: Int, val services: Set<Service>) {
    constructor(systemVersionEntity: SystemVersionEntity) : this(
        systemVersionEntity.version,
        systemVersionEntity.services.map { Service(it.value) }.toSet()
    )
}