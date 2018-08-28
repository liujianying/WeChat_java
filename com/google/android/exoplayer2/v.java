package com.google.android.exoplayer2;

import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.a.b;
import com.google.android.exoplayer2.b.d;
import com.google.android.exoplayer2.f.c;
import com.google.android.exoplayer2.f.j.a;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.metadata.e;
import com.google.android.exoplayer2.source.f;
import java.util.concurrent.CopyOnWriteArraySet;

@TargetApi(16)
public final class v implements f {
    protected final r[] acG;
    private final f adi;
    private final a aeB = new a(this, (byte) 0);
    final CopyOnWriteArraySet<Object> aeC = new CopyOnWriteArraySet();
    final CopyOnWriteArraySet<a> aeD = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet<e.a> aeE = new CopyOnWriteArraySet();
    private final int aeF;
    private final int aeG;
    Format aeH;
    Format aeI;
    Surface aeJ;
    private boolean aeK;
    private int aeL;
    private SurfaceHolder aeM;
    private TextureView aeN;
    public com.google.android.exoplayer2.a.e aeO;
    com.google.android.exoplayer2.video.e aeP;
    d aeQ;
    d aeR;
    int aeS;
    private b aeT;
    private float aeU;

    static /* synthetic */ void a(v vVar, Surface surface, boolean z) {
        c[] cVarArr = new c[vVar.aeF];
        r[] rVarArr = vVar.acG;
        int length = rVarArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3;
            r rVar = rVarArr[i];
            if (rVar.getTrackType() == 2) {
                i3 = i2 + 1;
                cVarArr[i2] = new c(rVar, surface);
            } else {
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        if (vVar.aeJ == null || vVar.aeJ == surface) {
            vVar.adi.a(cVarArr);
        } else {
            vVar.adi.b(cVarArr);
            if (vVar.aeK) {
                vVar.aeJ.release();
            }
        }
        vVar.aeJ = surface;
        vVar.aeK = z;
    }

    protected v(u uVar, g gVar, m mVar) {
        this.acG = uVar.a(new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()), this.aeB, this.aeB, this.aeB, this.aeB);
        int i = 0;
        int i2 = 0;
        for (r trackType : this.acG) {
            switch (trackType.getTrackType()) {
                case 1:
                    i++;
                    break;
                case 2:
                    i2++;
                    break;
                default:
                    break;
            }
        }
        this.aeF = i2;
        this.aeG = i;
        this.aeU = 1.0f;
        this.aeS = 0;
        this.aeT = b.afu;
        this.aeL = 1;
        this.adi = new h(this.acG, gVar, mVar);
    }

    public final void a(q.a aVar) {
        this.adi.a(aVar);
    }

    public final void b(q.a aVar) {
        this.adi.b(aVar);
    }

    public final int iB() {
        return this.adi.iB();
    }

    public final void a(f fVar) {
        this.adi.a(fVar);
    }

    public final void af(boolean z) {
        this.adi.af(z);
    }

    public final boolean iC() {
        return this.adi.iC();
    }

    public final boolean iD() {
        return this.adi.iD();
    }

    public final void seekTo(long j) {
        this.adi.seekTo(j);
    }

    public final void stop() {
        this.adi.stop();
    }

    public final void release() {
        this.adi.release();
        if (this.aeN != null) {
            if (this.aeN.getSurfaceTextureListener() == this.aeB) {
                this.aeN.setSurfaceTextureListener(null);
            }
            this.aeN = null;
        }
        if (this.aeM != null) {
            this.aeM.removeCallback(this.aeB);
            this.aeM = null;
        }
        if (this.aeJ != null) {
            if (this.aeK) {
                this.aeJ.release();
            }
            this.aeJ = null;
        }
    }

    public final void a(c... cVarArr) {
        this.adi.a(cVarArr);
    }

    public final void b(c... cVarArr) {
        this.adi.b(cVarArr);
    }

    public final long getDuration() {
        return this.adi.getDuration();
    }

    public final long getCurrentPosition() {
        return this.adi.getCurrentPosition();
    }

    public final long getBufferedPosition() {
        return this.adi.getBufferedPosition();
    }

    public final int getBufferedPercentage() {
        return this.adi.getBufferedPercentage();
    }
}
