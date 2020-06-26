package com.aba.core.ui.listing

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.aba.core.HistoryObserver
import com.aba.core.any
import com.aba.core.data.model.lawyer.LawyerRanking
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.domain.usecase.LawyerUseCase
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorEntity
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListingViewModelTest {

    @Mock
    lateinit var mockUseCase: LawyerUseCase

    @InjectMocks
    lateinit var subject: ListingViewModel


    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val testObserver = HistoryObserver<ResultResponse<List<LawyerDomainModel>>>()

    private val someDomainModel = LawyerDomainModel(
        id = "2938",
        firstName = "Joe",
        surName = "gonzalez",
        rate = 60.00,
        rating = 4.5,
        reviews = listOf(),
        ranking = LawyerRanking(1, 20),
        speciality = "Finance",
        isBackgroundVerified = true,
        description = "",
        info = "",
        averageResponseTime = 2,
        memberSince = "Dec 2015",
        isFavorite = true,
        isFeatured = false
    )

    private val someErrorEntity = ErrorEntity.Network

    @Before
    fun setup() {
        observeLawyers()
    }

    @Test
    fun `givenSuccessfulResult whenOnSearch thenResultIsAvailable`() {
        givenSuccessfulResult()
        whenOnGetAllLawyers()
        thenResultIsAvailable()
        thenUseCaseExecuteCalled()
    }

    @Test
    fun `givenFailureResult whenOnSearch thenResultIsFailure`() {
        givenFailureResult()
        whenOnGetAllLawyers()
        thenResultIsFailure()
        thenUseCaseExecuteCalled()
    }

    /*
     Given
     */

    private fun givenFailureResult() = given(mockUseCase.execute(any()))
        .willReturn(Observable.just(ResultResponse.Failure(someErrorEntity)))

    private fun givenSuccessfulResult() = given(mockUseCase.execute(any())).willReturn(
        Observable.just(ResultResponse.Success(listOf(someDomainModel)))
    )

    /*
     When
     */

    private fun whenOnGetAllLawyers() {
        subject.getAllLawyers()
    }


    /*
     Then
     */

    private fun thenUseCaseExecuteCalled() = verify(mockUseCase).execute(any())


    private fun thenResultIsAvailable() =
        assertThat(testObserver.history).contains(ResultResponse.Success(listOf(someDomainModel)))


    private fun thenResultIsFailure() =
        assertThat(testObserver.history).contains(ResultResponse.Failure(someErrorEntity))

    /*
     Helper
     */

    private fun observeLawyers() {
        subject.lawyerLiveData.observeForever(testObserver)
    }
}