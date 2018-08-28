package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.d.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class c extends b {
    private e fFu;
    private int fFw;
    WeakReference<p> mPageRef;

    abstract void u(JSONObject jSONObject);

    c() {
    }

    final void a(e eVar, p pVar, JSONObject jSONObject, int i) {
        this.fFu = eVar;
        this.mPageRef = new WeakReference(pVar);
        this.fFw = i;
        u(jSONObject);
    }

    protected final View ajw() {
        return this.mPageRef == null ? null : ((p) this.mPageRef.get()).getContentView();
    }

    final void h(String str, Map<String, Object> map) {
        if (this.mPageRef != null && this.mPageRef.get() != null && this.fFu != null) {
            ((p) this.mPageRef.get()).E(this.fFw, this.fFu.f(str, map));
        }
    }

    final void ajx() {
        C(AppBrandEmptyPickerView.class);
        this.gMI.setOnResultListener(new a() {
            public final void f(boolean z, Object obj) {
                c.this.gMI.hide();
            }
        });
        this.gMI.show();
    }
}
