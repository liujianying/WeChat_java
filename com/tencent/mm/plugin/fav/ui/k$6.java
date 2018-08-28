package com.tencent.mm.plugin.fav.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.sdk.platformtools.ah;

class k$6 implements Runnable {
    final /* synthetic */ String dat;
    final /* synthetic */ g iVs;
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ boolean jaU;
    final /* synthetic */ int jaV;
    final /* synthetic */ int jaW;
    final /* synthetic */ vx jam;

    k$6(String str, int i, int i2, g gVar, vx vxVar, boolean z, ImageView imageView) {
        this.dat = str;
        this.jaV = i;
        this.jaW = i2;
        this.iVs = gVar;
        this.jam = vxVar;
        this.jaU = z;
        this.ixr = imageView;
    }

    public final void run() {
        Bitmap b = k.b(this.dat, this.jaV, this.jaW, false);
        if (b == null) {
            k.c(this.iVs, this.jam, this.jaU);
            return;
        }
        String str = (String) this.ixr.getTag();
        if (str != null && str.equals(this.dat)) {
            com.tencent.mm.kernel.g.Em();
            ah.A(new 1(this, b));
        }
    }
}
