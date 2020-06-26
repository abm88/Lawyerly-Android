package com.aba.core.data

import com.aba.core.data.local.model.LawyerLocalModel
import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.data.model.lawyer.LawyerRanking
import com.aba.core.data.model.lawyer.Review
import com.aba.core.domain.data.LawyerDomainModel
import java.lang.Exception


val SOME_TEXT = "SOME_TEXT"

val SOME_REVIEW = Review(
    title = "Awesome",
    review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
)

val SOME_OTHER_REVIEW = Review(
    title = "Not Bad",
    review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
)

val SOME_REVIEWS = listOf(
    SOME_REVIEW,
    SOME_OTHER_REVIEW
)

val SOME_LOCAL_FAVORITE_LAWYER = LawyerLocalModel(
    id = "2938",
    firstName = "Joe",
    surName = "gonzalez",
    rate = 60.00,
    rating = 4.5,
    reviews = SOME_REVIEWS,
    ranking = LawyerRanking(1, 20),
    speciality = "Finance",
    isBackgroundVerified = true,
    description = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Sed enim ut sem viverra aliquet eget sit amet tellus. Eu ultrices vitae auctor eu augue ut lectus arcu bibendum.
Lobortis mattis aliquam faucibus purus. Quam quisque id diam vel quam.
 Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.
                """.trimIndent(),
    info = """
                    Ultrices neque ornare aenean euismod elementum nisi quis eleifend quam. 
Ornare lectus sit amet est placerat in egestas. Aliquet bibendum enim facilisis gravida neque convallis.
                """.trimIndent(),
    averageResponseTime = 2,
    memberSince = "Dec 2015",
    isFavorite = true,
    isFeatured = false
)

val SOME_OTHER_LOCAL_FEATURED_LAWYER = LawyerLocalModel(
    id = "658",
    firstName = "Aleen",
    surName = "Mcneil",
    rate = 50.00,
    rating = 4.8,
    reviews = SOME_REVIEWS,
    ranking = LawyerRanking(2, 20),
    speciality = "Loan",
    isBackgroundVerified = false,
    description = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Sed enim ut sem viverra aliquet eget sit amet tellus. Eu ultrices vitae auctor eu augue ut lectus arcu bibendum.
Lobortis mattis aliquam faucibus purus. Quam quisque id diam vel quam.
 Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.
                """.trimIndent(),
    info = """
                    Ultrices neque ornare aenean euismod elementum nisi quis eleifend quam. 
Ornare lectus sit amet est placerat in egestas. Aliquet bibendum enim facilisis gravida neque convallis.
                """.trimIndent(),
    averageResponseTime = 2,
    memberSince = "Sep 2015",
    isFavorite = false,
    isFeatured = true
)


val SOME_LAWYER_DOMAIN_MODEL = LawyerDomainModel(
    id = "2938",
    firstName = "Joe",
    surName = "gonzalez",
    rate = 60.00,
    rating = 4.5,
    reviews = SOME_REVIEWS,
    ranking = LawyerRanking(1, 20),
    speciality = "Finance",
    isBackgroundVerified = true,
    description = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Sed enim ut sem viverra aliquet eget sit amet tellus. Eu ultrices vitae auctor eu augue ut lectus arcu bibendum.
Lobortis mattis aliquam faucibus purus. Quam quisque id diam vel quam.
 Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.
                """.trimIndent(),
    info = """
                    Ultrices neque ornare aenean euismod elementum nisi quis eleifend quam. 
Ornare lectus sit amet est placerat in egestas. Aliquet bibendum enim facilisis gravida neque convallis.
                """.trimIndent(),
    averageResponseTime = 2,
    memberSince = "Dec 2015",
    isFavorite = true,
    isFeatured = false
)

val SOME_OTHER_LAWYER_DOMAIN_MODEL = LawyerDomainModel(
    id = "658",
    firstName = "Aleen",
    surName = "Mcneil",
    rate = 50.00,
    rating = 4.8,
    reviews = SOME_REVIEWS,
    ranking = LawyerRanking(2, 20),
    speciality = "Loan",
    isBackgroundVerified = false,
    description = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Sed enim ut sem viverra aliquet eget sit amet tellus. Eu ultrices vitae auctor eu augue ut lectus arcu bibendum.
Lobortis mattis aliquam faucibus purus. Quam quisque id diam vel quam.
 Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.
                """.trimIndent(),
    info = """
                    Ultrices neque ornare aenean euismod elementum nisi quis eleifend quam. 
Ornare lectus sit amet est placerat in egestas. Aliquet bibendum enim facilisis gravida neque convallis.
                """.trimIndent(),
    averageResponseTime = 2,
    memberSince = "Sep 2015",
    isFavorite = false,
    isFeatured = true
)


val SOME_LAWYER_DTO_MODEL = LawyerDTO(
    id = "2938",
    firstName = "Joe",
    surName = "gonzalez",
    rate = 60.00,
    rating = 4.5,
    reviews = SOME_REVIEWS,
    ranking = LawyerRanking(1, 20),
    speciality = "Finance",
    isBackgroundVerified = true,
    description = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Sed enim ut sem viverra aliquet eget sit amet tellus. Eu ultrices vitae auctor eu augue ut lectus arcu bibendum.
Lobortis mattis aliquam faucibus purus. Quam quisque id diam vel quam.
 Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.
                """.trimIndent(),
    info = """
                    Ultrices neque ornare aenean euismod elementum nisi quis eleifend quam. 
Ornare lectus sit amet est placerat in egestas. Aliquet bibendum enim facilisis gravida neque convallis.
                """.trimIndent(),
    averageResponseTime = 2,
    memberSince = "Dec 2015",
    isFavorite = true,
    isFeatured = false
)

val SOME_OTHER_LAWYER_DTO_MODEL = LawyerDTO(
    id = "658",
    firstName = "Aleen",
    surName = "Mcneil",
    rate = 50.00,
    rating = 4.8,
    reviews = SOME_REVIEWS,
    ranking = LawyerRanking(2, 20),
    speciality = "Loan",
    isBackgroundVerified = false,
    description = """
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. 
Sed enim ut sem viverra aliquet eget sit amet tellus. Eu ultrices vitae auctor eu augue ut lectus arcu bibendum.
Lobortis mattis aliquam faucibus purus. Quam quisque id diam vel quam.
 Tellus rutrum tellus pellentesque eu tincidunt tortor aliquam nulla facilisi.
                """.trimIndent(),
    info = """
                    Ultrices neque ornare aenean euismod elementum nisi quis eleifend quam. 
Ornare lectus sit amet est placerat in egestas. Aliquet bibendum enim facilisis gravida neque convallis.
                """.trimIndent(),
    averageResponseTime = 2,
    memberSince = "Sep 2015",
    isFavorite = false,
    isFeatured = true
)

val SOME_EXCEPTION = Exception(SOME_TEXT)

@JvmField
val SOME_LOCAL_LAWYER_ITEMS = listOf(
    SOME_LOCAL_FAVORITE_LAWYER, SOME_OTHER_LOCAL_FEATURED_LAWYER
)

@JvmField
val SOME_DOMAIN_LAWYER_ITEMS = listOf(
    SOME_LAWYER_DOMAIN_MODEL, SOME_OTHER_LAWYER_DOMAIN_MODEL
)

val SOME_LAWYER_DTO_ITEMS = listOf(
    SOME_LAWYER_DTO_MODEL, SOME_OTHER_LAWYER_DTO_MODEL

)
