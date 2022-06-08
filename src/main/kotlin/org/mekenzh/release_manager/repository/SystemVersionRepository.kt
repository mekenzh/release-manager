package org.mekenzh.release_manager.repository

import org.mekenzh.release_manager.entity.SystemVersionEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SystemVersionRepository:CrudRepository<SystemVersionEntity, Int> {
    fun findFirstByOrderByVersionDesc(): Optional<SystemVersionEntity>
    fun findByVersion(version: Int): Optional<SystemVersionEntity>
}