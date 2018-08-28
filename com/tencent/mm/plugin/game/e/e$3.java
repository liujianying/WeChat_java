package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.plugin.game.e.e.b;
import com.tencent.mm.sdk.platformtools.ah;

class e$3 extends b {
    final /* synthetic */ int aEd;
    final /* synthetic */ int aEe;
    final /* synthetic */ ImageView ixr;
    final /* synthetic */ e kdq;
    final /* synthetic */ int kdv;

    e$3(e eVar, ImageView imageView, int i, int i2, int i3) {
        this.kdq = eVar;
        this.ixr = imageView;
        this.aEe = i;
        this.aEd = i2;
        this.kdv = i3;
    }

    public final void a(View view, Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            ah.A(new 1(this, bitmap));
        }
    }
}
