package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.util.zip.CRC32;

public final class b {
    public static int a(byte[] bArr, int i, short s, short s2, int i2, byte[] bArr2) {
        int i3 = 0;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(n.eo(i));
            byteArrayOutputStream.write(new byte[]{(byte) ((s >> 8) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE), (byte) (s & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE)});
            byteArrayOutputStream.write(new byte[]{(byte) ((s2 >> 8) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE), (byte) (s2 & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE)});
            byteArrayOutputStream.write(n.eo(i2));
            byteArrayOutputStream.write(n.eo(0));
            byteArrayOutputStream.write(bArr2);
            CRC32 crc32 = new CRC32();
            crc32.update(byteArrayOutputStream.toByteArray());
            return (int) crc32.getValue();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakOldPacker", e, "", new Object[i3]);
            return i3;
        }
    }

    public static String Y(byte[] bArr) {
        String str = "";
        r0 = bArr.length > 100 ? bArr.length - 100 : 0;
        while (r0 < bArr.length) {
            str = str + Integer.toHexString(bArr[r0] & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE) + " ";
            r0++;
        }
        x.e("MicroMsg.BakOldPacker", "dump errBuf: %s", new Object[]{str});
        return str;
    }
}
