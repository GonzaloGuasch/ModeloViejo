package grupoSinNombre.persistencia

import grupoSinNombre.model.BookApp
import org.springframework.data.repository.CrudRepository

interface BookAppRepository: CrudRepository<BookApp, Long> {

}