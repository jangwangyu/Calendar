package com.study.calendarapp;

import com.study.calendarapp.event.*;
import com.study.calendarapp.event.update.UpdateMeeting;
import com.study.calendarapp.reader.EventCsvReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class CalendarAppApplication {

    public static void main(String[] args) throws IOException {
        // List<AbstractEvent> list = new ArrayList<>();
        Schedule schedule = new Schedule();

        EventCsvReader csvReader = new EventCsvReader();
        String meetingCsvPath = "/data/meeting.csv";

        List<Meeting> meetings = csvReader.readMeetings(meetingCsvPath);
        meetings.forEach(schedule::add);

        Meeting meeting = meetings.get(0);
        meeting.print();

        System.out.println("수정 후.....");

        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "new title",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "A",
                        "new agenda"
                )
        );

        meeting.delete(true);
        System.out.println("삭제 후 수정 시도.....");
        meetings.get(0).validateAndUpdate(
                new UpdateMeeting(
                        "new title2",
                        ZonedDateTime.now(),
                        ZonedDateTime.now().plusHours(1),
                        null,
                        "B",
                        "new agenda2"
                )
        );
        meeting.print();

        /*HashSet<String> participants = new HashSet<String>();
        participants.add("danny.kim");

        Meeting meeting1 = new Meeting(
            1, "meeting1", ZonedDateTime.now(), ZonedDateTime.now().plusHours(1),
                participants,"meetingRoomA", "스터디"
        );

        schedule.add(meeting1);

        Todo todo1 = new Todo(
                2,"todo1",
                ZonedDateTime.now().plusHours(3), ZonedDateTime.now().plusHours(4),
                "할 일 적기"
        );
        schedule.add(todo1);

        Todo todo2 = new Todo(
                3,"todo2",
                ZonedDateTime.now().plusHours(5), ZonedDateTime.now().plusHours(4),
                "할 일 적기"
        );
        schedule.add(todo2);*/

//        list.stream()
//                .forEach(Event::print);

        schedule.printAll();


    }

}
