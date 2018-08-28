package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.c.u.d;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.i;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.i.j;
import com.tencent.map.lib.gl.model.GLIcon;

public final class m implements h {
    private final String aem;
    private int aft;
    private long aih;
    private k alX;
    private String amX;
    private boolean anb;
    private long ann;
    private final j aot;
    private final i aou;
    private int aov;
    private boolean aow;
    private int state;

    public m() {
        this(null);
    }

    public m(String str) {
        this.state = 0;
        this.aot = new j(4);
        this.aot.data[0] = (byte) -1;
        this.aou = new i();
        this.aem = str;
    }

    public final void jX() {
        this.state = 0;
        this.aov = 0;
        this.aow = false;
    }

    public final void a(f fVar, d dVar) {
        dVar.kf();
        this.amX = dVar.kh();
        this.alX = fVar.cp(dVar.kg());
    }

    public final void d(long j, boolean z) {
        this.aih = j;
    }

    public final void b(j jVar) {
        while (jVar.me() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    byte[] bArr = jVar.data;
                    i = jVar.position;
                    int i2 = jVar.limit;
                    for (int i3 = i; i3 < i2; i3++) {
                        boolean z = (bArr[i3] & 255) == 255;
                        boolean z2 = this.aow && (bArr[i3] & 224) == 224;
                        this.aow = z;
                        if (z2) {
                            jVar.setPosition(i3 + 1);
                            this.aow = false;
                            this.aot.data[1] = bArr[i3];
                            this.aov = 2;
                            this.state = 1;
                            break;
                        }
                    }
                    jVar.setPosition(i2);
                    break;
                case 1:
                    i = Math.min(jVar.me(), 4 - this.aov);
                    jVar.readBytes(this.aot.data, this.aov, i);
                    this.aov = i + this.aov;
                    if (this.aov < 4) {
                        break;
                    }
                    this.aot.setPosition(0);
                    if (!i.a(this.aot.readInt(), this.aou)) {
                        this.aov = 0;
                        this.state = 1;
                        break;
                    }
                    this.aft = this.aou.aft;
                    if (!this.anb) {
                        this.ann = (1000000 * ((long) this.aou.aiQ)) / ((long) this.aou.sampleRate);
                        this.alX.f(Format.a(this.amX, this.aou.mimeType, -1, GLIcon.LEFT, this.aou.channels, this.aou.sampleRate, null, null, this.aem));
                        this.anb = true;
                    }
                    this.aot.setPosition(0);
                    this.alX.a(this.aot, 4);
                    this.state = 2;
                    break;
                case 2:
                    i = Math.min(jVar.me(), this.aft - this.aov);
                    this.alX.a(jVar, i);
                    this.aov = i + this.aov;
                    if (this.aov < this.aft) {
                        break;
                    }
                    this.alX.a(this.aih, 1, this.aft, 0, null);
                    this.aih += this.ann;
                    this.aov = 0;
                    this.state = 0;
                    break;
                default:
                    break;
            }
        }
    }

    public final void jY() {
    }
}
