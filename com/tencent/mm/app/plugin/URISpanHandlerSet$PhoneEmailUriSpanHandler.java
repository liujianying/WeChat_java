package com.tencent.mm.app.plugin;

import android.os.Bundle;
import com.tencent.mm.app.plugin.URISpanHandlerSet.BaseUriSpanHandler;
import com.tencent.mm.app.plugin.URISpanHandlerSet.a;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.pluginsdk.s;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.l;
import com.tencent.mm.sdk.platformtools.bi;

@a
class URISpanHandlerSet$PhoneEmailUriSpanHandler extends BaseUriSpanHandler {
    final /* synthetic */ URISpanHandlerSet bAt;

    URISpanHandlerSet$PhoneEmailUriSpanHandler(URISpanHandlerSet uRISpanHandlerSet) {
        this.bAt = uRISpanHandlerSet;
        super(uRISpanHandlerSet);
    }

    final m db(String str) {
        return null;
    }

    final int[] vB() {
        return new int[]{25, 24};
    }

    final boolean a(m mVar, g gVar) {
        if (mVar.type == 25) {
            String str = mVar.username;
            Bundle bundle = new Bundle();
            if (!(str == null || str.equals(q.GF()))) {
                bundle.putString("Contact_User", str);
                com.tencent.mm.plugin.account.friend.a.a pp = b.getAddrUploadStg().pp(str);
                if (pp == null || bi.oW(pp.Xh())) {
                    str = null;
                } else {
                    str = bi.oV(pp.Xp()).replace(" ", "");
                }
                bundle.putString("Contact_Mobile_MD5", str);
            }
            bundle.putInt("fromScene", 1);
            l.a(URISpanHandlerSet.a(this.bAt), mVar.url, null, bundle);
            return true;
        }
        if (mVar.type == 24) {
            l.b(URISpanHandlerSet.a(this.bAt), mVar.url, null);
        }
        return false;
    }

    final boolean a(String str, boolean z, s sVar, Bundle bundle) {
        return false;
    }
}
