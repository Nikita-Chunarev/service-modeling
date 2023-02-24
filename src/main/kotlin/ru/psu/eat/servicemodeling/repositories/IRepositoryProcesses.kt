package ru.psu.eat.servicemodeling.repositories

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.psu.eat.servicemodeling.model.CProcess
import java.util.*

@Repository
interface IRepositoryProcesses : CrudRepository<CProcess, UUID>{
    fun findByName(
        name : String
    ) : List<CProcess>
}