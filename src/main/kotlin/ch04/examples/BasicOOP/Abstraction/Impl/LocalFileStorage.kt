package com.bible.ch04.examples.BasicOOP.Abstraction.Impl

import com.bible.ch04.examples.BasicOOP.Abstraction.*

class LocalFileStorage : FileStorage() {
    private val storage = mutableMapOf<String, ByteArray>()

    override fun upload(fileName: String, content: ByteArray): String {
        val fileId = "FILE_${System.currentTimeMillis()}"
        storage[fileId] = content
        println("  [LocalStorage] 파일 저장: $fileName → $fileId")
        return fileId
    }

    override fun download(fileId: String): ByteArray? {
        println("  [LocalStorage] 파일 다운로드: $fileId")
        return storage[fileId]
    }

    override fun delete(fileId: String): Boolean {
        println("  [LocalStorage] 파일 삭제: $fileId")
        return storage.remove(fileId) != null
    }
}