package com.tencent.qqpinyin.voicerecoapi;

public final class a {
    public static int MAX_FRAME_SIZE = 2000;
    private byte[] vgH = null;
    public byte[] vgI = null;
    private int vgJ = 0;
    public int vgK = 0;
    public TRSpeexNative vgL = new TRSpeexNative();

    public final int cEM() {
        if (this.vgJ != 0) {
            return -103;
        }
        int nativeTRSpeexInit = this.vgL.nativeTRSpeexInit();
        if (nativeTRSpeexInit == -1) {
            return nativeTRSpeexInit;
        }
        this.vgJ = nativeTRSpeexInit;
        this.vgH = new byte[(MAX_FRAME_SIZE * 10)];
        return 0;
    }

    public final byte[] W(byte[] bArr, int i) {
        if (this.vgJ == 0) {
            throw new b(-102);
        } else if (bArr == null || bArr.length == 0) {
            throw new b(-104);
        } else {
            int nativeTRSpeexEncode = this.vgL.nativeTRSpeexEncode(this.vgJ, bArr, 0, i, this.vgH);
            if (nativeTRSpeexEncode < 0) {
                throw new b(nativeTRSpeexEncode);
            } else if (nativeTRSpeexEncode == 0) {
                return null;
            } else {
                byte[] bArr2 = new byte[nativeTRSpeexEncode];
                System.arraycopy(this.vgH, 0, bArr2, 0, nativeTRSpeexEncode);
                return bArr2;
            }
        }
    }

    public final int cEN() {
        if (this.vgJ == 0) {
            return -102;
        }
        this.vgH = null;
        int nativeTRSpeexRelease = this.vgL.nativeTRSpeexRelease(this.vgJ);
        this.vgJ = 0;
        return nativeTRSpeexRelease;
    }
}
