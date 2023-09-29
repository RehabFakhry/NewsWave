package com.the_chance.data.repository

//import com.the_chance.domain.model.Response
//import com.the_chance.domain.repository.AuthRepository
//import kotlinx.coroutines.flow.Flow
//import com.google.firebase.auth.AuthResult
//import com.google.firebase.auth.FirebaseAuth
//import kotlinx.coroutines.flow.catch
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.tasks.await
//import javax.inject.Inject
//
//class AuthRepositoryImpl @Inject constructor(
//    private val firebaseAuth: FirebaseAuth
//): BaseRepository(), AuthRepository {
//    override suspend fun loginUser(
//        email: String,
//        password: String
//    ): Flow<Response<AuthResult>> {
//        return flow {
//            emit(Response.Loading())
//            var result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
//            emit(Response.Success(result))
//        }.catch {
//            emit(Response.Error(it.message.toString()))
//        }
//    }
//
//    override suspend fun signupUser(email: String, password: String) {
//        TODO("Not yet implemented")
//    }
//
//    override suspend fun signupUser(
//        userName: String,
//        email: String,
//        password: String
//    ): Flow<Response<AuthResult>> {
//        return flow {
//            emit(Response.Loading())
//            var result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
//            emit(Response.Success(result))
//        }.catch {
//            emit(Response.Error(it.message.toString()))
//        }
//    }
//}