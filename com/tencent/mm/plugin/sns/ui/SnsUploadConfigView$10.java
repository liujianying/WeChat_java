package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;

class SnsUploadConfigView$10 implements OnClickListener {
    final /* synthetic */ SnsUploadConfigView ogF;

    SnsUploadConfigView$10(SnsUploadConfigView snsUploadConfigView) {
        this.ogF = snsUploadConfigView;
    }

    public final void onClick(View view) {
        SnsUploadConfigView.d(this.ogF, !SnsUploadConfigView.i(this.ogF));
        if (SnsUploadConfigView.i(this.ogF)) {
            SnsUploadConfigView.g(this.ogF);
        }
        SnsUploadConfigView.j(this.ogF);
    }
}
