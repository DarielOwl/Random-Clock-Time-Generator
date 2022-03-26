package co.com.sofka.mentoring35.Repository;

import co.com.sofka.mentoring35.Model.Random;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface RandomRepository extends ReactiveCrudRepository<Random, String> {
    
}
