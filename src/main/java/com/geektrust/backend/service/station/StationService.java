package com.geektrust.backend.service.station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.geektrust.backend.entities.Station;

public class StationService implements IStationService {
    private Map<String, Station> stations;

    public StationService() {
        this.stations = new HashMap<>();
    }

    @Override
    public void addStation(Station station) {
        stations.put(station.getName(), station);
    }

    @Override
    public void removeStation(String stationCode) {
        stations.remove(stationCode);
    }

    @Override
    public Station getStationByCode(String stationCode) {
        return stations.get(stationCode);
    }

    @Override
    public List<Station> getAllStations() {
        return new ArrayList<>(stations.values());
    }
    
}
