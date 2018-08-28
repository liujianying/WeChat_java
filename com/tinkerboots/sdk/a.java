package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.File;

public final class a {
    public static a vFU;
    private final ApplicationLike applicationLike;
    public final com.tencent.tinker.lib.e.a vFV;
    public final com.tinkerboots.sdk.a.a vFW;

    public a(Context context, ApplicationLike applicationLike, c cVar, d dVar, b bVar, com.tencent.tinker.lib.c.a aVar, Class<? extends AbstractResultService> cls, com.tinkerboots.sdk.a.a.b bVar2) {
        com.tinkerboots.sdk.b.b.context = context;
        this.applicationLike = applicationLike;
        this.vFW = com.tinkerboots.sdk.a.a.a(bVar2);
        com.tencent.tinker.lib.e.a.a aVar2 = new com.tencent.tinker.lib.e.a.a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        if (aVar2.status != -1) {
            throw new TinkerRuntimeException("tinkerFlag is already set.");
        }
        aVar2.status = tinkerFlags;
        if (cVar == null) {
            throw new TinkerRuntimeException("loadReporter must not be null.");
        } else if (aVar2.vsy != null) {
            throw new TinkerRuntimeException("loadReporter is already set.");
        } else {
            aVar2.vsy = cVar;
            if (bVar == null) {
                throw new TinkerRuntimeException("listener must not be null.");
            } else if (aVar2.vsx != null) {
                throw new TinkerRuntimeException("listener is already set.");
            } else {
                aVar2.vsx = bVar;
                if (dVar == null) {
                    throw new TinkerRuntimeException("patchReporter must not be null.");
                } else if (aVar2.vsz != null) {
                    throw new TinkerRuntimeException("patchReporter is already set.");
                } else {
                    aVar2.vsz = dVar;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                    } else if (aVar2.vsH != null) {
                        throw new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                    } else {
                        aVar2.vsH = valueOf;
                        com.tencent.tinker.lib.e.a cGX = aVar2.cGX();
                        com.tencent.tinker.lib.e.a.a(cGX);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        com.tencent.tinker.lib.e.a.vsv = true;
                        TinkerPatchService.a(aVar, cls);
                        com.tencent.tinker.lib.f.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", new Object[]{Boolean.valueOf(ShareTinkerInternals.In(cGX.tinkerFlags)), "1.9.7"});
                        if (!ShareTinkerInternals.In(cGX.tinkerFlags)) {
                            com.tencent.tinker.lib.f.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            throw new TinkerRuntimeException("intentResult must not be null.");
                        } else {
                            String acV;
                            cGX.vsD = new com.tencent.tinker.lib.e.d();
                            com.tencent.tinker.lib.e.d dVar2 = cGX.vsD;
                            com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(cGX.context);
                            dVar2.vsW = ShareIntentUtil.aE(tinkerResultIntent);
                            dVar2.grC = ShareIntentUtil.aF(tinkerResultIntent);
                            dVar2.vsM = ShareIntentUtil.q(tinkerResultIntent, "intent_patch_system_ota");
                            dVar2.vsJ = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_oat_dir");
                            dVar2.vsL = "interpet".equals(dVar2.vsJ);
                            boolean z = hL.ons;
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", new Object[]{Integer.valueOf(dVar2.vsW), ShareTinkerInternals.aC(r2), Boolean.valueOf(z), Boolean.valueOf(dVar2.vsM), Build.FINGERPRINT, dVar2.vsJ, Boolean.valueOf(dVar2.vsL)});
                            String j = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_old_version");
                            String j2 = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_new_version");
                            File file = hL.vsw;
                            File file2 = hL.vsA;
                            if (!(j == null || j2 == null)) {
                                if (z) {
                                    dVar2.vsI = j2;
                                } else {
                                    dVar2.vsI = j;
                                }
                                com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", new Object[]{j, j2, dVar2.vsI});
                                acV = SharePatchFileUtil.acV(dVar2.vsI);
                                if (!ShareTinkerInternals.oW(acV)) {
                                    dVar2.vsN = new File(file.getAbsolutePath() + "/" + acV);
                                    dVar2.vsO = new File(dVar2.vsN.getAbsolutePath(), SharePatchFileUtil.acW(dVar2.vsI));
                                    dVar2.vsP = new File(dVar2.vsN, "dex");
                                    dVar2.vsQ = new File(dVar2.vsN, "lib");
                                    dVar2.vsR = new File(dVar2.vsN, "res");
                                    dVar2.vsS = new File(dVar2.vsR, "resources.apk");
                                }
                                dVar2.patchInfo = new SharePatchInfo(j, j2, Build.FINGERPRINT, dVar2.vsJ);
                                dVar2.vsK = !j.equals(j2);
                            }
                            Throwable aG = ShareIntentUtil.aG(tinkerResultIntent);
                            if (aG == null) {
                                switch (dVar2.vsW) {
                                    case -10000:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        throw new TinkerRuntimeException("can't get the right intent return code");
                                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                                        if (dVar2.vsS != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", new Object[]{dVar2.vsS.getAbsolutePath()});
                                            hL.vsy.a(dVar2.vsS, 6);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                        throw new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                                        if (dVar2.vsN != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", new Object[]{dVar2.vsS.getAbsolutePath()});
                                            hL.vsy.a(dVar2.vsS, 6, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                                        if (dVar2.vsN != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", new Object[]{dVar2.vsR.getAbsolutePath()});
                                            hL.vsy.a(dVar2.vsR, 6, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                    case -19:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        hL.vsy.a(j, j2, file2);
                                        break;
                                    case -18:
                                        acV = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_lib_path");
                                        if (acV != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", new Object[]{acV});
                                            hL.vsy.a(new File(acV), 5, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                    case -17:
                                        if (dVar2.vsN != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", new Object[]{dVar2.vsQ.getAbsolutePath()});
                                            hL.vsy.a(dVar2.vsQ, 5, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                    case DownloadResult.CODE_URL_EMPTY /*-16*/:
                                        hL.vsy.d(2, ShareIntentUtil.aH(tinkerResultIntent));
                                        break;
                                    case DownloadResult.CODE_NETWORK_UNAVAIABLE /*-15*/:
                                        hL.vsy.d(1, ShareIntentUtil.aH(tinkerResultIntent));
                                        break;
                                    case DownloadResult.CODE_CREATE_FILE_FAILED /*-13*/:
                                        acV = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_mismatch_dex_path");
                                        if (acV != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", new Object[]{acV});
                                            hL.vsy.a(new File(acV), 3);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                    case DownloadResult.CODE_SPACE_NOT_ENOUGH /*-12*/:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case DownloadResult.CODE_RECEIVE_HTMLPAGE /*-11*/:
                                        acV = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (acV != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", new Object[]{acV});
                                            hL.vsy.a(new File(acV), 4, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                    case -10:
                                        acV = ShareIntentUtil.j(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (acV != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", new Object[]{acV});
                                            hL.vsy.a(new File(acV), 3, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                    case -9:
                                        if (dVar2.vsP != null) {
                                            com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", new Object[]{dVar2.vsP.getAbsolutePath()});
                                            hL.vsy.a(dVar2.vsP, 3, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        throw new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                    case -8:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (dVar2.vsO != null) {
                                            hL.vsy.b(dVar2.vsO, tinkerResultIntent.getIntExtra("intent_patch_package_patch_check", -10000));
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error patch package check fail , but file is null");
                                    case -7:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", new Object[]{dVar2.vsI});
                                        if (dVar2.vsO != null) {
                                            hL.vsy.a(dVar2.vsO, 1, false);
                                            break;
                                        }
                                        throw new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                    case -6:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", new Object[]{dVar2.vsI});
                                        hL.vsy.a(dVar2.vsN, 1, true);
                                        break;
                                    case -5:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        com.tencent.tinker.lib.f.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        hL.vsy.a(j, j2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        com.tencent.tinker.lib.f.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        hL.vsE = true;
                                        dVar2.vsT = ShareIntentUtil.aI(tinkerResultIntent);
                                        dVar2.vsU = ShareIntentUtil.aJ(tinkerResultIntent);
                                        dVar2.vsV = ShareIntentUtil.aK(tinkerResultIntent);
                                        if (dVar2.vsL) {
                                            hL.vsy.d(0, null);
                                        }
                                        if (z && dVar2.vsK) {
                                            hL.vsy.a(j, j2, file, dVar2.vsN.getName());
                                            break;
                                        }
                                }
                            }
                            com.tencent.tinker.lib.f.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", new Object[]{Integer.valueOf(dVar2.vsW)});
                            int i = -1;
                            switch (dVar2.vsW) {
                                case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                                    i = -4;
                                    break;
                                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                                    i = -3;
                                    break;
                                case -20:
                                    i = -1;
                                    break;
                                case DownloadResult.CODE_FILE_NOT_EXIST /*-14*/:
                                    i = -2;
                                    break;
                            }
                            hL.vsy.a(aG, i);
                            cGX.vsy.a(cGX.vsw, cGX.vsD.vsW, cGX.vsD.grC);
                            if (!cGX.vsE) {
                                com.tencent.tinker.lib.f.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.vFV = cGX;
                    }
                }
            }
        }
    }

    public static a cJC() {
        if (vFU != null) {
            return vFU;
        }
        throw new TinkerRuntimeException("you must init TinkerClient sdk first");
    }

    public final a na(boolean z) {
        int i = 1;
        if (this.vFW == null || this.vFV == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            return vFU;
        }
        Context context = com.tinkerboots.sdk.b.b.getContext();
        if (VERSION.SDK_INT >= 23) {
            int i2 = context.checkSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : 0;
            int i3 = context.checkSelfPermission("android.permission.INTERNET") == 0 ? 1 : 0;
            if (i2 == 0 || i3 == 0) {
                i = 0;
            }
        }
        if (i == 0) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            return vFU;
        } else if (ShareTinkerInternals.In(this.vFV.tinkerFlags) && ShareTinkerInternals.ib(context)) {
            if (this.vFV.ons) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new 1(this, z));
            }
            return vFU;
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            return vFU;
        }
    }

    public final a gy(String str, String str2) {
        if (this.vFW == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            return vFU;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", new Object[]{str, str2});
        this.vFW.vGd.vGe.vGf.put(str, str2);
        return vFU;
    }

    public final a Iz(int i) {
        if (this.vFW == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            return vFU;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", new Object[]{Integer.valueOf(i)});
        com.tinkerboots.sdk.a.a aVar = this.vFW;
        if (((long) i) == -1) {
            com.tencent.tinker.lib.f.a.i("Tinker.ServerClient", "Warning, disableFetchPatchUpdate", new Object[0]);
            com.tinkerboots.sdk.b.b.getContext().getSharedPreferences("patch_server_config", 0).edit().putLong("fetch_patch_last_check", -1).commit();
        } else if (i < 0 || i > 24) {
            throw new TinkerRuntimeException("hours must be between 0 and 24");
        } else {
            aVar.fqj = (((long) i) * 3600) * 1000;
        }
        return vFU;
    }
}
