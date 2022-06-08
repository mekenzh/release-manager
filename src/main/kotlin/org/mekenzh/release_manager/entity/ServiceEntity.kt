package org.mekenzh.release_manager.entity

import org.mekenzh.release_manager.model.Service
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "Service")
class ServiceEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: Int?,
    val name: String,
    val version: Int,
    @ManyToMany(mappedBy = "services") val systemVersionEntities: MutableSet<SystemVersionEntity>
) {
    constructor(service: Service) : this(null, service.name, service.version, mutableSetOf())
}