package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiPrivateAddContact extends a {
    public static final int CTRL_INDEX = 407;
    public static final String NAME = "private_addContact";

    public final void a(p pVar, JSONObject jSONObject, int i) {
        a(ahQ(), pVar, jSONObject, i);
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        a(ahQ(), lVar, jSONObject, i);
    }

    protected int ahQ() {
        return 1;
    }

    private void a(int i, c cVar, JSONObject jSONObject, int i2) {
        try {
            int i3 = jSONObject.getInt("scene");
            String string = jSONObject.getString("username");
            if (bi.oW(string)) {
                x.i("MicroMsg.JsApiPrivateAddContact", "username nil");
                cVar.E(i2, f("fail:username is nil", null));
                return;
            }
            AddContactRequest addContactRequest = new AddContactRequest();
            addContactRequest.userName = string;
            addContactRequest.scene = i3;
            addContactRequest.fGD = i;
            a.a(cVar.getContext(), addContactRequest, new 1(this, cVar, i2));
        } catch (JSONException e) {
            x.w("MicroMsg.JsApiPrivateAddContact", "parse exp:%s", new Object[]{e});
            cVar.E(i2, f("fail:parse exp", null));
        }
    }
}
