package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.a.g;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable$Columns;
import java.util.Map;

public final class a implements e {
    a pNC = new a(this, (byte) 0);
    private c pND = new 1(this);

    private class a {
        boolean bLW;
        boolean bgH;
        private b pNF;
        private String pNG;
        private long pNH;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void a(int i, String str, String str2, int i2, long j) {
            String str3;
            if (bi.oW(str)) {
                String str4 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str5 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2.toString();
                }
                objArr[2] = str3;
                x.i(str4, str5, objArr);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            str3 = g.u(stringBuffer.toString().getBytes());
            if (!bi.oW(this.pNG) && this.pNG.equals(str3) && System.currentTimeMillis() - this.pNH <= 8000 && bi.oW(str2)) {
                if (this.bLW) {
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[]{str});
                    h.Bh(i2).a(this.pNF.bTD().sjt, true, ab.b(this.pNF.bTD().rHj), this.pNF.bTD().rHm);
                    return;
                } else if (this.bgH) {
                    if (this.pNF != null) {
                        this.pNF.pNI = i2;
                    }
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    return;
                } else {
                    x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[]{str, str3, Integer.valueOf(i2)});
            if (this.pNF != null) {
                au.DF().c(this.pNF);
            }
            this.pNG = str3;
            this.pNH = System.currentTimeMillis();
            this.bgH = true;
            this.bLW = false;
            au.DF().a(234, a.this);
            this.pNF = new b(i, str, str2.getBytes(), i2, j);
            au.DF().a(this.pNF, 0);
        }
    }

    public a() {
        com.tencent.mm.sdk.b.a.sFg.b(this.pND);
    }

    public final boolean W(Map<String, Object> map) {
        x.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[]{map.toString()});
        String t = t(map, "keyword");
        String t2 = t(map, "nextPageBuffer");
        int v = v(map, DownloadSettingTable$Columns.TYPE);
        int v2 = v(map, "webview_instance_id");
        String t3 = t(map, "searchID");
        this.pNC.a(v, t, t2, v2, bi.oW(t3) ? 0 : Long.valueOf(t3).longValue());
        return false;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar instanceof b) {
            au.DF().b(234, this);
            this.pNC.bgH = false;
            b bVar = (b) lVar;
            if (i == 0 && i2 == 0) {
                this.pNC.bLW = true;
            } else {
                this.pNC.bLW = false;
                h.Bh(bVar.pNI).a("{}", bVar.pNJ, "", 0);
            }
            h.Bh(bVar.pNI).a(bVar.bTD().sjt, bVar.pNJ, ab.b(bVar.bTD().rHj), bVar.bTD().rHm);
        }
    }

    public static String t(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static int v(Map<String, Object> map, String str) {
        String t = t(map, str);
        if (bi.oW(t)) {
            return 0;
        }
        return Integer.valueOf(t).intValue();
    }
}
