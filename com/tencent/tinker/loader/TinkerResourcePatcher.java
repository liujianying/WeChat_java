package com.tencent.tinker.loader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.ArrayMap;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class TinkerResourcePatcher {
    private static Method vtA = null;
    private static Field vtB = null;
    private static Field vtC = null;
    private static Field vtD = null;
    private static Field vtE = null;
    private static Field vtF = null;
    private static Field vtG = null;
    private static Field vtH = null;
    private static Collection<WeakReference<Resources>> vtw = null;
    private static Object vtx = null;
    private static AssetManager vty = null;
    private static Method vtz = null;

    TinkerResourcePatcher() {
    }

    public static void hR(Context context) {
        Class cls;
        Class cls2 = Class.forName("android.app.ActivityThread");
        vtx = ShareReflectUtil.c(context, cls2);
        try {
            cls = Class.forName("android.app.LoadedApk");
        } catch (ClassNotFoundException e) {
            cls = Class.forName("android.app.ActivityThread$PackageInfo");
        }
        vtD = ShareReflectUtil.d(cls, "mResDir");
        vtE = ShareReflectUtil.d(cls2, "mPackages");
        if (VERSION.SDK_INT < 27) {
            vtF = ShareReflectUtil.d(cls2, "mResourcePackages");
        }
        AssetManager assets = context.getAssets();
        vtz = ShareReflectUtil.b(assets, "addAssetPath", String.class);
        try {
            vtH = ShareReflectUtil.b(assets, "mStringBlocks");
            vtA = ShareReflectUtil.b(assets, "ensureStringBlocks", new Class[0]);
        } catch (Throwable th) {
        }
        vty = (AssetManager) ShareReflectUtil.a(assets, new Class[0]).newInstance(new Object[0]);
        if (VERSION.SDK_INT >= 19) {
            cls2 = Class.forName("android.app.ResourcesManager");
            Object invoke = ShareReflectUtil.c(cls2, "getInstance", new Class[0]).invoke(null, new Object[0]);
            try {
                vtw = ((ArrayMap) ShareReflectUtil.d(cls2, "mActiveResources").get(invoke)).values();
            } catch (NoSuchFieldException e2) {
                vtw = (Collection) ShareReflectUtil.d(cls2, "mResourceReferences").get(invoke);
            }
        } else {
            vtw = ((HashMap) ShareReflectUtil.d(cls2, "mActiveResources").get(vtx)).values();
        }
        if (vtw == null) {
            throw new IllegalStateException("resource references is null");
        }
        Resources resources = context.getResources();
        if (VERSION.SDK_INT >= 24) {
            try {
                vtC = ShareReflectUtil.b(resources, "mResourcesImpl");
            } catch (Throwable th2) {
                vtB = ShareReflectUtil.b(resources, "mAssets");
            }
        } else {
            vtB = ShareReflectUtil.b(resources, "mAssets");
        }
        try {
            vtG = ShareReflectUtil.d(ApplicationInfo.class, "publicSourceDir");
        } catch (NoSuchFieldException e3) {
        }
    }

    public static void bQ(Context context, String str) {
        if (str != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            Field[] fieldArr;
            if (VERSION.SDK_INT < 27) {
                fieldArr = new Field[]{vtE, vtF};
            } else {
                fieldArr = new Field[]{vtE};
            }
            for (Field field : fieldArr) {
                for (Entry value : ((Map) field.get(vtx)).entrySet()) {
                    Object obj = ((WeakReference) value.getValue()).get();
                    if (obj != null) {
                        if (applicationInfo.sourceDir.equals((String) vtD.get(obj))) {
                            vtD.set(obj, str);
                        }
                    }
                }
            }
            if (((Integer) vtz.invoke(vty, new Object[]{str})).intValue() == 0) {
                throw new IllegalStateException("Could not create new AssetManager");
            }
            if (!(vtH == null || vtA == null)) {
                vtH.set(vty, null);
                vtA.invoke(vty, new Object[0]);
            }
            for (WeakReference weakReference : vtw) {
                Resources resources = (Resources) weakReference.get();
                if (resources != null) {
                    try {
                        vtB.set(resources, vty);
                    } catch (Throwable th) {
                        Object obj2 = vtC.get(resources);
                        ShareReflectUtil.b(obj2, "mAssets").set(obj2, vty);
                    }
                    c(resources);
                    resources.updateConfiguration(resources.getConfiguration(), resources.getDisplayMetrics());
                }
            }
            if (VERSION.SDK_INT >= 24) {
                try {
                    if (vtG != null) {
                        vtG.set(context.getApplicationInfo(), str);
                    }
                } catch (Throwable th2) {
                }
            }
            if (!hS(context)) {
                throw new TinkerRuntimeException("checkResInstall failed");
            }
        }
    }

    private static void c(Resources resources) {
        try {
            Object obj = ShareReflectUtil.d(Resources.class, "mTypedArrayPool").get(resources);
            do {
            } while (ShareReflectUtil.b(obj, "acquire", new Class[0]).invoke(obj, new Object[0]) != null);
        } catch (Throwable th) {
            new StringBuilder("clearPreloadTypedArrayIssue failed, ignore error: ").append(th);
        }
    }

    private static boolean hS(Context context) {
        Object open;
        Object obj = null;
        try {
            open = context.getAssets().open("only_use_to_test_tinker_resource.txt");
        } catch (Throwable th) {
            open = th;
            StringBuilder stringBuilder = new StringBuilder("checkResUpdate failed, can't find test resource assets file only_use_to_test_tinker_resource.txt e:");
            open = open.getMessage();
            stringBuilder.append(open);
            return false;
        } finally {
            SharePatchFileUtil.ar(
/*
Method generation error in method: com.tencent.tinker.loader.TinkerResourcePatcher.hS(android.content.Context):boolean, dex: 
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0027: INVOKE  (wrap: java.lang.Object
  ?: MERGE  (r3_1 java.lang.Object) = (r3_0 'obj' java.lang.Object), (r0_5 'open' java.lang.Object)) com.tencent.tinker.loader.shareutil.SharePatchFileUtil.ar(java.lang.Object):void type: STATIC in method: com.tencent.tinker.loader.TinkerResourcePatcher.hS(android.content.Context):boolean, dex: 
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
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r3_1 java.lang.Object) = (r3_0 'obj' java.lang.Object), (r0_5 'open' java.lang.Object) in method: com.tencent.tinker.loader.TinkerResourcePatcher.hS(android.content.Context):boolean, dex: 
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:686)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:656)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:338)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 21 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:537)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:509)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:211)
	... 26 more

*/
        }
