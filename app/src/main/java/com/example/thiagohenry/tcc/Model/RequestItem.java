package com.example.thiagohenry.tcc.Model;

import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by thiagohenry on 23/04/17.
 */

public class RequestItem {
    @PrimaryKey
    private Long id;
    @Index
    @Required
    private Price   price_id;
    @Index
    @Required
    private Request request_id;
    @Index
    @Required
    private Product product_id;
    @Required
    private Long quantity;
    @Index
    @Required
    private Long invoiced_amount;
    private Long discount;
    @Index
    private Long value_table;
    @Index
    private Long value_unit;
    @Index
    private Long value_unit_invoiced;
    @Index
    private Long value_total;
    @Index
    private Long value_total_invoiced;
    @Index
    private Long value_difference;
    private String observation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Price getPrice_id() {
        return price_id;
    }

    public void setPrice_id(Price price_id) {
        this.price_id = price_id;
    }

    public Request getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Request request_id) {
        this.request_id = request_id;
    }

    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getInvoiced_amount() {
        return invoiced_amount;
    }

    public void setInvoiced_amount(Long invoiced_amount) {
        this.invoiced_amount = invoiced_amount;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Long getValue_table() {
        return value_table;
    }

    public void setValue_table(Long value_table) {
        this.value_table = value_table;
    }

    public Long getValue_unit() {
        return value_unit;
    }

    public void setValue_unit(Long value_unit) {
        this.value_unit = value_unit;
    }

    public Long getValue_unit_invoiced() {
        return value_unit_invoiced;
    }

    public void setValue_unit_invoiced(Long value_unit_invoiced) {
        this.value_unit_invoiced = value_unit_invoiced;
    }

    public Long getValue_total() {
        return value_total;
    }

    public void setValue_total(Long value_total) {
        this.value_total = value_total;
    }

    public Long getValue_total_invoiced() {
        return value_total_invoiced;
    }

    public void setValue_total_invoiced(Long value_total_invoiced) {
        this.value_total_invoiced = value_total_invoiced;
    }

    public Long getValue_difference() {
        return value_difference;
    }

    public void setValue_difference(Long value_difference) {
        this.value_difference = value_difference;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }
}