package model

import grupoSinNombre.model.BookApp
import grupoSinNombre.model.User
import junit.framework.Assert.*
import org.junit.Test
import java.time.LocalDate

class BookAppTest {

    @Test
    fun aBookAppWhenIsCreatedIsEmpty() {
        val bookApp = BookApp()

        assertEquals(0, bookApp.amountOfUsers())
    }

    @Test
    fun aBookAppCanRegisterANewUser() {
        var newUser = User("first user", "f@gmail.com", LocalDate.now());
        var bookApp = BookApp()

        bookApp.registerUser(newUser, "asd")

        assertEquals(1, bookApp.amountOfUsers())
    }
    @Test
    fun twoUsersCannotHaveTheSamePassword(){
        val newUser = User("first user", "f@gmail.com", LocalDate.now())
        val newUserWithSamePassword = User("Second user", "s@@gmail.com", LocalDate.now())
        val bookApp = BookApp()

        //al momento de chequera las contraseñas hay que ver si las mayusculas y minisculas cuentan
        //o solo vemos que sea el mismo string y lesto
        bookApp.registerUser(newUser, "Alfredo casero")
        bookApp.registerUser(newUserWithSamePassword, "Alfredo casero")

        assertEquals(1, bookApp.amountOfUsers())
    }
    @Test
    fun whenAnUserIsRegistedItCanLogInWithHisUserNameAndPassword(){
        val newUser = User("User", "user@gmail.com", LocalDate.now())
        val bookApp = BookApp()

        bookApp.registerUser(newUser, "Una Contraseña")

        assertTrue(bookApp.logInUser(newUser.userName, "Una Contraseña"))
    }
    @Test
    fun aNoRegistedUserCannotLoginToTheApp(){
        val noRegisterUser = User("No Register user", "n@gmail.com", LocalDate.now())
        val bookApp = BookApp()

        assertFalse(bookApp.logInUser(noRegisterUser.userName, ""))
    }
}