package org.mekenzh.release_manager.model

import org.mekenzh.release_manager.entity.SystemVersionEntity

data class SystemVersion(val version: Int, val services: Set<Service>) {
    constructor(systemVersionEntity: SystemVersionEntity) : this(
        systemVersionEntity.id ?: 0,
        systemVersionEntity.services.map { Service(it) }.toSet()
    )
}