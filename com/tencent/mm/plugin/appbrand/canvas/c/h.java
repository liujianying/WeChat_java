package com.tencent.mm.plugin.appbrand.canvas.c;

import android.graphics.Path;
import com.tencent.mm.plugin.appbrand.q.f;
import org.json.JSONArray;

public final class h implements a {
    public final String getMethod() {
        return "moveTo";
    }

    public final boolean a(Path path, JSONArray jSONArray) {
        if (jSONArray.length() < 2) {
            return false;
        }
        path.moveTo(f.d(jSONArray, 0), f.d(jSONArray, 1));
        return true;
    }
}
