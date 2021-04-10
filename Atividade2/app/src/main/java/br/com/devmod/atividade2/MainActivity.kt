package br.com.devmod.atividade2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.devmod.atividade2.modelo.Animal
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),RecyclerAdapter.OnAnimalClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val listaAnimais = listOf(
            Animal(
                "Cachorro",
                R.drawable.cachorro,
                "Espécie: Canis lupus familiaris \nTipo: Doméstico"
            ),
            Animal(
                "Gato",
                R.drawable.gato,
                "Espécie: Felis silvestris catus \nTipo: Domestico"
            ),
            Animal(
                "Elefante Africano",
                R.drawable.elefante,
                "Espécie: Loxodonta africana \nTipo: Selvagem"
            ),
            Animal(
                "Tigre",
                R.drawable.tigre,
                "Espécie: Panthera tigris \nTipo: Selvagem"
            )
        )


        recyclerView.adapter = RecyclerAdapter(this,listaAnimais, this)
    }

    override fun onItemClick(tipo: String) {
        Toast.makeText(this, tipo, Toast.LENGTH_SHORT).show()
    }


}