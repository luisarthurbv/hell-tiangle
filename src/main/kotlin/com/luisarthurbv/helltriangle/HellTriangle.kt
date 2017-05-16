package com.luisarthurbv.helltriangle

fun calculateHellTriangle(rows: List<List<Int>>): Int {
    if(rows.isEmpty()) {
        throw IllegalArgumentException("Cannot calculate hell triangle with 0 rows")
    }

    var root: Node? = null
    var lastRowNodes: List<Node>? = null
    for((rowIndex, rowValues) in rows.withIndex()) {
        if(rowIndex + 1 != rowValues.size) {
            throw IllegalArgumentException("Invalid triangle row size")
        }

        val currentRowNodes: List<Node> = rowValues.map {
            Node(it)
        }

        if(lastRowNodes != null) {
            lastRowNodes.withIndex().forEach {
                it ->
                it.value.leftNode = currentRowNodes[it.index]
                it.value.rightNode = currentRowNodes[it.index+1]
            }
        }

        if(root == null) {
            root = currentRowNodes[0]
        }

        lastRowNodes = currentRowNodes
    }

    return root!!.maxChildrenPath()
}