package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.gl.JNICallback$b;
import com.tencent.map.lib.gl.JNICallback.c;
import com.tencent.tencentmap.mapsdk.a.kz.b;
import javax.microedition.khronos.opengles.GL10;

public class kx extends ke implements JNICallback$b, c, b {
    private int a;
    private kw b;

    public kx(kw kwVar) {
        this.b = kwVar;
        this.b.a((JNICallback$b) this);
        this.b.a((c) this);
        this.a = kwVar.a();
        new StringBuilder("tileOverlayId:").append(this.a);
    }

    public Bitmap a(byte[] bArr) {
        if (this.b != null) {
            return this.b.a(bArr);
        }
        return null;
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
    }

    public void c() {
    }

    public void d() {
        e();
    }

    public void e() {
        if (this.b != null) {
            this.b.b();
        }
    }

    public void a(String str, byte[] bArr, byte[] bArr2) {
        if (this.b != null) {
            this.b.a(str, bArr, bArr2);
        }
    }

    public void a(boolean z) {
        if (this.b != null) {
            this.b.a(z);
        }
    }
}
