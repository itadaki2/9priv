import java.util.Scanner
import kotlin.random.Random

// 1 генерация 10 случайных чисел
fun generatorChisel() {
    for (i in 1..10) {
        println(Random.nextInt(1, 101))
    }
}

// 2 подсчет гласных и согласных
fun analizStroki(stroka: String) {
    var glasnye = 0
    var soglasnye = 0
    val glasnyeBukvy = "аеёиоуыэюяaeiou"

    for (bukva in stroka.lowercase()) {
        if (bukva in glasnyeBukvy) glasnye++
        else if (bukva.isLetter()) soglasnye++
    }
    println("гласные: $glasnye, согласные: $soglasnye")
}

// 3 конвертация долларов в евро
fun konvertValyuty(dollary: Double) {
    val kurs = 0.85
    println("в евро: ${dollary * kurs}")
}

// 4 проверка на анаграмму
fun anagramma(stroka1: String, stroka2: String): Boolean {
    return stroka1.toList().sorted() == stroka2.toList().sorted()
}

// 5 нахождение простых чисел до N
fun prostyeChislaDoN(n: Int) {
    for (chislo in 2..n) {
        var prostoe = true
        for (i in 2 until chislo) {
            if (chislo % i == 0) prostoe = false
        }
        if (prostoe) println(chislo)
    }
}

// 6 сортировка массива строк
fun sortirovkaStrok(stroki: Array<String>) {
    stroki.sort()
    println(stroki.joinToString(", "))
}

// 7 изменение регистра
fun izmenitRegistr(stroka: String) {
    val novayaStroka = stroka.map {
        if (it.isUpperCase()) it.lowercaseChar() else it.uppercaseChar()
    }.joinToString("")
    println(novayaStroka)
}

// 8 игра угадай число
fun igraUgaday() {
    val zagadannoe = Random.nextInt(1, 101)
    val scanner = Scanner(System.`in`)
    var chislo = 0
    while (chislo != zagadannoe) {
        println("Введите число:")
        chislo = scanner.nextInt()
        if (chislo < zagadannoe) println("Больше")
        else if (chislo > zagadannoe) println("Меньше")
        else println("Вы угадали!")
    }
}

// 9 генератор пароля
fun generatorParolya(dlina: Int) {
    val simvoly = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#\$%^&*"
    var parol = ""
    for (i in 1..dlina) {
        parol += simvoly.random()
    }
    println("Ваш пароль: $parol")
}

// 10 самое длинное слово
fun samoeDlinnoeSlovo(stroka: String) {
    val slova = stroka.split(" ")
    var maxSlovo = slova[0]
    for (slovo in slova) {
        if (slovo.length > maxSlovo.length) {
            maxSlovo = slovo
        }
    }
    println("самое длинное слово: $maxSlovo")
}

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nвыберите задание (1-10), 0 для выхода:")
        when (scanner.nextInt()) {
            1 -> generatorChisel()
            2 -> {
                println("введите строку:")
                val stroka = scanner.next()
                analizStroki(stroka)
            }
            3 -> {
                println("введите сумму в долларах:")
                val dollary = scanner.nextDouble()
                konvertValyuty(dollary)
            }
            4 -> {
                println("введите первую строку:")
                val stroka1 = scanner.next()
                println("введите вторую строку:")
                val stroka2 = scanner.next()
                println("анаграмма? ${anagramma(stroka1, stroka2)}")
            }
            5 -> {
                println("введите число N:")
                val n = scanner.nextInt()
                prostyeChislaDoN(n)
            }
            6 -> {
                println("введите количество строк:")
                val n = scanner.nextInt()
                val stroki = Array(n) { scanner.next() }
                sortirovkaStrok(stroki)
            }
            7 -> {
                println("введите строку:")
                val stroka = scanner.next()
                izmenitRegistr(stroka)
            }
            8 -> igraUgaday()
            9 -> {
                println("введите длину пароля:")
                val dlina = scanner.nextInt()
                generatorParolya(dlina)
            }
            10 -> {
                println("введите строку:")
                scanner.nextLine() // очистка буфера
                val stroka = scanner.nextLine()
                samoeDlinnoeSlovo(stroka)
            }
            0 -> {
                println("Выход")
                break
            }
            else -> println("неверное задания")
        }
    }
}
