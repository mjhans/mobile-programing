package com.bible.week03.examples

@JvmOverloads
fun <T> joinToString(
    collection: Collection<T>,
    separator: String = ",",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator) // 첫원소 앞에는 구분자를 붙이면 안된다.
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

fun main(){
    val list = listOf(1, 2, 3, 4, 5)
    println(list)
    println(list.toString()) 

    println(joinToString(list, "; ", "(", ")"))

    //named
//    println(joinToString(
//        collection = list,
//        separator = "; ",
//        prefix = "(",
//        postfix = ")")
//    )

    println(joinToString(list, ",", "",""))
    println(joinToString(list))
    println(joinToString(list, ","))

    // parameter 이름을 써줄때 파라미터 위치는 관계 없다)
    println(joinToString(
        collection = list, // 필수 파라미터
        prefix = "(",
        postfix = ")")
    )


}