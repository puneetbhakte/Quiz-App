package com.example.quiz

object constants {
    fun getQuestions():ArrayList<question> {
        val QuestionList = ArrayList<question>()
        val que1 = question("which country this flag belong to ?",
            1,R.drawable.flag_of_russia,
            "India","Russia","America","France",
            2)
        QuestionList.add(que1)


        val que2 = question("which country this flag belong to ?",
            2,R.drawable.ic_flag_of_india,
            "India","Russia","America","Pakistan",
            1)
        QuestionList.add(que2)


        val que3 = question("which country this flag belong to ?",
            3,R.drawable.ic_flag_of_argentina,
            "India","Argentina","brazil","Pakistan",
            2)
        QuestionList.add(que3)


        val que4 = question("which country this flag belong to ?",
            4,R.drawable.ic_flag_of_belgium,
            "poland","Russia","Afghanistan","belgium",
            4)
        QuestionList.add(que4)

        val que5 = question("which country this flag belong to ?",
            5,R.drawable.ic_flag_of_new_zealand,
            "India","America","New Zealand","Austria",
            3)
        QuestionList.add(que5)

        val que6 = question("which country this flag belong to ? ", 6,R.drawable.ic_flag_of_brazil,
            "Brazil","Russia","Japan","Finland",
            1)
        QuestionList.add(que6)

        val que7 = question("which country this flag belong to ? ",
            7,R.drawable.ic_flag_of_kuwait,
            "China","Sri Lanka","Kuwait","UAE",
            3)
        QuestionList.add(que7)

        val que8 = question("which country this flag belong to ?",
            8,R.drawable.ic_flag_of_denmark,
            "Denmark","Russia","America","Pakistan",
            1)
        QuestionList.add(que8)

        val que9 = question("which country this flag belong to ?",
            9,R.drawable.ic_flag_of_belgium,
            "Japan","Belgium","Finland","Afghanistan",
            2)
        QuestionList.add(que9)


        val que10 = question("which country this flag belong to ?",
            10,R.drawable.ic_flag_of_germany,
            "India","Germany","America","Pakistan",
            2)
        QuestionList.add(que10)

        return QuestionList
    }
}