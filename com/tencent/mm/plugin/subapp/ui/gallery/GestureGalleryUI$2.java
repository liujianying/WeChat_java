package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.mm.g.a.kh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class GestureGalleryUI$2 extends c<kh> {
    final /* synthetic */ GestureGalleryUI osu;

    GestureGalleryUI$2(GestureGalleryUI gestureGalleryUI) {
        this.osu = gestureGalleryUI;
        this.sFo = kh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kh khVar = (kh) bVar;
        if (khVar != null) {
            x.i("MicroMsg.GestureGalleryUI", "notify Event: %d", new Object[]{Integer.valueOf(khVar.bUG.bUE)});
            if (khVar.bUG.activity == this.osu && khVar.bUG.bHL.equals(GestureGalleryUI.e(this.osu))) {
                switch (khVar.bUG.bUE) {
                    case 3:
                        this.osu.finish();
                        break;
                }
            }
            x.e("MicroMsg.GestureGalleryUI", "not the same");
        } else {
            x.e("MicroMsg.GestureGalleryUI", "NotifyDealQBarStrResultEvent is null.");
        }
        return false;
    }
}
