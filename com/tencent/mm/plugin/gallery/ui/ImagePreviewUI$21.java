package com.tencent.mm.plugin.gallery.ui;

import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;

class ImagePreviewUI$21 implements Runnable {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$21(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void run() {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) ImagePreviewUI.a(this.jEa).getLayoutParams();
        marginLayoutParams.topMargin = (int) (((float) j.S(this.jEa)) + this.jEa.getResources().getDimension(R.f.DefaultActionbarHeightPort));
        ImagePreviewUI.a(this.jEa).setLayoutParams(marginLayoutParams);
    }
}
