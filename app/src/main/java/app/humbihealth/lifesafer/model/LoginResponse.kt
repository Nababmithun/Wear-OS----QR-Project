package app.humbihealth.lifesafer.model

data class LoginResponse(
    val `data`: Data,
    val message: String,
    val success: Boolean
) {
    data class Data(
        val expiry: String,
        val token: String,
        val user: User
    ) {
        data class User(
            val dateJoined: String,
            val dp: Any,
            val email: String,
            val id: Int,
            val language: String,
            val name: String,
            val profilePic: Any,
            val username: String
        )
    }
}