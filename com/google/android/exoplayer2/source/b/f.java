package com.google.android.exoplayer2.source.b;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b;
import com.google.android.exoplayer2.c.c.c;
import com.google.android.exoplayer2.c.c.e;
import com.google.android.exoplayer2.c.c.t;
import com.google.android.exoplayer2.h.i;
import com.google.android.exoplayer2.i.g;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.a;
import com.google.android.exoplayer2.source.a.d;
import com.google.android.exoplayer2.source.b.a.a$a;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class f extends d {
    private static final AtomicInteger atu = new AtomicInteger();
    private final q alB;
    private final boolean amj;
    private volatile boolean asP;
    private final String atA;
    private final com.google.android.exoplayer2.c.d atB;
    final boolean atC;
    private final boolean atD;
    private final boolean atE;
    private final a atF;
    private final j atG;
    private com.google.android.exoplayer2.c.d atH;
    private int atI;
    private int atJ;
    private boolean atK;
    j atL;
    volatile boolean atM;
    private final List<Format> atd;
    public final int atv;
    public final a$a atw;
    private final com.google.android.exoplayer2.h.f atx;
    private final i aty;
    private final boolean atz;
    public final int uid;

    public f(com.google.android.exoplayer2.h.f fVar, i iVar, i iVar2, a$a a_a, List<Format> list, int i, Object obj, long j, long j2, int i2, int i3, boolean z, q qVar, f fVar2, byte[] bArr, byte[] bArr2) {
        com.google.android.exoplayer2.h.f fVar3;
        if (bArr == null || bArr2 == null) {
            fVar3 = fVar;
        } else {
            fVar3 = new a(fVar, bArr, bArr2);
        }
        super(fVar3, iVar, a_a.aep, i, obj, j, j2, i2);
        this.atv = i3;
        this.aty = iVar2;
        this.atw = a_a;
        this.atd = list;
        this.atz = z;
        this.alB = qVar;
        this.amj = this.aiC instanceof a;
        this.atA = iVar.uri.getLastPathSegment();
        boolean z2 = this.atA.endsWith(".aac") || this.atA.endsWith(".ac3") || this.atA.endsWith(".ec3") || this.atA.endsWith(".mp3");
        this.atE = z2;
        if (fVar2 != null) {
            this.atF = fVar2.atF;
            this.atG = fVar2.atG;
            this.atB = fVar2.atH;
            this.atC = fVar2.atw != a_a;
            z2 = fVar2.atv != i3 || this.atC;
            this.atD = z2;
        } else {
            this.atF = this.atE ? new a() : null;
            this.atG = this.atE ? new j(10) : null;
            this.atB = null;
            this.atC = false;
            this.atD = true;
        }
        this.atx = fVar;
        this.uid = atu.getAndIncrement();
    }

    public final long kP() {
        return (long) this.atJ;
    }

    public final void kQ() {
        this.asP = true;
    }

    public final boolean kR() {
        return this.asP;
    }

    public final void kS() {
        com.google.android.exoplayer2.c.d lVar;
        boolean z;
        int i;
        i R;
        b bVar;
        Object obj = null;
        int i2 = 0;
        if (this.atH == null && !this.atE) {
            int z2;
            if ("text/vtt".equals(this.atw.aep.adW) || this.atA.endsWith(".webvtt") || this.atA.endsWith(".vtt")) {
                lVar = new l(this.asK.aem, this.alB);
                z2 = true;
            } else if (!this.atD) {
                lVar = this.atB;
                z2 = 0;
            } else if (this.atA.endsWith(".mp4") || this.atA.startsWith(".m4", this.atA.length() - 4)) {
                lVar = new com.google.android.exoplayer2.c.b.d(this.alB);
                z2 = true;
            } else {
                i = 16;
                List list = this.atd;
                if (list != null) {
                    i = 48;
                } else {
                    list = Collections.emptyList();
                }
                String str = this.asK.adT;
                if (!TextUtils.isEmpty(str)) {
                    Object aw;
                    String aw2;
                    String str2 = "audio/mp4a-latm";
                    if (str != null) {
                        for (String aw22 : str.split(",")) {
                            aw = g.aw(aw22);
                            if (aw != null && g.at(aw)) {
                                break;
                            }
                        }
                    }
                    aw = null;
                    if (!str2.equals(aw)) {
                        i |= 2;
                    }
                    str2 = "video/avc";
                    if (str != null) {
                        for (String aw222 : str.split(",")) {
                            aw222 = g.aw(aw222);
                            if (aw222 != null && g.au(aw222)) {
                                obj = aw222;
                                break;
                            }
                        }
                    }
                    if (!str2.equals(obj)) {
                        i |= 4;
                    }
                }
                z2 = true;
                lVar = new t(2, this.alB, new e(i, list));
            }
            if (z2 != 0) {
                lVar.a(this.atL);
            }
            this.atH = lVar;
        }
        if (!(this.atB == this.atH || this.atK || this.aty == null)) {
            R = this.aty.R((long) this.atI);
            try {
                bVar = new b(this.atx, R.aAJ, this.atx.a(R));
                i = 0;
                while (i == 0) {
                    if (!this.asP) {
                        i = this.atH.a(bVar);
                    }
                }
                this.atI = (int) (bVar.getPosition() - this.aty.aAJ);
                com.google.android.exoplayer2.i.t.a(this.aiC);
                this.atK = true;
            } catch (Throwable th) {
                com.google.android.exoplayer2.i.t.a(this.aiC);
            }
        }
        if (!this.asP) {
            boolean z3;
            if (this.amj) {
                i iVar = this.asJ;
                if (this.atJ != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2;
                R = iVar;
            } else {
                z3 = false;
                R = this.asJ.R((long) this.atJ);
            }
            if (!this.atz) {
                this.alB.mq();
            } else if (this.alB.amH == Long.MAX_VALUE) {
                this.alB.S(this.asN);
            }
            try {
                bVar = new b(this.aiC, R.aAJ, this.aiC.a(R));
                if (this.atH == null) {
                    long readLong;
                    bVar.jS();
                    if (bVar.b(this.atG.data, 0, 10, true)) {
                        this.atG.reset(10);
                        if (this.atG.mf() == a.amG) {
                            this.atG.da(3);
                            i = this.atG.mg();
                            int i3 = i + 10;
                            if (i3 > this.atG.capacity()) {
                                obj = this.atG.data;
                                this.atG.reset(i3);
                                System.arraycopy(obj, 0, this.atG.data, 0, 10);
                            }
                            if (bVar.b(this.atG.data, 10, i, true)) {
                                Metadata c = this.atF.c(this.atG.data, i);
                                if (c != null) {
                                    for (Entry entry : c.aqq) {
                                        if (entry instanceof PrivFrame) {
                                            PrivFrame privFrame = (PrivFrame) entry;
                                            if ("com.apple.streaming.transportStreamTimestamp".equals(privFrame.aqU)) {
                                                System.arraycopy(privFrame.aqV, 0, this.atG.data, 0, 8);
                                                this.atG.reset(8);
                                                readLong = this.atG.readLong();
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    readLong = -9223372036854775807L;
                    readLong = readLong != -9223372036854775807L ? this.alB.T(readLong) : this.asN;
                    if (this.atA.endsWith(".aac")) {
                        lVar = new c(readLong);
                    } else if (this.atA.endsWith(".ac3") || this.atA.endsWith(".ec3")) {
                        lVar = new com.google.android.exoplayer2.c.c.a(readLong);
                    } else if (this.atA.endsWith(".mp3")) {
                        lVar = new com.google.android.exoplayer2.c.a.b(readLong);
                    } else {
                        throw new IllegalArgumentException("Unknown extension for audio file: " + this.atA);
                    }
                    lVar.a(this.atL);
                    this.atH = lVar;
                }
                if (z3) {
                    bVar.ck(this.atJ);
                }
                while (i2 == 0) {
                    if (this.asP) {
                        break;
                    }
                    i2 = this.atH.a(bVar);
                }
                this.atJ = (int) (bVar.getPosition() - this.asJ.aAJ);
                com.google.android.exoplayer2.i.t.a(this.aiC);
                this.atM = true;
            } catch (Throwable th2) {
                com.google.android.exoplayer2.i.t.a(this.aiC);
            }
        }
    }
}
