package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class lo {
    public static boolean b = false;
    private static ReentrantReadWriteLock c = new ReentrantReadWriteLock();
    private static boolean e = false;
    private static boolean f = false;
    public boolean a = false;
    private a d;

    public void a(Context context) {
        try {
            c.writeLock().lock();
            r a = r.a(context);
            e = a.f();
            f = a.g();
            this.d = new a(a.h(), a.j(), a.i(), a.n(), a.o(), a.k(), a.l());
            byte[] d = kh.d(context, "frontier.dat");
            if (d != null) {
                try {
                    String[] d2 = kh.d(new String(d, "utf-8"));
                    if (d2 != null && d2.length >= 2) {
                        ln.a(d2[1]);
                    }
                    if (d2 != null && d2.length == 3) {
                        ln.b(d2[2]);
                    }
                } catch (UnsupportedEncodingException e) {
                }
            }
            c.writeLock().unlock();
        } catch (Throwable th) {
            c.writeLock().unlock();
        }
    }

    public boolean a() {
        return e;
    }

    public void a(boolean z) {
        e = z;
    }

    public static void b(boolean z) {
        f = z;
    }

    public boolean b() {
        return f;
    }

    public void a(int i, int i2, int i3, String str, String str2, String str3, String str4) {
        try {
            c.writeLock().lock();
            this.d = new a(i, i2, i3, str, str2, str3, str4);
        } finally {
            c.writeLock().unlock();
        }
    }

    public a c() {
        try {
            c.readLock().lock();
            a aVar = this.d;
            return aVar;
        } finally {
            c.readLock().unlock();
        }
    }
}
