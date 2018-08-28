package com.google.android.exoplayer2.h;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import java.lang.reflect.InvocationTargetException;

public final class l implements f {
    private final t<? super f> aAB;
    private final f aBg;
    private f aBh;
    private f aBi;
    private f aBj;
    private f aBk;
    private f aiC;
    private final Context context;

    public l(Context context, t<? super f> tVar, f fVar) {
        this.context = context.getApplicationContext();
        this.aAB = tVar;
        this.aBg = (f) a.Z(fVar);
    }

    public final long a(i iVar) {
        a.ap(this.aiC == null);
        String scheme = iVar.uri.getScheme();
        if (t.e(iVar.uri)) {
            if (iVar.uri.getPath().startsWith("/android_asset/")) {
                this.aiC = lU();
            } else {
                if (this.aBh == null) {
                    this.aBh = new p(this.aAB);
                }
                this.aiC = this.aBh;
            }
        } else if ("asset".equals(scheme)) {
            this.aiC = lU();
        } else if ("content".equals(scheme)) {
            if (this.aBj == null) {
                this.aBj = new e(this.context, this.aAB);
            }
            this.aiC = this.aBj;
        } else if ("rtmp".equals(scheme)) {
            this.aiC = lV();
        } else {
            this.aiC = this.aBg;
        }
        return this.aiC.a(iVar);
    }

    public final int read(byte[] bArr, int i, int i2) {
        return this.aiC.read(bArr, i, i2);
    }

    public final Uri getUri() {
        return this.aiC == null ? null : this.aiC.getUri();
    }

    public final void close() {
        if (this.aiC != null) {
            try {
                this.aiC.close();
            } finally {
                this.aiC = null;
            }
        }
    }

    private f lU() {
        if (this.aBi == null) {
            this.aBi = new c(this.context, this.aAB);
        }
        return this.aBi;
    }

    private f lV() {
        if (this.aBk == null) {
            try {
                this.aBk = (f) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
            } catch (InstantiationException e2) {
            } catch (IllegalAccessException e3) {
            } catch (NoSuchMethodException e4) {
            } catch (InvocationTargetException e5) {
            }
            if (this.aBk == null) {
                this.aBk = this.aBg;
            }
        }
        return this.aBk;
    }
}
