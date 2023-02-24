package ru.psu.eat.servicemodeling.services

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import ru.psu.eat.servicemodeling.model.CProcess
import ru.psu.eat.servicemodeling.repositories.IRepositoryProcesses
import java.util.*

@Service
class CServiceProcesses(
    val repositoryProcesses : IRepositoryProcesses
) : IServiceProcesses
{
    override fun getAll(): Iterable<CProcess> {
        return repositoryProcesses.findAll()
    }

    override fun getById(id: UUID): ResponseEntity<CProcess> {
        return repositoryProcesses.findById(id)
            .map {item -> ResponseEntity.ok(item)}
            .orElse(ResponseEntity.notFound().build())
    }

    override fun getByName(name: String): Iterable<CProcess> {
        return repositoryProcesses.findByName(name)
    }

    override fun save(item: CProcess) {
        repositoryProcesses.save(item)
    }

    override fun delete(item: CProcess) {
        repositoryProcesses.delete(item)
    }

    override fun deleteById(id: UUID): ResponseEntity<String> {
        return repositoryProcesses.findById(id)
            .map { process ->
                repositoryProcesses.delete(process)
                ResponseEntity.ok(process.id.toString())
            }
            .orElse(ResponseEntity.notFound().build())
    }
}