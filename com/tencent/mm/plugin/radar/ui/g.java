package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.content.res.Resources;
import b.c.b.e;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beq;

public final class g {
    public static final g mmr = new g();

    private g() {
    }

    public static String b(beq beq) {
        e.i((Object) beq, "member");
        String str = beq.hbL;
        if (str != null) {
            return str;
        }
        str = beq.ryZ;
        return str == null ? "" : str;
    }

    public static String a(ben ben) {
        if (ben != null) {
            String str = ben.ryZ;
            if (str == null) {
                str = ben.hbL;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static String c(beq beq) {
        if (beq != null) {
            String str = beq.ryZ;
            if (str == null) {
                str = beq.hbL;
                if (str == null) {
                    str = "";
                }
            }
            if (str != null) {
                return str;
            }
        }
        return "";
    }

    public static boolean ea(Context context) {
        e.i((Object) context, "context");
        Resources resources = context.getResources();
        e.h(resources, "context.resources");
        return resources.getDisplayMetrics().densityDpi <= aq.CTRL_BYTE;
    }
}
