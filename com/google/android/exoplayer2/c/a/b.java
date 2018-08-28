package com.google.android.exoplayer2.c.a;

import com.google.android.exoplayer2.c.d;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;

public final class b implements d {
    public static final g aiU = new 1();
    private static final int aiV = t.aE("Xing");
    private static final int aiW = t.aE("Info");
    private static final int aiX = t.aE("VBRI");
    private Metadata adU;
    private final long aiY;
    private final j aiZ;
    private final i aja;
    private final h ajb;
    private f ajc;
    private k ajd;
    private int aje;
    private a ajf;
    private long ajg;
    private long ajh;
    private int aji;
    private final int flags;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this(-9223372036854775807L);
    }

    public b(long j) {
        this.flags = 0;
        this.aiY = j;
        this.aiZ = new j(10);
        this.aja = new i();
        this.ajb = new h();
        this.ajg = -9223372036854775807L;
    }

    public final void a(f fVar) {
        this.ajc = fVar;
        this.ajd = this.ajc.cp(0);
        this.ajc.jU();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.google.android.exoplayer2.c.e r23) {
        /*
        r22 = this;
        r0 = r22;
        r2 = r0.aje;
        if (r2 != 0) goto L_0x013c;
    L_0x0006:
        r5 = 0;
        r3 = 0;
        r4 = 0;
        r23.jS();	 Catch:{ EOFException -> 0x010c }
        r6 = r23.getPosition();	 Catch:{ EOFException -> 0x010c }
        r8 = 0;
        r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r2 != 0) goto L_0x00ca;
    L_0x0016:
        r2 = 0;
        r7 = r2;
    L_0x0018:
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r2 = r2.data;	 Catch:{ EOFException -> 0x010c }
        r6 = 0;
        r8 = 10;
        r0 = r23;
        r0.b(r2, r6, r8);	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r6 = 0;
        r2.setPosition(r6);	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r2 = r2.mf();	 Catch:{ EOFException -> 0x010c }
        r6 = com.google.android.exoplayer2.metadata.id3.a.amG;	 Catch:{ EOFException -> 0x010c }
        if (r2 != r6) goto L_0x00b8;
    L_0x003a:
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r6 = 3;
        r2.da(r6);	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r2 = r2.mg();	 Catch:{ EOFException -> 0x010c }
        r8 = r2 + 10;
        r0 = r22;
        r6 = r0.adU;	 Catch:{ EOFException -> 0x010c }
        if (r6 != 0) goto L_0x00ae;
    L_0x0052:
        r6 = new byte[r8];	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r9 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r9 = r9.data;	 Catch:{ EOFException -> 0x010c }
        r10 = 0;
        r11 = 0;
        r12 = 10;
        java.lang.System.arraycopy(r9, r10, r6, r11, r12);	 Catch:{ EOFException -> 0x010c }
        r9 = 10;
        r0 = r23;
        r0.b(r6, r9, r2);	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r2 = r0.flags;	 Catch:{ EOFException -> 0x010c }
        r2 = r2 & 2;
        if (r2 == 0) goto L_0x00ac;
    L_0x0070:
        r2 = com.google.android.exoplayer2.c.h.aiH;	 Catch:{ EOFException -> 0x010c }
    L_0x0072:
        r9 = new com.google.android.exoplayer2.metadata.id3.a;	 Catch:{ EOFException -> 0x010c }
        r9.<init>(r2);	 Catch:{ EOFException -> 0x010c }
        r2 = r9.c(r6, r8);	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r0.adU = r2;	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r2 = r0.adU;	 Catch:{ EOFException -> 0x010c }
        if (r2 == 0) goto L_0x00b3;
    L_0x0085:
        r0 = r22;
        r9 = r0.ajb;	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r10 = r0.adU;	 Catch:{ EOFException -> 0x010c }
        r2 = 0;
        r6 = r2;
    L_0x008f:
        r2 = r10.aqq;	 Catch:{ EOFException -> 0x010c }
        r2 = r2.length;	 Catch:{ EOFException -> 0x010c }
        if (r6 >= r2) goto L_0x00b3;
    L_0x0094:
        r2 = r10.aqq;	 Catch:{ EOFException -> 0x010c }
        r2 = r2[r6];	 Catch:{ EOFException -> 0x010c }
        r11 = r2 instanceof com.google.android.exoplayer2.metadata.id3.CommentFrame;	 Catch:{ EOFException -> 0x010c }
        if (r11 == 0) goto L_0x00a8;
    L_0x009c:
        r2 = (com.google.android.exoplayer2.metadata.id3.CommentFrame) r2;	 Catch:{ EOFException -> 0x010c }
        r11 = r2.description;	 Catch:{ EOFException -> 0x010c }
        r2 = r2.text;	 Catch:{ EOFException -> 0x010c }
        r2 = r9.j(r11, r2);	 Catch:{ EOFException -> 0x010c }
        if (r2 != 0) goto L_0x00b3;
    L_0x00a8:
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x008f;
    L_0x00ac:
        r2 = 0;
        goto L_0x0072;
    L_0x00ae:
        r0 = r23;
        r0.cl(r2);	 Catch:{ EOFException -> 0x010c }
    L_0x00b3:
        r2 = r7 + r8;
        r7 = r2;
        goto L_0x0018;
    L_0x00b8:
        r23.jS();	 Catch:{ EOFException -> 0x010c }
        r0 = r23;
        r0.cl(r7);	 Catch:{ EOFException -> 0x010c }
        r6 = r23.jT();	 Catch:{ EOFException -> 0x010c }
        r2 = (int) r6;	 Catch:{ EOFException -> 0x010c }
        r0 = r23;
        r0.ck(r2);	 Catch:{ EOFException -> 0x010c }
    L_0x00ca:
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r6 = r2.data;	 Catch:{ EOFException -> 0x010c }
        r7 = 0;
        r8 = 4;
        if (r5 <= 0) goto L_0x010f;
    L_0x00d4:
        r2 = 1;
    L_0x00d5:
        r0 = r23;
        r2 = r0.b(r6, r7, r8, r2);	 Catch:{ EOFException -> 0x010c }
        if (r2 == 0) goto L_0x0135;
    L_0x00dd:
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r6 = 0;
        r2.setPosition(r6);	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r2 = r0.aiZ;	 Catch:{ EOFException -> 0x010c }
        r2 = r2.readInt();	 Catch:{ EOFException -> 0x010c }
        if (r3 == 0) goto L_0x00f6;
    L_0x00ef:
        r6 = (long) r3;	 Catch:{ EOFException -> 0x010c }
        r6 = e(r2, r6);	 Catch:{ EOFException -> 0x010c }
        if (r6 == 0) goto L_0x00fd;
    L_0x00f6:
        r6 = com.google.android.exoplayer2.c.i.cq(r2);	 Catch:{ EOFException -> 0x010c }
        r7 = -1;
        if (r6 != r7) goto L_0x011b;
    L_0x00fd:
        r2 = r4 + 1;
        r3 = 131072; // 0x20000 float:1.83671E-40 double:6.47582E-319;
        if (r4 != r3) goto L_0x0111;
    L_0x0103:
        r2 = new com.google.android.exoplayer2.o;	 Catch:{ EOFException -> 0x010c }
        r3 = "Searched too many bytes.";
        r2.<init>(r3);	 Catch:{ EOFException -> 0x010c }
        throw r2;	 Catch:{ EOFException -> 0x010c }
    L_0x010c:
        r2 = move-exception;
        r2 = -1;
    L_0x010e:
        return r2;
    L_0x010f:
        r2 = 0;
        goto L_0x00d5;
    L_0x0111:
        r5 = 0;
        r3 = 0;
        r4 = 1;
        r0 = r23;
        r0.ck(r4);	 Catch:{ EOFException -> 0x010c }
        r4 = r2;
        goto L_0x00ca;
    L_0x011b:
        r5 = r5 + 1;
        r7 = 1;
        if (r5 != r7) goto L_0x0130;
    L_0x0120:
        r0 = r22;
        r3 = r0.aja;	 Catch:{ EOFException -> 0x010c }
        com.google.android.exoplayer2.c.i.a(r2, r3);	 Catch:{ EOFException -> 0x010c }
    L_0x0127:
        r3 = r6 + -4;
        r0 = r23;
        r0.cl(r3);	 Catch:{ EOFException -> 0x010c }
        r3 = r2;
        goto L_0x00ca;
    L_0x0130:
        r2 = 4;
        if (r5 == r2) goto L_0x0135;
    L_0x0133:
        r2 = r3;
        goto L_0x0127;
    L_0x0135:
        r23.jS();	 Catch:{ EOFException -> 0x010c }
        r0 = r22;
        r0.aje = r3;	 Catch:{ EOFException -> 0x010c }
    L_0x013c:
        r0 = r22;
        r2 = r0.ajf;
        if (r2 != 0) goto L_0x0280;
    L_0x0142:
        r13 = new com.google.android.exoplayer2.i.j;
        r0 = r22;
        r2 = r0.aja;
        r2 = r2.aft;
        r13.<init>(r2);
        r2 = r13.data;
        r3 = 0;
        r0 = r22;
        r4 = r0.aja;
        r4 = r4.aft;
        r0 = r23;
        r0.b(r2, r3, r4);
        r0 = r22;
        r2 = r0.aja;
        r2 = r2.version;
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x02a2;
    L_0x0165:
        r0 = r22;
        r2 = r0.aja;
        r2 = r2.channels;
        r3 = 1;
        if (r2 == r3) goto L_0x029d;
    L_0x016e:
        r2 = 36;
        r14 = r2;
    L_0x0171:
        r2 = r13.limit;
        r3 = r14 + 4;
        if (r2 < r3) goto L_0x02b5;
    L_0x0177:
        r13.setPosition(r14);
        r2 = r13.readInt();
        r3 = aiV;
        if (r2 == r3) goto L_0x0186;
    L_0x0182:
        r3 = aiW;
        if (r2 != r3) goto L_0x02b5;
    L_0x0186:
        r15 = r2;
    L_0x0187:
        r2 = aiV;
        if (r15 == r2) goto L_0x018f;
    L_0x018b:
        r2 = aiW;
        if (r15 != r2) goto L_0x0319;
    L_0x018f:
        r0 = r22;
        r0 = r0.aja;
        r16 = r0;
        r2 = r23.getPosition();
        r8 = r23.getLength();
        r0 = r16;
        r4 = r0.aiQ;
        r0 = r16;
        r6 = r0.sampleRate;
        r0 = r16;
        r5 = r0.aft;
        r10 = (long) r5;
        r18 = r2 + r10;
        r10 = r13.readInt();
        r2 = r10 & 1;
        r3 = 1;
        if (r2 != r3) goto L_0x01bb;
    L_0x01b5:
        r2 = r13.mh();
        if (r2 != 0) goto L_0x02d1;
    L_0x01bb:
        r3 = 0;
        r2 = r3;
    L_0x01bd:
        if (r2 == 0) goto L_0x0207;
    L_0x01bf:
        r0 = r22;
        r3 = r0.ajb;
        r4 = r3.aei;
        r5 = -1;
        if (r4 == r5) goto L_0x0316;
    L_0x01c8:
        r3 = r3.aej;
        r4 = -1;
        if (r3 == r4) goto L_0x0316;
    L_0x01cd:
        r3 = 1;
    L_0x01ce:
        if (r3 != 0) goto L_0x0207;
    L_0x01d0:
        r23.jS();
        r3 = r14 + 141;
        r0 = r23;
        r0.cl(r3);
        r0 = r22;
        r3 = r0.aiZ;
        r3 = r3.data;
        r4 = 0;
        r5 = 3;
        r0 = r23;
        r0.b(r3, r4, r5);
        r0 = r22;
        r3 = r0.aiZ;
        r4 = 0;
        r3.setPosition(r4);
        r0 = r22;
        r3 = r0.ajb;
        r0 = r22;
        r4 = r0.aiZ;
        r4 = r4.mf();
        r5 = r4 >> 12;
        r4 = r4 & 4095;
        if (r5 > 0) goto L_0x0203;
    L_0x0201:
        if (r4 <= 0) goto L_0x0207;
    L_0x0203:
        r3.aei = r5;
        r3.aej = r4;
    L_0x0207:
        r0 = r22;
        r3 = r0.aja;
        r3 = r3.aft;
        r0 = r23;
        r0.ck(r3);
        if (r2 == 0) goto L_0x0222;
    L_0x0214:
        r3 = r2.jR();
        if (r3 != 0) goto L_0x0222;
    L_0x021a:
        r3 = aiW;
        if (r15 != r3) goto L_0x0222;
    L_0x021e:
        r2 = r22.b(r23);
    L_0x0222:
        r0 = r22;
        r0.ajf = r2;
        r0 = r22;
        r2 = r0.ajf;
        if (r2 == 0) goto L_0x023e;
    L_0x022c:
        r0 = r22;
        r2 = r0.ajf;
        r2 = r2.jR();
        if (r2 != 0) goto L_0x0246;
    L_0x0236:
        r0 = r22;
        r2 = r0.flags;
        r2 = r2 & 1;
        if (r2 == 0) goto L_0x0246;
    L_0x023e:
        r2 = r22.b(r23);
        r0 = r22;
        r0.ajf = r2;
    L_0x0246:
        r0 = r22;
        r15 = r0.ajd;
        r2 = 0;
        r0 = r22;
        r3 = r0.aja;
        r3 = r3.mimeType;
        r4 = -1;
        r5 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = r22;
        r6 = r0.aja;
        r6 = r6.channels;
        r0 = r22;
        r7 = r0.aja;
        r7 = r7.sampleRate;
        r8 = -1;
        r0 = r22;
        r9 = r0.ajb;
        r9 = r9.aei;
        r0 = r22;
        r10 = r0.ajb;
        r10 = r10.aej;
        r11 = 0;
        r12 = 0;
        r13 = 0;
        r0 = r22;
        r14 = r0.flags;
        r14 = r14 & 2;
        if (r14 == 0) goto L_0x03c7;
    L_0x0278:
        r14 = 0;
    L_0x0279:
        r2 = com.google.android.exoplayer2.Format.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14);
        r15.f(r2);
    L_0x0280:
        r0 = r22;
        r2 = r0.aji;
        if (r2 != 0) goto L_0x0451;
    L_0x0286:
        r23.jS();
        r0 = r22;
        r2 = r0.aiZ;
        r2 = r2.data;
        r3 = 0;
        r4 = 4;
        r5 = 1;
        r0 = r23;
        r2 = r0.b(r2, r3, r4, r5);
        if (r2 != 0) goto L_0x03cd;
    L_0x029a:
        r2 = -1;
        goto L_0x010e;
    L_0x029d:
        r2 = 21;
        r14 = r2;
        goto L_0x0171;
    L_0x02a2:
        r0 = r22;
        r2 = r0.aja;
        r2 = r2.channels;
        r3 = 1;
        if (r2 == r3) goto L_0x02b0;
    L_0x02ab:
        r2 = 21;
        r14 = r2;
        goto L_0x0171;
    L_0x02b0:
        r2 = 13;
        r14 = r2;
        goto L_0x0171;
    L_0x02b5:
        r2 = r13.limit;
        r3 = 40;
        if (r2 < r3) goto L_0x02cd;
    L_0x02bb:
        r2 = 36;
        r13.setPosition(r2);
        r2 = r13.readInt();
        r3 = aiX;
        if (r2 != r3) goto L_0x02cd;
    L_0x02c8:
        r2 = aiX;
        r15 = r2;
        goto L_0x0187;
    L_0x02cd:
        r2 = 0;
        r15 = r2;
        goto L_0x0187;
    L_0x02d1:
        r2 = (long) r2;
        r4 = (long) r4;
        r20 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r4 * r20;
        r6 = (long) r6;
        r6 = com.google.android.exoplayer2.i.t.a(r2, r4, r6);
        r2 = r10 & 6;
        r3 = 6;
        if (r2 == r3) goto L_0x02ec;
    L_0x02e2:
        r3 = new com.google.android.exoplayer2.c.a.d;
        r4 = r18;
        r3.<init>(r4, r6, r8);
        r2 = r3;
        goto L_0x01bd;
    L_0x02ec:
        r2 = r13.mh();
        r11 = (long) r2;
        r2 = 1;
        r13.da(r2);
        r2 = 99;
        r10 = new long[r2];
        r2 = 0;
    L_0x02fa:
        r3 = 99;
        if (r2 >= r3) goto L_0x0308;
    L_0x02fe:
        r3 = r13.readUnsignedByte();
        r4 = (long) r3;
        r10[r2] = r4;
        r2 = r2 + 1;
        goto L_0x02fa;
    L_0x0308:
        r3 = new com.google.android.exoplayer2.c.a.d;
        r0 = r16;
        r13 = r0.aft;
        r4 = r18;
        r3.<init>(r4, r6, r8, r10, r11, r13);
        r2 = r3;
        goto L_0x01bd;
    L_0x0316:
        r3 = 0;
        goto L_0x01ce;
    L_0x0319:
        r2 = aiX;
        if (r15 != r2) goto L_0x03c1;
    L_0x031d:
        r0 = r22;
        r8 = r0.aja;
        r10 = r23.getPosition();
        r14 = r23.getLength();
        r2 = 10;
        r13.da(r2);
        r2 = r13.readInt();
        if (r2 > 0) goto L_0x0342;
    L_0x0334:
        r2 = 0;
    L_0x0335:
        r0 = r22;
        r3 = r0.aja;
        r3 = r3.aft;
        r0 = r23;
        r0.ck(r3);
        goto L_0x0222;
    L_0x0342:
        r6 = r8.sampleRate;
        r2 = (long) r2;
        r16 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = 32000; // 0x7d00 float:4.4842E-41 double:1.581E-319;
        if (r6 < r4) goto L_0x0384;
    L_0x034c:
        r4 = 1152; // 0x480 float:1.614E-42 double:5.69E-321;
    L_0x034e:
        r4 = (long) r4;
        r4 = r4 * r16;
        r6 = (long) r6;
        r16 = com.google.android.exoplayer2.i.t.a(r2, r4, r6);
        r9 = r13.readUnsignedShort();
        r12 = r13.readUnsignedShort();
        r18 = r13.readUnsignedShort();
        r2 = 2;
        r13.da(r2);
        r2 = r8.aft;
        r2 = (long) r2;
        r4 = r10 + r2;
        r2 = r9 + 1;
        r8 = new long[r2];
        r2 = r9 + 1;
        r10 = new long[r2];
        r2 = 0;
        r6 = 0;
        r8[r2] = r6;
        r2 = 0;
        r10[r2] = r4;
        r2 = 1;
    L_0x037c:
        r3 = r8.length;
        if (r2 >= r3) goto L_0x03b8;
    L_0x037f:
        switch(r18) {
            case 1: goto L_0x0387;
            case 2: goto L_0x03a4;
            case 3: goto L_0x03a9;
            case 4: goto L_0x03ae;
            default: goto L_0x0382;
        };
    L_0x0382:
        r2 = 0;
        goto L_0x0335;
    L_0x0384:
        r4 = 576; // 0x240 float:8.07E-43 double:2.846E-321;
        goto L_0x034e;
    L_0x0387:
        r3 = r13.readUnsignedByte();
    L_0x038b:
        r3 = r3 * r12;
        r6 = (long) r3;
        r4 = r4 + r6;
        r6 = (long) r2;
        r6 = r6 * r16;
        r0 = (long) r9;
        r20 = r0;
        r6 = r6 / r20;
        r8[r2] = r6;
        r6 = -1;
        r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1));
        if (r3 != 0) goto L_0x03b3;
    L_0x039e:
        r6 = r4;
    L_0x039f:
        r10[r2] = r6;
        r2 = r2 + 1;
        goto L_0x037c;
    L_0x03a4:
        r3 = r13.readUnsignedShort();
        goto L_0x038b;
    L_0x03a9:
        r3 = r13.mf();
        goto L_0x038b;
    L_0x03ae:
        r3 = r13.mh();
        goto L_0x038b;
    L_0x03b3:
        r6 = java.lang.Math.min(r14, r4);
        goto L_0x039f;
    L_0x03b8:
        r2 = new com.google.android.exoplayer2.c.a.c;
        r0 = r16;
        r2.<init>(r8, r10, r0);
        goto L_0x0335;
    L_0x03c1:
        r2 = 0;
        r23.jS();
        goto L_0x0222;
    L_0x03c7:
        r0 = r22;
        r14 = r0.adU;
        goto L_0x0279;
    L_0x03cd:
        r0 = r22;
        r2 = r0.aiZ;
        r3 = 0;
        r2.setPosition(r3);
        r0 = r22;
        r2 = r0.aiZ;
        r2 = r2.readInt();
        r0 = r22;
        r3 = r0.aje;
        r4 = (long) r3;
        r3 = e(r2, r4);
        if (r3 == 0) goto L_0x03ef;
    L_0x03e8:
        r3 = com.google.android.exoplayer2.c.i.cq(r2);
        r4 = -1;
        if (r3 != r4) goto L_0x03fd;
    L_0x03ef:
        r2 = 1;
        r0 = r23;
        r0.ck(r2);
        r2 = 0;
        r0 = r22;
        r0.aje = r2;
        r2 = 0;
        goto L_0x010e;
    L_0x03fd:
        r0 = r22;
        r3 = r0.aja;
        com.google.android.exoplayer2.c.i.a(r2, r3);
        r0 = r22;
        r2 = r0.ajg;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0447;
    L_0x0411:
        r0 = r22;
        r2 = r0.ajf;
        r4 = r23.getPosition();
        r2 = r2.C(r4);
        r0 = r22;
        r0.ajg = r2;
        r0 = r22;
        r2 = r0.aiY;
        r4 = -9223372036854775807; // 0x8000000000000001 float:1.4E-45 double:-4.9E-324;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0447;
    L_0x042e:
        r0 = r22;
        r2 = r0.ajf;
        r4 = 0;
        r2 = r2.C(r4);
        r0 = r22;
        r4 = r0.ajg;
        r0 = r22;
        r6 = r0.aiY;
        r2 = r6 - r2;
        r2 = r2 + r4;
        r0 = r22;
        r0.ajg = r2;
    L_0x0447:
        r0 = r22;
        r2 = r0.aja;
        r2 = r2.aft;
        r0 = r22;
        r0.aji = r2;
    L_0x0451:
        r0 = r22;
        r2 = r0.ajd;
        r0 = r22;
        r3 = r0.aji;
        r4 = 1;
        r0 = r23;
        r2 = r2.a(r0, r3, r4);
        r3 = -1;
        if (r2 != r3) goto L_0x0466;
    L_0x0463:
        r2 = -1;
        goto L_0x010e;
    L_0x0466:
        r0 = r22;
        r3 = r0.aji;
        r2 = r3 - r2;
        r0 = r22;
        r0.aji = r2;
        r0 = r22;
        r2 = r0.aji;
        if (r2 <= 0) goto L_0x0479;
    L_0x0476:
        r2 = 0;
        goto L_0x010e;
    L_0x0479:
        r0 = r22;
        r2 = r0.ajg;
        r0 = r22;
        r4 = r0.ajh;
        r6 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r4 = r4 * r6;
        r0 = r22;
        r6 = r0.aja;
        r6 = r6.sampleRate;
        r6 = (long) r6;
        r4 = r4 / r6;
        r4 = r4 + r2;
        r0 = r22;
        r3 = r0.ajd;
        r6 = 1;
        r0 = r22;
        r2 = r0.aja;
        r7 = r2.aft;
        r8 = 0;
        r9 = 0;
        r3.a(r4, r6, r7, r8, r9);
        r0 = r22;
        r2 = r0.ajh;
        r0 = r22;
        r4 = r0.aja;
        r4 = r4.aiQ;
        r4 = (long) r4;
        r2 = r2 + r4;
        r0 = r22;
        r0.ajh = r2;
        r2 = 0;
        r0 = r22;
        r0.aji = r2;
        r2 = 0;
        goto L_0x010e;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.c.a.b.a(com.google.android.exoplayer2.c.e):int");
    }

    private a b(e eVar) {
        eVar.b(this.aiZ.data, 0, 4);
        this.aiZ.setPosition(0);
        i.a(this.aiZ.readInt(), this.aja);
        return new a(eVar.getPosition(), this.aja.bitrate, eVar.getLength());
    }

    private static boolean e(int i, long j) {
        return ((long) (-128000 & i)) == (-128000 & j);
    }
}
