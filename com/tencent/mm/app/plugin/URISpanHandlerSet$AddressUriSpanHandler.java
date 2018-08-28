package com.tencent.mm.app.plugin;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

@a
class URISpanHandlerSet$AddressUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$AddressUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        return null;
    }

    final int[] vB() {
        return new int[]{44};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type != 44) {
            return false;
        }
        Uri parse = Uri.parse("geo:0,0?q=" + Uri.encode(mVar.url));
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(parse);
        intent.addFlags(268435456);
        if (intent.resolveActivity(ad.getContext().getPackageManager()) != null) {
            ad.getContext().startActivity(intent);
            h.mEJ.h(12809, new Object[]{Integer.valueOf(9), ""});
        } else {
            x.w("MicroMsg.URISpanHandlerSet", "Cannot find map app");
        }
        h.mEJ.h(12809, new Object[]{Integer.valueOf(8), ""});
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
