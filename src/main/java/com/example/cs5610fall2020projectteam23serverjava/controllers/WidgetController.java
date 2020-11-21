package com.example.cs5610fall2020projectteam23serverjava.controllers;

import com.example.cs5610fall2020projectteam23serverjava.models.Widget;
import com.example.cs5610fall2020projectteam23serverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
    @Autowired
            WidgetService service;

    @GetMapping("/api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
        return service.findWidgetsForTopic(topicId);
    }

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("/api/widgets/{wid}")
    public Widget findWidgetById(
            @PathVariable("wid") Integer widgetId) {
        return service.findWidgetById(widgetId);
    }
    @PostMapping("/api/topics/{tid}/widgets")
    public Widget createWidget(
            @PathVariable("tid") String topicId,
            @RequestBody Widget widget) {
        widget.setTopicId(topicId);
        return service.createWidget(topicId, widget);
    }
    @PutMapping("/api/widgets/{wid}")
    public Widget updateWidget(
            @PathVariable("wid") Integer widgetId,
            @RequestBody Widget newWidget) {
        return service.updateWidget(widgetId, newWidget);
    }

    @PutMapping("/api/topics/{topicId}/widgets")
    public List<Widget> saveAllWidget(
            @PathVariable("topicId") String topicId,
            @RequestBody List<Widget> newWidgetList) {
        return service.saveAllWidget(topicId, newWidgetList);
    }

    @DeleteMapping("/api/widgets/{wid}")
    public void deleteWidget(
            @PathVariable("wid") Integer widgetId) {
        service.deleteWidget(widgetId);
    }
}
