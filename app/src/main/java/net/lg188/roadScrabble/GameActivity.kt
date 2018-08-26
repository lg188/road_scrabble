package net.lg188.roadScrabble

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val data: MutableList<Player> = mutableListOf<Player>()
        data.add(Player("<Player 1>"))
        data.add(Player("<Player 2>"))

        val list = findViewById<ListView>(R.id.player_list)
        list.adapter = PlayerAdapter(this, data)

    }
}
