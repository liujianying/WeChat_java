package com.tencent.mm.plugin.game.wepkg.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.utils.b;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Set;

public class c extends com.tencent.mm.sdk.b.c<kk> {
    private static volatile String cbP;
    private static volatile long keQ;
    private static volatile long keR;
    private static Set<String> keS = new HashSet();

    private static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            Bundle bundle = (Bundle) obj;
            if (bundle != null) {
                b.kgl = bundle.getBoolean("is_wepkg_disable");
                String string = bundle.getString("call_raw_url");
                x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload entrance url:%s, isToolsProcess:%b", new Object[]{string, Boolean.valueOf(ad.cie())});
                if (WepkgMainProcessService.ajG()) {
                    x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "preload wepkg");
                    f.Eh(string);
                    if (cVar != null) {
                        cVar.at(bundle);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "prestart WepkgMainProcessService and preload wepkg");
                d.a(string, new 1(this, cVar, bundle));
            } else if (cVar != null) {
                cVar.at(bundle);
            }
        }
    }

    public c() {
        this.sFo = kk.class.getName().hashCode();
    }

    private boolean a(kk kkVar) {
        switch (kkVar.bUK.type) {
            case 0:
            case 1:
                String str = "MicroMsg.Wepkg.NotifyGameWebviewOperationListener";
                String str2 = "on NotifyGameWebviewOperationListener operation listener, type:%d, hashcode:%s, event hashcode:%s, threadId:%s, isUIThead:%s";
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(kkVar.bUK.type);
                objArr[1] = Integer.valueOf(hashCode());
                objArr[2] = Integer.valueOf(kkVar.hashCode());
                objArr[3] = Long.valueOf(Thread.currentThread().getId());
                objArr[4] = Boolean.valueOf(Thread.currentThread() == Looper.getMainLooper().getThread());
                x.i(str, str2, objArr);
                String str3 = "";
                try {
                    str3 = kkVar.bUK.intent.getStringExtra("rawUrl");
                } catch (Exception e) {
                }
                synchronized (c.class) {
                    if (!bi.oV(cbP).equalsIgnoreCase(str3)) {
                        cbP = str3;
                        keQ = System.currentTimeMillis();
                        keR = System.currentTimeMillis();
                        if (ad.cic()) {
                            b.kgl = g.AU().AG();
                        }
                        if (!d.Ex(str3)) {
                            x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "dont have pkgid or disable wepkg, normal turn page. disableWepkg:" + b.kgl);
                            b(kkVar);
                            break;
                        }
                        x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "exist pkgid:%s, to reload", new Object[]{d.Eu(str3)});
                        kkVar.bUK.group = com.tencent.mm.a.g.u(bi.oV(str3).getBytes()) + "_" + System.currentTimeMillis();
                        ah.i(new b(this, kkVar), 500);
                        Parcelable bundle = new Bundle();
                        bundle.putBoolean("is_wepkg_disable", b.kgl);
                        bundle.putString("call_raw_url", str3);
                        f.a("com.tencent.mm:tools", bundle, a.class, new 1(this, kkVar));
                        break;
                    }
                    x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "forbid to open same page two times");
                }
        }
        return false;
    }

    private synchronized void b(kk kkVar) {
        ah.i(new 2(this), 1000);
        if (kkVar != null) {
            String str;
            if (!bi.oW(kkVar.bUK.group)) {
                if (keS.contains(kkVar.bUK.group)) {
                    keS.remove(kkVar.bUK.group);
                } else {
                    keS.add(kkVar.bUK.group);
                }
            }
            Context context = kkVar.bUK.context != null ? kkVar.bUK.context : ad.getContext();
            if (kkVar.bUK.intent == null) {
                kkVar.bUK.intent = new Intent();
            }
            switch (kkVar.bUK.type) {
                case 0:
                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.game.GameWebViewUI", kkVar.bUK.intent);
                    break;
                case 1:
                    com.tencent.mm.bg.d.b(context, "webview", ".ui.tools.TransparentWebViewUI", kkVar.bUK.intent);
                    break;
            }
            x.i("MicroMsg.Wepkg.NotifyGameWebviewOperationListener", "turn to GameWebViewUI time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - keQ)});
            String str2 = "";
            try {
                str2 = kkVar.bUK.intent.getStringExtra("rawUrl");
                kkVar.bUK.context = null;
                str = str2;
            } catch (Exception e) {
                str = str2;
            }
            com.tencent.mm.plugin.game.wepkg.utils.a.b("preloadWebTime", str, d.Eu(str), null, -1, r6, null);
        }
    }
}
