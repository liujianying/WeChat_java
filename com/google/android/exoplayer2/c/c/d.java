package com.google.android.exoplayer2.c.c;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ab;
import com.tencent.smtt.sdk.WebView;
import java.util.Arrays;
import java.util.Collections;

public final class d implements h {
    private static final byte[] amT = new byte[]{(byte) 73, (byte) 68, (byte) 51};
    private final String aem;
    long aih;
    private k alX;
    private int amO;
    private long amQ;
    private final boolean amU;
    private final i amV;
    private final j amW;
    private String amX;
    private k amY;
    private int amZ;
    private boolean ana;
    private boolean anb;
    private k anc;
    private long ane;
    private int sampleSize;
    private int state;

    public d() {
        this(true, null);
    }

    public d(boolean z, String str) {
        this.amV = new i(new byte[7]);
        this.amW = new j(Arrays.copyOf(amT, 10));
        jZ();
        this.amU = z;
        this.aem = str;
    }

    public final void jX() {
        jZ();
    }

    public final void a(f fVar, com.google.android.exoplayer2.c.c.u.d dVar) {
        dVar.kf();
        this.amX = dVar.kh();
        this.alX = fVar.cp(dVar.kg());
        if (this.amU) {
            dVar.kf();
            this.amY = fVar.cp(dVar.kg());
            this.amY.f(Format.h(dVar.kh(), "application/id3"));
            return;
        }
        this.amY = new c();
    }

    public final void d(long j, boolean z) {
        this.aih = j;
    }

    public final void b(j jVar) {
        while (jVar.me() > 0) {
            int i;
            int i2;
            switch (this.state) {
                case 0:
                    byte[] bArr = jVar.data;
                    i = jVar.position;
                    int i3 = jVar.limit;
                    i2 = i;
                    while (i2 < i3) {
                        i = i2 + 1;
                        i2 = bArr[i2] & WebView.NORMAL_MODE_ALPHA;
                        if (this.amZ == WXMediaMessage.TITLE_LENGTH_LIMIT && i2 >= 240 && i2 != WebView.NORMAL_MODE_ALPHA) {
                            this.ana = (i2 & 1) == 0;
                            this.state = 2;
                            this.amO = 0;
                            jVar.setPosition(i);
                            break;
                        }
                        switch (i2 | this.amZ) {
                            case 329:
                                this.amZ = 768;
                                i2 = i;
                                break;
                            case 511:
                                this.amZ = WXMediaMessage.TITLE_LENGTH_LIMIT;
                                i2 = i;
                                break;
                            case 836:
                                this.amZ = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                                i2 = i;
                                break;
                            case 1075:
                                this.state = 1;
                                this.amO = amT.length;
                                this.sampleSize = 0;
                                this.amW.setPosition(0);
                                break;
                            default:
                                if (this.amZ == ab.CTRL_BYTE) {
                                    i2 = i;
                                    break;
                                }
                                this.amZ = ab.CTRL_BYTE;
                                i2 = i - 1;
                                break;
                        }
                    }
                    i = i2;
                    jVar.setPosition(i);
                    break;
                case 1:
                    if (!a(jVar, this.amW.data, 10)) {
                        break;
                    }
                    this.amY.a(this.amW, 10);
                    this.amW.setPosition(6);
                    a(this.amY, 0, 10, this.amW.mg() + 10);
                    break;
                case 2:
                    if (!a(jVar, this.amV.data, this.ana ? 7 : 5)) {
                        break;
                    }
                    this.amV.setPosition(0);
                    if (this.anb) {
                        this.amV.cX(10);
                    } else {
                        i2 = this.amV.cY(2) + 1;
                        if (i2 != 2) {
                            new StringBuilder("Detected audio object type: ").append(i2).append(", but assuming AAC LC.");
                            i2 = 2;
                        }
                        i = this.amV.cY(4);
                        this.amV.cX(1);
                        Object t = com.google.android.exoplayer2.i.c.t(i2, i, this.amV.cY(3));
                        Pair i4 = com.google.android.exoplayer2.i.c.i(t);
                        Format a = Format.a(this.amX, "audio/mp4a-latm", -1, -1, ((Integer) i4.second).intValue(), ((Integer) i4.first).intValue(), Collections.singletonList(t), null, this.aem);
                        this.amQ = 1024000000 / ((long) a.sampleRate);
                        this.alX.f(a);
                        this.anb = true;
                    }
                    this.amV.cX(4);
                    int cY = (this.amV.cY(13) - 2) - 5;
                    if (this.ana) {
                        cY -= 2;
                    }
                    a(this.alX, this.amQ, 0, cY);
                    break;
                case 3:
                    i2 = Math.min(jVar.me(), this.sampleSize - this.amO);
                    this.anc.a(jVar, i2);
                    this.amO = i2 + this.amO;
                    if (this.amO != this.sampleSize) {
                        break;
                    }
                    this.anc.a(this.aih, 1, this.sampleSize, 0, null);
                    this.aih += this.ane;
                    jZ();
                    break;
                default:
                    break;
            }
        }
    }

    public final void jY() {
    }

    private boolean a(j jVar, byte[] bArr, int i) {
        int min = Math.min(jVar.me(), i - this.amO);
        jVar.readBytes(bArr, this.amO, min);
        this.amO = min + this.amO;
        return this.amO == i;
    }

    private void jZ() {
        this.state = 0;
        this.amO = 0;
        this.amZ = ab.CTRL_BYTE;
    }

    private void a(k kVar, long j, int i, int i2) {
        this.state = 3;
        this.amO = i;
        this.anc = kVar;
        this.ane = j;
        this.sampleSize = i2;
    }
}
