package com.cvetyshayasiren.aiphotosession.data

enum class ImageUris(val shortPath: String) {

    DUB_CYBER_0(shortPath = "resultDub/modDub_cyber0.png"),
    DUB_CYBER_1(shortPath = "resultDub/modDub_cyber1.png"),
    DUB_CYBER_2(shortPath = "resultDub/modDub_cyber2.png"),
    DUB_CYBER_3(shortPath = "resultDub/modDub_cyber3.png"),
    DUB_CYBER_4(shortPath = "resultDub/modDub_cyber4.png"),
    DUB_CYBER_5(shortPath = "resultDub/modDub_cyber5.png"),
    DUB_CYBER_6(shortPath = "resultDub/modDub_cyber6.png"),
    DUB_CYBER_7(shortPath = "resultDub/modDub_cyber7.png"),

    DUB_NOIR_0(shortPath = "resultDub/modDub_noir0.png"),
    DUB_NOIR_1(shortPath = "resultDub/modDub_noir1.png"),
    DUB_NOIR_2(shortPath = "resultDub/modDub_noir2.png"),
    DUB_NOIR_3(shortPath = "resultDub/modDub_noir3.png"),
    DUB_NOIR_4(shortPath = "resultDub/modDub_noir4.png"),
    DUB_NOIR_5(shortPath = "resultDub/modDub_noir5.png"),
    DUB_NOIR_6(shortPath = "resultDub/modDub_noir6.png"),
    DUB_NOIR_7(shortPath = "resultDub/modDub_noir7.png"),
    DUB_NOIR_8(shortPath = "resultDub/modDub_noir8.png"),
    DUB_NOIR_9(shortPath = "resultDub/modDub_noir9.png"),
    DUB_NOIR_10(shortPath = "resultDub/modDub_noir10.png"),
    DUB_NOIR_11(shortPath = "resultDub/modDub_noir11.png"),


    VI_CYBER_0(shortPath = "resultVi/modVi_cyber0.png"),
    VI_CYBER_1(shortPath = "resultVi/modVi_cyber1.png"),
    VI_CYBER_2(shortPath = "resultVi/modVi_cyber2.png"),
    VI_CYBER_3(shortPath = "resultVi/modVi_cyber3.png"),

    VI_NOIR_0(shortPath = "resultVi/modVi_noir0.png"),
    VI_NOIR_1(shortPath = "resultVi/modVi_noir1.png"),
    VI_NOIR_2(shortPath = "resultVi/modVi_noir2.png"),
    VI_NOIR_3(shortPath = "resultVi/modVi_noir3.png"),
    VI_NOIR_4(shortPath = "resultVi/modVi_noir4.png"),
    VI_NOIR_5(shortPath = "resultVi/modVi_noir5.png"),
    VI_NOIR_6(shortPath = "resultVi/modVi_noir6.png"),
    VI_NOIR_7(shortPath = "resultVi/modVi_noir7.png"),
    VI_NOIR_8(shortPath = "resultVi/modVi_noir8.png"),
    VI_NOIR_9(shortPath = "resultVi/modVi_noir9.png");

    fun getUri(): String {
        return "$ROOT_LINK/$shortPath"
    }

    companion object {
        const val ROOT_LINK = "https://raw.githubusercontent.com/cvetyshayasiren/aiPhotoSession/refs/heads/content"

        val trashList = listOf<ImageUris>(
            DUB_NOIR_0, DUB_NOIR_3,DUB_NOIR_4,DUB_NOIR_8,DUB_NOIR_10, DUB_NOIR_11,
            DUB_CYBER_1, DUB_CYBER_2, DUB_CYBER_3, DUB_CYBER_6, DUB_CYBER_7,
            VI_NOIR_3, VI_NOIR_4, VI_NOIR_5, VI_NOIR_8,
            VI_CYBER_0, VI_CYBER_2, VI_CYBER_3
        )

        fun getShuffledTrashList() = trashList.shuffled()
    }
}