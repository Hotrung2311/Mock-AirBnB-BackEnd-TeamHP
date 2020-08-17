package com.example.airbnbbackend.repositories;

import com.example.airbnbbackend.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value = "select * from demo.booking where house_id = ?1",nativeQuery = true)
    List<Booking> findAccountByHomeInBookingTable(Long id);

    Optional<Booking> findByAccount_IdAndHouse_Id(Long account_id, Long house_id);

    @Query(value = "SELECT  DATEDIFF(CURDATE(), demo.booking.start_time)" +
            "FROM demo.booking where house_id = ?1;",nativeQuery = true)
    List<Long> getCompareStartTimeList(Long id);

    List<Booking> findByHouse_Id(Long id);
}
