package com.google.android.exoplayer2.a;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.a.e$a.1;
import com.google.android.exoplayer2.a.e$a.2;
import com.google.android.exoplayer2.a.e$a.3;
import com.google.android.exoplayer2.drm.d;
import com.google.android.exoplayer2.e;
import com.google.android.exoplayer2.e.a;
import com.google.android.exoplayer2.e.b;
import com.google.android.exoplayer2.e.c;
import com.google.android.exoplayer2.i.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.p;
import java.util.Arrays;

@TargetApi(16)
public final class i extends b implements f {
    private int aeg;
    private int aeh;
    private final e$a ahm;
    private final f ahn;
    private boolean aho;
    private boolean ahp;
    private MediaFormat ahq;
    private long ahr;
    private boolean ahs;

    public i(c cVar, com.google.android.exoplayer2.drm.b<d> bVar, Handler handler, e eVar, c cVar2, d... dVarArr) {
        super(1, cVar, bVar, true);
        this.ahn = new f(cVar2, dVarArr, new a(this, (byte) 0));
        this.ahm = new e$a(handler, eVar);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final int a(com.google.android.exoplayer2.e.c r11, com.google.android.exoplayer2.Format r12) {
        /*
        r10 = this;
        r6 = 21;
        r7 = -1;
        r3 = 1;
        r1 = 0;
        r2 = r12.adW;
        r0 = com.google.android.exoplayer2.i.g.at(r2);
        if (r0 != 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = com.google.android.exoplayer2.i.t.SDK_INT;
        if (r0 < r6) goto L_0x0025;
    L_0x0012:
        r0 = 32;
    L_0x0014:
        r4 = r10.ah(r2);
        if (r4 == 0) goto L_0x0027;
    L_0x001a:
        r4 = r11.kp();
        if (r4 == 0) goto L_0x0027;
    L_0x0020:
        r0 = r0 | 8;
        r1 = r0 | 4;
        goto L_0x000d;
    L_0x0025:
        r0 = r1;
        goto L_0x0014;
    L_0x0027:
        r5 = r11.d(r2, r1);
        if (r5 != 0) goto L_0x002f;
    L_0x002d:
        r1 = r3;
        goto L_0x000d;
    L_0x002f:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;
        if (r2 < r6) goto L_0x0059;
    L_0x0033:
        r2 = r12.sampleRate;
        if (r2 == r7) goto L_0x0046;
    L_0x0037:
        r2 = r12.sampleRate;
        r4 = r5.aps;
        if (r4 != 0) goto L_0x0061;
    L_0x003d:
        r2 = "sampleRate.caps";
        r5.aj(r2);
        r2 = r1;
    L_0x0044:
        if (r2 == 0) goto L_0x005a;
    L_0x0046:
        r2 = r12.aeg;
        if (r2 == r7) goto L_0x0059;
    L_0x004a:
        r6 = r12.aeg;
        r2 = r5.aps;
        if (r2 != 0) goto L_0x008e;
    L_0x0050:
        r2 = "channelCount.caps";
        r5.aj(r2);
        r2 = r1;
    L_0x0057:
        if (r2 == 0) goto L_0x005a;
    L_0x0059:
        r1 = r3;
    L_0x005a:
        if (r1 == 0) goto L_0x0173;
    L_0x005c:
        r1 = 4;
    L_0x005d:
        r0 = r0 | 8;
        r1 = r1 | r0;
        goto L_0x000d;
    L_0x0061:
        r4 = r5.aps;
        r4 = r4.getAudioCapabilities();
        if (r4 != 0) goto L_0x0071;
    L_0x0069:
        r2 = "sampleRate.aCaps";
        r5.aj(r2);
        r2 = r1;
        goto L_0x0044;
    L_0x0071:
        r4 = r4.isSampleRateSupported(r2);
        if (r4 != 0) goto L_0x008c;
    L_0x0077:
        r4 = new java.lang.StringBuilder;
        r6 = "sampleRate.support, ";
        r4.<init>(r6);
        r2 = r4.append(r2);
        r2 = r2.toString();
        r5.aj(r2);
        r2 = r1;
        goto L_0x0044;
    L_0x008c:
        r2 = r3;
        goto L_0x0044;
    L_0x008e:
        r2 = r5.aps;
        r2 = r2.getAudioCapabilities();
        if (r2 != 0) goto L_0x009e;
    L_0x0096:
        r2 = "channelCount.aCaps";
        r5.aj(r2);
        r2 = r1;
        goto L_0x0057;
    L_0x009e:
        r7 = r5.name;
        r8 = r5.mimeType;
        r4 = r2.getMaxInputChannelCount();
        if (r4 > r3) goto L_0x00b0;
    L_0x00a8:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;
        r9 = 26;
        if (r2 < r9) goto L_0x00c8;
    L_0x00ae:
        if (r4 <= 0) goto L_0x00c8;
    L_0x00b0:
        r2 = r4;
    L_0x00b1:
        if (r2 >= r6) goto L_0x0170;
    L_0x00b3:
        r2 = new java.lang.StringBuilder;
        r4 = "channelCount.support, ";
        r2.<init>(r4);
        r2 = r2.append(r6);
        r2 = r2.toString();
        r5.aj(r2);
        r2 = r1;
        goto L_0x0057;
    L_0x00c8:
        r2 = "audio/mpeg";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00d1:
        r2 = "audio/3gpp";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00da:
        r2 = "audio/amr-wb";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00e3:
        r2 = "audio/mp4a-latm";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00ec:
        r2 = "audio/vorbis";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00f5:
        r2 = "audio/opus";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x00fe:
        r2 = "audio/raw";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0107:
        r2 = "audio/flac";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0110:
        r2 = "audio/g711-alaw";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0119:
        r2 = "audio/g711-mlaw";
        r2 = r2.equals(r8);
        if (r2 != 0) goto L_0x012b;
    L_0x0122:
        r2 = "audio/gsm";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x012d;
    L_0x012b:
        r2 = r4;
        goto L_0x00b1;
    L_0x012d:
        r2 = "audio/ac3";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x0161;
    L_0x0136:
        r2 = 6;
    L_0x0137:
        r8 = new java.lang.StringBuilder;
        r9 = "AssumedMaxChannelAdjustment: ";
        r8.<init>(r9);
        r7 = r8.append(r7);
        r8 = ", [";
        r7 = r7.append(r8);
        r4 = r7.append(r4);
        r7 = " to ";
        r4 = r4.append(r7);
        r4 = r4.append(r2);
        r7 = "]";
        r4.append(r7);
        goto L_0x00b1;
    L_0x0161:
        r2 = "audio/eac3";
        r2 = r2.equals(r8);
        if (r2 == 0) goto L_0x016d;
    L_0x016a:
        r2 = 16;
        goto L_0x0137;
    L_0x016d:
        r2 = 30;
        goto L_0x0137;
    L_0x0170:
        r2 = r3;
        goto L_0x0057;
    L_0x0173:
        r1 = 3;
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a(com.google.android.exoplayer2.e.c, com.google.android.exoplayer2.Format):int");
    }

    protected final a a(c cVar, Format format, boolean z) {
        if (ah(format.adW)) {
            a kp = cVar.kp();
            if (kp != null) {
                this.aho = true;
                return kp;
            }
        }
        this.aho = false;
        return super.a(cVar, format, z);
    }

    private boolean ah(String str) {
        f fVar = this.ahn;
        if (fVar.afQ != null) {
            if (Arrays.binarySearch(fVar.afQ.afz, f.ag(str)) >= 0) {
                return true;
            }
        }
        return false;
    }

    protected final void a(a aVar, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto) {
        boolean z = t.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(aVar.name) && "samsung".equals(t.MANUFACTURER) && (t.DEVICE.startsWith("zeroflte") || t.DEVICE.startsWith("herolte") || t.DEVICE.startsWith("heroqlte"));
        this.ahp = z;
        if (this.aho) {
            this.ahq = format.iQ();
            this.ahq.setString("mime", "audio/raw");
            mediaCodec.configure(this.ahq, null, mediaCrypto, 0);
            this.ahq.setString("mime", format.adW);
            return;
        }
        mediaCodec.configure(format.iQ(), null, mediaCrypto, 0);
        this.ahq = null;
    }

    public final f iq() {
        return this;
    }

    protected final void c(String str, long j, long j2) {
        e$a e_a = this.ahm;
        if (e_a.afC != null) {
            e_a.handler.post(new 2(e_a, str, j, j2));
        }
    }

    protected final void e(Format format) {
        super.e(format);
        e$a e_a = this.ahm;
        if (e_a.afC != null) {
            e_a.handler.post(new 3(e_a, format));
        }
        this.aeh = "audio/raw".equals(format.adW) ? format.aeh : 2;
        this.aeg = format.aeg;
    }

    protected final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int i;
        int[] iArr;
        Object obj = this.ahq != null ? 1 : null;
        String string = obj != null ? this.ahq.getString("mime") : "audio/raw";
        if (obj != null) {
            mediaFormat = this.ahq;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (this.ahp && integer == 6 && this.aeg < 6) {
            int[] iArr2 = new int[this.aeg];
            for (i = 0; i < this.aeg; i++) {
                iArr2[i] = i;
            }
            iArr = iArr2;
        } else {
            iArr = null;
        }
        try {
            int i2;
            f fVar = this.ahn;
            i = this.aeh;
            boolean z = !"audio/raw".equals(string);
            int ag = z ? f.ag(string) : i;
            int i3 = 0;
            if (z) {
                i2 = 0;
            } else {
                fVar.agr = t.ax(i, integer);
                fVar.afR.ahf = iArr;
                i = integer;
                for (d dVar : fVar.afT) {
                    i3 |= dVar.r(integer2, i, ag);
                    if (dVar.isActive()) {
                        i = dVar.iY();
                        ag = dVar.iZ();
                    }
                }
                if (i3 != 0) {
                    fVar.jc();
                }
                i2 = i3;
                integer = i;
            }
            switch (integer) {
                case 1:
                    i = 4;
                    break;
                case 2:
                    i = 12;
                    break;
                case 3:
                    i = 28;
                    break;
                case 4:
                    i = 204;
                    break;
                case 5:
                    i = 220;
                    break;
                case 6:
                    i = 252;
                    break;
                case 7:
                    i = 1276;
                    break;
                case 8:
                    i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                    break;
                default:
                    throw new f.c("Unsupported channel count: " + integer);
            }
            if (t.SDK_INT <= 23 && "foster".equals(t.DEVICE) && "NVIDIA".equals(t.MANUFACTURER)) {
                switch (integer) {
                    case 3:
                    case 5:
                        i = 252;
                        break;
                    case 7:
                        i = com.google.android.exoplayer2.b.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                }
            }
            i3 = (t.SDK_INT <= 25 && "fugu".equals(t.DEVICE) && z && integer == 1) ? 12 : i;
            if (i2 != 0 || !fVar.isInitialized() || fVar.encoding != ag || fVar.sampleRate != integer2 || fVar.agb != i3) {
                f fVar2;
                fVar.reset();
                fVar.encoding = ag;
                fVar.agd = z;
                fVar.sampleRate = integer2;
                fVar.agb = i3;
                fVar.agc = z ? ag : 2;
                fVar.agu = t.ax(2, integer);
                if (!z) {
                    ag = AudioTrack.getMinBufferSize(integer2, i3, fVar.agc);
                    com.google.android.exoplayer2.i.a.ap(ag != -2);
                    i3 = ag * 4;
                    i = ((int) fVar.A(250000)) * fVar.agu;
                    ag = (int) Math.max((long) ag, fVar.A(750000) * ((long) fVar.agu));
                    if (i3 < i) {
                        fVar2 = fVar;
                    } else if (i3 > ag) {
                        i = ag;
                        fVar2 = fVar;
                    } else {
                        i = i3;
                        fVar2 = fVar;
                    }
                } else if (fVar.agc == 5 || fVar.agc == 6) {
                    i = 20480;
                    fVar2 = fVar;
                } else {
                    i = 49152;
                    fVar2 = fVar;
                }
                fVar2.bufferSize = i;
                fVar.age = z ? -9223372036854775807L : fVar.z((long) (fVar.bufferSize / fVar.agu));
                fVar.b(fVar.acY);
            }
        } catch (Throwable e) {
            throw new f.c(e);
        } catch (f.c e2) {
            throw e.a(e2, this.index);
        }
    }

    protected static void jr() {
    }

    protected static void js() {
    }

    protected static void jt() {
    }

    protected final void ae(boolean z) {
        boolean z2 = false;
        super.ae(z);
        e$a e_a = this.ahm;
        com.google.android.exoplayer2.b.d dVar = this.aqc;
        if (e_a.afC != null) {
            e_a.handler.post(new 1(e_a, dVar));
        }
        int i = this.acj.aeA;
        if (i != 0) {
            f fVar = this.ahn;
            if (t.SDK_INT >= 21) {
                z2 = true;
            }
            com.google.android.exoplayer2.i.a.ap(z2);
            if (!fVar.agM || fVar.aeS != i) {
                fVar.agM = true;
                fVar.aeS = i;
                fVar.reset();
                return;
            }
            return;
        }
        f fVar2 = this.ahn;
        if (fVar2.agM) {
            fVar2.agM = false;
            fVar2.aeS = 0;
            fVar2.reset();
        }
    }

    protected final void b(long j, boolean z) {
        super.b(j, z);
        this.ahn.reset();
        this.ahr = j;
        this.ahs = true;
    }

    protected final void onStarted() {
        super.onStarted();
        this.ahn.play();
    }

    protected final void onStopped() {
        f fVar = this.ahn;
        fVar.agL = false;
        if (fVar.isInitialized()) {
            fVar.jj();
            fVar.afX.pause();
        }
        super.onStopped();
    }

    protected final void ix() {
        try {
            f fVar = this.ahn;
            fVar.reset();
            fVar.jg();
            for (d reset : fVar.afT) {
                reset.reset();
            }
            fVar.aeS = 0;
            fVar.agL = false;
            try {
                super.ix();
            } finally {
                this.aqc.jC();
                this.ahm.e(this.aqc);
            }
        } catch (Throwable th) {
            super.ix();
        } finally {
            this.aqc.jC();
            this.ahm.e(this.aqc);
        }
    }

    public final boolean iT() {
        if (super.iT()) {
            f fVar = this.ahn;
            boolean z = !fVar.isInitialized() || (fVar.agK && !fVar.je());
            if (z) {
                return true;
            }
        }
        return false;
    }

    public final boolean hv() {
        return this.ahn.je() || super.hv();
    }

    public final long jn() {
        long aj = this.ahn.aj(iT());
        if (aj != Long.MIN_VALUE) {
            if (!this.ahs) {
                aj = Math.max(this.ahr, aj);
            }
            this.ahr = aj;
            this.ahs = false;
        }
        return this.ahr;
    }

    public final p b(p pVar) {
        return this.ahn.b(pVar);
    }

    public final p ju() {
        return this.ahn.acY;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected final boolean a(long r12, long r14, android.media.MediaCodec r16, java.nio.ByteBuffer r17, int r18, int r19, long r20, boolean r22) {
        /*
        r11 = this;
        r2 = r11.aho;
        if (r2 == 0) goto L_0x0012;
    L_0x0004:
        r2 = r19 & 2;
        if (r2 == 0) goto L_0x0012;
    L_0x0008:
        r2 = 0;
        r0 = r16;
        r1 = r18;
        r0.releaseOutputBuffer(r1, r2);
        r2 = 1;
    L_0x0011:
        return r2;
    L_0x0012:
        if (r22 == 0) goto L_0x0030;
    L_0x0014:
        r2 = 0;
        r0 = r16;
        r1 = r18;
        r0.releaseOutputBuffer(r1, r2);
        r2 = r11.aqc;
        r3 = r2.aic;
        r3 = r3 + 1;
        r2.aic = r3;
        r2 = r11.ahn;
        r3 = r2.agy;
        r4 = 1;
        if (r3 != r4) goto L_0x002e;
    L_0x002b:
        r3 = 2;
        r2.agy = r3;
    L_0x002e:
        r2 = 1;
        goto L_0x0011;
    L_0x0030:
        r10 = r11.ahn;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.agF;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x003c;
    L_0x0036:
        r2 = r10.agF;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r0 = r17;
        if (r0 != r2) goto L_0x00cd;
    L_0x003c:
        r2 = 1;
    L_0x003d:
        com.google.android.exoplayer2.i.a.ao(r2);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.isInitialized();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x00a5;
    L_0x0046:
        r2 = r10.afV;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2.block();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.jl();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r10.aga = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.aga;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r9 = r2.getAudioSessionId();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = com.google.android.exoplayer2.a.f.afO;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x0082;
    L_0x005b:
        r2 = com.google.android.exoplayer2.i.t.SDK_INT;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = 21;
        if (r2 >= r3) goto L_0x0082;
    L_0x0061:
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x0070;
    L_0x0065:
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.getAudioSessionId();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r9 == r2) goto L_0x0070;
    L_0x006d:
        r10.jg();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0070:
        r2 = r10.afZ;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x0082;
    L_0x0074:
        r2 = new android.media.AudioTrack;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = 3;
        r4 = 4000; // 0xfa0 float:5.605E-42 double:1.9763E-320;
        r5 = 4;
        r6 = 2;
        r7 = 2;
        r8 = 0;
        r2.<init>(r3, r4, r5, r6, r7, r8, r9);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r10.afZ = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0082:
        r2 = r10.aeS;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == r9) goto L_0x008d;
    L_0x0086:
        r10.aeS = r9;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.afU;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2.cb(r9);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x008d:
        r2 = r10.afX;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = r10.aga;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r10.jk();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2.a(r3, r4);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r10.jf();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = 0;
        r10.agN = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.agL;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x00a5;
    L_0x00a2:
        r10.play();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x00a5:
        r2 = r10.jk();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x00e5;
    L_0x00ab:
        r2 = r10.aga;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.getPlayState();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = 2;
        if (r2 != r3) goto L_0x00d0;
    L_0x00b4:
        r2 = 0;
        r10.agN = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x00b7:
        r2 = 0;
    L_0x00b8:
        if (r2 == 0) goto L_0x0233;
    L_0x00ba:
        r2 = 0;
        r0 = r16;
        r1 = r18;
        r0.releaseOutputBuffer(r1, r2);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r11.aqc;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = r2.aib;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = r3 + 1;
        r2.aib = r3;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = 1;
        goto L_0x0011;
    L_0x00cd:
        r2 = 0;
        goto L_0x003d;
    L_0x00d0:
        r2 = r10.aga;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.getPlayState();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = 1;
        if (r2 != r3) goto L_0x00e5;
    L_0x00d9:
        r2 = r10.afX;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.jm();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = 0;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x00b7;
    L_0x00e5:
        r2 = r10.agN;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = r10.je();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r10.agN = r3;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x0111;
    L_0x00ef:
        r2 = r10.agN;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x0111;
    L_0x00f3:
        r2 = r10.aga;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.getPlayState();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = 1;
        if (r2 == r3) goto L_0x0111;
    L_0x00fc:
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r10.agO;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r6 = r2 - r4;
        r2 = r10.afU;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = r10.bufferSize;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r10.age;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = com.google.android.exoplayer2.b.n(r4);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2.d(r3, r4, r6);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0111:
        r2 = r10.agF;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x0182;
    L_0x0115:
        r2 = r17.hasRemaining();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x011d;
    L_0x011b:
        r2 = 1;
        goto L_0x00b8;
    L_0x011d:
        r2 = r10.agd;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x0134;
    L_0x0121:
        r2 = r10.agx;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x0134;
    L_0x0125:
        r2 = r10.agc;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = 7;
        if (r2 == r3) goto L_0x012e;
    L_0x012a:
        r3 = 8;
        if (r2 != r3) goto L_0x019b;
    L_0x012e:
        r2 = com.google.android.exoplayer2.a.h.d(r17);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0132:
        r10.agx = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0134:
        r2 = r10.agf;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x0161;
    L_0x0138:
        r2 = r10.jd();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x00b7;
    L_0x013e:
        r9 = r10.afY;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = new com.google.android.exoplayer2.a.f$g;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3 = r10.agf;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = 0;
        r0 = r20;
        r4 = java.lang.Math.max(r4, r0);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r6 = r10.ji();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r6 = r10.z(r6);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r8 = 0;
        r2.<init>(r3, r4, r6, r8);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r9.add(r2);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = 0;
        r10.agf = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r10.jc();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0161:
        r2 = r10.agy;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x01c9;
    L_0x0165:
        r2 = 0;
        r0 = r20;
        r2 = java.lang.Math.max(r2, r0);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r10.agz = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = 1;
        r10.agy = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0172:
        r2 = r10.agd;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x0220;
    L_0x0176:
        r2 = r10.agt;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r10.agx;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = (long) r4;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2 + r4;
        r10.agt = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x017e:
        r0 = r17;
        r10.agF = r0;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0182:
        r2 = r10.agd;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 == 0) goto L_0x022c;
    L_0x0186:
        r2 = r10.agF;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r0 = r20;
        r10.a(r2, r0);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x018d:
        r2 = r10.agF;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.hasRemaining();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        if (r2 != 0) goto L_0x00b7;
    L_0x0195:
        r2 = 0;
        r10.agF = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = 1;
        goto L_0x00b8;
    L_0x019b:
        r3 = 5;
        if (r2 != r3) goto L_0x01a3;
    L_0x019e:
        r2 = com.google.android.exoplayer2.a.a.iX();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        goto L_0x0132;
    L_0x01a3:
        r3 = 6;
        if (r2 != r3) goto L_0x01ab;
    L_0x01a6:
        r2 = com.google.android.exoplayer2.a.a.b(r17);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        goto L_0x0132;
    L_0x01ab:
        r3 = new java.lang.IllegalStateException;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = new java.lang.StringBuilder;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r5 = "Unexpected audio encoding: ";
        r4.<init>(r5);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r4.append(r2);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2.toString();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r3.<init>(r2);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        throw r3;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x01c1:
        r2 = move-exception;
    L_0x01c2:
        r3 = r11.index;
        r2 = com.google.android.exoplayer2.e.a(r2, r3);
        throw r2;
    L_0x01c9:
        r2 = r10.agz;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r10.jh();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r10.z(r4);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2 + r4;
        r4 = r10.agy;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r5 = 1;
        if (r4 != r5) goto L_0x0208;
    L_0x01d9:
        r4 = r2 - r20;
        r4 = java.lang.Math.abs(r4);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r6 = 200000; // 0x30d40 float:2.8026E-40 double:9.8813E-319;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 <= 0) goto L_0x0208;
    L_0x01e6:
        r4 = new java.lang.StringBuilder;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r5 = "Discontinuity detected [expected ";
        r4.<init>(r5);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r4.append(r2);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r5 = ", got ";
        r4 = r4.append(r5);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r0 = r20;
        r4 = r4.append(r0);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r5 = "]";
        r4.append(r5);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = 2;
        r10.agy = r4;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
    L_0x0208:
        r4 = r10.agy;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r5 = 2;
        if (r4 != r5) goto L_0x0172;
    L_0x020d:
        r4 = r10.agz;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r20 - r2;
        r2 = r2 + r4;
        r10.agz = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = 1;
        r10.agy = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r10.afU;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2.iS();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        goto L_0x0172;
    L_0x021e:
        r2 = move-exception;
        goto L_0x01c2;
    L_0x0220:
        r2 = r10.ags;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = r17.remaining();	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r4 = (long) r4;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        r2 = r2 + r4;
        r10.ags = r2;	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        goto L_0x017e;
    L_0x022c:
        r0 = r20;
        r10.x(r0);	 Catch:{ d -> 0x01c1, f$h -> 0x021e }
        goto L_0x018d;
    L_0x0233:
        r2 = 0;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.a.i.a(long, long, android.media.MediaCodec, java.nio.ByteBuffer, int, int, long, boolean):boolean");
    }

    protected final void jv() {
        try {
            f fVar = this.ahn;
            if (!fVar.agK && fVar.isInitialized() && fVar.jd()) {
                fVar.afX.B(fVar.ji());
                fVar.agj = 0;
                fVar.agK = true;
            }
        } catch (Exception e) {
            throw e.a(e, this.index);
        }
    }

    public final void d(int i, Object obj) {
        f fVar;
        switch (i) {
            case 2:
                fVar = this.ahn;
                float floatValue = ((Float) obj).floatValue();
                if (fVar.agC != floatValue) {
                    fVar.agC = floatValue;
                    fVar.jf();
                    return;
                }
                return;
            case 3:
                b bVar = (b) obj;
                fVar = this.ahn;
                if (!fVar.aeT.equals(bVar)) {
                    fVar.aeT = bVar;
                    if (!fVar.agM) {
                        fVar.reset();
                        fVar.aeS = 0;
                        return;
                    }
                    return;
                }
                return;
            default:
                super.d(i, obj);
                return;
        }
    }
}
