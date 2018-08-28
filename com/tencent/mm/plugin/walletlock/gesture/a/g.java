package com.tencent.mm.plugin.walletlock.gesture.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;

public final class g {
    public long pGZ = -1;
    public long pHa = 0;

    public final byte[] toByteArray() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(this.pGZ);
            dataOutputStream.writeLong(this.pHa);
            dataOutputStream.close();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final g aZ(byte[] bArr) {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        try {
            this.pGZ = dataInputStream.readLong();
            this.pHa = dataInputStream.readLong();
            dataInputStream.close();
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TimeInfo", e, "", new Object[0]);
        }
        return this;
    }
}
