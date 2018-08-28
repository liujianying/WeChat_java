package com.tencent.mm.svg.a;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class e {
    protected static String bqz;
    private static Class<?> bzf = null;
    protected static Application bzg;
    protected static Resources bzh;
    private static Method sCC = null;
    private static Method sCD = null;
    private static boolean tfd = false;
    private static volatile a tfe;
    private static LongSparseArray<ConstantState>[] tff;
    private static LongSparseArray<ConstantState> tfg;
    private static c<ConstantState> tfh;
    private static c<ConstantState> tfi;
    protected static Class<d> tfj;
    private static volatile boolean tfk = false;
    private static Map<WeakReference<Resources>, Map<Long, Integer>> tfl = new HashMap();
    private static boolean tfm = false;

    public static class a {
        Resources mResources;
        TypedValue teJ = new TypedValue();
        Map<Integer, com.tencent.mm.svg.c> teO;
        Application tfn;

        public a(Map<Integer, com.tencent.mm.svg.c> map, Application application, Resources resources) {
            this.teO = map;
            this.tfn = application;
            this.mResources = resources;
        }

        public final void a(Integer num, com.tencent.mm.svg.c cVar) {
            this.teO.put(num, cVar);
            e.a(this.tfn, this.mResources, num.intValue(), this.teJ);
        }
    }

    protected static class b extends ConstantState {
        private Resources mResources;
        private int oFj = 0;
        private long tfo = 0;

        public b(int i, Resources resources, long j) {
            if (i == 0) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "SVGConstantState Why this id is %d. TypedValue %s", Integer.valueOf(i));
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
            }
            this.oFj = i;
            this.mResources = resources;
            this.tfo = j;
        }

        public final Drawable newDrawable() {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable mResources:" + this.mResources, new Object[0]);
            return a.c(this.mResources, this.oFj);
        }

        public final Drawable newDrawable(Resources resources) {
            try {
                Map b = e.b(resources);
                if (b != null) {
                    int intValue = ((Integer) b.get(Long.valueOf(this.tfo))).intValue();
                    Drawable b2 = e.b(resources, intValue);
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "loadDrawableSkipCache id:" + Integer.toHexString(intValue) + ",drawable:" + b2, new Object[0]);
                    return b2;
                }
            } catch (Exception e) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "newDrawable loadDrawableSkipCache error:" + e.getMessage(), new Object[0]);
            }
            return newDrawable();
        }

        public final int getChangingConfigurations() {
            return 0;
        }
    }

    @TargetApi(16)
    public static class c<T> extends LongSparseArray<T> {
        public static boolean tfp = false;
        LongSparseArray<T> tfg = null;

        public final T get(long j, T t) {
            synchronized (this.tfg) {
                if (this.tfg.indexOfKey(j) >= 0) {
                    T t2 = this.tfg.get(j, t);
                    return t2;
                }
                return super.get(j, t);
            }
        }

        public final void delete(long j) {
            super.delete(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! delete key %s", Long.valueOf(j));
        }

        public final void remove(long j) {
            super.remove(j);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! remove key %s", Long.valueOf(j));
        }

        public final void clear() {
            super.clear();
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGLongSparseArray", "Found u! clear.", new Object[0]);
        }
    }

    static /* synthetic */ void a(Application application, Resources resources, int i, TypedValue typedValue) {
        if (i == 0) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "preloadDrawable Why this id is %d. TypedValue %s", Integer.valueOf(i), typedValue);
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", Log.getStackTraceString(new Throwable()), new Object[0]);
        }
        resources.getValue(i, typedValue, true);
        long j = (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
        b bVar = new b(i, application.getResources(), j);
        synchronized (tfg) {
            tfg.put(j, bVar);
        }
    }

    static /* synthetic */ Map b(Resources resources) {
        for (WeakReference weakReference : tfl.keySet()) {
            Resources resources2 = (Resources) weakReference.get();
            if (resources2 != null && resources2 == resources) {
                return (Map) tfl.get(weakReference);
            }
        }
        return null;
    }

    public static void a(Resources resources, Map<Long, Integer> map) {
        int i;
        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "addFilterResources:" + resources, new Object[0]);
        for (WeakReference weakReference : tfl.keySet()) {
            if (weakReference.get() == resources) {
                i = 1;
                break;
            }
        }
        i = 0;
        if (i == 0) {
            tfl.put(new WeakReference(resources), map);
        }
    }

    public static void h(Class<?> cls) {
        bzf = cls;
    }

    public static void a(com.tencent.mm.svg.b.c.a aVar) {
        com.tencent.mm.svg.b.c.b(aVar);
    }

    public static void d(Application application, String str) {
        if (tfm) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg initiated.", new Object[0]);
            return;
        }
        bqz = str;
        a.cQ(str);
        com.tencent.mm.svg.b.b.cQ(str);
        bzg = application;
        gk(application);
    }

    public static void a(Application application, Resources resources, String str) {
        Throwable e;
        boolean z;
        long nanoTime;
        Throwable th;
        boolean z2;
        boolean z3;
        d(application, str);
        if (tfk) {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "svg loaded, skip this time.", new Object[0]);
            return;
        }
        String str2 = bqz + ".svg.SVGPreload";
        long nanoTime2;
        try {
            com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "try to load SVGPreload", new Object[0]);
            Class cls = Class.forName(str2);
            nanoTime2 = System.nanoTime();
            bzg = application;
            tfj = cls;
            bzh = resources;
            try {
                if (tfj != null) {
                    ((d) cls.newInstance()).load(b(application, bzh));
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVGCode wrapper size %s", Integer.valueOf(b(application, bzh).teO.size()));
                    tfd = true;
                }
            } catch (Throwable e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "We found one NotFoundException.", new Object[0]);
                tfd = false;
            }
            try {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "load SVGPreload spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                tfk = true;
            } catch (ClassNotFoundException e3) {
                z = true;
                try {
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "ClassNotFoundException %s. Go fallback logic.", str2);
                    if (z) {
                        tfk = true;
                        return;
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    gk(application);
                    try {
                        c(application, resources);
                    } catch (ClassNotFoundException e4) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                } catch (Throwable th2) {
                    th = th2;
                    z2 = z;
                    if (z2) {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime2 = System.nanoTime();
                        gk(application);
                        try {
                            c(application, resources);
                        } catch (ClassNotFoundException e5) {
                        }
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                    } else {
                        tfk = true;
                    }
                    throw th;
                }
            } catch (InstantiationException e6) {
                e2 = e6;
                z3 = true;
                try {
                    com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                    com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
                    if (z3) {
                        tfk = true;
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime = System.nanoTime();
                    gk(application);
                    try {
                        c(application, resources);
                    } catch (ClassNotFoundException e7) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
                } catch (Throwable e22) {
                    th = e22;
                    z2 = z3;
                    if (z2) {
                        tfk = true;
                    } else {
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                        nanoTime2 = System.nanoTime();
                        gk(application);
                        try {
                            c(application, resources);
                        } catch (ClassNotFoundException e52) {
                        }
                        com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                    }
                    throw th;
                }
            } catch (IllegalAccessException e8) {
                e22 = e8;
                z3 = true;
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e22, "", new Object[0]);
                if (z3) {
                    tfk = true;
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                gk(application);
                try {
                    c(application, resources);
                } catch (ClassNotFoundException e9) {
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            } catch (Throwable e222) {
                th = e222;
                z2 = true;
                if (z2) {
                    tfk = true;
                } else {
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                    nanoTime2 = System.nanoTime();
                    gk(application);
                    try {
                        c(application, resources);
                    } catch (ClassNotFoundException e522) {
                    }
                    com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
                }
                throw th;
            }
        } catch (ClassNotFoundException e10) {
            z = false;
        } catch (InstantiationException e11) {
            e222 = e11;
            z3 = false;
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e222, "", new Object[0]);
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "InstantiationException %s", str2);
            if (z3) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                gk(application);
                try {
                    c(application, resources);
                } catch (ClassNotFoundException e72) {
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
            tfk = true;
        } catch (IllegalAccessException e12) {
            e222 = e12;
            z3 = false;
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "IllegalAccessException %s", str2);
            com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e222, "", new Object[0]);
            if (z3) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime = System.nanoTime();
                gk(application);
                try {
                    c(application, resources);
                } catch (ClassNotFoundException e92) {
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime) / 1000));
            }
            tfk = true;
        } catch (Throwable e2222) {
            th = e2222;
            z2 = false;
            if (z2) {
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG initSVGPreloadFallback", new Object[0]);
                nanoTime2 = System.nanoTime();
                gk(application);
                try {
                    c(application, resources);
                } catch (ClassNotFoundException e5222) {
                }
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG fallback Register spent %s", Long.valueOf((System.nanoTime() - nanoTime2) / 1000));
            } else {
                tfk = true;
            }
            throw th;
        }
    }

    private static a b(Application application, Resources resources) {
        if (tfe == null) {
            synchronized (e.class) {
                if (tfe == null) {
                    tfe = new a(a.cog(), application, resources);
                }
            }
        }
        return tfe;
    }

    @TargetApi(16)
    private static void gk(Context context) {
        int i = 1;
        if (tfh == null) {
            try {
                Object obj;
                tfg = new LongSparseArray();
                c cVar = new c();
                tfh = cVar;
                cVar.tfg = tfg;
                cVar = new c();
                tfi = cVar;
                cVar.tfg = tfg;
                if (VERSION.SDK_INT >= 23) {
                    com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "mResourcesImpl");
                    aVar.prepare();
                    if (aVar.dfG == null) {
                        i = 0;
                    }
                    if (i != 0) {
                        obj = aVar.get();
                    } else {
                        obj = context.getResources();
                    }
                } else {
                    obj = context.getResources();
                }
                a(context, obj);
                com.tencent.mm.svg.b.c.i("MicroMsg.SVGResourceLoader", "SVG this resources %s", context.getResources());
            } catch (Throwable e) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "Call reflectPreloadCache failed. Reason : NoSuchFieldException.", new Object[0]);
            } catch (Throwable e2) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "Call reflectPreloadCache failed. Reason : IllegalAccessException.", new Object[0]);
            } catch (Throwable e22) {
                com.tencent.mm.svg.b.c.printErrStackTrace("MicroMsg.SVGResourceLoader", e22, "Call reflectPreloadCache failed. Reason : IllegalArgumentException.", new Object[0]);
            }
        }
    }

    @TargetApi(16)
    private static void a(Context context, Object obj) {
        Object obj2 = new com.tencent.mm.svg.b.a(obj, "sPreloadedDrawables").get();
        if (obj2 == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is null!! OMG!!!", new Object[0]);
        } else if (obj2 instanceof LongSparseArray[]) {
            int i;
            long keyAt;
            tff = (LongSparseArray[]) obj2;
            com.tencent.mm.svg.b.c.d("MicroMsg.SVGResourceLoader", "sPreloadDrawable content: %s ", tff[0]);
            for (i = 0; i < tff[0].size(); i++) {
                keyAt = tff[0].keyAt(i);
                tfh.put(keyAt, tff[0].get(keyAt));
            }
            for (i = 0; i < tff[1].size(); i++) {
                keyAt = tff[1].keyAt(i);
                tfi.put(keyAt, tff[1].get(keyAt));
            }
            tff[0] = tfh;
            tff[1] = tfi;
        } else if (obj2 instanceof LongSparseArray) {
            com.tencent.mm.svg.b.a aVar = new com.tencent.mm.svg.b.a(context.getResources(), "sPreloadedDrawables");
            LongSparseArray longSparseArray = (LongSparseArray) aVar.get();
            for (int i2 = 0; i2 < longSparseArray.size(); i2++) {
                long keyAt2 = longSparseArray.keyAt(i2);
                tfh.put(keyAt2, longSparseArray.get(keyAt2));
            }
            c cVar = tfh;
            aVar.prepare();
            if (aVar.dfG == null) {
                throw new NoSuchFieldException();
            }
            aVar.dfG.set(aVar.obj, cVar);
            if (aVar.get() == null) {
                com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "resourcePreloadDrawable is null!! OMG!!", new Object[0]);
            }
        } else {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "mResourcePreloadDrawable is others!! OMG!", new Object[0]);
        }
    }

    private static Class<?> cok() {
        if (bzf != null) {
            return bzf;
        }
        Class<?> cls;
        try {
            cls = Class.forName(bqz + ".R$raw");
            if (cls != null) {
                return cls;
            }
        } catch (ClassNotFoundException e) {
        }
        cls = com.tencent.mm.svg.b.b.con();
        return cls == null ? null : cls;
    }

    private static void c(Application application, Resources resources) {
        Class cok = cok();
        if (cok == null) {
            com.tencent.mm.svg.b.c.e("MicroMsg.SVGResourceLoader", "Raw class is null!", new Object[0]);
            return;
        }
        Field[] declaredFields = cok.getDeclaredFields();
        a b = b(application, resources);
        try {
            a aVar = new a();
            for (Field field : declaredFields) {
                int i = field.getInt(null);
                if (aVar.d(application.getResources(), i)) {
                    a(b.tfn, b.mResources, i, b.teJ);
                }
            }
            tfd = true;
        } catch (IllegalAccessException e) {
            tfd = false;
        } catch (IllegalArgumentException e2) {
            tfd = false;
        }
    }

    public static Drawable b(Resources resources, int i) {
        Drawable colorDrawable;
        Method declaredMethod;
        NotFoundException notFoundException;
        boolean z = true;
        TypedValue typedValue = new TypedValue();
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        }
        if (z) {
            colorDrawable = new ColorDrawable(typedValue.data);
        } else {
            colorDrawable = null;
        }
        if (sCC == null) {
            try {
                declaredMethod = Resources.class.getDeclaredMethod("loadXmlResourceParser", new Class[]{String.class, Integer.TYPE, Integer.TYPE, String.class});
                sCC = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e, "", new Object[0]);
                return null;
            }
        }
        if (sCD == null) {
            try {
                declaredMethod = AssetManager.class.getDeclaredMethod("openNonAsset", new Class[]{Integer.TYPE, String.class, Integer.TYPE});
                sCD = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                x.printErrStackTrace("MicroMsg.SVGResourceLoader", e2, "", new Object[0]);
                return null;
            }
        }
        if (colorDrawable == null) {
            if (typedValue.string == null) {
                throw new NotFoundException("Resource is not a Drawable (color or path): " + typedValue);
            }
            String charSequence = typedValue.string.toString();
            Drawable createFromXml;
            if (charSequence.endsWith(".xml")) {
                try {
                    XmlResourceParser xmlResourceParser = (XmlResourceParser) sCC.invoke(resources, new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(typedValue.assetCookie), "drawable"});
                    createFromXml = Drawable.createFromXml(resources, xmlResourceParser);
                    xmlResourceParser.close();
                    colorDrawable = createFromXml;
                } catch (Throwable e22) {
                    notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                    notFoundException.initCause(e22);
                    throw notFoundException;
                }
            }
            try {
                InputStream inputStream = (InputStream) sCD.invoke(resources.getAssets(), new Object[]{Integer.valueOf(typedValue.assetCookie), charSequence, Integer.valueOf(2)});
                createFromXml = Drawable.createFromResourceStream(resources, typedValue, inputStream, charSequence, null);
                inputStream.close();
                colorDrawable = createFromXml;
            } catch (Throwable e222) {
                notFoundException = new NotFoundException("File " + charSequence + " from drawable resource ID #0x" + Integer.toHexString(i));
                notFoundException.initCause(e222);
                throw notFoundException;
            }
        }
        return colorDrawable;
    }
}
