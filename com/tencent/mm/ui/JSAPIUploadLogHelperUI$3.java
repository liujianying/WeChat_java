package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mm.R;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;

class JSAPIUploadLogHelperUI$3 implements aj {
    final /* synthetic */ ProgressDialog mnA;
    final /* synthetic */ JSAPIUploadLogHelperUI tkg;
    final /* synthetic */ OnDismissListener tkh;

    JSAPIUploadLogHelperUI$3(JSAPIUploadLogHelperUI jSAPIUploadLogHelperUI, ProgressDialog progressDialog, OnDismissListener onDismissListener) {
        this.tkg = jSAPIUploadLogHelperUI;
        this.mnA = progressDialog;
        this.tkh = onDismissListener;
    }

    public final void gW(int i) {
        c i2;
        if (i < 0) {
            x.e("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, error happened, percent:%d", new Object[]{Integer.valueOf(i)});
            au.a(null);
            if (this.mnA != null) {
                this.mnA.dismiss();
            }
            i2 = h.i(this.tkg, R.l.upload_fail, R.l.app_tip);
            if (i2 != null) {
                i2.setOnDismissListener(this.tkh);
            }
            synchronized (JSAPIUploadLogHelperUI.CO()) {
                JSAPIUploadLogHelperUI.ba(false);
            }
        } else if (i >= 100) {
            x.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi done.");
            au.a(null);
            if (this.mnA != null) {
                this.mnA.dismiss();
            }
            i2 = h.i(this.tkg, R.l.upload_success, R.l.app_tip);
            if (i2 != null) {
                i2.setOnDismissListener(this.tkh);
            }
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            com.tencent.mm.plugin.report.service.h.mEJ.h(12975, new Object[]{Long.valueOf(currentTimeMillis)});
            synchronized (JSAPIUploadLogHelperUI.CO()) {
                JSAPIUploadLogHelperUI.ba(false);
            }
        } else {
            x.i("MicroMsg.JSAPIUploadLogHelperUI", "uploadLog call by jsapi, ipxx progress:%d", new Object[]{Integer.valueOf(i)});
            if (this.mnA != null) {
                this.mnA.setMessage(this.tkg.getString(R.l.upload_ing) + i + "%");
            }
        }
    }
}
