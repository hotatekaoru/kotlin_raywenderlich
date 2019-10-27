package com.example.createmonster.view.allcreatures

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.createmonster.R
import com.example.createmonster.view.creature.CreatureActivity
import com.example.createmonster.viewmodel.AllCreaturesViewModel
import kotlinx.android.synthetic.main.activity_all_creatures.*
import kotlinx.android.synthetic.main.content_all_creatures.*

class AllCreaturesActivity: AppCompatActivity() {

    private lateinit var viewModel: AllCreaturesViewModel
    private val adapter = CreatureAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_creatures)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this).get(AllCreaturesViewModel::class.java)

        creaturesRecyclerView.layoutManager = LinearLayoutManager(this)
        creaturesRecyclerView.adapter = adapter

        viewModel.getAllCreaturesLiveData().observe(this, Observer{ creatures ->
            creatures?.let {
                adapter.updateCreatures(creatures)
            }
        })

        fab.setOnClickListener {
            // TODO: View(Activity)からView(Activity)を呼び出していいのだろうか
            startActivity(Intent(this, CreatureActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear_all -> {
                viewModel.clearAllCreatures()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
