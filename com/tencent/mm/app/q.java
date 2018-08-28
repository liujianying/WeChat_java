package com.tencent.mm.app;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.tencent.mm.f.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.splash.b;
import com.tencent.mm.splash.c;
import com.tencent.mm.splash.e;
import com.tencent.mm.splash.m;
import com.tencent.mm.xlog.app.XLogSetup;

public final class q {
    public static h bzn;

    public static void a(h hVar, String str) {
        bzn = hVar;
        com.tencent.mm.splash.h.a(new c() {
            public final void e(Activity activity) {
                if (q.bzn != null && q.bzn.ES()) {
                    SharedPreferences sharedPreferences = activity.getSharedPreferences("system_config_prefs", 4);
                    if (sharedPreferences.getBoolean("first_launch_weixin", true)) {
                        sharedPreferences.edit().putBoolean("first_launch_weixin", false).commit();
                        XLogSetup.realSetupXlog();
                    }
                }
            }

            public final void a(Throwable th, String str) {
                x.printErrStackTrace("WxSplash.WeChatSplash", th, str, new Object[0]);
                if (str == null) {
                    str = "";
                }
                com.tencent.mm.splash.h.ckd().sNz.add(str + "  " + Log.getStackTraceString(th));
            }

            public final void b(String str, String str2, Object... objArr) {
                x.i(str, str2, objArr);
            }
        });
        com.tencent.mm.splash.h.a(new b() {
            public final boolean aY(Context context) {
                return a.bh(context);
            }

            public final boolean aZ(Context context) {
                return a.aZ(context);
            }

            public final void ba(Context context) {
                a.ba(context);
            }
        });
        com.tencent.mm.splash.h.a(new e() {
            public final void vh() {
                com.tencent.mm.blink.a.vh();
            }

            public final void cR(String str) {
                com.tencent.mm.blink.a.cR(str);
            }

            public final void vi() {
                com.tencent.mm.blink.a.fm(1);
            }
        });
        if (str == null) {
            x.i("WxSplash.WeChatSplash", "splash callback class is null, return.");
            return;
        }
        com.tencent.mm.blink.a.aD(b.bya);
        com.tencent.mm.splash.h.XB(ad.chW());
        com.tencent.mm.splash.h.J(WeChatSplashActivity.class);
        com.tencent.mm.splash.h.K(WeChatSplashFallbackActivity.class);
        m.a(hVar.dsQ, hVar.dox, str);
    }
}
