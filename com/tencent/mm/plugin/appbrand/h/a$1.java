package com.tencent.mm.plugin.appbrand.h;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.messenger.a.a;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends a {
    final /* synthetic */ long dUM;
    final /* synthetic */ int eeg;
    final /* synthetic */ com.tencent.mm.y.a.a gjP;
    final /* synthetic */ String gjQ;
    final /* synthetic */ String gjR;
    final /* synthetic */ a gjS;

    a$1(a aVar, com.tencent.mm.y.a.a aVar2, String str, int i, long j, String str2) {
        this.gjS = aVar;
        this.gjP = aVar2;
        this.gjQ = str;
        this.eeg = i;
        this.dUM = j;
        this.gjR = str2;
    }

    public final void onClickImp(View view) {
        x.i("MicroMsg.WxaSubscribeMsgService", "On Span clicked(title : %s, username : %s, path : %s, talker : %s)", new Object[]{this.gjP.content, this.gjP.username, this.gjP.path, this.gjQ});
        Bundle bundle = new Bundle();
        bundle.putInt("stat_scene", this.eeg);
        bundle.putString("stat_msg_id", "msg_" + Long.toString(this.dUM));
        bundle.putString("stat_chat_talker_username", this.gjQ);
        bundle.putString("stat_send_msg_user", this.gjR);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1088;
        appBrandStatObject.bGG = "";
        appBrandStatObject.cbB = c.h(appBrandStatObject.scene, bundle);
        appBrandStatObject.cbC = c.i(appBrandStatObject.scene, bundle);
        String str = "";
        if (this.gjP.path != null && this.gjP.path.length() > 0) {
            byte[] decode = Base64.decode(this.gjP.path, 2);
            if (decode != null) {
                str = new String(decode);
            }
        }
        ((d) g.l(d.class)).a(view.getContext(), this.gjP.username, null, this.gjP.type, 0, str, appBrandStatObject);
    }
}
