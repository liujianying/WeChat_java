package com.google.a.a;

public final class a {
    private int bfG;
    private int bfH;
    private int bfI;
    private int bfJ;
    private int bfK = Integer.MAX_VALUE;
    private int bfL;
    private int bfM = 64;
    private int bfN = 67108864;
    private final byte[] buffer;
    private int bufferSize;

    public final int rX() {
        if ((this.bfI == this.bufferSize ? 1 : 0) != 0) {
            this.bfJ = 0;
            return 0;
        }
        this.bfJ = rY();
        if (this.bfJ != 0) {
            return this.bfJ;
        }
        throw d.sg();
    }

    public final void dT(int i) {
        if (this.bfJ != i) {
            throw d.sh();
        }
    }

    public final boolean dU(int i) {
        switch (g.ef(i)) {
            case 0:
                rY();
                return true;
            case 1:
                sc();
                sc();
                sc();
                sc();
                sc();
                sc();
                sc();
                sc();
                return true;
            case 2:
                dZ(rY());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                sc();
                sc();
                sc();
                sc();
                return true;
            default:
                throw d.si();
        }
        int rX;
        do {
            rX = rX();
            if (rX != 0) {
            }
            dT(g.aJ(g.eg(i), 4));
            return true;
        } while (dU(rX));
        dT(g.aJ(g.eg(i), 4));
        return true;
    }

    public final String readString() {
        int rY = rY();
        if (rY > this.bufferSize - this.bfI || rY <= 0) {
            return new String(dY(rY), "UTF-8");
        }
        String str = new String(this.buffer, this.bfI, rY, "UTF-8");
        this.bfI = rY + this.bfI;
        return str;
    }

    public final void a(e eVar) {
        int rY = rY();
        if (this.bfL >= this.bfM) {
            throw d.sj();
        }
        rY = dV(rY);
        this.bfL++;
        eVar.a(this);
        dT(0);
        this.bfL--;
        dW(rY);
    }

    public final byte[] readBytes() {
        int rY = rY();
        if (rY > this.bufferSize - this.bfI || rY <= 0) {
            return dY(rY);
        }
        Object obj = new byte[rY];
        System.arraycopy(this.buffer, this.bfI, obj, 0, rY);
        this.bfI = rY + this.bfI;
        return obj;
    }

    public final int rY() {
        byte sc = sc();
        if (sc >= (byte) 0) {
            return sc;
        }
        int i = sc & 127;
        byte sc2 = sc();
        if (sc2 >= (byte) 0) {
            return i | (sc2 << 7);
        }
        i |= (sc2 & 127) << 7;
        sc2 = sc();
        if (sc2 >= (byte) 0) {
            return i | (sc2 << 14);
        }
        i |= (sc2 & 127) << 14;
        sc2 = sc();
        if (sc2 >= (byte) 0) {
            return i | (sc2 << 21);
        }
        i |= (sc2 & 127) << 21;
        sc2 = sc();
        i |= sc2 << 28;
        if (sc2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (sc() >= (byte) 0) {
                return i;
            }
        }
        throw d.sf();
    }

    public final long rZ() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte sc = sc();
            j |= ((long) (sc & 127)) << i;
            if ((sc & 128) == 0) {
                return j;
            }
        }
        throw d.sf();
    }

    a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bfG = 0;
        this.bufferSize = i + 0;
        this.bfI = 0;
    }

    public final int dV(int i) {
        if (i < 0) {
            throw d.se();
        }
        int i2 = this.bfI + i;
        int i3 = this.bfK;
        if (i2 > i3) {
            throw d.sd();
        }
        this.bfK = i2;
        sa();
        return i3;
    }

    private void sa() {
        this.bufferSize += this.bfH;
        int i = this.bufferSize;
        if (i > this.bfK) {
            this.bfH = i - this.bfK;
            this.bufferSize -= this.bfH;
            return;
        }
        this.bfH = 0;
    }

    public final void dW(int i) {
        this.bfK = i;
        sa();
    }

    public final int sb() {
        if (this.bfK == Integer.MAX_VALUE) {
            return -1;
        }
        return this.bfK - this.bfI;
    }

    public final int getPosition() {
        return this.bfI - this.bfG;
    }

    public final void dX(int i) {
        if (i > this.bfI - this.bfG) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.bfI - this.bfG));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.bfI = this.bfG + i;
        }
    }

    private byte sc() {
        if (this.bfI == this.bufferSize) {
            throw d.sd();
        }
        byte[] bArr = this.buffer;
        int i = this.bfI;
        this.bfI = i + 1;
        return bArr[i];
    }

    private byte[] dY(int i) {
        if (i < 0) {
            throw d.se();
        } else if (this.bfI + i > this.bfK) {
            dZ(this.bfK - this.bfI);
            throw d.sd();
        } else if (i <= this.bufferSize - this.bfI) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bfI, obj, 0, i);
            this.bfI += i;
            return obj;
        } else {
            throw d.sd();
        }
    }

    private void dZ(int i) {
        if (i < 0) {
            throw d.se();
        } else if (this.bfI + i > this.bfK) {
            dZ(this.bfK - this.bfI);
            throw d.sd();
        } else if (i <= this.bufferSize - this.bfI) {
            this.bfI += i;
        } else {
            throw d.sd();
        }
    }
}
