package com.tencent.mm.ui;

import com.tencent.mm.ui.af.d;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class MMNewPhotoEditUI$3 implements c {
    final /* synthetic */ MMNewPhotoEditUI tnX;

    MMNewPhotoEditUI$3(MMNewPhotoEditUI mMNewPhotoEditUI) {
        this.tnX = mMNewPhotoEditUI;
    }

    public final void a(l lVar) {
        lVar.e(0, this.tnX.getString(d.retransmits));
        lVar.e(1, this.tnX.getString(d.plugin_favorite_opt));
        lVar.e(2, this.tnX.getString(d.save_img_to_local));
    }
}
