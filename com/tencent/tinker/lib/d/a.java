package com.tencent.tinker.lib.d;

import android.content.Context;
import com.tencent.tinker.lib.e.d;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import org.xwalk.core.XWalkResourceClient;

public class a implements c {
    public final Context context;

    public a(Context context) {
        this.context = context;
    }

    public void c(File file, int i) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchListenerReceiveFail: patch receive fail: %s, code: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
    }

    public void a(String str, String str2, File file, String str3) {
        int i = 0;
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchVersionChanged: patch version change from " + str + " to " + str2, new Object[0]);
        if (str != null && str2 != null && !str.equals(str2) && com.tencent.tinker.lib.e.a.hL(this.context).ons) {
            com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "onLoadPatchVersionChanged, try kill all other process", new Object[0]);
            ShareTinkerInternals.ie(this.context);
            c hQ = c.hQ(this.context);
            if (!hQ.vtb) {
                com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry disabled, just return", new Object[0]);
            } else if (!hQ.vtc.exists()) {
                com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck retry file is not exist, just return", new Object[0]);
            } else if (str2 == null) {
                com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck md5 is null, just return", new Object[0]);
            } else {
                c$a ae = c$a.ae(hQ.vtc);
                if (str2.equals(ae.bKg)) {
                    com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatchRetry", "onPatchResetMaxCheck, reset max check to 1", new Object[0]);
                    ae.vtf = "1";
                    c$a.a(hQ.vtc, ae);
                }
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                int length = listFiles.length;
                while (i < length) {
                    File file2 = listFiles[i];
                    String name = file2.getName();
                    if (file2.isDirectory() && !name.equals(str3)) {
                        SharePatchFileUtil.k(file2);
                    }
                    i++;
                }
            }
        }
    }

    public void d(int i, Throwable th) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret: type: %d, throwable: %s", new Object[]{Integer.valueOf(i), th});
        switch (i) {
            case 0:
                com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret ok", new Object[0]);
                break;
            case 1:
                com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, can get instruction set from existed oat file", new Object[0]);
                break;
            case 2:
                com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadInterpret fail, command line to interpret return error", new Object[0]);
                break;
        }
        cGV();
    }

    public void a(File file, int i, boolean z) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadFileNotFound: patch file not found: %s, fileType: %d, isDirectory: %b", new Object[]{file.getAbsolutePath(), Integer.valueOf(i), Boolean.valueOf(z)});
        if (i == 4) {
            cGV();
        } else {
            cGU();
        }
    }

    public void a(File file, int i) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch load Reporter onLoadFileMd5Mismatch: patch file md5 mismatch file: %s, fileType: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        cGU();
    }

    public void a(String str, String str2, File file) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPatchInfoCorrupted: patch info file damage: %s, from version: %s to version: %s", new Object[]{file.getAbsolutePath(), str, str2});
        cGU();
    }

    public void a(File file, int i, long j) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadResult: patch load result, path:%s, code: %d, cost: %dms", new Object[]{file.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(j)});
    }

    public void a(Throwable th, int i) {
        switch (i) {
            case XWalkResourceClient.ERROR_AUTHENTICATION /*-4*/:
                com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unCatch exception: %s", new Object[]{th});
                ShareTinkerInternals.ia(this.context);
                com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "unCaught exception disable tinker forever with sp", new Object[0]);
                String hY = SharePatchFileUtil.hY(this.context);
                if (!ShareTinkerInternals.oW(hY)) {
                    SharePatchFileUtil.aj(SharePatchFileUtil.hX(this.context));
                    com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "tinker uncaught real exception:" + hY, new Object[0]);
                    break;
                }
                break;
            case -3:
                if (th.getMessage().contains("checkResInstall failed")) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker res check fail:" + th.getMessage(), new Object[0]);
                } else {
                    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load resource exception: %s", new Object[]{th});
                }
                ShareTinkerInternals.ia(this.context);
                com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "res exception disable tinker forever with sp", new Object[0]);
                break;
            case -2:
                if (th.getMessage().contains("checkDexInstall failed")) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: tinker dex check fail:" + th.getMessage(), new Object[0]);
                } else {
                    com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load dex exception: %s", new Object[]{th});
                }
                ShareTinkerInternals.ia(this.context);
                com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "dex exception disable tinker forever with sp", new Object[0]);
                break;
            case -1:
                com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadException: patch load unknown exception: %s", new Object[]{th});
                break;
        }
        com.tencent.tinker.lib.f.a.e("Tinker.DefaultLoadReporter", "tinker load exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        com.tencent.tinker.lib.f.a.printErrStackTrace("Tinker.DefaultLoadReporter", th, "tinker load exception", new Object[0]);
        com.tencent.tinker.lib.e.a.hL(this.context).tinkerFlags = 0;
        cGU();
    }

    public void b(File file, int i) {
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "patch loadReporter onLoadPackageCheckFail: load patch package check fail file path: %s, errorCode: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        cGU();
    }

    public final void cGU() {
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(this.context);
        if (hL.ons) {
            d dVar = hL.vsD;
            if (dVar.vsK) {
                SharePatchInfo sharePatchInfo = dVar.patchInfo;
                if (!(sharePatchInfo == null || ShareTinkerInternals.oW(sharePatchInfo.vvF))) {
                    com.tencent.tinker.lib.f.a.w("Tinker.DefaultLoadReporter", "checkAndCleanPatch, oldVersion %s is not null, try kill all other process", new Object[]{sharePatchInfo.vvF});
                    ShareTinkerInternals.ie(this.context);
                }
            }
        }
        hL.aWt();
    }

    public final boolean cGV() {
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(this.context);
        if (!hL.ons) {
            return false;
        }
        File file = hL.vsD.vsO;
        if (file == null || !c.hQ(this.context).acP(SharePatchFileUtil.ak(file))) {
            return false;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.DefaultLoadReporter", "try to repair oat file on patch process", new Object[0]);
        com.tencent.tinker.lib.e.c.bP(this.context, file.getAbsolutePath());
        return true;
    }
}
