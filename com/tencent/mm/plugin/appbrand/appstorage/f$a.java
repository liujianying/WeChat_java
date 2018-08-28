package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.sdk.platformtools.bi;

public class f$a {
    private String country;
    private String csL;
    private String fkD;
    public String fkE;
    private String state;

    public f$a(String str, String str2, String str3, String str4, String str5) {
        this.country = bi.oV(str);
        this.state = bi.oV(str2);
        this.csL = bi.oV(str3);
        this.fkD = bi.oV(str4);
        this.fkE = bi.oV(str5);
    }

    public final String acD() {
        StringBuilder stringBuilder;
        if (bi.WC(this.country) || bi.WC(this.state) || bi.WC(this.csL) || bi.WC(this.fkD) || bi.WC(this.fkE)) {
            stringBuilder = new StringBuilder();
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
            }
            if (this.state.length() > 0) {
                stringBuilder.append(this.state);
            }
            if (this.csL.length() > 0) {
                stringBuilder.append(this.csL);
            }
            if (this.fkD.length() > 0) {
                stringBuilder.append(this.fkD);
            }
            if (this.fkE.length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.fkE);
            }
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        if (this.fkD.length() > 0) {
            stringBuilder.append(this.fkD);
            stringBuilder.append(" ");
        }
        if (this.csL.length() > 0) {
            stringBuilder.append(this.csL + " ");
        }
        if (this.state.length() > 0) {
            stringBuilder.append(this.state + " ");
        }
        if (this.country.length() > 0) {
            stringBuilder.append(this.country);
        }
        if (this.fkE.length() > 0) {
            stringBuilder.append(" ");
            stringBuilder.append(this.fkE);
        }
        return stringBuilder.toString();
    }
}
