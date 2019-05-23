package components.repositories;

import components.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepo extends CrudRepository<Offer, Integer> {

}
