package dev.gilmario.ti.democoroutines.ui.main

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MainRepository {

    fun getFilmes(callback: (filmes: List<Filme>) -> Unit) {
        Thread(Runnable {
            Thread.sleep(5000)
            callback.invoke(
                listOf(
                    Filme(1, "TITULO1"),
                    Filme(2, "TITULO02"),
                    Filme(3, "TITULO03")
                )
            )

        }).start()
    }


    suspend fun getFilmesCoroutines(): List<Filme> {
        return withContext(Dispatchers.Default) {
            delay(3000)
            listOf(
                Filme(1, "TITULO1"),
                Filme(2, "TITULO02"),
                Filme(3, "TITULO03")
            )
        }
    }
}