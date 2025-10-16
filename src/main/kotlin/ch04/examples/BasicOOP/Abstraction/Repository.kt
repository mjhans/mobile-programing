package com.bible.ch04.examples.BasicOOP.Abstraction

abstract class Repository<T> {
    // 복잡한 구현은 숨기고 간단한 인터페이스 제공
    abstract fun save(item: T): T
    abstract fun findById(id: String): T?
    abstract fun findAll(): List<T>
    abstract fun delete(id: String): Boolean
}