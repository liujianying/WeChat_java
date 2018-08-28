package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class FavImgGalleryUI$2 extends c<mu> {
    final /* synthetic */ FavImgGalleryUI iYT;

    FavImgGalleryUI$2(FavImgGalleryUI favImgGalleryUI) {
        this.iYT = favImgGalleryUI;
        this.sFo = mu.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mu muVar = (mu) bVar;
        FavImgGalleryUI.f(this.iYT).put(muVar.bXK.filePath, muVar);
        if (FavImgGalleryUI.i(this.iYT) != null && FavImgGalleryUI.i(this.iYT).ofo.isShowing()) {
            FavImgGalleryUI.a(this.iYT);
        }
        return true;
    }
}
