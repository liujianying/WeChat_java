package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mm.br.e;
import com.tencent.mm.plugin.appbrand.widget.input.panel.AppBrandSmileyPanelBase.a;
import com.tencent.mm.sdk.platformtools.ad;

public class c {
    public Context gKE;
    boolean gKV = false;
    public b gKX;
    a gKY;
    int gKZ;
    int gLa;

    public final a aqi() {
        if (this.gKX == null) {
            this.gKX = new b();
            this.gKX.gKE = this.gKE;
            this.gKX.setPanelManager(this);
        }
        return this.gKX;
    }

    public static int[] anG() {
        r1 = new int[2];
        Display defaultDisplay = ((WindowManager) ad.getContext().getSystemService("window")).getDefaultDisplay();
        r1[0] = defaultDisplay.getWidth();
        r1[1] = defaultDisplay.getHeight();
        return r1;
    }

    public e apU() {
        return e.cjH();
    }
}
