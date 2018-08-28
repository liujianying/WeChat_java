package com.tencent.mm.plugin.appbrand;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.page.l;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.c;

class t$3 extends bd<Bitmap> {
    final /* synthetic */ g fel;

    t$3(g gVar) {
        this.fel = gVar;
        super(500, null, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        l currentPage = this.fel.fcz.getCurrentPage();
        if (currentPage.getWidth() == 0 || currentPage.getHeight() == 0) {
            return null;
        }
        Object createBitmap = Bitmap.createBitmap(currentPage.getWidth(), currentPage.getHeight(), Config.ARGB_8888);
        c.a(new Canvas(createBitmap), currentPage);
        return createBitmap;
    }
}
