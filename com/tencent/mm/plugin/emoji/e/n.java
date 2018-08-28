package com.tencent.mm.plugin.emoji.e;

import android.content.pm.PackageManager.NameNotFoundException;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.gif.MMWXGFJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;

public final class n {
    private static boolean igU = false;
    private static boolean igV = false;
    private static boolean igW = false;
    private static boolean igX = false;

    public static boolean aEg() {
        if ((g.AT().getInt("EmotionRewardOption", 0) & 1) == 1) {
            return false;
        }
        return true;
    }

    public static boolean aEh() {
        if ((g.AT().getInt("EmotionRewardOption", 0) & 2) == 2) {
            return false;
        }
        return true;
    }

    public static boolean aEi() {
        if ((g.AT().getInt("EmotionRewardOption", 0) & 4) == 4) {
            return true;
        }
        return false;
    }

    public static int aEj() {
        return bi.getInt(g.AT().getValue("CustomEmojiMaxSize"), 150);
    }

    public static String aEk() {
        return g.AT().getValue("C2CEmojiNotAutoDownloadTimeRange");
    }

    public static String aEl() {
        return g.AT().getValue("EmotionPanelConfigName");
    }

    public static boolean aEm() {
        if (!igU) {
            c fJ = com.tencent.mm.model.c.c.Jx().fJ("100296");
            int i;
            if (fJ.isValid()) {
                i = bi.getInt((String) fJ.ckq().get("EnableEmoticonExternUrl"), 0);
            } else {
                i = 0;
            }
            int i2 = g.AT().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 1) != 1 && (i & 1) != 1) {
                igW = false;
            } else if (aEo() || aEp()) {
                igW = false;
            } else {
                igW = true;
            }
            if (errorCode < 0) {
                igW = false;
                switch (errorCode) {
                    case -906:
                        h.mEJ.a(711, 10, 1, false);
                        break;
                    case -905:
                        h.mEJ.a(711, 9, 1, false);
                        break;
                    case -904:
                        h.mEJ.a(711, 8, 1, false);
                        break;
                    case -903:
                        h.mEJ.a(711, 7, 1, false);
                        break;
                    case -902:
                        h.mEJ.a(711, 6, 1, false);
                        break;
                    case -901:
                        h.mEJ.a(711, 5, 1, false);
                        break;
                }
            }
            igU = true;
            x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDownload:%b", new Object[]{Boolean.valueOf(igW)});
        }
        return igW;
    }

    public static boolean aEn() {
        if (!igV) {
            int i = 0;
            c fJ = com.tencent.mm.model.c.c.Jx().fJ("100296");
            if (fJ.isValid()) {
                i = bi.getInt((String) fJ.ckq().get("EnableEmoticonExternUrl"), 0);
            }
            int i2 = g.AT().getInt("EnableEmoticonExternUrl", 0);
            int errorCode = MMWXGFJNI.getErrorCode();
            if ((i2 & 2) == 2 || (i & 2) == 2) {
                if (aEo() || aEp()) {
                    h.mEJ.a(711, 0, 1, false);
                } else {
                    igX = true;
                    h.mEJ.a(711, 1, 1, false);
                    if (errorCode < 0) {
                        igX = false;
                    }
                    igV = true;
                    x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[]{Boolean.valueOf(igX)});
                }
            }
            igX = false;
            if (errorCode < 0) {
                igX = false;
            }
            igV = true;
            x.i("MicroMsg.emoji.EmotionDynamicConfigMgr", "isEnableHevcDecode:%b", new Object[]{Boolean.valueOf(igX)});
        }
        return igX;
    }

    private static boolean aEo() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app.cn", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private static boolean aEp() {
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.wearable.app", 1);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
