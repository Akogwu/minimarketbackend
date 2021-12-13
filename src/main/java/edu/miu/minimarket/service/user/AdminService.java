package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.user.AdminDto;
import edu.miu.minimarket.model.user.Admin;

public interface AdminService {

    public Admin save(AdminDto adminDto);

}
