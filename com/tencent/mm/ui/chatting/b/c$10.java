package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.ac.d.b;
import com.tencent.mm.ac.d.b.c;
import com.tencent.mm.ac.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.n.d;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter$d;
import org.json.JSONException;
import org.json.JSONObject;

class c$10 implements ChatFooter$d {
    final /* synthetic */ c tOm;

    c$10(c cVar) {
        this.tOm = cVar;
    }

    public final boolean kS(boolean z) {
        if (c.c(this.tOm) == null) {
            return false;
        }
        b bG = c.c(this.tOm).bG(false);
        if (bG == null) {
            return false;
        }
        c My = bG.My();
        if (My == null || My.dLC == null || My.dLC.isEmpty()) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(((j) My.dLC.get(0)).value);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1083;
            appBrandStatObject.bGG = c.c(this.tOm).field_username;
            ((d) g.l(d.class)).a(this.tOm.bAG.tTq.getContext(), jSONObject.optString("userName"), null, 0, 0, jSONObject.optString("pagePath"), appBrandStatObject, c.c(this.tOm).field_appId);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }
}
