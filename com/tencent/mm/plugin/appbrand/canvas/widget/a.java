package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;
import com.tencent.mm.plugin.appbrand.canvas.f;
import com.tencent.mm.plugin.appbrand.collector.d;
import org.json.JSONArray;

public interface a extends b, d {
    void a(JSONArray jSONArray, a aVar);

    void adk();

    void adl();

    void b(JSONArray jSONArray, a aVar);

    boolean d(Canvas canvas);

    f getDrawContext();

    int getType();

    void m(Runnable runnable);

    void setId(String str);
}
