package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsUploadConfigView$9 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;

    SnsUploadConfigView$9(SnsUploadConfigView snsUploadConfigView) {
        this.ogF = snsUploadConfigView;
    }

    public final void onClick(View view) {
        SnsUploadConfigView.c(this.ogF, !SnsUploadConfigView.f(this.ogF));
        if (SnsUploadConfigView.f(this.ogF)) {
            SnsUploadConfigView.g(this.ogF);
        }
        SnsUploadConfigView.h(this.ogF);
    }
}
