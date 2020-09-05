package com.example.kotlinretrofit

import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("posts")
    fun getPostList(): Call<List<Post>>

    @GET("posts/{id}")
    fun singlePost(@Path("id") postId: Int): Call<Post>

    @GET("posts")
    fun getPostWithQuery(@Query("userId") userId: Int): Call<List<Post>>

    @POST("posts")
    @FormUrlEncoded
    fun savePosts(@Body postId: Post): Call<Post>

    @POST("posts")
    fun savePostsWithField(@Field("title") title: String, @Field("body") body: String): Call<Post>

    @DELETE("posts/{id}")
    fun deletePost(@Path("id") postId: Int): Call<Post>
}