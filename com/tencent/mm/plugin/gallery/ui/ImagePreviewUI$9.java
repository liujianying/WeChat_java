package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import com.tencent.mm.plugin.gallery.a.a;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.plugin.gallery.ui.f.b;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$9 implements b {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$9(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void qH(int i) {
        x.i("MicroMsg.ImagePreviewUI", "[onItemClick] position:%s %s", Integer.valueOf(i), Boolean.valueOf(ImagePreviewUI.p(this.jEa)));
        ((f) ImagePreviewUI.o(this.jEa).getAdapter()).cH(i, i);
        ImagePreviewUI.q(this.jEa).k(i, false);
        if (ImagePreviewUI.p(this.jEa)) {
            c.jAA = true;
        } else {
            c.jAC = true;
        }
    }

    public final void cG(int i, int i2) {
        x.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMove]fromPos:%s, toPos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), ImagePreviewUI.g(this.jEa));
    }

    public final void K(int i, int i2, int i3) {
        x.i("MicroMsg.ImagePreviewUIChangelcai", "[onItemMoved] fromPos:%s, toPos:%s,visiblePos:%s, mPosition:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), ImagePreviewUI.g(this.jEa));
        if (ImagePreviewUI.p(this.jEa)) {
            a.swap(ImagePreviewUI.d(this.jEa), i, i2);
            c.jAz = true;
            return;
        }
        a.swap(ImagePreviewUI.r(this.jEa), i, i2);
        c h = ImagePreviewUI.h(this.jEa);
        x.i("MicroMsg.ImageAdapter", "[swapPosition]from:%s to:%s curPos:%s visiblePos:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(ImagePreviewUI.g(this.jEa).intValue()), Integer.valueOf(i3));
        if (!h.jCW) {
            a.swap(h.jCV, i, i2);
            h.jCY = i3;
            h.jCZ = (View) h.tzb.get(r0);
            h.tyZ.remove(h.jCZ);
            h.tza.clear();
            h.tzb.clear();
            h.jDa = true;
            h.notifyDataSetChanged();
        }
        ImagePreviewUI.q(this.jEa).k(i3, false);
        ((f) ImagePreviewUI.o(this.jEa).getAdapter()).cH(i3, i3);
        c.jAB = true;
    }
}
