package com.study.calendarapp.event;

import java.time.ZonedDateTime;

public class Nodisturbance extends AbstractEvent {
    public Nodisturbance(int id, String title, ZonedDateTime startAt,
                       ZonedDateTime endAt) {
        super(id, title, startAt, endAt);
    }

    @Override
    public void print() {

    }

    @Override
    public boolean support(EventType type) {
        return type == EventType.NO_DISTURBANCE;
    }
}
