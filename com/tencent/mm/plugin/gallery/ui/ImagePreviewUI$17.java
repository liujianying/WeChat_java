package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;

class ImagePreviewUI$17 implements a {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$17(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void a(m mVar) {
        if (mVar.position == ImagePreviewUI.g(this.jEa).intValue()) {
            ImagePreviewUI.a(this.jEa, mVar.path, mVar.jBs);
        }
    }
}
