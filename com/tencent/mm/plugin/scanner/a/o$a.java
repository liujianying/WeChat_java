package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bi;

public class o$a {
    private String country;
    private String dRJ;
    private String ehp;
    private String fkD;
    private String fkE;
    private String mGH;
    private String mGI;

    public o$a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        if (str == null) {
            str = "";
        }
        this.mGH = str;
        if (str2 == null) {
            str2 = "";
        }
        this.mGI = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.fkD = str3;
        if (str4 == null) {
            str4 = "";
        }
        this.dRJ = str4;
        if (str5 == null) {
            str5 = "";
        }
        this.ehp = str5;
        if (str6 == null) {
            str6 = "";
        }
        this.fkE = str6;
        if (str7 == null) {
            str7 = "";
        }
        this.country = str7;
    }

    public final String acD() {
        StringBuilder stringBuilder;
        String stringBuilder2;
        if (bi.WC(this.mGH) || bi.WC(this.mGI) || bi.WC(this.fkD) || bi.WC(this.dRJ) || bi.WC(this.ehp) || bi.WC(this.country)) {
            stringBuilder = new StringBuilder();
            if (this.country.length() > 0) {
                stringBuilder.append(this.country);
                stringBuilder.append("\n");
            }
            if (this.ehp.length() > 0) {
                stringBuilder.append(this.ehp + " ");
            }
            if (this.dRJ.length() > 0) {
                stringBuilder.append(this.dRJ);
            }
            if (this.ehp.length() > 0 || this.dRJ.length() > 0) {
                stringBuilder.append("\n");
            }
            if (this.fkD.length() > 0) {
                stringBuilder.append(this.fkD + " ");
                stringBuilder.append("\n");
            }
            if (this.mGI.length() > 0) {
                stringBuilder.append(this.mGI);
                stringBuilder.append("\n");
            }
            if (this.mGH.length() > 0) {
                stringBuilder.append(this.mGH);
                stringBuilder.append("\n");
            }
            if (this.fkE.length() > 0) {
                stringBuilder.append(this.fkE);
            }
            stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2.endsWith("\n")) {
                return stringBuilder2.substring(0, stringBuilder2.length() - 1);
            }
            return stringBuilder2;
        }
        stringBuilder = new StringBuilder();
        if (this.mGH.length() > 0) {
            stringBuilder.append(this.mGH);
            stringBuilder.append("\n");
        }
        if (this.mGI.length() > 0) {
            stringBuilder.append(this.mGI);
            stringBuilder.append("\n");
        }
        if (this.fkD.length() > 0) {
            stringBuilder.append(this.fkD);
            stringBuilder.append("\n");
        }
        if (this.dRJ.length() > 0) {
            stringBuilder.append(this.dRJ + " ");
        }
        if (this.ehp.length() > 0) {
            stringBuilder.append(this.ehp + " ");
        }
        if (this.fkE.length() > 0) {
            stringBuilder.append(this.fkE);
        }
        if (this.dRJ.length() > 0 || this.ehp.length() > 0) {
            stringBuilder.append("\n");
        }
        if (this.country.length() > 0) {
            stringBuilder.append(this.country);
        }
        stringBuilder2 = stringBuilder.toString();
        return stringBuilder2.endsWith("\n") ? stringBuilder2.substring(0, stringBuilder2.length() - 1) : stringBuilder2;
    }
}
