package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;

class ImagePreviewUI$8 implements Runnable {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$8(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void run() {
        int i = this.jEa.getResources().getDisplayMetrics().widthPixels / 7;
        ImagePreviewUI.o(this.jEa).getLayoutParams().height = (((int) ad.getContext().getResources().getDimension(R.f.LargePadding)) * 2) + i;
        ImagePreviewUI.o(this.jEa).smoothScrollToPosition(ImagePreviewUI.g(this.jEa).intValue());
    }
}
