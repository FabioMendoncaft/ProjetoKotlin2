package br.com.devmod.atividade2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.devmod.atividade2.base.BaseViewHolder
import br.com.devmod.atividade2.modelo.Animal
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.animais_row.view.*
import java.lang.IllegalArgumentException

class RecyclerAdapter(
    private val context: Context,
    val listaAnimais: List<Animal>,
    private val itemClickListener:OnAnimalClickListener
    ) :RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnAnimalClickListener{
        fun onItemClick(tipo: String)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return AnimaisViewHolder(
            LayoutInflater.from(context).inflate(R.layout.animais_row,parent,false)
        )
    }

    override fun getItemCount(): Int = listaAnimais.size

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is AnimaisViewHolder -> holder.bind(listaAnimais[position], position)
            else -> throw IllegalArgumentException("Esqueci de passar o viewhodel no bind")
        }
    }

    inner class AnimaisViewHolder(itemView: View) : BaseViewHolder<Animal>(itemView){
        override fun bind(item: Animal, position: Int) {
            itemView.setOnClickListener { itemClickListener.onItemClick(item.tipo) }
            Glide.with(context).load(item.image).into(itemView.img_animal)
            itemView.txt_nome_animal.text = item.nome
        }
    }
}