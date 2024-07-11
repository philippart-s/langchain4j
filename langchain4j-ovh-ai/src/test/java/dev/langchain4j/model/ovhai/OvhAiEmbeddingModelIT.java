package dev.langchain4j.model.ovhai;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.data.segment.TextSegment;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.model.output.Response;

@EnabledIfEnvironmentVariable(named = "OVHAI_AI_API_KEY", matches = ".+")
public class OvhAiEmbeddingModelIT {

    

    @Test
    void should_embed() {
        EmbeddingModel model = OvhAiEmbeddingModel
        .builder()
        .apiKey(System.getenv("OVHAI_AI_API_KEY"))
        .logRequests(true)
        .logResponses(true)
        .build();

        // given
        TextSegment textSegment = TextSegment.from("Embed this sentence.");

        // when
        Response<Embedding> response = model.embed(textSegment);

        // then
        assertThat(response.content().vector()).hasSize(768);

        assertThat(response.finishReason()).isNull();
    }

    @Test
    void should_embed_with_bge_e5_model() {
        EmbeddingModel model = OvhAiEmbeddingModel
        .builder()
        .apiKey(System.getenv("OVHAI_AI_API_KEY"))
        .baseUrl("https://bge-base-en-v1-5.endpoints.kepler.ai.cloud.ovh.net")
        .logRequests(true)
        .logResponses(true)
        .build();

        // given
        TextSegment textSegment = TextSegment.from("Embed this sentence.");

        // when
        Response<Embedding> response = model.embed(textSegment);

        // then
        assertThat(response.content().vector()).hasSize(768);

        assertThat(response.finishReason()).isNull();
    }
}
