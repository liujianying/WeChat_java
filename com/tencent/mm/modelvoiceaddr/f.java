package com.tencent.mm.modelvoiceaddr;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.b.c.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.Set;

public final class f implements e {
    public static int bFx = Downloads.MIN_RETYR_AFTER;
    private static final String eqr = (aa.duN + "voice_temp.silk");
    private c bDp;
    private a bEb = new 1(this);
    private a eqB = null;
    private boolean eqD = false;
    private b eqE = null;
    private com.tencent.mm.modelvoiceaddr.a.c eqF;
    private com.tencent.mm.modelvoiceaddr.a.c.a eqG = new 2(this);
    public int eqt = 0;
    private int equ = 0;
    private boolean eqv = false;
    private com.tencent.mm.e.c.a eqz;

    static /* synthetic */ void a(f fVar, short[] sArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            short s = sArr[i2];
            if (s > fVar.eqt) {
                fVar.eqt = s;
            }
        }
        x.d("MicroMsg.SceneVoiceInputAddr", "setCurAmplitude mMaxAmpSinceLastCall = %s", new Object[]{Integer.valueOf(fVar.eqt)});
    }

    public f(b bVar) {
        this.eqE = bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        String[] TS = ((a) lVar).TS();
        Set TU = ((a) lVar).TU();
        String str2 = "MicroMsg.SceneVoiceInputAddr";
        String str3 = "onSceneEnd time %s errType:%s errCode:%s list:%s scene.hashCode():%s,this.hashCode():%s";
        Object[] objArr = new Object[6];
        objArr[0] = Long.valueOf(System.currentTimeMillis());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(TS == null ? -1 : TS.length);
        objArr[4] = Integer.valueOf(lVar.hashCode());
        objArr[5] = Integer.valueOf(this.eqB == null ? -1 : this.eqB.hashCode());
        x.d(str2, str3, objArr);
        if (this.eqB == null || lVar.hashCode() != this.eqB.hashCode()) {
            x.d("MicroMsg.SceneVoiceInputAddr", "onSceneEnd scene.hashCode() != mVoiceRecogScene.hashCode()");
        } else if (this.eqE == null) {
        } else {
            if (i2 == 0 && i == 0) {
                this.eqE.a(TS, TU);
                if ((lVar instanceof b) && this.equ == 0 && ((b) lVar).eqa.Uf()) {
                    this.eqE.Ud();
                    an(false);
                    return;
                }
                return;
            }
            if (str != null && str.equalsIgnoreCase("SecurityCheckError")) {
                this.eqE.B(13, 132, -1);
            } else if (str == null || !str.equalsIgnoreCase("ReadFileLengthError")) {
                this.eqE.B(11, i, i2);
            } else {
                this.eqE.B(13, 133, -1);
            }
            an(false);
        }
    }

    public final void bs(int i, int i2) {
        x.i("MicroMsg.SceneVoiceInputAddr", "error localCode = %s,errType = %s,errCode = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(-1)});
        if (this.eqE != null) {
            this.eqE.B(i, i2, -1);
        }
        k(false, true);
    }

    public final void aJ(boolean z) {
        x.i("MicroMsg.SceneVoiceInputAddr", "stop fromUI = %s", new Object[]{Boolean.valueOf(z)});
        if (!(z || this.eqE == null)) {
            this.eqE.TZ();
        }
        k(true, true);
    }

    public final void an(boolean z) {
        x.i("MicroMsg.SceneVoiceInputAddr", "cancel fromUI = %s", new Object[]{Boolean.valueOf(z)});
        this.eqE = null;
        k(false, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k(boolean r7, boolean r8) {
        /*
        r6 = this;
        r5 = 1;
        r4 = 0;
        r0 = "MicroMsg.SceneVoiceInputAddr";
        r1 = "reset keepNetScene = %s,sendLastScene = %s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = java.lang.Boolean.valueOf(r7);
        r2[r4] = r3;
        r3 = java.lang.Boolean.valueOf(r8);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
        monitor-enter(r6);
        r0 = 1;
        r6.eqD = r0;	 Catch:{ all -> 0x0077 }
        r0 = r6.bDp;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x002a;
    L_0x0022:
        r0 = r6.bDp;	 Catch:{ all -> 0x0077 }
        r0.we();	 Catch:{ all -> 0x0077 }
        r0 = 0;
        r6.bDp = r0;	 Catch:{ all -> 0x0077 }
    L_0x002a:
        r0 = r6.eqz;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0036;
    L_0x002e:
        r0 = r6.eqz;	 Catch:{ all -> 0x0077 }
        r0.wA();	 Catch:{ all -> 0x0077 }
        r0 = 0;
        r6.eqz = r0;	 Catch:{ all -> 0x0077 }
    L_0x0036:
        r0 = r6.eqF;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0042;
    L_0x003a:
        r0 = r6.eqF;	 Catch:{ Exception -> 0x0069 }
        r0.release();	 Catch:{ Exception -> 0x0069 }
        r0 = 0;
        r6.eqF = r0;	 Catch:{ Exception -> 0x0069 }
    L_0x0042:
        r0 = 0;
        r6.equ = r0;	 Catch:{ all -> 0x0077 }
        r0 = r6.eqB;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0061;
    L_0x0049:
        r0 = r6.eqB;	 Catch:{ all -> 0x0077 }
        r0 = r0 instanceof com.tencent.mm.modelvoiceaddr.b;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x0061;
    L_0x004f:
        r0 = r6.eqB;	 Catch:{ all -> 0x0077 }
        r0.TR();	 Catch:{ all -> 0x0077 }
        r0 = eqr;	 Catch:{ all -> 0x0077 }
        r1 = com.tencent.mm.a.e.cm(r0);	 Catch:{ all -> 0x0077 }
        r0 = r6.eqB;	 Catch:{ Exception -> 0x007a }
        r0 = (com.tencent.mm.modelvoiceaddr.b) r0;	 Catch:{ Exception -> 0x007a }
        r0.iI(r1);	 Catch:{ Exception -> 0x007a }
    L_0x0061:
        if (r7 != 0) goto L_0x0067;
    L_0x0063:
        r0 = r6.eqv;	 Catch:{ all -> 0x0077 }
        if (r0 != 0) goto L_0x008d;
    L_0x0067:
        monitor-exit(r6);	 Catch:{ all -> 0x0077 }
    L_0x0068:
        return;
    L_0x0069:
        r0 = move-exception;
        r1 = "MicroMsg.SceneVoiceInputAddr";
        r2 = "mVoiceSilentDetectAPI.release error";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x0077 }
        goto L_0x0042;
    L_0x0077:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0077 }
        throw r0;
    L_0x007a:
        r0 = move-exception;
        r1 = "MicroMsg.SceneVoiceInputAddr";
        r2 = "reset cutShortSentence error";
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x0077 }
        r0 = 6;
        r1 = -1;
        r6.bs(r0, r1);	 Catch:{ all -> 0x0077 }
        goto L_0x0061;
    L_0x008d:
        r0 = r6.eqB;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x00bc;
    L_0x0091:
        r0 = r6.eqB;	 Catch:{ all -> 0x0077 }
        r0 = r0 instanceof com.tencent.mm.modelvoiceaddr.b;	 Catch:{ all -> 0x0077 }
        if (r0 == 0) goto L_0x00bc;
    L_0x0097:
        r0 = "MicroMsg.SceneVoiceInputAddr";
        r1 = "reset call stop() sendLastScene:%s";
        r2 = 1;
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x0077 }
        r3 = 0;
        r4 = java.lang.Boolean.valueOf(r8);	 Catch:{ all -> 0x0077 }
        r2[r3] = r4;	 Catch:{ all -> 0x0077 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ all -> 0x0077 }
        if (r8 == 0) goto L_0x00b3;
    L_0x00ac:
        r0 = r6.eqB;	 Catch:{ all -> 0x0077 }
        r0 = (com.tencent.mm.modelvoiceaddr.b) r0;	 Catch:{ all -> 0x0077 }
        r0.TW();	 Catch:{ all -> 0x0077 }
    L_0x00b3:
        r0 = com.tencent.mm.kernel.g.DF();	 Catch:{ all -> 0x0077 }
        r1 = 235; // 0xeb float:3.3E-43 double:1.16E-321;
        r0.b(r1, r6);	 Catch:{ all -> 0x0077 }
    L_0x00bc:
        r0 = 0;
        r6.eqB = r0;	 Catch:{ all -> 0x0077 }
        r0 = 0;
        r6.eqv = r0;	 Catch:{ all -> 0x0077 }
        monitor-exit(r6);	 Catch:{ all -> 0x0077 }
        goto L_0x0068;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.modelvoiceaddr.f.k(boolean, boolean):void");
    }
}
