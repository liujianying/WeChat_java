package com.tencent.mm.plugin.appbrand.ui.recents;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.appusage.k;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.c;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;

final class j extends c<Object> {
    j(ArrayList<?> arrayList, ArrayList<?> arrayList2) {
        super(arrayList, arrayList2);
    }

    public final boolean bV(int i, int i2) {
        if (!this.guO.get(i).getClass().equals(this.guP.get(i2).getClass())) {
            return false;
        }
        if (!(this.guO.get(i) instanceof k)) {
            return false;
        }
        k kVar = (k) this.guO.get(i);
        k kVar2 = (k) this.guP.get(i2);
        return kVar.fig == kVar2.fig && kVar.bGy.equals(kVar2.bGy);
    }

    public final boolean bW(int i, int i2) {
        if (!(this.guO.get(i) instanceof k)) {
            return false;
        }
        k kVar = (k) this.guO.get(i);
        k kVar2 = (k) this.guP.get(i2);
        if (bi.oV(kVar.appId).equals(kVar2.appId) && kVar.bGy.equals(kVar2.bGy) && kVar.fig == kVar2.fig && kVar.fmd == kVar2.fmd && bi.oV(kVar.fmb).equals(kVar2.fmb) && bi.oV(kVar.appName).equals(kVar2.appName)) {
            return true;
        }
        return false;
    }

    public final Object bX(int i, int i2) {
        if (i >= this.guO.size()) {
            return null;
        }
        Bundle bundle = new Bundle();
        if (this.guO.get(i) instanceof k) {
            k kVar = (k) this.guO.get(i);
            k kVar2 = (k) this.guP.get(i2);
            if (kVar.fmc != kVar2.fmc) {
                bundle.putLong("running_flag", kVar2.fmc);
            }
            if (kVar.fmd != kVar2.fmd) {
                bundle.putBoolean("star", kVar2.fmd);
            }
            if (kVar.fig != kVar2.fig) {
                bundle.putInt("debug_type", kVar2.fig);
            }
            if (!bi.oV(kVar.fmb).equals(kVar2.fmb)) {
                bundle.putString("icon", kVar2.fmb);
            }
            if (!bi.oV(kVar.appName).equals(kVar2.appName)) {
                bundle.putString("nick_name", kVar2.appName);
            }
        }
        return bundle.size() <= 0 ? null : bundle;
    }
}
