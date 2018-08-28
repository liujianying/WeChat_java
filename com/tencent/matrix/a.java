package com.tencent.matrix;

import android.app.Application;
import com.tencent.matrix.b.b;
import com.tencent.matrix.b.c;
import java.util.HashSet;
import java.util.Iterator;

public class a {
    private static volatile a boS;
    private final Application application;
    public final HashSet<b> boT;
    private final c boU;

    public static class a {
        public final Application application;
        public HashSet<b> boT;
        public c boU;

        public a(Application application) {
            if (application == null) {
                throw new RuntimeException("matrix init, application is null");
            }
            this.application = application;
        }

        public final a a(b bVar) {
            if (this.boT == null) {
                this.boT = new HashSet();
            }
            String tag = bVar.getTag();
            Iterator it = this.boT.iterator();
            while (it.hasNext()) {
                if (tag.equals(((b) it.next()).getTag())) {
                    throw new RuntimeException(String.format("plugin with tag %s is already exist", new Object[]{tag}));
                }
            }
            this.boT.add(bVar);
            return this;
        }
    }

    public /* synthetic */ a(Application application, c cVar, HashSet hashSet, byte b) {
        this(application, cVar, hashSet);
    }

    private a(Application application, c cVar, HashSet<b> hashSet) {
        this.application = application;
        this.boU = cVar;
        this.boT = hashSet;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            bVar.a(this.application, this.boU);
            this.boU.b(bVar);
        }
    }

    public static void a(com.tencent.matrix.d.b.a aVar) {
        com.tencent.matrix.d.b.b(aVar);
    }

    public static boolean isInstalled() {
        return boS != null;
    }

    public static a a(a aVar) {
        synchronized (a.class) {
            if (boS == null) {
                boS = aVar;
            } else {
                com.tencent.matrix.d.b.e("Matrix.Matrix", "Matrix instance is already set. this invoking will be ignored", new Object[0]);
            }
        }
        return boS;
    }

    public static a tg() {
        if (boS != null) {
            return boS;
        }
        throw new RuntimeException("you must init Matrix sdk first");
    }

    public final <T extends b> T g(Class<T> cls) {
        String name = cls.getName();
        Iterator it = this.boT.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.getClass().getName().equals(name)) {
                return bVar;
            }
        }
        return null;
    }
}
