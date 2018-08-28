package com.tencent.mm.plugin.remittance.ui;

import android.graphics.Bitmap;
import com.tencent.mm.platformtools.y.a;
import com.tencent.mm.sdk.platformtools.x;

class RemittanceF2fDynamicCodeUI$1 implements a {
    final /* synthetic */ RemittanceF2fDynamicCodeUI mCI;

    RemittanceF2fDynamicCodeUI$1(RemittanceF2fDynamicCodeUI remittanceF2fDynamicCodeUI) {
        this.mCI = remittanceF2fDynamicCodeUI;
    }

    public final void m(String str, Bitmap bitmap) {
        if (str != null && RemittanceF2fDynamicCodeUI.a(this.mCI) != null && str.equals(RemittanceF2fDynamicCodeUI.a(this.mCI))) {
            x.i("MicroMsg.RemittanceF2fDynamicCodeUI", "cdnImageDownloadListener mchPhoto = %s notifyKey = %s", new Object[]{RemittanceF2fDynamicCodeUI.a(this.mCI), str});
            this.mCI.runOnUiThread(new 1(this));
        }
    }
}
