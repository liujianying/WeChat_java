package com.tencent.mm.plugin.video;

import com.tencent.mm.sdk.platformtools.bi;
import java.math.BigInteger;

public final class c {
    public static String OC(String str) {
        if (bi.oW(str)) {
            return "";
        }
        return new BigInteger(Long.toBinaryString(bi.getLong(str, 0)), 2).toString();
    }
}
