package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.extension.f;
import com.tencent.mm.model.u.b;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class g extends com.tencent.mm.plugin.appbrand.dynamic.d.a.a {

    private static class a implements f {
        String cbJ;
        String id;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void f(Parcel parcel) {
            parcel.writeString(this.id);
            parcel.writeString(this.cbJ);
        }

        public final void readFromParcel(Parcel parcel) {
            this.id = parcel.readString();
            this.cbJ = parcel.readString();
        }
    }

    public g() {
        super("makePhoneCall", 327);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, com.tencent.mm.u.b.b.a<JSONObject> aVar2) {
        b Da = aVar.Da();
        a aVar3 = new a();
        aVar3.id = Da.getString("__page_view_id", "");
        aVar3.cbJ = jSONObject.optString("phoneNumber", "");
        XIPCInvoker.a(Da.getString("__process_name", ad.getProcessName()), aVar3, b.class, new 1(this, aVar2));
    }
}
