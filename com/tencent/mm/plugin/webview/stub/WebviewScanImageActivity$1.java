package com.tencent.mm.plugin.webview.stub;

import android.os.Bundle;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class WebviewScanImageActivity$1 extends c<kh> {
    final /* synthetic */ WebviewScanImageActivity pVi;

    WebviewScanImageActivity$1(WebviewScanImageActivity webviewScanImageActivity) {
        this.pVi = webviewScanImageActivity;
        super(0);
        this.sFo = kh.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        kh khVar = (kh) bVar;
        if (khVar != null && (khVar instanceof kh)) {
            a.sFg.c(WebviewScanImageActivity.a(this.pVi));
            x.i("MicroMsg.WebviewScanImageActivity", "notify Event: %d", new Object[]{Integer.valueOf(khVar.bUG.bUE)});
            x.d("MicroMsg.WebviewScanImageActivity", "%s, %s", new Object[]{khVar.bUG.activity, this.pVi});
            if (khVar.bUG.activity == this.pVi && khVar.bUG.bHL.equals(WebviewScanImageActivity.b(this.pVi))) {
                Bundle bundle = khVar.bUG.bUH;
                int i;
                switch (khVar.bUG.bUE) {
                    case 0:
                    case 1:
                    case 2:
                        this.pVi.finish();
                        break;
                    case 3:
                        if (bundle != null) {
                            i = bundle.getInt("geta8key_action_code", 0);
                            h.mEJ.h(13329, new Object[]{WebviewScanImageActivity.c(this.pVi), WebviewScanImageActivity.b(this.pVi), Integer.valueOf(i)});
                        }
                        this.pVi.finish();
                        break;
                    case 4:
                        if (bundle != null) {
                            i = bundle.getInt("geta8key_action_code", 0);
                            h.mEJ.h(13329, new Object[]{WebviewScanImageActivity.c(this.pVi), WebviewScanImageActivity.b(this.pVi), Integer.valueOf(i)});
                            break;
                        }
                        break;
                }
            }
            x.e("MicroMsg.WebviewScanImageActivity", "not the same, eventStr: %s, origin: %s", new Object[]{khVar.bUG.bHL, WebviewScanImageActivity.b(this.pVi)});
        } else {
            x.e("MicroMsg.WebviewScanImageActivity", "event is null or not a instant of NotifyDealQBarStrResultEvent");
        }
        return false;
    }
}
