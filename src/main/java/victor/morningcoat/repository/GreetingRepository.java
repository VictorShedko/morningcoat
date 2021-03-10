package victor.morningcoat.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import victor.morningcoat.entity.Greeting;

@Repository
public interface GreetingRepository extends PagingAndSortingRepository<Greeting,Integer>{

}
