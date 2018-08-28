package com.tencent.mm.plugin.appbrand.widget.e;

import android.view.View;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.plugin.appbrand.jsapi.base.f;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import org.json.JSONObject;

public abstract class a extends c {
    private static final LinkedList<Runnable> gMi = new LinkedList();
    private static boolean gMj = false;
    private static a gMk = new 1();

    public abstract boolean a(p pVar, JSONObject jSONObject, a aVar, f fVar);

    protected final boolean a(p pVar, int i, View view, JSONObject jSONObject, f fVar) {
        2 2 = new 2(this, pVar, i, view, jSONObject, fVar);
        if (gMj) {
            gMi.add(2);
            x.i("MicroMsg.BaseMarkerAnimatorJsApi", "add to MarkerAnimator!");
        } else {
            gMj = true;
            2.run();
        }
        return true;
    }
}
