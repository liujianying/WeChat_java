package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.sdk.platformtools.bi;

public class o$b {
    private String fkF;
    private String fkG;
    private String fkH;

    public o$b(String str, String str2, String str3) {
        if (str == null) {
            str = "";
        }
        this.fkF = str;
        if (str2 == null) {
            str2 = "";
        }
        this.fkG = str2;
        if (str3 == null) {
            str3 = "";
        }
        this.fkH = str3;
    }

    public final String acD() {
        StringBuilder stringBuilder = new StringBuilder();
        if (bi.WC(this.fkF) || bi.WC(this.fkG) || bi.WC(this.fkH)) {
            if (this.fkH.trim().length() > 0) {
                stringBuilder.append(this.fkH);
            }
            if (this.fkG.trim().length() > 0) {
                stringBuilder.append(this.fkG);
            }
            if (this.fkF.trim().length() > 0) {
                stringBuilder.append(this.fkF);
            }
        } else {
            if (this.fkF.trim().length() > 0) {
                stringBuilder.append(this.fkF);
            }
            if (this.fkG.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.fkG);
            }
            if (this.fkH.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(this.fkH);
            }
        }
        return stringBuilder.toString();
    }
}
