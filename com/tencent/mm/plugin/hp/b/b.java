package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;

public final class b {
    private static long kmx = 0;

    public static void aWk() {
        h.mEJ.a(338, 9, 1, false);
    }

    public static void rl(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        switch (i) {
            case 0:
                h.mEJ.a(338, 0, 1, false);
                break;
            case 1:
                h.mEJ.a(338, 20, 1, false);
                break;
            case 2:
                h.mEJ.a(614, 0, 1, false);
                break;
        }
        kmx = bi.VG();
    }

    public static void rm(int i) {
        long bI = bi.bI(kmx);
        x.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", new Object[]{Long.valueOf(bI)});
        switch (i) {
            case 1:
                h.mEJ.a(338, 40, 1, false);
                break;
        }
        if (bI < 0) {
            x.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
        } else if (bI <= 5000) {
            h.mEJ.U(338, 1, 43);
        } else if (bI <= 60000) {
            h.mEJ.U(338, 1, 44);
        } else if (bI <= 180000) {
            h.mEJ.U(338, 1, 45);
        } else {
            h.mEJ.U(338, 1, 46);
        }
    }

    public static void rn(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report download failed");
        switch (i) {
            case 0:
                h.mEJ.a(338, 41, 1, false);
                return;
            case 1:
                h.mEJ.a(338, 42, 1, false);
                return;
            case 2:
                h.mEJ.a(614, 3, 1, false);
                return;
            default:
                return;
        }
    }

    public static void fK(boolean z) {
        x.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        h.mEJ.U(338, 2, 71);
        if (z) {
            h.mEJ.a(338, 7, 1, true);
        }
    }

    public static void ro(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i) {
            case -26:
                h.mEJ.a(338, 83, 1, false);
                return;
            case -25:
                h.mEJ.a(338, 82, 1, false);
                return;
            case -24:
                h.mEJ.a(338, 81, 1, false);
                return;
            case -23:
                h.mEJ.a(338, 79, 1, false);
                return;
            case -22:
                h.mEJ.a(338, 80, 1, false);
                return;
            case -21:
                h.mEJ.a(338, 77, 1, false);
                return;
            case -20:
                h.mEJ.a(338, 76, 1, false);
                return;
            case WebViewClient.ERROR_IO /*-7*/:
                h.mEJ.a(338, 84, 1, false);
                return;
            case WebViewClient.ERROR_CONNECT /*-6*/:
                h.mEJ.a(338, 78, 1, false);
                return;
            case WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                h.mEJ.a(338, 85, 1, false);
                return;
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                h.mEJ.a(338, 74, 1, false);
                return;
            case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                h.mEJ.a(338, 73, 1, false);
                return;
            case -2:
                h.mEJ.a(338, 75, 1, false);
                return;
            case -1:
                h.mEJ.a(338, 72, 1, false);
                return;
            default:
                return;
        }
    }

    public static void N(Intent intent) {
        KVCommCrossProcessReceiver.brK();
        x.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            h.mEJ.U(338, 6, 127);
        } else if (ShareIntentUtil.j(intent, "patch_path_extra") == null) {
            h.mEJ.U(338, 6, MapRouteSectionWithName.kMaxRoadNameLength);
        } else {
            h.mEJ.a(338, 6, 1, true);
        }
    }

    public static void l(long j, boolean z) {
        if (z) {
            h.mEJ.a(338, 3, 1, true);
        }
        if (z) {
            h.mEJ.a(338, 101, 1, false);
        } else {
            h.mEJ.a(338, 103, 1, false);
        }
        x.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", new Object[]{Long.valueOf(j)});
        if (j < 0) {
            x.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
        } else if (j <= 5000) {
            if (z) {
                h.mEJ.a(338, 117, 1, false);
            } else {
                h.mEJ.a(338, 122, 1, false);
            }
        } else if (j <= 10000) {
            if (z) {
                h.mEJ.a(338, 118, 1, false);
            } else {
                h.mEJ.a(338, 123, 1, false);
            }
        } else if (j <= 30000) {
            if (z) {
                h.mEJ.a(338, 119, 1, false);
            } else {
                h.mEJ.a(338, 124, 1, false);
            }
        } else if (j > 60000) {
            if (j >= 3600000) {
                h.mEJ.a(338, 133, 1, false);
            }
            if (z) {
                h.mEJ.a(338, 121, 1, false);
            } else {
                h.mEJ.a(338, 126, 1, false);
            }
        } else if (z) {
            h.mEJ.a(338, 120, 1, false);
        } else {
            h.mEJ.a(338, 125, 1, false);
        }
    }

    public static void rp(int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        switch (i) {
            case WebViewClient.ERROR_TIMEOUT /*-8*/:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, 131);
                return;
            case WebViewClient.ERROR_IO /*-7*/:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, 113);
                return;
            case WebViewClient.ERROR_CONNECT /*-6*/:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, 112);
                return;
            case WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, i$l.AppCompatTheme_switchStyle);
                return;
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, i$l.AppCompatTheme_spinnerStyle);
                return;
            case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, i$l.AppCompatTheme_seekBarStyle);
                return;
            case -2:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, 129);
                return;
            case -1:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, i$l.AppCompatTheme_ratingBarStyleSmall);
                return;
            default:
                return;
        }
    }

    public static void d(Throwable th) {
        h.mEJ.a(338, 104, 1, false);
        h.mEJ.c("Tinker", "Tinker Exception:apply tinker occur unknown exception " + ak.j(th), null);
    }

    public static void e(Throwable th) {
        if (th.getMessage().contains("checkDexOptExist failed")) {
            h.mEJ.a(338, 134, 1, false);
        } else if (th.getMessage().contains("checkDexOptFormat failed")) {
            h.mEJ.a(338, 135, 1, false);
            h.mEJ.c("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + ak.j(th), null);
        } else {
            h.mEJ.a(338, 105, 1, false);
            h.mEJ.c("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + ak.j(th), null);
        }
    }

    public static void aWl() {
        h.mEJ.a(338, 106, 1, false);
    }

    public static void aWm() {
        h.mEJ.a(338, 116, 1, false);
    }

    public static void rq(int i) {
        switch (i) {
            case 1:
                h.mEJ.a(338, 130, 1, false);
                return;
            case 3:
                h.mEJ.a(338, 114, 1, false);
                return;
            case 5:
                h.mEJ.a(338, 115, 1, false);
                return;
            case 6:
                h.mEJ.a(338, 132, 1, false);
                return;
            case 7:
                h.mEJ.a(338, 136, 1, false);
                return;
            default:
                return;
        }
    }

    public static void m(long j, boolean z) {
        h.mEJ.a(338, 4, 1, false);
        if (z) {
            x.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", new Object[]{Long.valueOf(j)});
            if (j < 0) {
                x.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
                return;
            } else if (j <= 500) {
                h.mEJ.a(338, 177, 1, false);
                return;
            } else if (j <= 1000) {
                h.mEJ.a(338, 178, 1, false);
                return;
            } else if (j <= 3000) {
                h.mEJ.a(338, 179, 1, false);
                return;
            } else if (j <= 5000) {
                h.mEJ.a(338, 180, 1, false);
                return;
            } else {
                h.mEJ.a(338, 181, 1, false);
                return;
            }
        }
        h.mEJ.a(338, 159, 1, false);
    }

    public static void a(Throwable th, int i) {
        boolean z = false;
        switch (i) {
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                h.mEJ.a(338, 188, 1, false);
                break;
            case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                if (!th.getMessage().contains("checkResInstall failed")) {
                    h.mEJ.a(338, 184, 1, false);
                    break;
                }
                h.mEJ.a(338, 190, 1, false);
                z = true;
                break;
            case -2:
                if (!th.getMessage().contains("checkDexInstall failed")) {
                    h.mEJ.a(338, 161, 1, false);
                    x.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                }
                h.mEJ.a(338, 189, 1, false);
                x.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                z = true;
                break;
            case -1:
                h.mEJ.a(338, 160, 1, false);
                break;
        }
        if (!z) {
            String j = ak.j(th);
            if (i == -4) {
                Context context = ad.getContext();
                String hY = SharePatchFileUtil.hY(context);
                if (!ShareTinkerInternals.oW(hY)) {
                    j = "tinker checkSafeModeCount fail:\n" + hY;
                    SharePatchFileUtil.aj(SharePatchFileUtil.hX(context));
                }
            }
            h.mEJ.c("Tinker", "Tinker Exception:load tinker occur exception " + j, null);
        }
    }

    public static void j(boolean z, int i) {
        x.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", new Object[]{Integer.valueOf(i)});
        if (z) {
            h.mEJ.a(338, 170, 1, false);
        }
        switch (i) {
            case WebViewClient.ERROR_TIMEOUT /*-8*/:
                h.mEJ.U(338, 169, 186);
                return;
            case WebViewClient.ERROR_IO /*-7*/:
                h.mEJ.U(338, 169, 176);
                return;
            case WebViewClient.ERROR_CONNECT /*-6*/:
                h.mEJ.U(338, 169, 175);
                return;
            case WebViewClient.ERROR_PROXY_AUTHENTICATION /*-5*/:
                h.mEJ.U(338, 169, 174);
                return;
            case WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                h.mEJ.U(338, 169, 173);
                return;
            case WebViewClient.ERROR_UNSUPPORTED_AUTH_SCHEME /*-3*/:
                h.mEJ.U(338, 169, 172);
                return;
            case -2:
                h.mEJ.U(338, i$l.AppCompatTheme_ratingBarStyleIndicator, 182);
                return;
            case -1:
                h.mEJ.U(338, 169, 171);
                return;
            default:
                return;
        }
    }

    public static void rr(int i) {
        switch (i) {
            case 1:
                h.mEJ.a(338, 166, 1, false);
                return;
            case 2:
                h.mEJ.a(338, 167, 1, false);
                return;
            case 3:
                h.mEJ.a(338, 164, 1, false);
                return;
            case 4:
                h.mEJ.a(338, 183, 1, false);
                return;
            case 5:
                h.mEJ.a(338, 165, 1, false);
                return;
            case 6:
                h.mEJ.a(338, 187, 1, false);
                return;
            default:
                return;
        }
    }

    public static void rs(int i) {
        switch (i) {
            case 3:
                h.mEJ.a(338, 162, 1, false);
                return;
            case 5:
                h.mEJ.a(338, 163, 1, false);
                return;
            case 6:
                h.mEJ.a(338, 185, 1, false);
                return;
            default:
                return;
        }
    }

    public static void aWn() {
        h.mEJ.a(338, 168, 1, false);
    }

    public static void aWo() {
        h.mEJ.a(338, 5, 1, false);
    }

    public static void c(int i, Throwable th) {
        switch (i) {
            case 0:
                h.mEJ.a(338, 193, 1, false);
                return;
            case 1:
                h.mEJ.a(338, 191, 1, false);
                h.mEJ.c("Tinker", "Tinker Exception:interpret occur instruction exception " + ak.j(th), null);
                return;
            case 2:
                h.mEJ.a(338, 192, 1, false);
                h.mEJ.c("Tinker", "Tinker Exception:interpret occur command exception " + ak.j(th), null);
                return;
            default:
                return;
        }
    }
}
