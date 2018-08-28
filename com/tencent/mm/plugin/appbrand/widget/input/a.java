package com.tencent.mm.plugin.appbrand.widget.input;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import com.tencent.mm.pluginsdk.e;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static final boolean gGe = (VERSION.SDK_INT < 20);
    public final Activity activity;
    public boolean gGf = false;
    public int gGg = 0;

    public a(Activity activity) {
        this.activity = activity;
    }

    /* renamed from: apf */
    public final void a() {
        if (this.gGf && !this.activity.isFinishing() && gGe) {
            l m = l.m(this.activity);
            if (m == null) {
                x.w("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
            } else {
                a(m);
            }
        }
    }

    public final void a(l lVar) {
        int i;
        Point point = new Point();
        this.activity.getWindowManager().getDefaultDisplay().getSize(point);
        int eL = e.eL(this.activity);
        int i2 = point.y;
        if (this.activity.getWindow() == null || (this.activity.getWindow().getAttributes().flags & 1024) <= 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            eL = 0;
        }
        x.i("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[]{Integer.valueOf(i2 - eL)});
        lVar.setForceHeight(eL);
    }

    public static boolean cO(Context context) {
        boolean z;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier > 0) {
            z = resources.getBoolean(identifier);
        } else {
            z = false;
        }
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"qemu.hw.mainkeys"});
            if ("1".equals(str)) {
                return false;
            }
            if ("0".equals(str)) {
                return true;
            }
            return z;
        } catch (Exception e) {
        }
    }
}
