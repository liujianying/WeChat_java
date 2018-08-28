package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

class d$b {
    String bPL;
    boolean eeJ;
    String iow;
    final /* synthetic */ d pOF;
    long pOO;
    long pOP;
    private String pOQ;
    int scene;
    int type;

    private d$b(d dVar) {
        this.pOF = dVar;
        this.eeJ = false;
        this.pOQ = null;
    }

    /* synthetic */ d$b(d dVar, byte b) {
        this(dVar);
    }

    final boolean isAvailable() {
        if (this.eeJ || bi.oW(this.bPL) || (System.currentTimeMillis() / 1000) - this.pOP > this.pOO) {
            return false;
        }
        return true;
    }

    final String bTH() {
        if (this.pOQ == null) {
            this.pOQ = "";
            try {
                JSONArray optJSONArray = new JSONObject(this.bPL).optJSONObject("data").optJSONObject("hotwords").optJSONArray("items");
                Iterable arrayList = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(Uri.encode(optJSONArray.optJSONObject(i).optString("hotword")));
                }
                this.pOQ = TextUtils.join("|", arrayList);
            } catch (Exception e) {
            }
        }
        return this.pOQ;
    }

    final void ei(int i, int i2) {
        asj asj = new asj();
        au.HU();
        String Ge = c.Ge();
        String p = d.p(i, i2, false);
        if (!p.equals(d.p(i, i2, true))) {
            this.eeJ = true;
        }
        File file = new File(Ge, p);
        byte[] e = e.e(file.getAbsolutePath(), 0, (int) file.length());
        if (e != null) {
            try {
                asj.aG(e);
                this.scene = asj.scene;
                this.bPL = asj.rjK;
                this.pOO = asj.rUE;
                this.pOP = asj.rUF;
                this.iow = asj.rlo;
                this.type = asj.hcE;
                x.i("MicroMsg.FTS.FTSWebViewLogic", "load bizCacheFile %s %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(e.length)});
            } catch (IOException e2) {
            }
        }
    }
}
