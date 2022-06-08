package org.mekenzh.release_manager.repository

import org.mekenzh.release_manager.entity.ServiceEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ServiceRepository : CrudRepository<ServiceEntity, Double> {

    fun findByNameAndVersion(name: String, version: Int): ServiceEntity?
}