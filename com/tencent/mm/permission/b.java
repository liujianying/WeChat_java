package com.tencent.mm.permission;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.util.Base64;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.k.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.au;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class b {
    static final String byN;
    static final String byO;
    static Map<Integer, a> euZ;
    c eva = new 1(this);
    private c evb = new 2(this);
    private c evc = new 3(this);

    static /* synthetic */ void b(int i, boolean z, boolean z2) {
        x.i("MicroMsg.PermissionMgr", "makeMark, setOrClear: " + z);
        au.HS().setInt(((a) euZ.get(Integer.valueOf(i))).eve, z ? 1 : 0);
        if (true == z) {
            a.Vj().Vk();
        }
        if (!z && true == z2) {
            long j = au.HS().getLong(((a) euZ.get(Integer.valueOf(i))).evf, 0);
            if (0 != j && System.currentTimeMillis() - j >= 86400000) {
                Y("LastTick: " + j + ", CurrentTtick: " + System.currentTimeMillis() + "\n", au.HS().Di(((a) euZ.get(Integer.valueOf(i))).evg) == 1 ? 6 : 5);
                au.HS().setLong(((a) euZ.get(Integer.valueOf(i))).evf, 0);
            }
        }
    }

    static /* synthetic */ boolean iP(int i) {
        int Di = au.HS().Di(((a) euZ.get(Integer.valueOf(i))).eve);
        x.i("MicroMsg.PermissionMgr", "current mark status: " + Di);
        return Di == 0;
    }

    static /* synthetic */ boolean y(int i, boolean z) {
        int oH;
        boolean z2;
        a aVar = new a();
        int i2 = 1;
        int i3 = 1;
        if (au.HX()) {
            i2 = oH("ShowPermissionDialog");
            i3 = oH("OnlyScanRunningService");
            oH = oH("Interval4ShowPmsDialog");
        } else {
            oH = 3600000;
        }
        x.i("MicroMsg.PermissionMgr", "showDlg: %d, filter: %d, interval: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(oH)});
        long j = 0;
        for (a aVar2 : euZ.values()) {
            long j2 = au.HS().getLong(aVar2.evf, 0);
            if (j < j2) {
                j = j2;
            }
        }
        boolean z3 = 1 == i2 && System.currentTimeMillis() - j >= ((long) oH);
        if (z3) {
            String str;
            z2 = 1 == i3;
            List arrayList = new ArrayList();
            List<com.tencent.mm.compatible.f.a.b> arrayList2 = new ArrayList();
            List<com.tencent.mm.compatible.f.a.a> arrayList3 = new ArrayList();
            com.tencent.mm.compatible.f.a.a(e.duN + "permissioncfg.cfg", arrayList2, arrayList3);
            String str2 = null;
            PInt pInt = new PInt(0);
            PBool pBool = new PBool();
            for (com.tencent.mm.compatible.f.a.b bVar : arrayList2) {
                pInt.value = 0;
                pBool.value = true;
                if (com.tencent.mm.compatible.f.a.a(Build.MANUFACTURER, bVar.dfU, pInt, pBool) && com.tencent.mm.compatible.f.a.a(Build.MODEL, bVar.model, pInt, pBool)) {
                    com.tencent.mm.compatible.f.a.a(VERSION.RELEASE, bVar.version, pInt, pBool);
                }
                str = (!pBool.value || pInt.value <= 0) ? str2 : (String) bVar.dfT.get(i);
                str2 = str;
            }
            if (str2 != null) {
                arrayList.add(str2);
            }
            List<PackageInfo> be = com.tencent.mm.compatible.f.a.be(z2);
            if (be != null) {
                for (PackageInfo packageInfo : be) {
                    str2 = null;
                    for (com.tencent.mm.compatible.f.a.a aVar3 : arrayList3) {
                        pInt.value = 0;
                        pBool.value = true;
                        if (com.tencent.mm.compatible.f.a.a(packageInfo.packageName, aVar3.byT, pInt, pBool)) {
                            if (aVar3.dfQ == 0 && aVar3.dfR == 0) {
                                pBool.value = true;
                            } else if (aVar3.dfQ > packageInfo.versionCode || aVar3.dfR < packageInfo.versionCode) {
                                pBool.value = false;
                            } else {
                                pInt.value++;
                                pBool.value = true;
                            }
                        }
                        str = (!pBool.value || pInt.value <= 0) ? str2 : (String) aVar3.dfT.get(i);
                        str2 = str;
                    }
                    if (str2 != null) {
                        arrayList.add(str2);
                    }
                }
            }
            x.i("MicroMsg.PermissionMgr", "len of tips list: " + Integer.valueOf(arrayList.size()));
            if (arrayList.size() != 0) {
                a(i, arrayList, z);
                c(arrayList, z);
                z2 = true;
            } else {
                if (System.currentTimeMillis() - au.HS().getLong(42, 0) < 2592000000L) {
                    cc(z);
                } else if (1 == i) {
                    au.HS().setLong(42, System.currentTimeMillis());
                    PermissionWarningDialog.b(ad.getContext(), 1 == i3, z);
                }
                z2 = false;
            }
            au.HS().setLong(((a) euZ.get(Integer.valueOf(i))).evf, System.currentTimeMillis());
        } else {
            z2 = false;
        }
        x.i("MicroMsg.PermissionMgr", "showPermissionDialog cost: " + aVar.Ad() + ", needShowDlg: " + z3);
        return z2;
    }

    static {
        String zz = q.zz();
        byN = zz;
        byO = o.getString(zz.hashCode());
        Map hashMap = new HashMap();
        euZ = hashMap;
        hashMap.put(Integer.valueOf(1), new a(38, 40, 41, R.l.app_permission_tips_title_record, R.l.app_permission_tips_content_prefix_audio));
        euZ.put(Integer.valueOf(2), new a(43, 44, 45, R.l.app_permission_tips_title_camera, R.l.app_permission_tips_content_prefix_camera));
    }

    public b() {
        com.tencent.mm.sdk.b.a.sFg.b(this.eva);
        com.tencent.mm.sdk.b.a.sFg.b(this.evb);
        com.tencent.mm.sdk.b.a.sFg.b(this.evc);
    }

    private static int oH(String str) {
        int i = 0;
        try {
            return bi.getInt(g.AT().getValue(str), 0);
        } catch (Exception e) {
            x.e("MicroMsg.PermissionMgr", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            return i;
        }
    }

    public static void cc(boolean z) {
        Y("App_List:\n", z ? 4 : 3);
    }

    public static void l(boolean z, boolean z2) {
        StringBuilder stringBuilder = new StringBuilder();
        PackageManager packageManager = ad.getContext().getPackageManager();
        List<PackageInfo> be = com.tencent.mm.compatible.f.a.be(z);
        if (be != null) {
            stringBuilder.append("App_List:\n");
            for (PackageInfo packageInfo : be) {
                if (packageInfo != null) {
                    String str = "";
                    if (!(packageInfo.applicationInfo == null || packageManager == null)) {
                        str = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                    }
                    stringBuilder.append(str + ":" + packageInfo.packageName + ":" + packageInfo.versionCode + "\n");
                }
            }
        }
        Y(stringBuilder.toString(), z2 ? 4 : 3);
    }

    private static void c(List<String> list, boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Match_Tips:\n");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append("\n");
            i = i2 + 1;
        }
        Y(stringBuilder.toString(), z ? 2 : 1);
    }

    private static void a(int i, List<String> list, boolean z) {
        int i2;
        int i3;
        int size = list.size() > 5 ? 5 : list.size();
        int[] iArr = new int[]{R.l.app_permission_tips_one, R.l.app_permission_tips_two, R.l.app_permission_tips_three, R.l.app_permission_tips_four, R.l.app_permission_tips_five};
        Context context = ad.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.getString(((a) euZ.get(Integer.valueOf(i))).evi));
        for (i2 = 0; i2 < size; i2++) {
            stringBuilder.append(context.getString(iArr[i2]));
            stringBuilder.append((String) list.get(i2));
            stringBuilder.append(10);
        }
        w HS = au.HS();
        i2 = ((a) euZ.get(Integer.valueOf(i))).evg;
        if (z) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        HS.setInt(i2, i3);
        PermissionWarningDialog.m(context, context.getString(((a) euZ.get(Integer.valueOf(i))).evh), stringBuilder.toString());
    }

    private static void Y(String str, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n#client.version=").append(d.qVN).append("\n");
        stringBuilder.append("#accinfo.revision=").append(com.tencent.mm.sdk.platformtools.d.REV).append("\n");
        stringBuilder.append("#accinfo.uin=").append(at.dBv.I("last_login_uin", byO)).append("\n");
        stringBuilder.append("#accinfo.dev=").append(byN).append("\n");
        stringBuilder.append("#accinfo.build=").append(com.tencent.mm.sdk.platformtools.d.TIME).append(":").append(com.tencent.mm.sdk.platformtools.d.HOSTNAME).append(":").append(com.tencent.mm.sdk.platformtools.e.bxk).append("\n");
        Date date = new Date();
        stringBuilder.append("#accinfo.uploadTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date)).append("\n");
        stringBuilder.append("#permission.type=").append(String.valueOf(i)).append(10);
        stringBuilder.append("#permission.content:\n");
        Intent intent = new Intent();
        intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.monitor.ExceptionMonitorService");
        intent.setAction("uncatch_exception");
        intent.putExtra("exceptionWriteSdcard", false);
        intent.putExtra("exceptionPid", Process.myPid());
        String str2 = "userName";
        String I = at.dBv.I("login_weixin_username", "");
        if (bi.oW(I)) {
            I = at.dBv.I("login_user_name", "never_login_crash");
        }
        intent.putExtra(str2, I);
        intent.putExtra("tag", "permission");
        x.d("MicroMsg.PermissionMgr", "report type: %d, len: %d", new Object[]{Integer.valueOf(i), Integer.valueOf((stringBuilder.toString() + str).length())});
        intent.putExtra("exceptionMsg", Base64.encodeToString(I.getBytes(), 2));
        ad.getContext().startService(intent);
    }
}
