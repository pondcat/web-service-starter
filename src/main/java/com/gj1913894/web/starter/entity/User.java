package com.gj1913894.web.starter.entity;

import com.gj1913894.web.starter.dto.CqSsc;

import java.util.Date;
import java.util.List;

/**
 * @author 孙权
 */
public class User implements DbEntity<Long> {
    private Long id;
    private String username;
    private String mobile;
    /**
     * 用户姓名
     **/
    private String name;
    /**
     * 性别 0:女 1:男
     **/
    private Integer gender;
    /**
     * 证件类型
     **/
    private Integer cardType;
    /**
     * 证件号码
     **/
    private String cardId;
    /**
     * 所属公司名称
     **/
    private String companyName;
    /**
     * 实名认证标记(1:已认证 0:未认证)
     **/
    private Integer realNameAuth;
    /**
     * 芝麻分
     **/
    private Integer zhimaScore;
    /**
     * 芝麻是否在租客端展示(1:展示 2:不展示)
     **/
    private Integer zhimaShow;
    /**
     * 芝麻zhimaOpenid
     **/
    private String zhimaOpenid;
    /**
     * 数据状态(1:有效 0:删除)
     **/
    private Integer valid;
    /**
     * CA合同ID
     **/
    private Integer caId;
    /**
     * 账务ID
     **/
    private Integer acctId;
    /**
     * 图像
     **/
    private String image;
    /**
     * 拓展ID
     **/
    private Integer salesId;
    /**
     * 所属城市
     **/
    private Integer cityId;
    /**
     * 400或其他联系电话
     **/
    private String contactPhone;
    /**
     * 状态(1:已登记,2:待激活,3:已激活,4:退出中,5:不可激活,6:黑名单)
     **/
    private Integer status;
    /**
     * 注册来源(1:经纪人app,2:H5扫码登记)
     **/
    private Integer regChannel;
    /**
     * 登记时间
     **/
    private Date checkInTime;
    /**
     * 注册时间
     **/
    private Date registerTime;
    /**
     * 状态变更时间
     **/
    private Date statusChangeTime;
    /**
     * 创建人
     **/
    private Integer createBy;
    /**
     * 更新人
     **/
    private Integer updateBy;
    /**
     * 更新时间
     **/
    private Date updateTime;
    /**
     * 创建时间
     **/
    private Date createTime;
    /**
     * 备注
     **/
    private String remark;
    /**
     * 经纪人等级
     **/
    private Integer rank;
    /**
     * 经纪人等级备注
     **/
    private String rankMemo;
    /**
     * 图像是否在租客端展示(1:展示 2:不展示)
     */
    private Integer imageShow;
    /**
     * 测试账号标记(1:测试账号 0:正式账号)
     */
    private Integer testAccountFlag;
    /**
     * 退出待审核状态,仅当status=7时有效:0,退出待客户经理审核;1,退出待主管审核
     */
    private Byte quitStat;
    /**
     * 最早激活时间,即第一次交服务费的时间
     */
    private Date activeTime;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;
    /**
     * 积分等级
     */
    private Integer level;

    private List<CqSsc> list;

    public List<CqSsc> getList() {
        return list;
    }

    public void setList(List<CqSsc> list) {
        this.list = list;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getRealNameAuth() {
        return realNameAuth;
    }

    public void setRealNameAuth(Integer realNameAuth) {
        this.realNameAuth = realNameAuth;
    }

    public Integer getZhimaScore() {
        return zhimaScore;
    }

    public void setZhimaScore(Integer zhimaScore) {
        this.zhimaScore = zhimaScore;
    }

    public Integer getZhimaShow() {
        return zhimaShow;
    }

    public void setZhimaShow(Integer zhimaShow) {
        this.zhimaShow = zhimaShow;
    }

    public String getZhimaOpenid() {
        return zhimaOpenid;
    }

    public void setZhimaOpenid(String zhimaOpenid) {
        this.zhimaOpenid = zhimaOpenid;
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public Integer getAcctId() {
        return acctId;
    }

    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getSalesId() {
        return salesId;
    }

    public void setSalesId(Integer salesId) {
        this.salesId = salesId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRegChannel() {
        return regChannel;
    }

    public void setRegChannel(Integer regChannel) {
        this.regChannel = regChannel;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getStatusChangeTime() {
        return statusChangeTime;
    }

    public void setStatusChangeTime(Date statusChangeTime) {
        this.statusChangeTime = statusChangeTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getRankMemo() {
        return rankMemo;
    }

    public void setRankMemo(String rankMemo) {
        this.rankMemo = rankMemo;
    }

    public Integer getImageShow() {
        return imageShow;
    }

    public void setImageShow(Integer imageShow) {
        this.imageShow = imageShow;
    }

    public Integer getTestAccountFlag() {
        return testAccountFlag;
    }

    public void setTestAccountFlag(Integer testAccountFlag) {
        this.testAccountFlag = testAccountFlag;
    }

    public Byte getQuitStat() {
        return quitStat;
    }

    public void setQuitStat(Byte quitStat) {
        this.quitStat = quitStat;
    }

    public Date getActiveTime() {
        return activeTime;
    }

    public void setActiveTime(Date activeTime) {
        this.activeTime = activeTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
