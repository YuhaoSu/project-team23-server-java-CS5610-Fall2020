package com.example.cs5610fall2020projectteam23serverjava.services;

import com.example.cs5610fall2020projectteam23serverjava.models.Widget;
import com.example.cs5610fall2020projectteam23serverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class WidgetService {
    @Autowired
            WidgetRepository widgetRepository;

    public List<Widget> findWidgetsForTopic(String tid) {
        return widgetRepository.findWidgetsForTopic(tid);
    }
    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }
    public Widget findWidgetById(Integer widgetId) {
        return widgetRepository.findById(widgetId).get();
    }
    public Widget createWidget(String tid, Widget widget) {
        widget.setTopicId(tid);
        return widgetRepository.save(widget);
    }
    public Widget updateWidget(
            Integer widgetId,
            Widget newWidget) {

        Optional widgetO = widgetRepository.findById(widgetId);
        if(widgetO.isPresent()) {
            Widget widget = (Widget) widgetO.get();
            widget.setName(newWidget.getName());
            widget.setType(newWidget.getType());
            widget.setTopicId(newWidget.getTopicId());
            widget.setText(newWidget.getText());
            widget.setSize(newWidget.getSize());
            widget.setSrc(newWidget.getSrc());
            widget.setWidth(newWidget.getWidth());
            widget.setHeight(newWidget.getHeight());
            widget.setWidgetOrder(newWidget.getWidgetOrder());
            widget.setCssClass(newWidget.getCssClass());
            widget.setStyle(newWidget.getStyle());
            widget.setValue(newWidget.getValue());
            widget.setOrdered(newWidget.getOrdered());
            return widgetRepository.save(widget);
        } else {
            return null;
        }
    }

    public void deleteWidget(
            Integer widgetId) {
        widgetRepository.deleteById(widgetId);
    }


    public List<Widget> saveAllWidget(String topicId, List<Widget> widgetsNew) {
        List<Widget> oldWidgetListById =  widgetRepository.findWidgetsForTopic(topicId);

        for(Widget d: oldWidgetListById){
            widgetRepository.deleteById(d.getId());
        }

        for(Widget s: widgetsNew){
            widgetRepository.save(s);
        }
        return widgetRepository.findWidgetsForTopic(topicId);
    }
}
