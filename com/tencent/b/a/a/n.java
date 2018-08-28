package com.tencent.b.a.a;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public final class n implements Runnable {
    public static long bvM = -1;
    private a bvK = null;
    int bvL = 0;
    private Context mContext = null;
    private int mType = 0;

    public n(Context context, int i) {
        this.mContext = context;
        this.mType = i;
    }

    private void tS() {
        g z = r.aH(this.mContext).z(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1)})));
        g z2 = r.aH(this.mContext).z(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(2)})));
        g z3 = r.aH(this.mContext).z(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(4)})));
        if (!s.b(z, z2) || !s.b(z, z3)) {
            z = s.a(s.a(z, z2), s.a(z, z3));
            new StringBuilder("local mid check failed, redress with mid:").append(z.toString());
            r.aH(this.mContext).b(z);
        }
    }

    private void c(JSONObject jSONObject) {
        if (i.bvA != null && j.bvG != 1) {
            if (j.bvH <= 0 || this.bvL <= j.bvH) {
                i.bvA.cg("[" + new m(this.mContext, jSONObject).tR().toString() + "]");
                bvM = System.currentTimeMillis();
                this.bvL++;
                return;
            }
            new StringBuilder("limit dispatch:").append(j.bvH);
        }
    }

    public final void run() {
        new StringBuilder("request type:").append(this.mType);
        switch (this.mType) {
            case 1:
                c(null);
                return;
            case 2:
                if (this.bvK == null) {
                    this.bvK = r.aH(this.mContext).tU();
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (i.bvB <= 0) {
                    i.bvB = PreferenceManager.getDefaultSharedPreferences(this.mContext).getLong("__MID_LAST_CHECK_TIME__", 0);
                }
                long abs = Math.abs(currentTimeMillis - i.bvB);
                new StringBuilder("check entity: ").append(this.bvK.toString()).append(",duration:").append(abs);
                if (this.bvK.bvc < 0 || this.bvK.bvc > 100) {
                    this.bvK.bvc = 3;
                }
                long j = ((long) this.bvK.bvc) * e.bvv;
                new StringBuilder("duration:").append(abs).append(",maxCheckDays:").append(j).append(",mLastCheckTime:").append(i.bvB).append(",mCheckEntity:").append(this.bvK);
                if (abs >= j) {
                    tS();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("dur", abs);
                        jSONObject.put("md", j);
                        jSONObject.put("lct", i.bvB);
                        jSONObject.put("cur", currentTimeMillis);
                    } catch (JSONException e) {
                    }
                    if (bvM <= 0) {
                        c(jSONObject);
                        return;
                    }
                    return;
                } else if (abs > e.bvv) {
                    tS();
                    return;
                } else {
                    return;
                }
            default:
                new StringBuilder("wrong type:").append(this.mType);
                return;
        }
    }
}
