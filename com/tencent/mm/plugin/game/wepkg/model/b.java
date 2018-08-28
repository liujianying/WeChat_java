package com.tencent.mm.plugin.game.wepkg.model;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class b {
    private static b keL = null;

    static /* synthetic */ void a(b bVar, final String str) {
        if (!bi.oW(str)) {
            Parcelable bundle = new Bundle(1);
            bundle.putString("call_pkg_id", str);
            f.a("com.tencent.mm:tools", bundle, a.class, new c<Bundle>() {
                public final /* synthetic */ void at(Object obj) {
                    Bundle bundle = (Bundle) obj;
                    if (bundle != null) {
                        d.Em().H(new 1(this, bundle.getString("used_wepkg_version")));
                    }
                }
            });
        }
    }

    public static synchronized b aVv() {
        b bVar;
        synchronized (b.class) {
            if (keL == null) {
                synchronized (b.class) {
                    if (keL == null) {
                        keL = new b();
                    }
                }
            }
            bVar = keL;
        }
        return bVar;
    }

    public final synchronized void aVw() {
        boolean z = true;
        synchronized (this) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("we_pkg_sp", 0);
            if (System.currentTimeMillis() - sharedPreferences.getLong("clean_wepkg_time", 0) <= 86400000) {
                z = false;
            }
            x.i("MicroMsg.Wepkg.CleanWepkgMgr", "clean wepkg, allowClean:%b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                sharedPreferences.edit().putLong("clean_wepkg_time", System.currentTimeMillis()).commit();
                e.post(new 1(this), "clean_wepkg");
            }
        }
    }
}
