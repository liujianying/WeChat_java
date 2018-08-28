package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.i.e;
import java.util.Arrays;

public final class t {
    public int epK;
    public int fileSize;
    public byte[] kMN = new byte[20];
    public final a vpA = new a(8197, false);
    public final a vpB = new a(8198, true);
    public final a[] vpC = new a[]{this.vpk, this.vpl, this.vpm, this.vpn, this.vpo, this.vpp, this.vpq, this.vpr, this.vps, this.vpt, this.vpu, this.vpv, this.vpw, this.vpx, this.vpy, this.vpz, this.vpA, this.vpB};
    public int vpD;
    public int vpE;
    public int vpF;
    public int vpG;
    public final a vpk = new a(0, true);
    public final a vpl = new a(1, true);
    public final a vpm = new a(2, true);
    public final a vpn = new a(3, true);
    public final a vpo = new a(4, true);
    public final a vpp = new a(5, true);
    public final a vpq = new a(6, true);
    public final a vpr = new a(4096, true);
    public final a vps = new a(4097, true);
    public final a vpt = new a(4098, true);
    public final a vpu = new a(4099, true);
    public final a vpv = new a(8192, false);
    public final a vpw = new a(8193, true);
    public final a vpx = new a(8194, false);
    public final a vpy = new a(8195, false);
    public final a vpz = new a(8196, false);

    final void a(e eVar) {
        int i;
        int i2 = eVar.aig.getInt();
        int i3 = 0;
        a aVar = null;
        while (i3 < i2) {
            short s = eVar.aig.getShort();
            eVar.aig.getShort();
            for (a aVar2 : this.vpC) {
                if (aVar2.vpH == s) {
                    i = eVar.aig.getInt();
                    int i4 = eVar.aig.getInt();
                    if ((aVar2.size == 0 || aVar2.size == i) && (aVar2.off == -1 || aVar2.off == i4)) {
                        aVar2.size = i;
                        aVar2.off = i4;
                        if (aVar == null || aVar.off <= aVar2.off) {
                            i3++;
                            aVar = aVar2;
                        } else {
                            throw new j("Map is unsorted at " + aVar + ", " + aVar2);
                        }
                    }
                    throw new j("Unexpected map value for 0x" + Integer.toHexString(s));
                }
            }
            throw new IllegalArgumentException("No such map item: " + s);
        }
        this.vpk.off = 0;
        Arrays.sort(this.vpC);
        for (i = 1; i < this.vpC.length; i++) {
            if (this.vpC[i].off == -1) {
                this.vpC[i].off = this.vpC[i - 1].off;
            }
        }
    }

    public final void cGM() {
        int i = this.fileSize;
        for (int length = this.vpC.length - 1; length >= 0; length--) {
            a aVar = this.vpC[length];
            if (aVar.off != -1) {
                if (aVar.off > i) {
                    throw new j("Map is unsorted at " + aVar);
                }
                aVar.vpJ = i - aVar.off;
                i = aVar.off;
            }
        }
        this.vpG = (((((this.vpk.vpJ + this.vpl.vpJ) + this.vpm.vpJ) + this.vpn.vpJ) + this.vpo.vpJ) + this.vpp.vpJ) + this.vpq.vpJ;
        this.vpF = this.fileSize - this.vpG;
    }

    public final void b(e eVar) {
        int i = 0;
        for (a exists : this.vpC) {
            if (exists.exists()) {
                i++;
            }
        }
        eVar.writeInt(i);
        for (a aVar : this.vpC) {
            if (aVar.exists()) {
                eVar.writeShort(aVar.vpH);
                eVar.writeShort((short) 0);
                eVar.writeInt(aVar.size);
                eVar.writeInt(aVar.off);
            }
        }
    }
}
