package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.s;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.WxaWidgetContextImpl;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer.a;
import com.tencent.mm.plugin.appbrand.dynamic.j.a.2;
import com.tencent.mm.plugin.appbrand.dynamic.j.d;
import com.tencent.mm.sdk.platformtools.x;

class WxaWidgetInitializer$1 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ int eeg;
    final /* synthetic */ int fen;
    final /* synthetic */ int fuS;
    final /* synthetic */ int fuT;
    final /* synthetic */ String fuU;
    final /* synthetic */ a fuV;
    final /* synthetic */ String fuW;
    final /* synthetic */ String sk;

    WxaWidgetInitializer$1(String str, int i, int i2, String str2, int i3, int i4, String str3, a aVar, String str4) {
        this.sk = str;
        this.fen = i;
        this.fuS = i2;
        this.bAj = str2;
        this.fuT = i3;
        this.eeg = i4;
        this.fuU = str3;
        this.fuV = aVar;
        this.fuW = str4;
    }

    public final void run() {
        x.d("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[]{this.sk, Integer.valueOf(this.fen), Integer.valueOf(this.fuS)});
        s.i("MicroMsg.WxaWidgetInitializer", "initialize(id : %s, pkgType : %s, version : %s)", new Object[]{this.sk, Integer.valueOf(this.fen), Integer.valueOf(this.fuS)});
        d a = com.tencent.mm.plugin.appbrand.dynamic.j.a.a(this.bAj, this.fen, this.fuS, this.fuT, this.eeg, this.fuU);
        if (a == null) {
            x.e("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.sk, Integer.valueOf(this.fen), Integer.valueOf(this.fuS)});
            s.i("MicroMsg.WxaWidgetInitializer", "getLaunchWxaWidgetInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.sk, Integer.valueOf(this.fen), Integer.valueOf(this.fuS)});
            if (this.fuV != null) {
                this.fuV.a(this.sk, this.bAj, false, null);
                return;
            }
            return;
        }
        WxaPkgWrappingInfo b = com.tencent.mm.plugin.appbrand.dynamic.j.a.b(this.sk, this.bAj, this.fuW, this.fen, this.fuS);
        if (b != null) {
            WxaWidgetContextImpl a2 = WxaWidgetInitializer.a(this.sk, this.bAj, b, a);
            if (this.fuV != null) {
                this.fuV.a(this.sk, this.bAj, a2 != null, a2);
                return;
            }
            return;
        }
        x.e("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.sk, Integer.valueOf(this.fen), Integer.valueOf(this.fuS)});
        s.i("MicroMsg.WxaWidgetInitializer", "get widget PkgWrappingInfo(id : %s, pkgType : %s, version : %s) return null.", new Object[]{this.sk, Integer.valueOf(this.fen), Integer.valueOf(this.fuS)});
        if (this.fuV != null) {
            this.fuV.bf(this.sk, this.bAj);
        }
        String str = this.sk;
        String str2 = this.bAj;
        String str3 = this.fuW;
        int i = this.fen;
        1 1 = new 1(this, a);
        if (i != Integer.MIN_VALUE && com.tencent.mm.plugin.appbrand.dynamic.j.a.b(str, str2, str3, i, 0) == null) {
            Parcelable bundle = new Bundle();
            bundle.putString("id", str);
            bundle.putString("appId", str2);
            bundle.putInt("debugType", i);
            f.a("com.tencent.mm", bundle, com.tencent.mm.plugin.appbrand.dynamic.j.a.d.class, new 2(1));
        }
    }
}
