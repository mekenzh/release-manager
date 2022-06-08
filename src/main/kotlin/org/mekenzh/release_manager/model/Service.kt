package org.mekenzh.release_manager.model

import org.mekenzh.release_manager.entity.ServiceEntity

data class Service(val name: String, val version: Int) {
    constructor(serviceEntity: ServiceEntity) : this(serviceEntity.name, serviceEntity.version)
}