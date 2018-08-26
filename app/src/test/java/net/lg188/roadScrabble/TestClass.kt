package net.lg188.roadScrabble
import org.junit.Test
import org.junit.Assert.*

class TestClass {
    val players = listOf( Player("Player_1"), Player("Player_2"))

    fun init_game():  GameFlow{
        return GameFlow(players)
    }

    @Test
    fun `Catch letters from license plate (simple)`(){
        var game = init_game()

        assertEquals("NCR", game.findLicensePlate("1-NCR-123"))
    }

    @Test
    fun `Attempt a turn with "tst" and "test"`(){
        var game = init_game()
        game.findLicensePlate("tst")
        val d = game.attempt("test")
        assertEquals( 7 ,d)
    }

    @Test
    fun `Attempt a turn with ""`(){
        var game = init_game()
        game.findLicensePlate("tst")
        val d = game.attempt("test")
        assertEquals( 7 ,d)
    }

    @Test
    fun `ASCII bounds score calculation`(){
        assertEquals( 1,GameFlow.calculateCharScore('a'))
        assertEquals( 4,GameFlow.calculateCharScore('z'))
        assertEquals( 10,GameFlow.calculateCharScore('q'))
    }
}