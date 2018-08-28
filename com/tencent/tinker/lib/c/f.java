package com.tencent.tinker.lib.c;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.tencent.tinker.lib.service.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.IOException;

public final class f extends a {
    public final boolean a(Context context, String str, a aVar) {
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(context);
        File file = new File(str);
        if (!ShareTinkerInternals.In(hL.tinkerFlags) || !ShareTinkerInternals.ib(context)) {
            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch is disabled, just return", new Object[0]);
            return false;
        } else if (SharePatchFileUtil.ah(file)) {
            ShareSecurityCheck shareSecurityCheck = new ShareSecurityCheck(context);
            int a = ShareTinkerInternals.a(context, hL.tinkerFlags, file, shareSecurityCheck);
            if (a != 0) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchPackageCheckFail", new Object[0]);
                hL.vsz.d(file, a);
                return false;
            }
            String ak = SharePatchFileUtil.ak(file);
            if (ak == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch md5 is null, just return", new Object[0]);
                return false;
            }
            SharePatchInfo sharePatchInfo;
            aVar.vsp = ak;
            com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchMd5:%s", new Object[]{ak});
            String absolutePath = hL.vsw.getAbsolutePath();
            File acU = SharePatchFileUtil.acU(absolutePath);
            File acT = SharePatchFileUtil.acT(absolutePath);
            SharePatchInfo n = SharePatchInfo.n(acT, acU);
            if (n == null) {
                sharePatchInfo = new SharePatchInfo("", ak, Build.FINGERPRINT, "odex");
            } else if (n.vvF == null || n.vvG == null || n.vsJ == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchInfoCorrupted", new Object[0]);
                hL.vsz.a(file, n.vvF, n.vvG);
                return false;
            } else if (SharePatchFileUtil.acX(ak)) {
                sharePatchInfo = new SharePatchInfo(n.vvF, ak, Build.FINGERPRINT, n.vsJ.equals("interpet") ? "changing" : n.vsJ);
            } else {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:onPatchVersionCheckFail md5 %s is valid", new Object[]{ak});
                hL.vsz.a(file, n, ak);
                return false;
            }
            absolutePath = absolutePath + "/" + SharePatchFileUtil.acV(ak);
            com.tencent.tinker.lib.f.a.i("Tinker.UpgradePatch", "UpgradePatch tryPatch:patchVersionDirectory:%s", new Object[]{absolutePath});
            File file2 = new File(absolutePath + "/" + SharePatchFileUtil.acW(ak));
            try {
                if (!ak.equals(SharePatchFileUtil.ak(file2))) {
                    SharePatchFileUtil.l(file, file2);
                    com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch copy patch file, src file: %s size: %d, dest file: %s size:%d", new Object[]{file.getAbsolutePath(), Long.valueOf(file.length()), file2.getAbsolutePath(), Long.valueOf(file2.length())});
                }
                if (d.a(hL, shareSecurityCheck, context, absolutePath, file2)) {
                    String str2;
                    boolean z;
                    if (ShareTinkerInternals.Ik(hL.tinkerFlags)) {
                        str2 = (String) shareSecurityCheck.vvS.get("assets/so_meta.txt");
                        if (str2 == null) {
                            com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not contained", new Object[0]);
                            z = true;
                        } else {
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            z = c.a(context, absolutePath + "/lib/", str2, file2);
                            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
                            com.tencent.tinker.lib.f.a.i("Tinker.BsDiffPatchInternal", "recover lib result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime)});
                        }
                    } else {
                        com.tencent.tinker.lib.f.a.w("Tinker.BsDiffPatchInternal", "patch recover, library is not enabled", new Object[0]);
                        z = true;
                    }
                    if (z) {
                        if (ShareTinkerInternals.Il(hL.tinkerFlags)) {
                            str2 = (String) shareSecurityCheck.vvS.get("assets/res_meta.txt");
                            if (str2 == null || str2.length() == 0) {
                                com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not contained", new Object[0]);
                                z = true;
                            } else {
                                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                if (e.c(context, absolutePath + "/res/", str2, file2)) {
                                    z = true;
                                } else {
                                    com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                                    z = false;
                                }
                                elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                com.tencent.tinker.lib.f.a.i("Tinker.ResDiffPatchInternal", "recover resource result:%b, cost:%d", new Object[]{Boolean.valueOf(z), Long.valueOf(elapsedRealtime2)});
                            }
                        } else {
                            com.tencent.tinker.lib.f.a.w("Tinker.ResDiffPatchInternal", "patch recover, resource is not enabled", new Object[0]);
                            z = true;
                        }
                        if (!z) {
                            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch resource failed", new Object[0]);
                            return false;
                        } else if (!d.a(file, hL)) {
                            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, check dex opt file failed", new Object[0]);
                            return false;
                        } else if (SharePatchInfo.a(acT, sharePatchInfo, acU)) {
                            com.tencent.tinker.lib.f.a.w("Tinker.UpgradePatch", "UpgradePatch tryPatch: done, it is ok", new Object[0]);
                            return true;
                        } else {
                            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, rewrite patch info failed", new Object[0]);
                            hL.vsz.a(file, sharePatchInfo.vvF, sharePatchInfo.vvG);
                            return false;
                        }
                    }
                    com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch library failed", new Object[0]);
                    return false;
                }
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:new patch recover, try patch dex failed", new Object[0]);
                return false;
            } catch (IOException e) {
                com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:copy patch file fail from %s to %s", new Object[]{file.getPath(), file2.getPath()});
                hL.vsz.a(file, file2, file.getName(), 1);
                return false;
            }
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.UpgradePatch", "UpgradePatch tryPatch:patch file is not found, just return", new Object[0]);
            return false;
        }
    }
}
