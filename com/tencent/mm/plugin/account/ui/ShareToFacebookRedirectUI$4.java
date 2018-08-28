package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.model.f;
import com.tencent.mm.protocal.c.bks;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.ui.widget.a.e.b;

class ShareToFacebookRedirectUI$4 implements b {
    final /* synthetic */ ShareToFacebookRedirectUI eXf;
    final /* synthetic */ a eXg;

    ShareToFacebookRedirectUI$4(ShareToFacebookRedirectUI shareToFacebookRedirectUI, a aVar) {
        this.eXf = shareToFacebookRedirectUI;
        this.eXg = aVar;
    }

    public final void b(boolean z, String str) {
        this.eXf.YC();
        this.eXg.eIW.dismiss();
        if (z) {
            bks bks = new bks();
            if (bi.oW(str)) {
                str = " ";
            }
            bks.jPH = str;
            bks.jPe = ShareToFacebookRedirectUI.b(this.eXf);
            bks.rej = ShareToFacebookRedirectUI.c(this.eXf);
            bks.lCN = ShareToFacebookRedirectUI.d(this.eXf);
            bks.skc = ShareToFacebookRedirectUI.e(this.eXf);
            g.DF().a(new f(bks), 0);
            ShareToFacebookRedirectUI.a(this.eXf, h.a(this.eXf, "", false, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    ShareToFacebookRedirectUI.f(ShareToFacebookRedirectUI$4.this.eXf).dismiss();
                    ShareToFacebookRedirectUI$4.this.eXf.finish();
                }
            }));
            return;
        }
        this.eXf.finish();
    }
}
