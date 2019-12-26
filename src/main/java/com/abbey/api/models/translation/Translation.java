package com.abbey.api.models.translation;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "translations")
@Data
@Builder
public class Translation {

    @Id
    private String _id;

    private String language;
    private Map<String, Map<String,String>> content;

    public String get_id() {
        return this._id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getLanguage() {
        return this.language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    public Map<String, Map<String, String>> getContent() {
        return this.content;
    }
    public void setContent(Map<String, Map<String, String>> content) {
        this.content = content;
    }
}
