package com.example.kotlinquiz

class QuestionsBank {
    fun getQuestions(): List<QuestionsList> {
        val questionsLists = mutableListOf<QuestionsList>()
        val question1 = QuestionsList("Where did the first modern Summer Olympic games take place in 1896?",
            "Athens, Greece", "Roma, Italy", "Moscow, Russia", "Paris, France",
            "Athens, Greece", "")
        val question2 = QuestionsList("Which boxer did Muhammad Ali fight in ‘The Rumble in the Jungle’?",
            "Tom Holland", "Tom Cruise", "George Foreman", "Lev Tolstoy",
            "George Foreman", "")
        val question3 = QuestionsList("Which sport takes place in a velodrome?",
            "Hockey", "Tennis", "Formula 1", "Cycling",
            "Cycling", "")
        val question4 = QuestionsList("How many points are awarded for a touchdown in American Football?",
            "45", "15", "6", "4",
            "6", "")
        val question5 = QuestionsList("Which country won the first ever football world cup?",
            "Argentina", "Uruguay", "Brazil", "France",
            "Uruguay", "")
        val question6 = QuestionsList("What has Mohammed Ali’s original name?",
            "Mohammed Salah", "Cassius Clay", "Chidiegwu Chidiebele", "Ezgi Kadri",
            "Cassius Clay", "")
        val question7 = QuestionsList("What is world record time for the 100 metres?",
            "9.58 seconds", "9.48 seconds", "9.18 seconds", "10.58 seconds",
            "9.58 seconds", "")
        val question8 = QuestionsList("How many gold medals has Usain Bolt won?",
            "3", "10", "9", "8",
            "8", "")
        val question9 = QuestionsList("How long is the total distance of a marathon?",
            "45.195 km.", "10.000 km.", "42.195 km", "21.195 km.",
            "42.195 km", "")
        val question10 = QuestionsList("How many players are there on a baseball team?",
            "9 players", "11 players", "5 players", "4 players",
            "9 players", "")

        questionsLists.add(question1)
        questionsLists.add(question2)
        questionsLists.add(question3)
        questionsLists.add(question4)
        questionsLists.add(question5)
        questionsLists.add(question6)
        questionsLists.add(question7)
        questionsLists.add(question8)
        questionsLists.add(question9)
        questionsLists.add(question10)

        return questionsLists
    }
}