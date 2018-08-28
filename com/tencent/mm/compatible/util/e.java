package com.tencent.mm.compatible.util;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.ax.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public final class e extends b {
    public static final String dgi = h.getExternalStorageDirectory().getParent();
    public static String dgj = (bnE + "Download/");
    public static String dgk;
    public static String dgl;
    public static String dgm = (bnE + "vusericon/");
    public static String dgn = (bnE + "Game/");
    public static String dgo = (bnE + "CDNTemp/");
    public static String dgp = (bnE + "Download/VoiceRemind");
    public static String dgq = (bnE + "watchdog/");
    public static String dgr = (bnE + "xlog");
    public static String dgs = (bnE + "avatar/");
    public static String dgt = (bnE + "exdevice/");
    public static String dgu = (bnE + "newyear/");
    public static String dgv = (bnE + "expose/");
    public static String dgw = (bnE + "f2flucky/");
    public static String dgx = (bnE + "WebviewCache/");
    public static String dgy = (bnE + "pattern_recognition/");
    public static String dgz = (bnE + "sniffer/");

    public static void ff(String str) {
        x.i("MicroMsg.CConstants", "initSdCardPath start SDCARD_ROOT: " + bnC);
        if (bi.oW(str)) {
            int i;
            ArrayList ciH = ax.ciH();
            int size = ciH.size();
            for (i = 0; i < size; i++) {
                x.i("MicroMsg.CConstants", "initSdCardPath start list i = " + i + " StatMountParse: " + ciH.get(i));
            }
            if (size > 1) {
                Collections.sort(ciH, new Comparator<a>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        a aVar = (a) obj;
                        a aVar2 = (a) obj2;
                        long j = (aVar.sIO * aVar.sIP) - (aVar2.sIO * aVar2.sIP);
                        if (j < 0) {
                            return 1;
                        }
                        return j > 0 ? -1 : 0;
                    }
                });
            }
            if (!(size <= 0 || ciH.get(0) == null || bi.oW(((a) ciH.get(0)).sIK))) {
                bnC = ((a) ciH.get(0)).sIK;
                for (i = 0; i < size; i++) {
                    x.i("MicroMsg.CConstants", "initSdCardPath end list i = " + i + " StatMountParse: " + ciH.get(i));
                }
            }
        } else {
            bnC = str;
        }
        bnE = bnC + bnD;
        dgj = bnE + "Download/";
        dgm = bnE + "vusericon/";
        dgn = bnE + "Game/";
        dgo = bnE + "CDNTemp/";
        dgq = bnE + "watchdog/";
        dgr = bnE + "xlog";
        duP = bnE + "crash/";
        dgs = bnE + "avatar/";
        dgk = bnE + "Cache/";
        String str2 = bnE + "WeChat/";
        String str3 = bnE + "WeiXin/";
        if (com.tencent.mm.a.e.cn(str2) || !(com.tencent.mm.a.e.cn(str3) || w.chP().equals("zh_CN"))) {
            str3 = str2;
        }
        dgl = str3;
        x.i("MicroMsg.CConstants", "initSdCardPath end SDCARD_ROOT: " + bnC);
    }
}
