package com.bible.ch04.examples.BasicOOP.Abstraction.Services

import com.bible.ch04.examples.BasicOOP.Abstraction.*

class UserService(private val repository: Repository<User>) {
    fun getUser(id: String): User? {
        println("[UserService] 사용자 조회 요청: $id")

        // DB 연결, SQL, 에러 처리 등 복잡한 세부사항 몰라도 됨
        // 단순히 repository.findById() 호출만 하면 됨
        return repository.findById(id)
    }

    fun createUser(name: String, email: String, age: Int): User {
        println("[UserService] 사용자 생성 요청")

        val user = User(
            id = "U${System.currentTimeMillis()}",
            name = name,
            email = email,
            age = age
        )

        // 복잡한 저장 로직은 repository가 처리
        return repository.save(user)
    }

    fun getAllUsers(): List<User> {
        println("[UserService] 전체 사용자 조회 요청")
        return repository.findAll()
    }
}
