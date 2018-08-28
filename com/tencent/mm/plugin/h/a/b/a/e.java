package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.plugin.h.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String hia = h.hgS;
    public static final String hib = h.hgT;
    public static final String hic = h.hgU;
    public static final String hid = h.hgV;
    public byte hie;
    public byte hif;
    public byte hig;
    public byte hih;
    public byte[] hii;
    public int hij;
    public byte hik;
    public byte hil;
    public byte[] him;

    public e() {
        this.hhi = null;
        this.hhj = 8;
        this.hgC = 16;
        this.hie = (byte) 0;
        this.hif = (byte) 0;
        this.hig = (byte) 0;
        this.hih = (byte) 0;
        this.hii = new byte[]{(byte) 0, (byte) 0};
        this.hij = -1;
        this.hik = (byte) 0;
        this.hil = (byte) 0;
        this.him = null;
    }

    public final byte[] atV() {
        byte[] bArr;
        if (this.hhi.equalsIgnoreCase(hia)) {
            Object obj = new byte[3];
            System.arraycopy(Byte.valueOf(this.hie), 0, obj, 0, 1);
            System.arraycopy(Byte.valueOf(this.hif), 0, obj, 1, 1);
            System.arraycopy(Byte.valueOf(this.hig), 0, obj, 2, 1);
            return obj;
        } else if (this.hhi.equalsIgnoreCase(hib)) {
            bArr = new byte[1];
            System.arraycopy(Byte.valueOf(this.hih), 0, bArr, 0, 1);
            return bArr;
        } else if (!this.hhi.equalsIgnoreCase(hid)) {
            return null;
        } else {
            bArr = new byte[this.hij];
            byte b = (byte) ((this.hij >> 8) & 255);
            System.arraycopy(Byte.valueOf((byte) (this.hij & 255)), 0, bArr, 0, 1);
            System.arraycopy(Byte.valueOf(b), 0, bArr, 1, 1);
            System.arraycopy(Byte.valueOf(this.hik), 0, bArr, 2, 1);
            if (this.hij <= 3) {
                return bArr;
            }
            System.arraycopy(this.him, 0, bArr, 3, this.hij - 3);
            return bArr;
        }
    }
}
