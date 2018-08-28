package com.tencent.mm.model;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.x;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public final class cb {
    public static boolean dDE = false;
    private static cb dDH = null;
    private ArrayList<String> dDF = new ArrayList();
    private String dDG = "";

    public cb(String str, boolean z) {
        Throwable e;
        RandomAccessFile randomAccessFile;
        try {
            this.dDG = str + "version_history.cfg";
            randomAccessFile = new RandomAccessFile(this.dDG, "rw");
            try {
                String format;
                long length = randomAccessFile.length();
                x.i("MicroMsg.VersionHistory", "init fileLen:%d isNewAcc:%b curVer:0x%x path:%s", Long.valueOf(length), Boolean.valueOf(z), Integer.valueOf(d.qVN), this.dDG);
                if (length <= 0 || length > 10240) {
                    randomAccessFile.seek(0);
                    if (!z) {
                        format = String.format("%x", new Object[]{Integer.valueOf(536870913)});
                        randomAccessFile.write((format + "\n").getBytes());
                        this.dDF.add(format);
                    }
                } else {
                    while (randomAccessFile.getFilePointer() < length) {
                        format = bi.aG(randomAccessFile.readLine(), "");
                        if (format.length() != 8) {
                            x.e("MicroMsg.VersionHistory", "Read ver history failed , line len:%d path:%s", Integer.valueOf(format.length()), this.dDG);
                        } else if (format.startsWith("2")) {
                            this.dDF.add(format);
                        } else {
                            x.e("MicroMsg.VersionHistory", "Read ver history failed , line:%s %s", format, this.dDG);
                        }
                    }
                }
                format = String.format("%x", new Object[]{Integer.valueOf(d.qVN)});
                if (this.dDF.size() == 0 || !format.equals(this.dDF.get(this.dDF.size() - 1))) {
                    dDE = true;
                    this.dDF.add(format);
                    randomAccessFile.seek(length);
                    randomAccessFile.write((format + "\n").getBytes());
                }
                String str2 = "";
                for (int i = 0; i < this.dDF.size(); i++) {
                    str2 = str2 + ((String) this.dDF.get(i)) + ";";
                }
                x.i("MicroMsg.VersionHistory", "Read succ isupdate:%b ver:%s file:%s", Boolean.valueOf(dDE), str2, this.dDG);
                try {
                    randomAccessFile.close();
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.VersionHistory", e2, "Close Version History file failed.", "");
                }
            } catch (Exception e3) {
                e2 = e3;
                try {
                    x.printErrStackTrace("MicroMsg.VersionHistory", e2, "Open Version History file failed.", "");
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.VersionHistory", e22, "Close Version History file failed.", "");
                    }
                    if (dDH != null) {
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    e22 = th;
                    try {
                        randomAccessFile.close();
                    } catch (Throwable e4) {
                        x.printErrStackTrace("MicroMsg.VersionHistory", e4, "Close Version History file failed.", "");
                    }
                    throw e22;
                }
            }
        } catch (Exception e5) {
            e22 = e5;
            randomAccessFile = null;
            x.printErrStackTrace("MicroMsg.VersionHistory", e22, "Open Version History file failed.", "");
            randomAccessFile.close();
            if (dDH != null) {
                return;
            }
            return;
        } catch (Throwable th2) {
            e22 = th2;
            randomAccessFile = null;
            randomAccessFile.close();
            throw e22;
        }
        if (dDH != null && dDH != this && dDH.dDF.size() < this.dDF.size()) {
            dDH.dDF = this.dDF;
            j.q(this.dDG, dDH.dDG, false);
        }
    }

    public static void iO(String str) {
        dDH = new cb(str, true);
    }

    public static String IT() {
        if (dDH == null) {
            return "";
        }
        cb cbVar = dDH;
        String str = "";
        int size = 4 >= cbVar.dDF.size() ? 0 : cbVar.dDF.size() - 4;
        while (size < cbVar.dDF.size()) {
            size++;
            str = str + ((String) cbVar.dDF.get(size)) + ";";
        }
        return str;
    }
}
