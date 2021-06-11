package com.himsngh
/*
   * Variables are null safe in Kotlin until and unless explicitly defined they will not take null.
   * Kotlin Compilers are smart so it interpret the type of variable with being explicitly told .
   * Using var and val we can define two different types of variables .
   * Var is used when we have an mutable type variable i.e it can change its value
   * whereas Val is similar to final in java .It means that once assigned it cannot change is value.
   *
   * Null - Safety
   * In kotlin only safe-call or null-assertion operator calls are allowed to use.
   * To take null in kotlin we specify a special type of operator (?) safe-call operator . To imply the compiler that
   * this variable can be null also. For ex. var name : String? = "" -> The ? defines that this can be null.
   * When using variables that can contain null values we have to take care of the fact that they can be null.
   * for ex: while printing the length of a string variable which can be null we use println(name?.length) the null
   * operator to specify that it can be null and if it is instead of throwing error print null.
   * The null-assertion operator(!!) converts any nullable type to non- nullable type and if the value is null it throws
   * Null Pointer Exception.
   * For ex: var v:String? = "Him" ,   println(v!!.length) if v is not null it will convert v to not nullable and
   * print Him but if it is null then it will throw null-pointer exception .
   * We can also use an if else condition dealing with null called as Elvis-Operator (?:). If the left side is null it
   * will evaluate the right hand side and give the result. For ex. println(name?.length ?: "Sorry the value is null")
   *
   * Type - Casting
   * In kotlin after initializing to a particular data type we cant assign is to any other data type directly as we do
   * in other languages .For ex. In java we can assign an int to long . But in Kotlin this throws an error . We have to
   * explicitly cast the variable to long by using helper functions like toInt() etc.
   * In type casting we can assign the values  to Any keyword which is the parent class of all the types.
   * for ex. val name: Any = "Himanshu" -> Any is the parent of all types so it will take this variable.
   * if (name is String) print(name.length) -> We are checking the type of the variable is name or not.
   * To check if one type conversion to other is successful or not we can use the safe cast operator(as?)
   * var num: Int = 7 , var num2 :Long = num as Long -> will throw an exception of Class Cast exception
   * var num: Int = 7 , var num3 :Long? = num as? Long -> if successful then cast it or else return null
   *
   *
   * Println
   * For printing we can use string concatenation but Kotlin provides an efficient way for this using the $ operator
   * we can use this to point to the variable we want to add . Similar to Python's format string .
   * Similar to java System.out.print and println in Kotlin also we have print and println having the same functionalities.
   *
   *
   * Functions
   * Functions are defined using the fun keyword , followed by the arguments and then the return statement. In Kotlin
   * we have to always return something and when we don't have anything to return we can use the Unit keyword as return
   * type . But we can omit this as the compiler will figure out on itself the return type is Unit.
   * We can pass default arguments in the functions and can also call the functions using the arguments name and in doing so it  doesn't
   * need to be in the specified order.
   * For functions which are just single line return statement we can directly return it ;
   * For ex: fun addNum(a: Int, b: Int) = a+b . this return the sum of the two numbers a and b.
   *
   * String
   * Strings are similar to what we are using till now . In kotlin we have take care of one thing the while concatenating
   * we can't put the first element to be other than string . If so then the compiler will throw an error as other data
   * types don't know concat. There are lots of useful helper functions in the String class to work with.
   * Strings are immutable in Kotlin. We can use + operator for concatenating but we have a better option with String
   * template. A template starts with a $ sign and the given expression to evaluate and it then concat it with the string.
   * for ex. "My name is : $name , and the length of my name is : ${name.length}"
   * There are two types of string in Kotlin . Raw strings and or escaped string .
   * Escaped string is declared using " " and may contain escape characters like \n,\t, \r etc.
   * Raw strings are declared using """ """ and cannot contain any escape character but can be used to define multiline
   * strings.
   *
   *
   * Arrays
   * Arrays are also similar to what we are using .It is an collection of similar data types either of Int, String or etc.
   * We can instantiate an array with -> val arr = arrayOf(1,2,3) and this will give an array of [1,2,3] . There
   * are also other ways through which we can instantiate arrays and of different types. for ex. to create an
   * array of null we can use -> arrayOfNulls(size) . Arrays are mutable in nature and of fixed size. There are also
   * built in methods for creating arrays of primitive data types for ex. var ar = intArrayOf(), IntArray()
   * and many more. To get the size of the array we can use the size function .
   * In arrayOf we can have different data types in a array but not in primitive types like intArrayOf or IntArray which
   * only supports the defined data types.
   * Using the constructor we can define an empty array  of a fixed initial number with a given size. Array(size){init}.
   *
   * Any
   * Since any is the parent class all data types we can define any and use it to store any type of data. For ex.
   * listOf(1,2,"3","4") if we do this then we get  a list of these different data structures but we then cant add or
   * delete anything from the structure to do that we need to specifically define the keyword any.
   * var l = listOf<Any>(now use any data type).
   *
   * Kotlin collection are broadly classified in two categories mutable and immutable. List , Set and map all are
   * both immutable as well as mutable depends on the way they are defined.
   *
 */
fun main(){

    val p = 10 // val p: Int = 10  we don't need to explicitly define the Int the compiler does this for us.
    var n:Int? = 10 // var types can change it value
    val s = "Himanshu"
    // n.compareTo(5) will throw an error we have to make sure that we are handling the fact that the variable can be
    // null and the method call will not work .
    println("The value of n compare to 5 is : ${n?.compareTo(5) ?: "Sorry this is null"} ")
    n = null
    //p = 20 is also not possible since this variable is final and cannot be changed.
    //p = null is also not possible as we have not defined the variable to take nulls.
    println(p)
    println("After updating n to null the value of n compare to 5 is :  ${n?.compareTo(5) ?: "Sorry n is null"} ")
    // We can use string concatenation also using the + operator but this is an efficient Kotlin way of writing.
    println("Hello! $s.\nThe length of your name is: ${s.length}")

//    val number1: String? = null
//    println(number1!!.length ?: 0) // Throws null pointer exception.
    var name: String? = "Himansh"
    println(name!!) // println(name!! ?: "sorry null") No use of elvis operator. as it will not get to that and throw
                        // exception of null pointer.
    name = null
    //println(name!! ?: "Sorry null") this also throws a null pointer exception.
    println(name?.length)

    val num1 = 7 // or even with this -> val num1 = 7
    //val num2: Long = num1 as Long // Class - cast exception
    val num2: Long? = num1 as? Long // now it will not throw an exception and if the cast is not successful it will return null
    print("The value of num2 after cast conversion is : $num2") // Prints the string
    println() // prints the string and moves the cursor to the next line
    println("******************** Functions ************************")

    val number1 = 10
    val number2 = 35
    println("The sum of the $number1 and $number2 : ${addNum(number1,number2)}")
    println("Multiplication of $number1 and $number2 : ${mul(b= number2, a = number1)}")
    println("Using default arguments : ${sub(number1,number2)} ")

    println("****************** Strings ****************************")
    val str = "Himanshu"
    val con = str.toList() // helper function to convert string.
    println("Using str.toList() for string $str we get : $con")
    println("Traversing the string using for loop for(c in str), we can also used many builtin function to traverse like" +
            " string.indices and more to traverse ")
    for(c in str){
        print("$c ")
    }
    println()
    val esStr = "I am an escape string \nand using a new line character and a tab space \t here we go."
    val rawStr = """
        I am an raw String.
        I don't use escape character and have multiline style.
        Use trim Indent to make sure that every new line start from starting or it will be indented.
        like we used in this.
    """.trimIndent()
    println(esStr)
    println(rawStr)

    // Since the variable nam is null the following will evaluate to Himanshu.
    val nam:String? = null
    val tem = nam ?: "Himanshu"
    println(tem)
    println("The use of elvis operator in different scenario : " + name ?: "Him") // in this case it will always be null
    // since first the string concatenation happens and after that the elvis comparison which is not null then.

    println("*************** Important point ******************")
    println("The == operator is used to compare the object's value like .equals in java and the === operator is used to check the reference.")



    println("*****************  ARRAYS *********************")
    val arrInit = Array(10){10}
    println("Initialising array using Array(size){0} ${arrInit.joinToString(", ")}")
    //Different ways to init an array using different data types.
    val arr = IntArray(5){it+1}
    println("Using IntArray(5){it+1} initializer we get : ${arr.contentToString()}")
    val arr1= intArrayOf(5,10,15,20)
    println("The value of arr1 is : ${arr1.contentToString()} with at index 0 the value is : ${arr1[0]}")
    val arr2 = arrayOf(10)
    println("Using arrayOf(10) we get an initialised array of : ${arr2.contentToString()}")
    val arr3 = IntArray(10)
    println("Using IntArray(10) we get : ${arr3.contentToString()} of size  ${arr3.size}")
    // Since we are using an IntArray as an initializer we get it initialised to 0 by default of given size.
    // We can even mention it in after initialising using {1} and it will be 1 now.
    //
    // array can also be of any type in kotlin . ie. we can have any type of data in kotlin. but similar to other
    // data structures problem we have to specify it as an any type other wise we wont be able to modify.
    val varArr = arrayOf<Any>(1,2,4,"him")
    println("The arrayOf can contain different data types in an array -> ${varArr.joinToString(",")}")
    varArr[1] = "Hello" // if any is not defined then this will throw an error.

    println("\n***************** LOOPS AND CONDITIONALS ***************************\n")

    /*
        * Kotlin conditions are similar to other languages with a little modification.
        * In Kotlin If else condition is an expression rather than statement but can be used as an statement also.
        * This means that if else can return some value and can be assigned to a different variable to catch it.
        * If-Else can also be used and written in a single line expression.
        *
        * Switch case in kotlin is when . When is more powerful than switch and can be used in many ways .
        * Just like if in kotlin when is also an expression and can be used to return something.
        * When can also be used with ranges and when used as an expression we have to define a else condition .
        *
        * For loop is similar to what we are using . We use it for iterating the data structures which are iterable .
        * There are various ways through which we can iterate and use for loop like directly iterating the data of the
        * structure of using the .indices or using range based for loop.
        * And similarly while and do while loop
        *
        * Break, Continue are used as always with slight modification we have option to  define where we want to jump
        * to after these statement using @jumpHere . similarly for continue
        *

     */

    val price = 50
    val discount = if(price < 30){
        println("Sorry no discount available.")
        0
    } else if(price < 80){
        if(price <50){
            println("Total cost is less than 50")
            10
        }else{
            println("Cost is more than 50 and less than 80")
            15
        }
    }else {
        println("Total cost is more than 80")
        0.5 * 100
    }
    println("Discount after purchasing with an amount of $price is  : $discount")

    //When

    // use of when with direct input.
//    when(readLine()){
//        "h","i","m","n"-> println("The user input is h, i, m, n")
//        "a","o" -> println("The user input is a,o ")
//    }
    val temp = when(discount.toInt()){
        in 0..10 -> {
            println("The discount is in between 0 to 10")
            discount
        }
        in 11..50 ->{
            println("The discount is in between 10 to 50")
            discount
        }
        else -> {
            println("The discount is not in the range")
            0
        }
    }
    println("The use of when as an expression $temp")

    // two different types of when used in kotlin .
     // can also be used as an range in between that is. 0..10 -> then this expression will be evaluated.
//    when(0){
//        0,1 -> println("o or 1")
//        else ->println("otherwise")
//    }

    // For loop is similar to what we have seen till now .
    var items = arrayOf("Tomato", "potato", "Mango", " apple")
    println("Today's grocery list items are : ")
    for(item in items)
        println(item)
    // we can also have accessed it using indices like
    // for(i in items.indices)
     //       println(items[i])
    println("Range based for loop with step size 2")
    for(i in 1..10 step 2){
        print("$i, ")
    }
    println("\nFor each loop ")
    (1..5).forEach { print(it)}
    println()

    loop@for(i in 0..100 step 10){
        for(j in i..100){
            if(j == 50){
                println("Breaking the entire loop directly")
                break@loop
            }
        }
    }

    println("\n *************** Collections ********************** ")

    /*
      * For  immutable types we use : listOf(), mapOf(), setOf()
      * for mutable list types we use : ArrayList() , arrayListOf(), mutableListOf()
      * for mutable sets : hashSetOf(), mutableSetOf()
      * for mutable map : hashMapOf(), mutableMapOf(), HashMap
      *
      * ArrayList() and arrayListOf() is similar to what we have in java ArrayList. which is mutable and dynamic in size.
      * arrayListOf() return ArrayList() as its type.
      *
      * Map in map.keys and map.values can be used to
   */

    val list1 = listOf("him","ans","hu","sin","gh") // immutable list , of fixed size.
    for(item in list1)print(item)
    println()
    //list1.add() unresolved reference as the list is immutable it does not contains add method.
    //list1.drop(5) this also won't work as the list is immutable.
    //for(item in list1)println(item)
    // We can also define list with any type.

    val list2 = mutableListOf<Any>() // can also use arrayListOf() or ArrayList().
    list2.add("Himanshu")
    list2.add(50)
    list2.add('c')
    println("Printing an mutable list of any data type : $list2")
    list2[1] = 100 // list2.set(2,100)
    list2.removeAt(2)
    list2.add(59)
    list2.remove(59)
    println("After modifying the list $list2")
    //val list3 = ArrayList<Int>() we have to define the type of list while defining ArrayList
    //val list3 = arrayListOf<Int>() similarly in arrayListOf also

    val map = mapOf(62 to "Himanshu", 162 to "hello")
    println("Immutable map : $map")
    //map[162] = "hi" this wont work as this is an immutable data structure.
    val map1 = mutableMapOf(62 to "Himanshu", 162 to "hello")
    map1[162] = "Hello"
    map1[23] = "Namaste"
    println("Mutable map is : $map1")
    //map1["him"] = 32 this wont work as this is type mismatch to what we have defined.
    val map2 = mutableMapOf<Any,Any>()
    map2[1] = "Hello"
    map2["hello"] = 50
    println("mutable map of type any : $map2")

    // HashMap can be used to create map of mutable types and  HashMap is made using HashTable and it does not guarantee
    // order of the elements.
    val hashMap = HashMap<Any,Any>() // hashmap of type any
    hashMap["hello"] = 50
    hashMap[50] = "hello"
    println("Hash map of data type any : $hashMap")

    //similarly the set interface is implemented .
    // setOf, mutableSetOf(), HashSet()

}

fun addNum(a : Int, b: Int): Int{
    return a+b
}
fun mul(a : Int,b: Int) = a * b // single return statement can be return like this in single line.
fun sub(a : Int,b: Int, c:Int = 3): Int{ // Default arguments
    return a-b-c
}