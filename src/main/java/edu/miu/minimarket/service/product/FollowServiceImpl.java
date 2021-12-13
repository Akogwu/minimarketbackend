package edu.miu.minimarket.service.product;

import edu.miu.minimarket.model.product.Follow;
import edu.miu.minimarket.repository.product.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    FollowRepository followRepository;

    @Override
    public Follow save (Follow follow) {
        return followRepository.save(follow);
    }

    @Override
    public boolean sellerIsExist (long id) {

        if (followRepository.findSellerById(id)!=null) {
            return true;
        }
        return  false;
    }

    @Override
    public void deleteFollow (long sellerId) {
        Follow follow = followRepository.findSellerById(sellerId);
        if (follow != null) {
            followRepository.delete(follow);
        }
    }
}
