package ru.psu.eat.servicemodeling.model

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "processes")
data class CProcess(
    @Id
    var id : UUID?
    = null,

    @Column
    var name : String
    = ""
)
