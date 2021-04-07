package com.oeong.vo;

import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PhoneSpecsVO {
    @JsonProperty("id")
    private Integer specsId;
    @JsonProperty("name")
    private String specsName;
    @JsonProperty("imgUrl")
    private String specsIcon;
    @JsonProperty("previewImgUrl")
    private String specsPreview;
}

/**
 {
 id: 1,
 name: "32GB",
 imgUrl: "../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg",
 previewImgUrl: "../static/e84a2e03-7f19-41d2-98a5-a5c16b7e252d.jpg"
 }
 */
