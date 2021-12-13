package edu.miu.minimarket.service.product;

import edu.miu.minimarket.dto.user.AdminDto;
import edu.miu.minimarket.model.product.Follow;

public interface FollowService {

    public Follow save(Follow follow);

    public boolean sellerIsExist(long id);

    public void deleteFollow(long sellerId);

}
