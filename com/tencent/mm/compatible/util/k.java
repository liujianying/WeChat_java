package com.tencent.mm.compatible.util;

import android.content.Intent;
import com.tencent.mm.app.b;
import com.tencent.mm.compatible.e.y;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class k {
    private static String dgF = null;
    private static boolean dgG = false;
    private static HashMap<String, String> dgH = null;
    private static final HashMap<String, WeakReference<ClassLoader>> mLoadedLibs = new HashMap();

    private static class a implements UncaughtExceptionHandler {
        private UncaughtExceptionHandler mParent;

        public a(UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.mParent = uncaughtExceptionHandler;
        }

        public final void uncaughtException(Thread thread, Throwable th) {
            Object obj = 1;
            Object obj2 = ((th instanceof UnsatisfiedLinkError) || ((th instanceof NoSuchMethodError) && th.getMessage().matches(".*sig(nature)?[=:].*"))) ? 1 : null;
            if (obj2 != null) {
                try {
                    k.vg();
                } catch (Exception e) {
                }
                if (obj != null) {
                    th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
                }
                this.mParent.uncaughtException(thread, th);
            }
            obj = null;
            if (obj != null) {
                th = new UnsatisfiedLinkError("Invalid JNI libraries detected and recovered.").initCause(th);
            }
            this.mParent.uncaughtException(thread, th);
        }
    }

    static /* synthetic */ void vg() {
        List generateAbiList = generateAbiList();
        File dir = ad.getContext().getDir("recover_lib", 0);
        ZipFile zipFile = new ZipFile(ad.getContext().getApplicationInfo().sourceDir);
        try {
            HashSet hashSet = new HashSet();
            Pattern compile = Pattern.compile("lib/[A-Za-z0-9-_=]+/lib([A-Za-z0-9-_=]+)\\.so");
            Enumeration entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                Matcher matcher = compile.matcher(((ZipEntry) entries.nextElement()).getName());
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    if (!hashSet.contains(group)) {
                        extractLibrary(zipFile, group, generateAbiList, new File(dir, "lib" + group + ".so"));
                        hashSet.add(group);
                    }
                }
            }
        } finally {
            zipFile.close();
        }
    }

    private k() {
    }

    public static boolean fg(String str) {
        boolean containsKey;
        synchronized (mLoadedLibs) {
            containsKey = mLoadedLibs.containsKey(str);
        }
        return containsKey;
    }

    public static String fh(String str) {
        String str2;
        try {
            ClassLoader classLoader = k.class.getClassLoader();
            Method declaredMethod = ClassLoader.class.getDeclaredMethod("findLibrary", new Class[]{String.class});
            declaredMethod.setAccessible(true);
            str2 = (String) declaredMethod.invoke(classLoader, new Object[]{str});
        } catch (Exception e) {
            str2 = null;
        }
        if (str2 != null) {
            return str2;
        }
        File file = new File(ad.getContext().getDir("recover_lib", 0), "lib" + str + ".so");
        if (file.canRead()) {
            return file.getAbsolutePath();
        }
        return str2;
    }

    private static boolean a(String str, ClassLoader classLoader) {
        if (!com.tencent.mm.loader.stub.a.patchEnabled()) {
            return false;
        }
        ApplicationLike applicationLike;
        String e;
        if (!dgG) {
            applicationLike = b.applicationLike;
            if (applicationLike == null) {
                throw new RuntimeException("tinker application is null when try to load from patch libs");
            }
            dgG = true;
            if (applicationLike == null || applicationLike.getApplication() == null) {
                throw new TinkerRuntimeException("tinkerApplication is null");
            }
            Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
            HashMap aJ = (tinkerResultIntent == null || ShareIntentUtil.aE(tinkerResultIntent) != 0) ? null : ShareIntentUtil.aJ(tinkerResultIntent);
            dgH = aJ;
            e = com.tencent.tinker.lib.e.b.e(applicationLike);
            if (ShareTinkerInternals.oW(e)) {
                dgF = null;
            } else {
                File hV = SharePatchFileUtil.hV(applicationLike.getApplication());
                e = SharePatchFileUtil.acV(e);
                if (!(hV == null || e == null)) {
                    dgF = new File(hV.getAbsolutePath() + "/" + e).getAbsolutePath() + "/lib";
                }
            }
        }
        if (!str.startsWith("lib")) {
            str = "lib" + str;
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        String str2 = "lib/armeabi/" + str;
        applicationLike = b.applicationLike;
        if (com.tencent.tinker.lib.e.b.c(applicationLike) && com.tencent.tinker.lib.e.b.d(applicationLike) && dgH != null) {
            for (String e2 : dgH.keySet()) {
                if (e2.equals(str2)) {
                    String str3 = dgF + "/" + e2;
                    File file = new File(str3);
                    if (!file.exists()) {
                        continue;
                    } else if (!applicationLike.getTinkerLoadVerifyFlag() || SharePatchFileUtil.f(file, (String) dgH.get(e2))) {
                        try {
                            x.w("MicroMsg.LoadLibrary", "succ load from patch path: %s", str3);
                            reflectSystemLoad(str3, classLoader);
                            synchronized (mLoadedLibs) {
                                mLoadedLibs.put(str, new WeakReference(classLoader));
                            }
                            return true;
                        } catch (InvocationTargetException e3) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e3.getCause()));
                        } catch (Throwable e4) {
                            throw ((UnsatisfiedLinkError) new UnsatisfiedLinkError("Failed loading library: " + str).initCause(e4));
                        }
                    } else {
                        x.e("MicroMsg.LoadLibrary", "loadLibraryFromTinker md5mismatch fail: %s", str3);
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.lang.String r7, java.lang.ClassLoader r8) {
        /*
        r1 = 0;
        r2 = 0;
        r3 = "libName or callerClassLoader is null";
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r7);
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        if (r8 != 0) goto L_0x0049;
    L_0x000d:
        r0 = 1;
    L_0x000e:
        junit.framework.Assert.assertFalse(r3, r0);
        r3 = mLoadedLibs;
        monitor-enter(r3);
        r0 = "MicroMsg.LoadLibrary";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0068 }
        r5 = "initial try load library:";
        r4.<init>(r5);	 Catch:{ all -> 0x0068 }
        r4 = r4.append(r7);	 Catch:{ all -> 0x0068 }
        r4 = r4.toString();	 Catch:{ all -> 0x0068 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r4);	 Catch:{ all -> 0x0068 }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0068 }
        r0 = r0.get(r7);	 Catch:{ all -> 0x0068 }
        r0 = (java.lang.ref.WeakReference) r0;	 Catch:{ all -> 0x0068 }
        if (r0 == 0) goto L_0x0295;
    L_0x0034:
        r0 = r0.get();	 Catch:{ all -> 0x0068 }
        r0 = (java.lang.ClassLoader) r0;	 Catch:{ all -> 0x0068 }
    L_0x003a:
        if (r0 == 0) goto L_0x006b;
    L_0x003c:
        if (r0 != r8) goto L_0x004b;
    L_0x003e:
        r0 = "MicroMsg.LoadLibrary";
        r1 = "already loaded library";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);	 Catch:{ all -> 0x0068 }
        monitor-exit(r3);	 Catch:{ all -> 0x0068 }
    L_0x0048:
        return;
    L_0x0049:
        r0 = r1;
        goto L_0x000e;
    L_0x004b:
        r0 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x0068 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0068 }
        r2 = "Library '";
        r1.<init>(r2);	 Catch:{ all -> 0x0068 }
        r1 = r1.append(r7);	 Catch:{ all -> 0x0068 }
        r2 = "' was loaded by a different ClassLoader.";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0068 }
        r1 = r1.toString();	 Catch:{ all -> 0x0068 }
        r0.<init>(r1);	 Catch:{ all -> 0x0068 }
        throw r0;	 Catch:{ all -> 0x0068 }
    L_0x0068:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0068 }
        throw r0;
    L_0x006b:
        monitor-exit(r3);	 Catch:{ all -> 0x0068 }
        r0 = "MicroMsg.LoadLibrary";
        r3 = new java.lang.StringBuilder;
        r4 = "try load library:";
        r3.<init>(r4);
        r3 = r3.append(r7);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r0 = a(r7, r8);
        if (r0 != 0) goto L_0x0048;
    L_0x0088:
        r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
        if (r3 == 0) goto L_0x0098;
    L_0x008e:
        r0 = com.tencent.mm.sdk.platformtools.bj.cjh();
        if (r0 != 0) goto L_0x0098;
    L_0x0094:
        r0 = com.tencent.mm.loader.stub.a.DEBUG;
        if (r0 == 0) goto L_0x00eb;
    L_0x0098:
        reflectSystemLoadlibrary(r7, r8);	 Catch:{ InvocationTargetException -> 0x00ad, Exception -> 0x00ce }
        r1 = mLoadedLibs;	 Catch:{ InvocationTargetException -> 0x00ad, Exception -> 0x00ce }
        monitor-enter(r1);	 Catch:{ InvocationTargetException -> 0x00ad, Exception -> 0x00ce }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x00aa }
        r2 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x00aa }
        r2.<init>(r8);	 Catch:{ all -> 0x00aa }
        r0.put(r7, r2);	 Catch:{ all -> 0x00aa }
        monitor-exit(r1);	 Catch:{ all -> 0x00aa }
        goto L_0x0048;
    L_0x00aa:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x00aa }
        throw r0;	 Catch:{ InvocationTargetException -> 0x00ad, Exception -> 0x00ce }
    L_0x00ad:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed loading library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x00ce:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed loading library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x00eb:
        r0 = "recover_lib";
        r0 = r3.getDir(r0, r1);
        r4 = new java.io.File;
        r1 = new java.lang.StringBuilder;
        r5 = "lib";
        r1.<init>(r5);
        r1 = r1.append(r7);
        r5 = ".so";
        r1 = r1.append(r5);
        r1 = r1.toString();
        r4.<init>(r0, r1);
        r0 = r4.isFile();
        if (r0 == 0) goto L_0x0292;
    L_0x0114:
        r0 = r4.getAbsolutePath();	 Catch:{ UnsatisfiedLinkError -> 0x012e, InvocationTargetException -> 0x018e, Throwable -> 0x01be }
        reflectSystemLoad(r0, r8);	 Catch:{ UnsatisfiedLinkError -> 0x012e, InvocationTargetException -> 0x018e, Throwable -> 0x01be }
        r1 = mLoadedLibs;	 Catch:{ UnsatisfiedLinkError -> 0x012e, InvocationTargetException -> 0x018e, Throwable -> 0x01be }
        monitor-enter(r1);	 Catch:{ UnsatisfiedLinkError -> 0x012e, InvocationTargetException -> 0x018e, Throwable -> 0x01be }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x012b }
        r5 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x012b }
        r5.<init>(r8);	 Catch:{ all -> 0x012b }
        r0.put(r7, r5);	 Catch:{ all -> 0x012b }
        monitor-exit(r1);	 Catch:{ all -> 0x012b }
        goto L_0x0048;
    L_0x012b:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x012b }
        throw r0;	 Catch:{ UnsatisfiedLinkError -> 0x012e, InvocationTargetException -> 0x018e, Throwable -> 0x01be }
    L_0x012e:
        r0 = move-exception;
    L_0x012f:
        r4.delete();
        r1 = r0;
    L_0x0133:
        reflectSystemLoadlibrary(r7, r8);	 Catch:{ UnsatisfiedLinkError -> 0x0149, InvocationTargetException -> 0x01db, Throwable -> 0x0211 }
        r5 = mLoadedLibs;	 Catch:{ UnsatisfiedLinkError -> 0x0149, InvocationTargetException -> 0x01db, Throwable -> 0x0211 }
        monitor-enter(r5);	 Catch:{ UnsatisfiedLinkError -> 0x0149, InvocationTargetException -> 0x01db, Throwable -> 0x0211 }
        r0 = mLoadedLibs;	 Catch:{ all -> 0x0146 }
        r6 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0146 }
        r6.<init>(r8);	 Catch:{ all -> 0x0146 }
        r0.put(r7, r6);	 Catch:{ all -> 0x0146 }
        monitor-exit(r5);	 Catch:{ all -> 0x0146 }
        goto L_0x0048;
    L_0x0146:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0146 }
        throw r0;	 Catch:{ UnsatisfiedLinkError -> 0x0149, InvocationTargetException -> 0x01db, Throwable -> 0x0211 }
    L_0x0149:
        r0 = move-exception;
        if (r1 != 0) goto L_0x028f;
    L_0x014c:
        r1 = r3.getApplicationInfo();	 Catch:{ Exception -> 0x028b, all -> 0x0287 }
        r3 = r1.sourceDir;	 Catch:{ Exception -> 0x028b, all -> 0x0287 }
        r1 = new java.util.zip.ZipFile;	 Catch:{ Exception -> 0x028b, all -> 0x0287 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x028b, all -> 0x0287 }
        r2 = generateAbiList();	 Catch:{ Exception -> 0x0177 }
        r2 = extractLibrary(r1, r7, r2, r4);	 Catch:{ Exception -> 0x0177 }
        if (r2 != 0) goto L_0x022e;
    L_0x0161:
        r0 = new java.lang.RuntimeException;	 Catch:{ Exception -> 0x0177 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0177 }
        r3 = "Can't find recover library: ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0177 }
        r2 = r2.append(r7);	 Catch:{ Exception -> 0x0177 }
        r2 = r2.toString();	 Catch:{ Exception -> 0x0177 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0177 }
        throw r0;	 Catch:{ Exception -> 0x0177 }
    L_0x0177:
        r0 = move-exception;
    L_0x0178:
        r2 = new java.lang.UnsatisfiedLinkError;	 Catch:{ all -> 0x0187 }
        r3 = "Failed recovering native library.";
        r2.<init>(r3);	 Catch:{ all -> 0x0187 }
        r0 = r2.initCause(r0);	 Catch:{ all -> 0x0187 }
        r0 = (java.lang.UnsatisfiedLinkError) r0;	 Catch:{ all -> 0x0187 }
        throw r0;	 Catch:{ all -> 0x0187 }
    L_0x0187:
        r0 = move-exception;
    L_0x0188:
        if (r1 == 0) goto L_0x018d;
    L_0x018a:
        r1.close();	 Catch:{ IOException -> 0x0284 }
    L_0x018d:
        throw r0;
    L_0x018e:
        r0 = move-exception;
        r1 = r0.getCause();
        r1 = r1 instanceof java.lang.UnsatisfiedLinkError;
        if (r1 == 0) goto L_0x019e;
    L_0x0197:
        r0 = r0.getCause();
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        goto L_0x012f;
    L_0x019e:
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x01be:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x01db:
        r0 = move-exception;
        r5 = r0.getCause();
        r5 = r5 instanceof java.lang.UnsatisfiedLinkError;
        if (r5 == 0) goto L_0x01ee;
    L_0x01e4:
        if (r1 != 0) goto L_0x020e;
    L_0x01e6:
        r0 = r0.getCause();
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        goto L_0x014c;
    L_0x01ee:
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r0.getCause();
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x020e:
        r0 = r1;
        goto L_0x014c;
    L_0x0211:
        r0 = move-exception;
        r1 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r0 = r1.initCause(r0);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x022e:
        r1.close();	 Catch:{ IOException -> 0x0282 }
    L_0x0231:
        r1 = r4.getAbsolutePath();	 Catch:{ InvocationTargetException -> 0x024b, Exception -> 0x026f }
        reflectSystemLoad(r1, r8);	 Catch:{ InvocationTargetException -> 0x024b, Exception -> 0x026f }
        r2 = mLoadedLibs;	 Catch:{ InvocationTargetException -> 0x024b, Exception -> 0x026f }
        monitor-enter(r2);	 Catch:{ InvocationTargetException -> 0x024b, Exception -> 0x026f }
        r1 = mLoadedLibs;	 Catch:{ all -> 0x0248 }
        r3 = new java.lang.ref.WeakReference;	 Catch:{ all -> 0x0248 }
        r3.<init>(r8);	 Catch:{ all -> 0x0248 }
        r1.put(r7, r3);	 Catch:{ all -> 0x0248 }
        monitor-exit(r2);	 Catch:{ all -> 0x0248 }
        goto L_0x0048;
    L_0x0248:
        r1 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0248 }
        throw r1;	 Catch:{ InvocationTargetException -> 0x024b, Exception -> 0x026f }
    L_0x024b:
        r1 = move-exception;
        if (r0 != 0) goto L_0x026e;
    L_0x024e:
        r0 = new java.lang.UnsatisfiedLinkError;
        r2 = new java.lang.StringBuilder;
        r3 = "Failed recovering native library: ";
        r2.<init>(r3);
        r2 = r2.append(r7);
        r2 = r2.toString();
        r0.<init>(r2);
        r1 = r1.getCause();
        r0 = r0.initCause(r1);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x026e:
        throw r0;
    L_0x026f:
        r1 = move-exception;
        if (r0 != 0) goto L_0x0281;
    L_0x0272:
        r0 = new java.lang.UnsatisfiedLinkError;
        r2 = "Failed recovering native library.";
        r0.<init>(r2);
        r0 = r0.initCause(r1);
        r0 = (java.lang.UnsatisfiedLinkError) r0;
        throw r0;
    L_0x0281:
        throw r0;
    L_0x0282:
        r1 = move-exception;
        goto L_0x0231;
    L_0x0284:
        r1 = move-exception;
        goto L_0x018d;
    L_0x0287:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0188;
    L_0x028b:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0178;
    L_0x028f:
        r0 = r1;
        goto L_0x014c;
    L_0x0292:
        r1 = r2;
        goto L_0x0133;
    L_0x0295:
        r0 = r2;
        goto L_0x003a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.compatible.util.k.b(java.lang.String, java.lang.ClassLoader):void");
    }

    private static void reflectSystemLoad(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("load", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static void reflectSystemLoadlibrary(String str, ClassLoader classLoader) {
        Runtime runtime = Runtime.getRuntime();
        Method declaredMethod = runtime.getClass().getDeclaredMethod("loadLibrary", new Class[]{String.class, ClassLoader.class});
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(runtime, new Object[]{str, classLoader});
    }

    private static List<String> generateAbiList() {
        List arrayList = new ArrayList(3);
        String str = y.get("ro.product.cpu.abi");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        str = y.get("ro.product.cpu.abi2");
        if (str != null && str.length() > 0) {
            arrayList.add(str);
        }
        arrayList.add("armeabi");
        return arrayList;
    }

    private static boolean extractLibrary(ZipFile zipFile, String str, List<String> list, File file) {
        if (file.isFile()) {
            return true;
        }
        for (String str2 : list) {
            ZipEntry entry = zipFile.getEntry("lib/" + str2 + "/lib" + str + ".so");
            if (entry != null) {
                InputStream inputStream = zipFile.getInputStream(entry);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[2048];
                while (true) {
                    try {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    } finally {
                        inputStream.close();
                        fileOutputStream.close();
                    }
                }
                file.setReadOnly();
                return true;
            }
        }
        return false;
    }

    public static void setupBrokenLibraryHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
    }
}
