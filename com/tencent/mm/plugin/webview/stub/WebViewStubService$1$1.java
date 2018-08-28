package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.a$i;
import com.tencent.mm.R;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.f;
import com.tencent.mm.ac.k;
import com.tencent.mm.ac.z;
import com.tencent.mm.g.a.km;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.webview.a.a;
import com.tencent.mm.plugin.webview.stub.WebViewStubService.1;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map;

class WebViewStubService$1$1 implements Runnable {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ int pUS;
    final /* synthetic */ int pUT;
    final /* synthetic */ 1 pUU;

    WebViewStubService$1$1(1 1, int i, Bundle bundle, int i2) {
        this.pUU = 1;
        this.pUS = i;
        this.bAE = bundle;
        this.pUT = i2;
    }

    public final void run() {
        int i;
        int i2;
        Intent intent;
        String str;
        Bundle bundle;
        switch (this.pUS) {
            case 1:
                WebViewStubService.a(this.pUU.pUR, 2, this.bAE, this.pUT);
                return;
            case 2:
                s.gH(this.pUU.pUR);
                return;
            case 3:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("stat_scene", 4);
                g Bh = h.Bh(this.pUT);
                if (Bh != null) {
                    bundle2.putString("stat_url", Bh.getCurrentUrl());
                }
                1.a(this.pUU, this.bAE, bundle2);
                return;
            case 4:
                WebViewStubService.a(this.pUU.pUR, 3, this.bAE, this.pUT);
                return;
            case 5:
                i = this.bAE.getInt("scene_end_type", 0);
                i2 = this.bAE.getInt("scene_end_listener_hash_code", -1);
                if (i2 != -1) {
                    WebViewStubService.a(this.pUU.pUR).add(Integer.valueOf(i2));
                }
                x.i("MicroMsg.WebViewStubService", "add Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_inc_count[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.a(this.pUU.pUR).size()), Integer.valueOf(WebViewStubService.b(this.pUU.pUR))});
                if (i > 0) {
                    WebViewStubService.c(this.pUU.pUR);
                    x.i("MicroMsg.WebViewStubService", "real add Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                    au.DF().a(233, this.pUU.pUR);
                    au.DF().a(673, this.pUU.pUR);
                    au.DF().a(666, this.pUU.pUR);
                    au.DF().a(1254, this.pUU.pUR);
                    au.DF().a(1373, this.pUU.pUR);
                    return;
                }
                return;
            case 6:
                i = this.bAE.getInt("scene_end_type", 0);
                i2 = this.bAE.getInt("scene_end_listener_hash_code", -1);
                if (i2 != -1) {
                    WebViewStubService.a(this.pUU.pUR).remove(Integer.valueOf(i2));
                }
                x.i("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set_size:[%d], before_dec_count:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.a(this.pUU.pUR).size()), Integer.valueOf(WebViewStubService.b(this.pUU.pUR))});
                if (i > 0) {
                    WebViewStubService.d(this.pUU.pUR);
                    if (WebViewStubService.b(this.pUU.pUR) < 0) {
                        x.e("MicroMsg.WebViewStubService", "remove Scene end, type:[%d] hashCode:[%d], set size:[%d], unexpected_count[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(WebViewStubService.a(this.pUU.pUR).size()), Integer.valueOf(WebViewStubService.b(this.pUU.pUR))});
                        WebViewStubService.e(this.pUU.pUR);
                    }
                    if (WebViewStubService.b(this.pUU.pUR) <= 0 && WebViewStubService.a(this.pUU.pUR).size() <= 0) {
                        x.i("MicroMsg.WebViewStubService", "real remove Scene end, hashCode:[%d]", new Object[]{Integer.valueOf(i2)});
                        if (au.HX()) {
                            au.DF().b(233, this.pUU.pUR);
                            au.DF().b(673, this.pUU.pUR);
                            au.DF().b(666, this.pUU.pUR);
                            au.DF().b(1254, this.pUU.pUR);
                            au.DF().b(1373, this.pUU.pUR);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 7:
                intent = new Intent();
                intent.putExtra("MMActivity.OverrideEnterAnimation", 0);
                intent.putExtra("MMActivity.OverrideExitAnimation", R.a.push_down_out);
                intent.addFlags(268435456);
                a.ezn.s(intent, this.pUU.pUR);
                return;
            case 8:
                intent = new Intent();
                intent.putExtras(this.bAE);
                intent.addFlags(268435456);
                a.ezn.t(intent, this.pUU.pUR);
                return;
            case 20:
                this.bAE.setClassLoader(getClass().getClassLoader());
                h.Bh(this.pUT).qhS = this.bAE.getBundle("jsapiargs");
                str = (String) this.bAE.getCharSequence("bizofstartfrom");
                bundle = this.bAE.getBundle("startwebviewparams");
                if (!(str == null || bundle == null)) {
                    km kmVar = new km();
                    kmVar.bUM.bUN = str;
                    kmVar.bUM.bUO = bundle;
                    com.tencent.mm.sdk.b.a.sFg.m(kmVar);
                }
                WebViewStubService.a(this.pUU.pUR, this.bAE.getInt("screen_orientation", -1));
                return;
            case 21:
                h.Bh(this.pUT).bYa().putAll(this.bAE);
                return;
            case a$i.AppCompatTheme_actionModeBackground /*29*/:
                str = this.bAE.getString("srcUsername");
                z.MY();
                e.kE(str);
                z.MY();
                e.kF(str);
                z.Nj();
                if (!bi.oW(str) && f.kN(str)) {
                    z.Nj().b(str, null);
                    return;
                }
                return;
            case 30:
                str = this.bAE.getString("srcUsername");
                z.MY();
                e.kG(str);
                z.Nj();
                if (!bi.oW(str) && f.kN(str)) {
                    z.Nj();
                    k.kS(str);
                    return;
                }
                return;
            case 41:
                if (au.HX()) {
                    g Bh2 = h.Bh(this.pUT);
                    bundle = this.bAE;
                    if (Bh2.qiF != null) {
                        if (bundle == null || bundle.size() <= 0) {
                            Bh2.a(Bh2.pRY, Bh2.qiF, "showKeyboard:fail", null, true, true);
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put("text", bi.oV(bundle.getString("show_kb_input_callback_text")));
                            Bh2.a(Bh2.pRY, Bh2.qiF, "showKeyboard:ok", hashMap, true, true);
                        }
                        Bh2.qiF = null;
                        return;
                    }
                    return;
                }
                return;
            default:
                x.e("MicroMsg.WebViewStubService", "not support action code:[%d]", new Object[]{Integer.valueOf(this.pUS)});
                return;
        }
    }
}
