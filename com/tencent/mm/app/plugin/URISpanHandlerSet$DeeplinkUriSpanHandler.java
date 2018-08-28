package com.tencent.mm.app.plugin;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.ac.f;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.PRIORITY;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;

@a(vC = PRIORITY.LOW)
class URISpanHandlerSet$DeeplinkUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$DeeplinkUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        x.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler getHrefFromUrl %s", new Object[]{str});
        if (str.trim().toLowerCase().startsWith("weixin://")) {
            return new m(str, 30, null);
        }
        return null;
    }

    final int[] vB() {
        return new int[]{30};
    }

    final boolean a(m mVar, g gVar) {
        String str;
        x.i("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler handleSpanClick %d, %s", new Object[]{Integer.valueOf(mVar.type), mVar.url});
        if (gVar != null) {
            str = (String) gVar.a(mVar);
        } else {
            str = null;
        }
        if (mVar.type != 30) {
            return false;
        }
        String oV = bi.oV(mVar.url);
        if (oV.startsWith("weixin://shieldBrandMsg/") || oV.startsWith("weixin://receiveBrandMsg/")) {
            if (bi.oW(str)) {
                x.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null");
                return true;
            }
            d kH = f.kH(str);
            if (kH == null) {
                x.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler BizInfo is null");
                return true;
            } else if (oV.startsWith("weixin://shieldBrandMsg/")) {
                h.a(URISpanHandlerSet.a(this.bAt), R.l.temp_session_shield_biz_msg_tips, R.l.app_tip, R.l.temp_session_shield_biz_msg_confirm, R.l.cancel, new 1(this, kH, oV, str), null);
            } else if (oV.startsWith("weixin://receiveBrandMsg/")) {
                h.a(URISpanHandlerSet.a(this.bAt), R.l.temp_session_receive_biz_msg_tips, R.l.app_tip, R.l.temp_session_receive_biz_msg_confirm, R.l.cancel, new 2(this, kH, oV, str), null);
            }
        } else if (com.tencent.mm.pluginsdk.d.k(Uri.parse(oV))) {
            com.tencent.mm.pluginsdk.d.x(URISpanHandlerSet.a(this.bAt), str, oV);
        } else if (!oV.startsWith("weixin://receiveWeAppKFMsg")) {
            com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.a(this.bAt), oV, str, 1, oV, null);
        } else if (bi.oW(str)) {
            x.e("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler username is null, handle the BUILTIN_RECEIVE_WEAPP_KFMSG ,  the herfUrl is %s", new Object[]{oV});
            return true;
        } else {
            h.a(URISpanHandlerSet.a(this.bAt), R.l.app_brand_reveive_msg_title, R.l.app_tip, R.l.app_brand_reveive_msg_config, R.l.cancel, new 3(this, str), null);
        }
        return true;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        if (bi.oW(str) || bundle == null) {
            boolean z2;
            String str2 = "MicroMsg.URISpanHandlerSet";
            String str3 = "url is null ? %b, paramsBundle is null ? %b";
            Object[] objArr = new Object[2];
            if (str == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[0] = Boolean.valueOf(z2);
            if (bundle == null) {
                z2 = true;
            } else {
                z2 = false;
            }
            objArr[1] = Boolean.valueOf(z2);
            x.e(str2, str3, objArr);
            return false;
        } else if (!com.tencent.mm.pluginsdk.d.k(Uri.parse(str))) {
            return false;
        } else {
            int i = bundle.getInt("key_scene", -1);
            x.d("MicroMsg.URISpanHandlerSet", "DeeplinkUriSpanHandler jump, %d, %s", new Object[]{Integer.valueOf(i), str});
            if (i == -1) {
                i = 5;
            }
            com.tencent.mm.pluginsdk.d.a(URISpanHandlerSet.a(this.bAt), str, i, new 4(this, h.a(URISpanHandlerSet.a(this.bAt), "", true, null)));
            return true;
        }
    }
}
