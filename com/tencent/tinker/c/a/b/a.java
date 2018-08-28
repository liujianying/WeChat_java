package com.tencent.tinker.c.a.b;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.b.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a {
    public static final byte[] gRO = new byte[]{(byte) 68, (byte) 88, (byte) 68, (byte) 73, (byte) 70, (byte) 70};
    private short version;
    public final com.tencent.tinker.a.a.a.a vre;
    public int vrf;
    private int vrg;
    public int vrh;
    public int vri;
    public int vrj;
    public int vrk;
    public int vrl;
    public int vrm;
    public int vrn;
    public int vro;
    public int vrp;
    public int vrq;
    public int vrr;
    public int vrs;
    public int vrt;
    public int vru;
    public int vrv;
    public int vrw;
    public int vrx;
    public byte[] vry;

    public a(InputStream inputStream) {
        this.vre = new com.tencent.tinker.a.a.a.a(ByteBuffer.wrap(d.m(inputStream)));
        byte[] Hz = this.vre.Hz(gRO.length);
        if (c.l(Hz, gRO) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(Hz));
        }
        this.version = this.vre.aig.getShort();
        if (c.b(this.version, (short) 2) != 0) {
            throw new IllegalStateException("bad dex patch file version: " + this.version + ", expected: 2");
        }
        this.vrf = this.vre.aig.getInt();
        this.vrg = this.vre.aig.getInt();
        this.vrh = this.vre.aig.getInt();
        this.vri = this.vre.aig.getInt();
        this.vrj = this.vre.aig.getInt();
        this.vrk = this.vre.aig.getInt();
        this.vrl = this.vre.aig.getInt();
        this.vrm = this.vre.aig.getInt();
        this.vrn = this.vre.aig.getInt();
        this.vro = this.vre.aig.getInt();
        this.vrp = this.vre.aig.getInt();
        this.vrq = this.vre.aig.getInt();
        this.vrr = this.vre.aig.getInt();
        this.vrs = this.vre.aig.getInt();
        this.vrt = this.vre.aig.getInt();
        this.vru = this.vre.aig.getInt();
        this.vrv = this.vre.aig.getInt();
        this.vrw = this.vre.aig.getInt();
        this.vrx = this.vre.aig.getInt();
        this.vry = this.vre.Hz(20);
        com.tencent.tinker.a.a.a.a aVar = this.vre;
        aVar.aig.position(this.vrg);
    }
}
