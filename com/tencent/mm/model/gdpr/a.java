package com.tencent.mm.model.gdpr;

import com.tencent.mm.sdk.platformtools.bi;

public enum a {
    MINI_PROGRAM("miniProgram", 1),
    BIZ("officialAccount", 0),
    OPENSDK("OPENSDK", 2);
    
    public final String dEe;
    public final int dEf;

    private a(String str, int i) {
        this.dEe = str;
        this.dEf = i;
    }

    public static boolean iX(String str) {
        return iY(str) != null;
    }

    public static a iY(String str) {
        if (bi.oW(str)) {
            return null;
        }
        for (a aVar : values()) {
            if (str.equals(aVar.dEe)) {
                return aVar;
            }
        }
        return null;
    }
}
