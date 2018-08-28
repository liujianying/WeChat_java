package com.tencent.tinker.lib.d;

import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.lib.f.c;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.util.List;

public class b implements d {
    private static boolean vsn = false;
    protected final Context context;

    public b(Context context) {
        this.context = context;
    }

    public void O(Intent intent) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchServiceStart: patch service start", new Object[0]);
        vsn = false;
        c hQ = c.hQ(this.context);
        if (!hQ.vtb) {
            a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry disabled, just return", new Object[0]);
        } else if (intent == null) {
            a.e("Tinker.UpgradePatchRetry", "onPatchServiceStart intent is null, just return", new Object[0]);
        } else {
            String aB = TinkerPatchService.aB(intent);
            if (aB == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch path is null, just return", new Object[0]);
                return;
            }
            File file = new File(aB);
            String ak = SharePatchFileUtil.ak(file);
            if (ak == null) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart patch md5 is null, just return", new Object[0]);
                return;
            }
            c$a ae;
            if (hQ.vtc.exists()) {
                ae = c$a.ae(hQ.vtc);
                if (ae.bKg == null || ae.vtf == null || !ak.equals(ae.bKg)) {
                    hQ.ad(file);
                    ae.bKg = ak;
                    ae.vtf = "1";
                } else {
                    int parseInt = Integer.parseInt(ae.vtf);
                    if (parseInt >= hQ.vte) {
                        SharePatchFileUtil.aj(hQ.vtd);
                        a.w("Tinker.UpgradePatchRetry", "onPatchServiceStart retry more than max count, delete retry info file!", new Object[0]);
                        return;
                    }
                    ae.vtf = String.valueOf(parseInt + 1);
                }
            } else {
                hQ.ad(file);
                ae = new c$a(ak, "1");
            }
            c$a.a(hQ.vtc, ae);
        }
    }

    public void d(File file, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchPackageCheckFail: package check failed. path: %s, code: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(i)});
        if (i == -3 || i == -4 || i == -8) {
            com.tencent.tinker.lib.e.a.hL(this.context).ac(file);
        }
    }

    public void a(File file, SharePatchInfo sharePatchInfo, String str) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchVersionCheckFail: patch version exist. path: %s, version: %s", new Object[]{file.getAbsolutePath(), str});
    }

    public void a(File file, File file2, String str, int i) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchTypeExtractFail: file extract fail type: %s, path: %s, extractTo: %s, filename: %s", new Object[]{ShareTinkerInternals.Im(i), file.getPath(), file2.getPath(), str});
        com.tencent.tinker.lib.e.a.hL(this.context).ac(file);
    }

    public void a(File file, List<File> list, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchDexOptFail: dex opt fail path: %s, dex size: %d", new Object[]{file.getAbsolutePath(), Integer.valueOf(list.size())});
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "onPatchDexOptFail:", new Object[0]);
        if (th.getMessage().contains("checkDexOptExist failed") || th.getMessage().contains("checkDexOptFormat failed")) {
            vsn = true;
            for (File aj : list) {
                SharePatchFileUtil.aj(aj);
            }
            return;
        }
        com.tencent.tinker.lib.e.a.hL(this.context).ac(file);
    }

    public void a(File file, boolean z, long j) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchResult: patch all result path: %s, success: %b, cost: %d", new Object[]{file.getAbsolutePath(), Boolean.valueOf(z), Long.valueOf(j)});
        if (!vsn) {
            c hQ = c.hQ(this.context);
            if (!hQ.vtb) {
                a.w("Tinker.UpgradePatchRetry", "onPatchServiceResult retry disabled, just return", new Object[0]);
            } else if (hQ.vtd.exists()) {
                SharePatchFileUtil.aj(hQ.vtd);
            }
        }
    }

    public void a(File file, String str, String str2) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchInfoCorrupted: patch info is corrupted. old: %s, new: %s", new Object[]{str, str2});
        com.tencent.tinker.lib.e.a.hL(this.context).aWt();
    }

    public void a(File file, Throwable th) {
        a.i("Tinker.DefaultPatchReporter", "patchReporter onPatchException: patch exception path: %s, throwable: %s", new Object[]{file.getAbsolutePath(), th.getMessage()});
        a.e("Tinker.DefaultPatchReporter", "tinker patch exception, welcome to submit issue to us: https://github.com/Tencent/tinker/issues", new Object[0]);
        a.printErrStackTrace("Tinker.DefaultPatchReporter", th, "tinker patch exception", new Object[0]);
        com.tencent.tinker.lib.e.a.hL(this.context).tinkerFlags = 0;
        com.tencent.tinker.lib.e.a.hL(this.context).ac(file);
    }
}
