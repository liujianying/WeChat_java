package com.tencent.mm.plugin.qqmail.ui;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.qqmail.b.p.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

class AttachDownloadPage$9 extends a {
    final /* synthetic */ AttachDownloadPage meu;

    AttachDownloadPage$9(AttachDownloadPage attachDownloadPage) {
        this.meu = attachDownloadPage;
    }

    public final void onProgress(int i) {
        x.d("MicroMsg.AttachDownloadPage", "download progress : " + i);
        AttachDownloadPage.j(this.meu);
        AttachDownloadPage.a(this.meu, 1);
    }

    public final void onSuccess(String str, Map<String, String> map) {
        e.i(AttachDownloadPage.k(this.meu), AttachDownloadPage.l(this.meu) + ".temp", AttachDownloadPage.l(this.meu));
        AttachDownloadPage.a(this.meu, 3);
        Toast.makeText(this.meu, this.meu.getString(R.l.download_success) + " : " + AttachDownloadPage.a(this.meu), 5000).show();
        AttachDownloadPage.d(this.meu);
    }

    public final void onError(int i, String str) {
        AttachDownloadPage.a(this.meu, 4);
        if (AttachDownloadPage.m(this.meu) < 5) {
            AttachDownloadPage.n(this.meu);
            AttachDownloadPage.f(this.meu);
            return;
        }
        AttachDownloadPage.d(this.meu);
    }

    public final void onComplete() {
    }
}
