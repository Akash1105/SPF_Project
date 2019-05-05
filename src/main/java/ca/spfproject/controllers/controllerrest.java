package ca.spfproject.controllers;

import ca.spfproject.model.modelrest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class controllerrest {
    private List<modelrest> pledges = new ArrayList<>();
    private AtomicLong nextId = new AtomicLong();


    @GetMapping("/hello")
    public String getHelloMessage() {
        return "Hello Spring Boot World";
    }


    @PostMapping("/pledges")
    @ResponseStatus(HttpStatus.CREATED)
    public modelrest createNewPledge(@RequestBody modelrest pledge) {
        //set pledge to have next ID:
        pledge.setId(nextId.incrementAndGet());
        pledges.add(pledge);
        return pledge;

    }

    @GetMapping("/pledges")
    public List<modelrest> getAllPledges() {
        return pledges;
    }

    @GetMapping("/pledges/{id}")
    public modelrest getOnePledge(@PathVariable("id") long pledgeId) {
        for (modelrest pledge : pledges) {
            if (pledge.getId() == pledgeId) {
                return pledge;
            }
        }
        throw new IllegalArgumentException();
    }

    @PostMapping("pledges/{id}")
    public modelrest editOnePledge(
            @PathVariable("id") long pledgeId,
            @RequestBody modelrest newPledge
    ) {
        for (modelrest pledge : pledges) {
            if (pledge.getId() == pledgeId) {
                pledges.remove(pledge);
                newPledge.setId(pledgeId);
                pledges.add(newPledge);
                return pledge;
            }
        }

        throw new IllegalArgumentException();
    }

    // Create Exception Handle
    @ResponseStatus(value = HttpStatus.BAD_REQUEST,
            reason = "Request ID not found.")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badIdExceptionHandler() {
        // Nothing to do
    }

}

