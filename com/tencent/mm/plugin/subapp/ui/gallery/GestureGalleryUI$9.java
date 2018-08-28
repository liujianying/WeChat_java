package com.tencent.mm.plugin.subapp.ui.gallery;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class GestureGalleryUI$9 implements OnItemSelectedListener {
    final /* synthetic */ GestureGalleryUI osu;

    GestureGalleryUI$9(GestureGalleryUI gestureGalleryUI) {
        this.osu = gestureGalleryUI;
    }

    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        GestureGalleryUI.a(this.osu, i);
        this.osu.setMMTitle((GestureGalleryUI.j(this.osu) + 1) + " / " + GestureGalleryUI.k(this.osu).size());
        x.d("MicroMsg.GestureGalleryUI", "pos:" + i);
        GestureGalleryUI.c(this.osu, GestureGalleryUI.n(this.osu).c((String) GestureGalleryUI.k(this.osu).get(i), GestureGalleryUI.l(this.osu), i, GestureGalleryUI.m(this.osu)));
        if (bi.oW(GestureGalleryUI.b(this.osu))) {
            GestureGalleryUI.c(this.osu, (String) GestureGalleryUI.k(this.osu).get(i));
        }
    }

    public final void onNothingSelected(AdapterView<?> adapterView) {
    }
}
