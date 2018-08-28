package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.model.g.2;
import com.tencent.mm.plugin.game.wepkg.model.g.3;
import com.tencent.mm.plugin.game.wepkg.utils.b;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.rtmp.TXLiveConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class f {

    public interface a {
        void L(JSONObject jSONObject);
    }

    static /* synthetic */ boolean a(File file, Map map) {
        if (file == null || !file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            return false;
        }
        for (File file2 : listFiles) {
            File[] listFiles2 = file2.listFiles();
            if (!(listFiles2 == null || listFiles2.length == 0)) {
                List arrayList = new ArrayList();
                for (File file3 : listFiles2) {
                    c cVar = new c((byte) 0);
                    cVar.version = file3.getName();
                    String str = file3.getAbsolutePath() + File.separator + "package";
                    if (e.cn(str)) {
                        cVar.kfy = str;
                    }
                    File file4 = new File(file3.getAbsolutePath() + File.separator + "preload_files");
                    if (file4.isDirectory()) {
                        File[] listFiles3 = file4.listFiles();
                        if (listFiles3 == null || listFiles3.length == 0) {
                            arrayList.add(cVar);
                        } else {
                            List arrayList2 = new ArrayList();
                            for (File name : listFiles3) {
                                arrayList2.add(name.getName());
                            }
                            cVar.kfz = arrayList2;
                            arrayList.add(cVar);
                        }
                    } else {
                        arrayList.add(cVar);
                    }
                }
                map.put(file2.getName(), arrayList);
            }
        }
        return true;
    }

    public static synchronized e Eh(String str) {
        e eVar;
        synchronized (f.class) {
            String Eu = d.Eu(str);
            String Ev = d.Ev(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (bi.oW(Eu) || bi.oW(Ev)) {
                x.e("MicroMsg.Wepkg.WepkgManager", "pkgId = %s, domain = %s", new Object[]{Eu, Ev});
                eVar = null;
            } else {
                eVar = b.kgk.Er(Eu);
                if (eVar == null || eVar.kff == null || !Ev.equalsIgnoreCase(eVar.kff.cfx)) {
                    h.mEJ.a(859, 6, 1, false);
                    WepkgVersion En = g.En(Eu);
                    if (En == null) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "DB dont have valid record, pkgid:%s, domain:%s, version:%s:", new Object[]{Eu, "", ""});
                        com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", str, Eu, null, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(14));
                        h.mEJ.a(859, 7, 1, false);
                        eVar = null;
                    } else if (!Ev.equalsIgnoreCase(En.cfx)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "the domain not match, pkgid:%s, version:%s, UrlDomain[%s] != DBDomain[%s]", new Object[]{Eu, En.version, Ev, En.cfx});
                        com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", str, Eu, null, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(13));
                        h.mEJ.a(859, 8, 1, false);
                        eVar = null;
                    } else if (bi.oW(En.version)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "this pkgid(%s) is disable form server", new Object[]{Eu});
                        com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", str, Eu, null, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(15));
                        h.mEJ.a(859, 9, 1, false);
                        eVar = null;
                    } else if (!En.kfX || (!En.kfY && En.kfZ)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "local cache disable, pkgid:%s, version:%s, bigPackageReady:%s, preloadFilesReady:%s, preloadFilesAtomic:%s", new Object[]{En.kfA, En.version, Boolean.valueOf(En.kfX), Boolean.valueOf(En.kfY), Boolean.valueOf(En.kfZ)});
                        com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", str, Eu, En.version, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(16));
                        h.mEJ.a(859, 10, 1, false);
                        eVar = null;
                    } else {
                        d dVar;
                        String str2 = En.version;
                        String str3 = En.ffK;
                        String str4 = En.bKg;
                        int i = En.kfV;
                        if (bi.oW(Eu) || bi.oW(str3) || bi.oW(str4)) {
                            x.i("MicroMsg.Wepkg.WepkgManager", "pkgid or pkgPath or md5 is null, pkg invalid");
                            dVar = null;
                        } else {
                            File file = new File(str3);
                            if (!file.exists()) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, pkgPath:%s, file dont exist", new Object[]{str3});
                                El(Eu);
                                com.tencent.mm.plugin.game.wepkg.utils.a.b("PkgModified", null, Eu, str2, 1, 0, null);
                                dVar = null;
                            } else if (file.length() != ((long) i)) {
                                x.i("MicroMsg.Wepkg.WepkgManager", "readCacheWepkg, [server_pkgSize:%d] != [local_pkgSize:%d]", new Object[]{Integer.valueOf(i), Long.valueOf(file.length())});
                                file.delete();
                                El(Eu);
                                com.tencent.mm.plugin.game.wepkg.utils.a.b("PkgModified", null, Eu, str2, 2, 0, null);
                                dVar = null;
                            } else {
                                if (file.length() <= 5242880) {
                                    if (!str4.equalsIgnoreCase(g.m(file))) {
                                        x.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage, [server_md5:%s] != [local_md5:%s]", new Object[]{str4, g.m(file)});
                                        file.delete();
                                        El(Eu);
                                        com.tencent.mm.plugin.game.wepkg.utils.a.b("PkgModified", null, Eu, str2, 3, 0, null);
                                        dVar = null;
                                    }
                                } else {
                                    x.i("MicroMsg.Wepkg.WepkgManager", "readCacheBigPackage fileLength(%d) > checkSize(%d). dont check md5", new Object[]{Long.valueOf(file.length()), Long.valueOf(5242880)});
                                }
                                d dVar2 = new d(file);
                                if (!dVar2.fgX || dVar2.kfc == null) {
                                    Ei(Eu);
                                    dVar = null;
                                } else {
                                    dVar = dVar2;
                                }
                            }
                        }
                        if (dVar != null || bi.oW(En.ffK)) {
                            Map aB = aB(Eu, En.kfZ);
                            if (aB == null) {
                                com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", str, Eu, En.version, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(18));
                                h.mEJ.a(859, 11, 1, false);
                                eVar = null;
                            } else {
                                eVar = new e(En, dVar, aB);
                                b.kgk.kgm.put(Eu, eVar);
                                x.i("MicroMsg.Wepkg.WepkgManager", "loadWepkg time:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                h.mEJ.a(859, 12, 1, false);
                            }
                        } else {
                            com.tencent.mm.plugin.game.wepkg.utils.a.b("EnterWeb", str, Eu, En.version, 0, 0, com.tencent.mm.plugin.game.wepkg.utils.a.rd(17));
                            h.mEJ.a(859, 11, 1, false);
                            eVar = null;
                        }
                    }
                } else {
                    x.i("MicroMsg.Wepkg.WepkgManager", "memory has pkgid:%s record, version:%s", new Object[]{eVar.kff.kfA, eVar.kff.version});
                }
            }
        }
        return eVar;
    }

    public static void Ei(String str) {
        x.i("MicroMsg.Wepkg.WepkgManager", "clear all wepkg info, pkgid:%s", new Object[]{str});
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = TXLiveConstants.PLAY_EVT_CONNECT_SUCC;
        wepkgCrossProcessTask.kff.kfA = str;
        if (ad.cic()) {
            d.Em().H(new 2(wepkgCrossProcessTask));
            return;
        }
        wepkgCrossProcessTask.fFC = new 3(wepkgCrossProcessTask);
        wepkgCrossProcessTask.ahA();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    public static void Ej(String str) {
        Parcelable bundle = new Bundle(1);
        bundle.putString("call_pkg_id", str);
        com.tencent.mm.ipcinvoker.f.a("com.tencent.mm:tools", bundle, b.class, new 1(str));
    }

    private static Map<String, WepkgPreloadFile> aB(String str, boolean z) {
        if (bi.oW(str)) {
            return null;
        }
        Map<String, WepkgPreloadFile> hashMap = new HashMap();
        List<WepkgPreloadFile> Ep = g.Ep(str);
        if (bi.cX(Ep)) {
            return hashMap;
        }
        Object obj = null;
        for (WepkgPreloadFile wepkgPreloadFile : Ep) {
            if (wepkgPreloadFile != null) {
                if (bi.oW(wepkgPreloadFile.filePath)) {
                    x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath is null, isAtomic:%s", new Object[]{Boolean.valueOf(z)});
                    if (z) {
                        dg(wepkgPreloadFile.kfA, wepkgPreloadFile.kfk);
                        obj = 1;
                    } else {
                        g.a(str, wepkgPreloadFile.kfk, "", null);
                    }
                } else {
                    File file = new File(wepkgPreloadFile.filePath);
                    if (!file.exists()) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, pkgPath:%s, file dont exist, isAtomic:%s", new Object[]{wepkgPreloadFile.filePath, Boolean.valueOf(z)});
                        if (z) {
                            dg(wepkgPreloadFile.kfA, wepkgPreloadFile.kfk);
                            obj = 1;
                        } else {
                            g.a(str, wepkgPreloadFile.kfk, "", null);
                        }
                    } else if (file.length() != ((long) wepkgPreloadFile.size)) {
                        x.i("MicroMsg.Wepkg.WepkgManager", "readCachePreloadFiles, [server_pkgSize:%d] != [local_pkgSize:%d], isAtomic:%s", new Object[]{Integer.valueOf(wepkgPreloadFile.size), Long.valueOf(file.length()), Boolean.valueOf(z)});
                        if (z) {
                            dg(wepkgPreloadFile.kfA, wepkgPreloadFile.kfk);
                            file.delete();
                            obj = 1;
                        } else {
                            g.a(str, wepkgPreloadFile.kfk, "", null);
                        }
                    } else {
                        hashMap.put(wepkgPreloadFile.kfk, wepkgPreloadFile);
                    }
                }
            }
        }
        return obj != null ? null : hashMap;
    }

    public static boolean Ek(String str) {
        try {
            File file = new File(str);
            File file2 = new File(file.getParent(), file.getName() + "_temp");
            if (file.renameTo(file2)) {
                e.k(file2);
                return true;
            }
        } catch (Exception e) {
            x.i("MicroMsg.Wepkg.WepkgManager", "safeDeleteDir err:" + e.getMessage());
        }
        return false;
    }

    public static void a(a aVar) {
        String str = b.OBJECT_ROOT_DIR_PATH;
        File file = new File(str);
        if (!(file.exists() && file.isDirectory())) {
            aVar.L(null);
        }
        WepkgCrossProcessTask wepkgCrossProcessTask = new WepkgCrossProcessTask();
        wepkgCrossProcessTask.nc = TXLiveConstants.PUSH_EVT_CONNECT_SUCC;
        wepkgCrossProcessTask.fFC = new 3(wepkgCrossProcessTask, str, file, aVar);
        wepkgCrossProcessTask.ahA();
        WepkgMainProcessService.a(wepkgCrossProcessTask);
    }

    private static void El(String str) {
        if (!bi.oW(str)) {
            g.a(str, "", false, new 4());
        }
    }

    private static void dg(String str, String str2) {
        if (!bi.oW(str) && !bi.oW(str2)) {
            g.a(str, str2, "", new 6(str, new a() {
                public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
                }
            }));
        }
    }
}
