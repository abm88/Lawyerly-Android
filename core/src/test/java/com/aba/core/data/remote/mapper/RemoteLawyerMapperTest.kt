package com.aba.core.data.remote.mapper

import com.aba.core.data.SOME_LAWYER_DTO_MODEL
import com.aba.core.domain.data.LawyerDomainModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RemoteLawyerMapperTest {

    private lateinit var subject: RemoteLawyerMapper
    private val remoteItems = listOf(SOME_LAWYER_DTO_MODEL)

    private lateinit var result: List<LawyerDomainModel>


    @Before
    fun setup() {
        subject = RemoteLawyerMapper()
    }

    @Test
    fun `givenLawyerDTOModels whenOnMap thenDTOItemsAreMappedToDomainModels`() {
        whenOnMap()
        thenDTOItemsAreMappedToDomainModels()
    }


    /*
     When
     */
    private fun whenOnMap() {
        result = subject.map(remoteItems)
    }

    /*
     Then
     */
    private fun thenDTOItemsAreMappedToDomainModels() = with(result[0]) {
        assertThat(id).isEqualTo(SOME_LAWYER_DTO_MODEL.id)
        assertThat(firstName).isEqualTo(SOME_LAWYER_DTO_MODEL.firstName)
        assertThat(surName).isEqualTo(SOME_LAWYER_DTO_MODEL.surName)
        assertThat(rate).isEqualTo(SOME_LAWYER_DTO_MODEL.rate)
        assertThat(rating).isEqualTo(SOME_LAWYER_DTO_MODEL.rating)
        assertThat(reviews).isEqualTo(SOME_LAWYER_DTO_MODEL.reviews)
        assertThat(ranking).isEqualTo(SOME_LAWYER_DTO_MODEL.ranking)
        assertThat(speciality).isEqualTo(SOME_LAWYER_DTO_MODEL.speciality)
        assertThat(isBackgroundVerified).isEqualTo(SOME_LAWYER_DTO_MODEL.isBackgroundVerified)
        assertThat(description).isEqualTo(SOME_LAWYER_DTO_MODEL.description)
        assertThat(averageResponseTime).isEqualTo(SOME_LAWYER_DTO_MODEL.averageResponseTime)
        assertThat(memberSince).isEqualTo(SOME_LAWYER_DTO_MODEL.memberSince)
        assertThat(isFeatured).isEqualTo(SOME_LAWYER_DTO_MODEL.isFeatured)
        assertThat(isFavorite).isEqualTo(SOME_LAWYER_DTO_MODEL.isFavorite)
    }

}