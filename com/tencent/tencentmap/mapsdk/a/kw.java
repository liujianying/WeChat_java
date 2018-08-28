package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback$b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.tencentmap.mapsdk.a.kz.b;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class kw implements JNICallback$b, c, b {
    private WeakReference<ks> a;
    private WeakReference<f> b;
    private ky c;
    private ll d;
    private r e = null;
    private int f = Integer.MIN_VALUE;
    private volatile ExecutorService g = null;

    public kw(ks ksVar) {
        this.a = new WeakReference(ksVar);
        this.b = new WeakReference(ksVar.getMap());
        this.e = r.a(ksVar.getContext().getApplicationContext());
        this.c = new ky(this.e);
        this.d = ll.a(ksVar.getContext().getApplicationContext());
    }

    public void a(JNICallback$b jNICallback$b) {
        if (this.b != null && this.b.get() != null) {
            ((f) this.b.get()).a(jNICallback$b);
        }
    }

    public void a(c cVar) {
        if (this.b != null && this.b.get() != null) {
            ((f) this.b.get()).a(cVar);
        }
    }

    public int a() {
        if (!(this.b == null || this.b.get() == null)) {
            this.f = ((f) this.b.get()).B();
            ((f) this.b.get()).e(18);
        }
        return this.f;
    }

    public void b() {
        if (this.b != null && this.b.get() != null) {
            ((f) this.b.get()).g(this.f);
        }
    }

    public void c() {
        if (this.b != null && this.b.get() != null && this.f != Integer.MIN_VALUE) {
            ((f) this.b.get()).h(this.f);
        }
    }

    public Bitmap a(byte[] bArr) {
        if (this.a.get() == null) {
            return null;
        }
        ng ngVar = new ng();
        ngVar.a(bArr);
        Bitmap a = this.d.a(new nc(ngVar.a(), ngVar.b(), ngVar.c(), "handdrawmap"));
        if (a != null) {
            return a;
        }
        String a2 = this.c.a(ngVar.a(), ngVar.b(), ngVar.c());
        if (a2 == null) {
            return null;
        }
        Object bytes = a2.getBytes();
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return null;
    }

    public void a(String str, byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr != null && bArr2.length != 0 && bArr.length != 0) {
            if (this.g == null) {
                synchronized (kx.class) {
                    if (this.g == null) {
                        this.g = Executors.newSingleThreadExecutor();
                    }
                }
            }
            this.g.execute(new 1(this, str, bArr, bArr2));
        }
    }

    private boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        Matcher matcher = Pattern.compile("version=\\d+").matcher(str);
        if (!matcher.find()) {
            return false;
        }
        String group = matcher.group();
        if (Integer.parseInt(group.substring(group.indexOf("=") + 1)) == this.e.w()) {
            return true;
        }
        return false;
    }

    public void a(boolean z) {
        if (z) {
            c();
        }
    }
}
