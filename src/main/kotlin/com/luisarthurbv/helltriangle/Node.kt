package com.luisarthurbv.helltriangle
import java.lang.Math.max

class Node(val value: Int) {

    var leftNode: Node? = null
    var rightNode: Node? = null
    var hasCalculated: Boolean = false
    var maxChildrenPath: Int = 0

    fun maxChildrenPath(): Int {
        if(hasCalculated) {
            return maxChildrenPath
        }

        hasCalculated = true
        val leftValue: Int = if(leftNode != null) {
            leftNode!!.maxChildrenPath()
        } else {
            0
        }

        val rightValue: Int = if(rightNode != null) {
            rightNode!!.maxChildrenPath()
        } else {
            0
        }

        maxChildrenPath = max(leftValue, rightValue) + value
        return maxChildrenPath
    }

}