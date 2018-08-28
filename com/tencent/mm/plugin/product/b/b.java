package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.um;
import com.tencent.mm.sdk.platformtools.bi;

public final class b {
    public static String l(int i, int i2, String str) {
        if (i == i2) {
            return d((double) i, str);
        }
        return String.format("%s~%s", new Object[]{d((double) i2, str), d((double) i, str)});
    }

    public static String d(double d, String str) {
        if ("CNY".equals(str) || "1".equals(str) || bi.oW(str)) {
            return String.format("¥%.2f", new Object[]{Double.valueOf(d / 100.0d)});
        }
        return String.format("%s%.2f", new Object[]{str, Double.valueOf(d / 100.0d)});
    }

    public static String a(Context context, um umVar) {
        if (umVar.rlz > 0) {
            return umVar.jPe + " " + d((double) umVar.rlz, umVar.rxc);
        }
        return context.getString(i.mall_product_submit_price_express_free);
    }
}
