package net.lg188.roadScrabble


class GameFlow {
    val players: List<Player>
    private var currentLetters: String = ""

    companion object {
        // TODO: Hardcoded dutch scores. Implement Rules class for this.
        val scoreMultiplier = intArrayOf(1, 3, 5, 2, 1, 4, 3, 4, 1, 4, 3, 3, 3, 1, 1, 3, 10, 2, 2, 2, 4, 4, 5, 8, 8, 4)

        fun calculateCharScore(char: Char) : Int {

            var ascii = char.toInt()
            var charValue: Int
            if( 96 < ascii &&  ascii < 123 ) {
                charValue = ascii - 97
            } else if(65 < ascii  &&  ascii < 91 ) {
                charValue = ascii - 65
            } else {
                throw Exception("ASCII value is out of bounds, check capitalisation")
            }

            return scoreMultiplier[charValue]
        }
    }

    constructor(players: List<Player> ) {
        if (players.size < 2)
            throw Exception("At least two players are needed to play this game.")
        this.players = players

        // TODO: check rules
        // TODO: store rules
    }


    fun findLicensePlate(plate: String) : String{
        // example:  "1-NCR-123" -> "NCR"
        this.currentLetters =  Regex("[^a-z]", RegexOption.IGNORE_CASE).replace(plate,"")
        return this.currentLetters
    }


    fun attempt(word: String) : Int {
        if(currentLetters == "")
            return 0

        // the word needs to be at least as long as the letters from the license plate
        if(word.length < currentLetters.length)
            return 0


        // check if the word contains the letters of the license plate
        var charLicensePlate = currentLetters.toCharArray()
        var charWord = word.toCharArray()
        var j = 0
        var score = 0
        // check every letter a) if it equals the right letter in the sequence. b) count score
        for (i in charWord){
            // a) check if the letter
            if(i == charLicensePlate[j]) j++

            // b) calculate score
            score += calculateCharScore(i) // TODO: add word bonus here

        }

        if(j < currentLetters.length){
            // not all characters of the license plate were passed
            return 0
        }

        // if word is not dictionary word
        //      return false

        return score
    }

    /*
    fun DictionaryAPICall(call: String) {
        var client = OkHttpClient()

        var url = "d"
        val request = Request.Builder().url(url).build()

        client.newCall(request)/* .enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                response.body().
            }
        })*/
    }
 */

}