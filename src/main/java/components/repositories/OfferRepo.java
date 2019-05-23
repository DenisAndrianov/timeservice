package components.repositories;

import components.Offer;
import components.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface OfferRepo extends CrudRepository<Offer, Integer> {

    Set<Offer> findAllByOwner(Set<User> owners);

    Optional<Offer> findById(Integer id);
}
