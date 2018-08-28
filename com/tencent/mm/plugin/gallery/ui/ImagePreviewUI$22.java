package com.tencent.mm.plugin.gallery.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.R;

class ImagePreviewUI$22 implements OnClickListener {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$22(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void onClick(View view) {
        ImagePreviewUI.b(this.jEa, !ImagePreviewUI.b(this.jEa));
        if (ImagePreviewUI.b(this.jEa)) {
            ImagePreviewUI.c(this.jEa).setImageResource(R.k.radio_on);
            if (ImagePreviewUI.d(this.jEa).size() == 0) {
                ImagePreviewUI.e(this.jEa).performClick();
            }
        } else {
            ImagePreviewUI.c(this.jEa).setImageResource(R.k.radio_off);
        }
        ImagePreviewUI.f(this.jEa).setText(this.jEa.mController.tml.getString(R.l.gallery_pic_orignal) + ImagePreviewUI.aRY());
        ImagePreviewUI.a(this.jEa, ImagePreviewUI.g(this.jEa).intValue());
    }
}
