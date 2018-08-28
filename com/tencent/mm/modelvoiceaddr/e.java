package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.c.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import java.io.File;

public final class e implements com.tencent.mm.ab.e {
    public static int bFx = 100;
    private static final String eqr = (aa.duN + "tmp_voiceaddr.spx");
    private static final String eqs = (aa.duN + "tmp_voiceaddr.amr");
    c bDp;
    private com.tencent.mm.e.b.c.a bEb = new 1(this);
    com.tencent.qqpinyin.voicerecoapi.c eqA = null;
    private a eqB = null;
    public int eqm = 1;
    public int eqt = 0;
    int equ = 0;
    boolean eqv = false;
    private int eqw = 500000;
    public boolean eqx = false;
    b eqy = null;
    com.tencent.mm.e.c.a eqz;
    ag handler = new 2(this);

    class a implements Runnable {
        public final void run() {
            synchronized (e.this) {
                x.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
                try {
                    new File(e.d(e.this)).delete();
                } catch (Exception e) {
                    x.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + e.d(e.this), new Object[]{e});
                }
                e.this.bDp = new c(e.this.eqx ? 8000 : 16000, 1, 3);
                e.this.bDp.bDQ = -19;
                e.this.bDp.aM(false);
                if (!e.this.eqx) {
                    e.this.eqz = new d();
                    if (!e.this.eqz.df(e.d(e.this))) {
                        x.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                        e.this.eqz.wA();
                        e.this.eqz = null;
                    }
                }
                if (e.this.eqx || q.deW.ddI <= 0) {
                    e.this.bDp.t(5, false);
                } else {
                    e.this.bDp.t(q.deW.ddI, true);
                }
                e.this.bDp.aN(false);
                e.this.eqA = new com.tencent.qqpinyin.voicerecoapi.c(e.this.eqw);
                int start = e.this.eqA.start();
                if (start != 0) {
                    x.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + start);
                    e.this.reset();
                } else {
                    e.this.bDp.bEb = e.this.bEb;
                    if (!e.this.bDp.wn()) {
                        x.e("MicroMsg.SceneVoiceAddr", "start record failed");
                        e.this.reset();
                    }
                }
            }
        }
    }

    static /* synthetic */ void a(e eVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > eVar.eqt) {
                eVar.eqt = s;
            }
        }
    }

    static /* synthetic */ String d(e eVar) {
        return !eVar.eqx ? eqr : eqs;
    }

    public e(b bVar, int i) {
        int i2 = 500000;
        this.eqy = bVar;
        this.eqm = i;
        if (this.eqm != 1) {
            i2 = 1500000;
        }
        this.eqw = i2;
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (this.eqm == 0) {
            x.d("MicroMsg.SceneVoiceAddr", "removeSceneEndListener MMFunc_UploadInputVoice");
            g.DF().b(349, this);
        } else {
            g.DF().b(TbsListener$ErrorCode.UNZIP_IO_ERROR, this);
        }
        String[] TS = ((a) lVar).TS();
        long TT = ((a) lVar).TT();
        String str2 = "MicroMsg.SceneVoiceAddr";
        String str3 = "onSceneEnd errType:%d errCode:%d list:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = Integer.valueOf(TS == null ? -1 : TS.length);
        x.i(str2, str3, objArr);
        if (this.eqy == null) {
            return;
        }
        if (i2 == 0 && i == 0) {
            this.eqy.a(TS, TT);
            return;
        }
        this.eqy.TY();
        cancel();
    }

    private void finish() {
        x.i("MicroMsg.SceneVoiceAddr", "finish");
        x.l("MicroMsg.SceneVoiceAddr", "finish", new Object[0]);
        if (this.eqB != null) {
            this.eqB.TR();
        }
        this.handler.sendEmptyMessage(2);
        if (!this.eqv) {
            this.handler.sendEmptyMessage(3);
        }
        reset();
    }

    public final void cancel() {
        this.eqy = null;
        finish();
    }

    private void reset() {
        x.i("MicroMsg.SceneVoiceAddr", "reset");
        synchronized (this) {
            if (this.bDp != null) {
                this.bDp.we();
                this.bDp = null;
            }
            if (this.eqz != null) {
                this.eqz.wA();
                this.eqz = null;
            }
            if (this.eqA != null) {
                this.eqA.stop();
            }
            this.eqA = null;
            if (this.eqB != null) {
                this.eqB.TR();
                this.eqB = null;
            }
            this.equ = 0;
            this.eqv = false;
        }
    }
}
