package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONObject;

public final class sg {
    private static List<rq> a = new CopyOnWriteArrayList();
    private static ConcurrentHashMap<String, Bitmap> b = new ConcurrentHashMap();
    private static ReentrantReadWriteLock g = new ReentrantReadWriteLock();
    private String c = null;
    private Context d;
    private WeakReference<sl> e;
    private AtomicInteger f = new AtomicInteger(0);

    public sg(sl slVar) {
        if (this.f.getAndIncrement() == 0) {
            a(sn.j());
        }
        this.d = sl.a();
        this.e = new WeakReference(slVar);
    }

    public static void a(String str) {
        if (str != null) {
            a.clear();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    JSONArray jSONArray2 = jSONObject.getJSONArray("level");
                    int i2 = jSONArray2.getInt(0);
                    int i3 = jSONArray2.getInt(1);
                    List arrayList = new ArrayList();
                    JSONArray jSONArray3 = jSONObject.getJSONArray("districts");
                    for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                        jSONObject = jSONArray3.getJSONObject(i4);
                        arrayList.add(new rp(jSONObject.getInt("rule"), jSONObject.getInt("priority"), jSONObject.getString("logo_name"), jSONObject.getString("logo"), jSONObject.getString("frontier")));
                    }
                    a.add(new rq(i2, i3, arrayList));
                }
            } catch (Throwable th) {
            }
        }
    }

    private boolean a(String str, Bitmap bitmap) {
        Throwable th;
        Closeable closeable = null;
        boolean z = false;
        g.writeLock().lock();
        if (bitmap != null) {
            Closeable fileOutputStream;
            try {
                File file = new File(b(str));
                if (file.exists()) {
                    rv.a(null);
                    g.writeLock().unlock();
                } else {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        z = bitmap.compress(CompressFormat.PNG, 100, fileOutputStream);
                        rv.a(fileOutputStream);
                        g.writeLock().unlock();
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = fileOutputStream;
                        rv.a(closeable);
                        g.writeLock().unlock();
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                rv.a(closeable);
                g.writeLock().unlock();
                throw th;
            }
        }
        return z;
    }

    private String b(String str) {
        String d = d();
        rv.b(d);
        return d + "/" + str;
    }

    private Bitmap c(String str) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        g.readLock().lock();
        Closeable fileInputStream;
        try {
            File file = new File(b(str));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    bitmap = BitmapFactory.decodeStream(fileInputStream);
                    rv.a(fileInputStream);
                    g.readLock().unlock();
                } catch (Throwable th2) {
                    th = th2;
                    closeable = fileInputStream;
                    rv.a(closeable);
                    g.readLock().unlock();
                    throw th;
                }
            }
            rv.a(bitmap);
            g.readLock().unlock();
        } catch (Throwable th3) {
            th = th3;
            closeable = bitmap;
            rv.a(closeable);
            g.readLock().unlock();
            throw th;
        }
        return bitmap;
    }

    private String d() {
        return this.d.getFilesDir() + "/logos";
    }

    public final void a() {
        g.writeLock().lock();
        b.clear();
        try {
            File file = new File(d());
            if (file.exists()) {
                File file2 = new File(this.d.getFilesDir() + "/oldLogos");
                if (file.renameTo(file2)) {
                    new 2(this, file2).start();
                } else {
                    rv.a(file.getAbsolutePath());
                }
            }
            g.writeLock().unlock();
        } catch (Throwable th) {
            g.writeLock().unlock();
            throw th;
        }
    }

    public final void a(rr rrVar) {
        float c = rrVar.c();
        for (rq rqVar : a) {
            if (c >= ((float) rqVar.a()) && c <= ((float) rqVar.b())) {
                break;
            }
        }
        rq rqVar2 = null;
        if (rqVar2 != null) {
            String[] a = rqVar2.a(rrVar);
            String str = a[0];
            String str2 = a[1];
            if ((str != this.c ? 1 : 0) != 0) {
                Bitmap bitmap = (Bitmap) b.get(str);
                if (bitmap != null) {
                    if (bitmap.isRecycled()) {
                        b.remove(str);
                    } else if (this.e.get() != null) {
                        ((sl) this.e.get()).a(bitmap);
                        this.c = str;
                        return;
                    }
                }
                Bitmap c2 = c(str);
                if (c2 == null || this.e.get() == null) {
                    this.c = null;
                    new 1(this, str2, str).start();
                    return;
                }
                this.c = str;
                b.put(this.c, c2);
                ((sl) this.e.get()).a(c2);
            }
        }
    }

    public final void b() {
        if (this.f.decrementAndGet() == 0) {
            if (VERSION.SDK_INT < 11) {
                for (Entry value : b.entrySet()) {
                    Bitmap bitmap = (Bitmap) value.getValue();
                    if (!(bitmap == null || bitmap.isRecycled())) {
                        bitmap.recycle();
                    }
                }
            }
            b.clear();
        }
    }
}
