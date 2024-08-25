package com.devoxx.genie.model.request;

import static com.devoxx.genie.model.Constant.GOOGLE_SEARCH_ACTION;
import static com.devoxx.genie.model.Constant.TAVILY_SEARCH_ACTION;

import com.devoxx.genie.model.LanguageModel;
import com.intellij.openapi.project.Project;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.chat.StreamingChatLanguageModel;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatMessageContext {
    private final LocalDateTime createdOn = LocalDateTime.now();
    private String name;
    private Project project;
    private Integer timeout;
    private String userPrompt;
    private UserMessage userMessage;
    private AiMessage aiMessage;
    private String context;
    private String actionCommand;
    private EditorInfo editorInfo;
    private LanguageModel languageModel;
    private ChatLanguageModel chatLanguageModel;
    private StreamingChatLanguageModel streamingChatLanguageModel;
    private int totalFileCount;



    @Builder.Default
    private boolean webSearchRequested = false;

    @Builder.Default
    private boolean fullProjectContextAdded = false;

    // Custom method
    public boolean hasFiles() {
        return totalFileCount > 0;
    }
    public boolean isWebSearchRequested() {
        return TAVILY_SEARCH_ACTION.equals(actionCommand) || GOOGLE_SEARCH_ACTION.equals(actionCommand);
    }

}
