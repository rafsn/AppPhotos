package br.projeto.appphotos.api

import br.projeto.appphotos.data.Foto
import br.projeto.appphotos.data.Post
import retrofit2.Response
import retrofit2.http.GET

interface JsonAPI {

    @GET("photos")
    suspend fun recuperarFotos(): Response<List<Foto>>

    @GET("posts")
    suspend fun recuperarPosts(): Response<List<Post>>
}