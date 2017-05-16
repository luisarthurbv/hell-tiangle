package com.luisarthurbv.helltriangle

import org.junit.Test

class HellTriangleTest() {

    @Test
    fun testSimpleHellTriangle() {
        val rows: List<List<Int>> = listOf(
                listOf(6),
                listOf(3, 5),
                listOf(9, 7, 1),
                listOf(4, 6, 8, 4)
        )
        val hellTriangleValue = calculateHellTriangle(rows)
        assert(hellTriangleValue == 26)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testNoRows() {
        calculateHellTriangle(listOf())
    }

    @Test(expected = IllegalArgumentException::class)
    fun testInvalidRowSize() {
        val rows: List<List<Int>> = listOf(
                listOf(6),
                listOf(3, 5, 3),
                listOf(9, 7, 1),
                listOf(4, 6, 8, 4)
        )
        calculateHellTriangle(rows)
    }

}