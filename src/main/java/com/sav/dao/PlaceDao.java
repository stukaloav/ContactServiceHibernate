package com.sav.dao;

import com.sav.model.Place;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlaceDao {
    @Transactional
    void addPlace(Place place);
    @Transactional
    List<Place> getAllPlaces();
}
