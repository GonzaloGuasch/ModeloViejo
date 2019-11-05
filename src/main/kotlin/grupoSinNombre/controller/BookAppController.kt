package grupoSinNombre.controller

import grupoSinNombre.service.BookAppService
import grupoSinNombre.service.BookService
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins= ["http://localhost:3000"])
@RestController
@RequestMapping("bookApp")
class BookAppController(private val bookAppService: BookAppService) {

    @RequestMapping
    fun index(): String = "Chequeo que el controller funcione correctamente"

    @PostMapping
    fun registerUser(@RequestBody userBody: Object) {
        bookAppService.registerUser(userBody)
    }
}
