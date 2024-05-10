import data.product
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by Karlen Legaspi
 */
class HomeViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<product>>(listOf())
    val products = _products.asStateFlow()

    val homeRepository = HomeRepository()
    init {

        viewModelScope.launch {
            homeRepository.getProducts().collect{ products ->
                _products.update { it + products }
            }
        }

    }
}