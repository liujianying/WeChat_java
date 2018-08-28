package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;
import java.util.List;

public enum g {
    ;
    
    public int kKQ;
    public double kKR;
    public double kKS;
    public double kKT;
    public double kKU;
    public String kKV;
    public String kKW;
    private List<Object> kKX;

    private g(String str) {
        this.kKQ = 100;
        this.kKR = 200.0d;
        this.kKS = 0.01d;
        this.kKT = 2000.0d;
        this.kKU = 200.0d;
        this.kKV = "¥";
        this.kKW = ad.getContext().getString(i.lucky_money_amount_unit_title);
        this.kKX = new LinkedList();
    }

    public final String toString() {
        return "WxaLuckyMoneyConfig{maxTotalNum=" + this.kKQ + ", perPersonMaxValue=" + this.kKR + ", perMinValue=" + this.kKS + ", maxTotalAmount=" + this.kKT + ", mListener=" + this.kKX + '}';
    }
}
