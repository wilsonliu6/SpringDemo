package com.mdt.open.springdemo.domain.jpa;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Persistable;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "red_pack")
public class RedPackJpa implements Persistable<String> {
    @Id
    @Column(name = "qrcode", length = 32, columnDefinition = "VARCHAR", unique = true)
    @NotNull
    private String qrCode;

//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = RedPackInfoJpa.class)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "red_pack_info_id")
    private RedPackInfoJpa redPackInfo;

    @Column(name = "status", columnDefinition = "INT")
    @NotNull
    private RedPackStatus status;

    @Column(name = "mch_billno", length = 28, columnDefinition = "VARCHAR")
    private String mchBillNo;

    @Column(name = "re_openid", length = 32, columnDefinition = "VARCHAR")
    private String reOpenId;

    @Column(name = "created_on", columnDefinition = "TIMESTAMP")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "MM")
    private Date createdOn;

    @Column(name = "updated_on", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "MM")
    private Date updatedOn;

    @PrePersist
    private void prePersist() {
        createdOn = updatedOn = new Date();
    }

    @PreUpdate
    private void preUpdate() {
        this.updatedOn = new Date();
    }

    protected RedPackJpa(){}

    public RedPackJpa(Builder builder){
        this.redPackInfo = builder.redPackInfo;
        this.qrCode = builder.qrCode;
        this.status = builder.redPackStatus;
        this.mchBillNo = builder.mchBillNo;
        this.reOpenId = builder.reOpenId;
        this.createdOn = builder.createdOn;
        this.updatedOn = builder.updatedOn;
    }

    public String getId(){
        return qrCode;
    }

    public boolean isNew(){
        return qrCode == null;
    }

    public RedPackStatus getStatus(){
        return status;
    }

    public String getQrCode(){
        return qrCode;
    }

    public RedPackInfoJpa getRedPackInfo(){
        return redPackInfo;
    }

    public String getReOpenId(){
        return reOpenId;
    }

    public String getMchBillNo() {
        return mchBillNo;
    }

    public void setStatus(RedPackStatus redPackStatus){
        this.status = redPackStatus;
    }
    public void setReOpenId(String reOpenId){
        this.reOpenId = reOpenId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RedPackJpa that = (RedPackJpa) o;

        if(qrCode != null ? !qrCode.equals(that.qrCode) : that.qrCode != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        return qrCode != null ? qrCode.hashCode() : 0;
    }

    public static class Builder{
        private RedPackInfoJpa redPackInfo;
        private String qrCode;
        private RedPackStatus redPackStatus;
        private String mchBillNo;
        private String reOpenId;
        private Date createdOn;
        private Date updatedOn;

        public Builder redPackInfo(RedPackInfoJpa redPackInfo){
            this.redPackInfo = redPackInfo;
            return this;
        }

        public Builder qrCode(String qrCode){
            this.qrCode = qrCode;
            return this;
        }

        public Builder redPackStatus(RedPackStatus redPackStatus){
            this.redPackStatus = redPackStatus;
            return this;
        }

        public Builder mchBillNo(String mchBillNo){
            this.mchBillNo = mchBillNo;
            return this;
        }

        public Builder reOpenId(String reOpenId){
            this.reOpenId = reOpenId;
            return this;
        }

        public Builder createdOn(Date createdOn){
            this.createdOn = createdOn;
            return this;
        }

        public Builder updatedOn(Date updatedOn){
            this.updatedOn = updatedOn;
            return this;
        }

        public RedPackJpa build(){
            return new RedPackJpa(this);
        }
    }
}
