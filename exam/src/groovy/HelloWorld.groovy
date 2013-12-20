package groovy

/**
 * @author hubery.chen
 */
class HelloWorld {

    static void main(def args) {
        def var = """hello world groovy!"""
        for (def i = 0; i < 5; i++) {
            println var
            println "This is ${i}:${var}"
        }
    }
}
