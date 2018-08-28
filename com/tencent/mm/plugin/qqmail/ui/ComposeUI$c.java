package com.tencent.mm.plugin.qqmail.ui;

import android.widget.ImageView;
import com.tencent.mm.plugin.qqmail.ui.MailAddrsViewControl.c;

class ComposeUI$c extends c {
    private ImageView mfF;
    final /* synthetic */ ComposeUI mfs;
    private int tag;

    public ComposeUI$c(ComposeUI composeUI, ImageView imageView, int i) {
        this.mfs = composeUI;
        this.mfF = imageView;
        this.tag = i;
    }

    public final void hg(boolean z) {
        ImageView imageView;
        int i = 0;
        ComposeUI.y(this.mfs);
        if (this.mfs.meX) {
            imageView = this.mfF;
        } else {
            imageView = this.mfF;
            if (!z) {
                i = 4;
            }
        }
        imageView.setVisibility(i);
        if ((this.tag == 1 || this.tag == 2) && !z) {
            ComposeUI.z(this.mfs).postDelayed(new 1(this), 10);
        }
    }
}
