package com.tencent.mm.plugin.appbrand.game;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public enum m {
    ;
    
    private boolean fAx;
    private int heightPixels;
    private int widthPixels;

    private m(String str) {
    }

    public final synchronized void bJ(int i, int i2) {
        this.widthPixels = i;
        this.heightPixels = i2;
        this.fAx = true;
    }

    public final synchronized void d(Point point) {
        if (this.fAx) {
            point.x = this.widthPixels;
            point.y = this.heightPixels;
        } else {
            x.printErrStackTrace("MicroMsg.WAGameWindowSizeHandler", new IllegalStateException(), "WAGameWindowSizeHandler has not been set, but there is someone getSize from it.", new Object[0]);
        }
    }

    @Deprecated
    public static void e(Point point) {
        Context context = ad.getContext();
        if (context != null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager != null && windowManager.getDefaultDisplay() != null) {
                windowManager.getDefaultDisplay().getRealSize(point);
            }
        }
    }
}
