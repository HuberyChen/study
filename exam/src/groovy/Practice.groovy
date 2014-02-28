package groovy

import org.junit.Test

/**
 * @author hubery.chen
 */
class Practice {

    @Test
    void variableParameter() {
        println sum(1)
        println sum(1, 2)
        println sum(1, 2, 3)
    }

    int sum(int ... var) {
        def total = 0
        for (i in var) {
            total += 1
        }
        return total
    }

}
