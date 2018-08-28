package com.tencent.mm.app.plugin;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.ui.LauncherUI;

@a
class URISpanHandlerSet$JumpActivityUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$JumpActivityUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
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
        if (!str.toLowerCase().startsWith("weixin://jump/")) {
            return false;
        }
        String[] split = str.split("/");
        String str2 = split[split.length - 1];
        Intent intent;
        if ("mainframe".equalsIgnoreCase(str2)) {
            intent = new Intent(URISpanHandlerSet.a(this.bAt), LauncherUI.class);
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            intent.addFlags(67108864);
            URISpanHandlerSet.a(this.bAt).startActivity(intent);
        } else if ("shake".equalsIgnoreCase(str2)) {
            h.mEJ.k(10221, "1");
            intent = new Intent();
            intent.addFlags(67108864);
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            d.b(URISpanHandlerSet.a(this.bAt), "shake", ".ui.ShakeReportUI", intent);
            if (URISpanHandlerSet.a(this.bAt) != null && (URISpanHandlerSet.a(this.bAt) instanceof Activity)) {
                ((Activity) URISpanHandlerSet.a(this.bAt)).finish();
            }
        } else if ("scanqrcode".equalsIgnoreCase(str2)) {
            intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 2);
            intent.setFlags(65536);
            intent.addFlags(67108864);
            if (URISpanHandlerSet.a(this.bAt) instanceof Service) {
                intent.addFlags(268435456);
            }
            d.b(URISpanHandlerSet.a(this.bAt), "scanner", ".ui.BaseScanUI", intent);
        }
        return true;
    }
}
