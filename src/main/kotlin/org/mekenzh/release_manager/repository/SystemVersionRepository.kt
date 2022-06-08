package org.mekenzh.release_manager.repository

import org.mekenzh.release_manager.entity.SystemVersionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SystemVersionRepository:CrudRepository<SystemVersionEntity, Int> {
    fun findFirstByOrderByIdDesc(): SystemVersionEntity?
}