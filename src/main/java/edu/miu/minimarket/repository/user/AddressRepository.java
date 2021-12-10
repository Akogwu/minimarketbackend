package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long>{
}
