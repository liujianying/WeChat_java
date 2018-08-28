package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bi;

public final class s {
    private static volatile s qzo = null;

    private s() {
    }

    public static s cbA() {
        if (qzo == null) {
            synchronized (s.class) {
                if (qzo == null) {
                    qzo = new s();
                }
            }
        }
        return qzo;
    }

    public static r v(int i, Bundle bundle) {
        switch (i) {
            case 1:
                return new v();
            case 2:
                return new a(bundle);
            default:
                return new o();
        }
    }

    public static int BD(int i) {
        switch (i) {
            case 0:
                return bi.getInt(g.AU().G("QQBroswer", "RecommendCount"), 5);
            case 1:
                return Integer.MAX_VALUE;
            default:
                return 5;
        }
    }

    public static void BE(int i) {
        switch (i) {
            case 0:
                h.mEJ.h(10998, new Object[]{Integer.valueOf(0)});
                return;
            case 1:
                h.mEJ.h(11091, new Object[]{Integer.valueOf(0)});
                return;
            default:
                return;
        }
    }

    public static void BF(int i) {
        switch (i) {
            case 0:
                h.mEJ.h(10998, new Object[]{Integer.valueOf(1)});
                return;
            case 1:
                h.mEJ.h(11091, new Object[]{Integer.valueOf(1)});
                return;
            default:
                return;
        }
    }

    public static void BG(int i) {
        switch (i) {
            case 0:
                h.mEJ.h(10998, new Object[]{Integer.valueOf(3)});
                return;
            case 1:
                h.mEJ.h(11091, new Object[]{Integer.valueOf(3)});
                return;
            default:
                return;
        }
    }

    public static void BH(int i) {
        switch (i) {
            case 0:
                h.mEJ.h(10998, new Object[]{Integer.valueOf(2)});
                return;
            case 1:
                h.mEJ.h(11091, new Object[]{Integer.valueOf(2)});
                return;
            default:
                return;
        }
    }
}
