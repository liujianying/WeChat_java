package com.tencent.mm.pluginsdk.model;

public final class n {
    public String bKk;
    private int qzc;
    public String qzd;
    public String qze;
    public String qzf;
    public int qzg;

    n(int i, String str, String str2, String str3, String str4, int i2) {
        this.qzc = i;
        this.bKk = str;
        this.qzd = str2;
        this.qzg = i2;
        this.qze = str3;
        this.qzf = str4;
    }

    public final String toString() {
        return "id:" + this.qzc + ";productId:" + this.bKk + ";full:" + this.qzd + ";productState:" + this.qzg + ";priceCurrencyCode:" + this.qze + ";priceAmountMicros:" + this.qzf;
    }
}
