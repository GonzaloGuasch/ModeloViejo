package grupoSinNombere

import grupoSinNombre.BooksApplication
import grupoSinNombre.controller.BookController
import grupoSinNombre.model.Book
import grupoSinNombre.persistencia.BookRepository
import grupoSinNombre.service.BookService
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test;
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
//import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.context.web.WebAppConfiguration


@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(BooksApplication::class),
webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BooksApplicationTests {
	var aBook0 = Book("Prueba0", "L",0,1, 2)
	var aBook1 = Book("Prueba1", "H", 0, 1, 2)

	@Autowired
	lateinit var bookRepository: BookRepository

	@Before
	fun saveBooks(){
		bookRepository.save(aBook0)
		bookRepository.save(aBook1)
	}
	@Test
	fun contextLoads() {
	}

	@org.junit.jupiter.api.Test
	fun test0_when_called_should_return_hola(){
		var controller = BookController(BookService(bookRepository))
		assertEquals("Hola", controller.index())
	}
	@org.junit.jupiter.api.Test
	fun test1_when_save_a_book_repository_should_return_the_same_book(){
		var otherBook = bookRepository.findById(1)
		assertEquals(1, otherBook.get().id)
		assertEquals("Prueba0", otherBook.get().name)
		assertEquals("L", otherBook.get().authorName)
		assertEquals(0, otherBook.get().releaseYear)
		assertEquals(1, otherBook.get().amountOfPages)
		assertEquals(2, otherBook.get().priceInPesos)
	}

	@org.junit.jupiter.api.Test
	fun test2__when_save_a_lot_of_books_repository_should_return_them(){
		var books = bookRepository.findAll()
		assert(books.contains(aBook0))
		assert(books.contains(aBook1))
		assertEquals(2, books.count())
	}
}
