package com.tencent.mm.ui;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import com.tencent.mm.R;
import com.tencent.mm.ac.b;
import com.tencent.mm.ac.c;
import com.tencent.mm.ac.r;
import com.tencent.mm.ac.z;
import com.tencent.mm.bu.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;

public final class g {
    public static int bu(Context context, String str) {
        if (bi.oW(str)) {
            return 0;
        }
        int i;
        b kn = z.Nh().kn(str);
        if (kn == null || (kn.field_userFlag & 2) == 0) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            return 0;
        }
        if (kn.field_wwExposeTimes < kn.field_wwMaxExposeTimes || p.r(context, "com.tencent.wework")) {
            return 2;
        }
        return 1;
    }

    public static void bv(Context context, String str) {
        if (!bi.oW(str) && !p.r(context, "com.tencent.wework")) {
            z.Nh().kq(str);
        }
    }

    public static void n(Context context, String str, int i) {
        if (p.r(context, "com.tencent.wework")) {
            al(str, 4, i);
        } else {
            al(str, 5, i);
        }
    }

    public static void o(Context context, String str, int i) {
        al(str, 1, i);
        am(str, 2, i);
        b ko = z.Nh().ko(str);
        if (p.r(context, "com.tencent.wework")) {
            Intent launchIntentForPackage;
            al(str, 2, i);
            PackageInfo packageInfo = p.getPackageInfo(context, "com.tencent.wework");
            if (bi.oW(packageInfo.versionName) || packageInfo.versionName.compareTo("1.3.3") < 0) {
                launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.wework");
            } else {
                String str2;
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                if (i == 2 || i == 4 || i == 6) {
                    str2 = "wxwork://createconversation";
                } else {
                    str2 = "wxwork://conversationlist";
                }
                intent.setData(Uri.parse(str2));
                launchIntentForPackage = intent;
            }
            a.post(new 4(context, launchIntentForPackage));
        } else if (ko.field_chatOpen || ko.field_use_preset_banner_tips) {
            h.a(context, R.l.enterprise_wework_donwload_confirm_tip, 0, R.l.enterprise_wework_donwload_confirm_btn, R.l.app_cancel, new 1(context, str, i), null);
        } else if (ko.field_show_confirm) {
            e.a aVar = new e.a(context);
            aVar.uKu = context.getString(R.l.app_cancel);
            aVar.Gv(R.l.enterprise_wework_donwload_confirm_btn);
            z.Nh();
            z.Nh();
            String ht = c.ht(1);
            if (ht == null) {
                aVar.abA(context.getString(R.l.enterprise_wework_donwload_confirm_tip));
            } else {
                aVar.abA(ht);
            }
            aVar.a(new 2(), new 3(context, str, i)).eIW.show();
        } else {
            p(context, str, i);
        }
    }

    public static void p(Context context, String str, int i) {
        al(str, 3, i);
        am(str, 3, i);
        z.MY();
        String str2 = "https://work.weixin.qq.com/wework_admin/commdownload?from=conv%s";
        Object[] objArr = new Object[1];
        objArr[0] = bi.oW(com.tencent.mm.ac.e.kD(str)) ? "off" : "on";
        String format = String.format(str2, objArr);
        FileDownloadTaskInfo yP = d.aCU().yP(format);
        if (yP != null && yP.status == 3 && com.tencent.mm.a.e.cn(yP.path)) {
            com.tencent.mm.a.e.deleteFile(yP.path);
        }
        s.makeText(context, context.getString(R.l.enterprise_wework_download_tip), 2000).show();
        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar.yQ(format);
        aVar.yS(context.getString(R.l.enterprise_wework_apk));
        aVar.ox(1);
        aVar.ef(true);
        d.aCU().a(aVar.ick);
    }

    private static int al(String str, int i, int i2) {
        com.tencent.mm.ac.d kA = z.MY().kA(str);
        if (kA.LZ()) {
            str = kA.Mg();
        }
        b kn = z.Nh().kn(str);
        int i3 = kn != null ? kn.field_qyUin : 0;
        int i4 = kn != null ? kn.field_userUin : 0;
        long j = kn != null ? kn.field_wwCorpId : 0;
        long j2 = kn != null ? kn.field_wwUserVid : 0;
        com.tencent.mm.plugin.report.service.h.mEJ.h(13656, new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
        x.d("MicroMsg.EnterpriseHelper", "enterprise wework action report: %s,%s,%s,%s,%s,%s", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)});
        return i2;
    }

    public static void di(String str, int i) {
        if (i > 0) {
            int i2;
            int i3;
            b kn = z.Nh().kn(str);
            if (kn != null) {
                i2 = kn.field_qyUin;
            } else {
                i2 = 0;
            }
            if (kn != null) {
                i3 = kn.field_userUin;
            } else {
                i3 = 0;
            }
            com.tencent.mm.plugin.report.service.h.mEJ.h(13703, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)});
            x.d("MicroMsg.EnterpriseHelper", "enterprise click report: %s,%s,%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i)});
        }
    }

    public static void am(String str, int i, int i2) {
        int i3;
        com.tencent.mm.ac.d kA = z.MY().kA(str);
        if (i2 == 3) {
            i3 = 2;
        } else {
            i3 = i2;
        }
        if (i3 == 4) {
            i3 = 3;
        }
        if (kA.LZ()) {
            str = kA.Mg();
        }
        b kn = z.Nh().kn(str);
        com.tencent.mm.kernel.g.Eh().dpP.a(new r(kn, i, i3, new Object()), 0);
        int i4 = kn.field_chatOpen ? 1 : 0;
        int i5 = kn.field_show_confirm ? 1 : 0;
        com.tencent.mm.plugin.report.service.h.mEJ.h(15162, new Object[]{Long.valueOf(kn.field_wwCorpId), Long.valueOf(kn.field_wwUserVid), Integer.valueOf(i4), Integer.valueOf(kn.field_wwUnreadCnt), Integer.valueOf(i5), Integer.valueOf(kn.field_userType), Integer.valueOf(i), Integer.valueOf(i3)});
    }
}
