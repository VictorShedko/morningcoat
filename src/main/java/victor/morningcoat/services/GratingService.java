package victor.morningcoat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import victor.morningcoat.entity.Greeting;
import victor.morningcoat.repository.GreetingRepository;

import javax.transaction.Transactional;
import java.util.Random;

@Service
public class GratingService {

    private final Random random = new Random();
    private final GreetingRepository repository;
    private final Greeting defaultGreeting =new Greeting();
    {
        defaultGreeting.setId(-1);
        defaultGreeting.setText("Have a nice day");
        defaultGreeting.setRating(0);
    }

    @Autowired
    public GratingService(GreetingRepository repository) {
        this.repository = repository;
    }

    public Greeting randomGreeting() {
        long i = repository.count();
        if(i==0){
            return defaultGreeting;
        }
        long index = random.nextInt((int) i);
        return repository.findAll(PageRequest.of((int) index, 1)).get().findFirst().orElse(defaultGreeting);

    }

    @Transactional
    public void rateGreeting(Greeting greeting) {
        repository.findById(greeting.getId()).ifPresent(gree-> gree.setRating(gree.getRating()+1));
    }

    public void save(Greeting greeting){
        repository.save(greeting);
    }

    public Iterable<Greeting> getAll() {

        return repository.findAll();
    }
}

