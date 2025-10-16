package com.bible.ch04.examples.BasicOOP.Abstraction

abstract class FileStorage {
    abstract fun upload(fileName: String, content: ByteArray): String
    abstract fun download(fileId: String): ByteArray?
    abstract fun delete(fileId: String): Boolean
}