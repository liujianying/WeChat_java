package com.google.android.exoplayer2.c.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.h;
import com.google.android.exoplayer2.i.j;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.Collections;

public final class i implements h {
    private static final double[] anm = new double[]{23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private k alX;
    private String amX;
    private boolean anb;
    private long anl;
    private long ann;
    private final boolean[] ano = new boolean[4];
    private final a anp = new a();
    private long anq;
    private boolean anr;
    private long ans;
    private long ant;
    private boolean anu;
    private boolean anv;

    public final void jX() {
        h.b(this.ano);
        a aVar = this.anp;
        aVar.anx = false;
        aVar.length = 0;
        aVar.any = 0;
        this.anq = 0;
        this.anr = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.kf();
        this.amX = dVar.kh();
        this.alX = fVar.cp(dVar.kg());
    }

    public final void d(long j, boolean z) {
        this.ans = j;
    }

    public final void b(j jVar) {
        int i = jVar.position;
        int i2 = jVar.limit;
        byte[] bArr = jVar.data;
        this.anq += (long) jVar.me();
        this.alX.a(jVar, jVar.me());
        while (true) {
            int a = h.a(bArr, i, i2, this.ano);
            if (a != i2) {
                long j;
                int i3 = jVar.data[a + 3] & WebView.NORMAL_MODE_ALPHA;
                if (!this.anb) {
                    Object obj;
                    int i4 = a - i;
                    if (i4 > 0) {
                        this.anp.d(bArr, i, a);
                    }
                    i = i4 < 0 ? -i4 : 0;
                    a aVar = this.anp;
                    if (aVar.anx) {
                        aVar.length -= i;
                        if (aVar.any == 0 && i3 == 181) {
                            aVar.any = aVar.length;
                        } else {
                            aVar.anx = false;
                            obj = 1;
                            if (obj != null) {
                                a aVar2 = this.anp;
                                String str = this.amX;
                                Object copyOf = Arrays.copyOf(aVar2.data, aVar2.length);
                                int i5 = copyOf[5] & WebView.NORMAL_MODE_ALPHA;
                                int i6 = (i5 >> 4) | ((copyOf[4] & WebView.NORMAL_MODE_ALPHA) << 4);
                                i5 = ((i5 & 15) << 8) | (copyOf[6] & WebView.NORMAL_MODE_ALPHA);
                                float f = 1.0f;
                                switch ((copyOf[7] & 240) >> 4) {
                                    case 2:
                                        f = ((float) (i5 * 4)) / ((float) (i6 * 3));
                                        break;
                                    case 3:
                                        f = ((float) (i5 * 16)) / ((float) (i6 * 9));
                                        break;
                                    case 4:
                                        f = ((float) (i5 * 121)) / ((float) (i6 * 100));
                                        break;
                                }
                                Format a2 = Format.a(str, "video/mpeg2", i6, i5, Collections.singletonList(copyOf), f);
                                j = 0;
                                i5 = (copyOf[7] & 15) - 1;
                                if (i5 >= 0 && i5 < anm.length) {
                                    double d = anm[i5];
                                    i5 = aVar2.any;
                                    int i7 = (copyOf[i5 + 9] & 96) >> 5;
                                    i5 = copyOf[i5 + 9] & 31;
                                    if (i7 != i5) {
                                        d *= (((double) i7) + 1.0d) / ((double) (i5 + 1));
                                    }
                                    j = (long) (1000000.0d / d);
                                }
                                Pair create = Pair.create(a2, Long.valueOf(j));
                                this.alX.f((Format) create.first);
                                this.ann = ((Long) create.second).longValue();
                                this.anb = true;
                            }
                        }
                    } else if (i3 == 179) {
                        aVar.anx = true;
                    }
                    aVar.d(a.anw, 0, a.anw.length);
                    obj = null;
                    if (obj != null) {
                        a aVar22 = this.anp;
                        String str2 = this.amX;
                        Object copyOf2 = Arrays.copyOf(aVar22.data, aVar22.length);
                        int i52 = copyOf2[5] & WebView.NORMAL_MODE_ALPHA;
                        int i62 = (i52 >> 4) | ((copyOf2[4] & WebView.NORMAL_MODE_ALPHA) << 4);
                        i52 = ((i52 & 15) << 8) | (copyOf2[6] & WebView.NORMAL_MODE_ALPHA);
                        float f2 = 1.0f;
                        switch ((copyOf2[7] & 240) >> 4) {
                            case 2:
                                f2 = ((float) (i52 * 4)) / ((float) (i62 * 3));
                                break;
                            case 3:
                                f2 = ((float) (i52 * 16)) / ((float) (i62 * 9));
                                break;
                            case 4:
                                f2 = ((float) (i52 * 121)) / ((float) (i62 * 100));
                                break;
                        }
                        Format a22 = Format.a(str2, "video/mpeg2", i62, i52, Collections.singletonList(copyOf2), f2);
                        j = 0;
                        i52 = (copyOf2[7] & 15) - 1;
                        if (i52 >= 0 && i52 < anm.length) {
                            double d2 = anm[i52];
                            i52 = aVar22.any;
                            int i72 = (copyOf2[i52 + 9] & 96) >> 5;
                            i52 = copyOf2[i52 + 9] & 31;
                            if (i72 != i52) {
                                d2 *= (((double) i72) + 1.0d) / ((double) (i52 + 1));
                            }
                            j = (long) (1000000.0d / d2);
                        }
                        Pair create2 = Pair.create(a22, Long.valueOf(j));
                        this.alX.f((Format) create2.first);
                        this.ann = ((Long) create2.second).longValue();
                        this.anb = true;
                    }
                }
                if (i3 == 0 || i3 == 179) {
                    int i8 = i2 - a;
                    if (this.anr && this.anv && this.anb) {
                        this.alX.a(this.anl, this.anu ? 1 : 0, ((int) (this.anq - this.ant)) - i8, i8, null);
                    }
                    if (!this.anr || this.anv) {
                        this.ant = this.anq - ((long) i8);
                        j = this.ans != -9223372036854775807L ? this.ans : this.anr ? this.anl + this.ann : 0;
                        this.anl = j;
                        this.anu = false;
                        this.ans = -9223372036854775807L;
                        this.anr = true;
                    }
                    this.anv = i3 == 0;
                } else if (i3 == 184) {
                    this.anu = true;
                }
                i = a + 3;
            } else if (!this.anb) {
                this.anp.d(bArr, i, i2);
                return;
            } else {
                return;
            }
        }
    }

    public final void jY() {
    }
}
