package com.rupp;

public class Product {
    private int id;
    private String name;
    private Double price_per_unit;
    private Boolean active_for_sell;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price_per_unit=" + price_per_unit +
                ", active_for_sell=" + active_for_sell +
                '}';
    }

    public Product(int id, String name, Double price_per_unit, Boolean active_for_sell) {
        this.id = id;
        this.name = name;
        this.price_per_unit = price_per_unit;
        this.active_for_sell = active_for_sell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(Double price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public Boolean getActive_for_sell() {
        return active_for_sell;
    }

    public void setActive_for_sell(Boolean active_for_sell) {
        this.active_for_sell = active_for_sell;
    }
}

