package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;

public final class q implements u {
    private int amO;
    private final p aoJ;
    private final j aoK = new j(32);
    private int aoL;
    private boolean aoM;
    private boolean aoN;

    public q(p pVar) {
        this.aoJ = pVar;
    }

    public final void a(com.google.android.exoplayer2.i.q qVar, f fVar, u$d u_d) {
        this.aoJ.a(qVar, fVar, u_d);
        this.aoN = true;
    }

    public final void jX() {
        this.aoN = true;
    }

    public final void a(j jVar, boolean z) {
        int readUnsignedByte;
        if (z) {
            readUnsignedByte = jVar.readUnsignedByte() + jVar.position;
        } else {
            readUnsignedByte = -1;
        }
        if (this.aoN) {
            if (z) {
                this.aoN = false;
                jVar.setPosition(readUnsignedByte);
                this.amO = 0;
            } else {
                return;
            }
        }
        while (jVar.me() > 0) {
            if (this.amO < 3) {
                if (this.amO == 0) {
                    readUnsignedByte = jVar.readUnsignedByte();
                    jVar.setPosition(jVar.position - 1);
                    if (readUnsignedByte == 255) {
                        this.aoN = true;
                        return;
                    }
                }
                readUnsignedByte = Math.min(jVar.me(), 3 - this.amO);
                jVar.readBytes(this.aoK.data, this.amO, readUnsignedByte);
                this.amO = readUnsignedByte + this.amO;
                if (this.amO == 3) {
                    this.aoK.reset(3);
                    this.aoK.da(1);
                    int readUnsignedByte2 = this.aoK.readUnsignedByte();
                    int readUnsignedByte3 = this.aoK.readUnsignedByte();
                    this.aoM = (readUnsignedByte2 & 128) != 0;
                    this.aoL = (((readUnsignedByte2 & 15) << 8) | readUnsignedByte3) + 3;
                    if (this.aoK.capacity() < this.aoL) {
                        Object obj = this.aoK.data;
                        this.aoK.reset(Math.min(4098, Math.max(this.aoL, obj.length * 2)));
                        System.arraycopy(obj, 0, this.aoK.data, 0, 3);
                    }
                }
            } else {
                readUnsignedByte = Math.min(jVar.me(), this.aoL - this.amO);
                jVar.readBytes(this.aoK.data, this.amO, readUnsignedByte);
                this.amO = readUnsignedByte + this.amO;
                if (this.amO != this.aoL) {
                    continue;
                } else {
                    if (!this.aoM) {
                        this.aoK.reset(this.aoL);
                    } else if (t.l(this.aoK.data, this.aoL, -1) != 0) {
                        this.aoN = true;
                        return;
                    } else {
                        this.aoK.reset(this.aoL - 4);
                    }
                    this.aoJ.b(this.aoK);
                    this.amO = 0;
                }
            }
        }
    }
}
