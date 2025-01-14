package com.study.calendarapp.event;

import java.time.ZonedDateTime;

public class Todo extends AbstractEvent{

    private String description;

    public Todo(int id, String title, ZonedDateTime startAt,
            ZonedDateTime endAt,
                String description){
        super(id, title, startAt, endAt);
        this.description = description; // class에 있는 description은 전달받은 description값으로 세팅
    }

    @Override
    public void print() {
        System.out.printf("[할 일] %s : %s%n", getTitle(), description);
    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.TO_DO;
    }
}
