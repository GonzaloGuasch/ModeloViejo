package grupoSinNombre.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class BookApp(
        private val registedUsers: MutableMap<User, String>  = mutableMapOf(),
        @Id @GeneratedValue
        private var id: Long = 0
) {

    fun amountOfUsers(): Int = registedUsers.size
    fun registerUser(newUser: User, password: String) {
        if(this.registedUsers.containsValue(password)){
            throw Exception("This password is already in use, please choose another one!")
        }else{
            this.registedUsers.putIfAbsent(newUser, password)
        }
    }

    fun logInUser(userName: String, userPassword: String): Boolean {
        var res = false
        this.registedUsers.map {userAndPasswordMap -> res = userAndPasswordMap.key.userName == userName &&
                                                            userAndPasswordMap.value == userPassword
        }

        if(!res){
            throw Exception("Check your password or your user name")
        }else{
            return res
        }
    }

}
