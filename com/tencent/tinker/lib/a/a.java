package com.tencent.tinker.lib.a;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class a {

    private static final class a {
        static /* synthetic */ void b(ClassLoader classLoader, File file) {
            Object obj = ShareReflectUtil.b(classLoader, "pathList").get(classLoader);
            Field b = ShareReflectUtil.b(obj, "nativeLibraryDirectories");
            File[] fileArr = (File[]) b.get(obj);
            List arrayList = new ArrayList(fileArr.length + 1);
            arrayList.add(file);
            for (Object obj2 : fileArr) {
                if (!file.equals(obj2)) {
                    arrayList.add(obj2);
                }
            }
            b.set(obj, arrayList.toArray(new File[0]));
        }
    }

    private static final class b {
        static /* synthetic */ void c(ClassLoader classLoader, File file) {
            Collection arrayList;
            Object obj = ShareReflectUtil.b(classLoader, "pathList").get(classLoader);
            List list = (List) ShareReflectUtil.b(obj, "nativeLibraryDirectories").get(obj);
            if (list == null) {
                arrayList = new ArrayList(2);
            } else {
                Object arrayList2 = list;
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                if (file.equals((File) it.next())) {
                    it.remove();
                    break;
                }
            }
            arrayList2.add(0, file);
            Collection collection = (List) ShareReflectUtil.b(obj, "systemNativeLibraryDirectories").get(obj);
            if (collection == null) {
                collection = new ArrayList(2);
            }
            List arrayList3 = new ArrayList((arrayList2.size() + collection.size()) + 1);
            arrayList3.addAll(arrayList2);
            arrayList3.addAll(collection);
            Method b = ShareReflectUtil.b(obj, "makePathElements", List.class, File.class, List.class);
            ArrayList arrayList4 = new ArrayList();
            ShareReflectUtil.b(obj, "nativeLibraryPathElements").set(obj, (Object[]) b.invoke(obj, new Object[]{arrayList3, null, arrayList4}));
        }
    }

    private static final class c {
        static void d(ClassLoader classLoader, File file) {
            String path = file.getPath();
            Field b = ShareReflectUtil.b(classLoader, "libPath");
            String[] split = ((String) b.get(classLoader)).split(":");
            StringBuilder stringBuilder = new StringBuilder(path);
            for (String str : split) {
                if (!(str == null || path.equals(str))) {
                    stringBuilder.append(':').append(str);
                }
            }
            b.set(classLoader, stringBuilder.toString());
            Field b2 = ShareReflectUtil.b(classLoader, "libraryPathElements");
            List list = (List) b2.get(classLoader);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.equals((String) it.next())) {
                    it.remove();
                    break;
                }
            }
            list.add(0, path);
            b2.set(classLoader, list);
        }
    }

    public static boolean a(ApplicationLike applicationLike, String str) {
        String e = com.tencent.tinker.lib.e.b.e(applicationLike);
        if (ShareTinkerInternals.oW(e)) {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "failed to get current patch version.", new Object[0]);
            return false;
        }
        File hV = SharePatchFileUtil.hV(applicationLike.getApplication());
        if (hV == null) {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "failed to get current patch directory.", new Object[0]);
            return false;
        }
        File file = new File(new File(hV.getAbsolutePath() + "/" + SharePatchFileUtil.acV(e)).getAbsolutePath() + "/lib/lib/" + str);
        if (file.exists()) {
            ClassLoader classLoader = applicationLike.getApplication().getClassLoader();
            if (classLoader == null) {
                com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "classloader is null", new Object[0]);
                return false;
            }
            com.tencent.tinker.lib.f.a.i("Tinker.LoadLibrary", "before hack classloader:" + classLoader.toString(), new Object[0]);
            try {
                Method declaredMethod = a.class.getDeclaredMethod("a", new Class[]{ClassLoader.class, File.class});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(null, new Object[]{classLoader, file});
                com.tencent.tinker.lib.f.a.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
                return true;
            } catch (Throwable th) {
                com.tencent.tinker.lib.f.a.i("Tinker.LoadLibrary", "after hack classloader:" + classLoader.toString(), new Object[0]);
            }
        } else {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "tinker lib path [%s] is not exists.", file);
            return false;
        }
    }

    private static void a(ClassLoader classLoader, File file) {
        if (file == null || !file.exists()) {
            com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, folder %s is illegal", file);
        } else if ((VERSION.SDK_INT == 25 && VERSION.PREVIEW_SDK_INT != 0) || VERSION.SDK_INT > 25) {
            try {
                Collection arrayList;
                Object obj = ShareReflectUtil.b(classLoader, "pathList").get(classLoader);
                List list = (List) ShareReflectUtil.b(obj, "nativeLibraryDirectories").get(obj);
                if (list == null) {
                    arrayList = new ArrayList(2);
                } else {
                    Object arrayList2 = list;
                }
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (file.equals((File) it.next())) {
                        it.remove();
                        break;
                    }
                }
                arrayList2.add(0, file);
                Collection collection = (List) ShareReflectUtil.b(obj, "systemNativeLibraryDirectories").get(obj);
                if (collection == null) {
                    collection = new ArrayList(2);
                }
                List arrayList3 = new ArrayList((arrayList2.size() + collection.size()) + 1);
                arrayList3.addAll(arrayList2);
                arrayList3.addAll(collection);
                ShareReflectUtil.b(obj, "nativeLibraryPathElements").set(obj, (Object[]) ShareReflectUtil.b(obj, "makePathElements", List.class).invoke(obj, new Object[]{arrayList3}));
            } catch (Throwable th) {
                com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, v25 fail, sdk: %d, error: %s, try to fallback to V23", Integer.valueOf(VERSION.SDK_INT), th.getMessage());
                b.c(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 23) {
            try {
                b.c(classLoader, file);
            } catch (Throwable th2) {
                com.tencent.tinker.lib.f.a.e("Tinker.LoadLibrary", "installNativeLibraryPath, v23 fail, sdk: %d, error: %s, try to fallback to V14", Integer.valueOf(VERSION.SDK_INT), th2.getMessage());
                a.b(classLoader, file);
            }
        } else if (VERSION.SDK_INT >= 14) {
            a.b(classLoader, file);
        } else {
            c.d(classLoader, file);
        }
    }
}
