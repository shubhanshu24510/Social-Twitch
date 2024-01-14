package com.shubhans.socialclone.feature_post.data.repository

import android.net.Uri
import androidx.core.net.toFile
import com.google.gson.Gson
import com.shubhans.socialclone.R
import com.shubhans.socialclone.core.domain.models.Comment
import com.shubhans.socialclone.core.domain.models.Post
import com.shubhans.socialclone.core.domain.models.UserItem
import com.shubhans.socialclone.core.util.Resource
import com.shubhans.socialclone.core.util.SimpleResource
import com.shubhans.socialclone.core.util.UiText
import com.shubhans.socialclone.feature_post.data.remote.PostApi
import com.shubhans.socialclone.feature_post.data.remote.request.CreateCommentRequest
import com.shubhans.socialclone.feature_post.data.remote.request.CreatePostRequest
import com.shubhans.socialclone.feature_post.data.remote.request.LikeUpdateRequest
import com.shubhans.socialclone.feature_post.domain.repository.PostRepository
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.HttpException
import java.io.IOException

class PostRepositoryImpl(
    private val api: PostApi,
    private val gson: Gson
) : PostRepository {

    override suspend fun getPostsForFollows(page: Int, pageSize: Int): Resource<List<Post>> {
        return try {
            val posts = api.getPostsForFollows(
                page = page,
                pageSize = pageSize
            )
            Resource.Success(data = posts)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun createPost(
        description: String,
        imageUri: Uri
    ): SimpleResource {
        val request = CreatePostRequest(description)
        val file = imageUri.toFile()
        return try {
            val response = api.createPost(
                postData = MultipartBody.Part
                    .createFormData(
                        "post_data",
                        gson.toJson(request)
                    ),
                postImage = MultipartBody.Part
                    .createFormData(
                        name = "post_image",
                        filename = file.name,
                        body = file.asRequestBody()
                    )
            )
            if(response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_Error))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun getPostDetails(postId: String): Resource<Post> {
        return try {
            val response = api.getPostDetails(postId = postId)
            if(response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_Error))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun getCommentsForPost(postId: String): Resource<List<Comment>> {
        return try {
            val comments = api.getCommentsForPost(postId = postId).map {
                it.toComment()
            }
            Resource.Success(comments)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun createComment(postId: String, comment: String): SimpleResource {
        return try {
            val response = api.createComment(
                CreateCommentRequest(
                    comment = comment,
                    postId = postId,
                )
            )
            if(response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_Error))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun likeParent(parentId: String, parentType: Int): SimpleResource {
        return try {
            val response = api.likeParent(
                LikeUpdateRequest(
                    parentId = parentId,
                    parentType = parentType
                )
            )
            if(response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_Error))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun unlikeParent(parentId: String, parentType: Int): SimpleResource {
        return try {
            val response = api.unlikeParent(
                parentId = parentId,
                parentType = parentType
            )
            if(response.successful) {
                Resource.Success(response.data)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))
                } ?: Resource.Error(UiText.StringResource(R.string.unknown_Error))
            }
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun getLikesForParent(parentId: String): Resource<List<UserItem>> {
        return try {
            val response = api.getLikesForParent(
                parentId = parentId,
            )
            Resource.Success(response.map { it.toUserItem() })
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }

    override suspend fun deletePost(postId: String): SimpleResource {
        return try {
            api.deletePost(postId)
            Resource.Success(Unit)
        } catch(e: IOException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.error_could_not_found_server)
            )
        } catch(e: HttpException) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.some_wrong)
            )
        }
    }
}