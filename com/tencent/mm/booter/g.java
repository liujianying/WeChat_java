package com.tencent.mm.booter;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import com.tencent.mm.ar.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

public final class g {
    public static void run() {
        SharedPreferences sharedPreferences;
        Editor edit;
        int i;
        Context context = ad.getContext();
        1 1 = new 1();
        if (context != null) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                String[] split = sharedPreferences.getString("crashlist", "").split(";");
                if (split != null && split.length > 0) {
                    edit = sharedPreferences.edit();
                    edit.putString("crashlist", "");
                    edit.commit();
                    for (i = 0; i < split.length; i++) {
                        String[] split2 = split[i] == null ? null : split[i].split(",");
                        if (split2 != null && split2.length >= 2) {
                            if (split2[1].equals("anr")) {
                                1.et(10);
                            } else {
                                1.et(11);
                                if ("com.tencent.mm".equals(split2[0])) {
                                    1.et(14);
                                }
                                if ("com.tencent.mm:push".equals(split2[0])) {
                                    1.et(17);
                                }
                                if ("com.tencent.mm:tools".equals(split2[0])) {
                                    1.et(20);
                                }
                                if (split2[1].equals("java")) {
                                    1.et(12);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        1.et(15);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        1.et(18);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        1.et(21);
                                    }
                                }
                                if (split2[1].equals("jni")) {
                                    1.et(13);
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        1.et(16);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        1.et(19);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        1.et(22);
                                    }
                                }
                                if (split2[1].equals("first")) {
                                    if ("com.tencent.mm".equals(split2[0])) {
                                        1.et(23);
                                    }
                                    if ("com.tencent.mm:push".equals(split2[0])) {
                                        1.et(24);
                                    }
                                    if ("com.tencent.mm:tools".equals(split2[0])) {
                                        1.et(25);
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        context = ad.getContext();
        i = com.tencent.mm.k.g.AT().getInt("AndroidGooglePlayCrashUploadSizeLimit", 3072);
        if (context != null && i > 0) {
            try {
                sharedPreferences = context.getSharedPreferences("crash_status_file", 4);
                if (sharedPreferences.getInt("googleplaysizelimit", 3072) != i) {
                    edit = sharedPreferences.edit();
                    edit.putInt("googleplaysizelimit", i);
                    edit.commit();
                }
            } catch (Throwable th2) {
            }
        }
        au.HU();
        if (ai.bH(ai.d((Long) c.DT().get(a.sOt, null))) > 21600000) {
            h.mEJ.a(279, (long) (com.tencent.mm.k.g.AT().getInt("AndroidDynamicConfigVer", 0) % 16), 1, false);
            au.HU();
            c.DT().a(a.sOt, Long.valueOf(ai.VF()));
        }
        au.HU();
        if (ai.bH(ai.d((Long) c.DT().get(a.sOu, null))) > 21600000) {
            au.HU();
            c.DT().a(a.sOu, Long.valueOf(ai.VF()));
            s Ta = o.Ta();
            int[] iArr = new int[]{0, 0, 0, 0, 0, 0};
            try {
                x.i("MicroMsg.VideoInfoStorage", "reportVideoMsgCount sql:%s", new Object[]{"select status, videofuncflag, human from videoinfo2 where lastmodifytime > " + (bi.VE() - 21600)});
                Cursor b = Ta.dCZ.b(r2, null, 2);
                while (b.moveToNext()) {
                    int i2 = b.getInt(0);
                    int i3 = b.getInt(1);
                    String string = b.getString(2);
                    if (111 == i2) {
                        if (i3 == 3) {
                            i2 = 0;
                        } else {
                            i2 = 3;
                        }
                        iArr[i2] = iArr[i2] + 1;
                    } else if (199 == i2) {
                        if (q.GF().equals(string)) {
                            i2 = i3 == 3 ? 1 : 4;
                            iArr[i2] = iArr[i2] + 1;
                        } else {
                            i2 = i3 == 3 ? 2 : 5;
                            iArr[i2] = iArr[i2] + 1;
                        }
                    }
                }
                b.close();
                h.mEJ.h(12696, new Object[]{Integer.valueOf(10010), Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]), Integer.valueOf(iArr[4]), Integer.valueOf(iArr[5])});
            } catch (Exception e) {
            }
        }
        if (bi.VF() - bi.a((Long) com.tencent.mm.kernel.g.Ei().DT().get(81939, null), 0) > 86400000) {
            i iVar = new i();
        }
        long currentTimeMillis = System.currentTimeMillis();
        au.HU();
        boolean booleanValue = ((Boolean) c.DT().get(233475, Boolean.valueOf(false))).booleanValue();
        au.HU();
        if (c.FR().clo() <= 0) {
            if (!booleanValue) {
                au.HU();
                c.FW().Yp("officialaccounts");
                au.HU();
                c.DT().set(233475, Boolean.valueOf(true));
            }
        } else if (booleanValue) {
            au.HU();
            c.DT().set(233475, Boolean.valueOf(false));
        }
        com.tencent.mm.plugin.webwx.a.g.bYF().bYH().bYD();
        x.i("MicroMsg.PostTaskLightweightJob", "use time %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
