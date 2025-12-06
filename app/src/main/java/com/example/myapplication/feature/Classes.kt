package com.example.myapplication.feature


class User1 {

}

class User2(name: String) {

    constructor() : this("")

    constructor(name: String, age: Int) : this(name) {
        println("name: $name, age: $age")
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun toString(): String {
        return super.toString()
    }
}

class User3 {

    private var name: String

    private var age: Int

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName(): String {
        return name
    }

    fun setAge(age: Int) {
        this.age = age
    }

    fun getAge(): Int {
        return age
    }

    override fun toString(): String {
        return "User3(name='$name', age=$age)"
    }
}

class User4(var name: String = "", var age: Int) {

    override fun toString(): String {
        return "User4(name='$name', age=$age)"
    }
}

data class User5(val name: String, val age: Int = 100)

object User6 {

    var name: String =""
    var age: Int = 0
}