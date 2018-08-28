package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.11;
import java.util.Collection;

class ImagePreviewUI$11$1 implements Runnable {
    final /* synthetic */ 11 jEb;

    ImagePreviewUI$11$1(11 11) {
        this.jEb = 11;
    }

    public final void run() {
        ImagePreviewUI.h(this.jEb.jEa).A(ImagePreviewUI.r(this.jEb.jEa));
        f fVar = (f) ImagePreviewUI.o(this.jEb.jEa).getAdapter();
        Collection r = ImagePreviewUI.r(this.jEb.jEa);
        fVar.jEl.clear();
        fVar.jEl.addAll(r);
        fVar.RR.notifyChanged();
        Collection stringArrayListExtra = this.jEb.heh.getStringArrayListExtra("preview_select_image_list");
        ImagePreviewUI.d(this.jEb.jEa).clear();
        if (stringArrayListExtra != null) {
            ImagePreviewUI.d(this.jEb.jEa).addAll(stringArrayListExtra);
        }
        this.jEb.jEa.updateOptionMenuText(0, ImagePreviewUI.m(this.jEb.jEa));
        ImagePreviewUI.f(this.jEb.jEa).setText(this.jEb.jEa.mController.tml.getString(R.l.gallery_pic_orignal) + ImagePreviewUI.aRY());
    }
}
