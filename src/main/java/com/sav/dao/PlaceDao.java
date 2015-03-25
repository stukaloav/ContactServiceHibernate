package com.sav.dao;

import com.sav.model.Place;

import java.util.List;

public interface PlaceDao {
    void addPlace(Place place);
    List<Place> getAllPlaces();
}
