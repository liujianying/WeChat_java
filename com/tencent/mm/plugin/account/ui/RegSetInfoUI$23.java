package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class RegSetInfoUI$23 implements a {
    final /* synthetic */ RegSetInfoUI eWJ;
    String eWQ;
    Bitmap mBitmap;

    RegSetInfoUI$23(RegSetInfoUI regSetInfoUI) {
        this.eWJ = regSetInfoUI;
    }

    public final boolean Ks() {
        if (!bi.oW(this.eWQ) && bi.oW((RegSetInfoUI.b(this.eWJ).getText()).trim())) {
            RegSetInfoUI.b(this.eWJ).setText(this.eWQ);
        }
        if (f.zZ()) {
            if (!(this.mBitmap == null || this.mBitmap.isRecycled() || RegSetInfoUI.j(this.eWJ))) {
                RegSetInfoUI.i(this.eWJ).setImageBitmap(this.mBitmap);
                RegSetInfoUI.k(this.eWJ);
                RegSetInfoUI.l(this.eWJ).setVisibility(0);
            }
            return true;
        }
        x.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
        return false;
    }

    public final boolean Kr() {
        try {
            this.eWQ = j.bW(this.eWJ);
            this.mBitmap = j.bX(this.eWJ);
        } catch (Exception e) {
            x.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + e.getMessage());
        }
        if (!(this.mBitmap == null || this.mBitmap.isRecycled())) {
            try {
                c.a(this.mBitmap, 100, CompressFormat.PNG, e.dgs + "temp.avatar", false);
            } catch (Throwable e2) {
                x.e("MiroMsg.RegSetInfoUI", "save avatar fail." + e2.getMessage());
                x.printErrStackTrace("MiroMsg.RegSetInfoUI", e2, "", new Object[0]);
            }
        }
        return true;
    }

    public final String toString() {
        return super.toString() + "|initView";
    }
}
