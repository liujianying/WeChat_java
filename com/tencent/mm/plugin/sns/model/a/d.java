package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsfs.f;
import com.tencent.mm.network.u;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.a.c.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.3;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.io.OutputStream;

public final class d extends b {
    private long ntk = 0;
    private int ntl = 0;

    public d(a aVar, a aVar2) {
        super(aVar, aVar2);
    }

    public final String MJ(String str) {
        return str;
    }

    public final boolean byZ() {
        return false;
    }

    public final u b(u uVar) {
        this.ntk = 0;
        if (this.ntk > 0) {
            x.i("MicroMsg.SnsDownloadAdSight", "appendHttpArg range " + this.ntk);
            uVar.setRequestProperty("RANGE", "bytes=" + this.ntk + "-");
        }
        return uVar;
    }

    public final boolean u(InputStream inputStream) {
        OutputStream outputStream = null;
        try {
            byte[] bArr = new byte[1024];
            String str = this.nsN.getPath() + this.nsN.byY();
            x.i("MicroMsg.SnsDownloadAdSight", "getdatabegin " + FileOp.mI(f.mQ(str)));
            outputStream = FileOp.mG(str);
            int i = 1;
            long currentTimeMillis = System.currentTimeMillis();
            this.nsY.value = "";
            Object obj = null;
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    if (this.ntb == 0) {
                        this.ntb = bi.bH(this.ntc);
                    }
                    if (read > this.nsZ) {
                        this.nsZ = read;
                        this.nta = bi.VE();
                    }
                    if (i.LM(af.Gq())) {
                        outputStream.write(bArr, 0, read);
                        this.nth += read;
                        if (this.nth - this.ntl > 409600 * i) {
                            af.aRu().post(new 3(af.byj(), this.nsN.mediaId, str));
                            this.ntl = this.nth;
                            i++;
                        }
                        obj = 1;
                        if (b.a(this.nth, currentTimeMillis, this.nsY)) {
                            currentTimeMillis = System.currentTimeMillis();
                            obj = null;
                        }
                    } else {
                        x.i("MicroMsg.SnsDownloadAdSight", "read data");
                        outputStream.close();
                        inputStream.close();
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e, "", new Object[0]);
                            }
                        }
                        return false;
                    }
                }
                outputStream.close();
                if (obj != null) {
                    b.a(this.nth, 0, this.nsY);
                }
                x.i("MicroMsg.SnsDownloadAdSight", "getdataend2  " + FileOp.mI(this.nsN.getPath() + this.nsN.byY()));
                return true;
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "snscdndownload fail : " + e2.getMessage(), new Object[0]);
            x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e2, "", new Object[0]);
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e22) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e22, "", new Object[0]);
                }
            }
            return false;
        } catch (Throwable th) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Throwable e3) {
                    x.printErrStackTrace("MicroMsg.SnsDownloadAdSight", e3, "", new Object[0]);
                }
            }
        }
    }

    public final boolean bza() {
        long mI = FileOp.mI(this.nsN.getPath() + this.nsN.byY());
        x.i("MicroMsg.SnsDownloadAdSight", "preceeData  downloadLen " + mI + " " + this.nte);
        if (mI < ((long) this.nte) + this.ntk) {
            return false;
        }
        FileOp.i(this.nsN.getPath(), this.nsN.byY(), i.k(this.caK));
        return true;
    }

    protected final int bzb() {
        return 4;
    }
}
