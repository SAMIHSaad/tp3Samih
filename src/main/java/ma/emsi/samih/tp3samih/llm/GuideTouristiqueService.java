package ma.emsi.samih.tp3samih.llm;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GuideTouristiqueService {

    private final GuideTouristique guide;

    public GuideTouristiqueService() {
        guide = AiServices.builder(GuideTouristique.class)
                .chatModel(GoogleAiGeminiChatModel.builder()
                        .apiKey(System.getenv("GEMINI_KEY"))
                        .modelName("gemini-2.0-flash")
                        .build())
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .build();
    }

    public String guide(String villeOuPays, int nb) {
        return guide.guide(villeOuPays, nb);
    }
}
