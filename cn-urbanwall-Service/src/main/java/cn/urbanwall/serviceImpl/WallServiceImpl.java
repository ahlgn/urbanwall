package cn.urbanwall.serviceImpl;

import cn.urbanwall.dao.TbWallerMapper;
import cn.urbanwall.model.TbWaller;
import cn.urbanwall.model.TbWallerExample;
import cn.urbanwall.quervo.WallView;
import cn.urbanwall.service.WallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Transactional(rollbackFor = Exception.class) //非运行异常也回滚事物
@Service
public class WallServiceImpl implements WallService {
    @Autowired
    private TbWallerMapper wallerMapper;
    /**
     * 发送留言
     * @param waller
     * @return
     */
    @Override
    public boolean sendWall(TbWaller waller) {
        waller.setSendtime(new Date());
        System.out.println("保存时间为"+new Date());
        int i = wallerMapper.insert(waller);
        return i>0?true:false;
    }

    @Override
    public boolean contrastIdAndUsername(Long id, String username) {
        TbWallerExample example = new TbWallerExample();
        TbWallerExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andSendUsernameEqualTo(username);
        List<TbWaller> tbWallers = wallerMapper.selectByExample(example);
        if(tbWallers.size()>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<WallView> selectNewWallBySchool(String school) {
        return null;
    }

    @Override
    public List<WallView> selectHotWallBySchool(String school) {
        return null;
    }

    @Override
    public List<WallView> selectHotWall() {
        return null;
    }




    @Override
    public List<WallView> selectWallBySchool(String school, int pageSize, int pageNo) {
        pageNo = (pageNo-1)*pageSize; //获取参数计算 从第几条数据开始
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("school",school);//设置学校
        map.put("page",pageNo);//设置倒叙后第几条开始
        map.put("pageSize",pageSize);//设置显示多少条数据
        List<WallView> wallers = wallerMapper.selectWallView(map);
        return wallers;
    }

    @Override
    public List<WallView> selcetWallByUserId(String userid) {
        List<WallView> wallViews = wallerMapper.selectWallByUserId(userid);
        return wallViews;
    }

    @Override
    public boolean deleteWallById(Long id) {
        int i = wallerMapper.deleteByPrimaryKey(id);
        return i>0?true:false;
    }

}
