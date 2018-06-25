/**
 * Created by hlandim on 25/06/18.
 */
fun main(args: Array<String>) {
    val head1 = Node(10, "msg-10")
    head1.next = Node(20, "msg-20")
    head1.next!!.next = Node(30, "msg-30")
    head1.next!!.next!!.next = Node(40, "msg-40")
    head1.next!!.next!!.next!!.next = Node(50, "msg-50")
    head1.next!!.next!!.next!!.next!!.next = Node(60, "msg-60")


    val head2 = Node(25, "msg-25")
    head2.next = head1.next!!.next // Node id 30 -> Intersection
    head2.next!!.next = head1.next!!.next!!.next
    head2.next!!.next!!.next = head1.next!!.next!!.next!!.next
    head2.next!!.next!!.next!!.next = head1.next!!.next!!.next!!.next!!.next

    val interSectionNode = getNode(head1, head2)

    if (interSectionNode.isNullOrBlank()) {
        println("The lists no have intersections")
    } else {
        println("The node of intersection is $interSectionNode")
    }
}

/**
 * function to get the intersection
 * point of two linked lists head1 and head2
 */
fun getNode(head1: Node, head2: Node): String? {
    val c1 = getCount(head1)
    val c2 = getCount(head2)
    val d: Int

    return if (c1 > c2) {
        d = c1 - c2
        getIntersectionNode(d, head1, head2)
    } else {
        d = c2 - c1
        getIntersectionNode(d, head2, head1)
    }
}

fun getCount(node: Node): Int {
    var current: Node? = node
    var count = 0

    while (current != null) {
        count++
        current = current.next
    }

    return count
}


/**
 * function to get the intersection point of two linked
 * lists head1 and head2 where head1 has d more nodes than
 * head2
 */
fun getIntersectionNode(d: Int, node1: Node, node2: Node): String? {
    var i = 0
    var current1: Node? = node1
    var current2: Node? = node2
    while (i < d) {
        if (current1 == null) {
            return null
        }
        current1 = current1.next
        i++
    }
    while (current1 != null && current2 != null) {
        if (current1.id == current2.id) {
            return current1.value
        }
        current1 = current1.next
        current2 = current2.next
    }

    return null
}
