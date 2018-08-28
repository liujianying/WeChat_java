package com.tencent.mm.plugin.appbrand.debugger;

import android.content.Context;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.cbd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class m {
    private static int ftB = -1;

    public static void a(cbd cbd, g gVar) {
        if (gVar != null) {
            int currentTimeMillis = (int) (System.currentTimeMillis() - gVar.fsv);
            h.mEJ.h(15190, new Object[]{Integer.valueOf(currentTimeMillis), Integer.valueOf(gVar.size), Integer.valueOf(cbd.boi()), Integer.valueOf(0), "", "", Integer.valueOf(aeG()), Integer.valueOf(aeH())});
        }
    }

    public static void a(a aVar, int i) {
        int currentTimeMillis = (int) (System.currentTimeMillis() - aVar.fsv);
        h.mEJ.h(15190, new Object[]{Integer.valueOf(currentTimeMillis), Integer.valueOf(aVar.size), Integer.valueOf(i), Integer.valueOf(1), "", bi.oV(aVar.bHA), Integer.valueOf(aeG()), Integer.valueOf(aeH())});
    }

    public static void a(String str, LinkedList<String> linkedList, long j, int i, int i2) {
        String str2 = "";
        if ((str.equals("invokeHandler") || str.equals("publishHandler")) && linkedList.size() > 0) {
            str2 = (String) linkedList.get(0);
        }
        int currentTimeMillis = (int) (System.currentTimeMillis() - j);
        h.mEJ.h(15190, new Object[]{Integer.valueOf(currentTimeMillis), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(2), str, str2, Integer.valueOf(aeG()), Integer.valueOf(aeH())});
    }

    public static String so(String str) {
        Matcher matcher = Pattern.compile("subscribeHandler\\(\"(.*)\" , ").matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private static int aeG() {
        if (ftB >= 0) {
            return ftB;
        }
        int iSPCode = ao.getISPCode(ad.getContext());
        ftB = iSPCode;
        return iSPCode;
    }

    public static int aeH() {
        Context context = ad.getContext();
        if (!ao.isConnected(context)) {
            return 0;
        }
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 2;
        }
        if (ao.is4G(context)) {
            return 3;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 5;
    }
}
