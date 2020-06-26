package com.aba.core.data.helper

import com.aba.core.data.model.lawyer.LawyerDTO
import com.aba.core.data.model.lawyer.LawyerRanking
import com.aba.core.data.model.lawyer.Review

class DataGenerator {
    companion object {
        val reviews = listOf<Review>(
            Review(
                title = "Awesome",
                review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            ),
            Review(
                title = "Not Bad",
                review = "Lorem ipsum dolor sit amet, consectetur adipiscing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
            )
        )
        val lawyerOne = LawyerDTO(
            id = "2932",
            firstName = "Joe",
            surName = "gonzalez",
            rate = 60.00,
            rating = 4.5,
            reviews = reviews,
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
            isFavorite = false,
            isFeatured = false
        )

        val lawyerTwo = LawyerDTO(
            id = "651",
            firstName = "Aleen",
            surName = "Mcneil",
            rate = 50.00,
            rating = 4.8,
            reviews = reviews,
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
            isFavorite = true,
            isFeatured = false
        )

        val lawyerThree = LawyerDTO(
            id = "258",
            firstName = "Marisa",
            surName = "Wengert",
            rate = 55.00,
            rating = 4.2,
            reviews = reviews,
            ranking = LawyerRanking(3, 20),
            speciality = "IT",
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
            averageResponseTime = 1,
            memberSince = "Oct 2017",
            isFavorite = true,
            isFeatured = true
        )

        val lawyerFour = LawyerDTO(
            id = "154358496",
            firstName = "Rayford",
            surName = "Teeter",
            rate = 45.00,
            rating = 4.9,
            reviews = reviews,
            ranking = LawyerRanking(4, 20),
            speciality = "Construction",
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
            averageResponseTime = 3,
            memberSince = "Sep 2017",
            isFavorite = true,
            isFeatured = false
        )

        val lawyerFive = LawyerDTO(
            id = "99123",
            firstName = "Ronald",
            surName = "Joslin",
            rate = 48.00,
            rating = 4.6,
            reviews = reviews,
            ranking = LawyerRanking(5, 20),
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
            memberSince = "Oct 2015",
            isFavorite = false,
            isFeatured = true
        )

        val lawyerSix = LawyerDTO(
            id = "6625369",
            firstName = "Antony",
            surName = "McGill",
            rate = 65.00,
            rating = 4.4,
            reviews = reviews,
            ranking = LawyerRanking(6, 20),
            speciality = "Finance",
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
            averageResponseTime = 1,
            memberSince = "May 2018",
            isFavorite = false,
            isFeatured = true
        )

        val lawyerSeven = LawyerDTO(
            id = "7713254",
            firstName = "Noami",
            surName = "George",
            rate = 58.00,
            rating = 4.5,
            reviews = reviews,
            ranking = LawyerRanking(7, 20),
            speciality = "IT",
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
            averageResponseTime = 1,
            memberSince = "July 2017",
            isFavorite = true,
            isFeatured = false
        )

        val lawyerEight = LawyerDTO(
            id = "2933",
            firstName = "Vanesa",
            surName = "Sistrunt",
            rate = 64.00,
            rating = 4.7,
            reviews = reviews,
            ranking = LawyerRanking(8, 20),
            speciality = "Agriculture",
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
            memberSince = "Dec 2016",
            isFavorite = true,
            isFeatured = false
        )

        val lawyerNine = LawyerDTO(
            id = "2932",
            firstName = "Carson",
            surName = "Schuldt",
            rate = 55.00,
            rating = 4.1,
            reviews = reviews,
            ranking = LawyerRanking(9, 20),
            speciality = "Finance",
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
            averageResponseTime = 1,
            memberSince = "Sep 2019",
            isFavorite = false,
            isFeatured = true
        )

        val lawyerTen = LawyerDTO(
            id = "997",
            firstName = "Lorean",
            surName = "Leonard",
            rate = 55.00,
            rating = 4.6,
            reviews = reviews,
            ranking = LawyerRanking(10, 20),
            speciality = "Agriculture",
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
            averageResponseTime = 3,
            memberSince = "May 2017",
            isFavorite = false,
            isFeatured = true
        )


        val lawyerEleven = LawyerDTO(
            id = "1230",
            firstName = "Donald",
            surName = "Simson",
            rate = 65.00,
            rating = 4.8,
            reviews = reviews,
            ranking = LawyerRanking(11, 20),
            speciality = "IT",
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
            averageResponseTime = 1,
            memberSince = "Oct 2015",
            isFavorite = false,
            isFeatured = false
        )


        val lawyerTwelve = LawyerDTO(
            id = "990",
            firstName = "George",
            surName = "Lorem",
            rate = 65.00,
            rating = 4.3,
            reviews = reviews,
            ranking = LawyerRanking(12, 20),
            speciality = "Agriculture",
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
            memberSince = "Oct 2018",
            isFavorite = false,
            isFeatured = true
        )


        val allLawyers = listOf(
            lawyerOne, lawyerTwo, lawyerThree,
            lawyerFour, lawyerFive, lawyerSix,
            lawyerSeven, lawyerEight, lawyerNine,
            lawyerTen, lawyerEleven, lawyerTwelve
        )

        val featuredLawyer = listOf(
            lawyerEleven,
            lawyerNine,
            lawyerThree,
            lawyerFive,
            lawyerTen,
            lawyerSeven,
            lawyerOne
        )

        val favoriteLawyers =
            listOf(lawyerSeven, lawyerTwelve, lawyerSix, lawyerEleven, lawyerEight)
    }

}