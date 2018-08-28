package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class FavImgGalleryUI$5 implements c {
    final /* synthetic */ FavImgGalleryUI iYT;
    final /* synthetic */ List ioK;
    final /* synthetic */ List ioL;

    FavImgGalleryUI$5(FavImgGalleryUI favImgGalleryUI, List list, List list2) {
        this.iYT = favImgGalleryUI;
        this.ioK = list;
        this.ioL = list2;
    }

    public final void a(l lVar) {
        lVar.setHeaderTitle((CharSequence) "");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioK.size()) {
                lVar.e(((Integer) this.ioK.get(i2)).intValue(), (CharSequence) this.ioL.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
