package com.shaheer.lil.learningspring2.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;


public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    public Iterable<Reservation> findReservationByReservationDate(Date resvDate);
}
