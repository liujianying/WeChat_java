package com.tencent.mm.model.d;

import com.tencent.mm.bv.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class b$3 implements Runnable {
    final /* synthetic */ b dFo;
    final /* synthetic */ String dFp;

    public b$3(b bVar, String str) {
        this.dFo = bVar;
        this.dFp = str;
    }

    public final void run() {
        Throwable e;
        b bVar = this.dFo;
        String str = b.bO() + "MMSQL.trace";
        String str2 = this.dFp + "\n";
        if (f.zZ()) {
            File file;
            try {
                file = new File(b.dFe);
                if (!file.exists()) {
                    file.mkdirs();
                }
                bVar.b(new File(b.dFe, "MMSQL.trace"), false);
            } catch (Exception e2) {
                x.e("MicroMsg.SQLTraceManager", "init dir fail");
            }
            file = new File(str);
            if (file.length() > bVar.dFj) {
                x.e("MicroMsg.SQLTraceManager", "log file invaild foramt,recreate");
                bVar.b(file, true);
            }
            RandomAccessFile randomAccessFile;
            try {
                randomAccessFile = new RandomAccessFile(str, "rw");
                try {
                    randomAccessFile.seek(randomAccessFile.length());
                    randomAccessFile.write(e.bF(str2.getBytes()));
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e3) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                    }
                } catch (IOException e4) {
                    e3 = e4;
                    try {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e3, "appendToFile fail with exception", new Object[0]);
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e32) {
                                x.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                            }
                        }
                        bVar.q(new File(b.dFe + "MMSQL.trace"));
                        return;
                    } catch (Throwable th) {
                        e32 = th;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.SQLTraceManager", e5, "appendToFile fail with exception", new Object[0]);
                            }
                        }
                        throw e32;
                    }
                }
            } catch (IOException e6) {
                e32 = e6;
                randomAccessFile = null;
                x.printErrStackTrace("MicroMsg.SQLTraceManager", e32, "appendToFile fail with exception", new Object[0]);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e322) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e322, "appendToFile fail with exception", new Object[0]);
                    }
                }
                bVar.q(new File(b.dFe + "MMSQL.trace"));
                return;
            } catch (Throwable th2) {
                e322 = th2;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e52) {
                        x.printErrStackTrace("MicroMsg.SQLTraceManager", e52, "appendToFile fail with exception", new Object[0]);
                    }
                }
                throw e322;
            }
            bVar.q(new File(b.dFe + "MMSQL.trace"));
            return;
        }
        x.i("MicroMsg.SQLTraceManager", "sdcard is not  Available,appendToFile fail ");
    }
}
