package com.tencent.qqpinyin.voicerecoapi;

public final class c {
    private int eqw;
    private int gkT;
    private TRVADNative vgM;

    public c(int i) {
        this.vgM = new TRVADNative();
        this.eqw = i;
        this.gkT = 5000000;
    }

    public c() {
        this.vgM = new TRVADNative();
        this.eqw = 500000;
        this.gkT = 10000000;
    }

    public final int start() {
        int mfeInit = this.vgM.mfeInit(this.eqw, this.gkT);
        if (mfeInit == 0) {
            mfeInit = this.vgM.mfeOpen();
            if (mfeInit == 0) {
                mfeInit = this.vgM.mfeEnableNoiseDetection(true);
                if (mfeInit == 0) {
                    mfeInit = this.vgM.mfeStart();
                }
            }
        }
        return mfeInit == 0 ? 0 : -1;
    }

    public final int stop() {
        int mfeStop = this.vgM.mfeStop();
        if (mfeStop == 0) {
            mfeStop = this.vgM.mfeClose();
            if (mfeStop == 0) {
                mfeStop = this.vgM.mfeExit();
            }
        }
        return mfeStop == 0 ? 0 : -1;
    }

    public final synchronized void a(short[] sArr, int i, a aVar) {
        double d = 26.0d;
        synchronized (this) {
            if (i > 0) {
                switch (this.vgM.mfeSendData(sArr, i)) {
                    case 1:
                        aVar.vgN = 1;
                        break;
                    case 2:
                        aVar.vgN = 2;
                        break;
                    case 3:
                        aVar.vgN = 3;
                        break;
                    default:
                        aVar.vgN = 0;
                        break;
                }
                int i2 = 0;
                int i3 = 0;
                while (i2 < i) {
                    i2++;
                    i3 = (int) (((double) i3) + (Math.sqrt((double) (sArr[i2] * sArr[i2])) / ((double) i)));
                }
                if (i3 < 100) {
                    d = 0.0d;
                } else if (i3 <= 16383) {
                    d = 26.0d * ((((double) i3) - 100.0d) / 32667.0d);
                }
                aVar.vgR = (int) d;
                new StringBuilder("volumn��").append(aVar.vgR);
            }
        }
    }
}
