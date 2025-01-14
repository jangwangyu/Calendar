package com.study.calendarapp;

import com.study.calendarapp.event.AbstractEvent;
import com.study.calendarapp.event.Meeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class CalendarAppApplication {

    public static void main(String[] args) {
        List<AbstractEvent> list = new ArrayList<>();
        HashSet<String> participants = new HashSet<String>();
        participants.add("danny.kim");

        Meeting meeting1 = new Meeting(
            1, "meeting1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants,"meetingRoomA", "스터디"
        );

    }

}
