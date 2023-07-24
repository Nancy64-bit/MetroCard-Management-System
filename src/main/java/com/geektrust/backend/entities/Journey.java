package com.geektrust.backend.entities;

import java.util.Objects;

public class Journey {
    private String journeyId;
    private Passenger passenger;
    private String journeyType;
    private Station station;
    private long startTime;
    private long endTime;

    public Journey(String journeyId, Passenger passenger, Station station, String journeyType) {
        this.journeyId = journeyId;
        this.passenger = passenger;
        this.journeyType = journeyType;
        this.station = station;
        this.startTime = System.currentTimeMillis();
    }

    // Getters and setters for other fields

    public Journey(String journeyId2, Station sourceStation2, Station destinationStation2,
            Passenger passenger2, String journeyType2) {}

    public String getJourneyId() {
        return journeyId;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public String getJourneyType() {
        return journeyType;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

        
    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journey journey = (Journey) o;
        return Objects.equals(journeyId, journey.journeyId) &&
                Objects.equals(passenger, journey.passenger) &&
                Objects.equals(journeyType, journey.journeyType) &&
                Objects.equals(station, journey.station) &&
                startTime == journey.startTime &&
                endTime == journey.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(journeyId, passenger, journeyType, station, startTime, endTime);
    }
}
