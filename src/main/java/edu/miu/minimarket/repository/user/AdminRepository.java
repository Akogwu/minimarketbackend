package edu.miu.minimarket.repository.user;

import edu.miu.minimarket.model.user.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {

}
