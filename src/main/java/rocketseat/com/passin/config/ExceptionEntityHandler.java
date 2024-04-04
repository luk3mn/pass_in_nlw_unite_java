package rocketseat.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import rocketseat.com.passin.domain.attendee.exceptions.AttendeeAlreadyExistException;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeNotFoundExcpetion;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistsException;
import rocketseat.com.passin.domain.event.exceptions.EventFullException;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.passin.dto.general.ErrorResponseDTO;

@ControllerAdvice // catch exception throw by controllers
public class ExceptionEntityHandler {
    
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EventFullException.class)
    public  ResponseEntity<ErrorResponseDTO> handleEventFull(EventFullException excpetion) {
        return ResponseEntity.badRequest().body(new ErrorResponseDTO(excpetion.getMessage()));
    }

    @ExceptionHandler(AttendeeNotFoundExcpetion.class)
    public  ResponseEntity handleAttendeeNotFound(AttendeeNotFoundExcpetion excpetion) {
        return ResponseEntity.notFound().build()    ;
    }

    @ExceptionHandler(AttendeeAlreadyExistException.class)
    public  ResponseEntity handleAttendeeAlreadyExists(AttendeeAlreadyExistException excpetion) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistsException.class)
    public  ResponseEntity handleAlreadyExists(CheckInAlreadyExistsException excpetion) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
