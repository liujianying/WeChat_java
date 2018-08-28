package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.widget.FrameLayout;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.task.AppBrandRemoteTaskController.c;
import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import com.tencent.mm.plugin.appbrand.ui.f;
import com.tencent.mm.plugin.appbrand.ui.m;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class h<_ActivityContext extends MMActivity & m> implements q {
    FrameLayout fcA;
    private _ActivityContext fcq;
    public LinkedList<g> fdn = new LinkedList();
    HashMap<String, g> fdo = new HashMap();
    private c fdp;

    public h(_ActivityContext _activitycontext, c cVar, FrameLayout frameLayout) {
        this.fcq = _activitycontext;
        this.fcA = frameLayout;
        this.fdp = cVar;
    }

    public final void a(g gVar, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        if (appBrandInitConfig != null && appBrandStatObject != null) {
            if (gVar == null) {
                Iterator it = this.fdn.iterator();
                while (it.hasNext()) {
                    g gVar2 = (g) it.next();
                    gVar2.fcA.setVisibility(8);
                    this.fdo.put(gVar2.mAppId, gVar2);
                    gVar2.fcL.fjj.jG(12);
                }
                this.fdn.clear();
            }
            if (qp(appBrandInitConfig.appId) == null) {
                b(gVar, appBrandInitConfig, appBrandStatObject);
            } else {
                this.fcq.runOnUiThread(new 2(this, gVar, appBrandInitConfig, appBrandStatObject));
            }
        }
    }

    final void b(final g gVar, final AppBrandInitConfig appBrandInitConfig, final AppBrandStatObject appBrandStatObject) {
        if (ah.isMainThread()) {
            g gVar2;
            if (appBrandInitConfig.aaq()) {
                x.i("MicroMsg.AppBrandRuntimeContainer", "cleanup by game, ugly");
                cleanup();
            } else {
                Iterator it = this.fdn.iterator();
                while (it.hasNext()) {
                    gVar2 = (g) it.next();
                    if (gVar2.aaq()) {
                        break;
                    }
                }
                for (g gVar22 : this.fdo.values()) {
                    if (gVar22.aaq()) {
                        break;
                    }
                }
                gVar22 = null;
                f(gVar22);
            }
            if (gVar != null) {
                gVar.onPause();
            }
            gVar22 = new g(this.fcq, this);
            gVar22.a(appBrandInitConfig, appBrandStatObject);
            gVar22.fcs = gVar;
            gVar22.aak();
            this.fdn.push(gVar22);
            this.fcA.addView(gVar22.fcA);
            if (gVar != null) {
                f.a(gVar22, gVar, null);
                return;
            }
            return;
        }
        this.fcq.runOnUiThread(new Runnable() {
            public final void run() {
                h.this.b(gVar, appBrandInitConfig, appBrandStatObject);
            }
        });
    }

    public final void close() {
        if (!(aaA() == null || aaA().aan() == 1060 || aaA().fcu == null || !aaA().fcu.fqN || !aaA().dti)) {
            ((d) g.l(d.class)).cN(this.fcq);
            aaA().fcu.fqN = false;
        }
        if (((m) this.fcq).anD()) {
            this.fcq.moveTaskToBack(true);
        } else {
            this.fcq.finish();
        }
    }

    public final void a(MiniProgramNavigationBackResult miniProgramNavigationBackResult) {
        if (miniProgramNavigationBackResult != null && (this.fcq instanceof AppBrandEmbedUI)) {
            Intent intent = new Intent();
            intent.putExtra("result_key_mini_program_navigate_back_result", miniProgramNavigationBackResult);
            this.fcq.setResult(-1, intent);
        }
        this.fcq.finish();
    }

    public final g aaA() {
        return (g) this.fdn.peek();
    }

    public final g d(g gVar) {
        int indexOf = this.fdn.indexOf(gVar);
        int size = this.fdn.size() - 1;
        if (indexOf == -1 || indexOf >= size) {
            return null;
        }
        return (g) this.fdn.get(indexOf + 1);
    }

    public final void a(AppBrandInitConfig appBrandInitConfig, MiniProgramNavigationBackResult miniProgramNavigationBackResult, g gVar) {
        String str = null;
        AppBrandLaunchReferrer appBrandLaunchReferrer = new AppBrandLaunchReferrer();
        appBrandLaunchReferrer.appId = appBrandInitConfig.appId;
        appBrandLaunchReferrer.fqE = 3;
        appBrandLaunchReferrer.fqF = miniProgramNavigationBackResult == null ? null : miniProgramNavigationBackResult.fei.toString();
        if (miniProgramNavigationBackResult != null) {
            str = miniProgramNavigationBackResult.fej.toString();
        }
        appBrandLaunchReferrer.fqG = str;
        gVar.fct.fqA.a(appBrandLaunchReferrer);
        AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
        appBrandStatObject.scene = 1038;
        appBrandStatObject.bGG = appBrandInitConfig.appId + ':' + appBrandInitConfig.fdE + ':' + (appBrandInitConfig.bGM + 1000);
        gVar.fct.aea();
        gVar.a(appBrandStatObject);
    }

    public final int aaB() {
        return this.fdn.size();
    }

    public final boolean e(g gVar) {
        return this.fdn.contains(gVar);
    }

    final g qp(String str) {
        Iterator it = this.fdn.iterator();
        while (it.hasNext()) {
            g gVar = (g) it.next();
            if (gVar.mAppId.equals(str)) {
                return gVar;
            }
        }
        return (g) this.fdo.get(str);
    }

    public final void f(g gVar) {
        this.fcq.runOnUiThread(new 4(this, gVar));
    }

    public final void cleanup() {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(this.fdn);
        linkedList.addAll(this.fdo.values());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            f((g) it.next());
        }
        x.i("MicroMsg.AppBrandRuntimeContainer", "cleanup");
    }

    public final c aaC() {
        return this.fdp;
    }
}
