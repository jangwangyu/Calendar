package com.study.calendarapp.event;

import com.study.calendarapp.exception.InvalidEventException;
import lombok.Getter;

import java.time.Duration;
import java.time.ZonedDateTime;

public abstract class AbstractEvent implements Event{
    private final int id;
    private String title;
    private ZonedDateTime startAt;
    private ZonedDateTime endAt;
    private Duration duration;

    // createAt, modifiedAt, deleteYn은 바로 계산하기 때문에 다른 곳에서 상속 받을 필요가 없음 - 직접 할당
    private final ZonedDateTime createAt; // 생성날짜
    private ZonedDateTime modifiedAt;

    private boolean deletedYn; // 삭제 여부

    protected AbstractEvent(int id, String title, ZonedDateTime startAt,
                            ZonedDateTime endAt) {
        if(startAt.isAfter(endAt)) {
            throw new InvalidEventException(
                    String.format("시작일은 종료일보다 이전이여야 합니다. 시작일=%s, 종료일=%s", startAt, endAt)
            );
        }


        this.id = id;
        this.title = title;
        this.startAt = startAt;
        this.endAt = endAt;
        this.duration = Duration.between(startAt, endAt);

        ZonedDateTime now = ZonedDateTime.now(); // 생성 수정된 시간이 바로 갱신되기 위함
        this.modifiedAt = now;
        this.createAt = now;

        this.deletedYn = false; // 초기값은 삭제가 안되어 있기 때문
    }

    public String getTitle() {
        return this.title;
    }

    public ZonedDateTime getStartAt() {
        return this.startAt;
    }

    public ZonedDateTime getEndAt() {
        return this.endAt;
    }
}
