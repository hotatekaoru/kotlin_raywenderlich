package com.example.createmonster.view.creature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.createmonster.R

class CreatureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_creature)
        configureUI()
    }

    private fun configureUI() {
        // 戻るボタン
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.add_creature)
        // TODO: hide label
    }
}
