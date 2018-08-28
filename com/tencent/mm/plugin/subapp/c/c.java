package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import junit.framework.Assert;

public final class c {
    private RandomAccessFile aBA = null;
    private String fileName = "";

    public c(String str) {
        this.fileName = str;
    }

    public static int nM(String str) {
        Assert.assertTrue(str.length() >= 0);
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        int length = (int) file.length();
        if (length > 0) {
            return length;
        }
        return 0;
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

    public final a xU(int i) {
        a aVar = new a();
        if (i < 0) {
            aVar.ret = -3;
        } else if (this.aBA != null || od("r")) {
            aVar.buf = new byte[6000];
            try {
                long length = this.aBA.length();
                this.aBA.seek((long) i);
                int read = this.aBA.read(aVar.buf, 0, 6000);
                x.d("MicroMsg.SpxFileOperator", "DBG: ReadFile[" + this.fileName + "] readOffset:" + i + " readRet:" + read + " fileNow:" + this.aBA.getFilePointer() + " fileSize:" + length);
                if (read < 0) {
                    read = 0;
                }
                aVar.bEG = read;
                aVar.eon = read + i;
                aVar.ret = 0;
            } catch (Exception e) {
                x.e("MicroMsg.SpxFileOperator", "ERR: ReadFile[" + this.fileName + "] Offset:" + i + "  failed:[" + e.getMessage() + "] ");
                Tz();
                aVar.ret = -1;
            }
        } else {
            aVar.ret = -2;
        }
        return aVar;
    }
}
