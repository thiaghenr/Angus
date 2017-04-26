package com.example.thiagohenry.tcc.Model;

/**
 * Created by thiagohenry on 25/04/17.
 */

public class Produto {
    private Integer app_id;
    private String name;
    private String description;
    private String category;
    private String unity;
    private String pac;
    private String fee;
    private String last_update;
    private String mark;
    private Integer id;
    private Integer id_erp;
    private String cod_erp;
    private Integer id_mobile;

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnity() {
        return unity;
    }

    public void setUnity(String unity) {
        this.unity = unity;
    }



    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getLast_update() {
        return last_update;
    }

    public void setLast_update(String last_update) {
        this.last_update = last_update;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPac() {
        return pac;
    }

    public void setPac(String pac) {
        this.pac = pac;
    }

    public Integer getId_erp() {
        return id_erp;
    }

    public void setId_erp(Integer id_erp) {
        this.id_erp = id_erp;
    }

    public String getCod_erp() {
        return cod_erp;
    }

    public void setCod_erp(String cod_erp) {
        this.cod_erp = cod_erp;
    }

    public Integer getId_mobile() {
        return id_mobile;
    }

    public void setId_mobile(Integer id_mobile) {
        this.id_mobile = id_mobile;
    }
}
