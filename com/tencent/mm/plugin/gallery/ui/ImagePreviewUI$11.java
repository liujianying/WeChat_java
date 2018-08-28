package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.mm.plugin.gallery.model.b.b;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.ag;

class ImagePreviewUI$11 implements b {
    final /* synthetic */ Intent heh;
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$11(ImagePreviewUI imagePreviewUI, Intent intent) {
        this.jEa = imagePreviewUI;
        this.heh = intent;
    }

    public final void CR(String str) {
        new ag(this.jEa.getMainLooper()).post(new 1(this));
        com.tencent.mm.plugin.gallery.model.b bVar = c.aRe().jAe;
        if (bVar.dHo != null && bVar.dHo.contains(this)) {
            bVar.dHo.remove(this);
        }
    }
}
