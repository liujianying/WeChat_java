package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;

class AttachDownloadPage$8 implements OnClickListener {
    final /* synthetic */ AttachDownloadPage meu;

    AttachDownloadPage$8(AttachDownloadPage attachDownloadPage) {
        this.meu = attachDownloadPage;
    }

    public final void onClick(View view) {
        if (AttachDownloadPage.i(this.meu) == 3) {
            AttachDownloadPage.b(this.meu, AttachDownloadPage.a(this.meu));
            return;
        }
        AttachDownloadPage.h(this.meu);
        AttachDownloadPage.e(this.meu);
        AttachDownloadPage.f(this.meu);
    }
}
