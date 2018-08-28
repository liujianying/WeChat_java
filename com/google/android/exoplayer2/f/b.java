package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.b.f;
import com.google.android.exoplayer2.b.g;
import com.google.android.exoplayer2.i.a;
import java.nio.ByteBuffer;

public abstract class b extends g<h, i, f> implements e {
    private final String name;

    public abstract d b(byte[] bArr, int i, boolean z);

    protected final /* synthetic */ e jL() {
        return new h();
    }

    protected final /* synthetic */ f jM() {
        return new c(this);
    }

    public b(String str) {
        int i = 0;
        super(new h[2], new i[2]);
        this.name = str;
        a.ap(this.aio == this.aim.length);
        e[] eVarArr = this.aim;
        int length = eVarArr.length;
        while (i < length) {
            eVarArr[i].ch(1024);
            i++;
        }
    }

    public final void O(long j) {
    }

    protected final void a(i iVar) {
        super.a(iVar);
    }

    private f a(h hVar, i iVar, boolean z) {
        try {
            ByteBuffer byteBuffer = hVar.aig;
            d b = b(byteBuffer.array(), byteBuffer.limit(), z);
            iVar.a(hVar.aih, b, hVar.aek);
            iVar.flags &= Integer.MAX_VALUE;
            return null;
        } catch (f e) {
            return e;
        }
    }
}
