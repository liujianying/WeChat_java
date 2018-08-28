package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class ImagePreviewUI$12 implements Runnable {
    final /* synthetic */ ImagePreviewUI jEa;
    final /* synthetic */ long jEc;

    ImagePreviewUI$12(ImagePreviewUI imagePreviewUI, long j) {
        this.jEa = imagePreviewUI;
        this.jEc = j;
    }

    public final void run() {
        ImagePreviewUI.a(this.jEa, true);
        c.aRg().qs(-8);
        x.v("MicroMsg.ImagePreviewUI", "test oncreate post: %d", new Object[]{Long.valueOf(bi.bI(this.jEc))});
    }
}
