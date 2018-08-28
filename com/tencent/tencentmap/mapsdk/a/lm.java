package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tencentmap.mapsdk.a.ic.c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

public class lm extends ke implements j, k, hb, hc, he {
    public static final String d = (Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry());
    nj a;
    public final int b = WXMediaMessage.TITLE_LENGTH_LIMIT;
    boolean c;
    private WeakReference<ks> e;
    private la f;
    private ll g;
    private int h = -1;
    private lo i;
    private volatile ExecutorService j = null;

    public lm(ks ksVar, lo loVar, nj njVar, boolean z) {
        this.g = ll.a(ksVar.getContext().getApplicationContext());
        a(ksVar, loVar, njVar);
        this.h = ksVar.getMap().e(z);
    }

    private void a(ks ksVar, lo loVar, nj njVar) {
        this.e = new WeakReference(ksVar);
        this.i = loVar;
        this.a = njVar;
        this.f = new la(ksVar);
        ksVar.getMap().a(this);
        ksVar.getMap().a(this);
        ksVar.getMap().a(this);
        ksVar.getMap().a(this);
        ksVar.getMap().a(this);
        ln.a(false);
    }

    public void a(GL10 gl10) {
    }

    public boolean a(float f, float f2) {
        return false;
    }

    public boolean a() {
        return false;
    }

    public void b() {
        if (!(this.e == null || this.e.get() == null)) {
            ((ks) this.e.get()).getMap().b(this);
            ((ks) this.e.get()).getMap().b(this);
            ((ks) this.e.get()).getMap().a(null);
            ((ks) this.e.get()).getMap().a(null);
        }
        System.gc();
    }

    public void d() {
        if (this.e != null && this.e.get() != null) {
            ((ks) this.e.get()).getMap().g(this.h);
            b();
        }
    }

    public void c() {
    }

    public Bitmap a(byte[] bArr) {
        if (this.e == null || this.e.get() == null || !((ks) this.e.get()).q()) {
            return null;
        }
        ng ngVar = new ng();
        ngVar.a(bArr);
        this.f.a().e();
        nc ncVar = new nc(ngVar.a(), ngVar.b(), ngVar.c(), this.i.c().a());
        Bitmap a = this.g.a(ncVar);
        if (a != null) {
            return a;
        }
        String a2 = this.a.a(ncVar.a(), ncVar.b(), ncVar.c());
        if (a2 == null) {
            return null;
        }
        Object bytes = a2.getBytes();
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        return null;
    }

    public void b_() {
        c();
    }

    public void a(c cVar) {
        if (cVar != c.a) {
            c();
        }
    }

    public void a(double d) {
        if (d > 1.0d || d < -1.0d) {
            c();
        }
    }

    public void a(String str, byte[] bArr, byte[] bArr2) {
        if (this.j == null) {
            synchronized (lm.class) {
                if (this.j == null) {
                    this.j = Executors.newSingleThreadExecutor();
                }
            }
        }
        this.j.execute(new 1(this, str, bArr, bArr2));
    }

    private boolean a(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        boolean z;
        boolean z2 = (str.contains("world") || str.contains("oversea")) ? false : true;
        if (str.contains("world") || str.contains("oversea")) {
            z = true;
        } else {
            z = false;
        }
        String a = this.i.c().a();
        if (z2 && !"taiwanmap".equals(a)) {
            return false;
        }
        if (!z || "bingmap".equals(a) || "googlemap".equals(a)) {
            return true;
        }
        return false;
    }

    private boolean b(String str) {
        if (str != null && str.length() > 0) {
            if (!str.contains("world") && !str.contains("oversea")) {
                return true;
            }
            Matcher matcher = Pattern.compile("version=\\d+").matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                if (Integer.parseInt(group.substring(group.indexOf("=") + 1)) != this.i.c().c) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}
