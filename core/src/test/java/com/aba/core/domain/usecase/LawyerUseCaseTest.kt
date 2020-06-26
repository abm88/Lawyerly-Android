package com.aba.core.domain.usecase

import com.aba.core.data.SOME_DOMAIN_LAWYER_ITEMS
import com.aba.core.data.SOME_LAWYER_DOMAIN_MODEL
import com.aba.core.data.SOME_OTHER_LAWYER_DOMAIN_MODEL
import com.aba.core.domain.data.LawyerDomainModel
import com.aba.core.domain.repository.LawyerRepository
import com.aba.core.domain.usecase.LawyerUseCase.*
import com.aba.core.network.ResultResponse
import com.aba.core.network.error.ErrorContainer
import com.aba.core.network.error.ErrorEntity
import com.aba.core.rx.SchedulerProvider
import com.aba.core.rx.TrampolineSchedulerProvider
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.given
import com.nhaarman.mockitokotlin2.verify
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LawyerUseCaseTest {


    private lateinit var param: LawyerParams
    private lateinit var result: TestObserver<ResultResponse<List<LawyerDomainModel>>>
    private val searchParam = LawyerParams()
    private val stubException = Exception()

    private lateinit var schedulerProvider: SchedulerProvider

    @Mock
    private lateinit var mockRepository: LawyerRepository

    @Mock
    private lateinit var errorContainer: ErrorContainer

    private lateinit var subject: LawyerUseCase

    @Before
    fun setup() {
        provideImmediateSchedulers()
        MockitoAnnotations.initMocks(this)
        subject = LawyerUseCase(
            mockRepository,
            schedulerProvider,
            errorContainer
        )
    }

    @Test
    fun `whenOnGetLawyers givenSuccessfulResponse thenResultIsSuccessful`() {
        givenSuccessfulResponse()
        whenOnGetLawyers()
        thenResultIsSuccessful()
        thenRepositoryIsCalled()
    }

    @Test
    fun `whenOnSearch givenFailureResponse thenResultIsFailure`() {
        givenErrorContainer()
        givenFailureResponse()
        whenOnGetLawyers()
        thenResultIsFailure()
        thenRepositoryIsCalled()
    }


    /*
     * Given
     */
    private fun givenSuccessfulResponse() {
        given(mockRepository.getAllLawyers()).willReturn(
            Observable.just(ResultResponse.Success(SOME_DOMAIN_LAWYER_ITEMS))
        )
    }

    private fun givenFailureResponse() {
        given(mockRepository.getAllLawyers()).willReturn(
            Observable.error(stubException)
        )
    }

    private fun givenErrorContainer() {
        given(errorContainer.getError(any())).willReturn(ErrorEntity.Network)
    }


    /*
     * When
     */
    private fun whenOnGetLawyers() {
        result = subject.execute(searchParam).test()
    }


    /*
     * Then
     */
    private fun thenResultIsSuccessful() = with(result) {
        assertComplete()
            .assertNoErrors()
            .assertValues(ResultResponse.Success(listOf(SOME_LAWYER_DOMAIN_MODEL, SOME_OTHER_LAWYER_DOMAIN_MODEL)))
    }

    private fun thenRepositoryIsCalled() {
        verify(mockRepository).getAllLawyers()
    }

    private fun thenResultIsFailure() = with(result) {
        assertComplete()
            .assertValue(ResultResponse.Failure(ErrorEntity.Network))
    }


    /*
     * Helper
     */
    private fun provideImmediateSchedulers() {
        schedulerProvider = TrampolineSchedulerProvider()
    }


}