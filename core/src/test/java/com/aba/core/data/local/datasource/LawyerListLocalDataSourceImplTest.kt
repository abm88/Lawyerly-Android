package com.aba.core.data.local.datasource

import com.aba.core.base.LocalMapper
import com.aba.core.data.*
import com.aba.core.data.local.dao.LawyerDao
import com.aba.core.data.local.model.LawyerLocalModel
import com.aba.core.domain.data.LawyerDomainModel
import com.nhaarman.mockitokotlin2.given
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LawyerListLocalDataSourceImplTest {

    private var result = TestObserver<List<LawyerDomainModel>>()

    @Mock
    lateinit var lawyerDao: LawyerDao

    @Mock
    lateinit var mapper: LocalMapper<List<LawyerLocalModel>, List<LawyerDomainModel>>

    @InjectMocks
    lateinit var subject: LawyerListLocalDataSourceImpl

    @Before
    fun setUp() {
        givenMapperIsMappingAllLocalLawyerModelsToDomainLawyerModels()
        givenMapperIsMappingFeaturedLocalLawyerModelsToDomainLawyerModels()
        givenMapperIsMappingFavoriteLocalLawyerModelsToDomainLawyerModels()
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
    private fun givenAllLawyerDataIsAvailable() = given(lawyerDao.getAllLawyers()).willReturn(
        Observable.just(SOME_LOCAL_LAWYER_ITEMS)
    )

    private fun givenFeaturedLawyerDataIsAvailable() =
        given(lawyerDao.getFeaturedLawyers()).willReturn(
            Observable.just(listOf(SOME_OTHER_LOCAL_FEATURED_LAWYER))
        )

    private fun givenFavoriteLawyerDataIsAvailable() =
        given(lawyerDao.getFavoriteLawyers()).willReturn(
            Observable.just(listOf(SOME_LOCAL_FAVORITE_LAWYER))
        )

    private fun givenMapperIsMappingFavoriteLocalLawyerModelsToDomainLawyerModels() =
        given(mapper.mapFromLocal(listOf(SOME_LOCAL_FAVORITE_LAWYER))).willReturn(
            listOf(SOME_LAWYER_DOMAIN_MODEL)
        )

    private fun givenMapperIsMappingFeaturedLocalLawyerModelsToDomainLawyerModels() =
        given(mapper.mapFromLocal(listOf(SOME_OTHER_LOCAL_FEATURED_LAWYER))).willReturn(
            listOf(SOME_OTHER_LAWYER_DOMAIN_MODEL)
        )

    private fun givenMapperIsMappingAllLocalLawyerModelsToDomainLawyerModels() =
        given(mapper.mapFromLocal(SOME_LOCAL_LAWYER_ITEMS)).willReturn(
            SOME_DOMAIN_LAWYER_ITEMS
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