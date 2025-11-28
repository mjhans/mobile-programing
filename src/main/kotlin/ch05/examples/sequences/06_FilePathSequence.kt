package com.bible.ch05.examples.sequences
// File Path Sequence - Kotlin in Action Ch6.2

import java.io.File

// 확장 함수: 파일이 숨김 디렉토리 안에 있는지 확인
fun File.isInsideHiddenDirectory(): Boolean =
    generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main() {
    println("=== 파일 경로 탐색 with generateSequence ===\n")

    // 1. 테스트용 임시 파일 구조 생성
    println("1. 테스트 환경 설정:")
    val tempDir = File.createTempFile("test", "", File(".")).apply {
        delete()
        mkdir()
    }
    val hiddenDir = File(tempDir, ".HiddenDir").apply { mkdir() }
    val normalDir = File(tempDir, "NormalDir").apply { mkdir() }
    val hiddenFile = File(hiddenDir, "secret.txt").apply { createNewFile() }
    val normalFile = File(normalDir, "public.txt").apply { createNewFile() }

    println("생성된 구조:")
    println("  ${tempDir.name}/")
    println("    .HiddenDir/ (숨김)")
    println("      secret.txt")
    println("    NormalDir/")
    println("      public.txt\n")

    println("=".repeat(50) + "\n")

    // 2. 숨김 디렉토리 검사
    println("2. 숨김 디렉토리 검사:")
    println("secret.txt가 숨김 디렉토리 안에 있는가?")
    println("  경로: ${hiddenFile.absolutePath}")
    println("  결과: ${hiddenFile.isInsideHiddenDirectory()}")
    println()

    println("public.txt가 숨김 디렉토리 안에 있는가?")
    println("  경로: ${normalFile.absolutePath}")
    println("  결과: ${normalFile.isInsideHiddenDirectory()}")
    println()

    println("=".repeat(50) + "\n")

    // 3. 부모 디렉토리 순회 과정 시각화
    println("3. 부모 디렉토리 순회 과정:")
    println("hiddenFile의 모든 부모:")
    generateSequence(hiddenFile) { it.parentFile }
        .forEach { println("  ${it.name}${if (it.isHidden) " (숨김)" else ""}") }
    println()

    // 4. 정리
    println("4. 정리:")
    hiddenFile.delete()
    normalFile.delete()
    hiddenDir.delete()
    normalDir.delete()
    tempDir.delete()
    println("테스트 파일 및 디렉토리 삭제 완료\n")

    println("핵심:")
    println("- generateSequence로 부모 디렉토리 순회")
    println("- any { it.isHidden }로 숨김 디렉토리 검사")
    println("- 확장 함수로 재사용 가능한 유틸리티 구현")
}
