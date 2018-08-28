package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static byte[] vji;
    static byte[] vjj;
    public int dQL = 0;
    public int requestType = 0;
    public int viZ = 0;
    public int viq = 0;
    public int vja = 0;
    public int vjb = 0;
    public byte[] vjc = null;
    public int vjd = 0;
    public long vje = 0;
    public byte[] vjf = null;
    public int vjg = 0;
    public int vjh = 0;

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.viZ != 0) {
            jceOutputStream.write(this.viZ, 0);
        }
        jceOutputStream.write(this.viq, 1);
        jceOutputStream.write(this.requestType, 2);
        if (this.vja != 0) {
            jceOutputStream.write(this.vja, 3);
        }
        if (this.vjb != 0) {
            jceOutputStream.write(this.vjb, 4);
        }
        if (this.vjc != null) {
            jceOutputStream.write(this.vjc, 5);
        }
        if (this.vjd != 0) {
            jceOutputStream.write(this.vjd, 6);
        }
        if (this.dQL != 0) {
            jceOutputStream.write(this.dQL, 7);
        }
        if (this.vje != 0) {
            jceOutputStream.write(this.vje, 8);
        }
        if (this.vjf != null) {
            jceOutputStream.write(this.vjf, 9);
        }
        if (this.vjg != 0) {
            jceOutputStream.write(this.vjg, 10);
        }
        if (this.vjh != 0) {
            jceOutputStream.write(this.vjh, 11);
        }
    }

    static {
        byte[] bArr = new byte[1];
        vji = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        vjj = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.viZ = jceInputStream.read(this.viZ, 0, false);
        this.viq = jceInputStream.read(this.viq, 1, false);
        this.requestType = jceInputStream.read(this.requestType, 2, false);
        this.vja = jceInputStream.read(this.vja, 3, false);
        this.vjb = jceInputStream.read(this.vjb, 4, false);
        this.vjc = jceInputStream.read(vji, 5, false);
        this.vjd = jceInputStream.read(this.vjd, 6, false);
        this.dQL = jceInputStream.read(this.dQL, 7, false);
        this.vje = jceInputStream.read(this.vje, 8, false);
        this.vjf = jceInputStream.read(vjj, 9, false);
        this.vjg = jceInputStream.read(this.vjg, 10, false);
        this.vjh = jceInputStream.read(this.vjh, 11, false);
    }
}
