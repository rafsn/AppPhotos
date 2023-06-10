package br.projeto.appphotos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.projeto.appphotos.adapter.GaleriaAdapter
import br.projeto.appphotos.api.RetrofitHelper
import br.projeto.appphotos.data.Foto
import br.projeto.appphotos.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val jsonAPI by lazy { RetrofitHelper.recuperarServico() }
    private val adapter = GaleriaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = GridLayoutManager(
            this,
            3,
            RecyclerView.VERTICAL,
            false
        )
        binding.recyclerView.adapter = adapter
        recuperarFotos()
    }

    fun recuperarFotos() {


        CoroutineScope(Dispatchers.IO).launch {
            var resposta: Response<List<Foto>>? = null

            try {
                resposta = jsonAPI.recuperarFotos()
            } catch (e: Exception) {
                e.printStackTrace()
            }


            if (resposta != null && resposta.isSuccessful) {
                val fotos = resposta.body()
                if (fotos != null) {
                    withContext(Dispatchers.Main) {
                        adapter.attackFotos(fotos)
                    }
                }
            } else {
                Log.d("Teste API", "Resposta null")
            }
        }
    }
}