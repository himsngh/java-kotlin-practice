package com.himsngh

import java.lang.Exception

/*
    * Exceptions is a runtime problem and occurs in the program when the compiler don't know what to do with the given
    * info. Exceptions stop the flow of the program. This may be occur due to running out of memory space, array out of
    * bond, condition like divided by zero. To handle this type of problem during program execution the technique of
    * exception handling is used.
    *
    * Exception handling is a technique which handles the runtime problems and maintains the flow of program execution.
    * In Kotlin, all exception classes are descendants of class Throwable.
    * There are four different keywords used in exception handling. These are: try, catch, finally, throw
    * Unchecked exception is that exception which is thrown due to mistakes in our code. This exception type extends
    * RuntimeException class.
    *
    * Kotlin doesn't support checked exception.
    *
    * Try is an expression
    * try is an expression, i.e. it may have a return value: The returned value of a try-expression is either the last
    * expression in the try block or the last expression in the catch block (or blocks). Contents of the finally
    * block do not affect the result of the expression.
    *
    *
 */

fun a(){
    println("a called....")
    b()
    println("back to a....")
}

fun b(){
    val a =  "Himanshu".toInt()
    println(a)
}

fun check(age: Int){
    if(age < 18){
        throw Exception("Under aged !! not allowed further...")
    }
    println("Passed....s")
}

fun main(){
    
    try{
        a()
        println("Executed successfully......")
    }catch (e:Exception){
        println("Exception caught... $e ${e.message}")
    }
    finally{
        println("This will always be printed....")
    }
    println(".......")

    val exceptionTemp = try{ "Himanshu".toInt() } catch (e:Exception){ println("Exception caught"); "Himanshu" }
    println(exceptionTemp)
    val exceptionTemp1 = try{ "123456".toInt() } catch (e:Exception){ println("Exception caught"); "Himanshu" }
    println(exceptionTemp1)

    check(19)
    try{
        check(17)
    }catch (e :Exception){
        println("${e.message}")
    }

    println("-----------------------------------")
    println("Without catch block........ ")

    try{
        a()
    }finally {
        println("This is second finally block.....")
        println("The exception will arise after executing this....")
    }



    // Even with return statement in try block finally will be executed
//    try{
//        return
//    }
//    catch (e:Exception){
//        println("exception $e")
//    }
//    finally {
//        println("How you doin.....")
//    }
     // How you doin.......    in printed

}