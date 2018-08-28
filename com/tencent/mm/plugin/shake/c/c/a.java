package com.tencent.mm.plugin.shake.c.c;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;

public final class a {
    private static SimpleDateFormat hIH = null;

    public static void buw() {
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance()");
        if (bux()) {
            x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is open");
            if (!buS()) {
                x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time, close card entrance");
                au.HU();
                c.DT().a(com.tencent.mm.storage.aa.a.sOA, Boolean.valueOf(false));
                return;
            }
            return;
        }
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() entrance is not open");
        if (buS()) {
            au.HU();
            c.DT().a(com.tencent.mm.storage.aa.a.sOA, Boolean.valueOf(true));
            x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() open shake card entrance");
            return;
        }
        x.i("MicroMsg.ShakeCardUtil", "checkShakeCardEntrance() card entrance is not in open time");
    }

    public static boolean bux() {
        if (au.HX()) {
            boolean booleanValue;
            au.HU();
            Object obj = c.DT().get(com.tencent.mm.storage.aa.a.sOA, Boolean.valueOf(false));
            if (obj != null) {
                booleanValue = ((Boolean) obj).booleanValue();
            } else {
                booleanValue = false;
            }
            return booleanValue;
        }
        x.e("MicroMsg.ShakeCardUtil", "acc is not ready");
        return false;
    }

    private static boolean buS() {
        au.HU();
        int intValue = ((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sOB, Integer.valueOf(0))).intValue();
        au.HU();
        int intValue2 = ((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sOC, Integer.valueOf(0))).intValue();
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time : " + intValue + " end time : " + intValue2);
        if (intValue <= 0) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is " + intValue + " , invalid");
            return false;
        } else if (intValue2 <= 0) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil end time  is " + intValue2 + " , invalid");
            return false;
        } else if (intValue >= intValue2) {
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil begin time is >= end time, invalid time");
            return false;
        } else {
            int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
            x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time : " + currentTimeMillis);
            if (currentTimeMillis < intValue || currentTimeMillis > intValue2) {
                x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is not incled in [btime, etime]");
                return false;
            }
            x.e("MicroMsg.ShakeCardUtil", "ShakeCardUtil current time is incled in [btime, etime]");
            return true;
        }
    }

    public static int buT() {
        au.HU();
        return ((Integer) c.DT().get(com.tencent.mm.storage.aa.a.sOH, Integer.valueOf(0))).intValue();
    }

    public static String buU() {
        au.HU();
        return (String) c.DT().get(com.tencent.mm.storage.aa.a.sOG, "");
    }

    public static String buV() {
        au.HU();
        return (String) c.DT().get(com.tencent.mm.storage.aa.a.sOD, "");
    }

    public static String buW() {
        au.HU();
        return (String) c.DT().get(com.tencent.mm.storage.aa.a.sOJ, "");
    }

    public static String buX() {
        au.HU();
        return (String) c.DT().get(com.tencent.mm.storage.aa.a.sOI, "");
    }

    public static String buY() {
        au.HU();
        return (String) c.DT().get(com.tencent.mm.storage.aa.a.sOM, "");
    }

    public static String buZ() {
        au.HU();
        return (String) c.DT().get(com.tencent.mm.storage.aa.a.sOL, "");
    }

    public static boolean vV(int i) {
        return i >= 0 && i <= 5;
    }

    public static int bva() {
        au.HU();
        int currentTimeMillis = (int) (System.currentTimeMillis() % 10);
        int nextInt = (new Random((long) c.Df()).nextInt(10) + currentTimeMillis) % 10;
        x.i("MicroMsg.ShakeCardUtil", "genShakeCardFrequencyLevel retRand:" + nextInt);
        return nextInt;
    }

    public static int vW(int i) {
        switch (i) {
            case 1:
                return 10;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 120;
            case 5:
                return d.CTRL_INDEX;
            default:
                return 0;
        }
    }

    public static int vX(int i) {
        switch (i) {
            case 1:
                return 20;
            case 2:
                return 30;
            case 3:
                return 60;
            case 4:
                return 90;
            case 5:
                return 120;
            case 6:
                return 150;
            case 7:
                return 180;
            case 8:
                return d.CTRL_INDEX;
            case 9:
                return 300;
            default:
                return 10;
        }
    }

    public static int xV(String str) {
        int rgb = Color.rgb(66, 66, 66);
        if (str == null || str.length() < 7 || !str.startsWith("#")) {
            x.e("MicroMsg.ShakeCardUtil", "string format error");
            return rgb;
        }
        try {
            String toUpperCase = str.substring(1).toUpperCase();
            return Color.argb(255, Integer.parseInt(toUpperCase.substring(0, 2), 16), Integer.parseInt(toUpperCase.substring(2, 4), 16), Integer.parseInt(toUpperCase.substring(4, 6), 16));
        } catch (Exception e) {
            x.e("MicroMsg.ShakeCardUtil", e.toString());
            return rgb;
        }
    }

    public static String bx(long j) {
        long j2 = 1000 * j;
        new GregorianCalendar().setTimeInMillis(j2);
        if (hIH == null) {
            hIH = new SimpleDateFormat("yyyy.MM.dd");
        }
        return hIH.format(new Date(j2));
    }

    public static void s(Context context, String str, String str2) {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil doCardDetailUI()");
        Intent intent = new Intent();
        intent.putExtra("key_card_id", str);
        intent.putExtra("key_card_ext", str2);
        intent.putExtra("key_from_scene", 15);
        com.tencent.mm.bg.d.b(context, "card", ".ui.CardDetailUI", intent);
    }

    public static boolean bvb() {
        return bux() && w.chL();
    }

    public static void buy() {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil setShakeCardEntranceData()");
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int i = 86400 + currentTimeMillis;
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOB, Integer.valueOf(currentTimeMillis));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOC, Integer.valueOf(i));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOD, "");
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOH, Integer.valueOf(0));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOE, Integer.valueOf(1));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOF, Integer.valueOf(6));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOG, "");
        com.tencent.mm.s.c.Cp().v(262154, true);
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOI, String.valueOf(currentTimeMillis));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOJ, "hello");
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOK, "shake card");
    }

    public static void buz() {
        x.i("MicroMsg.ShakeCardUtil", "ShakeCardUtil clearShakeCardEntranceData()");
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOB, Integer.valueOf(0));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOC, Integer.valueOf(0));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOD, "");
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOH, Integer.valueOf(0));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOE, Integer.valueOf(0));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOF, Integer.valueOf(0));
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOG, "");
        com.tencent.mm.s.c.Cp().v(262154, false);
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOI, "");
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOJ, "");
        au.HU();
        c.DT().a(com.tencent.mm.storage.aa.a.sOK, "");
    }
}
