package com.tencent.mm.plugin.appbrand.game.c;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONArray;
import org.json.JSONObject;

public class d {
    private static volatile d fBq;
    public c fBo;
    public b fBp;
    private c fBr = new c((byte) 0);
    public Context mContext;
    public volatile int mState = 0;

    public static d ags() {
        if (fBq == null) {
            synchronized (d.class) {
                if (fBq == null) {
                    fBq = new d();
                }
            }
        }
        return fBq;
    }

    public static void release() {
        if (fBq != null) {
            synchronized (d.class) {
                if (fBq != null) {
                    fBq.mState = 2;
                    fBq.fBr.fDo.clear();
                    fBq = null;
                }
            }
        }
    }

    private d() {
    }

    public final void sU(String str) {
        if (this.mState == 1 && this.fBp != null) {
            this.fBp.post(new 1(this, str));
        }
    }

    public final void G(int i, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("level", i);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("wxClient: " + str);
            jSONObject.put("logs", jSONArray);
            sU(jSONObject.toString());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GameInspector", e, "hy: vConsole json error", new Object[0]);
        }
    }
}
