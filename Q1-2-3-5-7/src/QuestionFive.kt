import java.util.*

/**
 * Created by hlandim on 22/06/18.
 */
fun main(args: Array<String>) {

    val head = Node(1,"msg-1")
    head.next = Node(2, "msg-2")
    head.next!!.next = Node(3,"msg-3")
    head.next!!.next!!.next = Node(4,"msg-2")
    head.next!!.next!!.next!!.next = Node(5,"msg-4")
    head.next!!.next!!.next!!.next!!.next = Node(6,"msg-2")
    println("List before remove duplicates ${printList(head)}")
    deleteDuplicates(head)
    println("List after remove duplicates ${printList(head)}")


}

data class Node(val id:Int, val value: String) {
    var next: Node? = null
}

fun deleteDuplicates(head: Node?) {

    val hashSet = hashSetOf<String>()
    var current = head
    var prev: Node? = null

    while (current != null) {
        val value = current.value

        if (hashSet.contains(value)) {
            prev!!.next = current.next
        } else {
            hashSet.add(value)
            prev = current
        }
        current = current.next
    }

}

fun printList(head: Node?) {

    var headAux = head
    while (headAux != null) {
        print("${headAux.value}, ")
        headAux = headAux.next
    }
}

