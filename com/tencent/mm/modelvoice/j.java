package com.tencent.mm.modelvoice;

import android.content.Context;
import android.media.AudioTrack;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import com.tencent.mm.compatible.b.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.b;
import com.tencent.mm.modelvoice.d.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;

public final class j implements d {
    AudioTrack aga;
    b bFu;
    private int bVU;
    String eoW;
    String eoX;
    OnCompletionListener epg;
    OnErrorListener eph;
    a epk;
    d.b epl;
    private int epm;
    private int epn;
    private int epo;
    private Runnable epp;
    com.tencent.qqpinyin.voicerecoapi.a epq;
    private int epr;
    int eps;
    boolean ept;
    byte[] epu;
    int epv;
    InputStream epw;
    int epx;
    String fileName;
    int status;

    public final int getStatus() {
        return this.status;
    }

    public j() {
        int i = 0;
        this.fileName = "";
        this.epk = null;
        this.epl = null;
        this.status = 0;
        this.epm = 2;
        this.epn = 16000;
        this.bVU = 1;
        this.epo = 20;
        this.epq = null;
        this.eps = 0;
        this.ept = false;
        this.eoW = "";
        this.eoX = "";
        this.epu = new byte[com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE];
        this.epv = 0;
        this.epw = null;
        this.epx = 314;
        this.epg = new 1(this);
        this.eph = new 2(this);
        this.epq = new com.tencent.qqpinyin.voicerecoapi.a();
        com.tencent.qqpinyin.voicerecoapi.a aVar = this.epq;
        if (aVar.vgK != 0) {
            i = -103;
        } else {
            int nativeTRSpeexDecodeInit = aVar.vgL.nativeTRSpeexDecodeInit();
            if (nativeTRSpeexDecodeInit == -1 || nativeTRSpeexDecodeInit == -100 || nativeTRSpeexDecodeInit == -101 || nativeTRSpeexDecodeInit == -102) {
                i = nativeTRSpeexDecodeInit;
            } else {
                aVar.vgK = nativeTRSpeexDecodeInit;
                aVar.vgI = new byte[(com.tencent.qqpinyin.voicerecoapi.a.MAX_FRAME_SIZE * 15)];
            }
        }
        if (i != 0) {
            x.e("speex", "res: " + i);
        }
    }

    public j(Context context) {
        this();
        this.bFu = new b(context);
    }

    public final void a(a aVar) {
        this.epk = aVar;
    }

    public final void a(d.b bVar) {
        this.epl = bVar;
    }

    final void TG() {
        if (this.aga != null) {
            this.aga.stop();
            this.aga.release();
            this.aga = null;
        }
    }

    public final void aK(boolean z) {
        int i;
        this.ept = true;
        if (this.bVU == 2) {
            this.epm = 3;
        } else {
            this.epm = 2;
        }
        this.epr = AudioTrack.getMinBufferSize(this.epn, this.epm, 2);
        if (this.aga != null) {
            try {
                this.aga.stop();
                this.aga.release();
            } catch (Exception e) {
                x.e("MicroMsg.SpeexPlayer", e.getMessage());
            } finally {
                this.aga = null;
            }
        }
        if (z) {
            i = 3;
        } else {
            i = 0;
        }
        if (q.deN.dby) {
            q.deN.dump();
            if (q.deN.dbF == 1) {
                i = 3;
            }
        }
        this.aga = new d(i, this.epn, this.epm, this.epr * 8);
        try {
            this.aga.play();
        } catch (Exception e2) {
            x.e("MicroMsg.SpeexPlayer", "audioTrack error:%s", new Object[]{e2.getMessage()});
        }
        this.ept = false;
    }

    public final boolean M(String str, boolean z) {
        return N(str, z);
    }

    public final boolean c(String str, boolean z, int i) {
        return N(str, z);
    }

    private boolean N(String str, boolean z) {
        if (this.status != 0) {
            x.e("MicroMsg.SpeexPlayer", "startPlay error status:" + this.status);
            return false;
        }
        x.i("MicroMsg.SpeexPlayer", "startPlay");
        this.status = 1;
        this.fileName = str;
        try {
            bX(z);
        } catch (Throwable e) {
            try {
                bX(true);
            } catch (Exception e2) {
                x.e("MicroMsg.SpeexPlayer", "startPlay File[" + this.fileName + "] failed");
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e)});
                this.status = -1;
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void bX(boolean r8) {
        /*
        r7 = this;
        r0 = 3;
        r6 = 1;
        r2 = 0;
        r1 = r7.fileName;
        r1 = com.tencent.mm.vfs.d.cn(r1);
        if (r1 != 0) goto L_0x000c;
    L_0x000b:
        return;
    L_0x000c:
        if (r8 == 0) goto L_0x00a7;
    L_0x000e:
        r1 = r0;
    L_0x000f:
        r3 = com.tencent.mm.compatible.e.q.deN;	 Catch:{ Exception -> 0x006d }
        r3 = r3.dby;	 Catch:{ Exception -> 0x006d }
        if (r3 == 0) goto L_0x00c0;
    L_0x0015:
        r3 = com.tencent.mm.compatible.e.q.deN;	 Catch:{ Exception -> 0x006d }
        r3.dump();	 Catch:{ Exception -> 0x006d }
        r3 = com.tencent.mm.compatible.e.q.deN;	 Catch:{ Exception -> 0x006d }
        r3 = r3.dbF;	 Catch:{ Exception -> 0x006d }
        if (r3 != r6) goto L_0x00c0;
    L_0x0020:
        r1 = r7.epn;	 Catch:{ Exception -> 0x006d }
        r3 = r7.epm;	 Catch:{ Exception -> 0x006d }
        r4 = 2;
        r1 = android.media.AudioTrack.getMinBufferSize(r1, r3, r4);	 Catch:{ Exception -> 0x006d }
        r7.epr = r1;	 Catch:{ Exception -> 0x006d }
        r7.TG();	 Catch:{ Exception -> 0x006d }
        r1 = new com.tencent.mm.compatible.b.d;	 Catch:{ Exception -> 0x006d }
        r3 = r7.epn;	 Catch:{ Exception -> 0x006d }
        r4 = r7.epm;	 Catch:{ Exception -> 0x006d }
        r5 = r7.epr;	 Catch:{ Exception -> 0x006d }
        r5 = r5 * 8;
        r1.<init>(r0, r3, r4, r5);	 Catch:{ Exception -> 0x006d }
        r7.aga = r1;	 Catch:{ Exception -> 0x006d }
        r0 = r7.epn;	 Catch:{ Exception -> 0x006d }
        r0 = r0 / 1000;
        r1 = r7.bVU;	 Catch:{ Exception -> 0x006d }
        r0 = r0 * r1;
        r1 = r7.epo;	 Catch:{ Exception -> 0x006d }
        r0 = r0 * r1;
        r0 = r0 * 2;
        r7.epx = r0;	 Catch:{ Exception -> 0x006d }
        r0 = r7.bFu;	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x0054;
    L_0x004f:
        r0 = r7.bFu;	 Catch:{ Exception -> 0x006d }
        r0.requestFocus();	 Catch:{ Exception -> 0x006d }
    L_0x0054:
        r0 = r7.aga;	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x000b;
    L_0x0058:
        r0 = r7.aga;	 Catch:{ Exception -> 0x00aa }
        r0.play();	 Catch:{ Exception -> 0x00aa }
        r0 = new com.tencent.mm.modelvoice.j$3;	 Catch:{ Exception -> 0x006d }
        r0.<init>(r7);	 Catch:{ Exception -> 0x006d }
        r7.epp = r0;	 Catch:{ Exception -> 0x006d }
        r0 = r7.epp;	 Catch:{ Exception -> 0x006d }
        r1 = "SpeexPlayer_play";
        com.tencent.mm.sdk.f.e.post(r0, r1);	 Catch:{ Exception -> 0x006d }
        goto L_0x000b;
    L_0x006d:
        r0 = move-exception;
        r1 = r7.bFu;
        if (r1 == 0) goto L_0x0077;
    L_0x0072:
        r1 = r7.bFu;
        r1.zY();
    L_0x0077:
        r7.TG();
        r1 = "MicroMsg.SpeexPlayer";
        r3 = new java.lang.StringBuilder;
        r4 = "playImp : fail, exception = ";
        r3.<init>(r4);
        r4 = r0.getMessage();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
        r1 = "MicroMsg.SpeexPlayer";
        r3 = "exception:%s";
        r4 = new java.lang.Object[r6];
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        r4[r2] = r0;
        com.tencent.mm.sdk.platformtools.x.e(r1, r3, r4);
        goto L_0x000b;
    L_0x00a7:
        r1 = r2;
        goto L_0x000f;
    L_0x00aa:
        r0 = move-exception;
        r1 = "MicroMsg.SpeexPlayer";
        r3 = "audioTrack error:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x006d }
        r5 = 0;
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x006d }
        r4[r5] = r0;	 Catch:{ Exception -> 0x006d }
        com.tencent.mm.sdk.platformtools.x.e(r1, r3, r4);	 Catch:{ Exception -> 0x006d }
        goto L_0x000b;
    L_0x00c0:
        r0 = r1;
        goto L_0x0020;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoice.j.bX(boolean):void");
    }

    public final boolean aI(boolean z) {
        if (this.status != 1) {
            return false;
        }
        this.status = 2;
        synchronized (this.eoX) {
            try {
                x.v("MicroMsg.SpeexPlayer", "before mOk.wait");
                long currentTimeMillis = System.currentTimeMillis();
                this.eoX.wait();
                x.v("MicroMsg.SpeexPlayer", "after mOk.wait time:" + (System.currentTimeMillis() - currentTimeMillis));
                if (this.bFu != null && z) {
                    this.bFu.zY();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e)});
                if (this.bFu != null && z) {
                    this.bFu.zY();
                }
                return false;
            } catch (Throwable th) {
                if (this.bFu != null && z) {
                    this.bFu.zY();
                }
            }
        }
        return true;
    }

    public final boolean vY() {
        if (this.status != 2) {
            return false;
        }
        this.status = 1;
        synchronized (this.eoW) {
            try {
                x.v("MicroMsg.SpeexPlayer", "before mpause.notify");
                this.eoW.notify();
                x.v("MicroMsg.SpeexPlayer", "after mpause.notify");
                if (this.bFu != null) {
                    this.bFu.requestFocus();
                }
            } catch (Throwable e) {
                x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e)});
                if (this.bFu != null) {
                    this.bFu.requestFocus();
                }
                return false;
            } catch (Throwable th) {
                if (this.bFu != null) {
                    this.bFu.requestFocus();
                }
            }
        }
        return true;
    }

    public final boolean isPlaying() {
        return this.status == 1;
    }

    public final boolean wk() {
        x.e("MicroMsg.SpeexPlayer", "stop  status:" + this.status);
        if (this.status == 1 || this.status == 2) {
            this.status = 3;
            synchronized (this.eoW) {
                try {
                    this.eoW.notify();
                    if (this.bFu != null) {
                        this.bFu.zY();
                    }
                } catch (Throwable e) {
                    x.e("MicroMsg.SpeexPlayer", "exception:%s", new Object[]{bi.i(e)});
                    TG();
                    if (this.bFu != null) {
                        this.bFu.zY();
                    }
                    return false;
                } catch (Throwable th) {
                    if (this.bFu != null) {
                        this.bFu.zY();
                    }
                }
            }
            return true;
        }
        x.e("MicroMsg.SpeexPlayer", "stop  error status:" + this.status);
        return false;
    }

    public final double wb() {
        return 0.0d;
    }

    public final void b(b.a aVar) {
        if (aVar != null && this.bFu != null) {
            this.bFu.a(aVar);
        }
    }
}
