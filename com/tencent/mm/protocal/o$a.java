package com.tencent.mm.protocal;

import com.tencent.mm.a.c;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class o$a extends d implements b {
    public int bOh = 0;
    public int bWA = 0;
    public int egS = 0;
    public String qWM = "";
    public byte[] qWN = new byte[0];

    private byte[] cgp() {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeInt(this.egS);
            dataOutputStream.writeShort(this.qWM.getBytes().length);
            dataOutputStream.write(this.qWM.getBytes());
            dataOutputStream.writeShort(this.qWN.length);
            dataOutputStream.write(this.qWN);
            dataOutputStream.close();
        } catch (IOException e) {
            x.e("MicroMsg.MMDirectSend", "direct merge tail failed, err=" + e.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] bm(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(this.bOh);
            dataOutputStream.writeByte(this.bWA);
            dataOutputStream.write(bArr);
            dataOutputStream.close();
        } catch (IOException e) {
            x.e("MicroMsg.MMDirectSend", "direct merge all failed, err=" + e.getMessage());
        }
        return byteArrayOutputStream.toByteArray();
    }

    public final byte[] Ie() {
        byte[] cgp = cgp();
        PByteArray pByteArray = new PByteArray();
        c.a(pByteArray, cgp, o.UA(this.qWv));
        return bm(pByteArray.value);
    }

    public final int If() {
        return 10;
    }

    public final int getCmdId() {
        return 8;
    }

    public final boolean cgo() {
        return true;
    }

    public final boolean LB() {
        return false;
    }
}
