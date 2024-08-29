package com.pgd.harrypotter.data.entity.mapper

interface Mapper<Entity, Domain> {
    fun map(data: Entity): Domain
}
