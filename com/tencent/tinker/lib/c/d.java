package com.tencent.tinker.lib.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.SystemClock;
import com.tencent.tinker.d.a.f;
import com.tencent.tinker.d.a.g;
import com.tencent.tinker.d.a.h;
import com.tencent.tinker.d.a.i;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerDexOptimizer;
import com.tencent.tinker.loader.TinkerDexOptimizer.ResultCallback;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.tencent.tinker.loader.shareutil.ShareDexDiffPatchInfo;
import com.tencent.tinker.loader.shareutil.ShareElfFile;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public final class d extends b {
    private static ArrayList<File> vsh = new ArrayList();
    private static ArrayList<ShareDexDiffPatchInfo> vsi = new ArrayList();
    private static HashMap<ShareDexDiffPatchInfo, File> vsj = new HashMap();
    private static boolean vsk = ShareTinkerInternals.cHe();

    protected static boolean a(a aVar, ShareSecurityCheck shareSecurityCheck, Context context, String str, File file) {
        if (ShareTinkerInternals.Ij(aVar.tinkerFlags)) {
            String str2 = (String) shareSecurityCheck.vvS.get("assets/dex_meta.txt");
            if (str2 == null) {
                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not contained", new Object[0]);
                return true;
            }
            boolean a;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            String str3 = str + "/dex/";
            if (b(context, str3, str2, file)) {
                File[] listFiles = new File(str3).listFiles();
                List arrayList = new ArrayList();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            arrayList.add(file2);
                        }
                    }
                }
                a = a(context, arrayList, str + "/odex/", file);
            } else {
                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, extractDiffInternals fail", new Object[0]);
                a = false;
            }
            elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "recover dex result:%b, cost:%d", new Object[]{Boolean.valueOf(a), Long.valueOf(elapsedRealtime)});
            return a;
        }
        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, dex is not enabled", new Object[0]);
        return true;
    }

    protected static boolean a(File file, a aVar) {
        Object shareElfFile;
        Object obj = null;
        if (vsh.isEmpty()) {
            return true;
        }
        File file2;
        int size = vsi.size() * 30;
        if (size > 120) {
            size = 120;
        }
        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "raw dex count: %d, dex opt dex count: %d, final wait times: %d", new Object[]{Integer.valueOf(vsi.size()), Integer.valueOf(vsh.size()), Integer.valueOf(size)});
        for (int i = 0; i < size; i++) {
            int i2;
            int i3 = i + 1;
            Iterator it = vsh.iterator();
            while (it.hasNext()) {
                if (!SharePatchFileUtil.ah((File) it.next())) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "parallel dex optimizer file %s is not exist, just wait %d times", new Object[]{((File) it.next()).getName(), Integer.valueOf(i3)});
                    i2 = 0;
                    break;
                }
            }
            i2 = 1;
            if (i2 == 0) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "thread sleep InterruptedException e:" + e, new Object[0]);
                }
            }
        }
        List arrayList = new ArrayList();
        Iterator it2 = vsh.iterator();
        while (it2.hasNext()) {
            file2 = (File) it2.next();
            com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file exist: %s, size %d", new Object[]{file2.getPath(), Long.valueOf(file2.length())});
            if (!SharePatchFileUtil.ah(file2)) {
                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "final parallel dex optimizer file %s is not exist, return false", new Object[]{file2.getName()});
                arrayList.add(file2);
            }
        }
        if (arrayList.isEmpty()) {
            if (VERSION.SDK_INT >= 21) {
                Iterator it3 = vsh.iterator();
                Throwable th = null;
                while (it3.hasNext()) {
                    file2 = (File) it3.next();
                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "check dex optimizer file format: %s, size %d", new Object[]{file2.getName(), Long.valueOf(file2.length())});
                    try {
                        if (ShareElfFile.af(file2) == 1) {
                            try {
                                shareElfFile = new ShareElfFile(file2);
                            } catch (Throwable th2) {
                                th = th2;
                                shareElfFile = "Tinker.DexDiffPatchInternal";
                                com.tencent.tinker.lib.f.a.e(shareElfFile, "final parallel dex optimizer file %s is not elf format, return false", new Object[]{file2.getName()});
                                arrayList.add(file2);
                            } finally {
                                obj = 
/*
Method generation error in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean, dex: 
jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r2_3 'obj' java.lang.Object) = (r2_2 'obj' java.lang.Object), (r7_19 'shareElfFile' java.lang.Object) in method: com.tencent.tinker.lib.c.d.a(java.io.File, com.tencent.tinker.lib.e.a):boolean, dex: 
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:298)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:278)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:218)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:186)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:320)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:257)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:220)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:110)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:75)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:10)
	at jadx.core.ProcessClass.process(ProcessClass.java:38)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:201)
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 52 more

*/

                                private static boolean acO(String str) {
                                    if (vsi.isEmpty() || !vsk) {
                                        return false;
                                    }
                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo;
                                    boolean z;
                                    Iterator it = vsi.iterator();
                                    File file = null;
                                    ShareDexDiffPatchInfo shareDexDiffPatchInfo2 = null;
                                    while (it.hasNext()) {
                                        shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                                        File file2 = new File(str + shareDexDiffPatchInfo.dia);
                                        if (ShareConstants.vuy.matcher(file2.getName()).matches()) {
                                            vsj.put(shareDexDiffPatchInfo, file2);
                                        }
                                        if (!shareDexDiffPatchInfo.vuz.startsWith("test.dex")) {
                                            file2 = file;
                                            shareDexDiffPatchInfo = shareDexDiffPatchInfo2;
                                        }
                                        file = file2;
                                        shareDexDiffPatchInfo2 = shareDexDiffPatchInfo;
                                    }
                                    if (shareDexDiffPatchInfo2 != null) {
                                        vsj.put(ShareTinkerInternals.a(shareDexDiffPatchInfo2, vsj.size() + 1), file);
                                    }
                                    file = new File(str, "tinker_classN.apk");
                                    if (file.exists()) {
                                        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo3 : vsj.keySet()) {
                                            if (!SharePatchFileUtil.b(file, shareDexDiffPatchInfo3.vuz, shareDexDiffPatchInfo3.vuB)) {
                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo3.vuz, Long.valueOf(file.length())});
                                                z = false;
                                                break;
                                            }
                                        }
                                        z = true;
                                        if (!z) {
                                            SharePatchFileUtil.aj(file);
                                        }
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        for (File aj : vsj.values()) {
                                            SharePatchFileUtil.aj(aj);
                                        }
                                    }
                                    return z;
                                }

                                private static boolean a(Context context, File file, String str) {
                                    Object obj;
                                    Object gVar;
                                    Throwable th;
                                    boolean z;
                                    if (vsi.isEmpty() || !vsk) {
                                        return true;
                                    }
                                    File file2 = new File(str, "tinker_classN.apk");
                                    if (vsj.isEmpty()) {
                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "classNDexInfo size: %d, no need to merge classN dex files", new Object[]{Integer.valueOf(vsj.size())});
                                        return true;
                                    }
                                    long currentTimeMillis = System.currentTimeMillis();
                                    obj = null;
                                    Object hVar;
                                    try {
                                        hVar = new h(new BufferedOutputStream(new FileOutputStream(file2)));
                                        try {
                                            for (ShareDexDiffPatchInfo shareDexDiffPatchInfo : vsj.keySet()) {
                                                File file3 = (File) vsj.get(shareDexDiffPatchInfo);
                                                if (shareDexDiffPatchInfo.vuG) {
                                                    try {
                                                        gVar = new g(file3);
                                                        try {
                                                            f adb = gVar.adb("classes.dex");
                                                            f fVar = new f(adb, shareDexDiffPatchInfo.vuz);
                                                            obj = gVar.a(adb);
                                                            try {
                                                                i.a(fVar, obj, hVar);
                                                                com.tencent.tinker.c.b.a.ar(obj);
                                                                com.tencent.tinker.c.b.a.ar(gVar);
                                                            } catch (Throwable th2) {
                                                                th = th2;
                                                            }
                                                        } catch (Throwable th3) {
                                                            th = th3;
                                                            obj = null;
                                                        }
                                                    } catch (Throwable th4) {
                                                        th = th4;
                                                        obj = null;
                                                        gVar = null;
                                                    }
                                                } else {
                                                    i.a(new f(shareDexDiffPatchInfo.vuz), file3, Long.parseLong(shareDexDiffPatchInfo.vuD), hVar);
                                                }
                                            }
                                            com.tencent.tinker.c.b.a.ar(hVar);
                                            z = true;
                                        } catch (Throwable th5) {
                                            th = th5;
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        hVar = null;
                                        com.tencent.tinker.c.b.a.ar(hVar);
                                        throw th;
                                    }
                                    if (z) {
                                        for (ShareDexDiffPatchInfo shareDexDiffPatchInfo2 : vsj.keySet()) {
                                            if (!SharePatchFileUtil.b(file2, shareDexDiffPatchInfo2.vuz, shareDexDiffPatchInfo2.vuB)) {
                                                z = false;
                                                com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "verify dex file md5 error, entry name; %s, file len: %d", new Object[]{shareDexDiffPatchInfo2.vuz, Long.valueOf(file2.length())});
                                                break;
                                            }
                                        }
                                    }
                                    if (z) {
                                        for (File aj : vsj.values()) {
                                            SharePatchFileUtil.aj(aj);
                                        }
                                    } else {
                                        com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "merge classN dex error, try delete temp file", new Object[0]);
                                        SharePatchFileUtil.aj(file2);
                                        a.hL(context).vsz.a(file, file2, file2.getName(), 7);
                                    }
                                    com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "merge classN dex file %s, result: %b, size: %d, use: %dms", new Object[]{file2.getPath(), Boolean.valueOf(z), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                    return z;
                                    com.tencent.tinker.c.b.a.ar(obj);
                                    com.tencent.tinker.c.b.a.ar(gVar);
                                    throw th;
                                }

                                private static boolean a(Context context, List<File> list, String str, File file) {
                                    a hL = a.hL(context);
                                    vsh.clear();
                                    File file2 = new File(str);
                                    if (file2.exists() || file2.mkdirs()) {
                                        for (File m : list) {
                                            vsh.add(new File(SharePatchFileUtil.m(m, file2)));
                                        }
                                        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "patch recover, try to optimize dex file count:%d, optimizeDexDirectory:%s", new Object[]{Integer.valueOf(list.size()), str});
                                        final List vector = new Vector();
                                        final Throwable[] thArr = new Throwable[1];
                                        TinkerDexOptimizer.a(list, file2, new ResultCallback() {
                                            long startTime;

                                            public final void aa(File file) {
                                                this.startTime = System.currentTimeMillis();
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "start to parallel optimize dex %s, size: %d", new Object[]{file.getPath(), Long.valueOf(file.length())});
                                            }

                                            public final void k(File file, File file2) {
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "success to parallel optimize dex %s, opt file:%s, opt file size: %d, use time %d", new Object[]{file.getPath(), file2.getPath(), Long.valueOf(file2.length()), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                                            }

                                            public final void b(File file, Throwable th) {
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "fail to parallel optimize dex %s use time %d", new Object[]{file.getPath(), Long.valueOf(System.currentTimeMillis() - this.startTime)});
                                                vector.add(file);
                                                thArr[0] = th;
                                            }
                                        });
                                        if (vector.isEmpty()) {
                                            return true;
                                        }
                                        hL.vsz.a(file, vector, thArr[0]);
                                        return false;
                                    }
                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch recover, make optimizeDexDirectoryFile fail", new Object[0]);
                                    return false;
                                }

                                private static boolean b(Context context, String str, String str2, File file) {
                                    Throwable th;
                                    ZipFile zipFile;
                                    vsi.clear();
                                    ShareDexDiffPatchInfo.m(str2, vsi);
                                    if (vsi.isEmpty()) {
                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "extract patch list is empty! type:%s:", new Object[]{ShareTinkerInternals.Im(3)});
                                        return true;
                                    }
                                    File file2 = new File(str);
                                    if (!file2.exists()) {
                                        file2.mkdirs();
                                    }
                                    a hL = a.hL(context);
                                    ZipFile zipFile2 = null;
                                    try {
                                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                                        if (applicationInfo == null) {
                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "applicationInfo == null!!!!", new Object[0]);
                                            SharePatchFileUtil.a(null);
                                            SharePatchFileUtil.a(null);
                                            return false;
                                        }
                                        ZipFile zipFile3;
                                        ZipFile zipFile4 = new ZipFile(applicationInfo.sourceDir);
                                        try {
                                            zipFile3 = new ZipFile(file);
                                        } catch (Throwable th2) {
                                            th = th2;
                                            zipFile = zipFile4;
                                            SharePatchFileUtil.a(zipFile);
                                            SharePatchFileUtil.a(zipFile2);
                                            throw th;
                                        }
                                        try {
                                            if (acO(str)) {
                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "class n dex file %s is already exist, and md5 match, just continue", new Object[]{"tinker_classN.apk"});
                                                SharePatchFileUtil.a(zipFile4);
                                                SharePatchFileUtil.a(zipFile3);
                                                return true;
                                            }
                                            Iterator it = vsi.iterator();
                                            while (it.hasNext()) {
                                                String str3;
                                                ShareDexDiffPatchInfo shareDexDiffPatchInfo = (ShareDexDiffPatchInfo) it.next();
                                                long currentTimeMillis = System.currentTimeMillis();
                                                if (shareDexDiffPatchInfo.path.equals("")) {
                                                    str3 = shareDexDiffPatchInfo.vuz;
                                                } else {
                                                    str3 = shareDexDiffPatchInfo.path + "/" + shareDexDiffPatchInfo.vuz;
                                                }
                                                String str4 = shareDexDiffPatchInfo.vuE;
                                                String str5 = shareDexDiffPatchInfo.vuC;
                                                if (vsk || !shareDexDiffPatchInfo.vuA.equals("0")) {
                                                    String str6 = vsk ? shareDexDiffPatchInfo.vuB : shareDexDiffPatchInfo.vuA;
                                                    if (SharePatchFileUtil.acX(str6)) {
                                                        File file3 = new File(str + shareDexDiffPatchInfo.dia);
                                                        if (!file3.exists()) {
                                                            file3.getParentFile().mkdirs();
                                                        } else if (SharePatchFileUtil.g(file3, str6)) {
                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "dex file %s is already exist, and md5 match, just continue", new Object[]{file3.getPath()});
                                                        } else {
                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "have a mismatch corrupted dex " + file3.getPath(), new Object[0]);
                                                            file3.delete();
                                                        }
                                                        ZipEntry entry = zipFile3.getEntry(str3);
                                                        ZipEntry entry2 = zipFile4.getEntry(str3);
                                                        if (str5.equals("0")) {
                                                            if (entry == null) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                                                hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                                SharePatchFileUtil.a(zipFile4);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                return false;
                                                            } else if (!a(zipFile3, entry, file3, shareDexDiffPatchInfo)) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to extract raw patch file " + file3.getPath(), new Object[0]);
                                                                hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                                SharePatchFileUtil.a(zipFile4);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                return false;
                                                            }
                                                        } else if (str4.equals("0")) {
                                                            if (!vsk) {
                                                                continue;
                                                            } else if (entry2 == null) {
                                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                                                hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                                SharePatchFileUtil.a(zipFile4);
                                                                SharePatchFileUtil.a(zipFile3);
                                                                return false;
                                                            } else {
                                                                if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                                                    a(zipFile4, entry2, file3, shareDexDiffPatchInfo);
                                                                    if (!SharePatchFileUtil.g(file3, str6)) {
                                                                        com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                                        hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                                        SharePatchFileUtil.aj(file3);
                                                                        SharePatchFileUtil.a(zipFile4);
                                                                        SharePatchFileUtil.a(zipFile3);
                                                                        return false;
                                                                    }
                                                                } else {
                                                                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                                                    hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                                    SharePatchFileUtil.a(zipFile4);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    return false;
                                                                }
                                                            }
                                                        } else if (entry == null) {
                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch entry is null. path:" + str3, new Object[0]);
                                                            hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                            SharePatchFileUtil.a(zipFile4);
                                                            SharePatchFileUtil.a(zipFile3);
                                                            return false;
                                                        } else if (!SharePatchFileUtil.acX(str4)) {
                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.Im(3), shareDexDiffPatchInfo.vuz, str4});
                                                            hL.vsz.d(file, b.Ii(3));
                                                            SharePatchFileUtil.a(zipFile4);
                                                            SharePatchFileUtil.a(zipFile3);
                                                            return false;
                                                        } else if (entry2 == null) {
                                                            com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "apk entry is null. path:" + str3, new Object[0]);
                                                            hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                            SharePatchFileUtil.a(zipFile4);
                                                            SharePatchFileUtil.a(zipFile3);
                                                            return false;
                                                        } else {
                                                            if (String.valueOf(entry2.getCrc()).equals(str5)) {
                                                                a(zipFile4, zipFile3, entry2, entry, shareDexDiffPatchInfo, file3);
                                                                if (SharePatchFileUtil.g(file3, str6)) {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "success recover dex file: %s, size: %d, use time: %d", new Object[]{file3.getPath(), Long.valueOf(file3.length()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
                                                                } else {
                                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "Failed to recover dex file when verify patched dex: " + file3.getPath(), new Object[0]);
                                                                    hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                                    SharePatchFileUtil.aj(file3);
                                                                    SharePatchFileUtil.a(zipFile4);
                                                                    SharePatchFileUtil.a(zipFile3);
                                                                    return false;
                                                                }
                                                            }
                                                            com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "apk entry %s crc is not equal, expect crc: %s, got crc: %s", new Object[]{str3, str5, String.valueOf(entry2.getCrc())});
                                                            hL.vsz.a(file, file3, shareDexDiffPatchInfo.vuz, 3);
                                                            SharePatchFileUtil.a(zipFile4);
                                                            SharePatchFileUtil.a(zipFile3);
                                                            return false;
                                                        }
                                                    }
                                                    com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "meta file md5 invalid, type:%s, name: %s, md5: %s", new Object[]{ShareTinkerInternals.Im(3), shareDexDiffPatchInfo.vuz, str6});
                                                    hL.vsz.d(file, b.Ii(3));
                                                    SharePatchFileUtil.a(zipFile4);
                                                    SharePatchFileUtil.a(zipFile3);
                                                    return false;
                                                }
                                                com.tencent.tinker.lib.f.a.w("Tinker.DexDiffPatchInternal", "patch dex %s is only for art, just continue", new Object[]{str3});
                                            }
                                            if (a(context, file, str)) {
                                                SharePatchFileUtil.a(zipFile4);
                                                SharePatchFileUtil.a(zipFile3);
                                                return true;
                                            }
                                            SharePatchFileUtil.a(zipFile4);
                                            SharePatchFileUtil.a(zipFile3);
                                            return false;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            zipFile2 = zipFile3;
                                            zipFile = zipFile4;
                                            SharePatchFileUtil.a(zipFile);
                                            SharePatchFileUtil.a(zipFile2);
                                            throw th;
                                        }
                                    } catch (Throwable th4) {
                                        th = th4;
                                        zipFile = null;
                                        SharePatchFileUtil.a(zipFile);
                                        SharePatchFileUtil.a(zipFile2);
                                        throw th;
                                    }
                                }

                                private static boolean b(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
                                    Throwable th;
                                    boolean z = false;
                                    int i = 0;
                                    while (i < 2 && !z) {
                                        int i2 = i + 1;
                                        com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "try Extracting " + file.getPath(), new Object[0]);
                                        Object zipOutputStream;
                                        Object bufferedInputStream;
                                        try {
                                            zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                                            try {
                                                bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedInputStream = null;
                                            }
                                            try {
                                                byte[] bArr = new byte[16384];
                                                zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                                                for (int read = bufferedInputStream.read(bArr); read != -1; read = bufferedInputStream.read(bArr)) {
                                                    zipOutputStream.write(bArr, 0, read);
                                                }
                                                zipOutputStream.closeEntry();
                                                com.tencent.tinker.c.b.a.ar(bufferedInputStream);
                                                com.tencent.tinker.c.b.a.ar(zipOutputStream);
                                                z = SharePatchFileUtil.g(file, str);
                                                com.tencent.tinker.lib.f.a.i("Tinker.DexDiffPatchInternal", "isExtractionSuccessful: %b", new Object[]{Boolean.valueOf(z)});
                                                if (!z && (!file.delete() || file.exists())) {
                                                    com.tencent.tinker.lib.f.a.e("Tinker.DexDiffPatchInternal", "Failed to delete corrupted dex " + file.getPath(), new Object[0]);
                                                }
                                                i = i2;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                com.tencent.tinker.c.b.a.ar(bufferedInputStream);
                                                com.tencent.tinker.c.b.a.ar(zipOutputStream);
                                                throw th;
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            bufferedInputStream = null;
                                            zipOutputStream = null;
                                        }
                                    }
                                    return z;
                                }

                                private static boolean a(ZipFile zipFile, ZipEntry zipEntry, File file, ShareDexDiffPatchInfo shareDexDiffPatchInfo) {
                                    String str = vsk ? shareDexDiffPatchInfo.vuB : shareDexDiffPatchInfo.vuA;
                                    String str2 = shareDexDiffPatchInfo.vuz;
                                    boolean z = shareDexDiffPatchInfo.vuG;
                                    if (SharePatchFileUtil.acY(str2) && z) {
                                        return b(zipFile, zipEntry, file, str);
                                    }
                                    return a(zipFile, zipEntry, file, str, true);
                                }

                                private static void a(ZipFile zipFile, ZipFile zipFile2, ZipEntry zipEntry, ZipEntry zipEntry2, ShareDexDiffPatchInfo shareDexDiffPatchInfo, File file) {
                                    Throwable th;
                                    Object obj;
                                    Object obj2;
                                    Object obj3 = null;
                                    try {
                                        InputStream bufferedInputStream;
                                        InputStream bufferedInputStream2 = new BufferedInputStream(zipFile.getInputStream(zipEntry));
                                        if (zipEntry2 != null) {
                                            try {
                                                bufferedInputStream = new BufferedInputStream(zipFile2.getInputStream(zipEntry2));
                                            } catch (Throwable th2) {
                                                th = th2;
                                                obj = null;
                                                InputStream obj22 = bufferedInputStream2;
                                                com.tencent.tinker.c.b.a.ar(obj22);
                                                com.tencent.tinker.c.b.a.ar(obj);
                                                throw th;
                                            }
                                        }
                                        bufferedInputStream = null;
                                        try {
                                            boolean acY = SharePatchFileUtil.acY(shareDexDiffPatchInfo.vuz);
                                            if (!acY || shareDexDiffPatchInfo.vuG) {
                                                try {
                                                    OutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
                                                    try {
                                                        zipOutputStream.putNextEntry(new ZipEntry("classes.dex"));
                                                        if (acY) {
                                                            new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream).a(zipOutputStream);
                                                        } else {
                                                            try {
                                                                ZipEntry nextEntry;
                                                                obj = new ZipInputStream(bufferedInputStream2);
                                                                do {
                                                                    try {
                                                                        nextEntry = obj.getNextEntry();
                                                                        if (nextEntry == null) {
                                                                            break;
                                                                        }
                                                                    } catch (Throwable th3) {
                                                                        th = th3;
                                                                        com.tencent.tinker.c.b.a.ar(obj);
                                                                        throw th;
                                                                    }
                                                                } while (!"classes.dex".equals(nextEntry.getName()));
                                                                if (nextEntry == null) {
                                                                    throw new TinkerRuntimeException("can't recognize zip dex format file:" + file.getAbsolutePath());
                                                                }
                                                                new com.tencent.tinker.c.a.a(obj, bufferedInputStream).a(zipOutputStream);
                                                                com.tencent.tinker.c.b.a.ar(obj);
                                                            } catch (Throwable th4) {
                                                                th = th4;
                                                                obj = null;
                                                                com.tencent.tinker.c.b.a.ar(obj);
                                                                throw th;
                                                            }
                                                        }
                                                        zipOutputStream.closeEntry();
                                                        com.tencent.tinker.c.b.a.ar(zipOutputStream);
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        obj3 = zipOutputStream;
                                                    }
                                                } catch (Throwable th6) {
                                                    th = th6;
                                                    com.tencent.tinker.c.b.a.ar(obj3);
                                                    throw th;
                                                }
                                            }
                                            com.tencent.tinker.c.a.a aVar = new com.tencent.tinker.c.a.a(bufferedInputStream2, bufferedInputStream);
                                            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                            try {
                                                aVar.a(bufferedOutputStream);
                                                com.tencent.tinker.c.b.a.ar(bufferedOutputStream);
                                            } catch (Throwable th7) {
                                                th = th7;
                                                OutputStream obj32 = bufferedOutputStream;
                                                com.tencent.tinker.c.b.a.ar(obj32);
                                                throw th;
                                            }
                                            com.tencent.tinker.c.b.a.ar(bufferedInputStream2);
                                            com.tencent.tinker.c.b.a.ar(bufferedInputStream);
                                        } catch (Throwable th8) {
                                            th = th8;
                                            obj = bufferedInputStream;
                                            obj22 = bufferedInputStream2;
                                            com.tencent.tinker.c.b.a.ar(obj22);
                                            com.tencent.tinker.c.b.a.ar(obj);
                                            throw th;
                                        }
                                    } catch (Throwable th9) {
                                        th = th9;
                                        obj = null;
                                        obj22 = null;
                                        com.tencent.tinker.c.b.a.ar(obj22);
                                        com.tencent.tinker.c.b.a.ar(obj);
                                        throw th;
                                    }
                                }
                            }
