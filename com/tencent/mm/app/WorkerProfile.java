package com.tencent.mm.app;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.ab.h;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.u;
import com.tencent.mm.ab.u.a;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.booter.c;
import com.tencent.mm.booter.notification.a.g;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.console.Shell;
import com.tencent.mm.console.Shell.Receiver;
import com.tencent.mm.g.a.ah;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.hc;
import com.tencent.mm.g.a.ja;
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.oi;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.rr;
import com.tencent.mm.h.b;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d.a.1;
import com.tencent.mm.model.d.a.2;
import com.tencent.mm.model.f;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.report.service.IKVReportNotify;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.pluginsdk.p$a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.AccountDeletedAlphaAlertUI;
import com.tencent.mm.ui.tools.NewTaskUI;
import com.tencent.smtt.sdk.TbsReaderView$ReaderCallback;
import java.util.Locale;

public final class WorkerProfile extends e implements com.tencent.mm.ab.e, a, ak, f.a, IKVReportNotify {
    public static final String byu = (ad.getPackageName());
    private static WorkerProfile bzx;
    private com.tencent.mm.model.ad bzA;
    private boolean bzB;
    private boolean bzC = false;
    @Deprecated
    public boolean bzD;
    public boolean bzE;
    private final int bzF = 0;
    private final int bzG = 1;
    private int bzH;
    private final int bzI = 2130706432;
    private StringBuilder bzJ = new StringBuilder();
    private g bzK;
    private b bzL;
    public final s bzM = new s();
    public final r bzN = new r();
    private final Shell bzd = new Shell();
    private final com.tencent.mm.console.a bzw = new com.tencent.mm.console.a();
    private al bzy;
    private az.b bzz;
    protected Locale locale;

    public WorkerProfile() {
        bzx = this;
    }

    public static WorkerProfile vt() {
        return bzx;
    }

    public final void onCreate() {
        long currentTimeMillis = System.currentTimeMillis();
        a.cI(byu);
        x.v("MicroMsg.WorkerProfile", "workerProfile onCreate, step 1");
        x.i("MicroMsg.WorkerProfile", "start time check onCreate proc:%s pid:%d" + byu + Process.myPid());
        x.i("MicroMsg.WorkerProfile", "appOnCreate start getAccStg %b, thread name %s", new Object[]{Boolean.valueOf(true), Thread.currentThread().getName()});
        long currentTimeMillis2 = System.currentTimeMillis();
        com.tencent.mm.model.d.a JA = com.tencent.mm.model.d.a.JA();
        com.tencent.mm.model.d.a.byP = byu;
        if (ad.sGA) {
            x.i("MicroMsg.HandlerTraceManager", "trace setup delete old file ret: " + com.tencent.mm.a.e.deleteFile(com.tencent.mm.model.d.a.dEI));
        }
        JA.dEX = System.currentTimeMillis();
        ag.setLogCallback(new 1(JA));
        com.tencent.mm.sdk.platformtools.ak.a("NetsceneQueue forbid in ", new 2(JA));
        au.DF().a(-1, this);
        u.a(this);
        au.HY().dAx = this;
        au.a(new 1(this));
        au.getSysCmdMsgExtension().a("getkvidkeystg", new 12(this), true);
        Context context = this.app;
        com.tencent.mm.sdk.platformtools.e.fq(context);
        com.tencent.mm.sdk.platformtools.e.fr(context);
        try {
            com.tencent.mm.c.a aVar;
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            x.i("MicroMsg.WorkerProfile", "initChannelUtil sourceFile = %s", new Object[]{str});
            try {
                int cm = com.tencent.mm.a.e.cm(str);
                x.i("MicroMsg.WorkerProfile", "checkApkExternal, fileSize = %s", new Object[]{Integer.valueOf(cm)});
                if (cm >= 8) {
                    com.tencent.mm.c.a.a y = com.tencent.mm.c.a.a.y(com.tencent.mm.a.e.f(str, cm - 8, 8));
                    if (y == null) {
                        x.e("MicroMsg.WorkerProfile", "checkApkExternal, header null");
                    } else if ((y.bxj + 8) - 8 >= 0) {
                        com.tencent.mm.c.b bVar = new com.tencent.mm.c.b();
                        bVar.aG(com.tencent.mm.a.e.f(str, (cm - ((y.bxj + 8) - 8)) - 8, (y.bxj + 8) - 8));
                        aVar = new com.tencent.mm.c.a(bVar);
                        x.i("MicroMsg.WorkerProfile", "checkApkExternal, check ok");
                    } else {
                        x.e("MicroMsg.WorkerProfile", "checkApkExternal header wrong");
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                x.e("MicroMsg.WorkerProfile", "Exception in checkApkExternal, %s", new Object[]{e.getMessage()});
            } catch (NameNotFoundException e2) {
                x.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
            }
            aVar = com.tencent.mm.c.a.cD(str);
            c bj;
            int i;
            int i2;
            SharedPreferences sharedPreferences;
            int i3;
            int i4;
            Editor edit;
            c cVar;
            b bVar2;
            26 26;
            if (aVar == null || aVar.bxh == null) {
                str = "MicroMsg.WorkerProfile";
                String str2 = "initChannelUtil something null %s";
                Object[] objArr = new Object[1];
                objArr[0] = Boolean.valueOf(aVar == null);
                x.e(str, str2, objArr);
                d.uN();
                bj = c.bj(this.app);
                if (!(bj == null || bj.cWO == -1)) {
                    com.tencent.mm.sdk.platformtools.e.bxk = bj.cWO;
                }
                context = this.app.getApplicationContext();
                i = com.tencent.mm.sdk.platformtools.e.bxk;
                i2 = d.qVN;
                if (context != null && i >= 0 && i2 >= 637534208) {
                    try {
                        sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                        i3 = sharedPreferences.getInt("channel", -1);
                        i4 = sharedPreferences.getInt("version", 0);
                        if (!(i3 == i && i4 == i2)) {
                            edit = sharedPreferences.edit();
                            edit.putInt("channel", i);
                            edit.putInt("version", i2);
                            edit.commit();
                        }
                    } catch (Throwable th) {
                    }
                }
                if (com.tencent.mm.sdk.platformtools.e.sFA > 0) {
                    com.tencent.mm.sdk.platformtools.e.sFC = true;
                }
                com.tencent.mm.bg.d.cfH();
                d.DEVICE_TYPE = "android-" + (bi.oW(com.tencent.mm.sdk.platformtools.e.bxl) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.e.bxl);
                if (!bi.oW(com.tencent.mm.sdk.a.b.chq())) {
                    d.DEVICE_TYPE = "android-" + com.tencent.mm.sdk.a.b.chq();
                }
                x.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[]{d.DEVICE_TYPE, com.tencent.mm.sdk.a.b.chq()});
                this.locale = MMActivity.initLanguage(this.app.getBaseContext());
                if (com.tencent.mm.sdk.a.b.chp()) {
                    Shell shell = this.bzd;
                    Context context2 = ad.getContext();
                    if (shell.dhr == null) {
                        shell.dhr = new Receiver();
                        context2.registerReceiver(shell.dhr, Shell.dht);
                    }
                }
                com.tencent.mm.sdk.b.a.sFg.b(this.bzw);
                cVar = new c();
                x.d("MicroMsg.AvatarDrawable", "setLoader" + cVar);
                com.tencent.mm.pluginsdk.ui.a.b.lZs = cVar;
                com.tencent.mm.pluginsdk.f.e.qBn = new 25(this);
                com.tencent.mm.kernel.g.a(h.class, new com.tencent.mm.kernel.c.e(this.bzN));
                com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.kernel.c.e(this.bzN));
                com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.e(this.bzN));
                com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.app.plugin.b.a.a());
                if (this.bzy == null) {
                    this.bzy = new com.tencent.mm.booter.notification.b(this.app);
                }
                this.bzL = new b();
                bVar2 = this.bzL;
                x.i("MicroMsg.BroadcastController", "summerdiz init");
                com.tencent.mm.sdk.b.a.sFg.b(bVar2.cZQ);
                if (this.bzB) {
                    a(null);
                    this.bzB = false;
                }
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.kiss.a.b.2(com.tencent.mm.kiss.a.b.EY()));
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.plugin.account.bind.ui.e());
                com.tencent.mm.sdk.b.a.sFg.b(new 23(this));
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<rr>() {
                    {
                        this.sFo = rr.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        rr rrVar = (rr) bVar;
                        if (rrVar.ccB.ccC == 3) {
                            NotifyReceiver.xz();
                        }
                        com.tencent.mm.bv.d.cov().dh(rrVar.ccB.className, rrVar.ccB.ccC);
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new 30(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 31(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 32(this));
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<ow>() {
                    {
                        this.sFo = ow.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        ow owVar = (ow) bVar;
                        for (String iVar : bi.F(owVar.bZQ.bZR.split(","))) {
                            au.DF().a(new com.tencent.mm.modelmulti.i(iVar, owVar.bZQ.content, owVar.bZQ.type), 0);
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new 34(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 2(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 3(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 4(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 5(this));
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<kl>() {
                    {
                        this.sFo = kl.class.getName().hashCode();
                    }

                    @TargetApi(16)
                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        Notification a;
                        kl klVar = (kl) bVar;
                        int clP = com.tencent.mm.az.d.SF().clP();
                        int i = klVar.bUL.type;
                        String str = klVar.bUL.userName;
                        String Xw = com.tencent.mm.br.b.cjC().Xw(klVar.bUL.bgn);
                        if (WorkerProfile.this.bzK == null) {
                            WorkerProfile.this.bzK = new g(ad.getContext());
                        }
                        WorkerProfile.this.bzK;
                        int cbg = com.tencent.mm.bf.a.cbg();
                        Notification notification = new Notification();
                        notification.icon = R.g.icon;
                        notification.when = System.currentTimeMillis();
                        notification.flags = 16;
                        Intent intent = new Intent();
                        intent.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                        intent.setFlags(335544320);
                        PendingIntent activity = PendingIntent.getActivity(ad.getContext(), 0, intent, 134217728);
                        if (i == 1) {
                            String string = ad.getContext().getString(R.l.notification_receive_new_friend);
                            Bitmap a2 = com.tencent.mm.aa.c.a(str, false, -1);
                            String str2 = Xw + string;
                            int i2 = R.g.notification_message_ignore_icon;
                            String string2 = ad.getContext().getString(R.l.notification_fail_send_msg_omit);
                            int i3 = R.g.notification_message_accept_icon;
                            String string3 = ad.getContext().getString(R.l.fmessage_verify_ok);
                            Intent intent2 = new Intent();
                            intent2.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                            intent2.putExtra("friend_message_transfer_username", str);
                            intent2.setAction("friend_message_ignore_" + str);
                            PendingIntent activity2 = PendingIntent.getActivity(ad.getContext(), 0, intent2, 134217728);
                            intent2 = new Intent();
                            intent2.setClassName(ad.getPackageName(), ad.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                            intent2.putExtra("friend_message_transfer_username", str);
                            intent2.setAction("friend_message_accept_" + str);
                            a = au.getNotification().a(notification, cbg, activity, Xw, string, str2, a2, i2, string2, activity2, i3, string3, PendingIntent.getActivity(ad.getContext(), 0, intent2, 134217728), str);
                        } else {
                            String str3;
                            String string4 = ad.getContext().getString(R.l.notification_push_new_friend);
                            if (clP > 2) {
                                str3 = Xw + ad.getContext().getString(R.l.notification_multi_new_friend, new Object[]{Integer.valueOf(clP)});
                            } else {
                                str3 = Xw;
                            }
                            Bitmap decodeResource = BitmapFactory.decodeResource(ad.getContext().getResources(), cbg);
                            a = au.getNotification().a(notification, cbg, 1, activity, str3, string4, str3 + string4, decodeResource, str);
                        }
                        if (VERSION.SDK_INT >= 16) {
                            a.priority = 2;
                        }
                        if (str != null) {
                            WorkerProfile.this.bzH = 2130706432 | (str.hashCode() & 16777215);
                        } else {
                            WorkerProfile.this.bzH = 2130706432;
                        }
                        au.getNotification().a(WorkerProfile.this.bzH, a, false);
                        if (clP == 0) {
                            com.tencent.mm.az.d.num = 0;
                        } else {
                            WorkerProfile.this.bzJ.append(WorkerProfile.this.bzH + ",");
                            ad.getContext().getSharedPreferences("notify_newfriend_prep", 0).edit().putString("notify_newfriend_prep", WorkerProfile.this.bzJ.toString()).commit();
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new 7(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 8(this));
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<hc>() {
                    {
                        this.sFo = hc.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        hc hcVar = (hc) bVar;
                        if (hcVar == null || hcVar.bQo == null) {
                            x.w("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent event null ret false");
                        } else {
                            x.i("MicroMsg.WorkerProfile", "summerdiz GetDisasterInfoEvent callback event noticeid[%d], manualauthSucc[%b]", new Object[]{Integer.valueOf(hcVar.bQo.bQp), Boolean.valueOf(hcVar.bQo.bQq)});
                            au.Em().H(new 1(this, r0, r1));
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new 10(this));
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.g>() {
                    {
                        this.sFo = com.tencent.mm.g.a.g.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        String str = null;
                        com.tencent.mm.g.a.g gVar = (com.tencent.mm.g.a.g) bVar;
                        Context context = gVar.bGi.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "add card to wx event, context is null");
                            return false;
                        }
                        String str2;
                        String str3;
                        String str4;
                        String str5;
                        String[] strArr = gVar.bGi.bGj;
                        if (strArr == null || strArr.length <= 0) {
                            str2 = null;
                            str3 = null;
                        } else {
                            str3 = strArr[0];
                            str2 = com.tencent.mm.a.g.u(p.bh(gVar.bGi.context, strArr[0])[0].toByteArray());
                        }
                        String[] strArr2 = gVar.bGi.selectionArgs;
                        if (strArr2 == null || strArr2.length <= 1) {
                            str4 = null;
                            str5 = null;
                        } else {
                            str4 = strArr2[0];
                            str5 = strArr2[1];
                        }
                        if (strArr2 != null && strArr2.length > 2) {
                            str = strArr2[2];
                        }
                        x.i("MicroMsg.WorkerProfile", "carlist = %s, appid = %s, transcation = %s", new Object[]{str5, str4, str});
                        Intent intent = new Intent(context, WXBizEntryActivity.class);
                        intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                        intent.putExtra("key_in_card_list", str5);
                        intent.putExtra("key_package_name", str3);
                        intent.putExtra("key_sign", str2);
                        intent.putExtra("key_from_scene", 8);
                        intent.putExtra("key_command_id", 9);
                        intent.putExtra("key_app_id", str4);
                        intent.putExtra("key_transaction", str);
                        context.startActivity(intent);
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.bi>() {
                    {
                        this.sFo = com.tencent.mm.g.a.bi.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        int i = 0;
                        com.tencent.mm.g.a.bi biVar = (com.tencent.mm.g.a.bi) bVar;
                        Context context = biVar.bIT.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "choose card from wx event, context is null");
                            return false;
                        }
                        String[] strArr = biVar.bIT.bGj;
                        String str = null;
                        if (strArr != null && strArr.length > 0) {
                            str = strArr[0];
                            com.tencent.mm.a.g.u(p.bh(biVar.bIT.context, strArr[0])[0].toByteArray());
                        }
                        Object obj = biVar.bIT.selectionArgs;
                        if (obj == null || obj.length < 10) {
                            if (obj != null) {
                                i = obj.length;
                            }
                            x.e("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs is null or length is < 10, the length is " + i);
                        } else {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (int i2 = 0; i2 < obj.length; i2++) {
                                stringBuilder.append(", selectionArgs[" + i2 + "]:" + obj[i2]);
                            }
                            x.i("MicroMsg.WorkerProfile", "ChooseCardFromWXEvent selectionArgs:", new Object[]{obj.toString()});
                            Intent intent = new Intent(context, WXBizEntryActivity.class);
                            intent.addFlags(268435456).addFlags(134217728).addFlags(67108864);
                            intent.putExtra("app_id", obj[0]);
                            intent.putExtra("shop_id", bi.getInt(obj[1], 0));
                            intent.putExtra("sign_type", obj[2]);
                            intent.putExtra("card_sign", obj[3]);
                            intent.putExtra("time_stamp", bi.getInt(obj[4], 0));
                            intent.putExtra("nonce_str", obj[5]);
                            intent.putExtra("card_tp_id", obj[6]);
                            intent.putExtra("card_type", obj[7]);
                            intent.putExtra("can_multi_select", bi.getInt(obj[8], 0));
                            intent.putExtra("key_from_scene", 8);
                            intent.putExtra("key_command_id", 16);
                            intent.putExtra("key_app_id", obj[0]);
                            intent.putExtra("key_package_name", str);
                            intent.putExtra("key_transaction", obj[9]);
                            context.startActivity(intent);
                        }
                        return true;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.sdk.b.c<oi>() {
                    {
                        this.sFo = oi.class.getName().hashCode();
                    }

                    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                        oi oiVar = (oi) bVar;
                        Context context = oiVar.bZh.context;
                        if (context == null) {
                            x.e("MicroMsg.WorkerProfile", "context is null");
                        } else {
                            String[] strArr = oiVar.bZh.bGj;
                            String str = null;
                            String str2 = null;
                            if (strArr != null && strArr.length > 0) {
                                str = strArr[0];
                                str2 = com.tencent.mm.a.g.u(p.bh(oiVar.bZh.context, strArr[0])[0].toByteArray());
                            }
                            String[] strArr2 = oiVar.bZh.selectionArgs;
                            if (strArr2 == null || strArr2.length <= 0) {
                                x.e("MicroMsg.WorkerProfile", "args is null");
                            } else {
                                x.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle event, withType = %b", new Object[]{Boolean.valueOf(oiVar.bZh.bZi)});
                                String str3;
                                String str4;
                                Intent intent;
                                com.tencent.mm.model.u.b v;
                                if (!oiVar.bZh.bZi) {
                                    str3 = null;
                                    str4 = null;
                                    if (strArr2 != null && strArr2.length > 1) {
                                        str3 = strArr2[0];
                                        str4 = strArr2[1];
                                    }
                                    x.i("MicroMsg.WorkerProfile", "open webview, appid = %s, url = %s", new Object[]{str3, str4});
                                    if (!(bi.oW(str3) || bi.oW(str4))) {
                                        x.i("MicroMsg.WorkerProfile", "url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&url=%s", new Object[]{str3, str4})});
                                        intent = new Intent(context, WXBizEntryActivity.class);
                                        intent.setData(Uri.parse(str4));
                                        intent.addFlags(268435456);
                                        intent.putExtra("key_package_name", str);
                                        intent.putExtra("translate_link_scene", 1);
                                        intent.putExtra("key_package_signature", str2);
                                        intent.putExtra("key_command_id", 12);
                                        v = com.tencent.mm.model.u.Hx().v("key_data_center_session_id", true);
                                        v.p("key_package_name", str);
                                        v.p("key_package_signature", str2);
                                        x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                                        context.startActivity(intent);
                                        return true;
                                    }
                                } else if (strArr2 == null || strArr2.length <= 0) {
                                    x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle fail, selectionArgs length invalid");
                                } else {
                                    str4 = strArr2[0];
                                    x.i("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent, typeStr = %s, appid = %s", new Object[]{strArr2[1], str4});
                                    String str5;
                                    switch (bi.WU(str3)) {
                                        case 1:
                                            if (strArr2.length < 5) {
                                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", new Object[]{Integer.valueOf(strArr2.length)});
                                            }
                                            String str6 = strArr2[2];
                                            String str7 = strArr2[3];
                                            str5 = strArr2[4];
                                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, scene = %s, templateID = %s, reserved = %s", new Object[]{str4, Integer.valueOf(r3), str6, str7, str5});
                                            if (bi.oW(str4)) {
                                                x.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                                break;
                                            }
                                            str5 = Uri.encode(String.format("scene=%s&template_id=%s&reserved=%s", new Object[]{str6, str7, str5}));
                                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5})});
                                            intent = new Intent(context, WXBizEntryActivity.class);
                                            intent.setData(Uri.parse(str4));
                                            intent.addFlags(268435456);
                                            intent.putExtra("key_package_name", str);
                                            intent.putExtra("translate_link_scene", 1);
                                            intent.putExtra("key_package_signature", str2);
                                            intent.putExtra("key_command_id", 12);
                                            v = com.tencent.mm.model.u.Hx().v("key_data_center_session_id", true);
                                            v.p("key_package_name", str);
                                            v.p("key_package_signature", str2);
                                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                                            context.startActivity(intent);
                                            return true;
                                        case 5:
                                            if (strArr2.length < 5) {
                                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent handle subscribe message, lenght = %d", new Object[]{Integer.valueOf(strArr2.length)});
                                            }
                                            x.i("MicroMsg.WorkerProfile", "openwebviewwithtype, appid = %s, type = %s, miniProgramAppid = %s", new Object[]{str4, Integer.valueOf(r3), strArr2[2]});
                                            if (bi.oW(str4)) {
                                                x.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, appId is null");
                                                break;
                                            } else if (bi.oW(str5)) {
                                                x.e("MicroMsg.WorkerProfile", "openwebviewwithtype fail, miniProgramAppid is null");
                                                break;
                                            } else {
                                                str5 = Uri.encode(String.format("miniProgramAppid=%s", new Object[]{str5}));
                                                x.i("MicroMsg.WorkerProfile", "openwebviewwithtype url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5})});
                                                intent = new Intent(context, WXBizEntryActivity.class);
                                                intent.setData(Uri.parse(str4));
                                                intent.addFlags(268435456);
                                                intent.putExtra("key_package_name", str);
                                                intent.putExtra("translate_link_scene", 1);
                                                intent.putExtra("key_package_signature", str2);
                                                intent.putExtra("key_command_id", 12);
                                                v = com.tencent.mm.model.u.Hx().v("key_data_center_session_id", true);
                                                v.p("key_package_name", str);
                                                v.p("key_package_signature", str2);
                                                x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                                                context.startActivity(intent);
                                                return true;
                                            }
                                        default:
                                            if (strArr2.length < 3) {
                                                x.e("MicroMsg.WorkerProfile", "SDKOpenWebviewEvent fail, unknown type = %d", new Object[]{Integer.valueOf(r3)});
                                                break;
                                            }
                                            str5 = strArr2[2];
                                            x.i("MicroMsg.WorkerProfile", "default url format = %s", new Object[]{String.format("weixin://dl/businessWebview/link?appid=%s&type=%d&query=%s", new Object[]{str4, Integer.valueOf(r3), str5})});
                                            intent = new Intent(context, WXBizEntryActivity.class);
                                            intent.setData(Uri.parse(str4));
                                            intent.addFlags(268435456);
                                            intent.putExtra("key_package_name", str);
                                            intent.putExtra("translate_link_scene", 1);
                                            intent.putExtra("key_package_signature", str2);
                                            intent.putExtra("key_command_id", 12);
                                            v = com.tencent.mm.model.u.Hx().v("key_data_center_session_id", true);
                                            v.p("key_package_name", str);
                                            v.p("key_package_signature", str2);
                                            x.i("MicroMsg.WorkerProfile", "sava packagename and signature to data center, package ; %s, sig : %s", new Object[]{str, str2});
                                            context.startActivity(intent);
                                            return true;
                                    }
                                }
                            }
                        }
                        return false;
                    }
                });
                com.tencent.mm.sdk.b.a.sFg.b(new 15(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 16(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 17(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 18(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 19(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 20(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 21(this));
                com.tencent.mm.sdk.b.a.sFg.b(new 22(this));
                com.tencent.mm.sdk.b.a.sFg.b(new l(2, 12));
                com.tencent.mm.plugin.messenger.a.g.lbL = new com.tencent.mm.ui.transmit.d();
                p$a.qyl = new com.tencent.mm.app.plugin.a();
                o.a.qyj = new com.tencent.mm.app.plugin.c();
                com.tencent.mm.pluginsdk.ui.d.b.a.qPF = com.tencent.mm.app.plugin.d.vA();
                if (!au.Dr()) {
                    au.HU();
                }
                com.tencent.mm.sdk.b.a.sFg.m(new cg());
                this.bzC = true;
                Log.setLogImpl(new 24(this));
                x.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
                26 = new 26(ad.getContext());
                26.map.put("qqmail", Integer.valueOf(R.l.hardcode_plugin_qqmail_nick));
                26.map.put("fmessage", Integer.valueOf(R.l.hardcode_plugin_fmessage_nick));
                26.map.put("floatbottle", Integer.valueOf(R.l.hardcode_plugin_bottle_nick));
                26.map.put("lbsapp", Integer.valueOf(R.l.hardcode_plugin_lbs_nick));
                26.map.put("shakeapp", Integer.valueOf(R.l.hardcode_plugin_shake_nick));
                26.map.put("medianote", Integer.valueOf(R.l.hardcode_plugin_medianote_nick));
                26.map.put("qqfriend", Integer.valueOf(R.l.hardcode_plugin_qqfriend_nick));
                26.map.put("newsapp", Integer.valueOf(R.l.hardcode_plugin_readerappnews_nick));
                26.map.put("facebookapp", Integer.valueOf(R.l.hardcode_plugin_facebookapp_nick));
                26.map.put("masssendapp", Integer.valueOf(R.l.hardcode_plugin_masssend_nick));
                26.map.put("meishiapp", Integer.valueOf(R.l.hardcode_plugin_meishiapp_nick));
                26.map.put("feedsapp", Integer.valueOf(R.l.hardcode_plugin_feedsapp_nick));
                26.map.put("voipapp", Integer.valueOf(R.l.hardcode_plugin_voip_nick));
                26.map.put("weixin", Integer.valueOf(R.l.official_nick));
                26.map.put("filehelper", Integer.valueOf(R.l.hardcode_file_helper_nick));
                26.map.put("cardpackage", Integer.valueOf(R.l.hardcode_plugin_card_package_nick));
                26.map.put("officialaccounts", Integer.valueOf(R.l.hardcode_plugin_official_accounts_nick));
                26.map.put("voicevoipapp", Integer.valueOf(R.l.hardcode_plugin_voipaudio_nick));
                26.map.put("helper_entry", Integer.valueOf(R.l.hardcode_plugin_helper_entry_nick));
                26.map.put("voiceinputapp", Integer.valueOf(R.l.hardcode_plugin_voiceinput_nick));
                26.map.put("linkedinplugin", Integer.valueOf(R.l.hardcode_plugin_linkedin_nick));
                26.map.put("notifymessage", Integer.valueOf(R.l.hardcode_plugin_notify_message_nick));
                26.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.hardcode_plugin_sport_nick));
                26.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.hardcode_plugin_app_brand_customer_service_message_nick));
                26.bzY.put("weixin", Integer.valueOf(R.l.official_alias));
                com.tencent.mm.l.a.a(26);
                if (!com.tencent.mm.compatible.util.f.zZ()) {
                    com.tencent.mm.plugin.report.service.h.mEJ.a(340, com.tencent.mm.compatible.util.d.fR(19) ? 5 : 6, 1, false);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                    Object[] objArr2 = new Object[2];
                    objArr2[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.fR(19) ? TbsReaderView$ReaderCallback.HIDDEN_BAR : TbsReaderView$ReaderCallback.SHOW_BAR);
                    objArr2[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.bnC, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                    hVar.h(11098, objArr2);
                }
                x.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.bzD), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxk), Integer.valueOf(d.qVN), bi.fX(ad.getContext())});
            }
            x.i("MicroMsg.WorkerProfile", "apk external info not null");
            if (aVar.bxh.bxk != 0) {
                com.tencent.mm.sdk.platformtools.e.bxk = aVar.bxh.bxk;
                x.i("MicroMsg.WorkerProfile", "read channelId from apk external");
            }
            if (aVar.bxh.bxm != 0) {
                com.tencent.mm.sdk.platformtools.e.bxm = aVar.bxh.bxm;
                x.i("MicroMsg.WorkerProfile", "ext.updateMode = %s", new Object[]{Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxm)});
            }
            if (aVar.bxh.bxn != null) {
                com.tencent.mm.sdk.platformtools.e.sFA = bi.getInt(aVar.bxh.bxn, 0);
            }
            if (aVar.bxh.bxo != null) {
                com.tencent.mm.sdk.platformtools.e.sFB = aVar.bxh.bxo;
            }
            if (aVar.bxh.bxl != null) {
                com.tencent.mm.sdk.platformtools.e.bxl = aVar.bxh.bxl;
            }
            if (aVar.bxh.bxr) {
                com.tencent.mm.sdk.platformtools.e.sFF = aVar.bxh.bxr;
                x.i("MicroMsg.WorkerProfile", "ext.isNokiaol = %s", new Object[]{Boolean.valueOf(com.tencent.mm.sdk.platformtools.e.sFF)});
            }
            if (aVar.bxh.bxq != 0) {
                com.tencent.mm.sdk.platformtools.e.bxq = aVar.bxh.bxq;
                x.i("MicroMsg.WorkerProfile", "ext.autoAddAccount = %s", new Object[]{Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxq)});
            }
            if (aVar.bxh.bxp) {
                com.tencent.mm.sdk.platformtools.e.sFE = aVar.bxh.bxp;
                x.i("MicroMsg.WorkerProfile", "ext.shouldShowGprsAlert = %s", new Object[]{Boolean.valueOf(com.tencent.mm.sdk.platformtools.e.sFE)});
            }
            d.uN();
            bj = c.bj(this.app);
            com.tencent.mm.sdk.platformtools.e.bxk = bj.cWO;
            context = this.app.getApplicationContext();
            i = com.tencent.mm.sdk.platformtools.e.bxk;
            i2 = d.qVN;
            sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
            i3 = sharedPreferences.getInt("channel", -1);
            i4 = sharedPreferences.getInt("version", 0);
            edit = sharedPreferences.edit();
            edit.putInt("channel", i);
            edit.putInt("version", i2);
            edit.commit();
            if (com.tencent.mm.sdk.platformtools.e.sFA > 0) {
                com.tencent.mm.sdk.platformtools.e.sFC = true;
            }
            com.tencent.mm.bg.d.cfH();
            if (bi.oW(com.tencent.mm.sdk.platformtools.e.bxl)) {
            }
            d.DEVICE_TYPE = "android-" + (bi.oW(com.tencent.mm.sdk.platformtools.e.bxl) ? Integer.valueOf(VERSION.SDK_INT) : com.tencent.mm.sdk.platformtools.e.bxl);
            if (bi.oW(com.tencent.mm.sdk.a.b.chq())) {
                d.DEVICE_TYPE = "android-" + com.tencent.mm.sdk.a.b.chq();
            }
            x.v("MicroMsg.WorkerProfile", "set device type :%s  %s", new Object[]{d.DEVICE_TYPE, com.tencent.mm.sdk.a.b.chq()});
            this.locale = MMActivity.initLanguage(this.app.getBaseContext());
            if (com.tencent.mm.sdk.a.b.chp()) {
                Shell shell2 = this.bzd;
                Context context22 = ad.getContext();
                if (shell2.dhr == null) {
                    shell2.dhr = new Receiver();
                    context22.registerReceiver(shell2.dhr, Shell.dht);
                }
            }
            com.tencent.mm.sdk.b.a.sFg.b(this.bzw);
            cVar = new c();
            x.d("MicroMsg.AvatarDrawable", "setLoader" + cVar);
            com.tencent.mm.pluginsdk.ui.a.b.lZs = cVar;
            com.tencent.mm.pluginsdk.f.e.qBn = new 25(this);
            com.tencent.mm.kernel.g.a(h.class, new com.tencent.mm.kernel.c.e(this.bzN));
            com.tencent.mm.kernel.g.a(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.kernel.c.e(this.bzN));
            com.tencent.mm.kernel.g.a(i.class, new com.tencent.mm.kernel.c.e(this.bzN));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.brandservice.a.a.class, new com.tencent.mm.plugin.bbom.d());
            com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.app.plugin.b.a.a());
            if (this.bzy == null) {
                this.bzy = new com.tencent.mm.booter.notification.b(this.app);
            }
            this.bzL = new b();
            bVar2 = this.bzL;
            x.i("MicroMsg.BroadcastController", "summerdiz init");
            com.tencent.mm.sdk.b.a.sFg.b(bVar2.cZQ);
            if (this.bzB) {
                a(null);
                this.bzB = false;
            }
            com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.kiss.a.b.2(com.tencent.mm.kiss.a.b.EY()));
            com.tencent.mm.sdk.b.a.sFg.b(new com.tencent.mm.plugin.account.bind.ui.e());
            com.tencent.mm.sdk.b.a.sFg.b(new 23(this));
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(new 30(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 31(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 32(this));
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(new 34(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 2(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 3(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 4(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 5(this));
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(new 7(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 8(this));
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(new 10(this));
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(/* anonymous class already generated */);
            com.tencent.mm.sdk.b.a.sFg.b(new 15(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 16(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 17(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 18(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 19(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 20(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 21(this));
            com.tencent.mm.sdk.b.a.sFg.b(new 22(this));
            com.tencent.mm.sdk.b.a.sFg.b(new l(2, 12));
            com.tencent.mm.plugin.messenger.a.g.lbL = new com.tencent.mm.ui.transmit.d();
            p$a.qyl = new com.tencent.mm.app.plugin.a();
            o.a.qyj = new com.tencent.mm.app.plugin.c();
            com.tencent.mm.pluginsdk.ui.d.b.a.qPF = com.tencent.mm.app.plugin.d.vA();
            if (au.Dr()) {
                au.HU();
            }
            com.tencent.mm.sdk.b.a.sFg.m(new cg());
            this.bzC = true;
            Log.setLogImpl(new 24(this));
            x.d("MicroMsg.WorkerProfile", "start time check WorkerProfile appOnCreate use time " + (System.currentTimeMillis() - currentTimeMillis2));
            26 = new 26(ad.getContext());
            26.map.put("qqmail", Integer.valueOf(R.l.hardcode_plugin_qqmail_nick));
            26.map.put("fmessage", Integer.valueOf(R.l.hardcode_plugin_fmessage_nick));
            26.map.put("floatbottle", Integer.valueOf(R.l.hardcode_plugin_bottle_nick));
            26.map.put("lbsapp", Integer.valueOf(R.l.hardcode_plugin_lbs_nick));
            26.map.put("shakeapp", Integer.valueOf(R.l.hardcode_plugin_shake_nick));
            26.map.put("medianote", Integer.valueOf(R.l.hardcode_plugin_medianote_nick));
            26.map.put("qqfriend", Integer.valueOf(R.l.hardcode_plugin_qqfriend_nick));
            26.map.put("newsapp", Integer.valueOf(R.l.hardcode_plugin_readerappnews_nick));
            26.map.put("facebookapp", Integer.valueOf(R.l.hardcode_plugin_facebookapp_nick));
            26.map.put("masssendapp", Integer.valueOf(R.l.hardcode_plugin_masssend_nick));
            26.map.put("meishiapp", Integer.valueOf(R.l.hardcode_plugin_meishiapp_nick));
            26.map.put("feedsapp", Integer.valueOf(R.l.hardcode_plugin_feedsapp_nick));
            26.map.put("voipapp", Integer.valueOf(R.l.hardcode_plugin_voip_nick));
            26.map.put("weixin", Integer.valueOf(R.l.official_nick));
            26.map.put("filehelper", Integer.valueOf(R.l.hardcode_file_helper_nick));
            26.map.put("cardpackage", Integer.valueOf(R.l.hardcode_plugin_card_package_nick));
            26.map.put("officialaccounts", Integer.valueOf(R.l.hardcode_plugin_official_accounts_nick));
            26.map.put("voicevoipapp", Integer.valueOf(R.l.hardcode_plugin_voipaudio_nick));
            26.map.put("helper_entry", Integer.valueOf(R.l.hardcode_plugin_helper_entry_nick));
            26.map.put("voiceinputapp", Integer.valueOf(R.l.hardcode_plugin_voiceinput_nick));
            26.map.put("linkedinplugin", Integer.valueOf(R.l.hardcode_plugin_linkedin_nick));
            26.map.put("notifymessage", Integer.valueOf(R.l.hardcode_plugin_notify_message_nick));
            26.map.put("gh_43f2581f6fd6", Integer.valueOf(R.l.hardcode_plugin_sport_nick));
            26.map.put("appbrandcustomerservicemsg", Integer.valueOf(R.l.hardcode_plugin_app_brand_customer_service_message_nick));
            26.bzY.put("weixin", Integer.valueOf(R.l.official_alias));
            com.tencent.mm.l.a.a(26);
            if (com.tencent.mm.compatible.util.f.zZ()) {
                com.tencent.mm.plugin.report.service.h.mEJ.a(340, com.tencent.mm.compatible.util.d.fR(19) ? 5 : 6, 1, false);
                com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.mEJ;
                Object[] objArr22 = new Object[2];
                objArr22[0] = Integer.valueOf(com.tencent.mm.compatible.util.d.fR(19) ? TbsReaderView$ReaderCallback.HIDDEN_BAR : TbsReaderView$ReaderCallback.SHOW_BAR);
                objArr22[1] = String.format("%s;%s;%s", new Object[]{com.tencent.mm.compatible.util.e.bnC, Environment.getExternalStorageDirectory().getAbsolutePath(), com.tencent.mm.compatible.util.h.getExternalStorageDirectory().getAbsolutePath()});
                hVar2.h(11098, objArr22);
            }
            x.i("MicroMsg.WorkerProfile", "start time check WorkerProfile oncreate use time :%d, launcherisFirst :%b channel:%d cv:%d. topActivityName:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(this.bzD), Integer.valueOf(com.tencent.mm.sdk.platformtools.e.bxk), Integer.valueOf(d.qVN), bi.fX(ad.getContext())});
        } catch (NameNotFoundException e22) {
            x.e("MicroMsg.WorkerProfile", "initChannelUtil NameNotFoundException");
        } catch (Exception e3) {
            x.e("MicroMsg.WorkerProfile", "Exception in initChannel, %s", new Object[]{e3.getMessage()});
        }
    }

    public final void onTerminate() {
        super.onTerminate();
        b bVar = this.bzL;
        x.i("MicroMsg.BroadcastController", "summerdiz release oldNoticeInfo[%s], newDisasterNoticeInfoMap[%d]", new Object[]{bVar.cZN, Integer.valueOf(bVar.cZP.size())});
        com.tencent.mm.sdk.b.a.sFg.c(bVar.cZQ);
        bVar.cZN = null;
        bVar.cZO.clear();
        bVar.cZP.clear();
        this.bzL = null;
    }

    public final void onConfigurationChanged(Configuration configuration) {
        String property = be.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            this.locale = new Locale(property);
        }
        synchronized (this) {
            if (this.bzC) {
                a(configuration);
                return;
            }
            this.bzB = true;
        }
    }

    private void a(Configuration configuration) {
        w.c(configuration);
        String property = be.getProperty("system_property_key_locale");
        if (property != null && property.length() > 0) {
            if ("language_default".equalsIgnoreCase(property)) {
                this.locale = Locale.getDefault();
            } else {
                String[] split = property.split("_");
                if (split == null || split.length < 2) {
                    this.locale = new Locale(property);
                } else {
                    x.d("MicroMsg.WorkerProfile", "initLanguage arr.length = %s", new Object[]{Integer.valueOf(split.length)});
                    this.locale = new Locale(split[0], split[1]);
                }
            }
        }
        Locale initLanguage = MMActivity.initLanguage(this.app.getBaseContext());
        x.d("MicroMsg.WorkerProfile", "onConfigurationChanged, locale = %s, n = %s, lang = %s", new Object[]{this.locale, initLanguage, property});
        if (initLanguage != null && this.locale != null && !initLanguage.equals(this.locale)) {
            if (au.HX()) {
                try {
                    com.tencent.mm.network.e eVar = au.DF().dJs;
                    if (eVar != null) {
                        com.tencent.mm.network.c Lr = eVar.Lr();
                        if (Lr != null) {
                            byte[] bArr = new byte[0];
                            au.HU();
                            Lr.x(bArr, com.tencent.mm.model.c.Df());
                        }
                    }
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "", new Object[0]);
                    x.printErrStackTrace("MicroMsg.WorkerProfile", e, "what the f$!k", new Object[0]);
                }
            }
            x.w("MicroMsg.WorkerProfile", "language changed, restart process");
            System.exit(-1);
        }
    }

    public final String toString() {
        return byu;
    }

    public final al getNotification() {
        if (this.bzy == null) {
            this.bzy = new com.tencent.mm.booter.notification.b(this.app);
        }
        return this.bzy;
    }

    public final az.b vu() {
        if (this.bzz == null) {
            this.bzz = new 27(this);
        }
        return this.bzz;
    }

    public final com.tencent.mm.model.ad vv() {
        if (this.bzA == null) {
            this.bzA = com.tencent.mm.booter.a.xt();
        }
        return this.bzA;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WorkerProfile", "onSceneEnd dkwt type:%d [%d,%d,%s]", new Object[]{Integer.valueOf(lVar.getType()), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 3 && i2 == -1) {
            x.i("MicroMsg.WorkerProfile", "getStack([ %s ]), ThreadID: %s", new Object[]{bi.cjd(), Long.valueOf(Thread.currentThread().getId())});
        }
        Intent intent;
        if (i == 4 && i2 == -3002) {
            if (bi.oW(str)) {
                x.e("MicroMsg.WorkerProfile", "summerdiz -3002 but errMsg is null");
                return;
            }
            if (str.startsWith("autoauth_errmsg_")) {
                str = str.substring(16);
            }
            x.i("MicroMsg.WorkerProfile", "summerdiz MM_ERR_IDCDISASTER -3002 errStr:%s", new Object[]{str});
            ah ahVar = new ah();
            ahVar.bHy.type = 4;
            ahVar.bHy.bHA = str;
            com.tencent.mm.sdk.b.a.sFg.m(ahVar);
        } else if (au.HX() && i == 4 && ((i2 == -6 || i2 == -310 || i2 == -311) && str != null && str.startsWith("autoauth_errmsg_"))) {
            if (NewTaskUI.czP() == null) {
                intent = new Intent();
                intent.setClass(ad.getContext(), NewTaskUI.class).addFlags(268435456);
                ad.getContext().startActivity(intent);
            }
        } else if (i == 4 && i2 == -213) {
            ja jaVar = new ja();
            jaVar.bSG.status = 0;
            jaVar.bSG.aAk = 3;
            com.tencent.mm.sdk.b.a.sFg.m(jaVar);
            if (AccountDeletedAlphaAlertUI.czr() == null) {
                intent = new Intent();
                intent.setClass(ad.getContext(), AccountDeletedAlphaAlertUI.class).addFlags(268435456);
                intent.putExtra("errmsg", str);
                ad.getContext().startActivity(intent);
            }
        }
    }

    public final void onReportKVDataReady(byte[] bArr, byte[] bArr2, int i) {
        au.Em().H(new 28(this, i, bArr2));
    }

    public final void cW(String str) {
        x.i("MicroMsg.WorkerProfile", "summerdiz onOldDisaster errStr[%s]", new Object[]{str});
        ah ahVar = new ah();
        ahVar.bHy.type = 4;
        ahVar.bHy.bHA = str;
        com.tencent.mm.sdk.b.a.sFg.m(ahVar);
    }

    public final void cX(String str) {
        x.i("MicroMsg.WorkerProfile", "summerdiz onReMoveNoticeId:%s", new Object[]{str});
        ah ahVar = new ah();
        ahVar.bHy.type = 1;
        ahVar.bHy.bHA = str;
        com.tencent.mm.sdk.b.a.sFg.m(ahVar);
    }
}
