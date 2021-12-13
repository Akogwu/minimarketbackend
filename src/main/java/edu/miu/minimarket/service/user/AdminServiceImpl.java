package edu.miu.minimarket.service.user;

import edu.miu.minimarket.dto.user.AdminDto;
import edu.miu.minimarket.model.user.Admin;
import edu.miu.minimarket.repository.user.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Admin save (AdminDto adminDto) {
        return adminRepository.save(modelMapper.map(adminDto, Admin.class));

    }
}
