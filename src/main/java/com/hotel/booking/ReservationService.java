package com.hotel.booking;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class ReservationService {

    private static final Logger log = LoggerFactory.getLogger(ReservationService.class);

    private final Map<Long, Reservation> reservationMap = Map.of(
            1L,  new Reservation(
                    1L,
                    10L,
                    180L,
                    LocalDate.now(),
                    LocalDate.now().plusDays(5),
                    ReservationStatus.APPROVED
                ),
            2L, new Reservation(
                    2L,
                    11L,
                    181L,
                    LocalDate.now(),
                    LocalDate.now().plusDays(5),
                    ReservationStatus.PENDING
                ),
            3L, new Reservation(
                    3L,
                    12L,
                    183L,
                    LocalDate.now(),
                    LocalDate.now().plusDays(5),
                    ReservationStatus.APPROVED
                )
    );

    public Reservation getReservationById(Long id) {
        if (!reservationMap.containsKey(id)) {
            throw new RuntimeException("Not found reservation by id " + id);
        }
        return reservationMap.get(id);
    }

    public List findAllReservations() {
        return reservationMap.values().stream().toList();
    }
}
