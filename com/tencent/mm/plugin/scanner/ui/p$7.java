package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.af.a.b.a;
import com.tencent.mm.plugin.scanner.a.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class p$7 implements a {
    final /* synthetic */ p mLr;
    final /* synthetic */ Activity mr;

    p$7(p pVar, Activity activity) {
        this.mLr = pVar;
        this.mr = activity;
    }

    public final void a(String str, String str2, byte[] bArr, int i, int i2) {
        int i3 = 1;
        l.mFT.vy(l.mFR);
        if (this.mLr.mLf != null) {
            this.mLr.mLf.bsU();
        }
        if (this.mLr.eHw == null || !this.mLr.eHw.isShowing()) {
            this.mLr.mLh = false;
            this.mLr.mLi = false;
            return;
        }
        if (this.mLr.mKp != null) {
            this.mLr.mKp.hu(true);
        }
        this.mLr.eHw.dismiss();
        if (bi.oW(str2)) {
            l.mFT.aXS();
            h.a(this.mr, R.l.qrcode_read_file_failed, R.l.app_tip, new 1(this));
            return;
        }
        br.IE().c(10237, new Object[]{Integer.valueOf(1)});
        this.mLr.mKp.bss();
        if (!(i == 19 || i == 22)) {
            i3 = 2;
        }
        p.a(this.mLr, i3, str2, bArr, i, i2);
        this.mLr.mLi = false;
        this.mLr.mLg.set(false);
    }

    public final void Kg(String str) {
        l.mFT.vy(l.mFR);
        if (this.mLr.mLf != null) {
            this.mLr.mLf.bsU();
        }
        if (this.mLr.eHw == null || !this.mLr.eHw.isShowing()) {
            this.mLr.mLh = false;
            this.mLr.mLg.set(false);
            this.mLr.mLi = false;
            return;
        }
        if (this.mLr.mKp != null) {
            this.mLr.mKp.hu(true);
        }
        this.mLr.eHw.dismiss();
        l.mFT.aXS();
        h.a(this.mr, R.l.qrcode_read_file_failed, R.l.app_tip, new 2(this));
        this.mLr.mLg.set(false);
    }
}
