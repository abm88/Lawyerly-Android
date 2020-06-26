package com.aba.core.data.local.mapper

import com.aba.core.data.SOME_LAWYER_DOMAIN_MODEL
import com.aba.core.data.SOME_LOCAL_FAVORITE_LAWYER
import com.aba.core.data.local.model.LawyerLocalModel
import com.aba.core.domain.data.LawyerDomainModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LawyerLocalMapperTest {

    private lateinit var subject: LawyerLocalMapper
    private val localItems = listOf(SOME_LOCAL_FAVORITE_LAWYER)
    private val domainItems = listOf(SOME_LAWYER_DOMAIN_MODEL)

    private lateinit var domainResult: List<LawyerDomainModel>
    private lateinit var localResult: List<LawyerLocalModel>


    @Before
    fun setup(){
        subject = LawyerLocalMapper()
    }

    @Test
    fun `givenLawyerLocalModelItems whenMapFromLocal thenInputIsMappedToLawyerDomainModel`() {
        whenMapFromLocal()
        thenInputIsMappedToLawyerDomainModel()
    }

    @Test
    fun `givenLawyerDomainModelItems whenMapToLocal thenInputIsMappedToLawyerLocalModel`(){
        whenMapToLocal()
        thenInputIsMappedToLawyerLocalModel()
    }


    /*
    When
    */
    private fun whenMapFromLocal() {
        domainResult = subject.mapFromLocal(localItems)
    }

    private fun whenMapToLocal() {
        localResult = subject.mapToLocal(domainItems)
    }


    /*
     Then
     */
    private fun thenInputIsMappedToLawyerDomainModel() = with(domainResult[0]){
        assertThat(id).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.id)
        assertThat(firstName).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.firstName)
        assertThat(surName).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.surName)
        assertThat(rate).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.rate)
        assertThat(rating).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.rating)
        assertThat(reviews).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.reviews)
        assertThat(ranking).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.ranking)
        assertThat(speciality).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.speciality)
        assertThat(isBackgroundVerified).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.isBackgroundVerified)
        assertThat(description).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.description)
        assertThat(averageResponseTime).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.averageResponseTime)
        assertThat(memberSince).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.memberSince)
        assertThat(isFeatured).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.isFeatured)
        assertThat(isFavorite).isEqualTo(SOME_LOCAL_FAVORITE_LAWYER.isFavorite)
    }

    private fun thenInputIsMappedToLawyerLocalModel() = with(localResult[0]){
        assertThat(id).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.id)
        assertThat(firstName).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.firstName)
        assertThat(surName).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.surName)
        assertThat(rate).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.rate)
        assertThat(rating).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.rating)
        assertThat(reviews).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.reviews)
        assertThat(ranking).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.ranking)
        assertThat(speciality).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.speciality)
        assertThat(isBackgroundVerified).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.isBackgroundVerified)
        assertThat(description).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.description)
        assertThat(averageResponseTime).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.averageResponseTime)
        assertThat(memberSince).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.memberSince)
        assertThat(isFeatured).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.isFeatured)
        assertThat(isFavorite).isEqualTo(SOME_LAWYER_DOMAIN_MODEL.isFavorite)
    }

}