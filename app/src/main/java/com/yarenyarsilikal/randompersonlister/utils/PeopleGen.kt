package com.yarenyarsilikal.randompersonlister.utils


/**
 * Created by yarenyarsilikal on 16.04.2022.
 */
object PeopleGen {
    private val firstNames = listOf(
        "Fatma",
        "Mehmet",
        "Ayşe",
        "Mustafa",
        "Emine",
        "Ahmet",
        "Hatice",
        "Ali",
        "Zeynep",
        "Hüseyin",
        "Elif",
        "Hasan",
        "İbrahim",
        "Can",
        "Murat",
        "Özlem"
    )
    private val lastNames = listOf(
        "Yılmaz",
        "Şahin",
        "Demir",
        "Çelik",
        "Şahin",
        "Öztürk",
        "Kılıç",
        "Arslan",
        "Taş",
        "Aksoy",
        "Barış",
        "Dalkıran"
    )

    fun generateRandomFullName(): String {
        val firstNamesCount = firstNames.size
        val lastNamesCount = lastNames.size
        val firstName = firstNames[RandomUtils.generateRandomInt(range = 0 until firstNamesCount)]
        val lastName = lastNames[RandomUtils.generateRandomInt(range = 0 until lastNamesCount)]
        return "${firstName} ${lastName}"
    }
}
