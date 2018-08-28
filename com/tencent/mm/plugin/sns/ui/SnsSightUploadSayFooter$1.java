package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsSightUploadSayFooter$1 implements OnClickListener {
    final /* synthetic */ SnsSightUploadSayFooter obk;

    SnsSightUploadSayFooter$1(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        this.obk = snsSightUploadSayFooter;
    }

    public final void onClick(View view) {
        int i = 0;
        if (this.obk.getVisibility() == 8) {
            this.obk.setVisibility(0);
        }
        if (this.obk.kXH.getVisibility() == 0) {
            i = 1;
        }
        if (i != 0) {
            SnsSightUploadSayFooter.a(this.obk);
        }
    }
}
