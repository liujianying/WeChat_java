package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static int gTj;
    public static int gTk;
    public static int gTl;
    public static int gTm;
    public static int gTn;
    public static int gTo;
    public static int gTp;
    public static long gTq;
    public static long gTr;
    public static long gTs;

    public static void reset() {
        gTj = 0;
        gTk = 0;
        gTl = 0;
        gTm = 0;
        gTn = 0;
        gTo = 0;
        gTp = 0;
        long VF = bi.VF();
        gTq = VF;
        gTs = VF - gTr;
    }

    public static void mz(int i) {
        switch (i) {
            case 1:
                gTl++;
                break;
            case 3:
                gTj++;
                break;
            case 34:
                gTn++;
                break;
            case 37:
            case 40:
            case f$k.AppCompatTheme_dialogTheme /*42*/:
            case f$k.AppCompatTheme_homeAsUpIndicator /*48*/:
            case f$k.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
            case 10000:
                gTk++;
                break;
            case f$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                gTm++;
                break;
            case f$k.AppCompatTheme_actionButtonStyle /*49*/:
                gTo++;
                break;
        }
        gTp++;
    }

    public static void aro() {
        x.d("MicroMsg.TestInfo", "total_count: " + gTp + "text_count: " + gTl + "normal_count : " + gTk + " image_count: " + gTj + " voice_count : " + gTn + " video_count " + gTm + " app_count : " + gTo + " time: " + (bi.VF() - gTq) + " net: " + gTs);
    }

    public static void arp() {
        x.d("MicroMsg.TestInfo", "netTime" + (bi.VF() - gTr));
    }
}
