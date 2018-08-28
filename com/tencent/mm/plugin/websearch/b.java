package com.tencent.mm.plugin.websearch;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.f;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements f {

    /* renamed from: com.tencent.mm.plugin.websearch.b$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int bpX = 0;
        final /* synthetic */ String dEt;
        final /* synthetic */ int eeg;
        final /* synthetic */ String fwt;
        final /* synthetic */ String jxq;
        final /* synthetic */ boolean pKA = true;
        final /* synthetic */ boolean pKB;
        final /* synthetic */ boolean pKC;
        final /* synthetic */ int pKD;
        final /* synthetic */ Map pKz;
        final /* synthetic */ Context val$context;

        AnonymousClass1(Map map, String str, int i, String str2, boolean z, String str3, boolean z2, boolean z3, int i2, Context context) {
            this.pKz = map;
            this.jxq = str;
            this.eeg = i;
            this.fwt = str2;
            this.dEt = str3;
            this.pKB = z2;
            this.pKC = z3;
            this.pKD = i2;
            this.val$context = context;
        }

        public final void run() {
            boolean z = false;
            if (p.zO(0)) {
                JSONObject jSONObject = new JSONObject();
                if (this.pKz != null) {
                    try {
                        jSONObject.put("parentSearchID", "0:" + ((String) this.pKz.get("sugId")) + ":" + this.jxq + ":");
                    } catch (JSONException e) {
                        x.k("StartWebSearchService", "", new Object[]{e});
                    }
                }
                String valueOf = String.valueOf(System.currentTimeMillis());
                String zK = p.zK(this.eeg);
                p.a(valueOf, this.fwt, zK, this.jxq, this.eeg);
                kx kxVar = new kx();
                kxVar.bVh.scene = 0;
                a.sFg.m(kxVar);
                Map a = p.a(this.eeg, this.pKA, 0, Uri.encode(jSONObject.toString()), "", this.fwt, this.jxq, "", zK, "", valueOf);
                if (this.pKz != null) {
                    a.putAll(this.pKz);
                }
                try {
                    a.put("query", com.tencent.mm.compatible.util.p.encode(this.jxq, "UTF-8"));
                } catch (Exception e2) {
                    a.put("query", this.jxq);
                }
                a.put("sessionId", this.fwt);
                String v = p.v(a);
                Intent adR = p.adR();
                adR.putExtra("ftsType", this.bpX);
                adR.putExtra("title", this.dEt);
                adR.putExtra("ftsbizscene", this.eeg);
                adR.putExtra("ftsQuery", this.jxq);
                String str = "ftsInitToSearch";
                if (!TextUtils.isEmpty(this.jxq) || this.pKB) {
                    z = true;
                }
                adR.putExtra(str, z);
                adR.putExtra("sessionId", this.fwt);
                adR.putExtra("subSessionId", zK);
                adR.putExtra("rawUrl", v);
                adR.putExtra("key_preload_biz", b.zH(this.eeg));
                if (this.pKC) {
                    adR.putExtra("status_bar_style", "black");
                }
                if (this.pKD != Integer.MAX_VALUE) {
                    adR.putExtra("customize_status_bar_color", this.pKD);
                }
                adR.putExtra("key_load_js_without_delay", true);
                d.b(this.val$context, "webview", ".ui.tools.fts.FTSSOSHomeWebViewUI", adR);
                b.zI(this.eeg);
                return;
            }
            x.e("StartWebSearchService", "fts h5 template not avail");
        }
    }

    static /* synthetic */ int zH(int i) {
        switch (i) {
            case 20:
                return 1;
            default:
                return 4;
        }
    }

    static /* synthetic */ void zI(int i) {
        switch (i) {
            case 20:
                p.fA(1000);
                return;
            default:
                p.fz(1000);
                return;
        }
    }

    public static void bSD() {
        p.fz(5000);
    }

    public final void b(Context context, int i, String str, String str2) {
        a(context, i, str, str2, null, "");
    }

    public final void a(Context context, String str, String str2, Map<String, String> map) {
        a(context, 36, str, str2, map, false, Integer.MAX_VALUE, "", true);
    }

    public final void a(Context context, int i, String str, String str2, Map<String, String> map, String str3) {
        a(context, i, str, str2, map, false, Integer.MAX_VALUE, str3);
    }

    public final void b(Context context, String str, String str2, Map<String, String> map) {
        a(context, 3, str, str2, map, true, -1, "");
    }

    private void a(Context context, int i, String str, String str2, Map<String, String> map, boolean z, int i2, String str3) {
        a(context, i, str, str2, map, z, i2, str3, false);
    }

    private void a(Context context, int i, String str, String str2, Map<String, String> map, boolean z, int i2, String str3, boolean z2) {
        ((i) g.l(i.class)).a(context, new AnonymousClass1(map, str, i, str2, true, str3, z2, z, i2, context));
    }
}
