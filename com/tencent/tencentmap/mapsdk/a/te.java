package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tencentmap.mapsdk.a.tc.a;
import java.io.File;
import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class te {
    private static final String g = ("Qmap" + File.separator);
    private AtomicBoolean a = new AtomicBoolean(false);
    private volatile Context b;
    private AtomicInteger c = new AtomicInteger(0);
    private b d;
    private c e;
    private ReentrantReadWriteLock f = new ReentrantReadWriteLock();

    public static te a() {
        return a.a;
    }

    public static String a(byte[] bArr) {
        String str = "md5";
        if (bArr == null || bArr.length == 0) {
            return str;
        }
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return stringBuilder.toString();
                }
                String toHexString = Integer.toHexString(digest[i2] & WebView.NORMAL_MODE_ALPHA);
                if (toHexString.length() == 1) {
                    toHexString = "0" + toHexString;
                }
                stringBuilder.append(toHexString);
                i = i2 + 1;
            }
        } catch (Exception e) {
            new StringBuilder("CacheManager getMd5 failed:").append(e.toString());
            return str;
        }
    }

    private static byte[] c(byte[] bArr, String str) {
        try {
            int i;
            byte[] bytes = str.getBytes("UTF-8");
            int length = bytes.length + bArr.length;
            byte[] bArr2 = new byte[length];
            for (i = 0; i < bytes.length; i++) {
                bArr2[i] = bytes[i];
            }
            for (i = bytes.length; i < length; i++) {
                bArr2[i] = bArr[i - bytes.length];
            }
            return bArr2;
        } catch (Exception e) {
            new StringBuilder("CacheManager encode:").append(e.toString());
            return bArr;
        }
    }

    private static byte[] d(byte[] bArr, String str) {
        try {
            int length = str.getBytes("UTF-8").length;
            byte[] bArr2 = new byte[(bArr.length - length)];
            for (int i = length; i < bArr.length; i++) {
                bArr2[i - length] = bArr[i];
            }
            return bArr2;
        } catch (Exception e) {
            return bArr;
        }
    }

    public final tf a(td tdVar) {
        tf tfVar = new tf(null, sn.b(), "");
        if (!(this.e == null || tdVar.m() == a.e || tdVar.m() == a.d || (tdVar.m() == a.a && tdVar.n() == 7))) {
            this.f.readLock().lock();
            try {
                tfVar = this.e.a(tdVar);
            } catch (Throwable th) {
            } finally {
                this.f.readLock().unlock();
            }
        }
        return tfVar;
    }

    public final void a(Context context) {
        try {
            this.c.incrementAndGet();
            if (this.a.compareAndSet(false, true)) {
                this.b = context;
                this.d = new b(this, this.b);
                this.e = new c(this, this.d);
            }
        } catch (Throwable th) {
        }
    }

    public final boolean a(a aVar) {
        boolean z = false;
        if (this.e != null) {
            this.f.writeLock().lock();
            try {
                z = this.e.a(aVar);
            } catch (Throwable th) {
                new StringBuilder("clearCache error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z;
    }

    public final boolean a(td tdVar, byte[] bArr, boolean z) {
        boolean z2 = false;
        if (!(this.e == null || tdVar.m() == a.e || tdVar.m() == a.d || (tdVar.m() == a.a && tdVar.n() == 7))) {
            this.f.writeLock().lock();
            try {
                z2 = this.e.a(tdVar, null, true);
            } catch (Throwable th) {
                new StringBuilder("updateTile error:").append(th.toString());
            } finally {
                this.f.writeLock().unlock();
            }
        }
        return z2;
    }

    public final boolean a(tf tfVar, td tdVar) {
        if (this.e == null || tdVar.m() == a.e || tdVar.m() == a.d || (tdVar.m() == a.a && tdVar.n() == 7)) {
            return false;
        }
        int g;
        switch (1.a[tdVar.m().ordinal()]) {
            case 1:
                g = sn.g();
                break;
            case 2:
                g = sn.b();
                break;
            case 3:
                g = sn.d();
                break;
            default:
                g = -1;
                break;
        }
        this.f.writeLock().lock();
        try {
            boolean a;
            if (!tdVar.g() || tdVar.l() != g || this.e == null) {
                this.f.writeLock().unlock();
                return false;
            } else if (c.a(this.e, tdVar)) {
                a = this.e.a(tdVar, tfVar.c(), false);
                this.f.writeLock().unlock();
                return a;
            } else {
                a = this.e.a(tdVar, tfVar.c());
                this.f.writeLock().unlock();
                return a;
            }
        } catch (Throwable th) {
            this.f.writeLock().unlock();
            throw th;
        }
    }

    public final String b() {
        Object obj = 1;
        boolean equals = Environment.getExternalStorageState().equals("mounted");
        if (this.b == null) {
            return null;
        }
        String str;
        if (VERSION.SDK_INT >= 23) {
            int checkSelfPermission = this.b.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE");
            int checkSelfPermission2 = this.b.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE");
            if (!(checkSelfPermission == 0 && checkSelfPermission2 == 0)) {
                obj = null;
            }
        }
        if (!equals || obj == null) {
            str = this.b.getFileStreamPath("") + File.separator + g;
        } else {
            try {
                str = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + g;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        }
        rv.b(str);
        return str;
    }

    public final void c() {
        if (this.c.decrementAndGet() == 0) {
            if (this.e != null) {
                this.e.close();
            }
            this.a.compareAndSet(true, false);
        }
    }
}
