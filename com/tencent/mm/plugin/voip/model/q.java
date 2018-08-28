package com.tencent.mm.plugin.voip.model;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.tencent.mm.R;
import com.tencent.mm.bh.d.a;
import com.tencent.mm.g.a.su;
import com.tencent.mm.k.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.ui.InviteRemindDialog;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class q {
    private static boolean oMY = false;
    private static OnClickListener oMZ = new 3();

    public static long a(String str, String str2, int i, int i2, String str3) {
        return a(str, str2, i, i2, str3, false);
    }

    public static long a(String str, String str2, int i, int i2, String str3, boolean z) {
        bd bdVar = new bd();
        bdVar.ay(com.tencent.mm.model.bd.iD(str));
        bdVar.eX(i);
        bdVar.setType(50);
        bdVar.ep(str);
        bdVar.dt(str3);
        bdVar.setContent(str2);
        bdVar.setStatus(i2);
        if (z) {
            bdVar.eC(bdVar.cqa | 8);
        }
        au.HU();
        long T = c.FT().T(bdVar);
        if (T < 0) {
            x.e("MicroMsg.VoipPluginManager", "inset voip  failed!");
        }
        x.d("MicroMsg.VoipPluginManager", "inset voip  msgId " + T);
        return T;
    }

    public static void bKN() {
        au.HU();
        c.DT().set(20480, Long.valueOf(System.currentTimeMillis()));
    }

    public static boolean bKO() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            au.HU();
            long longValue = ((Long) c.DT().get(20480, Integer.valueOf(-1))).longValue();
            if (longValue < 0) {
                return false;
            }
            currentTimeMillis -= longValue;
            x.d("MicroMsg.VoipPluginManager", "diff is" + currentTimeMillis);
            if (currentTimeMillis < 21600000) {
                return true;
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static void aK(final Context context, final String str) {
        new String[1][0] = context.getResources().getString(R.l.voip_call);
        oMY = false;
        try {
            au.HU();
            bd GF = c.FT().GF(str);
            if (GF != null) {
                long j = GF.field_createTime;
                oMY = d.bLP();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        if (bi.oW(str)) {
            x.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int Lg = au.DF().Lg();
        x.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + Lg);
        if (Lg != 4 && Lg != 6) {
            h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(4), Integer.valueOf(0)});
            com.tencent.mm.ui.base.h.a(context, R.l.voip_net_unavailable, R.l.voip_not_wifi_warnning_title, oMZ);
        } else if (!oMY) {
            try {
                au.HU();
                Map Uv = a.Uv((String) c.DT().get(77829, null));
                if (Uv != null) {
                    a aVar;
                    if (Uv != null && Uv.size() > 0) {
                        if (Uv.containsKey(str)) {
                            aVar = (a) Uv.get(str);
                            aVar.hitCount++;
                            Uv.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            Uv.put(str, aVar);
                        }
                    }
                    au.HU();
                    c.DT().set(77829, a.at(Uv));
                    for (Entry entry : Uv.entrySet()) {
                        aVar = (a) entry.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.ecL + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    au.HU();
                    c.DT().set(77829, a.at(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.ecL + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
            }
            InviteRemindDialog.k(context, str, 0);
            bKP();
        } else if (ao.isWap(context)) {
            com.tencent.mm.ui.base.h.a(context, R.l.voip_using_wap_tip, 0, R.l.voip_using_wap_yes, R.l.app_cancel, new 2(context), oMZ);
        } else if (ao.isWifi(context) || bKO()) {
            i.bJI().aP(context, str);
        } else {
            com.tencent.mm.ui.base.h.a(context, R.l.voip_not_wifi_warnning_message, R.l.voip_not_wifi_warnning_title, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    q.bKN();
                    i.bJI().aP(context, str);
                }
            }, oMZ);
        }
    }

    private static void bKP() {
        su suVar = new su();
        suVar.cdE.bOh = 8;
        com.tencent.mm.sdk.b.a.sFg.m(suVar);
    }

    public static void ek(Context context) {
        try {
            Intent intent = new Intent("/");
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.ApnSettings"));
            intent.setAction("android.intent.action.VIEW");
            context.startActivity(intent);
        } catch (Exception e) {
            searchIntentByClass(context, "ApnSettings");
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                x.e("MicroMsg.VoipPluginManager", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        x.e("MicroMsg.VoipPluginManager", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                x.e("MicroMsg.VoipPluginManager", "activityName count " + size);
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.VoipPluginManager", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Throwable e22) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e22, "", new Object[0]);
        }
        return null;
    }

    public static void aL(Context context, String str) {
        int i;
        g.AU();
        if (com.tencent.mm.k.c.AF() == 2) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        com.tencent.mm.bg.d.cfH();
        if (i2 == 0) {
            x.i("MicroMsg.VoipPluginManager", "showDouble %b, isLiteVersion: %b", new Object[]{Boolean.valueOf(false), Boolean.valueOf(false)});
        }
        oMY = false;
        try {
            au.HU();
            bd GF = c.FT().GF(str);
            if (GF != null) {
                long j = GF.field_createTime;
                oMY = d.bLP();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aN(context, str);
    }

    public static void aM(Context context, String str) {
        oMY = false;
        try {
            au.HU();
            bd GF = c.FT().GF(str);
            if (GF != null) {
                long j = GF.field_createTime;
                oMY = d.bLP();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
        }
        aN(context, str);
    }

    private static void aN(Context context, String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.VoipPluginManager", "talker is null");
            return;
        }
        int Lg = au.DF().Lg();
        x.d("MicroMsg.VoipPluginManager", "startVoipVideoCall getNowStatus " + Lg);
        if (Lg != 4 && Lg != 6) {
            h.mEJ.a(11518, true, true, new Object[]{Integer.valueOf(i.bJI().oNa.oHa.oJX.kpo), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(4), Integer.valueOf(0)});
            com.tencent.mm.ui.base.h.a(context, R.l.voip_net_unavailable, R.l.voip_not_wifi_warnning_title, oMZ);
        } else if (!oMY) {
            try {
                au.HU();
                Map Uv = a.Uv((String) c.DT().get(77829, null));
                if (Uv != null) {
                    a aVar;
                    if (Uv != null && Uv.size() > 0) {
                        if (Uv.containsKey(str)) {
                            aVar = (a) Uv.get(str);
                            aVar.hitCount++;
                            Uv.put(str, aVar);
                        } else {
                            aVar = new a();
                            aVar.hitCount++;
                            Uv.put(str, aVar);
                        }
                    }
                    au.HU();
                    c.DT().set(77829, a.at(Uv));
                    for (Entry entry : Uv.entrySet()) {
                        aVar = (a) entry.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val1 " + aVar.hitCount + " " + aVar.ecL + "name " + ((String) entry.getKey()));
                    }
                } else {
                    Map hashMap = new HashMap();
                    a aVar2 = new a();
                    aVar2.hitCount++;
                    hashMap.put(str, aVar2);
                    au.HU();
                    c.DT().set(77829, a.at(hashMap));
                    for (Entry entry2 : hashMap.entrySet()) {
                        aVar2 = (a) entry2.getValue();
                        x.d("MicroMsg.VoipPluginManager", "val2 " + aVar2.hitCount + " " + aVar2.ecL + "  name " + ((String) entry2.getKey()));
                    }
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.VoipPluginManager", e, "", new Object[0]);
            }
            InviteRemindDialog.k(context, str, 1);
            bKP();
        } else if (ao.isWap(context)) {
            com.tencent.mm.ui.base.h.a(context, R.l.voip_using_wap_tip, 0, R.l.voip_using_wap_yes, R.l.app_cancel, new 5(context), oMZ);
        } else if (ao.isWifi(context) || bKO()) {
            i.bJI().aO(context, str);
        } else {
            com.tencent.mm.ui.base.h.a(context, R.l.voip_not_wifi_warnning_message, R.l.voip_not_wifi_warnning_title, new 4(context, str), oMZ);
        }
    }
}
