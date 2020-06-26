package com.aba.core.data.remote.datasource

import com.aba.core.base.RemoteMapper
import com.aba.core.data.*
import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.data.network.service.FakeApiService
import com.aba.core.domain.data.LawyerDomainModel
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteDataSourceImplTest {


    @Mock
    lateinit var mockService: FakeApiService

    @Mock
    lateinit var mockMapper: RemoteMapper<List<LawyerDTO>, List<LawyerDomainModel>>

    @InjectMocks
    lateinit var subject: RemoteDataSourceImpl

    private lateinit var result: TestObserver<List<LawyerDomainModel>>


    @Before
    fun setup() {
        givenMapperIsMappingAllDTOLawyerModelsToDomainLawyerModels()
        givenMapperIsMappingFeaturedDTOLawyerModelsToDomainLawyerModels()
        givenMapperIsMappingFavoriteDTOLawyerModelsToDomainLawyerModels()
    }

    @Test
    fun `givenAllLawyerDataIsAvailable whenGetAllLawyers thenAllLawyersResultIsAvailable`() {
        givenAllLawyerDataIsAvailable()
        whenGetAllLawyers()
        thenAllLawyerResultIsAvailable()
    }

    @Test
    fun `givenFeaturedLawyerDataIsAvailable whenGetFeaturedLawyers thenFeaturedLawyersResultIsAvailable`() {
        givenFeaturedLawyerDataIsAvailable()
        whenGetFeaturedLawyers()
        thenFeaturedLawyerResultIsAvailable()
    }


    @Test
    fun `givenFavoriteLawyerDataIsAvailable whenGetFavoriteLawyers thenFavoriteLawyersResultIsAvailable`() {
        givenFavoriteLawyerDataIsAvailable()
        whenGetFavoriteLawyers()
        thenFavoriteLawyersResultIsAvailable()
    }



    /*
     Given
     */
    private fun givenAllLawyerDataIsAvailable() = given(mockService.getAllLawyers()).willReturn(
        Observable.just(SOME_LAWYER_DTO_ITEMS)
    )

    private fun givenFeaturedLawyerDataIsAvailable() =
        given(mockService.getFeaturedLawyers()).willReturn(
            Observable.just(listOf(SOME_OTHER_LAWYER_DTO_MODEL))
        )

    private fun givenFavoriteLawyerDataIsAvailable() =
        given(mockService.getFavoriteLawyers()).willReturn(
            Observable.just(listOf(SOME_LAWYER_DTO_MODEL))
        )

    private fun givenMapperIsMappingAllDTOLawyerModelsToDomainLawyerModels() =
        given(mockMapper.map(SOME_LAWYER_DTO_ITEMS)).willReturn(
            SOME_DOMAIN_LAWYER_ITEMS
        )

    private fun givenMapperIsMappingFeaturedDTOLawyerModelsToDomainLawyerModels() =
        given(mockMapper.map(listOf(SOME_OTHER_LAWYER_DTO_MODEL))).willReturn(
            listOf(SOME_OTHER_LAWYER_DOMAIN_MODEL)
        )


    private fun givenMapperIsMappingFavoriteDTOLawyerModelsToDomainLawyerModels() =
        given(mockMapper.map(listOf(SOME_LAWYER_DTO_MODEL))).willReturn(
            listOf(SOME_LAWYER_DOMAIN_MODEL)
        )


    /*
     When
     */
    private fun whenGetAllLawyers() {
        result = subject.getAllLawyers().test()
    }

    private fun whenGetFeaturedLawyers() {
        result = subject.getFeaturedLawyers().test()
    }

    private fun whenGetFavoriteLawyers() {
        result = subject.getFavoriteLawyers().test()
    }

    /*
     Then
     */
    private fun thenAllLawyerResultIsAvailable() = with(result) {
        assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
            .assertValues(SOME_DOMAIN_LAWYER_ITEMS)
    }

    private fun thenFeaturedLawyerResultIsAvailable() = with(result) {
        assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
            .assertValues(listOf(SOME_OTHER_LAWYER_DOMAIN_MODEL))
    }

    private fun thenFavoriteLawyersResultIsAvailable() = with(result) {
        assertNoErrors()
            .assertComplete()
            .assertValueCount(1)
            .assertValues(listOf(SOME_LAWYER_DOMAIN_MODEL))
    }

}