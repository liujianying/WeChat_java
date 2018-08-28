package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.sdk.platformtools.al.a;

class ImagePreviewUI$15 implements a {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$15(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final boolean vD() {
        boolean z;
        ImagePreviewUI imagePreviewUI = this.jEa;
        if (ImagePreviewUI.w(this.jEa)) {
            z = false;
        } else {
            z = true;
        }
        ImagePreviewUI.c(imagePreviewUI, z);
        ImagePreviewUI.a(this.jEa, ImagePreviewUI.w(this.jEa));
        return false;
    }
}
