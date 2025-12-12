package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import com.example.dessertclicker.model.Dessert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertClickerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        DessertClickerUiState()
    )
    val uiState = _uiState.asStateFlow()

    fun updateUiState() {
        _uiState.update { currentState ->
            val dessertsSold = currentState.dessertsSold + 1
            val dessertIndex = determineDessertIndex(dessertList, dessertsSold)
            currentState.copy(
                revenue = currentState.revenue + currentState.currentDessertPrice,
                dessertsSold = dessertsSold,
                currentDessertIndex = dessertIndex,
                currentDessertImageId = dessertList[dessertIndex].imageId
            )
        }
    }

    private fun determineDessertIndex(
        desserts: List<Dessert>,
        dessertsSold: Int
    ): Int {
        var dessertIndex = 0
        desserts.forEachIndexed { index, dessert ->
            if (dessertsSold >= dessert.startProductionAmount) {
                dessertIndex = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more desserts,
                // you'll start producing more expensive desserts as determined by startProductionAmount
                // We know to break as soon as we see a dessert who's "startProductionAmount" is greater
                // than the amount sold.
                return dessertIndex
            }
        }

        return dessertIndex
    }
}