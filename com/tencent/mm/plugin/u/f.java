package com.tencent.mm.plugin.u;

import android.util.Pair;
import com.tencent.mm.plugin.a.g;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.List;

public final class f {
    List<g> eyW;
    List<Pair> eyX;
    RandomAccessFile lcP;
    g lcQ;
    int lcR;
    int lcS;

    public final int x(ByteBuffer byteBuffer) {
        Throwable e;
        if (this.lcR >= this.lcS) {
            return -1;
        }
        int read;
        try {
            this.lcP.seek(this.lcQ.start);
            byte[] bArr = new byte[this.lcQ.size];
            read = this.lcP.read(bArr);
            try {
                if (read < this.lcQ.size) {
                    return -1;
                }
                bArr[0] = (byte) 0;
                bArr[1] = (byte) 0;
                bArr[2] = (byte) 0;
                bArr[3] = (byte) 1;
                int i = 0;
                while (i < read) {
                    if (bArr[i] == Byte.MIN_VALUE && i + 4 < read && bArr[i + 1] == (byte) 0 && bArr[i + 2] == (byte) 0) {
                        bArr[i + 3] = (byte) 0;
                        bArr[i + 4] = (byte) 1;
                    }
                    i++;
                }
                byteBuffer.clear();
                byteBuffer.put(bArr, 0, read).flip();
                return read;
            } catch (Throwable e2) {
                e = e2;
                x.printErrStackTrace("MicroMsg.Mp4Extractor", e, "read sample data error", new Object[0]);
                return read;
            }
        } catch (Exception e3) {
            e = e3;
            read = -1;
        }
    }
}
