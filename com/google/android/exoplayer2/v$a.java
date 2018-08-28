package com.google.android.exoplayer2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.TextureView.SurfaceTextureListener;
import com.google.android.exoplayer2.a.e;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Iterator;
import java.util.List;

final class v$a implements Callback, SurfaceTextureListener, e, a, com.google.android.exoplayer2.metadata.e.a, com.google.android.exoplayer2.video.e {
    final /* synthetic */ v aeV;

    private v$a(v vVar) {
        this.aeV = vVar;
    }

    /* synthetic */ v$a(v vVar, byte b) {
        this(vVar);
    }

    public final void a(d dVar) {
        this.aeV.aeQ = dVar;
        if (this.aeV.aeP != null) {
            this.aeV.aeP.a(dVar);
        }
    }

    public final void c(Format format) {
        this.aeV.aeH = format;
        if (this.aeV.aeP != null) {
            this.aeV.aeP.c(format);
        }
    }

    public final void b(int i, int i2, int i3, float f) {
        Iterator it = this.aeV.aeC.iterator();
        while (it.hasNext()) {
            it.next();
        }
        if (this.aeV.aeP != null) {
            this.aeV.aeP.b(i, i2, i3, f);
        }
    }

    public final void b(Surface surface) {
        if (this.aeV.aeJ == surface) {
            Iterator it = this.aeV.aeC.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        if (this.aeV.aeP != null) {
            this.aeV.aeP.b(surface);
        }
    }

    public final void b(d dVar) {
        if (this.aeV.aeP != null) {
            this.aeV.aeP.b(dVar);
        }
        this.aeV.aeH = null;
        this.aeV.aeQ = null;
    }

    public final void c(d dVar) {
        this.aeV.aeR = dVar;
        if (this.aeV.aeO != null) {
            this.aeV.aeO.c(dVar);
        }
    }

    public final void cb(int i) {
        this.aeV.aeS = i;
        if (this.aeV.aeO != null) {
            this.aeV.aeO.cb(i);
        }
    }

    public final void b(String str, long j, long j2) {
        if (this.aeV.aeO != null) {
            this.aeV.aeO.b(str, j, j2);
        }
    }

    public final void d(Format format) {
        this.aeV.aeI = format;
        if (this.aeV.aeO != null) {
            this.aeV.aeO.d(format);
        }
    }

    public final void c(int i, long j, long j2) {
        if (this.aeV.aeO != null) {
            this.aeV.aeO.c(i, j, j2);
        }
    }

    public final void d(d dVar) {
        if (this.aeV.aeO != null) {
            this.aeV.aeO.d(dVar);
        }
        this.aeV.aeI = null;
        this.aeV.aeR = null;
        this.aeV.aeS = 0;
    }

    public final void k(List<com.google.android.exoplayer2.f.a> list) {
        Iterator it = this.aeV.aeD.iterator();
        while (it.hasNext()) {
            ((a) it.next()).k(list);
        }
    }

    public final void a(Metadata metadata) {
        Iterator it = this.aeV.aeE.iterator();
        while (it.hasNext()) {
            ((com.google.android.exoplayer2.metadata.e.a) it.next()).a(metadata);
        }
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        v.a(this.aeV, surfaceHolder.getSurface(), false);
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        v.a(this.aeV, null, false);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        v.a(this.aeV, new Surface(surfaceTexture), true);
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        v.a(this.aeV, null, true);
        return true;
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
