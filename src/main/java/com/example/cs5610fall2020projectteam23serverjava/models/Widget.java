package com.example.cs5610fall2020projectteam23serverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    private String topicId;
    private String text;
    private Integer size;
    private String src;
    private Integer width;
    private Integer height;
    private Integer widgetOrder;
    private String cssClass;
    private String style;
    private String value;
    private Boolean ordered;

    public Widget() {
    }

    public Widget(Integer id, String name, String type, String topicId, String text, Integer size,
                  String src, Integer width, Integer height, Integer widgetOrder, String cssClass,
                  String style, String value, Boolean ordered) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.topicId = topicId;
        this.text = text;
        this.size = size;
        this.src = src;
        this.width = width;
        this.height = height;
        this.widgetOrder = widgetOrder;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
        this.ordered = ordered;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidgetOrder() {
        return widgetOrder;
    }

    public void setWidgetOrder(Integer widgetOrder) {
        this.widgetOrder = widgetOrder;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getOrdered() {
        return ordered;
    }

    public void setOrdered(Boolean ordered) {
        this.ordered = ordered;
    }
}
