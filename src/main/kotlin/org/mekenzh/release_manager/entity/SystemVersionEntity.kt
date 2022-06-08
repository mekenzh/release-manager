package org.mekenzh.release_manager.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.MapKey

@Entity
class SystemVersionEntity(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: Int?,
    @ManyToMany @JoinTable(
        name = "system_service",
        joinColumns = [JoinColumn(name = "system_version_id")],
        inverseJoinColumns = [JoinColumn(name = "service_id")]
    )
    @MapKey(name="name")
    val services: MutableMap<String ,ServiceEntity>
) : Comparable<SystemVersionEntity> {
    override fun compareTo(other: SystemVersionEntity): Int {
        val thisId = id ?: 0
        val otherId = other.id ?: 0
        return thisId.compareTo(otherId)
    }
}