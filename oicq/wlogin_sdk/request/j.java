package oicq.wlogin_sdk.request;

import com.tencent.wcdb.FileUtils;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.vIl = 2064;
        this.vIm = 9;
        this.vIo = iVar;
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, byte[] bArr4) {
        Object bZ;
        Object bY;
        int i3 = this.vIo.vIy;
        this.vIo._uin = j;
        util.gz("IMEI", util.cg(this.vIo.vIz));
        byte[] bArr5 = this.vIo.vIq;
        byte[] bArr6 = this.vIo.vIz;
        byte[] cKd = this.vIo.vIt.cKd();
        byte[] bArr7 = this.vIo.vID;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object U = anVar.U(i3, j);
        Object g = bVar.g(j, bArr);
        Object a = hVar.a(i3, j, bArr2, bArr, bArr3, bArr5, this.vIo.vIL, this.vIo.vIz);
        this.vIo.vIP = super.bV(hVar.cKd());
        Object IF = cVar.IF(i3);
        Object cKg = iVar.cKg();
        Object fW = rVar.fW(i, i2);
        Object cc = ahVar.cc(this.vIo.vIz);
        int i4 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            i4 = 8;
            bZ = jVar.bZ(bArr4);
        } else {
            bZ = obj;
        }
        if (bArr6.length > 0) {
            bArr6 = kVar.ca(bArr6);
        } else {
            bArr6 = bArr8;
        }
        Object a2 = agVar.a(bArr6, yVar.a(util.cKj(), util.cKk(), this.vIo.vIC, this.vIo.vIB, new byte[0], this.vIo.vIE), aaVar.a(this.vIo.vIK, this.vIo.vIL, this.vIo.vIM, this.vIo.vII, this.vIo.vIz), ajVar.m(this.vIo.vIG, this.vIo.vIH), this.vIo.vIq);
        i4++;
        Object cb = aeVar.cb(bArr7);
        int i5 = i4 + 1;
        if (cKd.length > 0) {
            bY = fVar.bY(cKd);
            i5++;
        } else {
            bY = obj2;
        }
        Object obj4 = new byte[(((((((((((U.length + g.length) + a.length) + fW.length) + IF.length) + cKg.length) + bZ.length) + a2.length) + bY.length) + cb.length) + 0) + cc.length)];
        System.arraycopy(U, 0, obj4, 0, U.length);
        int length = U.length + 0;
        System.arraycopy(g, 0, obj4, length, g.length);
        length += g.length;
        System.arraycopy(a, 0, obj4, length, a.length);
        length += a.length;
        System.arraycopy(fW, 0, obj4, length, fW.length);
        length += fW.length;
        System.arraycopy(IF, 0, obj4, length, IF.length);
        length += IF.length;
        System.arraycopy(cKg, 0, obj4, length, cKg.length);
        length += cKg.length;
        System.arraycopy(bZ, 0, obj4, length, bZ.length);
        length += bZ.length;
        System.arraycopy(a2, 0, obj4, length, a2.length);
        int length2 = a2.length + length;
        System.arraycopy(cb, 0, obj4, length2, cb.length);
        length2 += cb.length;
        System.arraycopy(obj3, 0, obj4, length2, 0);
        length2 += 0;
        System.arraycopy(bY, 0, obj4, length2, bY.length);
        System.arraycopy(cc, 0, obj4, bY.length + length2, cc.length);
        long j2 = j;
        int i6 = i3;
        a(this.vIg, this.vIl, j2, this.vIi, this.vIj, i6, this.vIk, super.v(obj4, this.vIm, i5));
        return super.cKa();
    }

    public final byte[] a(long j, byte[] bArr, byte[] bArr2, int i, int i2, byte[] bArr3) {
        int i3 = this.vIo.vIy;
        this.vIo._uin = j;
        Object bW = super.bW(bArr2);
        if (bW == null) {
            return null;
        }
        Object obj;
        Object bZ;
        int i4;
        byte[] ca;
        Object bY;
        byte[] bArr4 = this.vIo.vIz;
        byte[] cKd = this.vIo.vIt.cKd();
        byte[] bArr5 = this.vIo.vID;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object U = anVar.U(i3, j);
        Object g = bVar.g(j, bArr);
        this.vIo.vIP = super.bV(bW);
        int length = bW.length;
        if (hVar.vIU + length > hVar.vHZ) {
            hVar.vHZ = (hVar.vIU + length) + FileUtils.S_IWUSR;
            obj = new byte[hVar.vHZ];
            System.arraycopy(hVar.vIf, 0, obj, 0, hVar.vIU);
            hVar.vIf = obj;
        }
        hVar.vIa = hVar.vIU + length;
        System.arraycopy(bW, 0, hVar.vIf, hVar.vIU, length);
        hVar.vIV = length;
        util.B(hVar.vIf, 0, hVar.vIl);
        util.B(hVar.vIf, 2, hVar.vIV);
        Object cKa = hVar.cKa();
        util.gz("req2 a1:", util.cg(cKa));
        Object IF = cVar.IF(i3);
        Object cKg = iVar.cKg();
        Object fW = rVar.fW(i, i2);
        Object cc = ahVar.cc(this.vIo.vIz);
        bW = new byte[0];
        byte[] bArr6 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr3.length > 0) {
            bZ = jVar.bZ(bArr3);
            i4 = 8;
        } else {
            bZ = bW;
            i4 = 7;
        }
        if (bArr4.length > 0) {
            ca = kVar.ca(bArr4);
        } else {
            ca = bArr6;
        }
        Object a = agVar.a(ca, yVar.a(util.cKj(), util.cKk(), this.vIo.vIC, this.vIo.vIB, new byte[0], this.vIo.vIE), aaVar.a(this.vIo.vIK, this.vIo.vIL, this.vIo.vIM, this.vIo.vII, this.vIo.vIz), ajVar.m(this.vIo.vIG, this.vIo.vIH), this.vIo.vIq);
        int i5 = i4 + 1;
        obj = aeVar.cb(bArr5);
        int i6 = i5 + 1;
        if (cKd.length > 0) {
            bY = fVar.bY(cKd);
            i6++;
        } else {
            bY = obj2;
        }
        Object obj4 = new byte[(((((((((((U.length + g.length) + cKa.length) + fW.length) + IF.length) + cKg.length) + bZ.length) + a.length) + bY.length) + obj.length) + 0) + cc.length)];
        System.arraycopy(U, 0, obj4, 0, U.length);
        int length2 = U.length + 0;
        System.arraycopy(g, 0, obj4, length2, g.length);
        length2 += g.length;
        System.arraycopy(cKa, 0, obj4, length2, cKa.length);
        length2 += cKa.length;
        System.arraycopy(fW, 0, obj4, length2, fW.length);
        length2 += fW.length;
        System.arraycopy(IF, 0, obj4, length2, IF.length);
        length2 += IF.length;
        System.arraycopy(cKg, 0, obj4, length2, cKg.length);
        length2 += cKg.length;
        System.arraycopy(bZ, 0, obj4, length2, bZ.length);
        length2 += bZ.length;
        System.arraycopy(a, 0, obj4, length2, a.length);
        length = a.length + length2;
        System.arraycopy(obj, 0, obj4, length, obj.length);
        length += obj.length;
        System.arraycopy(obj3, 0, obj4, length, 0);
        length += 0;
        System.arraycopy(bY, 0, obj4, length, bY.length);
        System.arraycopy(cc, 0, obj4, bY.length + length, cc.length);
        ca = super.v(obj4, this.vIm, i6);
        a(this.vIg, this.vIl, j, this.vIi, this.vIj, i3, this.vIk, ca);
        return super.cKa();
    }
}
