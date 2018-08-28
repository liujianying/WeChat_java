package com.tencent.mm.plugin.gallery.ui;

import android.support.v4.view.ViewPager.e;
import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$13 implements e {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$13(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void O(int i) {
        c.qn(i);
        String jl = ImagePreviewUI.h(this.jEa).jl(i);
        ImagePreviewUI.a(this.jEa, i, jl);
        boolean contains = ImagePreviewUI.d(this.jEa).contains(jl);
        ImagePreviewUI.a(this.jEa, Integer.valueOf(i));
        ImagePreviewUI.e(this.jEa).setImageResource(contains ? R.k.checkbox_selected : R.k.checkbox_unselected);
        if (ImagePreviewUI.b(this.jEa)) {
            ImagePreviewUI.c(this.jEa).setImageResource(R.k.radio_on);
        } else {
            ImagePreviewUI.c(this.jEa).setImageResource(R.k.radio_off);
        }
        this.jEa.setMMTitle(String.format("%d/%d", new Object[]{Integer.valueOf(i + 1), Integer.valueOf(ImagePreviewUI.h(this.jEa).getCount())}));
        e eVar = ImagePreviewUI.h(this.jEa).jDc;
        if (eVar.jDz == -1) {
            int i2 = 0;
            while (true) {
                if (i2 != 0) {
                    if (i + i2 > i + 3 && i - i2 < Math.max(i - 3, 0)) {
                        break;
                    }
                    if (i + i2 <= i + 3) {
                        eVar.qG(i + i2);
                    }
                    if (i - i2 >= Math.max(i - 3, 0)) {
                        eVar.qG(i - i2);
                    }
                } else {
                    eVar.qG(i);
                }
                i2++;
            }
        } else if (eVar.jDz > i) {
            eVar.qG(Math.max(i - 3, 0));
        } else if (eVar.jDz < i) {
            eVar.qG(i + 3);
        }
        eVar.jDz = i;
        x.d("MicroMsg.ImagePreviewUI", "onItemSelected, pos = " + i);
        MediaItem CS = c.CS(jl);
        if (ImagePreviewUI.t(this.jEa).getVisibility() == 0 || ImagePreviewUI.u(this.jEa).getVisibility() == 0) {
            ImagePreviewUI.a(this.jEa, jl, CS);
            ImagePreviewUI.a(this.jEa, CS);
        }
    }

    public final void a(int i, float f, int i2) {
    }

    public final void N(int i) {
        if (ImagePreviewUI.h(this.jEa) != null) {
            ImagePreviewUI.h(this.jEa).jDd.N(i);
        }
    }
}
