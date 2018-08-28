package com.tencent.mm.plugin.appbrand.canvas;

import android.graphics.Canvas;
import android.graphics.Paint.Style;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.canvas.widget.a;
import com.tencent.mm.plugin.appbrand.collector.c;
import com.tencent.mm.plugin.appbrand.q.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d implements a {
    volatile boolean fmN;
    JSONArray fmO;
    private f fmP;
    private e fmQ;
    a fmR;
    private volatile String fmS;
    public volatile boolean fmT;
    private Runnable fmU = new 1(this);
    private Runnable fmV = new 2(this);
    private volatile long fmW;
    protected long fmX;
    protected long fmY;
    protected volatile long fmZ;
    protected int mCount;

    public d(a aVar) {
        this.fmR = aVar;
        this.fmP = new f(new a(aVar));
        this.fmQ = new e();
    }

    public final boolean d(Canvas canvas) {
        this.fmN = false;
        if (this.fmO == null || this.fmO.length() == 0) {
            return false;
        }
        long nanoTime;
        long j = this.fmW;
        long nanoTime2 = System.nanoTime();
        String sessionId = getSessionId();
        if (j != 0) {
            c.aZ(sessionId, "before_draw_actions");
        }
        f fVar = this.fmP;
        fVar.fnh.clear();
        fVar.fni.clear();
        fVar.fnf.reset();
        fVar.fng.reset();
        fVar.fnf.setStyle(Style.STROKE);
        fVar.fng.setStyle(Style.FILL);
        fVar.fnf.setAntiAlias(true);
        fVar.fng.setAntiAlias(true);
        fVar.fnf.setStrokeWidth((float) f.lP(1));
        fVar.fng.setStrokeWidth((float) f.lP(1));
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.fmO.length()) {
                break;
            }
            JSONObject optJSONObject = this.fmO.optJSONObject(i2);
            if (optJSONObject != null) {
                try {
                    e eVar = this.fmQ;
                    f fVar2 = this.fmP;
                    String optString = optJSONObject.optString("method");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("data");
                    com.tencent.mm.plugin.appbrand.canvas.a.d dVar = (com.tencent.mm.plugin.appbrand.canvas.a.d) eVar.fne.get(optString);
                    if (dVar != null) {
                        dVar.a(fVar2, canvas, optJSONArray);
                    }
                } catch (Exception e) {
                    x.e("MicroMsg.DrawActionDelegateImpl", "drawAction error, exception : %s", new Object[]{e});
                }
            }
            i = i2 + 1;
        }
        if (j != 0) {
            c.aZ(sessionId, "after_draw_actions");
            c.print(sessionId);
            nanoTime = System.nanoTime();
            this.fmY = (nanoTime - nanoTime2) + this.fmY;
            this.fmX = (nanoTime - j) + this.fmX;
            this.mCount++;
        }
        nanoTime = this.fmZ;
        j = System.currentTimeMillis();
        if (nanoTime != 0) {
            com.tencent.mm.plugin.appbrand.collector.f.bO(j - nanoTime);
        }
        if (!this.fmT) {
            this.fmZ = j;
        }
        return true;
    }

    public final void adk() {
    }

    public final void a(JSONArray jSONArray, a.a aVar) {
        this.fmR.m(new 3(this, jSONArray, aVar));
    }

    public final void b(JSONArray jSONArray, a.a aVar) {
        if (jSONArray != null && jSONArray.length() != 0) {
            this.fmR.m(new 4(this, jSONArray, aVar));
        }
    }

    public final void adl() {
        this.fmR.m(new 5(this));
    }

    public final void setId(String str) {
        this.fmP.doU = str;
    }

    public final int getType() {
        return this.fmR.getType();
    }

    public final void onPause() {
        this.fmW = 0;
        this.fmR.m(this.fmU);
    }

    public final void onResume() {
        this.fmR.m(this.fmV);
    }

    public final void m(Runnable runnable) {
        if (!equals(this.fmR)) {
            this.fmR.m(runnable);
        }
    }

    public final boolean isPaused() {
        return this.fmT;
    }

    public final String getSessionId() {
        return this.fmS;
    }

    public final void setSessionId(String str) {
        this.fmS = str;
    }

    public final int getDrawActionCostTimeReportId() {
        if (equals(this.fmR)) {
            return 0;
        }
        return this.fmR.getDrawActionCostTimeReportId();
    }

    public final int getDrawCostTimeReportId() {
        if (equals(this.fmR)) {
            return 0;
        }
        return this.fmR.getDrawCostTimeReportId();
    }

    public final void setStartTime(long j) {
        this.fmW = j;
    }

    public final void adm() {
        int i = this.mCount;
        long j = this.fmY;
        long j2 = this.fmX;
        if (i > 0 && j > 0 && j2 > 0) {
            int drawActionCostTimeReportId = this.fmR.getDrawActionCostTimeReportId();
            long j3 = j / ((long) i);
            int i2 = j3 <= 500000 ? 0 : j3 <= 1000000 ? 1 : j3 <= 2000000 ? 2 : j3 <= 3000000 ? 3 : j3 <= 4000000 ? 4 : j3 <= 5000000 ? 5 : 6;
            h.mEJ.a((long) drawActionCostTimeReportId, (long) i2, 1, false);
            drawActionCostTimeReportId = this.fmR.getDrawCostTimeReportId();
            j3 = j2 / ((long) i);
            i2 = j3 <= 20000000 ? 0 : j3 <= 25000000 ? 1 : j3 <= 30000000 ? 2 : j3 <= 35000000 ? 3 : j3 <= 40000000 ? 4 : j3 <= 50000000 ? 5 : j3 <= 60000000 ? 6 : j3 <= 70000000 ? 7 : j3 <= 80000000 ? 8 : 9;
            h.mEJ.a((long) drawActionCostTimeReportId, (long) i2, 1, false);
            int type = getType();
            if (j > 0 && j2 > 0 && i > 0) {
                ArrayList arrayList = new ArrayList();
                IDKey iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 3 : 0);
                iDKey.SetValue(j);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 4 : 1);
                iDKey.SetValue(j2);
                arrayList.add(iDKey);
                iDKey = new IDKey();
                iDKey.SetID(703);
                iDKey.SetKey(type == 1 ? 5 : 2);
                iDKey.SetValue((long) i);
                arrayList.add(iDKey);
                h.mEJ.b(arrayList, false);
            }
        }
    }

    public final f getDrawContext() {
        return this.fmP;
    }
}
