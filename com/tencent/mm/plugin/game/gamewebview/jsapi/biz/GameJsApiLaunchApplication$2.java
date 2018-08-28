package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.a$a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

class GameJsApiLaunchApplication$2 implements a {
    final /* synthetic */ String fFT;
    final /* synthetic */ Bundle fFU;
    final /* synthetic */ String fFV;
    final /* synthetic */ String fFX;
    final /* synthetic */ MMActivity gdk;
    final /* synthetic */ a$a jGK;
    final /* synthetic */ GameJsApiLaunchApplication jHc;

    GameJsApiLaunchApplication$2(GameJsApiLaunchApplication gameJsApiLaunchApplication, a$a a_a, String str, MMActivity mMActivity, Bundle bundle, String str2, String str3) {
        this.jHc = gameJsApiLaunchApplication;
        this.jGK = a_a;
        this.fFT = str;
        this.gdk = mMActivity;
        this.fFU = bundle;
        this.fFV = str2;
        this.fFX = str3;
    }

    public final void a(int i, int i2, String str, b bVar) {
        x.d("MicroMsg.GameJsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            aoh aoh = (aoh) bVar.dIE.dIL;
            switch (aoh.bMH) {
                case 0:
                    if (!bi.oW(this.fFT)) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.fFT));
                        intent.addFlags(268435456);
                        List B = bi.B(this.gdk, intent);
                        if (!(B == null || B.isEmpty())) {
                            Object b;
                            if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
                                b = g.b((ResolveInfo) B.get(0));
                            } else {
                                b = intent.getPackage();
                            }
                            if (!bi.oV(ad.getPackageName()).equals(b)) {
                                g.a(this.gdk, intent, null, aoh.rQQ, new 1(this), this.fFU);
                                return;
                            }
                        }
                    }
                    LaunchApplicationTask launchApplicationTask = new LaunchApplicationTask(this.gdk);
                    launchApplicationTask.appId = this.fFV;
                    launchApplicationTask.extInfo = this.fFX;
                    launchApplicationTask.bJx = this.fFU;
                    launchApplicationTask.showType = aoh.rQQ == 1 ? 1 : 0;
                    launchApplicationTask.fFC = new 2(this, launchApplicationTask);
                    launchApplicationTask.aNI();
                    return;
                case 2:
                    this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("launchApplication:fail_check fail forbidden scene", null));
                    return;
                default:
                    this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("launchApplication:fail_check fail", null));
                    return;
            }
        }
        this.jGK.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("launchApplication:fail_check fail", null));
    }
}
