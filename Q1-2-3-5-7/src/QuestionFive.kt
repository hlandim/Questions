import java.util.*

/**
 * Created by hlandim on 22/06/18.
 */
fun main(args: Array<String>) {

    val head = Node("msg-1")
    head.next = Node("msg-2")
    head.next!!.next = Node("msg-3")
    head.next!!.next!!.next = Node("msg-2")
    head.next!!.next!!.next!!.next = Node("msg-4")
    head.next!!.next!!.next!!.next!!.next = Node("msg-2")
    println("List before remove duplicates ${printList(head)}")
    deleteDuplicates(head)
    println("List after remove duplicates ${printList(head)}")


    var list = LinkedList<String>()
    list.add("msg-1")
    list.add("msg-2")
    list.add("msg-3")
    list.add("msg-2")
    list.add("msg-2")
    list.add("msg-6")
    list.add("msg-4")
    list.add("msg-4")
    list.add("msg-4")

    println(list)
    list = deleteDuplicates(list)
    println(list)


}

data class Node(val value: String) {
    var next: Node? = null
}

fun deleteDuplicates(head: LinkedList<String>): LinkedList<String> {

    val hashSet = arrayListOf<String>()

    val iterator = head.iterator()
    while (iterator.hasNext()) {
        val value = iterator.next()
        if (!hashSet.contains(value)) {
            hashSet.add(value)
        }
    }
    return LinkedList(hashSet)

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

