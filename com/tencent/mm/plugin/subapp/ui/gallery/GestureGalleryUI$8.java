package com.tencent.mm.plugin.subapp.ui.gallery;

import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.ui.base.h;

class GestureGalleryUI$8 implements a {
    final /* synthetic */ String ewx;
    final /* synthetic */ GestureGalleryUI osu;

    GestureGalleryUI$8(GestureGalleryUI gestureGalleryUI, String str) {
        this.osu = gestureGalleryUI;
        this.ewx = str;
    }

    public final void a(boolean z, String str, int i) {
        if (z) {
            if (n.nkw != null) {
                n.nkw.eu(this.ewx, str);
                n.nkw.bwX();
            }
            h.bA(this.osu, this.osu.getResources().getString(R.l.app_shared));
        }
    }
}
