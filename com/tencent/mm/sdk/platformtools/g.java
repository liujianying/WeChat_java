package com.tencent.mm.sdk.platformtools;

public final class g {
    public static String gVK = "]]>";
    public StringBuffer gVP = new StringBuffer();
    public String sFG = "";

    public g(String str) {
        this.sFG = str;
        wA(this.sFG);
    }

    private void wA(String str) {
        this.gVP.append("<" + str + ">");
    }

    public final void wB(String str) {
        this.gVP.append("</" + str + ">");
    }

    public final void bR(String str, String str2) {
        wA(str);
        if (!bi.oW(str2)) {
            if (str2.contains(gVK)) {
                this.gVP.append("<![CDATA[" + bi.WS(str2) + "]]>");
            } else {
                this.gVP.append("<![CDATA[" + str2 + "]]>");
            }
        }
        wB(str);
    }
}
