package com.example.myapplication.ui.screen.network

data class JsonResponse(
    val data: List<JsonDataResponse> = emptyList<JsonDataResponse>()
)

data class JsonDataResponse(
    val id: String? = null,
    val type: String? = null
){

    fun compareContent(obj: JsonDataResponse): Boolean = this.id == obj.id

    override fun toString(): String {
        return "id: $id, type: $type"
    }
}
