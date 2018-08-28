package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.RECEIVERCHECK})
public class WXEntryActivity$EntryReceiver extends BroadcastReceiver {
    private static ag handler;
    private String appId;
    private String appName;
    private Context context;
    private int hdG;
    private long heg;
    private String rU;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.plugin.base.stub.WXEntryActivity$EntryReceiver r9, android.content.Context r10, android.content.Intent r11) {
        /*
        r8 = 4;
        r2 = 1;
        r3 = 0;
        r9.context = r10;
        r0 = "_mmessage_content";
        r0 = com.tencent.mm.sdk.platformtools.s.j(r11, r0);
        r1 = "_mmessage_support_content_type";
        r4 = com.tencent.mm.sdk.platformtools.s.i(r11, r1);
        r9.heg = r4;
        r1 = "_mmessage_sdkVersion";
        r1 = com.tencent.mm.sdk.platformtools.s.a(r11, r1, r3);
        r9.hdG = r1;
        r1 = r9.hdG;
        r1 = com.tencent.mm.plugin.base.stub.WXEntryActivity.mX(r1);
        if (r1 != 0) goto L_0x003f;
    L_0x0026:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "sdk version is not supported, sdkVersion = ";
        r1.<init>(r2);
        r2 = r9.hdG;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
    L_0x003e:
        return;
    L_0x003f:
        r1 = "_mmessage_appPackage";
        r1 = com.tencent.mm.sdk.platformtools.s.j(r11, r1);
        r9.rU = r1;
        r1 = r9.rU;
        if (r1 == 0) goto L_0x0054;
    L_0x004c:
        r1 = r9.rU;
        r1 = r1.length();
        if (r1 > 0) goto L_0x005e;
    L_0x0054:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "unknown package, ignore";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x005e:
        r1 = "_mmessage_checksum";
        r1 = com.tencent.mm.sdk.platformtools.s.k(r11, r1);
        r4 = r9.hdG;
        r5 = r9.rU;
        r4 = com.tencent.mm.plugin.base.stub.WXEntryActivity.s(r0, r4, r5);
        r1 = com.tencent.mm.plugin.base.stub.WXEntryActivity.e(r1, r4);
        if (r1 != 0) goto L_0x007d;
    L_0x0073:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "checksum fail";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x007d:
        if (r0 != 0) goto L_0x0089;
    L_0x007f:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "check appid failed, null content";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x0089:
        r0 = android.net.Uri.parse(r0);
        r1 = r0.getAuthority();
        r4 = "appid";
        r0 = r0.getQueryParameter(r4);	 Catch:{ Exception -> 0x00c9 }
        r9.appId = r0;	 Catch:{ Exception -> 0x00c9 }
        r0 = "MicroMsg.WXEntryActivity";
        r4 = new java.lang.StringBuilder;
        r5 = "onReceive, appId = ";
        r4.<init>(r5);
        r5 = r9.appId;
        r4 = r4.append(r5);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r4);
        r0 = r9.appId;
        if (r0 == 0) goto L_0x00be;
    L_0x00b6:
        r0 = r9.appId;
        r0 = r0.length();
        if (r0 > 0) goto L_0x00dd;
    L_0x00be:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "invalid appid, ignore";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x00c9:
        r0 = move-exception;
        r1 = "MicroMsg.WXEntryActivity";
        r4 = "init: %s";
        r2 = new java.lang.Object[r2];
        r0 = r0.toString();
        r2[r3] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r4, r2);
        goto L_0x003e;
    L_0x00dd:
        r0 = com.tencent.mm.model.au.HX();
        if (r0 == 0) goto L_0x00e9;
    L_0x00e3:
        r0 = com.tencent.mm.model.au.Dr();
        if (r0 == 0) goto L_0x00ff;
    L_0x00e9:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "not login, just save the appid : %s";
        r2 = new java.lang.Object[r2];
        r4 = r9.appId;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
        r0 = r9.appId;
        com.tencent.mm.pluginsdk.model.app.p.Tc(r0);
        goto L_0x003e;
    L_0x00ff:
        r0 = com.tencent.mm.kernel.g.Eg();
        r0 = r0.dpD;
        if (r0 != 0) goto L_0x011d;
    L_0x0107:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "not login accInitializing, just save the appid : %s";
        r2 = new java.lang.Object[r2];
        r4 = r9.appId;
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.w(r0, r1, r2);
        r0 = r9.appId;
        com.tencent.mm.pluginsdk.model.app.p.Tc(r0);
        goto L_0x003e;
    L_0x011d:
        r0 = "registerapp";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x0307;
    L_0x0126:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = new java.lang.StringBuilder;
        r4 = "handle app registeration: ";
        r1.<init>(r4);
        r4 = r9.rU;
        r1 = r1.append(r4);
        r4 = ", sdkver=";
        r1 = r1.append(r4);
        r4 = r9.hdG;
        r1 = r1.append(r4);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.model.au.HX();
        if (r0 != 0) goto L_0x015c;
    L_0x0151:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "no available account";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x015c:
        r0 = r9.appId;
        r4 = com.tencent.mm.pluginsdk.model.app.g.bl(r0, r2);
        r0 = r9.context;
        r1 = r9.rU;
        r0 = com.tencent.mm.pluginsdk.model.app.p.c(r0, r4, r1);
        if (r0 != 0) goto L_0x0180;
    L_0x016c:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "reg fail, check app fail";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bme();
        r1 = r9.appId;
        r0.SU(r1);
        goto L_0x003e;
    L_0x0180:
        if (r4 == 0) goto L_0x0197;
    L_0x0182:
        r0 = r4.aaq();
        if (r0 == 0) goto L_0x0197;
    L_0x0188:
        r0 = com.tencent.mm.plugin.game.a.a.a.aSm();
        if (r0 == 0) goto L_0x0197;
    L_0x018e:
        r1 = r9.context;
        r5 = r9.appId;
        r6 = r9.rU;
        r0.q(r1, r5, r6);
    L_0x0197:
        r1 = 0;
        r0 = r9.context;	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r0 = r0.getPackageManager();	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r5 = r9.rU;	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r6 = 0;
        r5 = r0.getApplicationInfo(r5, r6);	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        if (r5 != 0) goto L_0x01cf;
    L_0x01a7:
        r0 = "MicroMsg.WXEntryActivity";
        r5 = "package not installed";
        com.tencent.mm.sdk.platformtools.x.e(r0, r5);	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        goto L_0x003e;
    L_0x01b2:
        r0 = move-exception;
        r1 = "MicroMsg.Crash";
        r2 = "May cause dvmFindCatchBlock crash!";
        r3 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
        r1 = new java.lang.IncompatibleClassChangeError;
        r2 = "May cause dvmFindCatchBlock crash!";
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.IncompatibleClassChangeError) r0;
        r0 = (java.lang.IncompatibleClassChangeError) r0;
        throw r0;
    L_0x01cf:
        r6 = r5.loadLabel(r0);	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r6 = r6.toString();	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r9.appName = r6;	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r0 = r5.loadIcon(r0);	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r5 = r0 instanceof android.graphics.drawable.BitmapDrawable;	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        if (r5 == 0) goto L_0x037d;
    L_0x01e1:
        r0 = (android.graphics.drawable.BitmapDrawable) r0;	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
        r0 = r0.getBitmap();	 Catch:{ IncompatibleClassChangeError -> 0x01b2, Throwable -> 0x0272 }
    L_0x01e7:
        r1 = r0;
    L_0x01e8:
        if (r4 == 0) goto L_0x0203;
    L_0x01ea:
        com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r0 = r9.appId;
        if (r0 == 0) goto L_0x01f7;
    L_0x01f1:
        r5 = r0.length();
        if (r5 != 0) goto L_0x0280;
    L_0x01f7:
        r0 = "MicroMsg.AppInfoStorage";
        r5 = "hasIcon, appId is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r5);
        r0 = r3;
    L_0x0201:
        if (r0 != 0) goto L_0x020c;
    L_0x0203:
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r5 = r9.appId;
        r0.t(r5, r1);
    L_0x020c:
        if (r4 != 0) goto L_0x028a;
    L_0x020e:
        r0 = new com.tencent.mm.pluginsdk.model.app.f;
        r0.<init>();
        r1 = r9.appId;
        r0.field_appId = r1;
        r1 = "";
        r0.field_appName = r1;
        r1 = r9.rU;
        r0.field_packageName = r1;
        r0.field_status = r3;
        r1 = r9.context;
        r2 = r9.rU;
        r1 = com.tencent.mm.pluginsdk.model.app.p.bg(r1, r2);
        if (r1 == 0) goto L_0x022e;
    L_0x022c:
        r0.field_signature = r1;
    L_0x022e:
        r2 = java.lang.System.currentTimeMillis();
        r0.field_modifyTime = r2;
        r2 = r9.heg;
        r0.field_appSupportContentType = r2;
        r1 = com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r1 = r1.l(r0);
        r2 = r9.appId;
        com.tencent.mm.pluginsdk.ui.tools.b.TW(r2);
        if (r1 == 0) goto L_0x003e;
    L_0x0247:
        r0 = r0.field_openId;
        r0 = com.tencent.mm.platformtools.ai.oW(r0);
        if (r0 == 0) goto L_0x003e;
    L_0x024f:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "handleAppRegisteration, trigger getAppSetting, appId = ";
        r1.<init>(r2);
        r2 = r9.appId;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bmh();
        r1 = r9.appId;
        r0.pS(r1);
        goto L_0x003e;
    L_0x0272:
        r0 = move-exception;
        r5 = "MicroMsg.WXEntryActivity";
        r6 = "package not installed";
        r7 = new java.lang.Object[r3];
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r5, r0, r6, r7);
        goto L_0x01e8;
    L_0x0280:
        r0 = com.tencent.mm.pluginsdk.model.app.i.cQ(r0, r2);
        r0 = com.tencent.mm.a.e.cn(r0);
        goto L_0x0201;
    L_0x028a:
        r0 = r4.field_appInfoFlag;
        r0 = r0 & 8192;
        if (r0 == 0) goto L_0x037a;
    L_0x0290:
        r0 = r9.heg;
        r6 = r4.field_appSupportContentType;
        r0 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1));
        if (r0 == 0) goto L_0x0305;
    L_0x0298:
        r0 = r2;
    L_0x0299:
        r6 = r9.heg;
        r4.field_appSupportContentType = r6;
    L_0x029d:
        r1 = r4.field_status;
        r2 = 2;
        if (r1 == r2) goto L_0x02ad;
    L_0x02a2:
        r1 = r4.field_status;
        r2 = 3;
        if (r1 == r2) goto L_0x02ad;
    L_0x02a7:
        r1 = r4.field_status;
        if (r1 == r8) goto L_0x02ad;
    L_0x02ab:
        if (r0 == 0) goto L_0x02da;
    L_0x02ad:
        r0 = r4.aaq();
        if (r0 != 0) goto L_0x02b8;
    L_0x02b3:
        r0 = r9.appId;
        com.tencent.mm.pluginsdk.ui.tools.b.TW(r0);
    L_0x02b8:
        r4.field_status = r3;
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r1 = new java.lang.String[r3];
        r0 = r0.a(r4, r1);
        r1 = "MicroMsg.WXEntryActivity";
        r2 = new java.lang.StringBuilder;
        r3 = "handleAppRegisteration, updateRet = ";
        r2.<init>(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r0);
    L_0x02da:
        r0 = r4.field_openId;
        r0 = com.tencent.mm.platformtools.ai.oW(r0);
        if (r0 == 0) goto L_0x003e;
    L_0x02e2:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "handleAppRegisteration, trigger getAppSetting, appId = ";
        r1.<init>(r2);
        r2 = r9.appId;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = com.tencent.mm.pluginsdk.model.app.ao.bmh();
        r1 = r9.appId;
        r0.pS(r1);
        goto L_0x003e;
    L_0x0305:
        r0 = r3;
        goto L_0x0299;
    L_0x0307:
        r0 = "unregisterapp";
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x003e;
    L_0x0310:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = new java.lang.StringBuilder;
        r2 = "handle app unregisteration: ";
        r1.<init>(r2);
        r2 = r9.rU;
        r1 = r1.append(r2);
        r2 = ", sdkver=";
        r1 = r1.append(r2);
        r2 = r9.hdG;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r1);
        r0 = com.tencent.mm.model.au.HX();
        if (r0 != 0) goto L_0x0346;
    L_0x033b:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "no available account";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x0346:
        r0 = r9.appId;
        r0 = com.tencent.mm.pluginsdk.model.app.g.bl(r0, r3);
        r1 = r9.context;
        r2 = r9.rU;
        r1 = com.tencent.mm.pluginsdk.model.app.p.c(r1, r0, r2);
        if (r1 != 0) goto L_0x0361;
    L_0x0356:
        r0 = "MicroMsg.WXEntryActivity";
        r1 = "unreg fail, check app fail";
        com.tencent.mm.sdk.platformtools.x.e(r0, r1);
        goto L_0x003e;
    L_0x0361:
        if (r0 == 0) goto L_0x003e;
    L_0x0363:
        r1 = r0.field_status;
        r2 = 5;
        if (r1 == r2) goto L_0x003e;
    L_0x0368:
        r0.field_status = r8;
        r1 = com.tencent.mm.pluginsdk.model.app.ao.bmf();
        r2 = new java.lang.String[r3];
        r1.a(r0, r2);
        r0 = r9.appId;
        com.tencent.mm.pluginsdk.ui.tools.b.TX(r0);
        goto L_0x003e;
    L_0x037a:
        r0 = r3;
        goto L_0x029d;
    L_0x037d:
        r0 = r1;
        goto L_0x01e7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.base.stub.WXEntryActivity$EntryReceiver.a(com.tencent.mm.plugin.base.stub.WXEntryActivity$EntryReceiver, android.content.Context, android.content.Intent):void");
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            d.cfH();
            if (handler == null) {
                HandlerThread Xs = e.Xs("WXEntryReceiver");
                Xs.start();
                handler = new ag(Xs.getLooper());
            }
            if (g.Ek().dqL.drf) {
                handler.post(new 2(this, context, intent));
            } else {
                g.Ek().a(new 1(this, context, intent));
            }
        }
    }
}
