package com.tencent.mm.plugin.appbrand.game.page;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.tencent.mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout.b;
import com.tencent.mm.sdk.platformtools.x;

class d$4 implements WAGamePageViewContainerLayout$a {
    final /* synthetic */ d fCR;

    d$4(d dVar) {
        this.fCR = dVar;
    }

    public final void a(b bVar, b bVar2) {
        x.v("AppBrandGame.WAGamePageView", "hy: after change. old direction:%s, new direction: %s", new Object[]{bVar, bVar2});
        if (this.fCR.fCK == null || this.fCR.fCK.content == null) {
            x.e("AppBrandGame.WAGamePageView", "hy: screenshot is null");
        } else if (!d.a(bVar) || !d.a(bVar2)) {
            if (!d.b(bVar) || !d.b(bVar2)) {
                if (d.a(bVar2)) {
                    Matrix matrix = new Matrix();
                    if ((bVar2 == b.fCV && bVar == b.fCW) || (bVar2 == b.fCX && bVar == b.fCY)) {
                        matrix.postRotate(90.0f);
                    } else {
                        matrix.postRotate(270.0f);
                    }
                    this.fCR.fCJ.setVisibility(0);
                    this.fCR.fCJ.setImageBitmap(Bitmap.createBitmap(this.fCR.fCK.content, 0, 0, this.fCR.fCK.content.getWidth(), this.fCR.fCK.content.getHeight(), matrix, true));
                    this.fCR.fCL = true;
                    return;
                }
                this.fCR.ahd();
                this.fCR.fCH.setOnConfigurationChangedListener(null);
            }
        }
    }
}
