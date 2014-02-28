package groovy

/**
 * @author hubery.chen
 */
class Closure {

    static void main(def args) {
        def map = ['name': 'John', 'age': '14', 'sex': 'boy']
        map.father = 'Keller'
        map.put('high', 1.27)
        map = map + ['weight': 25]
        //method 1
        map.each { key, value -> println "$key:$value" }
        println("----------------")
        //method 2
        map.each { println it }
        def say = { word -> println "Hi,$word" }
        say("groovy")
        say.call("groovy&java")
    }
}
