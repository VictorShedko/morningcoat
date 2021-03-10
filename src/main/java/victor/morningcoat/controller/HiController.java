package victor.morningcoat.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import victor.morningcoat.entity.Greeting;
import victor.morningcoat.services.GratingService;

import java.util.logging.Level;

@CrossOrigin(origins = "http://localhost:3000",maxAge = 3600)
@RestController
@Log
@RequestMapping("api/greeting")
public class HiController {
    private final GratingService service;

    public HiController(GratingService service) {
        this.service = service;
    }

    @GetMapping("/")
    public Greeting index() {
        log.log(Level.ALL,"get greeting");
        return service.randomGreeting();
    }

    @GetMapping("/d")
    public Iterable<Greeting> dump() {
        return service.getAll();
    }

    @PostMapping("/")
    public void postGreeting(@RequestBody Greeting greeting){
        service.save(greeting);
    }

    @PatchMapping("/")
    public void rateGreeting(@RequestBody Greeting greeting){
        service.rateGreeting(greeting);
    }

    @GetMapping("/secret")
    public String secret() {
        return "Welcome to secret page!";
    }

    @GetMapping("/tr")
    public String generateTrash() {
        TrashTread trashTread = new TrashTread();
        trashTread.start();
        return "Pollution started!";
    }

    @GetMapping("/genezvali")
    public String genezvali() {
        return "Understandable have a nice day!";
    }
}
