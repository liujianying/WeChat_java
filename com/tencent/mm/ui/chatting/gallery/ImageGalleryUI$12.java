package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.g.a.kh;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class ImageGalleryUI$12 extends c<kh> {
    final /* synthetic */ ImageGalleryUI tWn;

    ImageGalleryUI$12(ImageGalleryUI imageGalleryUI) {
        this.tWn = imageGalleryUI;
        this.sFo = kh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kh khVar = (kh) bVar;
        if (khVar != null && (khVar instanceof kh)) {
            x.i("MicroMsg.ImageGalleryUI", "notify Event: %d", new Object[]{Integer.valueOf(khVar.bUG.bUE)});
            if (khVar.bUG.activity == this.tWn && khVar.bUG.bHL.equals(ImageGalleryUI.c(this.tWn))) {
                switch (khVar.bUG.bUE) {
                    case 3:
                        this.tWn.finish();
                        break;
                }
            }
            x.e("MicroMsg.ImageGalleryUI", "not the same");
        } else {
            x.e("MicroMsg.ImageGalleryUI", "event is null or not a instant of NotifyDealQBarStrResultEvent");
        }
        return false;
    }
}
