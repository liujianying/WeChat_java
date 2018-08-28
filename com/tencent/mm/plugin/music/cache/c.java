package com.tencent.mm.plugin.music.cache;

import android.text.TextUtils;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.music.cache.ipc.IPCAudioParamRequest;
import com.tencent.mm.plugin.music.cache.ipc.a.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.BitSet;

public final class c {
    public int count = 0;
    public long eyz = -1;
    public BitSet lxw = new BitSet();
    public String lxx = "";
    public String mUrl;

    public static class a {
        public static BitSet aC(byte[] bArr) {
            BitSet bitSet = new BitSet(bArr.length * 8);
            int i = 0;
            for (byte b : bArr) {
                int i2 = 7;
                while (i2 >= 0) {
                    boolean z;
                    int i3 = i + 1;
                    if (((b & (1 << i2)) >> i2) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bitSet.set(i, z);
                    i2--;
                    i = i3;
                }
            }
            return bitSet;
        }
    }

    public c(String str) {
        this.mUrl = str;
    }

    public final void bhK() {
        int i = 0;
        if (!TextUtils.isEmpty(this.lxx)) {
            BitSet bitSet = this.lxw;
            byte[] bArr = new byte[(bitSet.size() / 8)];
            for (int i2 = 0; i2 < bitSet.size(); i2++) {
                int i3 = i2 / 8;
                bArr[i3] = (byte) (((bitSet.get(i2) ? 1 : 0) << (7 - (i2 % 8))) | bArr[i3]);
            }
            com.tencent.mm.plugin.music.cache.ipc.a.k(this.lxx, bArr);
        }
        x.d("MicroMsg.IndexBitMgr", "saveBitCache bitSet:%s", new Object[]{this.lxw.toString()});
        x.i("MicroMsg.IndexBitMgr", "saveBitCache bitSet count %d, cardinality:" + this.count + "," + this.lxw.cardinality());
        x.i("MicroMsg.IndexBitMgr", "isCacheComplete, count:%d, cardinality:%d", new Object[]{Integer.valueOf(this.count), Integer.valueOf(this.lxw.cardinality())});
        if (this.count > 0 && this.count == this.lxw.cardinality()) {
            i = 1;
        }
        if (i != 0) {
            tu(1);
        }
    }

    public final void clearCache() {
        x.i("MicroMsg.IndexBitMgr", "clearCache");
        this.lxw = new BitSet(this.count);
        tu(0);
        if (!TextUtils.isEmpty(this.lxx)) {
            com.tencent.mm.plugin.music.cache.ipc.a.k(this.lxx, null);
        }
    }

    private void tu(int i) {
        x.i("MicroMsg.IndexBitMgr", "setFileCacheComplete %d", new Object[]{Integer.valueOf(i)});
        if (!TextUtils.isEmpty(this.lxx)) {
            String str = this.lxx;
            IPCAudioParamRequest iPCAudioParamRequest = new IPCAudioParamRequest();
            iPCAudioParamRequest.lxx = str;
            iPCAudioParamRequest.lxH = i;
            x.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "updateMusicFileCacheComplete");
            XIPCInvoker.a("com.tencent.mm", iPCAudioParamRequest, i.class);
            x.d("MicroMsg.Audio.MusicDataSourceCrossProcessImp", "updateMusicFileCacheComplete end");
        }
    }

    public final int getIndex(int i) {
        if (((long) i) <= this.eyz) {
            return i / 8192;
        }
        x.e("MicroMsg.IndexBitMgr", "getIndex, offset is invalid, offset:%d, fileLength:%d", new Object[]{Integer.valueOf(i), Long.valueOf(this.eyz)});
        return 0;
    }

    public final boolean tv(int i) {
        return this.lxw.get(i);
    }

    public final void tw(int i) {
        this.lxw.set(i);
    }

    public final boolean cV(int i, int i2) {
        if (i < 0 || i2 < 0 || ((long) i) > this.eyz || ((long) (i + i2)) > this.eyz) {
            x.e("MicroMsg.IndexBitMgr", "canReadFromCache offset %d, size %d, fileLength %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(this.eyz)});
            x.e("MicroMsg.IndexBitMgr", "canReadFromCache invalid parameter!");
            return false;
        }
        int index = getIndex(i);
        int index2 = getIndex(i + i2);
        int i3 = index;
        while (i3 <= index2) {
            if (tv(index)) {
                i3++;
            } else {
                x.d("MicroMsg.IndexBitMgr", "index %d, indexBit 0", new Object[]{Integer.valueOf(i3)});
                return false;
            }
        }
        return true;
    }
}
