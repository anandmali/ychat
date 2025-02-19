package co.yml.ychat.domain.usecases

import co.yml.ychat.data.api.ChatGptApi
import co.yml.ychat.domain.mapper.toImageGenerated
import co.yml.ychat.domain.mapper.toImageGenerationsParamsDto
import co.yml.ychat.domain.model.ImageGenerationsParams

internal class ImageGenerationsUseCase(private val chatGptApi: ChatGptApi) {

    suspend fun requestImageGenerations(params: ImageGenerationsParams): List<String> {
        val requestDto = params.toImageGenerationsParamsDto()
        val response = chatGptApi.imageGenerations(requestDto)
        return response.getBodyOrThrow().toImageGenerated()
    }
}
