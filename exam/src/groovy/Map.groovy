package groovy

/**
 * @author hubery.chen
 */
class Map {

    static void main(def args) {
        def map = ['name': 'John', 'age': '14', 'sex': 'boy']
        map.father = 'Keller'
        map.put('high', 1.27)
        map = map + ['weight': 25]
        println(map.high)
    }
}
