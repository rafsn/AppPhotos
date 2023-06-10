package br.projeto.appphotos.holder

import androidx.recyclerview.widget.RecyclerView
import br.projeto.appphotos.data.Foto
import br.projeto.appphotos.databinding.LayoutItemBinding
import com.squareup.picasso.Picasso

class GaleriaHolder(var binding: LayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(foto: Foto) {
        Picasso.get().load(foto.url).into(binding.imgItem)
    }
}
