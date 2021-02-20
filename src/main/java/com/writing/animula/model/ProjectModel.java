package com.writing.animula.model;

import com.writing.animula.entity.Author;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel(value = "ProjectModel")
public class ProjectModel {

    @ApiModelProperty(value = "Generated ID",
            dataType = "Long")
    private String id;

    @ApiModelProperty(value = "Projectname",
            dataType = "String")
    private String name;

    @ApiModelProperty(value = "Description",
            dataType = "String")
    private String description;

    @ApiModelProperty(value = "Author",
            dataType = "String")
    private Author author;

    @ApiModelProperty(value = "Wordcount",
            dataType = "Long")
    private Long wordcount;

    @ApiModelProperty(value = "Activity",
            dataType = "String")
    private String activity;

    @ApiModelProperty(value = "Content",
            dataType = "byte[]")
    private byte[] content;

    @ApiModelProperty(value = "Published",
            dataType = "Boolean")
    private Boolean published;

    @ApiModelProperty(value = "Created",
            dataType = "LocalDate")
    private LocalDate created;

    @ApiModelProperty(value = "LastModified",
            dataType = "LocalDate")
    private LocalDate lastModified;

}
