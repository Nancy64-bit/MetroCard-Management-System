package com.geektrust.backend.entitiesTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.geektrust.backend.entities.Station;

public class StationTest {

    @Test
    public void testStation() {
        // Prepare test data
        String name = "CENTRAL";
        String location = "Central";

        // Create a Station instance
        Station station = new Station(name, location);

        // Assert the values
        assertEquals(name, station.getName());
        assertEquals(location, station.getLocation());
    }

    @Test
    public void testStationWithEmptyName() {
        // Prepare test data
        String name = "";
        String location = "AIRPORT";

        // Create a Station instance
        Station station = new Station(name, location);

        // Assert the values
        assertEquals(name, station.getName());
        assertEquals(location, station.getLocation());
    }

    @Test
    public void testStationWithNullLocation() {
        // Prepare test data
        String name = "CENTRAL";
        String location = null;

        // Create a Station instance
        Station station = new Station(name, location);

        // Assert the values
        assertEquals(name, station.getName());
        assertEquals(location, station.getLocation());
    }
}
