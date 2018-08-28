package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsUploadSayFooter$1 implements OnClickListener {
    final /* synthetic */ SnsUploadSayFooter ogJ;

    SnsUploadSayFooter$1(SnsUploadSayFooter snsUploadSayFooter) {
        this.ogJ = snsUploadSayFooter;
    }

    public final void onClick(View view) {
        if (this.ogJ.getVisibility() == 8) {
            this.ogJ.setVisibility(0);
        }
        if (this.ogJ.bEw()) {
            SnsUploadSayFooter.a(this.ogJ);
        }
    }
}
