package com.tencent.mm.plugin.qqmail.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.qqmail.b.w;

class AttachDownloadPage$3 implements OnClickListener {
    final /* synthetic */ AttachDownloadPage meu;

    AttachDownloadPage$3(AttachDownloadPage attachDownloadPage) {
        this.meu = attachDownloadPage;
    }

    public final void onClick(View view) {
        AttachDownloadPage.a(this.meu, 2);
        w.bow().cancel(AttachDownloadPage.b(this.meu));
        AttachDownloadPage.c(this.meu);
        AttachDownloadPage.d(this.meu);
    }
}
