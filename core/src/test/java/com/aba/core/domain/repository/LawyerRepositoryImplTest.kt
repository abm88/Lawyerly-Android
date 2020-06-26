package com.aba.core.domain.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.data.SOME_EXCEPTION
import com.aba.core.data.SOME_LAWYER_DOMAIN_MODEL
import com.aba.core.data.SOME_OTHER_LAWYER_DOMAIN_MODEL
import com.aba.core.data.local.datasource.LawyerLocalDataSource
import com.aba.core.data.remote.datasource.RemoteDataSource
import com.aba.core.data.repository.LawyerRepositoryImpl
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.network.ResultResponse
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.junit.MockitoRule


@RunWith(MockitoJUnitRunner::class)
class LawyerRepositoryImplTest {


    @Rule
    lateinit var rule: InstantTaskExecutorRule

    @Rule
    lateinit var mockitoRule: MockitoRule

    @Mock
    lateinit var mockRemoteDataSource: RemoteDataSource

    @Mock
    lateinit var mockLocalModel: LawyerLocalDataSource

    @InjectMocks
    lateinit var subject: LawyerRepositoryImpl

    private var result = TestObserver<ResultResponse<List<LawyerDomainModel>>>()

    @Test
    fun `givenRemoteDataIsAvailable AndGivenLocalDataIsAvailable whenGetAllLawyers thenDataIsAvailable`() {
        givenRemoteDataIsAvailable()
        givenLocalDataIsAvailable()
        whenGetAllLawyers()
        thenDataIsAvailable()
        thenVerifyRemoteDataSourceIsCalled()
        thenVerifyLocalDataSourceIsCalled()
    }

    @Test
    fun `givenRemoteDataIsNotFailure AndGivenLocalDataIsAvailable whenGetAllLawyers thenResultIsFailure`() {
        givenRemoteDataIsNotFailure()
        givenLocalDataIsAvailable()
        whenGetAllLawyers()
        thenResultIsFailure()
        thenVerifyRemoteDataSourceIsCalled()
        thenVerifyLocalDataSourceIsCalled()
    }


    private fun givenRemoteDataIsNotFailure() = given(mockRemoteDataSource.getAllLawyers())
        .willReturn(
            Observable.error(SOME_EXCEPTION)
        )


    /*
     Given
     */
    private fun givenLocalDataIsAvailable() {
//    given(mockLocalModel.getAllLawyers()).willReturn(
//    Observable.just(listOf(SOME_LAWYER_DOMAIN_MODEL)))
    }

    private fun givenRemoteDataIsAvailable() =
        given(mockRemoteDataSource.getAllLawyers()).willReturn(
            Observable.just(listOf(SOME_OTHER_LAWYER_DOMAIN_MODEL))
        )

    /*
     When
     */
    private fun whenGetAllLawyers() {
        result = subject.getAllLawyers().test()
    }

    /*
     Then
     */
    private fun thenDataIsAvailable() = with(result) {
        assertNoErrors()
            .assertComplete()
            .assertValues(
                ResultResponse.Success(listOf(SOME_OTHER_LAWYER_DOMAIN_MODEL))
//                ResultResponse.Success(listOf(SOME_LAWYER_DOMAIN_MODEL))
            )
    }

    private fun thenResultIsFailure() = with(result) {
        assertError(SOME_EXCEPTION)
            .assertNotComplete()
    }

    private fun thenVerifyRemoteDataSourceIsCalled() = verify(mockRemoteDataSource).getAllLawyers()

    private fun thenVerifyLocalDataSourceIsCalled() =
        verify(mockLocalModel, never()).getAllLawyers()
}