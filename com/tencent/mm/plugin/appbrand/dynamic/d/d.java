package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.a;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class d extends a {
    public d(int i) {
        super("getSystemInfo", i);
    }

    protected final void a(com.tencent.mm.u.c.a aVar, JSONObject jSONObject, b.a<JSONObject> aVar2) {
        Context context = aVar.getContext();
        u.b Da = aVar.Da();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f = displayMetrics.density;
        Map hashMap = new HashMap();
        hashMap.put("model", q.zE());
        hashMap.put("pixelRatio", Float.valueOf(f));
        hashMap.put("windowWidth", Integer.valueOf(f.lO(Da.getInt("__page_view_width", 0))));
        hashMap.put("windowHeight", Integer.valueOf(f.lO(Da.getInt("__page_view_height", 0))));
        hashMap.put("screenWidth", Integer.valueOf(f.lO(displayMetrics.widthPixels)));
        hashMap.put("screenHeight", Integer.valueOf(f.lO(displayMetrics.heightPixels)));
        hashMap.put("language", w.fD(context));
        hashMap.put("version", e.aj(null, com.tencent.mm.protocal.d.qVN));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        aVar2.aA(a(true, "", hashMap));
    }
}
