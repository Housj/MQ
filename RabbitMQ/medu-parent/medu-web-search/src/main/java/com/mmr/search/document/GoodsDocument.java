package com.mmr.search.document;

import org.apache.solr.client.solrj.beans.Field;

import java.util.Date;


public class GoodsDocument {

    public static final String FIELD_ID = "id";
    public static final String FIELD_CREATETIME = "createTime";
    public static final String FIELD_MODIFYTIME = "modifyTime";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_PICTURES = "pictures";
    public static final String FIELD_DEFAULTPRICE = "defaultPrice";
    public static final String FIELD_COMMENTS = "comments";
    public static final String FIELD_SALES = "sales";
    public static final String FIELD_SHOPID = "vmallId";

    @Field
    private Long id;
    @Field
    private Date createTime;
    @Field
    private Date modifyTime;
    @Field
    private String name;
    @Field
    private String pictures;
    @Field
    private Double defaultPrice;
    @Field
    private long comments = 0L;
    @Field
    private long sales = 0L;
    @Field
    private Long vmallId;
    @Field
    private String activityTags;
    @Field
    private Double discount;
    @Field
    private String suggestName;
    @Field
    private String pinyinName;
    @Field
    private long initSales;
    @Field
    private long seriesComments = 0L;
    @Field
    private long seriesSales = 0L;
    @Field
    private String suggestion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    public Double getDefaultPrice() {
        return defaultPrice;
    }

    public void setDefaultPrice(Double defaultPrice) {
        this.defaultPrice = defaultPrice;
    }

    public long getComments() {
        return comments;
    }

    public void setComments(long comments) {
        this.comments = comments;
    }

    public long getSales() {
        return sales;
    }

    public void setSales(long sales) {
        this.sales = sales;
    }

    public String getActivityTags() {
        return activityTags;
    }

    public void setActivityTags(String activityTags) {
        this.activityTags = activityTags;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getSuggestName() {
        return suggestName;
    }

    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }

    public void setSuggestName(String suggestName) {
        this.suggestName = suggestName;
    }

    public Long getVmallId() {
        return vmallId;
    }

    public void setVmallId(Long vmallId) {
        this.vmallId = vmallId;
    }

    public long getInitSales() {
        return initSales;
    }

    public void setInitSales(long initSales) {
        this.initSales = initSales;
    }

    public long getSeriesComments() {
        return seriesComments;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public void setSeriesComments(long seriesComments) {
        this.seriesComments = seriesComments;
    }

    public long getSeriesSales() {
        return seriesSales;
    }

    public void setSeriesSales(long seriesSales) {
        this.seriesSales = seriesSales;
    }


}
