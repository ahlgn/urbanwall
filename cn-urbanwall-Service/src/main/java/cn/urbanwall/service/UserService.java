package cn.urbanwall.service;

import cn.urbanwall.model.TbUser;
import cn.urbanwall.model.TbUserbase;
import cn.urbanwall.quervo.UserVo;

public interface UserService {
    public Integer login(TbUser user);

    public Integer register(TbUser user);

    public Integer updatePassword(TbUser user);

    public Integer updateUserbase(TbUserbase userbase);

    public TbUserbase selectUser(TbUserbase userbase);

    public TbUserbase selectUser(TbUser user);

    public TbUserbase selectUser(String username);



}
