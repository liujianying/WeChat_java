package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.d.a.d;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.f.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareResPatchInfo.LargeModeInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class e extends b {
    static boolean c(Context context, String str, String str2, File file) {
        Object hVar;
        Throwable th;
        Object obj;
        Object obj2;
        ShareResPatchInfo shareResPatchInfo = new ShareResPatchInfo();
        ShareResPatchInfo.a(str2, shareResPatchInfo);
        a.i("Tinker.ResDiffPatchInternal", "res dir: %s, meta: %s", new Object[]{str, shareResPatchInfo.toString()});
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(context);
        if (SharePatchFileUtil.acX(shareResPatchInfo.vvJ)) {
            File file2 = new File(str);
            File file3 = new File(file2, "res_temp");
            File file4 = new File(file2, "resources.apk");
            if (!file4.exists()) {
                file4.getParentFile().mkdirs();
            } else if (SharePatchFileUtil.h(file4, shareResPatchInfo.vvJ)) {
                a.w("Tinker.ResDiffPatchInternal", "resource file %s is already exist, and md5 match, just return true", new Object[]{file4.getPath()});
                return true;
            } else {
                a.w("Tinker.ResDiffPatchInternal", "have a mismatch corrupted resource " + file4.getPath(), new Object[0]);
                file4.delete();
            }
            try {
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                if (applicationInfo == null) {
                    a.w("Tinker.ResDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                    return false;
                }
                String str3 = applicationInfo.sourceDir;
                if (!a(context, str3, file2, file3, file, shareResPatchInfo)) {
                    return false;
                }
                try {
                    g gVar;
                    hVar = new h(new BufferedOutputStream(new FileOutputStream(file4)));
                    try {
                        gVar = new g(str3);
                    } catch (Throwable th2) {
                        th = th2;
                        obj = null;
                        obj2 = null;
                        com.tencent.tinker.c.b.a.ar(hVar);
                        com.tencent.tinker.c.b.a.ar(obj2);
                        com.tencent.tinker.c.b.a.ar(obj);
                        SharePatchFileUtil.k(file3);
                        throw th;
                    }
                    try {
                        g gVar2 = new g(file);
                        try {
                            f fVar;
                            Enumeration entries = gVar.entries();
                            int i = 0;
                            while (entries.hasMoreElements()) {
                                fVar = (f) entries.nextElement();
                                if (fVar == null) {
                                    throw new TinkerRuntimeException("zipEntry is null when get from oldApk");
                                }
                                String str4 = fVar.name;
                                if (!str4.contains("../")) {
                                    int i2;
                                    if (!ShareResPatchInfo.a(shareResPatchInfo.vvQ, str4) || shareResPatchInfo.vvL.contains(str4) || shareResPatchInfo.vvM.contains(str4) || shareResPatchInfo.vvO.contains(str4) || str4.equals("AndroidManifest.xml")) {
                                        i2 = i;
                                    } else {
                                        i.a(gVar, fVar, hVar);
                                        i2 = i + 1;
                                    }
                                    i = i2;
                                }
                            }
                            fVar = gVar.adb("AndroidManifest.xml");
                            if (fVar == null) {
                                a.w("Tinker.ResDiffPatchInternal", "manifest patch entry is null. path:AndroidManifest.xml", new Object[0]);
                                hL.vsz.a(file, file4, "AndroidManifest.xml", 6);
                                com.tencent.tinker.c.b.a.ar(hVar);
                                com.tencent.tinker.c.b.a.ar(gVar);
                                com.tencent.tinker.c.b.a.ar(gVar2);
                                SharePatchFileUtil.k(file3);
                                return false;
                            }
                            String str5;
                            f adb;
                            i.a(gVar, fVar, hVar);
                            i++;
                            Iterator it = shareResPatchInfo.vvO.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                adb = gVar.adb(str5);
                                if (adb == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "large patch entry is null. path:" + str5, new Object[0]);
                                    hL.vsz.a(file, file4, str5, 6);
                                    com.tencent.tinker.c.b.a.ar(hVar);
                                    com.tencent.tinker.c.b.a.ar(gVar);
                                    com.tencent.tinker.c.b.a.ar(gVar2);
                                    SharePatchFileUtil.k(file3);
                                    return false;
                                }
                                LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.vvP.get(str5);
                                i.a(adb, largeModeInfo.file, largeModeInfo.vvR, hVar);
                                i++;
                            }
                            it = shareResPatchInfo.vvK.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                adb = gVar2.adb(str5);
                                if (adb == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "add patch entry is null. path:" + str5, new Object[0]);
                                    hL.vsz.a(file, file4, str5, 6);
                                    com.tencent.tinker.c.b.a.ar(hVar);
                                    com.tencent.tinker.c.b.a.ar(gVar);
                                    com.tencent.tinker.c.b.a.ar(gVar2);
                                    SharePatchFileUtil.k(file3);
                                    return false;
                                }
                                if (shareResPatchInfo.vvN.containsKey(str5)) {
                                    i.a(adb, (File) shareResPatchInfo.vvN.get(str5), adb.vvR, hVar);
                                } else {
                                    i.a(gVar2, adb, hVar);
                                }
                                i++;
                            }
                            it = shareResPatchInfo.vvM.iterator();
                            while (it.hasNext()) {
                                str5 = (String) it.next();
                                adb = gVar2.adb(str5);
                                if (adb == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "mod patch entry is null. path:" + str5, new Object[0]);
                                    hL.vsz.a(file, file4, str5, 6);
                                    com.tencent.tinker.c.b.a.ar(hVar);
                                    com.tencent.tinker.c.b.a.ar(gVar);
                                    com.tencent.tinker.c.b.a.ar(gVar2);
                                    SharePatchFileUtil.k(file3);
                                    return false;
                                }
                                if (shareResPatchInfo.vvN.containsKey(str5)) {
                                    i.a(adb, (File) shareResPatchInfo.vvN.get(str5), adb.vvR, hVar);
                                } else {
                                    i.a(gVar2, adb, hVar);
                                }
                                i++;
                            }
                            gVar.cHk();
                            str5 = gVar.sla;
                            if (str5 == null) {
                                hVar.vwq = h.vwm;
                            } else {
                                byte[] bytes = str5.getBytes(d.UTF_8);
                                h.y("Comment", bytes);
                                hVar.vwq = bytes;
                            }
                            com.tencent.tinker.c.b.a.ar(hVar);
                            com.tencent.tinker.c.b.a.ar(gVar);
                            com.tencent.tinker.c.b.a.ar(gVar2);
                            SharePatchFileUtil.k(file3);
                            if (SharePatchFileUtil.h(file4, shareResPatchInfo.vvJ)) {
                                a.i("Tinker.ResDiffPatchInternal", "final new resource file:%s, entry count:%d, size:%d", new Object[]{file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length())});
                                return true;
                            }
                            a.i("Tinker.ResDiffPatchInternal", "check final new resource file fail path:%s, entry count:%d, size:%d", new Object[]{file4.getAbsolutePath(), Integer.valueOf(i), Long.valueOf(file4.length())});
                            SharePatchFileUtil.aj(file4);
                            hL.vsz.a(file, file4, "resources.apk", 6);
                            return false;
                        } catch (Throwable th3) {
                            th = th3;
                            obj = gVar2;
                            obj2 = gVar;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        obj = null;
                        g obj22 = gVar;
                        com.tencent.tinker.c.b.a.ar(hVar);
                        com.tencent.tinker.c.b.a.ar(obj22);
                        com.tencent.tinker.c.b.a.ar(obj);
                        SharePatchFileUtil.k(file3);
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    obj = null;
                    obj22 = null;
                    hVar = null;
                    com.tencent.tinker.c.b.a.ar(hVar);
                    com.tencent.tinker.c.b.a.ar(obj22);
                    com.tencent.tinker.c.b.a.ar(obj);
                    SharePatchFileUtil.k(file3);
                    throw th;
                }
            } catch (Throwable th6) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("patch " + ShareTinkerInternals.Im(6) + " extract failed (" + th6.getMessage() + ").", th6);
            }
        } else {
            a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, md5: %s", new Object[]{ShareTinkerInternals.Im(6), shareResPatchInfo.vvJ});
            hL.vsz.d(file, b.Ii(6));
            return false;
        }
    }

    private static boolean a(Context context, String str, File file, File file2, File file3, ShareResPatchInfo shareResPatchInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.tinker.lib.e.a hL = com.tencent.tinker.lib.e.a.hL(context);
        ZipFile zipFile = null;
        ZipFile zipFile2 = null;
        ZipFile zipFile3;
        ZipFile zipFile4;
        Throwable th;
        try {
            zipFile3 = new ZipFile(str);
            try {
                Object obj;
                Object obj2;
                ZipEntry entry = zipFile3.getEntry("resources.arsc");
                File file4 = new File(file, "resources.arsc");
                if (entry == null) {
                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:resources.arsc", new Object[0]);
                    hL.vsz.a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                }
                if (!String.valueOf(entry.getCrc()).equals(shareResPatchInfo.vvI)) {
                    a.e("Tinker.ResDiffPatchInternal", "resources.arsc's crc is not equal, expect crc: %s, got crc: %s", new Object[]{shareResPatchInfo.vvI, String.valueOf(entry.getCrc())});
                    hL.vsz.a(file3, file4, "resources.arsc", 6);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return false;
                } else if (shareResPatchInfo.vvO.isEmpty() && shareResPatchInfo.vvN.isEmpty()) {
                    a.i("Tinker.ResDiffPatchInternal", "no large modify or store resources, just return", new Object[0]);
                    SharePatchFileUtil.a(zipFile3);
                    SharePatchFileUtil.a(null);
                    return true;
                } else {
                    zipFile4 = new ZipFile(file3);
                    try {
                        String str2;
                        for (String str22 : shareResPatchInfo.vvN.keySet()) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            File file5 = new File(file2, str22);
                            SharePatchFileUtil.al(file5);
                            ZipEntry entry2 = zipFile4.getEntry(str22);
                            if (entry2 == null) {
                                a.w("Tinker.ResDiffPatchInternal", "store patch entry is null. path:" + str22, new Object[0]);
                                hL.vsz.a(file3, file5, str22, 6);
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            a(zipFile4, entry2, file5, null, false);
                            if (entry2.getSize() != file5.length()) {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file size mismatch, type:%s, name: %s, patch size: %d, file size; %d", new Object[]{ShareTinkerInternals.Im(6), str22, Long.valueOf(entry2.getSize()), Long.valueOf(file5.length())});
                                hL.vsz.d(file3, b.Ii(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            shareResPatchInfo.vvN.put(str22, file5);
                            a.w("Tinker.ResDiffPatchInternal", "success recover store file:%s, file size:%d, use time:%d", new Object[]{file5.getPath(), Long.valueOf(file5.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2)});
                        }
                        Iterator it = shareResPatchInfo.vvO.iterator();
                        while (it.hasNext()) {
                            str22 = (String) it.next();
                            long currentTimeMillis3 = System.currentTimeMillis();
                            LargeModeInfo largeModeInfo = (LargeModeInfo) shareResPatchInfo.vvP.get(str22);
                            if (largeModeInfo == null) {
                                a.w("Tinker.ResDiffPatchInternal", "resource not found largeModeInfo, type:%s, name: %s", new Object[]{ShareTinkerInternals.Im(6), str22});
                                hL.vsz.d(file3, b.Ii(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                            largeModeInfo.file = new File(file2, str22);
                            SharePatchFileUtil.al(largeModeInfo.file);
                            if (SharePatchFileUtil.acX(largeModeInfo.bKg)) {
                                ZipEntry entry3 = zipFile4.getEntry(str22);
                                if (entry3 == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "large mod patch entry is null. path:" + str22, new Object[0]);
                                    hL.vsz.a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                ZipEntry entry4 = zipFile3.getEntry(str22);
                                if (entry4 == null) {
                                    a.w("Tinker.ResDiffPatchInternal", "resources apk entry is null. path:" + str22, new Object[0]);
                                    hL.vsz.a(file3, largeModeInfo.file, str22, 6);
                                    SharePatchFileUtil.a(zipFile3);
                                    SharePatchFileUtil.a(zipFile4);
                                    return false;
                                }
                                obj = null;
                                Object obj3 = null;
                                try {
                                    obj = zipFile3.getInputStream(entry4);
                                    InputStream inputStream = zipFile4.getInputStream(entry3);
                                    try {
                                        com.tencent.tinker.b.a.a(obj, inputStream, largeModeInfo.file);
                                        com.tencent.tinker.c.b.a.ar(obj);
                                        com.tencent.tinker.c.b.a.ar(inputStream);
                                        if (SharePatchFileUtil.f(largeModeInfo.file, largeModeInfo.bKg)) {
                                            a.w("Tinker.ResDiffPatchInternal", "success recover large modify file:%s, file size:%d, use time:%d", new Object[]{largeModeInfo.file.getPath(), Long.valueOf(largeModeInfo.file.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis3)});
                                        } else {
                                            a.w("Tinker.ResDiffPatchInternal", "Failed to recover large modify file:%s", new Object[]{largeModeInfo.file.getPath()});
                                            SharePatchFileUtil.aj(largeModeInfo.file);
                                            hL.vsz.a(file3, largeModeInfo.file, str22, 6);
                                            SharePatchFileUtil.a(zipFile3);
                                            SharePatchFileUtil.a(zipFile4);
                                            return false;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        InputStream obj22 = inputStream;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj22 = obj3;
                                }
                            } else {
                                a.w("Tinker.ResDiffPatchInternal", "resource meta file md5 mismatch, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.Im(6), str22, largeModeInfo.bKg});
                                hL.vsz.d(file3, b.Ii(6));
                                SharePatchFileUtil.a(zipFile3);
                                SharePatchFileUtil.a(zipFile4);
                                return false;
                            }
                        }
                        a.w("Tinker.ResDiffPatchInternal", "success recover all large modify and store resources use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                        SharePatchFileUtil.a(zipFile3);
                        SharePatchFileUtil.a(zipFile4);
                        return true;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                }
                com.tencent.tinker.c.b.a.ar(obj);
                com.tencent.tinker.c.b.a.ar(obj22);
                throw th;
            } catch (Throwable th5) {
                th = th5;
                zipFile4 = null;
                SharePatchFileUtil.a(zipFile3);
                SharePatchFileUtil.a(zipFile4);
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            zipFile4 = null;
            zipFile3 = null;
            SharePatchFileUtil.a(zipFile3);
            SharePatchFileUtil.a(zipFile4);
            throw th;
        }
    }
}
