package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a {
    private static final String lW = ("code_cache" + File.separator + "secondary-dexes");
    private static final Set<String> lX = new HashSet();
    private static final boolean lY = F(System.getProperty("java.vm.version"));

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void H(android.content.Context r6) {
        /*
        r0 = lY;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 4;
        if (r0 >= r1) goto L_0x0029;
    L_0x000a:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r2 = "Multi dex installation failed. SDK ";
        r1.<init>(r2);
        r2 = android.os.Build.VERSION.SDK_INT;
        r1 = r1.append(r2);
        r2 = " is unsupported. Min SDK version is 4.";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0029:
        r0 = I(r6);	 Catch:{ Exception -> 0x0041 }
        if (r0 == 0) goto L_0x0004;
    L_0x002f:
        r1 = lX;	 Catch:{ Exception -> 0x0041 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0041 }
        r2 = r0.sourceDir;	 Catch:{ all -> 0x003e }
        r3 = lX;	 Catch:{ all -> 0x003e }
        r3 = r3.contains(r2);	 Catch:{ all -> 0x003e }
        if (r3 == 0) goto L_0x0063;
    L_0x003c:
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x0004;
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        throw r0;	 Catch:{ Exception -> 0x0041 }
    L_0x0041:
        r0 = move-exception;
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r3 = "Multi dex installation failed (";
        r2.<init>(r3);
        r0 = r0.getMessage();
        r0 = r2.append(r0);
        r2 = ").";
        r0 = r0.append(r2);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x0063:
        r3 = lX;	 Catch:{ all -> 0x003e }
        r3.add(r2);	 Catch:{ all -> 0x003e }
        r2 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003e }
        r3 = 20;
        if (r2 <= r3) goto L_0x0094;
    L_0x006e:
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x003e }
        r3 = "MultiDex is not guaranteed to work in SDK version ";
        r2.<init>(r3);	 Catch:{ all -> 0x003e }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x003e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = ": SDK version higher than 20 should be backed by runtime with built-in multidex capabilty but it's not the case here: java.vm.version=\"";
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = "java.vm.version";
        r3 = java.lang.System.getProperty(r3);	 Catch:{ all -> 0x003e }
        r2 = r2.append(r3);	 Catch:{ all -> 0x003e }
        r3 = "\"";
        r2.append(r3);	 Catch:{ all -> 0x003e }
    L_0x0094:
        r2 = r6.getClassLoader();	 Catch:{ RuntimeException -> 0x009d }
        if (r2 != 0) goto L_0x00a1;
    L_0x009a:
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x0004;
    L_0x009d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x0004;
    L_0x00a1:
        J(r6);	 Catch:{ Throwable -> 0x00d6 }
    L_0x00a4:
        r3 = new java.io.File;	 Catch:{ all -> 0x003e }
        r4 = r0.dataDir;	 Catch:{ all -> 0x003e }
        r5 = lW;	 Catch:{ all -> 0x003e }
        r3.<init>(r4, r5);	 Catch:{ all -> 0x003e }
        r4 = 0;
        r4 = android.support.multidex.b.a(r6, r0, r3, r4);	 Catch:{ all -> 0x003e }
        r5 = f(r4);	 Catch:{ all -> 0x003e }
        if (r5 == 0) goto L_0x00be;
    L_0x00b8:
        a(r2, r3, r4);	 Catch:{ all -> 0x003e }
    L_0x00bb:
        monitor-exit(r1);	 Catch:{ all -> 0x003e }
        goto L_0x0004;
    L_0x00be:
        r4 = 1;
        r0 = android.support.multidex.b.a(r6, r0, r3, r4);	 Catch:{ all -> 0x003e }
        r4 = f(r0);	 Catch:{ all -> 0x003e }
        if (r4 == 0) goto L_0x00cd;
    L_0x00c9:
        a(r2, r3, r0);	 Catch:{ all -> 0x003e }
        goto L_0x00bb;
    L_0x00cd:
        r0 = new java.lang.RuntimeException;	 Catch:{ all -> 0x003e }
        r2 = "Zip files were not valid.";
        r0.<init>(r2);	 Catch:{ all -> 0x003e }
        throw r0;	 Catch:{ all -> 0x003e }
    L_0x00d6:
        r3 = move-exception;
        goto L_0x00a4;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.multidex.a.H(android.content.Context):void");
    }

    private static ApplicationInfo I(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String packageName = context.getPackageName();
            if (packageManager == null || packageName == null) {
                return null;
            }
            return packageManager.getApplicationInfo(packageName, MapRouteSectionWithName.kMaxRoadNameLength);
        } catch (RuntimeException e) {
            return null;
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
        new StringBuilder("VM with version ").append(str).append(z ? " has multidex support" : " does not have multidex support");
        return z;
    }

    private static void a(ClassLoader classLoader, File file, List<File> list) {
        if (!list.isEmpty()) {
            Object obj;
            ArrayList arrayList;
            if (VERSION.SDK_INT >= 19) {
                obj = b(classLoader, "pathList").get(classLoader);
                ArrayList arrayList2 = new ArrayList();
                arrayList = new ArrayList(list);
                a(obj, "dexElements", (Object[]) b(obj, "makeDexElements", ArrayList.class, File.class, ArrayList.class).invoke(obj, new Object[]{arrayList, file, arrayList2}));
                if (arrayList2.size() > 0) {
                    Object obj2;
                    Iterator it = arrayList2.iterator();
                    while (it.hasNext()) {
                        it.next();
                    }
                    Field b = b(classLoader, "dexElementsSuppressedExceptions");
                    IOException[] iOExceptionArr = (IOException[]) b.get(classLoader);
                    if (iOExceptionArr == null) {
                        obj2 = (IOException[]) arrayList2.toArray(new IOException[arrayList2.size()]);
                    } else {
                        obj = new IOException[(arrayList2.size() + iOExceptionArr.length)];
                        arrayList2.toArray(obj);
                        System.arraycopy(iOExceptionArr, 0, obj, arrayList2.size(), iOExceptionArr.length);
                        obj2 = obj;
                    }
                    b.set(classLoader, obj2);
                }
            } else if (VERSION.SDK_INT >= 14) {
                obj = b(classLoader, "pathList").get(classLoader);
                arrayList = new ArrayList(list);
                a(obj, "dexElements", (Object[]) b(obj, "makeDexElements", ArrayList.class, File.class).invoke(obj, new Object[]{arrayList, file}));
            } else {
                a.a(classLoader, list);
            }
        }
    }

    private static boolean f(List<File> list) {
        for (File f : list) {
            if (!b.f(f)) {
                return false;
            }
        }
        return true;
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

    private static void J(Context context) {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            new StringBuilder("Clearing old secondary dex dir (").append(file.getPath()).append(").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                new StringBuilder("Failed to list secondary dex dir content (").append(file.getPath()).append(").");
                return;
            }
            for (File file2 : listFiles) {
                new StringBuilder("Trying to delete old file ").append(file2.getPath()).append(" of size ").append(file2.length());
                if (file2.delete()) {
                    new StringBuilder("Deleted old file ").append(file2.getPath());
                } else {
                    new StringBuilder("Failed to delete old file ").append(file2.getPath());
                }
            }
            if (file.delete()) {
                new StringBuilder("Deleted old secondary dex dir ").append(file.getPath());
            } else {
                new StringBuilder("Failed to delete secondary dex dir ").append(file.getPath());
            }
        }
    }
}
