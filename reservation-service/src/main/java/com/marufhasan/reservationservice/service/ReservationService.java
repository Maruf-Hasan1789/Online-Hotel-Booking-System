package com.marufhasan.reservationservice.service;

import com.marufhasan.reservationservice.dto.ReservationRequest;
import com.marufhasan.reservationservice.dto.RoomResponse;
import com.marufhasan.reservationservice.model.Reservation;
import com.marufhasan.reservationservice.model.Status;
import com.marufhasan.reservationservice.repository.ReservationRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import static java.time.format.DateTimeFormatter.ISO_DATE;

@Service
@Transactional
@RequiredArgsConstructor
@OpenAPIDefinition(info=
@Info(title="ReservationService-API",version="1.0",description = "Reservation-Service API using Spring Boot")
)
public class ReservationService {
     private final ReservationRepository reservationRepository;


    private final WebClient.Builder webClientBuilder;


    public String createReservation(ReservationRequest reservationRequest)
    {
        String hotelName=reservationRequest.getHotelName();
        String roomType=reservationRequest.getRoomType();
        String sDate=reservationRequest.getStartDate();
        String eDate=reservationRequest.getEndDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //Locale specifies human language for translating, and cultural norms for lowercase/uppercase and abbreviations and such. Example: Locale.US or Locale.CANADA_FRENCH
        formatter = formatter.withLocale(ISO_DATE.getLocale());
        LocalDate startDate = LocalDate.parse(sDate,formatter);
        LocalDate endDate=LocalDate.parse(eDate,formatter);
        System.out.println(startDate+" "+endDate);
        Integer numberOfRooms=reservationRequest.getNumberOfRooms();

        Integer totalBookedRooms=reservationRepository.findNumberOfBookedRooms(startDate,endDate,hotelName,roomType);

        System.out.println(totalBookedRooms);
      //  List<RoomResponse> roomResponseList= getNumberOfAvailableRooms().collectList().block();
        Integer totalRequiredTypeRoomInHotel=getNumberOfAvailableRooms(hotelName,roomType,sDate,eDate);
        if(totalBookedRooms+numberOfRooms>totalRequiredTypeRoomInHotel)
        {
            return "Not Enough room of type "+roomType+" in hotel "+hotelName;
        }
        UUID reservationID=UUID.randomUUID();
        //first e reservation create kri then handle kra jabe.
        Reservation reservation=new Reservation();
        reservation.setReservationID(reservationID);
        reservation.setHotelName(hotelName);
        reservation.setStatus(Status.CHECKED_IN);
        reservation.setRoomType(roomType);
        reservation.setStartDate(startDate);
        reservation.setEndDate(endDate);
        reservation.setNumberOfRooms(numberOfRooms);
        reservationRepository.save(reservation);
        return "reservation placed successfully";

    }
    public  Integer getNumberOfAvailableRooms(String hotelName,String roomType,String startDate,String endDate)
    {
        System.out.println(hotelName+" "+roomType);


        Integer val=webClientBuilder.build().get().uri("http://hotel-service/api/hotel/property/room/{hotelName}/{roomType}",hotelName,roomType)
                        .retrieve().bodyToMono(Integer.class).block();


       return val;// roomResponseList.size();//roomResponseList.size();
    }

    public  Flux<RoomResponse> getAllAvailableRooms()
    {


        Flux<RoomResponse> roomResponseFlux=webClientBuilder.build()
                .get().
                uri("http://hotel-service/api/hotel/property/room")
                .retrieve().bodyToFlux(RoomResponse.class);
        //ist<RoomResponse> roomResponseList=roomResponseFlux.subscribe(roomResponse -> roomResponse);
        return roomResponseFlux;
    }

    private RoomResponse mapToDTO(RoomResponse roomResponse) {
        return roomResponse;
    }

}
