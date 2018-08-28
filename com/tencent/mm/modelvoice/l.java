package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class l implements b {
    private RandomAccessFile aBA = null;
    private String fileName = "";

    public l(String str) {
        this.fileName = str;
    }

    public final void Tz() {
        if (this.aBA != null) {
            try {
                this.aBA.close();
                this.aBA = null;
                x.d("MicroMsg.SpxFileOperator", "Close :" + this.fileName);
            } catch (IOException e) {
            }
        }
    }

    private boolean od(String str) {
        boolean z;
        Assert.assertTrue(this.fileName.length() >= 0);
        if (this.aBA == null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (str.equals("r") || str.equals("rw")) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.SpxFileOperator", "Open file:" + this.aBA + " mode:" + str);
        try {
            this.aBA = new RandomAccessFile(this.fileName, str);
            return true;
        } catch (Exception e) {
            x.e("MicroMsg.SpxFileOperator", "ERR: OpenFile[" + this.fileName + "] failed:[" + e.getMessage() + "]");
            this.aBA = null;
            return false;
        }
    }

    public final g br(int i, int i2) {
        g gVar = new g();
        if (i < 0 || i2 <= 0) {
            gVar.ret = -3;
        } else if (this.aBA != null || od("r")) {
            gVar.buf = new byte[i2];
            try {
                long length = this.aBA.length();
                this.aBA.seek((long) i);
                int read = this.aBA.read(gVar.buf, 0, i2);
                x.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.aBA.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                gVar.bEG = read;
                gVar.eon = read + i;
                gVar.ret = 0;
            } catch (Exception e) {
                x.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                Tz();
                gVar.ret = -1;
            }
        } else {
            gVar.ret = -2;
        }
        return gVar;
    }

    public final int write(byte[] bArr, int i, int i2) {
        boolean z = true;
        boolean z2 = bArr.length > 0 && i > 0;
        Assert.assertTrue(z2);
        if (this.aBA == null && !od("rw")) {
            return -1;
        }
        try {
            this.aBA.seek((long) i2);
            this.aBA.write(bArr, 0, i);
            int i3 = i2 + i;
            if (((int) this.aBA.getFilePointer()) == i3) {
                z2 = true;
            } else {
                z2 = false;
            }
            Assert.assertTrue(z2);
            if (i3 < 0) {
                z = false;
            }
            Assert.assertTrue(z);
            return i3;
        } catch (Exception e) {
            x.e("MicroMsg.SpxFileOperator", "ERR: WriteFile[" + this.fileName + "] Offset:" + i2 + " failed:[" + e.getMessage() + "]");
            Tz();
            return -3;
        }
    }

    public final int getFormat() {
        return 1;
    }
}
