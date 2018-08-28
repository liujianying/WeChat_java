package com.tencent.mm.plugin.appbrand.game.d.a;

import android.text.Editable;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.f;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 1;
    private static final String NAME = "showKeyboard";
    final c fCp = new c();
    final a fCq = new a();
    final b fCr = new b();

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$3 */
    class AnonymousClass3 extends f {
        final /* synthetic */ l fCl;

        AnonymousClass3(l lVar) {
            this.fCl = lVar;
        }

        public final void afterTextChanged(Editable editable) {
            if (!af.s(editable)) {
                e.this.fCp.a(editable.toString(), this.fCl);
            }
        }
    }

    public final void a(l lVar, JSONObject jSONObject, int i) {
        String optString = jSONObject.optString("defaultValue");
        int optInt = jSONObject.optInt("maxLength", 140);
        if (optInt <= 0) {
            optInt = Integer.MAX_VALUE;
        }
        ah.A(new 1(this, lVar, optString, optInt, jSONObject.optBoolean("multiple", false), jSONObject.optBoolean("confirmHold", false), b.wj(jSONObject.optString("confirmType")), i));
    }
}
