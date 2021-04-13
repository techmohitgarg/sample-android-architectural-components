package com.example.sample_android_architectural_components.utils

import com.example.sample_android_architectural_components.listing.data.model.Articles
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ResultTest {

    @Test
    fun `should return loading when status is loading`() {
        // Given
        val givenViewState = Result.Loading
        // Then
        assertEquals(givenViewState, Result.Loading)
    }

    @Test
    fun `should return success when status is success`() {
        // Given
        val givenViewState = Result.Success(emptyList<Articles>())
        // Then
        assertNotNull(givenViewState)
        assertEquals(givenViewState.data.size, 0)
    }

    @Test
    fun `should return error when status is error`() {
        // Given
        val givenViewState = Result.Error("500 Internal Server Error")
        // Then
        assertNotNull(givenViewState)
        assertNotNull(givenViewState.errorMessage)
    }
}