package com.himsngh

import java.io.Serializable

/*
    * Generics are the powerful features that allow to define classes,methods and properties which can be accessed using
    * different types. The type differences of classes,methods are checked at compile time. The generics type class or
    * method is declared as parametrised type. The parametrised type is declared by the angle brackets <> .
    * Advantages of generics are 1. Type-Safety 2. Type Casting is not required 3. Compile time checking.
    * A generic function without any constraint can be called by any data type and can access it . To have an constraint or
    * to limit our generics we can add Upper Limit so that no other type can call it only the given constraint
    * and the subclass of it . For ex. class Box<T: Number> -> Now in this only the number and its subclass can call this
    * generic function and no any other function.
    * If we don't provide any upper bound then the compiler automatically give it as <T: Any?> the upper bound Any? which
    * is the super class for all the nullable and non- nullable classes.
    * To have more than one constraints or multiple upper bounds we can add it using the where keyword . after class declaration
    * where  T: Number, T:Serializable .
    ** Only one of the upper bound can be class.
    *
    * Variance
    * Generics type are invariant. That means that no class is subtype of any other or parent of any other.
    * For complex types like List<Person> we can't assign it to List<Student> which is a
    * child class of Person.
    * A generic class of parent type can be replaced by generic class of subtype.
    * for ex:
    * val student = Student()
    * val person: Person = student ---> is allowed but
    * val st: Person = Student() ---> this is also allowed.
    * But for complex types it will throw an compiler error
    * val list: MutableList<Student> = mutableListOf(Student("him"),Student("ans"))
    * val list2: MutableList<Person> = list  --> this will throw an error as type mismatch require Person found Student.
    * Suppose if we allow this to happen then the issues that will arise are:
    * fun add(group : MutableList<Person>, person:  Person) = group.add(person)
    * Now in main we create a val studentList:MutableListOf<Student> = mutableListOf() and a val teacher = Teacher()
    * if we pass this to the add function add(studentList, teacher) this will work and it will be added in the list.
    * So if now we try to get it back by
    * val student:Student = studentList.get(0) will throw an error but at runtime time which is worst.
    * This is why generics are invariant for complex types.
    * But this raises an issue then that we will loose polymorphism .
    * To tackle this we have Covariance and ContraVariance
    *
    * Covariance
    * To allow this and make our class covariant we need to add out modifier in the generics type <out T> .
    * Now this concept of polymorphism will work .
    * list: MutableList<Person> = studentList if the list class we define the generics as out t.
    * For ex:
    * open class Fruit
    * class Apple:Fruit()
    * class Orange: Fruit()
    *
    * class Box<out T>{ fun get(): T{} }
    * When we use out keyword in the generics class it operates as a producer and so there can't be any function which
    * take t  as the parameter.
    * for ex: if one more function is there in box class.
    * fun put(t : T);
    * val apple = Box<Apple>()
    * val fruitBox : FruitBox = apple -> This will work now since we have used the out modifier.
    * fruitBox.put(Orange()) -> Now if put function is valid then it implies that we can add orange in an apple box.
    * which is wrong and that's y when we use the out modifier it acts as a producer and so it can't consume .
    *
    * Contravariance
    * Contravariance is exactly opposite to covariance . ie A generic class of subtype can be replaced by generic class
    * of parent type. In Contravariance we use the keyword in with the generic and it acts as an consumer.
    * It means that this type can only consume and cannot produce the type.
    * Function cannot have return type as T and can take parameters of type T.
    * This means.
    * class Box<in T> { function.....}
    * So if we have a function that returns type T.
    * var fruitBox = Box<Fruit>()
    * var apple:Box<Apple> = fruitBox
    * var app = apple.get() -> This should give apple but it will return fruit and this leads to an error.
    * That's y we don't have return type as parameter T in contravariant.
    *
    * Type Projection
    * Similar to what we have learned even in function if we want to perform an action which have generics can lead to
    * some issues with it because of its invariant nature.
    * for ex.
    *  fun copy(from: MutableList<Any>, to: MutableList<Any>){ for(i in from.indices){to.add(from[i])} }
    * val any: MutableList<Any> = mutableListOf("John",7)
    * val num: MutableList<Int> = mutableListOf(1,2,3)
    * copy(num,any) --> this wont work now because generics are invariant and we are passing Int in Any which leads to error.
    * To tackle this we need to add covariant
    * fun copy(from: MutableList<out Any>....) now this will work.
    *
    * Star Projection
    * When we are not bothered about the the type of the data the we use *.
    * fun print( item: MutableList<*>){...} --> In this place we can also use out Any but it better to use this as
    * the type of the parameter is really doesn't matter to us .It is kind of raw types in java.
    *
    * Reified Types
    * The type of the items at runtime is erased and we don't know what is the type of the parameter passed or used in the
    * function at runtime. To know about the parameter we use Reified keyword with the inline function.
    * Inline functions copies the code of the function and paste it below the point it is called and then run the accordingly.
    *
 */

// Generic Methods

fun <P> printObject(obj : P){
   println("The obj is ${obj.toString()}")
}

class TypeGenerics<T>{

    fun withoutType(content: T){
        println("In this only the type of class can be called.....")
        println("the content is  : $content")
    }
    fun<T> withType(content: T){
        println("Defining type even in the function also and now we can have different type for the method also...")
        println("This is kind of overriding the class type....")
        println("the content is $content")
    }
}

// Generics Constraints
// Now only the number and its subclass can use this generic function.
fun <T: Number> price(t: T){
    println("The price of the item is : $t")
}

fun <T> printNumAndString(t:T) where T:Number, T:Serializable{
    println("The value is $t")
}

open class PersonGenerics
class StudentGenerics: PersonGenerics()

//Covariance
open class Fruit
class Apple: Fruit()
//Variant
class Box<out T>{
    fun get() : T{ TODO("Return item of type t")}
    fun getItem(){
        println("Getting Box of type T")
    }
    // fun put(t: T) {} this function is invalid in this context
}
//Contravariant

class Box2<in T>{
    // fun get(): T{} --> This is an error as this class is an contravariant
    fun get(t :T){} // this is valid in this case
}

class ListExample{
    fun copy(from: MutableList<out Any>,to: MutableList<Any>){
        for(i in from.indices){
            to.add(from[i])
        }
    }
}

// If i write any in place of * then the int type wont work until we provide an out modifier .
// * is used where it really doesn't matter what is the type of the parameter.
fun printGenerics(item: MutableList<*>){
    for(i in item.indices){
        print("${item[i]} ")
    }
    println()
}

//Reified
inline fun <reified T> checkTypeAtRuntime(item:Any){
    println("The type of the item is ${item is T}")
}

fun main(){
    //This will throw an error as temp is of type nullable string whereas t is of type non-nullable string .
//    val temp: String? = "Him"
//    val t:String = temp
    val str = "Himanshu"
    val int = 10
    val list = arrayListOf(10,20,30,40,50)
    println("The same function is printing all different kinds of objects that is the power of generics. ")
    printObject(str)
    printObject(int) // We can explicitly define printObject<Int> or else it is not necessary
    printObject(list)

    val typeGenerics = TypeGenerics<String>()
    typeGenerics.withoutType("Himanshu")
    typeGenerics.withType(10)
    //typeGenerics.withoutType(10)
    val price = 100
    price(price)
    printNumAndString(price)

    println("****************** Variance , Covariance and Contravariance ******************")

    //val student = StudentGenerics()

    //val students: MutableList<StudentGenerics> = mutableListOf(student,StudentGenerics())
    //val personList: MutableList<PersonGenerics> = students  --> Type mismatch error
    println("Required PersonGenerics but found StudentGenerics")

    val apple = Box<Apple>()
    apple.getItem()
    //val box:Box<Fruit> = apple --> This throws an error without the out modifier in the generics.
    val box: Box<Fruit> = apple //

    val any:MutableList<Any> = mutableListOf("Any", 1,"Type")
    println(any)
    val num:MutableList<Int> = mutableListOf(1,2,3)
    ListExample().copy(num,any)
    println(any)
    printGenerics(any)
    printGenerics(num)
    checkTypeAtRuntime<Any>(any)
    // print("The type of the item is ${any is Any}") -- true;
    checkTypeAtRuntime<String>(any)
    // print("The type of the item is ${any is Any}") -- false;
    checkTypeAtRuntime<Int>("Himanshu")
    // print("The type of the item is ${any is Any}") -- false;
}
