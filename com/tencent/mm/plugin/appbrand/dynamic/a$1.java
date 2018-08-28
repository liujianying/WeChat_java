package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements c<Bundle> {
    final /* synthetic */ String bAj;
    final /* synthetic */ String fue;
    final /* synthetic */ Bundle fuf;
    final /* synthetic */ a fug;
    final /* synthetic */ String sk;

    public a$1(a aVar, String str, String str2, String str3, Bundle bundle) {
        this.fug = aVar;
        this.fue = str;
        this.sk = str2;
        this.bAj = str3;
        this.fuf = bundle;
    }

    public final /* synthetic */ void at(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.fue.equals(this.fug.fuc)) {
            int i = bundle.getInt("op");
            if (i == 0) {
                this.fug.fud.cleanup();
            } else if (i == 1) {
                h.mEJ.a(635, 0, 1, false);
                WxaWidgetContext wxaWidgetContext = (WxaWidgetContext) bundle.getParcelable("fwContext");
                if (!bundle.getBoolean("success", false) || wxaWidgetContext == null) {
                    x.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", new Object[]{this.sk});
                    s.i("MicroMsg.DynamicIPCJsBridge", "init widget running context(%s) failed", new Object[]{this.sk});
                    this.fug.fud.ka(1);
                    h.mEJ.a(635, 2, 1, false);
                } else if (wxaWidgetContext.afb() != 1) {
                    x.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", new Object[]{this.sk});
                    s.i("MicroMsg.DynamicIPCJsBridge", "abort init widget running context(%s), server banned", new Object[]{this.sk});
                    this.fug.fud.ka(2);
                    h.mEJ.a(635, 2, 1, false);
                } else {
                    s.i("MicroMsg.DynamicIPCJsBridge", " putContext ", new Object[]{this.sk});
                    k.a(this.sk, wxaWidgetContext);
                    this.fug.fud.d(this.sk, this.bAj, this.fuf);
                    h.mEJ.a(635, 1, 1, false);
                }
            }
        }
    }
}
