package com.mmozhaiskyi.dataapi

import com.mmozhaiskyi.dataapi.model.GroupApiModel
import com.mmozhaiskyi.dataapi.model.LessonApiModel
import com.mmozhaiskyi.dataapi.model.TeacherApiModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RozkladService {

    @GET("groups")
    fun getGroupsByQuery(@Query("search") query: String): Observable<GroupsResult>

    @GET("teachers")
    fun getTeachersByQuery(@Query("search") query: String): Observable<TeachersResult>

    @GET("groups/{groupId}/lessons")
    fun getLessonsByGroup(@Path("groupId") groupId: String): Observable<LessonsResult>

    @GET("teachers/{teacherId}/lessons")
    fun getLessonByTeacher(@Path("teacherId") teacherId: String): Observable<LessonsResult>

    companion object {

        internal const val BASE_URL = "https://api.rozklad.org.ua/v2/"
    }
}

internal data class GroupsResult(val data: List<GroupApiModel>)

internal data class TeachersResult(val data: List<TeacherApiModel>)

internal data class LessonsResult(val data: List<LessonApiModel>)
