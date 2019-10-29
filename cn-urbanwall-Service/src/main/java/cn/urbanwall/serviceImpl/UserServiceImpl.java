package cn.urbanwall.serviceImpl;

import cn.urbanwall.dao.TbUserMapper;
import cn.urbanwall.dao.TbUserbaseMapper;
import cn.urbanwall.model.TbUser;
import cn.urbanwall.model.TbUserExample;
import cn.urbanwall.model.TbUserbase;
import cn.urbanwall.model.TbUserbaseExample;
import cn.urbanwall.service.UserService;
import cn.urbanwall.utils.IDUtils;
import cn.urbanwall.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Transactional(rollbackFor = Exception.class) //非运行异常也回滚事物
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbUserMapper userMapper;

    @Autowired
    private TbUserbaseMapper userbaseMapper;

    /**
     * 登录服务
     * @param user 前端提交用户信息
     * @return 成功返回1 密码错误0 用户不存在-1
     */
    @Override
    public Integer login(TbUser user) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<TbUser> users = userMapper.selectByExample(example);
        if(users.size()>0){
            String realpassword = users.get(0).getPassword();
            String inputpassword= MD5Utils.encodePassword(user.getPassword());
            if(realpassword.equals(inputpassword)){
                return 1;
            }else{
                return 0;
            }
        }else {
            return -1;
        }
    }

    /**
     * 注册服务
     * @param user
     * @return 注册成功1 注册失败0 已有用户返回-1
     */
    @Override
    public Integer register(TbUser user) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<TbUser> tbUsers = userMapper.selectByExample(example);
        if(tbUsers.size()==0) {
            user.setId(IDUtils.uuid());
            user.setPassword(MD5Utils.encodePassword(user.getPassword()));
            user.setCreatetime(new Date());
            int status = userMapper.insert(user);
            if (status > 0) {
                return 1;
            } else {
                return 0;
            }
        }else{
            return -1;
        }
    }

    /**
     * 修改密码
     * @param user
     * @return 修改成功1 修改失败0 无用户返回-1
     */
    @Override
    public Integer updatePassword(TbUser user) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<TbUser> users = userMapper.selectByExample(example);
        if(users.size()>0) {
            TbUser dbuser = users.get(0);
            dbuser.setPassword(MD5Utils.encodePassword(user.getPassword()));
            int status = userMapper.updateByPrimaryKey(dbuser);
            if (status > 0) {
                return 1;
            } else {
                return 0;
            }
        }else{
            return -1;
        }

    }

    /**
     * 修改用户信息
     * @param userbase
     * @return 修改成功1 修改失败0
     */
    @Override
    public Integer updateUserbase(TbUserbase userbase) {
        int status = userbaseMapper.updateByPrimaryKey(userbase);
        if(status>0){
            return 1;
        }else{
            return 0;
        }
    }

    /**
     * 查询用户基本信息
     * @param userbase
     * @return
     */
    @Override
    public TbUserbase selectUser(TbUserbase userbase) {
        TbUserbase tbUserbase = userbaseMapper.selectByPrimaryKey(userbase.getId());
        return tbUserbase;
    }

    /**
     * 查询用户基本信息
     * @param user
     * @return
     */
    @Override
    public TbUserbase selectUser(TbUser user) {
        TbUserbaseExample example = new TbUserbaseExample();
        TbUserbaseExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<TbUserbase> tbUserbases = userbaseMapper.selectByExample(example);
        if(tbUserbases.size()>0){
            TbUserbase tbUserbase = tbUserbases.get(0);
            return tbUserbase;
        }else {
            return null;
        }
    }

    /**
     * 通过用户名返回用户信息
     * @param username
     * @return
     */
    @Override
    public TbUserbase selectUser(String username) {
        TbUserbaseExample example= new TbUserbaseExample();
        TbUserbaseExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUserbase> tbUserbases = userbaseMapper.selectByExample(example);
        if(tbUserbases.size()>0){
            return tbUserbases.get(0);
        }else{
            return null;
        }
    }
}
