package com.tencent.mm.plugin.sight.decode.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import android.media.MediaPlayer;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o$b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class b {
    private static HashMap<String, WeakReference<Bitmap>> ncH = new HashMap();
    private static Map<String, Integer> ncL = new ConcurrentHashMap();
    private boolean eet = false;
    private ag ioW;
    public boolean kpl = true;
    private Surface mSurface;
    private volatile c ncA;
    private k ncB;
    private j ncC;
    private d ncD;
    public boolean ncE = true;
    public boolean ncF = true;
    public boolean ncG = false;
    public boolean ncI = false;
    public double ncJ = -1.0d;
    boolean ncK = false;
    public double ncM = -1.0d;
    private boolean ncN = false;
    public boolean ncO = false;
    private a ncP;
    public e ncQ;
    public f ncR;
    public g ncS;
    private int nci = 0;
    private int ncj = 0;
    public String nck = "";
    private String ncl = "";
    private int ncm = -1;
    protected int ncn = 41;
    private Bitmap nco;
    public Bitmap ncp;
    private Bitmap ncq;
    private WeakReference<View> ncr;
    private WeakReference<TextView> ncs;
    private long nct;
    public WeakReference<View> ncu;
    private Animation ncv;
    private Animation ncw;
    private volatile h ncx;
    private volatile b ncy;
    public volatile i ncz;
    public int position;

    public interface e {
        void d(b bVar, int i);
    }

    public interface g {
        int bvO();

        View bvP();

        int bvQ();
    }

    private class i implements Runnable {
        double ncM;
        MediaPlayer ndc;
        public int type;

        private i() {
            this.ncM = -1.0d;
        }

        public /* synthetic */ i(b bVar, byte b) {
            this();
        }

        private void bhP() {
            x.i("MicroMsg.SightPlayController", "stopPlayer");
            try {
                if (this.ndc != null) {
                    this.ndc.stop();
                    this.ndc.release();
                    this.ndc = null;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SightPlayController", e, "stop play sound error: %s", new Object[]{e.getMessage()});
                this.ndc = null;
            }
        }

        public final double bvR() {
            if (this.ndc == null) {
                return 0.0d;
            }
            return (double) this.ndc.getCurrentPosition();
        }

        public final void run() {
            String str;
            String str2 = "MicroMsg.SightPlayController";
            String str3 = "do play sound, operation %s";
            Object[] objArr = new Object[1];
            switch (this.type) {
                case 0:
                    str = "stop";
                    break;
                case 1:
                    str = "start";
                    break;
                case 2:
                    str = "pause";
                    break;
                case 3:
                    str = "resume";
                    break;
                case 4:
                    str = "seek";
                    break;
                default:
                    str = "unknown";
                    break;
            }
            objArr[0] = str;
            x.i(str2, str3, objArr);
            switch (this.type) {
                case 0:
                    bhP();
                    return;
                case 1:
                    bhP();
                    if (!bi.oW(b.this.nck)) {
                        try {
                            this.ndc = new com.tencent.mm.compatible.b.j();
                            this.ndc.setDisplay(null);
                            this.ndc.reset();
                            this.ndc.setDataSource(b.this.nck);
                            this.ndc.setAudioStreamType(3);
                            this.ndc.setOnErrorListener(new 1(this));
                            this.ndc.prepare();
                            this.ndc.start();
                            return;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.SightPlayController", e, "play sound error: %s", new Object[]{e.getMessage()});
                            x.e("MicroMsg.SightPlayController", "on Exception: play %s ERROR!!", new Object[]{b.this.nck});
                            b.this.clear();
                            if (b.this.ncQ != null) {
                                b.this.ncQ.d(b.this, -1);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                case 2:
                    try {
                        if (this.ndc != null && this.ndc.isPlaying()) {
                            this.ndc.pause();
                            return;
                        }
                        return;
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e2, "pause sound error: %s", new Object[]{e2.getMessage()});
                        bhP();
                        return;
                    }
                case 3:
                    try {
                        if (this.ndc != null) {
                            this.ndc.start();
                            return;
                        }
                        return;
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e22, "pause sound error: %s", new Object[]{e22.getMessage()});
                        bhP();
                        return;
                    }
                case 4:
                    try {
                        x.i("MicroMsg.SightPlayController", "soundplayer seek %f", new Object[]{Double.valueOf(this.ncM)});
                        this.ndc.seekTo((int) (this.ncM * 1000.0d));
                        return;
                    } catch (Throwable e222) {
                        x.printErrStackTrace("MicroMsg.SightPlayController", e222, "seek sound error: %s", new Object[]{e222.getMessage()});
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private class j implements Runnable {
        private j() {
        }

        /* synthetic */ j(b bVar, byte b) {
            this();
        }

        public final void run() {
            if (b.this.ncm >= 0 && b.this.ncs != null && b.this.ncs.get() != null) {
                ((TextView) b.this.ncs.get()).setText(SightVideoJNI.getVideoInfo(b.this.ncm));
            }
        }
    }

    private class k implements Runnable {
        WeakReference<Bitmap> nde;

        private k() {
            this.nde = new WeakReference(null);
        }

        /* synthetic */ k(b bVar, byte b) {
            this();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
            r10 = this;
            r1 = 0;
            r2 = 1;
            r3 = 0;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0017;
        L_0x000b:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isValid();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x020a;
        L_0x0017:
            r4 = "MicroMsg.SightPlayController";
            r5 = "#0x%x-#0x%x want draw thumb, but surface status error, surface null ? %B, thumb bgView null ? %B, thumb null ? %B, mask null ? %B";
            r0 = 6;
            r6 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r7 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r7 = r7.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r7 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x00df }
            r6[r0] = r7;	 Catch:{ Exception -> 0x00df }
            r7 = 2;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00c9;
        L_0x0041:
            r0 = r2;
        L_0x0042:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 3;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncr;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00cc;
        L_0x0051:
            r0 = r2;
        L_0x0052:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 4;
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ce;
        L_0x0061:
            r0 = r2;
        L_0x0062:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            r7 = 5;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncp;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00d0;
        L_0x0071:
            r0 = r2;
        L_0x0072:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.w(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncp;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x00ec;
        L_0x0083:
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.ncr;	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x009f;
        L_0x0093:
            r1 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r1 = r1.ncr;	 Catch:{ Exception -> 0x00df }
            r1 = r1.get();	 Catch:{ Exception -> 0x00df }
            r1 = (android.view.View) r1;	 Catch:{ Exception -> 0x00df }
        L_0x009f:
            if (r1 == 0) goto L_0x00a9;
        L_0x00a1:
            if (r0 == 0) goto L_0x00a9;
        L_0x00a3:
            r4 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r4 == 0) goto L_0x00d6;
        L_0x00a9:
            r4 = "MicroMsg.SightPlayController";
            r5 = "bgView:%B, thumb:%B";
            r6 = 2;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            if (r1 != 0) goto L_0x00d2;
        L_0x00b5:
            r1 = r2;
        L_0x00b6:
            r1 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r1;	 Catch:{ Exception -> 0x00df }
            r1 = 1;
            if (r0 != 0) goto L_0x00d4;
        L_0x00bf:
            r0 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r6[r1] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.e(r4, r5, r6);	 Catch:{ Exception -> 0x00df }
        L_0x00c8:
            return;
        L_0x00c9:
            r0 = r3;
            goto L_0x0042;
        L_0x00cc:
            r0 = r3;
            goto L_0x0052;
        L_0x00ce:
            r0 = r3;
            goto L_0x0062;
        L_0x00d0:
            r0 = r3;
            goto L_0x0072;
        L_0x00d2:
            r1 = r3;
            goto L_0x00b6;
        L_0x00d4:
            r2 = r3;
            goto L_0x00bf;
        L_0x00d6:
            r2 = new com.tencent.mm.plugin.sight.decode.a.b$k$1;	 Catch:{ Exception -> 0x00df }
            r2.<init>(r10, r1, r0);	 Catch:{ Exception -> 0x00df }
            r1.post(r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x00df:
            r0 = move-exception;
            r1 = "MicroMsg.SightPlayController";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x00c8;
        L_0x00ec:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncq;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0120;
        L_0x00f4:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncq;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getWidth();	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.ncp;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x00df }
            if (r0 != r4) goto L_0x0120;
        L_0x010a:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncq;	 Catch:{ Exception -> 0x00df }
            r0 = r0.getHeight();	 Catch:{ Exception -> 0x00df }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = r4.ncp;	 Catch:{ Exception -> 0x00df }
            r4 = r4.getHeight();	 Catch:{ Exception -> 0x00df }
            if (r0 == r4) goto L_0x013f;
        L_0x0120:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x018a }
            r4 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x018a }
            r4 = r4.ncp;	 Catch:{ Exception -> 0x018a }
            r4 = r4.getWidth();	 Catch:{ Exception -> 0x018a }
            r5 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x018a }
            r5 = r5.ncp;	 Catch:{ Exception -> 0x018a }
            r5 = r5.getHeight();	 Catch:{ Exception -> 0x018a }
            r6 = android.graphics.Bitmap.Config.ARGB_8888;	 Catch:{ Exception -> 0x018a }
            r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6);	 Catch:{ Exception -> 0x018a }
            r0.ncq = r4;	 Catch:{ Exception -> 0x018a }
        L_0x013f:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncq;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x0147:
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x015d;
        L_0x014f:
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r0 = r0.isRecycled();	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x01a9;
        L_0x015d:
            r1 = "MicroMsg.SightPlayController";
            r4 = "mThubmBgBmp:%B, thumbRef:%B";
            r0 = 2;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r6 = 0;
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncq;	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x01a5;
        L_0x016f:
            r0 = r2;
        L_0x0170:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r6 = r6.get();	 Catch:{ Exception -> 0x00df }
            if (r6 != 0) goto L_0x01a7;
        L_0x017f:
            r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r2;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.e(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x018a:
            r0 = move-exception;
            r4 = "MicroMsg.SightPlayController";
            r5 = "try to create thumb bmp error:%s";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = r0.getMessage();	 Catch:{ Exception -> 0x00df }
            r6[r7] = r8;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r4, r0, r5, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r4 = 0;
            r0.ncq = r4;	 Catch:{ Exception -> 0x00df }
            goto L_0x013f;
        L_0x01a5:
            r0 = r3;
            goto L_0x0170;
        L_0x01a7:
            r2 = r3;
            goto L_0x017f;
        L_0x01a9:
            r4 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r2 = r2.ncq;	 Catch:{ Exception -> 0x00df }
            r6 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r6 = r6.ncp;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.handleThumb(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = "MicroMsg.SightPlayController";
            r2 = "handle thumb use %d us";
            r6 = 1;
            r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x00df }
            r7 = 0;
            r8 = java.lang.System.nanoTime();	 Catch:{ Exception -> 0x00df }
            r4 = r8 - r4;
            r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r4 = r4 / r8;
            r4 = java.lang.Long.valueOf(r4);	 Catch:{ Exception -> 0x00df }
            r6[r7] = r4;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.i(r0, r2, r6);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r2 = r0.ncq;	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncr;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x0208;
        L_0x01ee:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
        L_0x01fa:
            if (r0 == 0) goto L_0x00c8;
        L_0x01fc:
            if (r2 == 0) goto L_0x00c8;
        L_0x01fe:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$2;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r0, r2);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0208:
            r0 = r1;
            goto L_0x01fa;
        L_0x020a:
            r1 = "MicroMsg.SightPlayController";
            r4 = "#0x%x-#0x%x draw thumb, thumb empty ? %B";
            r0 = 3;
            r5 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00df }
            r0 = 0;
            r6 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r6 = r6.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r0 = 1;
            r6 = r10.hashCode();	 Catch:{ Exception -> 0x00df }
            r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x00df }
            r5[r0] = r6;	 Catch:{ Exception -> 0x00df }
            r6 = 2;
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0270;
        L_0x0234:
            r0 = r2;
        L_0x0235:
            r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00df }
            r5[r6] = r0;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.sdk.platformtools.x.d(r1, r4, r5);	 Catch:{ Exception -> 0x00df }
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncr;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0246:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.ncr;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.view.View) r0;	 Catch:{ Exception -> 0x00df }
            if (r0 == 0) goto L_0x025c;
        L_0x0254:
            r1 = new com.tencent.mm.plugin.sight.decode.a.b$k$3;	 Catch:{ Exception -> 0x00df }
            r1.<init>(r10, r0);	 Catch:{ Exception -> 0x00df }
            r0.post(r1);	 Catch:{ Exception -> 0x00df }
        L_0x025c:
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            if (r0 != 0) goto L_0x0272;
        L_0x0264:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r0 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r1 = 0;
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceColor(r0, r1);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
        L_0x0270:
            r0 = r3;
            goto L_0x0235;
        L_0x0272:
            r0 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r1 = r0.mSurface;	 Catch:{ Exception -> 0x00df }
            r0 = r10.nde;	 Catch:{ Exception -> 0x00df }
            r0 = r0.get();	 Catch:{ Exception -> 0x00df }
            r0 = (android.graphics.Bitmap) r0;	 Catch:{ Exception -> 0x00df }
            r2 = com.tencent.mm.plugin.sight.decode.a.b.this;	 Catch:{ Exception -> 0x00df }
            r2 = r2.ncp;	 Catch:{ Exception -> 0x00df }
            com.tencent.mm.plugin.sight.base.SightVideoJNI.drawSurfaceThumb(r1, r0, r2);	 Catch:{ Exception -> 0x00df }
            goto L_0x00c8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sight.decode.a.b.k.run():void");
        }
    }

    public abstract void E(Bitmap bitmap);

    public abstract void cl(int i, int i2);

    static /* synthetic */ void A(b bVar) {
        if (bVar.ncu != null && -1 != bVar.bvG() && bVar.ncE) {
            if (bVar.ncv == null && bVar.ncu.get() != null) {
                bVar.ncv = AnimationUtils.loadAnimation(((View) bVar.ncu.get()).getContext(), bVar.bvG());
            }
            if (bVar.ncD == null) {
                bVar.ncD = new d(bVar, (byte) 0);
            }
            bVar.ioW.post(bVar.ncD);
        }
    }

    static /* synthetic */ void a(b bVar, int i, int i2) {
        x.d("MicroMsg.SightPlayController", "#0x%x check bmp, video width %d, height %d", new Object[]{Integer.valueOf(bVar.hashCode()), Integer.valueOf(i), Integer.valueOf(i2)});
        if (bVar.nco == null) {
            bVar.nco = o.dvq.a(new o$b(i, i2));
            x.k("MicroMsg.SightPlayController", "checkBmp, create new one, videoPath: %s", new Object[]{bVar.nck});
        } else if (bVar.nco.getWidth() != i || bVar.nco.getHeight() != i2) {
            int i3;
            x.w("MicroMsg.SightPlayController", "reset bmp, old value " + bVar.nco.getWidth() + "*" + bVar.nco.getHeight());
            if (!d.fR(19) || bVar.nco.getAllocationByteCount() < (i2 * i) * 4) {
                i3 = 0;
            } else {
                try {
                    x.w("MicroMsg.SightPlayController", "reset bmp, try directly reconfigure");
                    bVar.nco.reconfigure(i, i2, Config.ARGB_8888);
                    i3 = 1;
                } catch (Exception e) {
                    x.e("MicroMsg.SightPlayController", "reconfigure failed: %s" + e.getMessage());
                    i3 = 0;
                }
            }
            if (i3 == 0) {
                o.dvq.k(bVar.nco);
                bVar.nco = o.dvq.a(new o$b(i, i2));
            }
            x.k("MicroMsg.SightPlayController", "checkBmp, the origin bmp size not match, create new one, videoPath: %s", new Object[]{bVar.nck});
        }
    }

    public static Bitmap b(Context context, int i, int i2, int i3, int i4) {
        String format = String.format("%s-%s-%s-%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        WeakReference weakReference = (WeakReference) ncH.get(format);
        if (weakReference != null && weakReference.get() != null) {
            return (Bitmap) weakReference.get();
        }
        if (context == null) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but context is null");
            return null;
        } else if (i <= 0) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but mask id error");
            return null;
        } else if (i2 <= 0 || i4 <= 0 || i3 <= 0) {
            x.w("MicroMsg.SightPlayController", "get mask bmp, but size error");
            return null;
        } else {
            long VG = bi.VG();
            int i5 = (i2 * i4) / i3;
            NinePatchDrawable ninePatchDrawable = (NinePatchDrawable) context.getResources().getDrawable(i);
            ninePatchDrawable.setBounds(0, 0, i2, i5);
            Bitmap createBitmap = Bitmap.createBitmap(i2, i5, Config.ARGB_8888);
            ninePatchDrawable.draw(new Canvas(createBitmap));
            ncH.put(format, new WeakReference(createBitmap));
            x.d("MicroMsg.SightPlayController", "create mask bmp use %dms", new Object[]{Long.valueOf(bi.bI(VG))});
            return createBitmap;
        }
    }

    public static void Fm() {
        com.tencent.mm.modelvideo.o.d(new 1(), 0);
    }

    public b(int i, View view) {
        this.ncj = i;
        this.ioW = new ag(Looper.getMainLooper());
        this.ncu = new WeakReference(view);
        x.i("MicroMsg.SightPlayController", "new SightPlayController, drawType %d", new Object[]{Integer.valueOf(i)});
    }

    public int bvG() {
        return -1;
    }

    public final void hJ(boolean z) {
        if (this.ncx != null) {
            com.tencent.mm.modelvideo.o.l(this.ncx);
            this.ncx.lhj = true;
        }
        if (this.ncA != null) {
            this.ioW.removeCallbacks(this.ncA);
            this.ncA.lhj = true;
        }
        if (this.ncy != null) {
            com.tencent.mm.modelvideo.o.l(this.ncy);
            this.ncy.lhj = true;
        }
        if (this.ncz != null) {
            this.ncz.type = z ? 0 : 2;
            com.tencent.mm.modelvideo.o.d(this.ncz, 0);
        }
    }

    public final boolean bvH() {
        if (1 == this.ncj) {
            if (this.ncy == null || this.ncy.lhj) {
                return false;
            }
            return true;
        } else if (this.ncA == null || this.ncA.lhj || this.ncy == null || this.ncy.lhj) {
            return false;
        } else {
            return true;
        }
    }

    public final void restart() {
        x.i("MicroMsg.SightPlayController", "#0x%x restart, canPlay %B, videoPath %s, videoId %d", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.ncF), this.nck, Integer.valueOf(this.ncm)});
        if (!this.ncF) {
            clear();
        } else if (bvH()) {
            x.w("MicroMsg.SightPlayController", "#0x%x is runing, do nothing when restart request asked, videoPath %s", new Object[]{Integer.valueOf(hashCode()), this.nck});
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
                x.e("MicroMsg.SightPlayController", "#0x%x is bad fps, do nothing when restart", new Object[]{Integer.valueOf(hashCode())});
            } else if (this.ncm < 0) {
                x.w("MicroMsg.SightPlayController", "#0x%x restart match error video id, try reopen video, videoPath %s", new Object[]{Integer.valueOf(hashCode()), this.nck});
                if (!bi.oW(this.nck)) {
                    if (Lp(this.nck)) {
                        this.ncx = new h(this, (byte) 0);
                        com.tencent.mm.modelvideo.o.d(this.ncx, 0);
                        return;
                    }
                    x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                    clear();
                }
            } else if (1 == this.ncj) {
                this.ncy = new b(this, (byte) 0);
                this.ncA = null;
                com.tencent.mm.modelvideo.o.d(this.ncy, 0);
            } else {
                this.ncy = new b(this, (byte) 0);
                this.ncA = new c(this);
                this.ncy.ncY = this.ncA;
                this.ncA.ndb = this.ncy;
                com.tencent.mm.modelvideo.o.d(this.ncy, 0);
            }
        }
    }

    public final void clear() {
        x.i("MicroMsg.SightPlayController", "#0x%x do clear, remove render job, video id %d, runing %B", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.ncm), Boolean.valueOf(bvH())});
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
        com.tencent.mm.modelvideo.o.d(new 2(this, i), 0);
    }

    public final void aO(String str, boolean z) {
        x.i("MicroMsg.SightPlayController", "#0x%x data: set video[%s], old path[%s], fling[%B], last video id %d, recording %B, canPlay %B", new Object[]{Integer.valueOf(hashCode()), str, this.nck, Boolean.valueOf(z), Integer.valueOf(this.ncm), Boolean.valueOf(this.ncO), Boolean.valueOf(this.ncF)});
        if (this.ncO) {
            hJ(false);
        } else if (c()) {
            x.e("MicroMsg.SightPlayController", "is bad fps, do nothing when set video path");
            clear();
        } else if (!this.ncF) {
            clear();
        } else if (z) {
            this.ncl = str;
            hJ(false);
        } else if (this.nck.equals(str)) {
            this.ncl = "ERROR#PATH";
            hJ(false);
            restart();
        } else {
            clear();
            if (str == null) {
                str = "";
            }
            this.nck = str;
            if (bi.oW(this.nck)) {
                x.w("MicroMsg.SightPlayController", "empty video path, do draw empty thumb and return");
                D(null);
            } else if (Lp(this.nck)) {
                this.ncx = new h(this, (byte) 0);
                com.tencent.mm.modelvideo.o.d(this.ncx, 0);
            } else {
                x.w("MicroMsg.SightPlayController", "Check Sight Fail!!! return");
                clear();
            }
        }
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
    public final boolean c() {
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
        this.ncn = TbsLog.TBSLOG_CODE_SDK_BASE / Math.max(1, (int) SightVideoJNI.getVideoRate(this.ncm));
        x.d("MicroMsg.SightPlayController", "#0x%x update video rate to %d fps, delay %d ms", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(r0), Integer.valueOf(this.ncn)});
    }

    public final void d(Surface surface) {
        x.v("MicroMsg.SightPlayController", "set play surface %s", new Object[]{surface});
        this.mSurface = surface;
        com.tencent.mm.modelvideo.o.d(this.ncB, 0);
    }

    public final void setThumbBgView(View view) {
        this.ncr = new WeakReference(view);
    }

    public final void setSightInfoView(TextView textView) {
        this.ncs = new WeakReference(textView);
    }

    public final void D(Bitmap bitmap) {
        boolean z = true;
        String str = "MicroMsg.SightPlayController";
        String str2 = "draw surface thumb, thumb is null ? %B";
        Object[] objArr = new Object[1];
        if (bitmap != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.v(str, str2, objArr);
        com.tencent.mm.modelvideo.o.l(this.ncB);
        if (this.ncB == null) {
            this.ncB = new k(this, (byte) 0);
        }
        this.ncB.nde = new WeakReference(bitmap);
        com.tencent.mm.modelvideo.o.d(this.ncB, 0);
    }

    public final c bvK() {
        if (this.ncP == null) {
            this.ncP = new a(this);
        }
        return this.ncP;
    }

    public final double bvL() {
        if (this.ncm == -1) {
            return 0.0d;
        }
        return SightVideoJNI.getVideoDuration(this.ncm);
    }
}
