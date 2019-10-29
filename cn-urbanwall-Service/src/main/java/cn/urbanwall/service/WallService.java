package cn.urbanwall.service;

import cn.urbanwall.model.TbWaller;
import cn.urbanwall.quervo.WallView;

import java.util.List;

public interface WallService {
    public boolean sendWall(TbWaller waller);

    public boolean contrastIdAndUsername(Long id,String username);

    public List<WallView> selectNewWallBySchool(String school);

    public List<WallView> selectHotWallBySchool(String school);

    public List<WallView> selectHotWall();


    public List<WallView> selectWallBySchool(String school, int pageSize, int pageNo);

    public List<WallView> selcetWallByUserId(String userid);

    public boolean deleteWallById(Long id);


}
