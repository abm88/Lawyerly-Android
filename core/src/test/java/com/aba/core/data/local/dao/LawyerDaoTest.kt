package com.aba.core.data.local.dao

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aba.core.data.SOME_LOCAL_FAVORITE_LAWYER
import com.aba.core.data.SOME_LOCAL_LAWYER_ITEMS
import com.aba.core.data.SOME_OTHER_LOCAL_FEATURED_LAWYER
import com.aba.core.data.local.AppDatabase
import com.aba.core.data.local.model.LawyerLocalModel
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LawyerDaoTest {

    private lateinit var database: AppDatabase
    private lateinit var subject: LawyerDao
    private lateinit var result: TestObserver<List<LawyerLocalModel>>


    @Before
    fun setup() {
        database = AppDatabase.getTestInstance(InstrumentationRegistry.getInstrumentation().context)
        subject = database.provideLawyerDao()
    }


    @Test
    fun `givenDatabaseIsEmpty WhenOnInsertItems ThenItemsInserted`(){
        whenOnInsertItems()
        thenItemsInserted()
    }

    @Test
    fun `givenDatabaseIsEmpty whenOnInsertOneItem thenOneItemInserted`(){
        whenOnInsertOneItem()
        thenOneItemInserted()
    }

    @Test
    fun `givenDataBaseIsNotEmpty whenGetAllLawyers thenAllLawyersResultAreAvailable`(){
        givenDataBaseIsNotEmpty()
        whenGetAllLawyers()
        thenAllLawyerResultIsAvailable()
    }


    @Test
    fun `givenDataBaseIsNotEmpty whenGetFavoriteLawyers thenFavoriteLawyersResultAreAvailable`(){
        givenDataBaseIsNotEmpty()
        whenGetFavoriteLawyers()
        thenFavoriteLawyersAreAvailable()
    }

    @Test
    fun `givenDataBaseIsNotEmpty whenGetFeaturedLawyer thenFeaturedLawyersResultAreAvailable`(){
        givenDataBaseIsNotEmpty()
        whenGetFeaturedLawyer()
        thenFeaturedLawyersAreAvailable()
    }


    /*
     Given
     */
    private fun givenDataBaseIsNotEmpty() = whenOnInsertItems()


    /*
     When
     */
    private fun whenOnInsertItems() = subject.insertOrReplace(SOME_LOCAL_LAWYER_ITEMS)

    private fun whenOnInsertOneItem() = subject.insertOrReplace(SOME_LOCAL_FAVORITE_LAWYER)

    private fun whenGetAllLawyers() {
        result = subject.getAllLawyers().test()
    }

    private fun whenGetFavoriteLawyers() {
        result = subject.getFavoriteLawyers().test()
    }

    private fun whenGetFeaturedLawyer() {
        result = subject.getFeaturedLawyers().test()
    }


    /*
     Then
     */

    private fun thenItemsInserted() {
        whenGetAllLawyers()
        with(result){
            assertValueCount(1)
                .assertNoErrors()
                .assertComplete()
                .assertValues(SOME_LOCAL_LAWYER_ITEMS)
        }
    }

    private fun thenOneItemInserted() {
        whenGetAllLawyers()
        with(result){
            assertValueCount(1)
                .assertComplete()
                .assertNoErrors()
                .assertValues(listOf(SOME_LOCAL_FAVORITE_LAWYER))
        }
    }

    private fun thenAllLawyerResultIsAvailable() = with(result){
        assertValueCount(1)
            .assertNoErrors()
            .assertComplete()
            .assertValues(SOME_LOCAL_LAWYER_ITEMS)
    }

    private fun thenFavoriteLawyersAreAvailable() = with(result){
        assertValueCount(1)
            .assertNoErrors()
            .assertComplete()
            .assertValues(listOf(SOME_LOCAL_FAVORITE_LAWYER))
    }

    private fun thenFeaturedLawyersAreAvailable() = with(result){
        assertValueCount(1)
            .assertNoErrors()
            .assertComplete()
            .assertValues(listOf(SOME_OTHER_LOCAL_FEATURED_LAWYER))
    }

}