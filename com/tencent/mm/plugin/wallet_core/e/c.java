package com.tencent.mm.plugin.wallet_core.e;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.wallet_core.a;

public final class c {
    public static long pBi = 0;
    public static int pBj = 2;
    public static int pBk = 1;
    public static int pBl = 2;

    public static void bQW() {
        pBi = System.currentTimeMillis();
    }

    public static int bQX() {
        return (int) ((System.currentTimeMillis() - pBi) / 1000);
    }

    public static void b(Activity activity, Bundle bundle, int i) {
        com.tencent.mm.wallet_core.c af = a.af(activity);
        if (!o.bOW().bPs() && af != null && af.cCT()) {
            Orders orders = (Orders) bundle.getParcelable("key_orders");
            if (((PayInfo) bundle.getParcelable("key_pay_info")) != null && orders != null) {
                h.mEJ.h(10725, new Object[]{Integer.valueOf(i), Integer.valueOf(r0.bVY), Integer.valueOf((int) (orders.mBj * 100.0d)), orders.lNV});
            }
        } else if (!o.bOW().bPs() && bundle != null && bundle.getBoolean("key_is_bind_reg_process", false)) {
            h.mEJ.h(10932, new Object[]{Integer.valueOf(i), Integer.valueOf(bundle.getInt("key_bind_scene", 0))});
        }
    }

    public static void ea(int i, int i2) {
        h.mEJ.h(10932, new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
    }

    public static void a(PayInfo payInfo, Orders orders) {
        if (!o.bOW().bPs() && payInfo != null && orders != null) {
            h.mEJ.h(10725, new Object[]{Integer.valueOf(1), Integer.valueOf(payInfo.bVY), Integer.valueOf((int) (orders.mBj * 100.0d)), orders.lNV});
        }
    }
}
