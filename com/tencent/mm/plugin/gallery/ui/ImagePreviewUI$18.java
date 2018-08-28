package com.tencent.mm.plugin.gallery.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.gallery.model.m;
import com.tencent.mm.plugin.gallery.model.m.a;

class ImagePreviewUI$18 implements a {
    final /* synthetic */ ImagePreviewUI jEa;

    ImagePreviewUI$18(ImagePreviewUI imagePreviewUI) {
        this.jEa = imagePreviewUI;
    }

    public final void a(m mVar) {
        if (mVar.position == ImagePreviewUI.g(this.jEa).intValue()) {
            if (mVar.jBs.egD >= 300000 || (mVar.jBs.egD > 0 && mVar.jBs.egD < 1000)) {
                ImagePreviewUI.a(this.jEa).setVisibility(0);
                ImagePreviewUI.x(this.jEa).setText(mVar.jBs.egD >= 300000 ? this.jEa.getString(R.l.gallery_pic_video_too_long_desc) : this.jEa.getString(R.l.gallery_pic_video_too_short_desc));
                ImagePreviewUI.y(this.jEa).setEnabled(false);
                ImagePreviewUI.e(this.jEa).setEnabled(false);
                ImagePreviewUI.y(this.jEa).setTextColor(this.jEa.getResources().getColor(R.e.white_text_color_disabled));
                if (ImagePreviewUI.d(this.jEa).size() == 0) {
                    this.jEa.enableOptionMenu(false);
                    return;
                }
                return;
            }
            ImagePreviewUI.y(this.jEa).setEnabled(true);
            ImagePreviewUI.e(this.jEa).setEnabled(true);
            ImagePreviewUI.y(this.jEa).setTextColor(this.jEa.getResources().getColor(R.e.white_text_color));
            ImagePreviewUI.a(this.jEa).setVisibility(8);
        }
    }
}
