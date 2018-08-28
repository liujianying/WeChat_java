package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class a {
    private static HashMap<String, WeakReference<Bitmap>> ncH = new HashMap();
    private static Map<String, Integer> ncL = new ConcurrentHashMap();
    private boolean eet;
    private ag ioW;
    boolean kpl;
    private Surface mSurface;
    e nGA;
    f nGB;
    g nGC;
    volatile h nGs;
    private volatile b nGt;
    volatile i nGu;
    private volatile c nGv;
    private k nGw;
    private j nGx;
    private d nGy;
    private a nGz;
    boolean ncF;
    public boolean ncG;
    public boolean ncI;
    double ncJ;
    boolean ncK;
    double ncM;
    private boolean ncN;
    boolean ncO;
    private int nci;
    private int ncj;
    String nck;
    String ncl;
    int ncm;
    protected int ncn;
    private Bitmap nco;
    private Bitmap ncp;
    private Bitmap ncq;
    WeakReference<View> ncr;
    WeakReference<TextView> ncs;
    private long nct;
    private WeakReference<View> ncu;
    private Animation ncv;
    private Animation ncw;
    int position;

    public abstract void E(Bitmap bitmap);

    public abstract void cl(int i, int i2);

    static /* synthetic */ void A(a aVar) {
        if (aVar.ncu != null && -1 != aVar.bvG()) {
            if (aVar.ncv == null && aVar.ncu.get() != null) {
                aVar.ncv = AnimationUtils.loadAnimation(((View) aVar.ncu.get()).getContext(), aVar.bvG());
            }
            if (aVar.nGy == null) {
                aVar.nGy = new d(aVar, (byte) 0);
            }
            aVar.ioW.post(aVar.nGy);
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        x.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", Integer.valueOf(aVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2));
        if (aVar.nco == null) {
            aVar.nco = o.dvq.a(new b(i, i2));
            x.k("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", aVar.nck);
        } else if (aVar.nco.getWidth() != i || aVar.nco.getHeight() != i2) {
            int i3;
            x.w("MicroMsg.SightPlayController", "reset bmp, old value " + aVar.nco.getWidth() + "*" + aVar.nco.getHeight());
            if (!d.fR(19) || aVar.nco.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    x.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    aVar.nco.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                o.dvq.k(aVar.nco);
                aVar.nco = o.dvq.a(new b(i, i2));
            }
            x.k("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", aVar.nck);
        }
    }

    public a(View view) {
        this.eet = false;
        this.nci = 0;
        this.ncj = 0;
        this.nck = "";
        this.ncl = "";
        this.ncm = -1;
        this.ncn = 41;
        this.ncF = true;
        this.ncG = false;
        this.ncI = false;
        this.kpl = true;
        this.ncJ = -1.0d;
        this.ncK = false;
        this.ncM = -1.0d;
        this.ncN = false;
        this.ncO = false;
        this.ncj = 0;
        this.ioW = new ag(Looper.getMainLooper());
        this.ncu = new WeakReference(view);
        x.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", Integer.valueOf(0));
    }

    protected int bvG() {
        return -1;
    }

    public final void hJ(boolean z) {
        if (this.nGs != null) {
            com.tencent.mm.modelvideo.o.l(this.nGs);
            this.nGs.lhj = true;
        }
        if (this.nGv != null) {
            this.ioW.removeCallbacks(this.nGv);
            this.nGv.lhj = true;
        }
        if (this.nGt != null) {
            com.tencent.mm.modelvideo.o.l(this.nGt);
            this.nGt.lhj = true;
        }
        if (this.nGu != null) {
            this.nGu.type = z ? 0 : 2;
            com.tencent.mm.modelvideo.o.d(this.nGu, 0);
        }
    }

    public final boolean bvH() {
        if (1 == this.ncj) {
            if (this.nGt == null || this.nGt.lhj) {
                return false;
            }
            return true;
        } else if (this.nGv == null || this.nGv.lhj || this.nGt == null || this.nGt.lhj) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        x.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", Integer.valueOf(hashCode()), Boolean.valueOf(this.ncF), this.nck, Integer.valueOf(this.ncm));
        if (!this.ncF) {
            clear();
        } else if (bvH()) {
            x.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", Integer.valueOf(hashCode()), this.nck);
        } else {
            boolean z;
            if (this.ncm < 0) {
                z = true;
            } else {
                z = false;
            }
            hJ(z);
            this.nct = 0;
            if (c()) {
                x.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", Integer.valueOf(hashCode()));
            } else if (this.ncm < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", Integer.valueOf(hashCode()), this.nck);
                if (!bi.oW(this.nck)) {
                    if (Lp(this.nck)) {
                        this.nGs = new h(this, (byte) 0);
                        com.tencent.mm.modelvideo.o.d(this.nGs, 0);
                        return;
                    }
                    x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.ncj) {
                this.nGt = new b(this, (byte) 0);
                this.nGv = null;
                com.tencent.mm.modelvideo.o.d(this.nGt, 0);
            } else {
                this.nGt = new b(this, (byte) 0);
                this.nGv = new c(this);
                this.nGt.nGE = this.nGv;
                this.nGv.nGG = this.nGt;
                com.tencent.mm.modelvideo.o.d(this.nGt, 0);
            }
        }
    }

    public final void clear() {
        x.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", Integer.valueOf(hashCode()), Integer.valueOf(this.ncm), Boolean.valueOf(bvH()));
        hJ(true);
        this.nct = 0;
        wd(this.ncm);
        this.ncm = -1;
        this.nck = "";
        this.ncl = "ERROR#PATH";
        this.ncq = null;
        this.ncJ = 0.0d;
        this.ncK = false;
        o.dvq.k(this.nco);
        this.nco = null;
    }

    private void wd(int i) {
        com.tencent.mm.modelvideo.o.d(new 1(this, i), 0);
    }

    public static boolean Lp(String str) {
        if (bi.oW(str)) {
            return false;
        }
        Integer num = (Integer) ncL.get(str);
        if (num == null || 2 != num.intValue()) {
            return true;
        }
        return false;
    }

    /* renamed from: bvI */
    final boolean c() {
        if (this.ncI) {
            return false;
        }
        if (VERSION.SDK_INT >= 11) {
            if (this.nci < 3) {
                return false;
            }
            x.v("MicroMsg.SightPlayController", "match not check bad fps, but now is bad fps");
            this.nci = 0;
            return false;
        } else if (this.nci >= 3) {
            return true;
        } else {
            return false;
        }
    }

    protected final void bvJ() {
        this.ncn = 1000 / Math.max(1, (int) SightVideoJNI.getVideoRate(this.ncm));
        x.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.ncn));
    }

    public final void bAm() {
        x.v("MicroMsg.SightPlayController", "draw surface thumb, thumb is null ? %B", Boolean.valueOf(true));
        com.tencent.mm.modelvideo.o.l(this.nGw);
        if (this.nGw == null) {
            this.nGw = new k(this, (byte) 0);
        }
        this.nGw.nde = new WeakReference(null);
        com.tencent.mm.modelvideo.o.d(this.nGw, 0);
    }

    public final c bvK() {
        if (this.nGz == null) {
            this.nGz = new a(this);
        }
        return this.nGz;
    }
}
