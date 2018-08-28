package com.tencent.mm.plugin.topstory.ui.webview;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.topstory.ui.PluginTopStoryUI;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements e {
    public com.tencent.mm.plugin.topstory.ui.home.a oCq;
    private boolean oCr;
    public b oCs;
    public byte[] oCt;
    byte[] oCu;
    byte[] oCv;
    private com.tencent.mm.plugin.topstory.a.c.a oyF;

    private class a implements Runnable {
        public String oCx;

        private a() {
        }

        public /* synthetic */ a(b bVar, byte b) {
            this();
        }

        public final void run() {
            int i = 0;
            long currentTimeMillis = System.currentTimeMillis();
            b.this.oCt = FileOp.e("/data/data/com.tencent.mm/files/public/fts_browse/res/app.html", 0, -1);
            b.this.oCu = FileOp.e("/data/data/com.tencent.mm/files/public/fts_browse/res/dist/build.js", 0, -1);
            b.this.oCv = FileOp.e("/data/data/com.tencent.mm/files/public/fts_browse/res/dist/style.css", 0, -1);
            if (!bi.oW(this.oCx)) {
                b bVar = b.this;
                String str = this.oCx;
                if (bVar.oCt != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("json", str);
                        jSONObject.put("newQuery", false);
                        jSONObject.put("isCache", true);
                    } catch (Exception e) {
                    }
                    bVar.oCt = new String(bVar.oCt).replace("'###preloadObjFeedsData###'", jSONObject.toString() + "\n").getBytes();
                    x.i("MicroMsg.TopStory.TopStoryWebData", "attachDataToHtml");
                }
            }
            String str2 = "MicroMsg.TopStory.TopStoryWebData";
            String str3 = "loadHtmlDataFromSdcard totalLength: %d usetime: %d attachJsonData %d";
            Object[] objArr = new Object[3];
            objArr[0] = Long.valueOf((aM(b.this.oCt) + aM(b.this.oCu)) + aM(b.this.oCv));
            objArr[1] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            if (!bi.oW(this.oCx)) {
                i = this.oCx.length();
            }
            objArr[2] = Integer.valueOf(i);
            x.i(str2, str3, objArr);
        }

        private static long aM(byte[] bArr) {
            return bArr == null ? 0 : (long) bArr.length;
        }
    }

    private class b {
        long hnN;
        String oCy;
        bte oCz;

        private b() {
        }

        /* synthetic */ b(b bVar, byte b) {
            this();
        }
    }

    public final void a(bte bte, boolean z) {
        if (this.oyF == null || !bte.bJK.equals(this.oyF.ccA.bJK)) {
            this.oyF = new com.tencent.mm.plugin.topstory.a.c.a(bte);
            g.DF().a(1943, this);
            g.DF().a(this.oyF, 0);
            this.oCr = z;
            x.i("MicroMsg.TopStory.TopStoryWebData", "Start new net scene");
            return;
        }
        this.oCr = z;
        x.i("MicroMsg.TopStory.TopStoryWebData", "Wait current net scene");
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.equals(this.oyF)) {
            g.DF().b(1943, this);
            this.oyF = null;
            com.tencent.mm.plugin.topstory.a.c.a aVar = (com.tencent.mm.plugin.topstory.a.c.a) lVar;
            if (i == 0 && i2 == 0) {
                String str2 = aVar.bHD().rjK;
                a(aVar.ccA, str2, false);
                if (((PluginTopStoryUI) g.n(PluginTopStoryUI.class)).getTopStoryCommand().ozs) {
                    com.tencent.mm.sdk.f.e.post(new 1(this, str2), "SaveLastRequestResult");
                    return;
                }
                return;
            }
            x.i("MicroMsg.TopStory.TopStoryWebData", "netscene topstory error");
            a(aVar.ccA, bIF(), true);
        }
    }

    private void a(bte bte, String str, boolean z) {
        if (this.oCr) {
            if (this.oCq != null) {
                this.oCq.Ot(str);
            }
            this.oCr = false;
        } else if (z) {
            this.oCs = null;
        } else {
            this.oCs = new b(this, (byte) 0);
            this.oCs.oCz = bte;
            this.oCs.hnN = System.currentTimeMillis();
            this.oCs.oCy = str;
        }
    }

    private static String bIF() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ret", -1);
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }
}
