package com.wego.dexandroidnative;

public class OrderBookData {
    private double buy;
    private double buy_price_token;
    private double sell_price_token;
    private double sell;

    public double getBuy() {
        return buy;
    }

    public void setBuy(double buy) {
        this.buy = buy;
    }

    public double getBuy_price_token() {
        return buy_price_token;
    }

    public void setBuy_price_token(double buy_price_token) {
        this.buy_price_token = buy_price_token;
    }

    public double getSell_price_token() {
        return sell_price_token;
    }

    public void setSell_price_token(double sell_price_token) {
        this.sell_price_token = sell_price_token;
    }

    public double getSell() {
        return sell;
    }

    public void setSell(double sell) {
        this.sell = sell;
    }

    public OrderBookData(double buy, double buy_price_token, double sell_price_token, double sell) {
        this.buy = buy;
        this.buy_price_token = buy_price_token;
        this.sell_price_token = sell_price_token;
        this.sell = sell;
    }
}
