package com.himsngh


/*
   * Kotlin supports both functional and object-oriented programming. Kotlin also supports the pillar of oops like
   * encapsulation, inheritance and polymorphism.
   * Kotlin classes are similar to java class.
   * Variables defined with val keyword cannot have setters as it is read only value.
   * In Kotlin properties must be initialised or declared abstract. (school, name , age, isTeenager).
   * Setters and getters are already defined in the kotlin for all variable we define . However if we want to modify
   * them then we can by use get() or set() value.
   * When defining getters and setters sometimes we can have issues of infinite recursion . Kotlin uses a special kind
   * field which stores the variable data  to avoid infinite recursion use field instead of the name of the variable.
   *
   * Constructor
   * Constructor are defined in kotlin directly in the class declaration and are known as primary constructor .
   * There can be only one primary constructor but We can also define as many constructors we want other than primary
   * constructor known as secondary constructor.
   * If a constructor is defined private it cannot be called from outside a class.
   * Primary constructor is declared at the class declaration . for ex. class Student constructor(){}, but if the
   * constructor don't have any annotations or access modifiers then we can omit the word constructor and directly
   * define class Student(){}.
   * Primary Constructor does not contain any code. Initializer blocks are used to initialization of code. There can be
   * more than one initialization block. for ex. init{ code for initialization }. At the time of initialization the init
   * blocks are run according to the order they are defined in the class . first one will be executed first.
   * -> In primary constructor we can also define properties by using val or var keyword. for ex.  class stu(val name:String  = "None")
   * in this the name is an property of the class stu.
   *
   * Secondary constructors can be defined inside the class using the constructor keyword and can be defined as many as
   * we want. Both secondary and primary constructor can be in a class in that case the secondary constructor must
   * authorize the primary constructor for initial initialization and can be done by using the this keyword.
   * Thus first the primary constructor call executed and then the secondary.
   * Secondary constructor can call other secondary constructor use the same this keyword.
   * To refer to parent constructor we can use the super keyword .
   *
   * Visibility Modifiers
   * In kotlin there are mainly four kinds of visibility modifiers public, inline, protected, private. But the
   * visibility modifiers are different for classes and for top-level functions(Functions or variables defined outside of classes)
   * Public is by default if not mentioned and is visible to every where for both classes and top - level function.
   * Inline is visible in the module it is used in .
   * Protected is only used for classes and have visibility in parent and its subclasses.
   * If a variable or function is marked protected and if we override it in its subclass then also it will be protected only
   * until and unless explicitly changed to different modifier.
   * Private is only visible in the class defined and for top level in the file it is defined.
   * We can also make the constructor private if we don't want anyone to access and instantiate it. For ex. if we
   * don't want our primary constructor to be accessible then we can make it private and can use inner accessibility
   * thorough secondary constructors.
   *
   * Inheritance and Polymorphism
   * Inheritance allows to inherit features of exiting class (parent class) to a new class.(child or derived class).
   * Inheritance defines is-a relationship between the superclass and the child(sub)class .
   * for ex. student(child class) is a person(superclass) or teacher is a person.
   * All Kotlin classes have a common superclass Any.
   * As Kotlin classes are final by default so one cannot inherit from them directly. We use the open keyword in front
   * of the class declaration to make it non-final and inheritable.
   * Just like classes all properties and methods defined in a class are final and cannot be overridden . We have to
   * explicitly define with the keyword open to make it non-final and available for overriding.
   * If the parent's primary constructor is not present then the child can call the secondary constructor using the super
   * keyword.
   * super keyword is also used to call methods of the parent class.
   *
   * Polymorphism is defined as an object can take different shapes forex. when we define the the object
   * var p1 : Person = Teacher() and var p2 :Person = Worker() both are of type person but at runtime they are executing
   * their classes Teacher and Worker respectively.
   * Similarly in the function defined Work(p : Person) it is expecting data of type Person but while executing its changing
   * and executing Teacher and Worker class respectively . This is known  as Dynamic Polymorphism.
   * In both the cases the compiler has only knowledge of the given data type as Person and only at runtime it is known to
   * be of the given (teacher() or worker()) type . So only the functions defined in the Person class can be executed with this.
   *
   * Abstract
   * An class which is declared with the keyword abstract is an abstract class . Abstract class are by default open .
   * An abstract class cannot be instantiated. The methods and properties of an abstract class are non-abstract until
   * explicitly declared as abstract. An abstract doesn't have any implementation of the method and the subclass
   * need to override and provide the implementation. If the abstract class is extended and all the abstract methods is
   * not overridden or the implementation provided then the sub-class should also be marked abstract. Abstract classes
   * are partially defined classes i.e with some implemented and other abstract methods.
   * An non abstract class cannot have an abstract method.
   *
   * Interfaces
   * An interface is an blueprint of a class. It contains abstract methods as well as implementation of methods. The
   * methods which are declared without their body are by default abstract in interfaces. Interfaces do not have constructors
   * and cannot be instantiated . Any class implementing the interface must override all the abstract methods.
   * Interfaces can be used to perform multiple inheritance as a class cannot inherit from more than one class
   * but it can implements as many interfaces as the class wants.
   * Interfaces in kotlin are similar to what we have since Java 8. In java Interfaces we have default and static methods
   * which can have the implementation but only the default method can be overridden and not the static .
   * In kotlin we don't have static methods and if in a interface a  method body is not provided then that method is
   * abstract or otherwise it is default .
   * If two interfaces contains a non-abstract method of the same name and a class implements both of them then the class
   * overriding method and if wants to call the method of any of the class it must explicitly told the compiler to do so.
   *
   * Nested Class , Inner Class and Anonymous class
   * Nested Class is a class defined inside a class. In kotlin nested classes are by default static in nature.
   * i.e we can access its members and properties without creating an object or instantiate them.
   * We can directly access them by calling outerClass.innerClass.method/property. Nested class cannot access outer
   * class members .
   * Inner class are nested class with the inner keyword . Inner class have the authentication to access all the outer
   * class members even the private marked members. Outer class needs to be instantiated to access the inner class .
   * Anonymous classes are classes that are defined without a name. It is mostly used when we have to modify a little bit
   * of code or override a function . In general we have to create a new class and extend it and then override it .
   * To overcome this we have anonymous class which can be used in such cases and can override smaller function as needed.
   *
   * Data Class
   * Data class is simple class which is used to hold data/state and contains standard functionality. data keyword is used
   * to declare a data class. Declaring a data class must contain a primary constructor with at least one property .
   * i.e data class stu(var name:String) is a valid data class where as data class stu(name:String) is not.
   * In data class primary constructor, only properties are allowed and no other argument should be used or declared .
   * Data class internally consists of some methods like .equals(), .hashCode(), .toString(), components() functions
   * corresponding to the properties(getters and setters) and copy() method.
   * Data class equals method checks the property variable defined in the primary constructor and if all properties inside
   * the primary constructor is equal then it returns true. We can also use == for equals method.
   * Even if we have defined some other properties inside the data class and it has different value for different objects
   * still it wont matter if the properties defined inside the primary constructor is same .
   * === is used for checking the reference of the object.
   * Data class also provide a copy method which is used to copy the data of the data class and provide modification if required.
   * We can also use destructing the data class object with val(property,property,...) = data class object.
   * and it will give all the properties of the data class defined in the primary constructor.
   *
   * Enum Class
   * An enum is special class that represents a group of constants (unchangeable variable (read only) ,like finals).
   * Each enum consonants is an object of the enum class. Each enum consonants are separated by commas.
   * Enum classes are defined by the keyword enum. Two functions provided by the enum class are name and ordinal(position)
   * Enum class ordinal are defined according to their position in the enum class.
   * Enum classes can also define their own anonymous class with their corresponding methods as well as overriding base
   * methods. Creating Constant is okay but a better way is to use Enums .
   * An Enum class may implement an interface but cannot derive from another class.
   *
   * Sealed Class:
   * Sealed classes are used to represent restricted class hierarchy when a value can have one of the type from the limited
   * set , but cannot have any other type. They are, in a sense, an extension of enum classes: the set of values for an
   * enum type is also restricted, but each enum constant exists only as a single instance, whereas a subclass of a
   * sealed class can have multiple instances which can contain state.
   * A sealed class is abstract by itself i.e it cannot be instantiated and can have abstract members.
   * Sealed classes are not allowed to have non-private members.
   *
   * Objects and Companion Objects
   * When we require singleton class : The class which can have only one instance we can use the object keyword instead
   * of class to define a singleton class. for ex: object temp{} now this temp class will only have one instance which
   * is its name itself and cannot be instantiated for new objects.
   * Companion objects are defined inside the class and are similar to what we have static members and variables in java
   * These are for the whole class and not for the instance.
   *
   * Extension Function
   * Extension function are used to add new properties, or function to an existing class. These function can be for
   * all classes User Defined or even the Default Class like Int etc. Defining extension functions are really easy to use
   * and very helpful .
   *
 */

// fname is also an property of the class Person .
// Since this constructor don't have any annotations or visibility modifiers then we can omit the constructor word.
// open keyword is used to make it inheritable i.e non final
open class Person constructor(var fName:String, lastName:String){ // primary constructor

    var age:Int = 0
    var sex:String = "Not defined"
    var lastName: String = "Not defined"
    open var working = "Person"
    init{
        println("First INIT block executing .......")
        this.lastName = lastName
    }
    init{
        println("Second INIT block is executing.......")
        println("This block have no code ")
    }
    //Secondary Constructor

    constructor(name: String,lastName: String,age: Int):this(name,lastName){
        println("Secondary constructor 1 is being executing.....")
        this.age = age
    }
    constructor(name:String,lastName: String, age:Int, sex:String):this(name,lastName,age){
        println("Secondary constructor-2 is being executing.......")
        this.sex = sex
    }
    //After defining open only we can override or else we can't.
    open fun work(){
        println("$working is doing work........")
    }

}

class Teacher private constructor(fName:String,lName:String) : Person(fName,lName){
    override var working = "Teacher"
    init{
        println("Teacher inti block called.....")
    }
    constructor(fName:String, lName:String,age:Int,sex:String):this(fName,lName){
        println("Teacher secondary constructor called......")
        super.age = age
        super.sex = sex
    }

    override fun toString(): String {
        return "Teacher(name : $fName ${this.lastName}, age: ${this.age} , sex:${this.sex})"
    }
    override fun work(){
        super.work()
        println("super.working will give : ${super.working}")
        println("$working is doing work......")
    }
    fun work2(){
        println("Only teacher doing work......")
    }
}
class Worker(name: String,lastName: String) : Person(name,lastName){
    override var working = "Worker"
    override fun work(){
        println("$working is working....")
    }
}

class Student{ // by default the compiler generates an empty constructor.
    val school = "ABC Public School" //cannot be changed
    var name:String? = null
        get() = field ?: "Default"
        set(value) {
            if(value != null) field = value
        }
    val age:Int = 5 // val is not accessible directly and cannot be changed
//        set(value){
//            field = value
//        } val variables  cannot have setters as well because they are read only value we are trying to assign different value.
    val isTeenager:Boolean
        get() = age>12

}

// Abstract Classes and Interfaces

interface Engine{
    fun run()
    val name:String
        get() = "Engine"
    fun default(){
        println("Engine is hot")
    }
}
interface Wheels{
    fun default(){
        println("There are 4 wheels")
    }

}
open class Vehicle{
    open fun start(){
        println("Vehicle is moving.....")
    }
    open fun stop(){
        println("Vehicle was stopped......")
    }
}
abstract class Car: Vehicle(){
    abstract override fun start()
    override fun stop(){
        println("Car was stopped")
    }
}

class Honda:Car(),Engine,Wheels{
    override fun start() {
         //TODO("Not yet implemented")// if no implementation provided then we can use TODO keyword it will return an exception.
        println("Honda is moving......")
    }

    override fun run() {
      println("Running.........")

    }
    override val name: String
        get() = "Honda Civic"

    override fun default() {
        super<Engine>.default()
        super<Wheels>.default()
        println("By this way we call both the methods")
    }
}


// Inner Class , Nested Class and Anonymous class
open class Gear(val name:String){

    init{
        println("Outer class Init block is called.......")
    }
    class GearBox{
        init{
           println("Nested class init block is called......")
        }
        fun printGear(){
            println("Nested class GearBox.......")
        }
    }

    inner class GearBoxInner{
        init {
            println("Nested Inner class init block is called.....")
        }
        fun printGear(){
            println("Inner class Gear Box ........")
            println("Accessing the outer class name : $name")
        }
    }

    open fun gearBox(){
        println("Main class $name gear box......")
    }
}


//Data Class

//data class User(name:String) // will throw an error as data class must contain only property.
data class User(val name:String,var id:Int)
// Data class can be like this also but we don't use data class like this. Mostly data class are used to store data
// and only single line without any complexity.

data class Post(private val name:String, val number:Int){
    var age:Int = 8
    constructor(name: String, number: Int,age: Int) :this(name,number){
        this.age  = age
    }
}

//Enum class
enum class Metal(val symbol:String){
    IRON("Fe"),
    GOLD("Au"),
    SILVER("Ag"),
    //SODIUM -> we cant change and give a new property to sodium. All objects must be similar this raises an issue
    //To tackle this we can sealed classes.
}
enum class State{
    TALKING{
        override fun state():State{
            return TALKING
        }
        override fun run(){
            println("Talking and running")
        }
    },
    WALKING{
        override fun state(): State{
            return WALKING
        }
    };
    abstract fun state(): State
    open fun run(){
        println("Running")
    }
}

// Sealed Class
sealed class Operation{
    class Addition(val x:Int):Operation()
    class Subtraction(val x:Int) : Operation()
    class Multiplication(val x:Int) : Operation()
    class Division(val x:Int) : Operation()
    object Increment : Operation()
}
sealed class Shapes{
    class Square(val side:Int):Shapes()
    class Rectangle(val height:Int, val Width:Int):Shapes()
}

// Singleton class which have only one instance
object Singleton{
    init{
        println("Singleton class Init value ..... ")
    }
    var score: Int = 0
        private set
    fun setScore(value : Int){
        if(value > 0){
            this.score += value
        }
    }
}
class Static{

    companion object{
        fun classVariable(){
            println("This is same for all the instances of the class..")
        }
    }
}


// Extension Function

// For Int class
fun Int.getEven() = if(this % 2 == 0) this else this+1
//for MutableList
fun MutableList<Int>.swap(index1 : Int, index2: Int){
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun main() {

    val student = Student()
    println("Name of the school is : ${student.school}")
    println("Name of the student is : ${student.name}\nAge of the student is ${student.age}")
    //student.age = 14 //an error
    println("Is Student an teenager : ${student.isTeenager}")
    //student = Student() -> val cannot be reassigned (read-only value)

    println()

    var person = Person("Himanshu","Ranjan")
    println("Person ${person.fName} ${person.lastName} created with age ${person.age} and sex ${person.sex}")

    println("\nNow creating person object with secondary constructor 1 \n")
    person = Person("Himansh","Singh",20)
    println("Persona ${person.fName} ${person.lastName} created with age ${person.age} and sex ${person.sex}")

    println()
    person = Person("Himansh","Singh",20,"Male")
    println("Person with name  ${person.fName} ${person.lastName} created with age ${person.age} and sex ${person.sex}")

    println("\n******************** Inheritance  and Polymorphism *****************\n")
    person = Teacher("XYZ","ABC",43,"Female")
    println(person.toString())
    person.work()
    person.work2()
    println()
    val t1 : Person = Teacher("ABC","XYZ",45,"MALE")
    t1.work() // t1.work2() will not work as it in not known by the compiler since this object is of type Person
    println(t1.toString())
    val p2: Person = Worker("HIM","Ran")
    // Here both are of type Person still at runtime they are executing Teacher and Worker class.
    // This is dynamic polymorphism in which at runtime the type of variable is defined.
    println("---------------------------")
    work(t1)
    work(p2)

    println("***************** Abstraction and Interfaces *******************")
    val honda = Honda()
    honda.start()
    honda.stop()
    val honda1 = Vehicle()
    honda1.start()
    honda1.stop()

    honda.run()
    println("The name of the car is : ${honda.name}")
    honda.default()

    println("\n************** Nested Class , Inner Class and Anonymous class ******************\n")
    Gear.GearBox().printGear() // Outer class constructor is not called and only the inner class constructor is called.
    //Gear("Seven Gears").GearBox().printGear()
    // When tried to access after creating an object of outer class it throws an error.

    Gear("Six Gears").GearBoxInner().printGear()
    println("\nAnonymous Class")
    startGear(object: Gear("Start Gear"){
        override fun gearBox() {
            println("Calling from the overridden method by the anonymous class")
            super.gearBox()
        }
    })
   startGear(object: Gear("Start Gear"){
       override fun gearBox() {
           println("One more override gearBox method.")
       }
   })

    println("\n**************** Data Class *********************\n")

    val user1 = User("Himansh",1)
    val user2 = User("Himansh",1)
    val user3 = User("Himansh",2)
    val user4 = User("Himanshu",2)
    println("user1 = $user1 ") // inside string template using to string is redundant i.e not required.
    print("user2 = ")
    println(user2.toString())
    println("user1 == user2 ? --> ${user1 == user2} and user1 === user2 ? --> ${user1 === user2}") // we can use user1.equals(user2) also.
    println("user2 == user3 ? --> ${user2 == user3}")
    println("user3 == user4 ? --> ${user3 == user4}")

    val userCopy = user1.copy()
    val userCopy1 = user1.copy(name="Singh")
    val userCopy2 = user1.copy(id = 4)
    println("comparing the copy objects : ${userCopy == user1}")
    println("Copied userCop1 1 : $userCopy1")
    println("userCopy2 : $userCopy2")
    println("Dereference the data class")
    val(name,id) = user1
    println("val(name,id) = user1 will deference the object and give the properties as : $name and $id")
    val(nameUser2) = user2
    println("val(nameUser2) = user2 : $nameUser2")

    // Since the properties defined in the primary constructor are equal it does not matter what is defined inside the class
    // it will return true only. i.e in this example the age is different still it returns true.
    val p = Post("HIM",3,4)
    val p1 = Post("HIM",3,5)

    println("p == p1 ? --> ${p == p1}")
    println(p.toString())
    println(p1.toString())
    val copyPost = p.copy()
    println("Copy copies everything from the data class : $copyPost and even the age :${copyPost.age}")

    println("\n**************** ENUM classes ****************\n")
    for(metal in Metal.values()){
        println("Name : ${metal.name} , Symbol : ${metal.symbol} , position : ${metal.ordinal}")
    }
//    println(Metal.IRON.symbol) we can use it like this also.

    for(state in State.values()){
        println("Current state ${state.name}, and action is ${state.state()}")
    }
    println("******************* Sealed Class ********************")

    val temp = Operation.Addition(10)
    println("Executing sealed class : ${execute(10,temp)}")
    val sq = Shapes.Square(10)
    val rec = Shapes.Rectangle(10,15)
    println("Area of sq : ${area(sq)} and Area of rec ${area(rec)}")

    println("**************** Object and Companion object *********************")
    Singleton.setScore(100)
    Singleton.setScore(50)
    println("Score value : ${Singleton.score}")
    Singleton.setScore(23)
    println("Score value : ${Singleton.score}")
    println("Companion object")
    Static.classVariable()

    println("\n*************** Extension Functions ********************")

    println("The even value of 10: ${10.getEven()} and for 11 is : ${11.getEven()}")
    println("Swapping function added for Mutable list")
    val list = mutableListOf(10,20,30,40,50)
    println(list.toString())
    println("Swapping the value of list")
    list.swap(2,4)
    println(list.toString())

}
fun area(shapes: Shapes) = when(shapes){
    is Shapes.Square -> shapes.side* shapes.side
    is Shapes.Rectangle -> shapes.Width * shapes.height
}

fun execute(x: Int, op:Operation) = when(op){
    is Operation.Addition -> x + op.x
    is Operation.Subtraction -> x - op.x
    is Operation.Multiplication -> x * op.x
    is Operation.Division -> x / op.x
    Operation.Increment -> x+1
}
fun startGear(gear: Gear){
    gear.gearBox()
}
fun work(p : Person){
    p.work()
}


