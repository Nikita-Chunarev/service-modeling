package ru.psu.eat.servicemodeling.services

import org.springframework.http.ResponseEntity
import ru.psu.eat.servicemodeling.model.CProcess
import java.util.*

interface IServiceProcesses {
    fun getAll(
    ) : Iterable<CProcess>
    fun getById(
        id : UUID
    ) : ResponseEntity<CProcess>
    fun getByName(
        name : String
    ) : Iterable<CProcess>
    fun save(
        item : CProcess
    )
    fun delete(
        item : CProcess
    )
    fun deleteById(
        id : UUID
    ) : ResponseEntity<String>
}