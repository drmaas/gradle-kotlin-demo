import ratpack.jackson.Jackson.json
import ratpack.kotlin.handling.ratpack

fun main(args: Array<String>) {
    ratpack {
        handlers {
            get {
                render(json(mapOf("status" to "ok")))
            }
        }
    }
}