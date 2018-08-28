package com.tencent.mm.protocal;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class o$b extends e implements c {
    private int bOh;
    private int bWA;
    public byte[] content;
    public String deviceID;
    public String eeZ;
    private int egS;

    public o$b() {
        this.eeZ = "";
        this.content = new byte[0];
        this.deviceID = "";
        this.bOh = 0;
        this.bWA = 0;
        this.egS = 0;
        this.eeZ = "";
        this.content = new byte[0];
    }

    public final int getCmdId() {
        return 8;
    }

    public final boolean cgo() {
        return true;
    }

    private byte[] bn(byte[] bArr) {
        if (bArr == null || bArr.length < 2) {
            x.e("MicroMsg.MMDirectSend", "parse all failed, empty buf");
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length - 2)];
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            this.bOh = dataInputStream.readByte();
            this.bWA = dataInputStream.readByte();
            dataInputStream.readFully(bArr2);
            x.d("MicroMsg.MMDirectSend", "cmdId:" + this.bOh + ", flag=" + this.bWA + ", tail len=" + bArr2.length);
            byteArrayInputStream.close();
            return bArr2;
        } catch (IOException e) {
            x.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
            return bArr2;
        }
    }

    public final int G(byte[] bArr) {
        byte[] UA = o.UA(this.deviceID);
        PByteArray pByteArray = new PByteArray();
        if (com.tencent.mm.a.c.b(pByteArray, bn(bArr), UA) != 0) {
            byte[] bArr2 = new byte[16];
            for (int i = 0; i < 16; i++) {
                bArr2[i] = (byte) 0;
            }
            if (com.tencent.mm.a.c.b(pByteArray, bn(bArr), bArr2) != 0) {
                x.e("MicroMsg.MMDirectSend", "decrypting from buffer using key=%s error", new Object[]{bi.bB(UA)});
                return -1;
            }
        }
        byte[] bArr3 = pByteArray.value;
        if (bArr3 == null) {
            x.e("MicroMsg.MMDirectSend", "parse tail failed, empty buf");
            return 0;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr3));
            this.egS = dataInputStream.readInt();
            x.d("MicroMsg.MMDirectSend", "seq=" + this.egS);
            short readShort = dataInputStream.readShort();
            if (readShort < (short) 0) {
                throw new IOException("sender empty");
            }
            byte[] bArr4 = new byte[readShort];
            dataInputStream.readFully(bArr4);
            this.eeZ = new String(bArr4);
            x.d("MicroMsg.MMDirectSend", "recievers len=" + readShort + ", sender=" + this.eeZ);
            readShort = dataInputStream.readShort();
            if (readShort < (short) 0) {
                throw new IOException("content empty");
            }
            this.content = new byte[readShort];
            dataInputStream.readFully(this.content);
            x.d("MicroMsg.MMDirectSend", "content len=" + this.content.length);
            return 0;
        } catch (IOException e) {
            x.e("MicroMsg.MMDirectSend", "direct parse all failed, err=" + e.getMessage());
            return 0;
        }
    }
}
