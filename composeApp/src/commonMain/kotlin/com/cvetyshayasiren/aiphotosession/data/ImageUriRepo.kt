package com.cvetyshayasiren.aiphotosession.data

enum class ImageRatio(val value: Float) {
    SQUARE(1f), PORTRAIT(0.5625f), LANDSCAPE(1.7777f)
}

enum class ImageOpt(
    private val shortPath: String,
    private val ratio: ImageRatio,
    val comment: String
) {
    DUB_CYBER_0(shortPath = "resultDub/modDub_cyber0.png", ratio = ImageRatio.SQUARE,
        comment = "Смри как машет руками то, мужицке"),
    DUB_CYBER_1(shortPath = "resultDub/modDub_cyber1.png", ratio = ImageRatio.SQUARE,
        comment = "Уселся на краю, приуныл чёт, над подойти поддержать парю"),
    DUB_CYBER_2(shortPath = "resultDub/modDub_cyber2.png", ratio = ImageRatio.SQUARE,
        comment = "Заменили пол башки чувачку, такое время"),
    DUB_CYBER_3(shortPath = "resultDub/modDub_cyber3.png", ratio = ImageRatio.SQUARE,
        comment = "Грациозно всталт а?"),
    DUB_CYBER_4(shortPath = "resultDub/modDub_cyber4.png", ratio = ImageRatio.SQUARE,
        comment = "Чтот ток ноги да и всё"),
    DUB_CYBER_5(shortPath = "resultDub/modDub_cyber5.png", ratio = ImageRatio.SQUARE,
        comment = "Пока паря пырил в камеру, его самого прифоткали"),
    DUB_CYBER_6(shortPath = "resultDub/modDub_cyber6.png", ratio = ImageRatio.SQUARE,
        comment = "Обернулся и глядит"),
    DUB_CYBER_7(shortPath = "resultDub/modDub_cyber7.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Ручонки припаковал чтоб не мёрзли видать"),

    DUB_NOIR_0(shortPath = "resultDub/modDub_noir0.png", ratio = ImageRatio.SQUARE,
        comment = "Статно стоит, будт учуял чтот"),
    DUB_NOIR_1(shortPath = "resultDub/modDub_noir1.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Чтоб посмотреть, не обернулась ли она"),
    DUB_NOIR_2(shortPath = "resultDub/modDub_noir2.png", ratio = ImageRatio.PORTRAIT,
        comment = "Задумчив так, чтот обдумал, затеял чтот точно"),
    DUB_NOIR_3(shortPath = "resultDub/modDub_noir3.png", ratio = ImageRatio.SQUARE,
        comment = "Туманный день и взгляд емоё"),
    DUB_NOIR_4(shortPath = "resultDub/modDub_noir4.png", ratio = ImageRatio.PORTRAIT,
        comment = "На лесенке посидеть всегда кайф"),
    DUB_NOIR_5(shortPath = "resultDub/modDub_noir5.png", ratio = ImageRatio.PORTRAIT,
        comment = "Какой важный сел тут, ты ток глянь"),
    DUB_NOIR_6(shortPath = "resultDub/modDub_noir6.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Во тьме чёт шастает а"),
    DUB_NOIR_7(shortPath = "resultDub/modDub_noir7.png", ratio = ImageRatio.PORTRAIT,
        comment = "Смри ещё, этот паря уселся на мосту будто король тут он главный самый"),
    DUB_NOIR_8(shortPath = "resultDub/modDub_noir8.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Накостюмился кудат, причесон оттопырил, неспроста чую"),
    DUB_NOIR_9(shortPath = "resultDub/modDub_noir9.png", ratio = ImageRatio.PORTRAIT,
        comment = "Глазёнки прикрыл, кайфуе"),
    DUB_NOIR_10(shortPath = "resultDub/modDub_noir10.png", ratio = ImageRatio.PORTRAIT,
        comment = "Он понимает что он шикарне сегод"),
    DUB_NOIR_11(shortPath = "resultDub/modDub_noir11.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Чёт какойт свет вдали, а он не боится совсем"),
    DUB_NOIR_12(shortPath = "resultDub/modDub_noir12.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Птицы вдруг разлетались чтот"),
    DUB_NOIR_13(shortPath = "resultDub/modDub_noir13.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Детективне работа пошла тут явно"),


    VI_CYBER_0(shortPath = "resultVi/modVi_cyber0.png", ratio = ImageRatio.SQUARE,
        comment = "Решил тут чуток паря попрыгать, размяться"),
    VI_CYBER_1(shortPath = "resultVi/modVi_cyber1.png", ratio = ImageRatio.SQUARE,
        comment = "Уселся посидеть, ножками поболтать у воды пёс"),
    VI_CYBER_2(shortPath = "resultVi/modVi_cyber2.png", ratio = ImageRatio.SQUARE,
        comment = "Чтот натворил, набедокурил а?"),
    VI_CYBER_3(shortPath = "resultVi/modVi_cyber3.png", ratio = ImageRatio.SQUARE,
        comment = "Окак, чувачок даж оBALDел слегка"),
    VI_CYBER_4(shortPath = "resultVi/modVi_cyber4.png", ratio = ImageRatio.SQUARE,
        comment = "Какойт огонёк красный, над потыкать чтоль"),

    VI_NOIR_0(shortPath = "resultVi/modVi_noir0.png", ratio = ImageRatio.PORTRAIT,
        comment = "Ну машина прёт, разбегайся ёмое"),
    VI_NOIR_1(shortPath = "resultVi/modVi_noir1.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Куда ты лёг емое?"),
    VI_NOIR_2(shortPath = "resultVi/modVi_noir2.png", ratio = ImageRatio.PORTRAIT,
        comment = "На мосту встал, вниз попыривает, думу думает кажись"),
    VI_NOIR_3(shortPath = "resultVi/modVi_noir3.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Что ты за позу выдумал канеш паря"),
    VI_NOIR_4(shortPath = "resultVi/modVi_noir4.png", ratio = ImageRatio.PORTRAIT,
        comment = "Опёрся тут, замотался чтоль емоё?"),
    VI_NOIR_5(shortPath = "resultVi/modVi_noir5.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Хоррор чтот, страшн немног"),
    VI_NOIR_6(shortPath = "resultVi/modVi_noir6.png", ratio = ImageRatio.PORTRAIT,
        comment = "Вот так дождь, потоп прям"),
    VI_NOIR_7(shortPath = "resultVi/modVi_noir7.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Солнце и башка, вайбец прёт емое"),
    VI_NOIR_8(shortPath = "resultVi/modVi_noir8.png", ratio = ImageRatio.PORTRAIT,
        comment = "Кто ж тут лампу повесил, дундук какой?"),
    VI_NOIR_9(shortPath = "resultVi/modVi_noir9.png", ratio = ImageRatio.PORTRAIT,
        comment = "Емое, в луже то стоит, но как!"),

    PAIR_0(shortPath = "resultPair/pair0.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Гдет такую он шляпу раздобыл и притопал, шикарно немног"),
    PAIR_1(shortPath = "resultPair/pair1.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Дело над раскрывать, дететкивы на месте уж"),
    PAIR_2(shortPath = "resultPair/pair2.png", ratio = ImageRatio.LANDSCAPE,
        comment = "У водицы собрались, водопой чтоль у них?"),
    PAIR_3(shortPath = "resultPair/pair3.png", ratio = ImageRatio.LANDSCAPE,
        comment = "На лесенке пырят, кто вверх кто вперёд"),
    PAIR_4(shortPath = "resultPair/pair4.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Ну тут поднакинули ребята стиля, планочку высоко задрали чтот"),
    PAIR_5(shortPath = "resultPair/pair5.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Камеру увидали и отвлеклись от забот своих"),
    PAIR_6(shortPath = "resultPair/pair6.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Спускаются по лесенке дундучата, курточки одинаковые раздобыли гдет"),
    PAIR_7(shortPath = "resultPair/pair7.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Чутка подмокли, видать дождь был"),
    PAIR_8(shortPath = "resultPair/pair8.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Задумчиво так глядят, спокойно"),
    PAIR_9(shortPath = "resultPair/pair9.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Чтож ты в лужу то полез?"),

    PAIR_10(shortPath = "resultPair/pair10.png", ratio = ImageRatio.LANDSCAPE,
        comment = "Луч света как удачно пал"),

    ;

    fun getUri(): String {
        return "$ROOT_LINK/$shortPath"
    }

    fun getRatio(): Float = ratio.value

    companion object {
        const val ROOT_LINK = "https://raw.githubusercontent.com/cvetyshayasiren/aiPhotoSession/refs/heads/content"

        val trashList = listOf<ImageOpt>(
            DUB_CYBER_2, DUB_CYBER_6, DUB_CYBER_7,
            DUB_NOIR_8, DUB_NOIR_9, DUB_NOIR_10, DUB_NOIR_11, DUB_NOIR_12, DUB_NOIR_13,
            VI_CYBER_0, VI_CYBER_4,
            VI_NOIR_3, VI_NOIR_4, VI_NOIR_6, VI_NOIR_8,
            PAIR_1, PAIR_2, PAIR_3, PAIR_5, PAIR_6, PAIR_7, PAIR_8, PAIR_9, PAIR_10
        )

        val loadSet = entries.toSet() - trashList.toSet()

        fun getShuffledTrashList() = trashList.shuffled()
    }
}