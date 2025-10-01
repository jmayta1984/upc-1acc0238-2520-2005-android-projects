package pe.edu.upc.easyshop.features.home.presentation.productdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easyshop.features.home.domain.repositories.ProductRepository
import pe.edu.upc.easyshop.shared.models.Product
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel @Inject constructor(val repository: ProductRepository) : ViewModel() {
    private val _product = MutableStateFlow<Product?>(null)
    val product: StateFlow<Product?> = _product

    fun getProductById(id: Int) {
        viewModelScope.launch {
            _product.value = repository.getProductById(id)
        }
    }

    fun toggleFavorite(id: Int) {
        _product.value?.let { product ->
            viewModelScope.launch {
                if (product.isFavorite) {
                    repository.deleteProduct(product)
                } else {
                    repository.saveProduct(product)
                }
                _product.value = product.copy(
                    isFavorite = !product.isFavorite
                )
            }
        }

    }
}