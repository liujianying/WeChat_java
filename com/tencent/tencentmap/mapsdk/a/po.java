package com.tencent.tencentmap.mapsdk.a;

public class po {
    public byte[] a;
    public String b = "GBK";

    public String toString() {
        try {
            return new String(this.a, this.b);
        } catch (Exception e) {
            return "";
        }
    }
}
