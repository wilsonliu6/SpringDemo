package com.mdt.open.springdemo.domain.jpa;

import com.google.common.base.Objects;
import org.springframework.data.domain.Persistable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "red_pack_info")
public class RedPackInfoJpa implements Persistable<Long> {
    @Id
    @Column(name = "red_pack_info_id", columnDefinition = "BIGINT", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long redPackInfoId;

//    @OneToMany(mappedBy = "redPackInfo", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "redPackInfo", fetch = FetchType.EAGER)
    private List<RedPackJpa> redPacks = new ArrayList<>();

    @Column(name = "mch_id", length = 32, columnDefinition = "VARCHAR")
    @NotNull
    private String mchId;

    @Column(name = "wxappid", length = 32, columnDefinition = "VARCHAR")
    @NotNull
    private String wxAppId;

    @Column(name = "send_name", length = 32, columnDefinition = "VARCHAR")
    @NotNull
    private String sendName;

    @Column(name = "total_amount", columnDefinition = "INT")
    @NotNull
    private int totalAmount;

    @Column(name = "total_num", columnDefinition = "INT")
    @NotNull
    private int totalNum;

    @Column(name = "wishing", length = 128, columnDefinition = "VARCHAR")
    @NotNull
    private String wishing;

    @Column(name = "act_name", length = 32, columnDefinition = "VARCHAR")
    @NotNull
    private String actName;

    @Column(name = "remark", length = 256, columnDefinition = "VARCHAR")
    @NotNull
    private String remark;

    protected RedPackInfoJpa(){}

    public RedPackInfoJpa(Builder builder){
        this.mchId = builder.mchId;
        this.wxAppId = builder.wxAppId;
        this.sendName = builder.sendName;
        this.totalAmount = builder.totalAmount;
        this.totalNum = builder.totalNum;
        this.wishing = builder.wishing;
        this.actName = builder.actName;
        this.remark = builder.remark;
    }

    public Long getId(){
        return redPackInfoId;
    }

    public boolean isNew(){
        return redPackInfoId == null;
    }

    public String getMchId(){return mchId;}

    public String getWxAppId(){return wxAppId;}

    public String getSendName(){return sendName;}

    public int getTotalAmount(){return totalAmount;}

    public int getTotalNum(){return totalNum;}

    public String getWishing(){return wishing;}

    public String getActName(){return actName;}

    public String getRemark(){return remark;}

    @Override
    public String toString() {
//        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE).toString();
        return Objects.toStringHelper(this)
                .add("mchId", mchId)
                .add("wxAppId", wxAppId)
                .toString();
//        return "mchId:"+mchId + ",wxAppId:"+wxAppId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedPackInfoJpa that = (RedPackInfoJpa) o;

        if(redPackInfoId != null ? !redPackInfoId.equals(that.redPackInfoId) : that.redPackInfoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return redPackInfoId != null ? redPackInfoId.hashCode() : 0;
    }

    public List<RedPackJpa> getRedPacks(){return redPacks;}

    public static class Builder{
        private String mchId;
        private String wxAppId;
        private String sendName;
        private int totalAmount;
        private int totalNum;
        private String wishing;
        private String actName;
        private String remark;

        public Builder mchId(String mchId){
            this.mchId = mchId;
            return this;
        }

        public Builder wxAppId(String wxAppId){
            this.wxAppId = wxAppId;
            return this;
        }

        public Builder sendName(String sendName){
            this.sendName = sendName;
            return this;
        }

        public Builder totalAmount(int totalAmount){
            this.totalAmount = totalAmount;
            return this;
        }

        public Builder totalNum(int totalNum){
            this.totalNum = totalNum;
            return this;
        }

        public Builder wishing(String wishing){
            this.wishing = wishing;
            return this;
        }

        public Builder actName(String actName){
            this.actName = actName;
            return this;
        }

        public Builder remark(String remark){
            this.remark = remark;
            return this;
        }

        public RedPackInfoJpa build(){
            return new RedPackInfoJpa(this);
        }
    }
}
