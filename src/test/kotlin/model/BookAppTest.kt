package model

import grupoSinNombre.model.User
import junit.framework.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

class BookAppTest {

    @Test
    fun aBookAppWhenIsCreatedIsEmpty(){
        val bookApp = BookApp()

        assertEquals(0, bookApp.amountOfUsers())
    }
    @Test
    fun aBookAppCanRegisterANewUser(){
        var newUser = User("first user", "f@gmail.com", LocalDate.now());
        var bookApp = BookApp()


    }
}