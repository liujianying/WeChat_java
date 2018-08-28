package com.tencent.mm.plugin.remittance.bankcard.model;

import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.math.BigDecimal;

public final class a {
    public static long ek(String str, String str2) {
        try {
            return new BigDecimal(bi.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), 0, 4).longValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            return 0;
        }
    }

    public static double el(String str, String str2) {
        try {
            return new BigDecimal(bi.getDouble(str.trim(), 0.0d) == 0.0d ? "0" : str.trim()).divide(new BigDecimal(str2.trim()), 2, 4).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static double em(String str, String str2) {
        try {
            double d = bi.getDouble(str, 0.0d);
            double d2 = bi.getDouble(str2, 0.0d);
            if (d == 0.0d) {
                str = "0";
            }
            BigDecimal bigDecimal = new BigDecimal(str);
            if (d2 == 0.0d) {
                str2 = "0";
            }
            return bigDecimal.multiply(new BigDecimal(str2)).doubleValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BankRemitUtil", e, "", new Object[0]);
            return 0.0d;
        }
    }

    public static double vp(int i) {
        return el(String.valueOf(i), "100");
    }

    public static char Kv(String str) {
        String g = SpellMap.g(str.charAt(0));
        x.d("MicroMsg.BankRemitUtil", "pinyin: %s", new Object[]{g});
        if (bi.oW(g)) {
            return '#';
        }
        return g.toUpperCase().charAt(0);
    }
}
