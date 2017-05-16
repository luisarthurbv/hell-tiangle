package com.luisarthurbv.helltriangle

import org.junit.Test

class NodeTest() {

    @Test
    fun testNodeWithoutChildren() {
        val n = Node(12)
        val childrenSum = n.maxChildrenPath()
        assert(childrenSum == 12)
    }

    @Test
    fun testNodeWithOneChild() {
        val parent = Node(12)
        val child = Node(6)
        parent.leftNode = child
        val childrenSum = parent.maxChildrenPath()
        assert(childrenSum == 18)
    }

    @Test
    fun testNodeWithTwoChildern() {
        val parent = Node(12)
        val leftChild = Node(6)
        val rightChild = Node(7)
        parent.leftNode = leftChild
        parent.rightNode = rightChild
        val childrenSum = parent.maxChildrenPath()
        assert(childrenSum == 19)
    }

    @Test
    fun testNodeWithGranChildern() {
        val parent = Node(12)

        val leftChild = Node(6)
        val leftGranChildren = Node(9)
        leftChild.rightNode = leftGranChildren
        parent.leftNode = leftChild

        val rightChild = Node(7)
        val rightGranChildren = Node(20)
        rightChild.leftNode = rightGranChildren
        parent.rightNode = rightChild

        val childrenSum = parent.maxChildrenPath()
        assert(childrenSum == 39)
    }


}