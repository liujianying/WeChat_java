package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.d;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.aig;
        j jVar = new j(byteBuffer.array(), byteBuffer.limit());
        String mj = jVar.mj();
        String mj2 = jVar.mj();
        long ba = jVar.ba();
        jVar.da(4);
        return new Metadata(new Entry[]{new EventMessage(mj, mj2, (jVar.ba() * 1000) / ba, jVar.ba(), Arrays.copyOfRange(r1, jVar.position, r0))});
    }
}
