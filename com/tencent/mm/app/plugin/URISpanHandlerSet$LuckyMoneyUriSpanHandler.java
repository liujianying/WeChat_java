package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;

@a
class URISpanHandlerSet$LuckyMoneyUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$LuckyMoneyUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        if (str.trim().toLowerCase().startsWith("weixin://weixinhongbao/")) {
            return new m(str, 33, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{33};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 33) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_native_url", mVar.url);
        d.b(URISpanHandlerSet.a(this.bAt), "luckymoney", ".ui.LuckyMoneyDetailUI", intent);
        h.mEJ.h(12097, new Object[]{Integer.valueOf(11), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis())});
        h.mEJ.h(11850, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
