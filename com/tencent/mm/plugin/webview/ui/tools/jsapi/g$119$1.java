package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.g.a.ir;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.119;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.c.aoh;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

class g$119$1 implements Runnable {
    final /* synthetic */ int bFq;
    final /* synthetic */ int bFr;
    final /* synthetic */ String dJG;
    final /* synthetic */ b dKr;
    final /* synthetic */ 119 qkc;

    g$119$1(119 119, int i, int i2, String str, b bVar) {
        this.qkc = 119;
        this.bFq = i;
        this.bFr = i2;
        this.dJG = str;
        this.dKr = bVar;
    }

    public final void run() {
        x.d("MicroMsg.MsgHandler", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[]{Integer.valueOf(this.bFq), Integer.valueOf(this.bFr), this.dJG});
        if (this.bFq == 0 && this.bFr == 0) {
            aoh aoh = (aoh) this.dKr.dIE.dIL;
            switch (aoh.bMH) {
                case 0:
                    List B;
                    Object b;
                    boolean a;
                    d dVar = new d(new 1(this));
                    x.i("MicroMsg.MsgHandler", "launchApplication check result(showType : %d, errCode : %d)", new Object[]{Integer.valueOf(aoh.rQQ), Integer.valueOf(aoh.bMH)});
                    if (!bi.oW(this.qkc.fFT)) {
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(this.qkc.fFT));
                        intent.addFlags(268435456);
                        B = bi.B(g.j(this.qkc.qiK), intent);
                        if (!(B == null || B.isEmpty())) {
                            if (TextUtils.isEmpty(intent.getPackage()) && B.size() == 1) {
                                b = g.b((ResolveInfo) B.get(0));
                            } else {
                                b = intent.getPackage();
                            }
                            if (!bi.oV(ad.getPackageName()).equals(b)) {
                                dVar.cJ(g.a(g.j(this.qkc.qiK), intent, null, aoh.rQQ, dVar, this.qkc.fFU));
                                return;
                            }
                        }
                    }
                    WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
                    wXAppExtendObject.extInfo = this.qkc.fFX;
                    WXMediaMessage wXMediaMessage = new WXMediaMessage(wXAppExtendObject);
                    wXMediaMessage.sdkVer = 620823808;
                    wXMediaMessage.messageExt = this.qkc.fFX;
                    ir irVar = new ir();
                    irVar.bSe.bSg = wXMediaMessage;
                    irVar.bSe.appId = this.qkc.fFV;
                    irVar.bSe.showType = aoh.rQQ;
                    irVar.bSe.context = g.j(this.qkc.qiK);
                    irVar.bSe.bJx = this.qkc.fFU;
                    irVar.bSe.bSh = dVar;
                    a.sFg.m(irVar);
                    boolean z = irVar.bSf.bSi;
                    if (!z) {
                        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(this.qkc.fFV + "://" + this.qkc.fFW));
                        x.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[]{r0});
                        intent2.addFlags(268435456);
                        B = bi.B(g.j(this.qkc.qiK), intent2);
                        if (!(B == null || B.isEmpty())) {
                            if (TextUtils.isEmpty(intent2.getPackage()) && B.size() == 1) {
                                b = g.b((ResolveInfo) B.get(0));
                            } else {
                                b = intent2.getPackage();
                            }
                            if (!bi.oV(ad.getPackageName()).equals(b)) {
                                dVar.dJP = false;
                                dVar.fGh = false;
                                dVar.fGi = false;
                                dVar.bSi = false;
                                a = g.a(g.j(this.qkc.qiK), intent2, null, dVar, this.qkc.fFU);
                                dVar.cJ(a);
                                return;
                            }
                        }
                    }
                    a = z;
                    dVar.cJ(a);
                    return;
                case 2:
                    g.a(this.qkc.qiK, this.qkc.qiH, "launchApplication:fail_check fail forbidden scene", null);
                    return;
                default:
                    g.a(this.qkc.qiK, this.qkc.qiH, "launchApplication:fail_check fail", null);
                    return;
            }
        }
        g.a(this.qkc.qiK, this.qkc.qiH, "launchApplication:fail_check fail", null);
    }
}
