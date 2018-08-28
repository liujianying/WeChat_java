package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import com.tencent.mm.an.c;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.ui.SnsHeader.b;
import com.tencent.mm.ui.an;

class bb$8 implements b {
    final /* synthetic */ bb ogl;

    bb$8(bb bbVar) {
        this.ogl = bbVar;
    }

    public final void K(Bitmap bitmap) {
        if (bitmap != null) {
            int fromDPToPix = a.fromDPToPix(bb.a(this.ogl), 65);
            if (fromDPToPix > bitmap.getHeight()) {
                fromDPToPix = bitmap.getHeight();
            }
            fromDPToPix = c.s(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), fromDPToPix))[0];
            if (this.ogl.iZk != null) {
                this.ogl.iZk.setBackgroundColor(fromDPToPix);
            }
            if (this.ogl.gFD == null) {
                return;
            }
            if (an.Ec(fromDPToPix)) {
                this.ogl.gFD.setVisibility(8);
            } else {
                this.ogl.gFD.setVisibility(0);
            }
        }
    }
}
