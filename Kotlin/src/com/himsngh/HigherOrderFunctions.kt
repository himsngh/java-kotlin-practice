package com.himsngh

/*
    * Functions (Revision)
    * In Kotlin functions are defined using the fun keyword followed by the function name and then the parameters and
    * then return type. In kotlin it is must that a function must return something so if no return statement provided
    * kotlin return Unit type by default.
    * Default Argument functions are function which have default values. Overriding methods always use the default parameters
    * value as the base method. When overriding a method the default methods must be omitted from the signature.
    * If a default argument function precedes a parameter with no default value in kotlin then , the default value can
    * only be used by the calling function with named arguments.
    * When using named arguments to call a function you can change the order of of the arguments listed.
    *
    * Variable number of arguments (Varargs)
    * A parameter of a function (normally) the last one is marked as the vararg allowing a variable number of arguments
    * to be passed to the function.
    *
    *
    * Infix Functions
    * Functions marked with the infix keyword can also be called using the infix notation ie.(omitting the dot and the
    * parenthesis ) . for ex: infix fun Int.getEven(x:Int) : Int{ return 10}  --> a getEven b or a.getEven(b) is similar
    * in this context.
    * Infix functions must satisfy some conditions to be called as infix functions
    * -> They must be member function or extension function
    * -> They must have a single parameter
    * -> The parameter must not accept variable no of arguments and must have no default argument value.
    *
    * Local Functions
    * Kotlin supports local function i.e function inside a function
    *
    * Higher Order Functions and Lambda Function
    * A higher order function is a function which takes function as a parameter or returns a function as a value.
    * Kotlin functions are first class, which means that they can be stored in variables and data structures , passed
    * as argument to and returned from other higher-order-functions.
    * function types:
    *
    * for ex:
    * //initialization
    *
    * val f1: (Int,Int) -> Int  --> f1 stores a function which takes two int arguments and return type int
    * val f2: (Int,Int) -> Boolean
    * val f0: () -> Unit ---> f3 doesn't take any arguments and return type is unit.
    * val f3: ((String) -> Int)? -> This function can hold null as a value.
    * //declaration
    *
    * f1 = ::addInt  --> the function defined as addInt which matches the given conditions can be referenced from here.
    * f2= {x: Int,y:Int -> x>y} --> this is lambda expression
    * f3 = fun(s:String): Int { return s.length }
    *
    * // Invoking
    * f1.invoke(2,3)
    * f2(3,5)
    * f3("mark")
    *
    * fun addInt(x:Int, y:Int): Int{ return x+ y}
    *
    * To specify a function that can be nullable  --> ((Int,Int) -> Int)?
    * Non-literal values of function types with and without receiver are interchangeable, so that the receiver can
    * stand in for the first parameter, and vice versa. For instance, a value of type (A, B) -> C can be passed or
    * assigned where a A.(B) -> C is expected and the other way around:
    * A Higher order function is invoked either by using f1.invoke() or directly f1() .
    *
    * Lambda Expression and Anonymous Function
    * Lambda Expression and Anonymous Function are called function literal because they are function that are not
    * declared but passed immediately as an expression.
    *
    * A lambda expression is always surrounded by curly braces, parameter declarations in the full syntactic form go
    * inside curly braces and have optional type annotations, the body goes after an -> sign. If the inferred return
    * type of the lambda is not Unit, the last (or possibly single) expression inside the lambda body is treated as
    * the return value.
    * val sum: (Int, Int) -> Int = { x: Int, y: Int -> x + y } // full syntactic lambda expression
    * // can also be written as
    * val sum = {x , y -> x + y}
    * Trailing Lambda
    * In Kotlin, there is a convention: if the last parameter of a function is a function, then a lambda
    * expression passed as the corresponding argument can be placed outside the parentheses:
    * If the lambda is the only argument to that call, the parentheses can be omitted entirely:
    *
    * Return in lambdas
    * Lambdas don't allow return statement . To return from a lambda function we need to make the function inline
    * But then one more issue is the return statement is not local and it will return from main function.
    * So we need to point the return direction also.
    *
    * The lambda expression cannot be generic.
    * It
    * When a lambda expression have only single parameter then the parameter can be omitted and in place of that it can
    * be used to refer to the parameter.
    * for ex:
    * fun length(x: String, fn: (String) -> Int) { println(fn(x)) }
    * f: (String) -> Int = { it.length }
    * length("Himanshu",f)
    * If the lambda parameter is unused then we can replace it with _
    *
    * Anonymous Function
    * An anonymous function is similar to a function except that its name can be omitted.
    * fun(x:Int, y:Int): Int = x+y
    * The anonymous functions are always passed inside the parenthesis not like the lambda in which we can pass it outside
    * also if it the last parameter.
    * It has an explicit return type not like lambda in which we don't have return type and the last expression is the return statement.
    *
    * Closure
    * A lambda expression or anonymous function (as well as a local function and an object expression) can
    *  access its closure, i.e. the variables declared in the outer scope.
    *
    * Functions with receiver types
    * Function types with receiver, such as A.(B) -> C, can be instantiated with a special form of function literals –
    * function literals with receiver.
    * This behavior is similar to extension functions, which also allow you to access the members of the receiver
    * object inside the body of the function.
    *
    * Inline Functions
    * Used in Reified Types, to return from lambda , to prevent runtime overhead
    * Every time a lambda is passed an object is created for that lambda function which is an overhead . to avoid this
    * we create the function as inline. What happens now is that whenever we call the function the whole function code
    * is copied and pasted from where it has been called so now no need to create a new object and the program
    * runs it as an part of the execution without going to the function definition place.
    * We should try to keep the inline function as small as possible.
    * Using higher-order functions imposes certain runtime penalties: each function is an object, and it captures a closure,
    * i.e. those variables that are accessed in the body of the function. Memory allocations (both for function objects
    * and classes) and virtual calls introduce runtime overhead.
    * The inline modifier affects both the function itself and the lambdas passed to it: all of those will be inlined into the call site.
    * Inlining may cause the generated code to grow; however, if we do it in a reasonable way (i.e. avoiding inlining large functions),
    * it will pay off in performance, especially at "metamorphic" call-sites inside loops.
    *
    * No-Inline
    * inline lambda/ anonymous function's parameter can't be stored in a variable . To do this that lambda/anonymous
    * function must be marked noinline .
    *
    * CrossInline
    * Lambdas return are non local and to explicitly tell the compiler not to use the return statement in this lambda
    * we use the cross inline with the required function.
    *
    *
    *
    *
 */

// Variable Number of Arguments (vararg)

fun <T> asList(vararg t:T) : List<T>{
    val list = ArrayList<T>()
    for(i in t){
        list.add(i)
    }
    return list
}
//Infix
infix fun Int.incrementBy(value:Int):Int{
    return this+value
}

// Higher Order Functions



fun main(){
    println("******* Variable Number of Arguments *************")
    val list1 = asList(1,2,3,4)
    println(list1)
    val l = arrayOf(1,2,3,4)
    val list2 = asList(-1,-2,-3,*l,2,3) // *l is used to expand the array of l
    println(list2)

    println("\n*********** Infix Function *************")
    println("Calling using normal notation : ${10.incrementBy(11)}")
    println("Calling infix function using prefix notation i.e a getEven b ${10 incrementBy 11}")

    println("****************** Higher Order Functions *************************")
    var f1:(Int,Int) -> Int // F1 is a function with input parameters of type int and return type of int;
    f1 = ::addInt
    println("Add Int using f1.invoke() ${f1.invoke(4,5)} using f1() ${f1(4,5)}")
    f1 = {x,y -> x - y}
    println("Sub Int using f1.invoke(4,5) ${f1.invoke(4,5)} and using f1(4,5) ${f1(4,5)}")
    //f1 = ::compare can't do this because f1 requires Int,Int and returns Int whereas compare return boolean
    var f2:(Int,Int) -> Boolean
    //f2 = ::compare this will work now
    f2 = {x,y -> x > y} // different way to do it .
    println("Comparing : 4 > 5  ${f2(4,5)}")
    f2 = ::compare
    println("Comparing : 4 > 5  ${f2(4,5)}")


    // different ways to call an higher order functions

    higherOrder(4,5, ::addInt)

    //In Kotlin, there is a convention: if the last parameter of a function is a function, then a
    // lambda expression passed as the corresponding argument can be placed outside the parentheses:

    higherOrder(4,5) { x, y -> x - y } // this is also valid  ( higherOrder(4,5, {x,y -> x -y})
    higherOrder(4,5) {x,y -> x * y}
    higherOrder(4,5 ,(fun(x,y) = (x*10) / y) ) // this is an example of anonymous function and this should be inside the parenthesis.

    val fn:(String) -> Int = higherOrderReturn()
    println("Using the returned function the length of Himanshu is : ${fn("himanshu")}")

    val repeatFun: String.(Int) -> String = {times -> this.repeat(times)}

    println("String.Int and (String,Int) : ${runTransformation(repeatFun)} ")

    println("*************")
    val list = listOf(1,2,3,4,5,6,7,8,9,10)
    list.fold(0,{
        acc:Int , nextElement: Int ->
        println("Initial sum = $acc")
        val result = acc + nextElement
        println("Current result ($acc + $nextElement)  : $result")
        result
    })

    val joinToString = list.fold("Element : ") {acc, i -> "$acc $i"} // we can even do this
    println(joinToString)

    // this statement will not go further and the lambda return will return from the main also
//    printSum{ x:Int?,y:Int ->
//        println("Starting the lambda expression")
//        if(x == null)  return else println("The sum of $x and $y is ${x+y}")
//    }
//    println("Done execution")

    // Here we have explicitly mentioned the return position.
    printSum{ x:Int?,y:Int ->
        println("Starting the lambda expression")
        if(x == null)  return@printSum else println("The sum of $x and $y is ${x+y}")
    }
    println("Done Execution")

    println("**************** IT *****************")
    val f: (String) -> Int = {it.length}
    printLen("Himanshu",f)
    printLen("Himanshu") { it.length }

    println("*********************** -- Anonymous -- ****************************")
    println("Printing the length using anonymous function")
    printLen("Himanshu",fun(s) = s.length)

    println("------------ Closure --------------- ")
    //printNext()  no use as it is not stored in any variable so the return statement is vanished.
    val n = printNext()
    n()
    n()
    n()

    val printSum3: Int.(Int) -> Unit = { println("The sum of $this and $it is ${plus(it)} . \nWe can also use " +
            "this.plus(it) but even without this it's fine and will work." +
            "This is an example of function with receiver type.")}

    val i = 10
    i.printSum3(20)

    val printSum2: Int.(Int) -> Unit = fun Int.(num: Int) :Unit = println("The sum is ${plus(num)}")
    i.printSum2(20)

    println("*************** noinline ******************")
    noInline("Himanshu",{println(it)}, 10,20){x,y->println("The sum of the two numbers $x and $y is ${x+y}")}

    println("************* cross inline *************")
    printString("Himanshu"){println(it);return}
    printString("Himanshu"){println(it)}// now return is not allowed.

}

//Cross inline
//without cross inline
inline fun printString(name:String, f: (String)->Unit){
    f(name)
    println("This will not be executed if cross inline is not present.")
}
//with cross inline
inline fun printString2(name:String, crossinline f: (String)->Unit){
    f(name)
    println("This will not be executed if cross inline is not present.")
}
//no inline

inline fun noInline(name:String, f:(String)->Unit,x: Int, y:Int ,noinline f2: (Int,Int)-> Unit){
    f(name)
    printSum2(x,y,f2)
    //without the no inline modifier f2 can't be passed and will give an error.
}
fun printSum2(x: Int,y:Int, f: (Int,Int) -> Unit){
    f(x,y)
}
// Closure
fun printNext(): () -> Unit{
    var a = 0
    return {
        a++
        println("The count is : $a")
    }
}
fun printLen(x:String, f:(String) -> Int){
    println(f(x))
}
inline fun printSum(fn:(x:Int?, y: Int)-> Unit) {
    val x = null
    val y = 10
    fn(x,y)
    println("Done with the function printSum")
}

fun <T,R> Collection<T>.fold(
        initial : R,
        combine : (acc : R, nextElement : T)-> R
): R{
    var accumulator = initial
    for (item in this){
        accumulator = combine(accumulator, item)
    }
    return accumulator
}

fun runTransformation(f: (String, Int) -> String) : String{
    return f("Hello ",3)
}
fun higherOrderReturn():(String) -> Int{
    return {x:String -> x.length}
}
fun higherOrder(x: Int,y:Int, fn:(Int,Int) -> Int){
    val result = fn(x,y)
    println("The result is : $result")
}

fun addInt(x: Int, y: Int) = x+y
fun compare(x: Int, y:Int) = x > y