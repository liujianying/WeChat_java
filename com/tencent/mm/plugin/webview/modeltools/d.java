package com.tencent.mm.plugin.webview.modeltools;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import org.json.JSONObject;

public final class d {
    String pTL = null;
    private a pTM;
    private c pTN = new 1(this);
    private c pTO = new 2(this);
    private c pTP = new 3(this);

    static /* synthetic */ void a(d dVar) {
        dVar.pTM = null;
        a.sFg.c(dVar.pTN);
        a.sFg.c(dVar.pTO);
        a.sFg.c(dVar.pTP);
    }

    static /* synthetic */ void a(d dVar, String str) {
        if (dVar.pTM != null) {
            dVar.pTM.QK(str);
        }
    }

    static /* synthetic */ void a(d dVar, String str, JSONObject jSONObject, Bitmap bitmap) {
        if (dVar.pTM != null) {
            dVar.pTM.a(str, jSONObject, bitmap);
        }
    }

    static /* synthetic */ void b(d dVar, String str) {
        if (dVar.pTM != null) {
            dVar.pTM.MY(str);
        }
    }

    public final boolean a(String str, Context context, a aVar) {
        Intent intent;
        if ("bank".equalsIgnoreCase(str)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 7);
            intent.putExtra("scan_bankcard_with_confirm_ui", true);
            intent.addFlags(268435456);
            com.tencent.mm.bg.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.pTM = aVar;
            this.pTL = "bank";
            a.sFg.b(this.pTN);
            a.sFg.b(this.pTO);
            return true;
        } else if (!"identity_pay_auth".equalsIgnoreCase(str)) {
            return false;
        } else {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 11);
            com.tencent.mm.bg.d.b(context, "scanner", ".ui.BaseScanUI", intent);
            this.pTM = aVar;
            this.pTL = "identity";
            a.sFg.b(this.pTN);
            a.sFg.b(this.pTP);
            return true;
        }
    }
}
