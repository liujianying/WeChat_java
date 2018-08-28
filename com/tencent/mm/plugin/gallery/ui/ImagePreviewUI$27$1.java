package com.tencent.mm.plugin.gallery.ui;

import android.content.Intent;
import com.tencent.mm.plugin.gallery.ui.ImagePreviewUI.27;

class ImagePreviewUI$27$1 implements Runnable {
    final /* synthetic */ boolean jEg;
    final /* synthetic */ boolean jEh;
    final /* synthetic */ 27 jEi;
    final /* synthetic */ Intent val$intent;

    ImagePreviewUI$27$1(27 27, Intent intent, boolean z, boolean z2) {
        this.jEi = 27;
        this.val$intent = intent;
        this.jEg = z;
        this.jEh = z2;
    }

    public final void run() {
        ImagePreviewUI.a(this.jEi.jEa, this.val$intent, this.jEg, this.jEh);
    }

    public final String toString() {
        return super.toString() + "|addTextOptionMenu";
    }
}
