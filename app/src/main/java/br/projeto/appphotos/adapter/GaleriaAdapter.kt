package br.projeto.appphotos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.projeto.appphotos.data.Foto
import br.projeto.appphotos.databinding.LayoutItemBinding
import br.projeto.appphotos.holder.GaleriaHolder

class GaleriaAdapter : RecyclerView.Adapter<GaleriaHolder>() {

    private var fotos : List<Foto> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GaleriaHolder {
//        var view = LayoutInflater.from(parent.context).inflate(LayoutItemBinding, parent, false)
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = LayoutItemBinding.inflate(layoutInflater, parent, false)

        return GaleriaHolder(view)
    }

    override fun getItemCount(): Int {
        return fotos.count()
    }

    override fun onBindViewHolder(holder: GaleriaHolder, position: Int) {
        holder.bind(fotos[position])
    }

    fun attackFotos(fotos : List<Foto>){
        this.fotos = fotos
        notifyDataSetChanged()
    }
}