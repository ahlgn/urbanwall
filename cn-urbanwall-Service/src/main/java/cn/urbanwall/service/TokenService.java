package cn.urbanwall.service;

import cn.urbanwall.model.TbUser;
import cn.urbanwall.quervo.UserToken;

public interface TokenService {
    public String generateToken(TbUser user);

    public boolean saveToken(UserToken token);

}
