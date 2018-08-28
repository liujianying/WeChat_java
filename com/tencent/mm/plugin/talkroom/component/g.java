package com.tencent.mm.plugin.talkroom.component;

import android.os.Looper;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.loader.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.x;

class g extends a$a {
    private final ag handler = new ag(Looper.getMainLooper());
    private final v2engine ovu = new v2engine();

    static {
        int zj = m.zj();
        x.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(zj)});
        if ((zj & 1024) != 0) {
            d.y(ad.getContext(), "libvoipCodec_v7a.so");
        } else if ((zj & 512) != 0) {
            d.y(ad.getContext(), "libvoipCodec.so");
        } else {
            d.y(ad.getContext(), "libvoipCodec_v5.so");
        }
        k.b("voipMain", g.class.getClassLoader());
    }

    public final int uninitLive() {
        return ((Integer) new 1(this, Integer.valueOf(-99999)).a(this.handler)).intValue();
    }

    public final int SetCurrentMicId(final int i) {
        return ((Integer) new bd<Integer>(Integer.valueOf(-99999)) {
            protected final /* synthetic */ Object run() {
                return Integer.valueOf(g.this.ovu.SetCurrentMicId(i));
            }
        }.a(this.handler)).intValue();
    }

    public final int Close() {
        return ((Integer) new bd<Integer>(Integer.valueOf(-99999)) {
            protected final /* synthetic */ Object run() {
                return Integer.valueOf(g.this.ovu.Close());
            }
        }.a(this.handler)).intValue();
    }

    public final int bGN() {
        return ((Integer) new bd<Integer>(Integer.valueOf(-99999)) {
            protected final /* synthetic */ Object run() {
                x.i("MicroMsg.TalkRoomEngineProxy", "initLive cpuFlag: %d", new Object[]{Integer.valueOf(m.zj())});
                x.i("MicroMsg.TalkRoomEngineProxy", "initLive %d ", new Object[]{Integer.valueOf(g.this.ovu.initLive(r0, e.duM + "app_lib/"))});
                return Integer.valueOf(g.this.ovu.initLive(r0, e.duM + "app_lib/"));
            }
        }.a(this.handler)).intValue();
    }

    public final int a(b bVar, int i, int i2, int i3, long j, int[] iArr, int[] iArr2, int i4) {
        final short[] sArr = new short[iArr2.length];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            sArr[i5] = (short) iArr2[i5];
        }
        final b bVar2 = bVar;
        final int i6 = i;
        final int i7 = i2;
        final int i8 = i3;
        final long j2 = j;
        final int[] iArr3 = iArr;
        final int i9 = i4;
        return ((Integer) new bd<Integer>(Integer.valueOf(-99999)) {
            protected final /* synthetic */ Object run() {
                return Integer.valueOf(g.this.ovu.Open(bVar2, i6, i7, i8, j2, iArr3, sArr, i9));
            }
        }.a(this.handler)).intValue();
    }

    public final byte[] e(int[] iArr, String str) {
        return (byte[]) new 6(this, iArr, str).a(this.handler);
    }

    public final e a(c cVar) {
        return (e) new 7(this, cVar).a(this.handler);
    }

    public final d bGO() {
        return (d) new 8(this).a(this.handler);
    }
}
