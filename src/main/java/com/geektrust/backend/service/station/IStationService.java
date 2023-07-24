package com.geektrust.backend.service.station;

import java.util.List;
import com.geektrust.backend.entities.Station;

public interface IStationService {
    void addStation(Station station);
    void removeStation(String stationCode);
    Station getStationByCode(String stationCode);
    List<Station> getAllStations();
}
