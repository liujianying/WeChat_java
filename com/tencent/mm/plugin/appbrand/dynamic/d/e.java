package com.tencent.mm.plugin.appbrand.dynamic.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.appbrand.dynamic.d.a.b;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.c.a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends b {
    public e(int i) {
        super("getSystemInfoSync", i);
    }

    protected final JSONObject a(a aVar) {
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
        hashMap.put("version", com.tencent.mm.sdk.platformtools.e.aj(null, d.qVN));
        hashMap.put("system", "Android " + VERSION.RELEASE);
        return new JSONObject(hashMap);
    }
}
