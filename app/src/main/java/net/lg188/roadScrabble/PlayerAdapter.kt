package net.lg188.roadScrabble

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PlayerAdapter(context: Context, val dataSource: List<Player>) : BaseAdapter() {

    private val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource.get(position)
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.player_item, parent, false)
        val playerName = rowView.findViewById<TextView>(R.id.player_name)
        val playerScore = rowView.findViewById<TextView>(R.id.player_score)
        val player = getItem(position) as Player
        playerName.text = player.playerName
        playerScore.text = player.playerScore.toString()

        return rowView

    }


}