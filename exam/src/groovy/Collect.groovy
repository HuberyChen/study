package groovy

/**
 * @author hubery.chen
 */
class Collect {

    static void main(def args) {
        def collect = ["a", "b", "c"]
        collect.add(1)
        collect << "come on"
        collect[collect.size()] = 100.0

        collect = collect + 5
        collect = collect - "a"

        collect = collect - collect[0..2]
        for (def i = 0; i < collect.size(); i++) {
            println(collect[i])
        }
        println("--------------------")
        println collect?.size();
    }
}
