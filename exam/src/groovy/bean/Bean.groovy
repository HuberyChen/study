package groovy.bean

/**
 * @author hubery.chen
 */
class Bean {

    static void main(def args) {
        def person1 = new Person()
        person1.setName("hubery")
        person1.setAge(23)
        println(person1)

        def person2 = new Person(['name': 'hubery', 'age': 23])
        println(person2)
    }
}
