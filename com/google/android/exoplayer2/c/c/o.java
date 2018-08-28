package com.google.android.exoplayer2.c.c;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.q;

public final class o implements u {
    private long aih;
    private q alB;
    private int amO;
    private final h aoB;
    private final i aoC = new i(new byte[10]);
    private boolean aoD;
    private boolean aoE;
    private boolean aoF;
    private int aoG;
    private int aoH;
    private boolean aoI;
    private int state = 0;

    public o(h hVar) {
        this.aoB = hVar;
    }

    public final void a(q qVar, f fVar, u$d u_d) {
        this.alB = qVar;
        this.aoB.a(fVar, u_d);
    }

    public final void jX() {
        this.state = 0;
        this.amO = 0;
        this.aoF = false;
        this.aoB.jX();
    }

    public final void a(j jVar, boolean z) {
        if (z) {
            switch (this.state) {
                case 3:
                    if (this.aoH != -1) {
                        new StringBuilder("Unexpected start indicator: expected ").append(this.aoH).append(" more bytes");
                    }
                    this.aoB.jY();
                    break;
            }
            setState(1);
        }
        while (jVar.me() > 0) {
            int i;
            switch (this.state) {
                case 0:
                    jVar.da(jVar.me());
                    break;
                case 1:
                    if (!a(jVar, this.aoC.data, 9)) {
                        break;
                    }
                    this.aoC.setPosition(0);
                    if (this.aoC.cY(24) != 1) {
                        this.aoH = -1;
                        i = 0;
                    } else {
                        this.aoC.cX(8);
                        i = this.aoC.cY(16);
                        this.aoC.cX(5);
                        this.aoI = this.aoC.mb();
                        this.aoC.cX(2);
                        this.aoD = this.aoC.mb();
                        this.aoE = this.aoC.mb();
                        this.aoC.cX(6);
                        this.aoG = this.aoC.cY(8);
                        if (i == 0) {
                            this.aoH = -1;
                        } else {
                            this.aoH = ((i + 6) - 9) - this.aoG;
                        }
                        boolean i2 = true;
                    }
                    setState(i2 != 0 ? 2 : 0);
                    break;
                case 2:
                    if (a(jVar, this.aoC.data, Math.min(10, this.aoG)) && a(jVar, null, this.aoG)) {
                        this.aoC.setPosition(0);
                        this.aih = -9223372036854775807L;
                        if (this.aoD) {
                            this.aoC.cX(4);
                            long cY = ((long) this.aoC.cY(3)) << 30;
                            this.aoC.cX(1);
                            cY |= (long) (this.aoC.cY(15) << 15);
                            this.aoC.cX(1);
                            cY |= (long) this.aoC.cY(15);
                            this.aoC.cX(1);
                            if (!this.aoF && this.aoE) {
                                this.aoC.cX(4);
                                long cY2 = ((long) this.aoC.cY(3)) << 30;
                                this.aoC.cX(1);
                                cY2 |= (long) (this.aoC.cY(15) << 15);
                                this.aoC.cX(1);
                                cY2 |= (long) this.aoC.cY(15);
                                this.aoC.cX(1);
                                this.alB.T(cY2);
                                this.aoF = true;
                            }
                            this.aih = this.alB.T(cY);
                        }
                        this.aoB.d(this.aih, this.aoI);
                        setState(3);
                        break;
                    }
                case 3:
                    int i3;
                    i2 = jVar.me();
                    if (this.aoH == -1) {
                        i3 = 0;
                    } else {
                        i3 = i2 - this.aoH;
                    }
                    if (i3 > 0) {
                        i2 -= i3;
                        jVar.cZ(jVar.position + i2);
                    }
                    this.aoB.b(jVar);
                    if (this.aoH == -1) {
                        break;
                    }
                    this.aoH -= i2;
                    if (this.aoH != 0) {
                        break;
                    }
                    this.aoB.jY();
                    setState(1);
                    break;
                default:
                    break;
            }
        }
    }

    private void setState(int i) {
        this.state = i;
        this.amO = 0;
    }

    private boolean a(j jVar, byte[] bArr, int i) {
        int min = Math.min(jVar.me(), i - this.amO);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            jVar.da(min);
        } else {
            jVar.readBytes(bArr, this.amO, min);
        }
        this.amO = min + this.amO;
        if (this.amO != i) {
            return false;
        }
        return true;
    }
}
