package com.tencent.mm.ao;

import com.tencent.mm.plugin.ab.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bh;

public final class c {
    public static boolean a(bh bhVar) {
        if (bhVar == null) {
            x.e("MicroMsg.NewTipsManager", "check time, tipsInfo is null!!!");
            return false;
        }
        boolean z;
        long VE = bi.VE();
        if (bhVar.field_overdueTime == 0 && bhVar.field_disappearTime == 0) {
            z = true;
        } else {
            Long valueOf = Long.valueOf(Math.min(bhVar.field_beginShowTime + bhVar.field_overdueTime, bhVar.field_disappearTime));
            z = VE >= bhVar.field_beginShowTime && VE <= valueOf.longValue();
            if (VE > valueOf.longValue()) {
                ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).edit().putLong("newtips_makeread_time", bi.VF()).commit();
            }
        }
        x.i("MicroMsg.NewTipsManager", "timeEffective current: %s, overdueTime: %s, disappearTime: %s, show:%s", new Object[]{Long.valueOf(VE), Long.valueOf(bhVar.field_overdueTime), Long.valueOf(bhVar.field_disappearTime), Boolean.valueOf(z)});
        return z;
    }

    public static boolean b(bh bhVar) {
        if (bhVar == null) {
            x.e("MicroMsg.NewTipsManager", "check path, tipsInfo is null!!!");
            return false;
        }
        bh Do = a.bjj().Do(bhVar.field_tipId);
        if (Do == null || Do.field_tipsShowInfo == null || bhVar.field_tipsShowInfo == null) {
            return false;
        }
        String str = Do.field_tipsShowInfo.path;
        String str2 = bhVar.field_tipsShowInfo.path;
        if ((str == null && str2 == null) || (str != null && str.equals(str2))) {
            return true;
        }
        x.i("MicroMsg.NewTipsManager", "path illegal, localPath:%s, newPath:%s", new Object[]{str, str2});
        return false;
    }

    public static boolean c(bh bhVar) {
        if (bhVar == null) {
            x.e("MicroMsg.NewTipsManager", "check version, tipsInfo is null!!!");
            return false;
        }
        bh Do = a.bjj().Do(bhVar.field_tipId);
        if (Do == null) {
            return false;
        }
        if (bhVar.field_tipVersion > Do.field_tipVersion || (!bhVar.field_hadRead && bhVar.field_tipVersion == Do.field_tipVersion)) {
            return true;
        }
        return false;
    }

    protected static boolean d(bh bhVar) {
        if (bhVar == null) {
            x.e("MicroMsg.NewTipsManager", "can not show new  tips！！ tipsInfo is null !!");
            return false;
        } else if (bhVar.field_isExit && !bhVar.field_hadRead && a(bhVar)) {
            return true;
        } else {
            x.i("MicroMsg.NewTipsManager", "can not show tips, isExit:%s, hadRead:%s, timeEffective:%s", new Object[]{Boolean.valueOf(bhVar.field_isExit), Boolean.valueOf(bhVar.field_hadRead), Boolean.valueOf(a(bhVar))});
            return false;
        }
    }

    public static boolean ig(int i) {
        bh Do = a.bjj().Do(i);
        String format;
        int i2;
        int i3;
        long j;
        int i4;
        String str;
        String str2;
        String str3;
        long j2;
        if (Do == null) {
            x.e("MicroMsg.NewTipsManager", "showDot, newTipsInfo is null !!");
            return false;
        } else if (d(a.bjj().Do(i)) && Do.field_tipsShowInfo != null && Do.field_tipsShowInfo.showType == b.ebu) {
            if (Do == null) {
                x.e("MicroMsg.NewTipsManager", "reportShowNewTips, newTipsInfo is null !!");
            } else {
                format = String.format("newtips_show_%d-%d", new Object[]{Integer.valueOf(Do.field_tipId), Integer.valueOf(Do.field_tipVersion)});
                if (!ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).getBoolean(format, false)) {
                    int i5 = Do.field_tipId;
                    i2 = Do.field_tipVersion;
                    i3 = Do.field_tipType;
                    j = ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).edit().putLong("newtips_realshow_time", bi.VF()).commit();
                    i4 = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.showType : 0;
                    str = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.title : "";
                    str2 = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.lMY : "";
                    str3 = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.path : "";
                    h.mEJ.h(14995, new Object[]{Integer.valueOf(i5), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j), "", "", "", Long.valueOf(j2), "", "", "", Integer.valueOf(i4), str, str2, str3, "", Integer.valueOf(b.ebA), ""});
                    ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).edit().putBoolean(format, true).commit();
                }
            }
            return true;
        } else {
            if (Do == null) {
                x.e("MicroMsg.NewTipsManager", "reportDismissNewTips, newTipsInfo is null !!");
            } else {
                String format2 = String.format("newtips_dismiss_%d-%d", new Object[]{Integer.valueOf(Do.field_tipId), Integer.valueOf(Do.field_tipVersion)});
                if (!ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).getBoolean(format2, false)) {
                    i2 = Do.field_tipId;
                    i3 = Do.field_tipVersion;
                    int i6 = Do.field_tipType;
                    j = ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).getLong("newtips_gettipstime", 0);
                    j2 = Do.field_beginShowTime;
                    long j3 = Do.field_overdueTime;
                    long j4 = Do.field_disappearTime;
                    long j5 = ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).getLong("newtips_makeread_time", 0) - ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).getLong("newtips_realshow_time", 0);
                    i4 = 0;
                    long VE = bi.VE();
                    if (!b(Do) || !c(Do)) {
                        i4 = 1;
                    } else if (Do.field_hadRead) {
                        i4 = 4;
                    } else if (Do.field_disappearTime != 0 && VE > Do.field_disappearTime) {
                        i4 = 3;
                    } else if (Do.field_overdueTime != 0 && Do.field_beginShowTime + Do.field_overdueTime <= Do.field_disappearTime && VE > Do.field_beginShowTime + Do.field_overdueTime) {
                        i4 = 2;
                    }
                    int i7 = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.showType : 0;
                    str2 = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.title : "";
                    str3 = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.lMY : "";
                    format = Do.field_tipsShowInfo != null ? Do.field_tipsShowInfo.path : "";
                    long j6 = Do.field_pagestaytime;
                    h.mEJ.h(14995, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i6), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(r20), Long.valueOf(r22), Long.valueOf(j5), Integer.valueOf(i4), Integer.valueOf(i7), str2, str3, format, "", Integer.valueOf(b.ebB), Long.valueOf(j6)});
                    if (i6 == b.ebl) {
                        com.tencent.mm.storage.bi bjj = a.bjj();
                        str = "delete from NewTipsInfo where tipId = " + Do.field_tipId;
                        x.i("MicroMsg.NewTipsInfoStorage", "delete sql: " + str);
                        bjj.diF.fV("NewTipsInfo", str);
                        bjj.b(Do.field_tipId, 5, Integer.valueOf(Do.field_tipId));
                    }
                    ad.getContext().getSharedPreferences(ad.chY() + "_newtips_report", 0).edit().putBoolean(format2, true).commit();
                }
            }
            return false;
        }
    }
}
