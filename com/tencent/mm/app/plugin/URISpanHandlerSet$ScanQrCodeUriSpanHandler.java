package com.tencent.mm.app.plugin;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.x;

@a
class URISpanHandlerSet$ScanQrCodeUriSpanHandler extends URISpanHandlerSet$BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$ScanQrCodeUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        return null;
    }

    final int[] vB() {
        return new int[0];
    }

    final boolean a(m mVar, g gVar) {
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        boolean z2 = false;
        if (!str.equals("weixin://scanqrcode/")) {
            return false;
        }
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            if (bundle != null && bundle.getInt("fromScene") == 100) {
                z2 = true;
            }
            if (!z2) {
                intent.addFlags(67108864);
            }
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            if (z2) {
                d.b(URISpanHandlerSet.a(this.bAt), "scanner", ".ui.SingleTopScanUI", intent);
                return true;
            }
            d.b(URISpanHandlerSet.a(this.bAt), "scanner", ".ui.BaseScanUI", intent);
            return true;
        }
        x.e("MicroMsg.URISpanHandlerSet", "jumpToActivity, scan qrcode permission fail");
        return true;
    }
}
