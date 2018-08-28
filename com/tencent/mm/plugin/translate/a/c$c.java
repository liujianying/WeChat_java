package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.model.bd;

public class c$c {
    private static int oEy = 0;
    public String bhd;
    public byte[] cGM;
    public String cbd;
    public String ccF;
    public String ccM;
    public String id;
    public int oEv;
    public int oEw;
    public String oEx;
    public int ret;
    public int type;

    public c$c(String str, String str2, int i, String str3, byte[] bArr) {
        this.ccF = str;
        this.id = str2;
        this.type = i;
        this.bhd = str3;
        this.cGM = bArr;
        if (oEy == Integer.MAX_VALUE) {
            oEy = 0;
        }
        int i2 = oEy + 1;
        oEy = i2;
        this.oEw = i2;
        if (i == 1) {
            i2 = bd.iA(str);
            if (i2 != -1) {
                String trim = str.substring(0, i2).trim();
                if (trim != null && trim.length() > 0) {
                    this.oEx = trim;
                    this.ccF = str.substring(i2 + 1).trim();
                }
            }
        }
    }
}
