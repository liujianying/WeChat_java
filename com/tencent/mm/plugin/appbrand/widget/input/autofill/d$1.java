package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.EditText;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.plugin.appbrand.jsapi.d.f$a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.autofill.h.a;
import com.tencent.mm.plugin.appbrand.widget.input.z;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

class d$1 implements h {
    final /* synthetic */ WeakReference fQJ;
    final /* synthetic */ WeakReference gKn;

    d$1(WeakReference weakReference, WeakReference weakReference2) {
        this.gKn = weakReference;
        this.fQJ = weakReference2;
    }

    public final void a(String str, a aVar) {
        EditText editText = (EditText) this.gKn.get();
        p pVar = (p) this.fQJ.get();
        if (editText != null && pVar != null) {
            int inputId = ((z) editText).getInputId();
            f$a f_a = new f$a();
            Map hashMap = new HashMap();
            hashMap.put(SlookAirButtonFrequentContactAdapter.ID, str);
            hashMap.put("type", aVar.name().toLowerCase());
            hashMap.put("inputId", Integer.valueOf(inputId));
            f_a.aC(pVar.mAppId, pVar.hashCode()).x(hashMap).h(new int[]{pVar.hashCode()});
        }
    }
}
