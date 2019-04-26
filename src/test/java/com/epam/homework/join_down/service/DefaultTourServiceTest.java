package com.epam.homework.join_down.service;

import com.epam.homework.join_down.dao.TourDao;
import com.epam.homework.join_down.model.Tour;
import com.epam.homework.join_down.ui.SortType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultTourServiceTest {

    private TourService tourService;

    @Before
    public void setUp() throws Exception {
        TourDao tourDao = mock(TourDao.class);
        List<Tour> tours = new ArrayList<>();

        tours.add(new Tour.Builder().withPricePerDay(200).withLocation("B").withTourName("AAB").build());
        tours.add(new Tour.Builder().withPricePerDay(100).withLocation("C").withTourName("AAD").build());
        tours.add(new Tour.Builder().withPricePerDay(300).withLocation("A").withTourName("AAC").build());

        when(tourDao.getAll()).thenReturn(tours);
        tourService = new DefaultTourService(tourDao);
    }

    @Test
    public void shouldReturnListSortedByPrice() {
        assertThat(tourService.getToursSortedBy(SortType.PRICE).get(0).getPricePerDay()).isEqualTo(100);
    }

    @Test
    public void shouldReturnListSortedByLocation() {
        assertThat(tourService.getToursSortedBy(SortType.LOCATION).get(0).getLocation()).isEqualTo("A");
    }

    @Test
    public void shouldReturnListSortedByName() {
        assertThat(tourService.getToursSortedBy(SortType.NAME).get(2).getTourName()).isEqualTo("AAD");
    }
}