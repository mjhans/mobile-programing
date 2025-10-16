package com.bible.ch04.examples.BasicOOP.Abstraction.Impl

import com.bible.ch04.examples.BasicOOP.Abstraction.*

class UserRepository : Repository<User>() {
    // 실제로는 매우 복잡한 구현
    private val database = mutableMapOf<String, User>()  // 실제로는 JDBC, Hibernate 등

    private fun connect(): String {
        // 실제로는 복잡한 DB 연결 풀 관리
        println("    [DB] 연결 풀에서 연결 획득...")
        return "connection-${System.currentTimeMillis()}"
    }

    private fun executeQuery(query: String): String {
        // 실제로는 SQL 쿼리 실행, 결과 매핑 등
        println("    [DB] 쿼리 실행: $query")
        return "result"
    }

    private fun releaseConnection(connection: String) {
        // 실제로는 연결 반환, 트랜잭션 커밋/롤백 등
        println("    [DB] 연결 반환: $connection")
    }

    override fun save(item: User): User {
        println("  [UserRepository] 사용자 저장 중...")

        // 복잡한 내부 로직
        val connection = connect()
        executeQuery("INSERT INTO users (id, name, email, age) VALUES ('${item.id}', '${item.name}', '${item.email}', ${item.age})")

        database[item.id] = item

        releaseConnection(connection)

        println("  [UserRepository] 저장 완료: ${item.name}")
        return item
    }

    override fun findById(id: String): User? {
        println("  [UserRepository] ID로 사용자 조회: $id")

        val connection = connect()
        executeQuery("SELECT * FROM users WHERE id = '$id'")
        val user = database[id]
        releaseConnection(connection)

        return user
    }

    override fun findAll(): List<User> {
        println("  [UserRepository] 모든 사용자 조회")

        val connection = connect()
        executeQuery("SELECT * FROM users")
        val users = database.values.toList()
        releaseConnection(connection)

        return users
    }

    override fun delete(id: String): Boolean {
        println("  [UserRepository] 사용자 삭제: $id")

        val connection = connect()
        executeQuery("DELETE FROM users WHERE id = '$id'")
        val removed = database.remove(id) != null
        releaseConnection(connection)

        return removed
    }
}