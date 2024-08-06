package com.bucketlist.project.payload;

import java.util.List;

public class ExperienceResponse {
    private List<ExperienceDTO> content;

    public ExperienceResponse() {
    }

    public ExperienceResponse(List<ExperienceDTO> content) {
        this.content = content;
    }

    public List<ExperienceDTO> getContent() {
        return content;
    }

    public void setContent(List<ExperienceDTO> content) {
        this.content = content;
    }
}
