package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.p;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

public final class f {
    public static boolean afO = false;
    public static boolean afP = false;
    p acY;
    int aeS;
    b aeT;
    final c afQ;
    final g afR;
    private final l afS;
    final d[] afT;
    final f afU;
    final ConditionVariable afV = new ConditionVariable(true);
    private final long[] afW;
    final a afX;
    final LinkedList<g> afY;
    AudioTrack afZ;
    private long agA;
    private long agB;
    float agC;
    private d[] agD;
    private ByteBuffer[] agE;
    ByteBuffer agF;
    private ByteBuffer agG;
    private byte[] agH;
    private int agI;
    private int agJ;
    boolean agK;
    boolean agL;
    boolean agM;
    boolean agN;
    long agO;
    AudioTrack aga;
    int agb;
    int agc;
    boolean agd;
    long age;
    p agf;
    private long agg;
    private long agh;
    private ByteBuffer agi;
    int agj;
    private int agk;
    private int agl;
    private long agm;
    private long agn;
    private boolean ago;
    private long agp;
    private Method agq;
    int agr;
    long ags;
    long agt;
    int agu;
    private long agv;
    private long agw;
    int agx;
    int agy;
    long agz;
    int bufferSize;
    int encoding;
    int sampleRate;

    public static final class d extends Exception {
        public final int ahc;

        public d(int i, int i2, int i3, int i4) {
            super("AudioTrack init failed: " + i + ", Config(" + i2 + ", " + i3 + ", " + i4 + ")");
            this.ahc = i;
        }
    }

    public f(c cVar, d[] dVarArr, f fVar) {
        this.afQ = cVar;
        this.afU = fVar;
        if (t.SDK_INT >= 18) {
            try {
                this.agq = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException e) {
            }
        }
        if (t.SDK_INT >= 19) {
            this.afX = new b();
        } else {
            this.afX = new a((byte) 0);
        }
        this.afR = new g();
        this.afS = new l();
        this.afT = new d[(dVarArr.length + 3)];
        this.afT[0] = new j();
        this.afT[1] = this.afR;
        System.arraycopy(dVarArr, 0, this.afT, 2, dVarArr.length);
        this.afT[dVarArr.length + 2] = this.afS;
        this.afW = new long[10];
        this.agC = 1.0f;
        this.agy = 0;
        this.aeT = b.afu;
        this.aeS = 0;
        this.acY = p.aew;
        this.agJ = -1;
        this.agD = new d[0];
        this.agE = new ByteBuffer[0];
        this.afY = new LinkedList();
    }

    public final long aj(boolean z) {
        Object obj = (!isInitialized() || this.agy == 0) ? null : 1;
        if (obj == null) {
            return Long.MIN_VALUE;
        }
        long jp;
        if (this.aga.getPlayState() == 3) {
            long jn = this.afX.jn();
            if (jn != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.agn >= 30000) {
                    this.afW[this.agk] = jn - nanoTime;
                    this.agk = (this.agk + 1) % 10;
                    if (this.agl < 10) {
                        this.agl++;
                    }
                    this.agn = nanoTime;
                    this.agm = 0;
                    for (int i = 0; i < this.agl; i++) {
                        this.agm += this.afW[i] / ((long) this.agl);
                    }
                }
                if (!jk() && nanoTime - this.agp >= 500000) {
                    this.ago = this.afX.jo();
                    if (this.ago) {
                        jp = this.afX.jp() / 1000;
                        long jq = this.afX.jq();
                        if (jp >= this.agA) {
                            String str;
                            if (Math.abs(jp - nanoTime) > 5000000) {
                                str = "Spurious audio timestamp (system clock mismatch): " + jq + ", " + jp + ", " + nanoTime + ", " + jn + ", " + jh() + ", " + ji();
                                if (afP) {
                                    throw new e(str);
                                }
                                this.ago = false;
                            } else if (Math.abs(z(jq) - jn) > 5000000) {
                                str = "Spurious audio timestamp (frame position mismatch): " + jq + ", " + jp + ", " + nanoTime + ", " + jn + ", " + jh() + ", " + ji();
                                if (afP) {
                                    throw new e(str);
                                }
                            }
                        }
                        this.ago = false;
                    }
                    if (!(this.agq == null || this.agd)) {
                        try {
                            this.agB = (((long) ((Integer) this.agq.invoke(this.aga, null)).intValue()) * 1000) - this.age;
                            this.agB = Math.max(this.agB, 0);
                            if (this.agB > 5000000) {
                                new StringBuilder("Ignoring impossibly large audio latency: ").append(this.agB);
                                this.agB = 0;
                            }
                        } catch (Exception e) {
                            this.agq = null;
                        }
                    }
                    this.agp = nanoTime;
                }
            }
        }
        jp = System.nanoTime() / 1000;
        if (this.ago) {
            jp = z(A(jp - (this.afX.jp() / 1000)) + this.afX.jq());
        } else {
            if (this.agl == 0) {
                jp = this.afX.jn();
            } else {
                jp += this.agm;
            }
            if (!z) {
                jp -= this.agB;
            }
        }
        return y(jp) + this.agz;
    }

    final void jc() {
        int i;
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.afT) {
            if (dVar.isActive()) {
                arrayList.add(dVar);
            } else {
                dVar.flush();
            }
        }
        int size = arrayList.size();
        this.agD = (d[]) arrayList.toArray(new d[size]);
        this.agE = new ByteBuffer[size];
        for (i = 0; i < size; i++) {
            d dVar2 = this.agD[i];
            dVar2.flush();
            this.agE[i] = dVar2.jb();
        }
    }

    public final void play() {
        this.agL = true;
        if (isInitialized()) {
            this.agA = System.nanoTime() / 1000;
            this.aga.play();
        }
    }

    final void x(long j) {
        int length = this.agD.length;
        int i = length;
        while (i >= 0) {
            ByteBuffer byteBuffer = i > 0 ? this.agE[i - 1] : this.agF != null ? this.agF : d.afB;
            if (i == length) {
                a(byteBuffer, j);
            } else {
                d dVar = this.agD[i];
                dVar.c(byteBuffer);
                ByteBuffer jb = dVar.jb();
                this.agE[i] = jb;
                if (jb.hasRemaining()) {
                    i++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i--;
            } else {
                return;
            }
        }
    }

    final boolean a(ByteBuffer byteBuffer, long j) {
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        boolean z;
        int remaining;
        int position;
        if (this.agG != null) {
            if (this.agG == byteBuffer) {
                z = true;
            } else {
                z = false;
            }
            a.ao(z);
        } else {
            this.agG = byteBuffer;
            if (t.SDK_INT < 21) {
                remaining = byteBuffer.remaining();
                if (this.agH == null || this.agH.length < remaining) {
                    this.agH = new byte[remaining];
                }
                position = byteBuffer.position();
                byteBuffer.get(this.agH, 0, remaining);
                byteBuffer.position(position);
                this.agI = 0;
            }
        }
        position = byteBuffer.remaining();
        if (t.SDK_INT < 21) {
            remaining = this.bufferSize - ((int) (this.agv - (this.afX.jm() * ((long) this.agu))));
            if (remaining > 0) {
                remaining = this.aga.write(this.agH, this.agI, Math.min(position, remaining));
                if (remaining > 0) {
                    this.agI += remaining;
                    byteBuffer.position(byteBuffer.position() + remaining);
                }
            } else {
                remaining = 0;
            }
        } else if (this.agM) {
            if (j != -9223372036854775807L) {
                z = true;
            } else {
                z = false;
            }
            a.ap(z);
            AudioTrack audioTrack = this.aga;
            if (this.agi == null) {
                this.agi = ByteBuffer.allocate(16);
                this.agi.order(ByteOrder.BIG_ENDIAN);
                this.agi.putInt(1431633921);
            }
            if (this.agj == 0) {
                this.agi.putInt(4, position);
                this.agi.putLong(8, 1000 * j);
                this.agi.position(0);
                this.agj = position;
            }
            int remaining2 = this.agi.remaining();
            if (remaining2 > 0) {
                remaining = audioTrack.write(this.agi, remaining2, 1);
                if (remaining < 0) {
                    this.agj = 0;
                } else if (remaining < remaining2) {
                    remaining = 0;
                }
            }
            remaining = audioTrack.write(byteBuffer, position, 1);
            if (remaining < 0) {
                this.agj = 0;
            } else {
                this.agj -= remaining;
            }
        } else {
            remaining = this.aga.write(byteBuffer, position, 1);
        }
        this.agO = SystemClock.elapsedRealtime();
        if (remaining < 0) {
            throw new h(remaining);
        }
        if (!this.agd) {
            this.agv += (long) remaining;
        }
        if (remaining != position) {
            return false;
        }
        if (this.agd) {
            this.agw += (long) this.agx;
        }
        this.agG = null;
        return true;
    }

    final boolean jd() {
        boolean z;
        if (this.agJ == -1) {
            this.agJ = this.agd ? this.agD.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (this.agJ < this.agD.length) {
            d dVar = this.agD[this.agJ];
            if (z) {
                dVar.ja();
            }
            x(-9223372036854775807L);
            if (!dVar.iT()) {
                return false;
            }
            this.agJ++;
            z = true;
        }
        if (this.agG != null) {
            a(this.agG, -9223372036854775807L);
            if (this.agG != null) {
                return false;
            }
        }
        this.agJ = -1;
        return true;
    }

    public final boolean je() {
        if (isInitialized()) {
            if (ji() > this.afX.jm()) {
                return true;
            }
            boolean z = jk() && this.aga.getPlayState() == 2 && this.aga.getPlaybackHeadPosition() == 0;
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final p b(p pVar) {
        if (this.agd) {
            this.acY = p.aew;
            return this.acY;
        }
        l lVar = this.afS;
        lVar.aex = t.g(pVar.aex, 0.1f, 8.0f);
        float f = lVar.aex;
        l lVar2 = this.afS;
        float f2 = pVar.pitch;
        lVar2.pitch = t.g(f2, 0.1f, 8.0f);
        p pVar2 = new p(f, f2);
        Object obj = this.agf != null ? this.agf : !this.afY.isEmpty() ? ((g) this.afY.getLast()).acY : this.acY;
        if (!pVar2.equals(obj)) {
            if (isInitialized()) {
                this.agf = pVar2;
            } else {
                this.acY = pVar2;
            }
        }
        return this.acY;
    }

    final void jf() {
        if (!isInitialized()) {
            return;
        }
        if (t.SDK_INT >= 21) {
            this.aga.setVolume(this.agC);
            return;
        }
        AudioTrack audioTrack = this.aga;
        float f = this.agC;
        audioTrack.setStereoVolume(f, f);
    }

    public final void reset() {
        if (isInitialized()) {
            this.ags = 0;
            this.agt = 0;
            this.agv = 0;
            this.agw = 0;
            this.agx = 0;
            if (this.agf != null) {
                this.acY = this.agf;
                this.agf = null;
            } else if (!this.afY.isEmpty()) {
                this.acY = ((g) this.afY.getLast()).acY;
            }
            this.afY.clear();
            this.agg = 0;
            this.agh = 0;
            this.agF = null;
            this.agG = null;
            for (int i = 0; i < this.agD.length; i++) {
                d dVar = this.agD[i];
                dVar.flush();
                this.agE[i] = dVar.jb();
            }
            this.agK = false;
            this.agJ = -1;
            this.agi = null;
            this.agj = 0;
            this.agy = 0;
            this.agB = 0;
            jj();
            if (this.aga.getPlayState() == 3) {
                this.aga.pause();
            }
            AudioTrack audioTrack = this.aga;
            this.aga = null;
            this.afX.a(null, false);
            this.afV.close();
            new 1(this, audioTrack).start();
        }
    }

    final void jg() {
        if (this.afZ != null) {
            AudioTrack audioTrack = this.afZ;
            this.afZ = null;
            new 2(this, audioTrack).start();
        }
    }

    private long y(long j) {
        while (!this.afY.isEmpty() && j >= ((g) this.afY.getFirst()).adM) {
            g gVar = (g) this.afY.remove();
            this.acY = gVar.acY;
            this.agh = gVar.adM;
            this.agg = gVar.ahd - this.agz;
        }
        if (this.acY.aex == 1.0f) {
            return (this.agg + j) - this.agh;
        }
        if (!this.afY.isEmpty() || this.afS.ahS < 1024) {
            return this.agg + ((long) (((double) this.acY.aex) * ((double) (j - this.agh))));
        }
        return t.a(j - this.agh, this.afS.ahR, this.afS.ahS) + this.agg;
    }

    final boolean isInitialized() {
        return this.aga != null;
    }

    final long z(long j) {
        return (1000000 * j) / ((long) this.sampleRate);
    }

    final long A(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    final long jh() {
        return this.agd ? this.agt : this.ags / ((long) this.agr);
    }

    final long ji() {
        return this.agd ? this.agw : this.agv / ((long) this.agu);
    }

    final void jj() {
        this.agm = 0;
        this.agl = 0;
        this.agk = 0;
        this.agn = 0;
        this.ago = false;
        this.agp = 0;
    }

    final boolean jk() {
        return t.SDK_INT < 23 && (this.agc == 5 || this.agc == 6);
    }

    final AudioTrack jl() {
        AudioTrack audioTrack;
        if (t.SDK_INT >= 21) {
            AudioAttributes build;
            int i;
            if (this.agM) {
                build = new Builder().setContentType(3).setFlags(16).setUsage(1).build();
            } else {
                b bVar = this.aeT;
                if (bVar.afx == null) {
                    bVar.afx = new Builder().setContentType(bVar.afv).setFlags(bVar.flags).setUsage(bVar.afw).build();
                }
                build = bVar.afx;
            }
            AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.agb).setEncoding(this.agc).setSampleRate(this.sampleRate).build();
            if (this.aeS != 0) {
                i = this.aeS;
            } else {
                i = 0;
            }
            audioTrack = new AudioTrack(build, build2, this.bufferSize, 1, i);
        } else {
            int de = t.de(this.aeT.afw);
            if (this.aeS == 0) {
                audioTrack = new AudioTrack(de, this.sampleRate, this.agb, this.agc, this.bufferSize, 1);
            } else {
                audioTrack = new AudioTrack(de, this.sampleRate, this.agb, this.agc, this.bufferSize, 1, this.aeS);
            }
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception e) {
        }
        throw new d(state, this.sampleRate, this.agb, this.bufferSize);
    }

    static int ag(String str) {
        int i = -1;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    i = 2;
                    break;
                }
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    i = 0;
                    break;
                }
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    i = 1;
                    break;
                }
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    i = 3;
                    break;
                }
                break;
        }
        switch (i) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }
}
