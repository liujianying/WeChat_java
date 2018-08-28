package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.e.b;
import java.io.ByteArrayInputStream;

public abstract class a {

    /* renamed from: com.tencent.tinker.c.a.c.a$1 */
    class AnonymousClass1 implements com.tencent.tinker.a.a.b.a {
        final /* synthetic */ ByteArrayInputStream vrz;

        public AnonymousClass1(ByteArrayInputStream byteArrayInputStream) {
            this.vrz = byteArrayInputStream;
        }

        public final byte readByte() {
            return (byte) (this.vrz.read() & 255);
        }
    }

    public abstract int HU(int i);

    public abstract int HV(int i);

    public abstract int HW(int i);

    public abstract int HX(int i);

    public abstract int HY(int i);

    public abstract int HZ(int i);

    public abstract int Ia(int i);

    public abstract int Ib(int i);

    public abstract int Ic(int i);

    public abstract int Id(int i);

    public abstract int Ie(int i);

    public abstract int If(int i);

    public abstract int Ig(int i);

    public abstract int Ih(int i);

    public final com.tencent.tinker.a.a.e.a[] b(com.tencent.tinker.a.a.e.a[] aVarArr) {
        com.tencent.tinker.a.a.e.a[] aVarArr2 = new com.tencent.tinker.a.a.e.a[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            com.tencent.tinker.a.a.e.a aVar = aVarArr[i];
            aVarArr2[i] = new com.tencent.tinker.a.a.e.a(HX(aVar.voo), aVar.vop);
        }
        return aVarArr2;
    }

    public final b[] b(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i = 0; i < bVarArr.length; i++) {
            b bVar = bVarArr[i];
            bVarArr2[i] = new b(HY(bVar.voq), bVar.vop, Ih(bVar.vor));
        }
        return bVarArr2;
    }
}
