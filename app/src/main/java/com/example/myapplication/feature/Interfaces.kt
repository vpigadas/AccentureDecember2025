package com.example.myapplication.feature

interface Animal{
    val age: Int

    fun getName(): String
}

class Cat(override val age: Int) : Animal{

    override fun getName(): String  = "Cat"

}

abstract class Water : Animal{

    protected val _color: String = "blue"

    abstract fun getColor(): String
}

class Fish(override val age: Int) : Water(){
    override fun getColor(): String = _color

    override fun getName(): String = "Fish"
}

open class Dog(override val age: Int) : Animal{

    open val ears: Int = 2

    override fun getName(): String = "Dog"
}

data class Dog2(override val age: Int): Animal{
    override fun getName(): String {
     return "Dog2"
    }
}

class Dalmatias(age: Int): Dog(age){

    override val ears = 1

    override fun getName(): String  = "Dalmatias"
}