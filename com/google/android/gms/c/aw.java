package com.google.android.gms.c;

import com.tencent.smtt.sdk.WebView;

public final class aw {
    int aZO;
    int aZP;
    private int aZQ;
    int aZR;
    private int aZS;
    private int aZT = Integer.MAX_VALUE;
    private int aZU;
    private int aZV = 64;
    private int aZW = 67108864;
    final byte[] buffer;

    aw(byte[] bArr, int i) {
        this.buffer = bArr;
        this.aZO = 0;
        this.aZP = i + 0;
        this.aZR = 0;
    }

    private void dF(int i) {
        if (i < 0) {
            throw bd.qL();
        } else if (this.aZR + i > this.aZT) {
            dF(this.aZT - this.aZR);
            throw bd.qK();
        } else if (i <= this.aZP - this.aZR) {
            this.aZR += i;
        } else {
            throw bd.qK();
        }
    }

    private void qC() {
        this.aZP += this.aZQ;
        int i = this.aZP;
        if (i > this.aZT) {
            this.aZQ = i - this.aZT;
            this.aZP -= this.aZQ;
            return;
        }
        this.aZQ = 0;
    }

    private byte qE() {
        if (this.aZR == this.aZP) {
            throw bd.qK();
        }
        byte[] bArr = this.buffer;
        int i = this.aZR;
        this.aZR = i + 1;
        return bArr[i];
    }

    public final void a(be beVar) {
        int qz = qz();
        if (this.aZU >= this.aZV) {
            throw bd.qQ();
        }
        qz = dB(qz);
        this.aZU++;
        beVar.a(this);
        dz(0);
        this.aZU--;
        dC(qz);
    }

    public final boolean dA(int i) {
        switch (bh.dO(i)) {
            case 0:
                qz();
                return true;
            case 1:
                qB();
                return true;
            case 2:
                dF(qz());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                qA();
                return true;
            default:
                throw bd.qP();
        }
        int qw;
        do {
            qw = qw();
            if (qw != 0) {
            }
            dz(bh.aC(bh.dP(i), 4));
            return true;
        } while (dA(qw));
        dz(bh.aC(bh.dP(i), 4));
        return true;
    }

    public final int dB(int i) {
        if (i < 0) {
            throw bd.qL();
        }
        int i2 = this.aZR + i;
        int i3 = this.aZT;
        if (i2 > i3) {
            throw bd.qK();
        }
        this.aZT = i2;
        qC();
        return i3;
    }

    public final void dC(int i) {
        this.aZT = i;
        qC();
    }

    public final void dD(int i) {
        if (i > this.aZR - this.aZO) {
            throw new IllegalArgumentException("Position " + i + " is beyond current " + (this.aZR - this.aZO));
        } else if (i < 0) {
            throw new IllegalArgumentException("Bad position " + i);
        } else {
            this.aZR = this.aZO + i;
        }
    }

    public final byte[] dE(int i) {
        if (i < 0) {
            throw bd.qL();
        } else if (this.aZR + i > this.aZT) {
            dF(this.aZT - this.aZR);
            throw bd.qK();
        } else if (i <= this.aZP - this.aZR) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.aZR, obj, 0, i);
            this.aZR += i;
            return obj;
        } else {
            throw bd.qK();
        }
    }

    public final void dz(int i) {
        if (this.aZS != i) {
            throw bd.qO();
        }
    }

    public final int getPosition() {
        return this.aZR - this.aZO;
    }

    public final int qA() {
        return (((qE() & WebView.NORMAL_MODE_ALPHA) | ((qE() & WebView.NORMAL_MODE_ALPHA) << 8)) | ((qE() & WebView.NORMAL_MODE_ALPHA) << 16)) | ((qE() & WebView.NORMAL_MODE_ALPHA) << 24);
    }

    public final long qB() {
        byte qE = qE();
        byte qE2 = qE();
        return ((((((((((long) qE2) & 255) << 8) | (((long) qE) & 255)) | ((((long) qE()) & 255) << 16)) | ((((long) qE()) & 255) << 24)) | ((((long) qE()) & 255) << 32)) | ((((long) qE()) & 255) << 40)) | ((((long) qE()) & 255) << 48)) | ((((long) qE()) & 255) << 56);
    }

    public final int qD() {
        if (this.aZT == Integer.MAX_VALUE) {
            return -1;
        }
        return this.aZT - this.aZR;
    }

    public final int qw() {
        if ((this.aZR == this.aZP ? 1 : 0) != 0) {
            this.aZS = 0;
            return 0;
        }
        this.aZS = qz();
        if (this.aZS != 0) {
            return this.aZS;
        }
        throw bd.qN();
    }

    public final long qx() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte qE = qE();
            j |= ((long) (qE & 127)) << i;
            if ((qE & 128) == 0) {
                return j;
            }
        }
        throw bd.qM();
    }

    public final boolean qy() {
        return qz() != 0;
    }

    public final int qz() {
        byte qE = qE();
        if (qE >= (byte) 0) {
            return qE;
        }
        int i = qE & 127;
        byte qE2 = qE();
        if (qE2 >= (byte) 0) {
            return i | (qE2 << 7);
        }
        i |= (qE2 & 127) << 7;
        qE2 = qE();
        if (qE2 >= (byte) 0) {
            return i | (qE2 << 14);
        }
        i |= (qE2 & 127) << 14;
        qE2 = qE();
        if (qE2 >= (byte) 0) {
            return i | (qE2 << 21);
        }
        i |= (qE2 & 127) << 21;
        qE2 = qE();
        i |= qE2 << 28;
        if (qE2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (qE() >= (byte) 0) {
                return i;
            }
        }
        throw bd.qM();
    }

    public final String readString() {
        int qz = qz();
        if (qz > this.aZP - this.aZR || qz <= 0) {
            return new String(dE(qz), "UTF-8");
        }
        String str = new String(this.buffer, this.aZR, qz, "UTF-8");
        this.aZR = qz + this.aZR;
        return str;
    }
}
