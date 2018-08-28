package com.tencent.mm.f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.wcdb.database.SQLiteDatabase;
import dalvik.system.PathClassLoader;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a {
    private static boolean bFR = false;
    private static String bFS;
    private static String bFT;
    private static String bFU;
    private static Set<a> bFV;
    public static final boolean lY = F(System.getProperty("java.vm.version"));

    private static class a {
        String bFW;
        String bFX;
        String bFY;

        public a(String str, String str2, String str3) {
            this.bFW = str;
            this.bFX = str2;
            this.bFY = str3;
        }
    }

    private static final class b {
        static Object[] a(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) {
            Method c;
            try {
                c = a.b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class);
            } catch (NoSuchMethodException e) {
                x.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(ArrayList,File,ArrayList) failure");
                try {
                    c = a.b(obj, "makeDexElements", List.class, File.class, List.class);
                } catch (NoSuchMethodException e2) {
                    x.e("MicroMsg.MultiDex", "NoSuchMethodException: makeDexElements(List,File,List) failure");
                    try {
                        c = a.b(obj, "makePathElements", List.class, File.class, List.class);
                    } catch (NoSuchMethodException e3) {
                        x.e("MicroMsg.MultiDex", "NoSuchMethodException: makePathElements(List,File,List) failure");
                        throw e3;
                    }
                }
            }
            return (Object[]) c.invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    private a() {
    }

    public static void ba(Context context) {
        long blockSize;
        long j = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
            x.e("MicroMsg.MultiDex", "get db spare space error");
        }
        x.i("MicroMsg.MultiDex", "ifRomSpaceEnough available:%d all:%d", Long.valueOf(j), Long.valueOf(blockSize));
        if (blockSize != 0 && j < 31457280) {
            String an = bi.an(context, Process.myPid());
            x.i("MicroMsg.MultiDex", "space not enough process:%s, available:%d, RESTRICTION_SPACE_SIZE: %d", an, Long.valueOf(j), Long.valueOf(31457280));
            if (!an.equals("") && !an.endsWith(":nospace")) {
                Intent intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.NoRomSpaceDexUI");
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                context.startActivity(intent);
                Process.killProcess(Process.myPid());
            }
        }
    }

    public static boolean aZ(Context context) {
        int i = -1;
        if (lY) {
            x.i("MultiDex", "if need dexopt: VM has multidex support, MultiDex support library is disabled.");
            return false;
        } else if (bFR) {
            x.i("MultiDex", "if need dexopt: has inited.");
            return false;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            bi(context);
            if (bFV == null || bFV.size() <= 0) {
                return true;
            }
            bFS = context.getDir("cache", 0).getAbsolutePath();
            bFT = context.getDir("dex", 0).getAbsolutePath();
            bFU = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
            File file = new File(bFT);
            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                int size = bFV.size();
                File file2 = new File(bFS);
                if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                    x.i("MicroMsg.MultiDex", "if need dexopt: install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                    if (file.list() == null || file.list().length < size || file2.list() == null || file2.list().length < size) {
                        String str = "MicroMsg.MultiDex";
                        String str2 = "if need dexopt: dex file count not equal, install path: %s vs %s, opt path: %s vs %s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(file.list() == null ? -1 : file.list().length);
                        objArr[1] = Integer.valueOf(size);
                        if (file2.list() != null) {
                            i = file2.list().length;
                        }
                        objArr[2] = Integer.valueOf(i);
                        objArr[3] = Integer.valueOf(size);
                        x.i(str, str2, objArr);
                        return true;
                    } else if (context.getApplicationInfo() == null) {
                        return false;
                    } else {
                        for (a aVar : bFV) {
                            synchronized (a.class) {
                                x.i("MicroMsg.MultiDex", "if need dexopt: prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.bFW, aVar.bFX, aVar.bFY);
                            }
                            if (a(aVar)) {
                                x.i("MicroMsg.MultiDex", "if need dexopt: verify dex for check md5: targetFilePath: [%s] time: %d", aVar.bFW, Long.valueOf(bi.bH(currentTimeMillis)));
                            } else {
                                x.e("MicroMsg.MultiDex", "if need dexopt: targetDexFile md5 mismatch or not exists: %s", aVar.bFW);
                                return true;
                            }
                        }
                        return false;
                    }
                }
                x.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dexopt directory failed");
                return true;
            }
            x.f("MicroMsg.MultiDex", "if need dexopt: extractZipEntryToFile: create target dex directory failed");
            return true;
        }
    }

    public static synchronized boolean bh(Context context) {
        boolean z;
        synchronized (a.class) {
            x.i("MicroMsg.MultiDex", "install multidex hasinit: %b, force: %b", Boolean.valueOf(bFR), Boolean.valueOf(true));
            if (lY) {
                x.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
                z = true;
            } else if (bFR) {
                z = true;
            } else {
                if (context.getClassLoader() != null) {
                    x.i("MicroMsg.MultiDex", "classloader: " + context.getClassLoader().toString());
                } else {
                    x.e("MicroMsg.MultiDex", "classloader is null");
                }
                long currentTimeMillis = System.currentTimeMillis();
                bi(context);
                if (bFV == null || bFV.size() <= 0) {
                    z = false;
                } else {
                    try {
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if (applicationInfo == null) {
                            z = false;
                        } else {
                            bFS = context.getDir("cache", 0).getAbsolutePath();
                            bFT = context.getDir("dex", 0).getAbsolutePath();
                            bFU = context.getDir("cache", 0).getParentFile().getAbsolutePath() + "/dex.lock";
                            File file = new File(bFT);
                            if ((file.exists() && file.isDirectory()) || file.mkdirs()) {
                                int size = bFV.size();
                                File file2 = new File(bFS);
                                if ((file2.exists() && file2.isDirectory()) || file2.mkdirs()) {
                                    x.i("MicroMsg.MultiDex", "install Build.VERSION: %d, tryLoadDexFileCount: %d, installDir: %d, optDir: %d", Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(size), Integer.valueOf(file.list().length), Integer.valueOf(file2.list().length));
                                    List arrayList = new ArrayList(bFV.size());
                                    size = 0;
                                    Object obj = null;
                                    while (true) {
                                        int i = size;
                                        if (i >= 5 || r2 != null) {
                                            break;
                                        }
                                        arrayList.clear();
                                        for (a aVar : bFV) {
                                            x.i("MicroMsg.MultiDex", "prepare dex to load, file: %s, md5: %s, loadClass: %s", aVar.bFW, aVar.bFX, aVar.bFY);
                                            if (a(aVar)) {
                                                x.i("MicroMsg.MultiDex", "verify dex for check md5: targetFilePath: [%s] time: %d", aVar.bFW, Long.valueOf(bi.bH(currentTimeMillis)));
                                                if (b(context, aVar.bFY, false)) {
                                                    x.i("MicroMsg.MultiDex", "dex has been loaded, skip. targetFilePath: [%s]", aVar.bFW);
                                                } else {
                                                    x.w("MicroMsg.MultiDex", "dex [%s] is not load, it should be reload in further steps.", aVar.bFW);
                                                }
                                            } else {
                                                x.e("MicroMsg.MultiDex", "targetDexFile md5 mismatch or not exists: %s, force: %b", aVar.bFW, Boolean.valueOf(true));
                                                ZipFile zipFile = new ZipFile(applicationInfo.sourceDir);
                                                boolean a = a(zipFile, aVar);
                                                try {
                                                    zipFile.close();
                                                } catch (Exception e) {
                                                    x.w("MicroMsg.MultiDex", "base apk file close quietly failed");
                                                }
                                                if (!a) {
                                                    throw new Exception("overwriteLocalSecondaryDexFromApk fail");
                                                }
                                            }
                                            arrayList.add(new File(bFT + "/" + aVar.bFW));
                                        }
                                        if (arrayList.isEmpty()) {
                                            x.i("MicroMsg.MultiDex", "Nothing needs to be installed.");
                                            obj = 1;
                                            break;
                                        }
                                        a(context, bFS, arrayList);
                                        for (a aVar2 : bFV) {
                                            if (!b(context, aVar2.bFY, true)) {
                                                x.w("MicroMsg.MultiDex", "Failed to load dex [%s] in %d round, retry.", aVar2.bFW, Integer.valueOf(i + 1));
                                                String name = new File(bFT + "/" + aVar2.bFW).getName();
                                                if (!name.endsWith(".dex")) {
                                                    size = name.lastIndexOf(".");
                                                    if (size < 0) {
                                                        name = name + ".dex";
                                                    } else {
                                                        StringBuilder stringBuilder = new StringBuilder(size + 4);
                                                        stringBuilder.append(name, 0, size);
                                                        stringBuilder.append(".dex");
                                                        name = stringBuilder.toString();
                                                    }
                                                }
                                                File file3 = new File(file2, name);
                                                if (file3.exists()) {
                                                    x.w("MicroMsg.MultiDex", "Remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    if (!file3.delete()) {
                                                        x.w("MicroMsg.MultiDex", "Failed to remove perhaps broken odex file: " + file3.getAbsolutePath());
                                                    }
                                                }
                                                obj = null;
                                                size = i + 1;
                                            }
                                        }
                                        int obj2 = 1;
                                        size = i + 1;
                                    }
                                    if (obj2 == null) {
                                        throw new RuntimeException("Some dex is not installed successfully after 5 times retry !!");
                                    }
                                    bFR = true;
                                    x.i("MicroMsg.MultiDex", "install done");
                                    z = true;
                                } else {
                                    x.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dexopt directory failed");
                                    z = false;
                                }
                            } else {
                                x.f("MicroMsg.MultiDex", "extractZipEntryToFile: create target dex directory failed");
                                z = false;
                            }
                        }
                    } catch (Throwable th) {
                        x.e("MicroMsg.MultiDex", "Multidex installation failure", th);
                        x.printErrStackTrace("MicroMsg.MultiDex", th, "Multidex installation failure", new Object[0]);
                        ba(context);
                        RuntimeException runtimeException = new RuntimeException("Multi dex installation failed (" + th.getMessage() + ").", th);
                    }
                }
            }
        }
        return z;
    }

    private static boolean b(Context context, String str, boolean z) {
        try {
            if (Class.forName(str, false, context.getClassLoader()) != null) {
                return true;
            }
        } catch (Throwable e) {
            if (z) {
                x.printErrStackTrace("MicroMsg.MultiDex", e, "Failed to load a dex.", new Object[0]);
            }
        }
        if (!z) {
            return false;
        }
        x.w("MicroMsg.MultiDex", "checkDexLoaded fail.... " + str);
        return false;
    }

    private static boolean a(ZipFile zipFile, a aVar) {
        x.i("MicroMsg.MultiDex", "enter overwriteLocalSecondaryDexFromApk, please keep concerned at which process calls it.");
        File file = new File(bFU);
        String str = bFT + "/" + aVar.bFW;
        ShareFileLockHelper shareFileLockHelper = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            shareFileLockHelper = ShareFileLockHelper.ag(file);
            x.i("MicroMsg.MultiDex", "extract dex waiting for write lock cost %dms on file: %s", Long.valueOf(bi.bH(currentTimeMillis)), bFU);
            Closeable inputStream = zipFile.getInputStream(zipFile.getEntry(aVar.bFW));
            BufferedOutputStream bufferedOutputStream;
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    bufferedOutputStream.write(bArr, 0, read);
                }
                bufferedOutputStream.close();
                b(inputStream);
                x.i("MicroMsg.MultiDex", "extract dex from apk done: %s", bFU);
                try {
                    shareFileLockHelper.close();
                    return true;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    return true;
                }
            } catch (Throwable th) {
                b(inputStream);
            }
        } catch (Throwable e2) {
            try {
                x.printErrStackTrace("MicroMsg.MultiDex", e2, "", new Object[0]);
                x.e("MicroMsg.MultiDex", "overwrite local secondary dex failed, cannot lock file: %s", file.getAbsolutePath());
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.MultiDex", e22, "", new Object[0]);
                    }
                }
                return false;
            } catch (Throwable th2) {
                if (shareFileLockHelper != null) {
                    try {
                        shareFileLockHelper.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.MultiDex", e3, "", new Object[0]);
                    }
                }
            }
        }
    }

    private static boolean F(String str) {
        boolean z = false;
        if (str != null) {
            Matcher matcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(str);
            if (matcher.matches()) {
                try {
                    int parseInt = Integer.parseInt(matcher.group(1));
                    int parseInt2 = Integer.parseInt(matcher.group(2));
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 > 0)) {
                        z = true;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        x.i("MicroMsg.MultiDex", "VM with version " + str + (z ? " has multidex support" : " does not have multidex support"));
        return z;
    }

    private static boolean a(a aVar) {
        ShareFileLockHelper ag;
        Closeable fileInputStream;
        Throwable e;
        String str = bFT + "/" + aVar.bFW;
        File file = new File(str);
        if (file.isFile() && file.exists()) {
            File file2 = new File(bFU);
            try {
                long currentTimeMillis = System.currentTimeMillis();
                ag = ShareFileLockHelper.ag(file2);
                try {
                    x.i("MicroMsg.MultiDex", "extract dex waiting for verify lock cost %dms on file: %s", Long.valueOf(bi.bH(currentTimeMillis)), bFU);
                    fileInputStream = new FileInputStream(str);
                } catch (IOException e2) {
                    e = e2;
                    fileInputStream = null;
                    try {
                        x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                        x.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                        if (ag != null) {
                            try {
                                ag.close();
                            } catch (Exception e3) {
                                x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        b(fileInputStream);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (ag != null) {
                            try {
                                ag.close();
                            } catch (Exception e4) {
                                x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                            }
                        }
                        b(fileInputStream);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileInputStream = null;
                    if (ag != null) {
                        try {
                            ag.close();
                        } catch (Exception e42) {
                            x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                    }
                    b(fileInputStream);
                    throw e;
                }
                try {
                    str = g.b(fileInputStream, 102400);
                    if (str == null || !str.equalsIgnoreCase(aVar.bFX)) {
                        try {
                            ag.close();
                        } catch (Exception e5) {
                            x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                        b(fileInputStream);
                        return false;
                    }
                    try {
                        ag.close();
                    } catch (Exception e6) {
                        x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                    }
                    b(fileInputStream);
                    return true;
                } catch (IOException e7) {
                    e = e7;
                    x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
                    x.e("MicroMsg.MultiDex", "verify local secondary dex failed, cannot lock file: %s", file2.getAbsolutePath());
                    if (ag != null) {
                        try {
                            ag.close();
                        } catch (Exception e32) {
                            x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                        }
                    }
                    b(fileInputStream);
                    return false;
                }
            } catch (IOException e8) {
                e = e8;
                fileInputStream = null;
                ag = null;
            } catch (Throwable th3) {
                e = th3;
                fileInputStream = null;
                ag = null;
                if (ag != null) {
                    try {
                        ag.close();
                    } catch (Exception e422) {
                        x.e("MicroMsg.MultiDex", "verify local secondary dex failed to close lock file: %s", file2.getAbsolutePath());
                    }
                }
                b(fileInputStream);
                throw e;
            }
        }
        x.i("MicroMsg.MultiDex", "dex file not exist: %s", str);
        return false;
    }

    private static void a(Context context, String str, List<File> list) {
        PathClassLoader pathClassLoader = (PathClassLoader) context.getClassLoader();
        x.i("MicroMsg.MultiDex", "before reflectPathClassLoader for debug: ClassLoader " + pathClassLoader);
        Collections.sort(list, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                File file = (File) obj;
                File file2 = (File) obj2;
                if (file == null || file2 == null) {
                    return 0;
                }
                String name = file.getName();
                String name2 = file2.getName();
                return (name.contains("classes") && name2.contains("classes")) ? name.charAt(7) - name2.charAt(7) : 0;
            }
        });
        for (File name : list) {
            x.i("MicroMsg.MultiDex", "real reflectPathClassLoader dexname: " + name.getName());
        }
        File name2 = new File(str);
        if (!list.isEmpty()) {
            Object obj;
            if (VERSION.SDK_INT >= 19) {
                obj = b(pathClassLoader, "pathList").get(pathClassLoader);
                ArrayList arrayList = new ArrayList();
                b(obj, "dexElements", b.a(obj, new ArrayList(list), name2, arrayList));
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    if (it.hasNext()) {
                        x.w("MicroMsg.MultiDex", "Exception in makeDexElement", (IOException) it.next());
                        throw ((IOException) it.next());
                    }
                }
            }
            obj = b(pathClassLoader, "pathList").get(pathClassLoader);
            ArrayList arrayList2 = new ArrayList(list);
            b(obj, "dexElements", (Object[]) b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList2, name2}));
        }
        x.i("MicroMsg.MultiDex", "after reflectPathClassloader for debug: ClassLoader " + pathClassLoader);
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                x.w("MicroMsg.MultiDex", "Failed to close resource", e);
            }
        }
    }

    private static int bi(Context context) {
        if (bFV != null) {
            x.w("MicroMsg.MultiDex", "preloaded dex files not empty, skipped preloading");
            return 1;
        }
        try {
            Set set;
            String convertStreamToString = bi.convertStreamToString(context.getAssets().open("secondary-program-dex-jars/metadata.txt"));
            if (convertStreamToString == null || convertStreamToString.length() <= 0) {
                set = null;
            } else {
                set = new HashSet();
                for (String str : convertStreamToString.split("\n")) {
                    if (str != null && str.length() > 0) {
                        String[] split = str.split(" ", 3);
                        if (split != null && split.length >= 3) {
                            String trim = split[0].trim();
                            x.i("MicroMsg.MultiDex", "try parse dexname: %s, dexmd5:%s, classname:%s", trim, split[1].trim(), split[2].trim());
                            if (trim != null && trim.length() > 0) {
                                set.add(new a(trim, r7, str));
                            }
                        }
                    }
                }
            }
            bFV = set;
        } catch (Throwable e) {
            x.e("MicroMsg.MultiDex", "load preload libraries failed");
            x.printErrStackTrace("MicroMsg.MultiDex", e, "", new Object[0]);
        }
        return 0;
    }

    private static Field b(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    private static Method b(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }
}
