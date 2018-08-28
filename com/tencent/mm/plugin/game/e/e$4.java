package com.tencent.mm.plugin.game.e;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class e$4 extends e$b {
    final /* synthetic */ int aEd;
    final /* synthetic */ int aEe;
    final /* synthetic */ e kdq;
    final /* synthetic */ e$b kdx;
    final /* synthetic */ int kdy = 0;
    final /* synthetic */ String val$url;

    e$4(e eVar, e$b e_b, int i, int i2, String str) {
        this.kdq = eVar;
        this.kdx = e_b;
        this.aEd = i;
        this.aEe = i2;
        this.val$url = str;
    }

    public final void a(View view, Bitmap bitmap) {
        x.d("MicroMsg.GameImageUtil", "getBitmapWithWH, onFinish");
        if (bitmap != null && !bitmap.isRecycled()) {
            Bitmap b = e.b(bitmap, this.aEd, this.aEe);
            x.d("MicroMsg.GameImageUtil", "getBitmapWithWH, resizeBitmap end");
            if (this.kdy != 0) {
                b = c.a(b, true, (float) this.kdy);
            }
            e.b(this.kdq).m(this.val$url, b);
            if (this.kdx != null) {
                this.kdx.a(view, b);
            }
        }
    }
}
