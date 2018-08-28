package com.tencent.mm.ui.chatting.gallery;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.pluginsdk.model.app.l.a;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.gallery.b.1;

class b$1$1 implements a {
    final /* synthetic */ 1 tTM;

    b$1$1(1 1) {
        this.tTM = 1;
    }

    public final void eu(int i, int i2) {
        if (i == i2) {
            Bitmap oR;
            x.d("MicroMsg.ImageGalleryAdapter", "appmsgImg download finish! msgid: %s", new Object[]{Long.valueOf(this.tTM.dAs.field_msgId)});
            j.O(this.tTM.tTK.tXi, 8);
            try {
                oR = y.oR(this.tTM.fYI);
            } catch (OutOfMemoryError e) {
                x.w("MicroMsg.ImageGalleryAdapter", "[tomys] Oops, app img [%s] is too large, use resample version.", new Object[]{this.tTM.fYI});
                Runtime.getRuntime().gc();
                Runtime.getRuntime().runFinalization();
                oR = y.oQ(this.tTM.fYI);
            }
            if (oR != null) {
                this.tTM.tTK.tXm.setEnableHorLongBmpMode(false);
                k.k(this.tTM.tTK.tXm, oR.getWidth(), oR.getHeight());
                this.tTM.tTK.tXm.eT(oR.getWidth(), oR.getHeight());
                this.tTM.tTK.tXm.setImageBitmap(oR);
                this.tTM.tTK.tXm.invalidate();
            }
        }
    }
}
