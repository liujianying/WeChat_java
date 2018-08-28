package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.l;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public abstract class f extends g implements a {
    protected MMActivity fEY;
    private int fEZ;

    public abstract boolean a(MMActivity mMActivity, JSONObject jSONObject, int i);

    public abstract void onError(int i, String str);

    public abstract void u(Intent intent);

    public f(e eVar, l lVar, p pVar, JSONObject jSONObject, int i) {
        MMActivity mMActivity;
        super(eVar, lVar, pVar, jSONObject, i);
        n nVar = lVar.fdO.fcz;
        if (nVar == null) {
            mMActivity = null;
        } else {
            Context context = nVar.getContext();
            mMActivity = !(context instanceof MMActivity) ? null : (MMActivity) context;
        }
        this.fEY = mMActivity;
        if (this.fEY == null) {
            throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
        }
        this.fEZ = eVar.hashCode() & 65535;
    }

    public final void run() {
        this.fEY.geJ = this;
        if (!a(this.fEY, ahL(), this.fEZ)) {
            onError(-1, "fail:system error {{launch fail}}");
        }
    }

    public final void b(int i, int i2, Intent intent) {
        if (this.fEZ == i) {
            if (i2 == -1) {
                u(intent);
            } else if (intent == null || !intent.hasExtra("result_error_msg")) {
                onError(-1, "fail:system error {{unknow error}}");
            } else {
                onError(intent.getIntExtra("result_error_code", -1), intent.getStringExtra("result_error_msg"));
            }
        }
    }
}
