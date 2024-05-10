import apiClient.httpClient
import data.product
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.flow

/**
 * Created by Karlen Legaspi
 */
class HomeRepository {

    suspend fun getProductsApi() : List<product> {
        val response = httpClient.get("https://api.escuelajs.co/api/v1/products")
        return response.body()
    }

    fun getProducts() = flow {
        emit(getProductsApi())
    }
}