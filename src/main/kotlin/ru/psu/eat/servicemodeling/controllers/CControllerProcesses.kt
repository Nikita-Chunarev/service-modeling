package ru.psu.eat.servicemodeling.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.psu.eat.servicemodeling.model.CProcess
import ru.psu.eat.servicemodeling.services.IServiceProcesses
import java.util.*

@RestController
@RequestMapping("/processes")
class CControllerProcesses(
  val serviceProcesses : IServiceProcesses
)
{
    @GetMapping
    fun getAll() : Iterable<CProcess>
    {
        return serviceProcesses.getAll()
    }

    @GetMapping(
        params = ["id"]
    )
    fun getById(
        @RequestParam id : UUID
    ) : ResponseEntity<CProcess>
    {
        return serviceProcesses.getById(id)
    }

    @GetMapping(
        params = ["name"]
    )
    fun getByName(
        @RequestParam name : String
    ) : Iterable<CProcess>
    {
        return serviceProcesses.getByName(name)
    }

    @PostMapping
    fun save(
        @RequestBody item : CProcess
    )
    {
        serviceProcesses.save(item)
    }

    @DeleteMapping
    fun delete(
        @RequestBody item : CProcess
    )
    {
        serviceProcesses.delete(item)
    }

    @DeleteMapping(
        params = ["id"]
    )
    fun deleteById(
        @RequestParam id : UUID
    ) : ResponseEntity<String>
    {
        return serviceProcesses.deleteById(id)
    }
}