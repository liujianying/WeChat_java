package com.tencent.mm.ar;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.n;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.protocal.c.sl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.aa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public final class j extends l implements n, k {
    private int bJE;
    private b diG;
    private e diJ;
    public int ecO;
    private int offset = 0;

    public j(int i, int i2) {
        this.ecO = i;
        this.bJE = i2;
        m bi = r.Qp().bi(i, i2);
        if (bi == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get info null, id:" + i);
            return;
        }
        bi.status = 3;
        bi.bWA = 64;
        r.Qp().b(bi);
        if (i2 == 5) {
            com.tencent.mm.a.e.deleteFile(g.Ei().cachePath + "brand_i18n.apk");
            return;
        }
        com.tencent.mm.a.e.deleteFile(n.Qm() + r.Qp().bk(i, i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.d("MicroMsg.NetSceneDownloadPackage", "dkregcode doScene pkgId:%d packageType:%d", new Object[]{Integer.valueOf(this.ecO), Integer.valueOf(this.bJE)});
        m bi = r.Qp().bi(this.ecO, this.bJE);
        if (bi == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme failed id:" + this.ecO + " type:" + this.bJE);
            return -1;
        } else if (bi.status != 3) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene get Theme stat failed id:" + this.ecO + " stat:" + bi.status);
            return -1;
        } else if (bi.size <= 0) {
            x.e("MicroMsg.NetSceneDownloadPackage", "doScene Theme size err id:" + this.ecO + " size:" + bi.size);
            return -1;
        } else {
            a aVar = new a();
            aVar.dIG = new sk();
            aVar.dIH = new sl();
            aVar.uri = "/cgi-bin/micromsg-bin/downloadpackage";
            aVar.dIF = 160;
            aVar.dII = 0;
            aVar.dIJ = 0;
            this.diG = aVar.KT();
            sk skVar = (sk) this.diG.dID.dIL;
            ayv ayv = new ayv();
            ayv.jTt = bi.id;
            ayv.hcD = bi.version;
            skVar.rvL = ayv;
            skVar.rjC = this.offset;
            skVar.rvM = 65536;
            skVar.hcE = this.bJE;
            return a(eVar, this.diG, this);
        }
    }

    protected final int a(q qVar) {
        sk skVar = (sk) ((b) qVar).dID.dIL;
        m bi = r.Qp().bi(this.ecO, this.bJE);
        if (bi == null) {
            x.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked get Theme failed id:" + this.ecO);
            return l.b.dJn;
        } else if (skVar.rvL.jTt == this.ecO && skVar.rjC == this.offset && skVar.rjC < bi.size && skVar.rvM == 65536 && bi.size > 0 && bi.status == 3) {
            return l.b.dJm;
        } else {
            x.e("MicroMsg.NetSceneDownloadPackage", "securityVerificationChecked Theme failed id:" + this.ecO);
            return l.b.dJn;
        }
    }

    protected final int Cc() {
        return 50;
    }

    protected final void a(l.a aVar) {
        r.Qp().bm(this.ecO, this.bJE);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd id:" + this.ecO + " + id:" + i + " errtype:" + i2 + " errCode:" + i3);
        if (i2 == 0 || i3 == 0) {
            sl slVar = (sl) ((b) qVar).dIE.dIL;
            if (slVar.hcE != this.bJE) {
                x.e("MicroMsg.NetSceneDownloadPackage", "packageType is not consistent");
                r.Qp().bm(this.ecO, this.bJE);
                this.diJ.a(3, -1, "", this);
                return;
            }
            byte[] a = ab.a(slVar.rvN);
            if (a == null || a.length == 0) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd get pkgBuf failed id:" + this.ecO);
                r.Qp().bm(this.ecO, this.bJE);
                this.diJ.a(3, -1, str, this);
                return;
            }
            m bi = r.Qp().bi(this.ecO, this.bJE);
            if (bi == null) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd info is null, pkgId = " + this.ecO);
                r.Qp().bm(this.ecO, this.bJE);
                this.diJ.a(3, -1, str, this);
                return;
            } else if (bi.size != slVar.rvO) {
                x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd totalSize is incorrect");
                r.Qp().bm(this.ecO, this.bJE);
                g.Eh().dpP.a(new k(this.bJE), 0);
                this.diJ.a(3, -1, str, this);
                return;
            } else {
                String str2;
                String str3;
                if (this.bJE == 5) {
                    str2 = g.Ei().cachePath;
                    str3 = "brand_i18n.apk";
                } else {
                    r.Qp();
                    str2 = n.Qm();
                    str3 = r.Qp().bk(this.ecO, this.bJE);
                }
                x.d("MicroMsg.NetSceneDownloadPackage", "packagePath " + str2);
                x.d("MicroMsg.NetSceneDownloadPackage", "packageName " + str3);
                int b = com.tencent.mm.a.e.b(str2, str3, a);
                if (b != 0) {
                    r.Qp().bm(this.ecO, this.bJE);
                    x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd write file fail, ret = " + b);
                    this.diJ.a(3, -1, str, this);
                    return;
                }
                this.offset = a.length + this.offset;
                if (this.offset >= bi.size) {
                    String bl;
                    boolean z = false;
                    if (this.bJE == 1) {
                        bl = r.Qp().bl(this.ecO, this.bJE);
                        b = bi.fR(str2 + str3, bl);
                        if (b < 0) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + b + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + bl);
                            r.Qp().bm(this.ecO, this.bJE);
                            this.diJ.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            z = true;
                        }
                    }
                    if (this.bJE == 8) {
                        z = as(str2, str3);
                    }
                    if (this.bJE == 23) {
                        if (bi.oW(str2) || bi.oW(str3)) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, packagePath: %s, packageName: %s", new Object[]{str2, str3});
                            r.Qp().bm(this.ecO, this.bJE);
                            this.diJ.a(3, 0, "open permission pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.y(str2 + str3, com.tencent.mm.compatible.util.e.duN + "permissioncfg.cfg")) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.Qp().bm(this.ecO, this.bJE);
                                this.diJ.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                z = true;
                            }
                        } else {
                            x.e("MicroMsg.NetSceneDownloadPackage", "update permission pkg failed, file no exist, path: %s, name: %s", new Object[]{str2, str3});
                            r.Qp().bm(this.ecO, this.bJE);
                            this.diJ.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.bJE == 7) {
                        z = true;
                    }
                    if (this.bJE == 9) {
                        z = true;
                    }
                    if (this.bJE == 5) {
                        z = true;
                        x.i("MicroMsg.NetSceneDownloadPackage", "resetResContextImp");
                    }
                    if (this.bJE == 12) {
                        mh mhVar = new mh();
                        mhVar.bWX.bWZ = str2 + str3;
                        com.tencent.mm.sdk.b.a.sFg.m(mhVar);
                        z = true;
                    }
                    if (this.bJE == 18) {
                        bl = r.Qp().bl(this.ecO, this.bJE);
                        b = bi.fR(str2 + str3, bl);
                        if (b < 0) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "unzip fail, ret = " + b + ", zipFilePath = " + str2 + str3 + ", unzipPath = " + bl);
                            r.Qp().bm(this.ecO, this.bJE);
                            this.diJ.a(3, 0, "unzip fail", this);
                            z = false;
                        } else {
                            x.i("MicroMsg.NetSceneDownloadPackage", "Unzip Path %s", new Object[]{bl});
                            z = true;
                        }
                    }
                    if (this.bJE == 20) {
                        z = true;
                    }
                    if (this.bJE == 21) {
                        z = true;
                    }
                    if (this.bJE == 26) {
                        if (bi.oW(str2) || bi.oW(str3)) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, packagePath: %s, packageName: %s", new Object[]{str2, str3});
                            this.diJ.a(3, 0, "open IPCallContryCodeConfigs pkg failed", this);
                            z = false;
                        } else if (new File(str2 + str3).exists()) {
                            if (-1 == com.tencent.mm.a.e.y(str2 + str3, com.tencent.mm.compatible.util.e.duN + "ipcallCountryCodeConfig.cfg")) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "copy file failed");
                                r.Qp().bm(this.ecO, this.bJE);
                                this.diJ.a(3, 0, "copy file failed", this);
                                z = false;
                            } else {
                                x.d("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg success");
                                z = true;
                            }
                        } else {
                            x.e("MicroMsg.NetSceneDownloadPackage", "updateIPCallContryCodeConfigPkg failed, file not exist, packagePath: %s, packageName: %s", new Object[]{str2, str3});
                            r.Qp().bm(this.ecO, this.bJE);
                            this.diJ.a(3, 0, "file not exist", this);
                            z = false;
                        }
                    }
                    if (this.bJE == 36) {
                        z = ar(str2, str3);
                    }
                    if (z) {
                        bi.status = 2;
                        bi.bWA = 64;
                        r.Qp().b(bi);
                        this.diJ.a(0, 0, "", this);
                        return;
                    }
                    return;
                } else if (a(this.dIX, this.diJ) < 0) {
                    r.Qp().bm(this.ecO, this.bJE);
                    this.diJ.a(3, -1, str, this);
                    return;
                } else {
                    return;
                }
            }
        }
        x.e("MicroMsg.NetSceneDownloadPackage", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
        r.Qp().bm(this.ecO, this.bJE);
        this.diJ.a(i2, i3, str, this);
    }

    private static boolean ar(String str, String str2) {
        Throwable e;
        boolean z = true;
        if (bi.oW(str) || bi.oW(str2)) {
            return false;
        }
        try {
            String str3 = str + str2;
            String ct = com.tencent.mm.a.e.ct(str3);
            if (bi.oW(ct)) {
                z = false;
            } else {
                g.Ei().DT().a(aa.a.sUb, ct);
            }
            try {
                com.tencent.mm.a.e.deleteFile(str3);
                x.i("MicroMsg.NetSceneDownloadPackage", "update sense where result[%b] filepath[%s] xml[%s] ", new Object[]{Boolean.valueOf(z), str3, bi.Xf(ct)});
                return z;
            } catch (IOException e2) {
                e = e2;
            }
        } catch (IOException e3) {
            e = e3;
            z = false;
            x.printErrStackTrace("MicroMsg.NetSceneDownloadPackage", e, "", new Object[0]);
            return z;
        }
    }

    private boolean as(String str, String str2) {
        Throwable e;
        Throwable th;
        String str3 = null;
        if (bi.oW(str) || bi.oW(str2)) {
            x.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, no file assigned, packagePath:" + str + " ,packageName:" + str2);
            r.Qp().bm(this.ecO, this.bJE);
            this.diJ.a(3, 0, "open regioncode file fail", this);
            return false;
        }
        File file = new File(str + str2);
        if (file.exists()) {
            Map hashMap = new HashMap();
            InputStream fileInputStream;
            try {
                fileInputStream = new FileInputStream(file);
                BufferedWriter bufferedWriter;
                try {
                    File file2;
                    Reader inputStreamReader = new InputStreamReader(fileInputStream, "utf-8");
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        String[] split = readLine.trim().split("\\|");
                        if (split.length < 2 || bi.oW(split[0]) || bi.oW(split[1])) {
                            x.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, error line = " + readLine);
                        } else {
                            bufferedWriter = (BufferedWriter) hashMap.get(split[0]);
                            if (bufferedWriter == null) {
                                RegionCodeDecoder.cmS();
                                str3 = RegionCodeDecoder.Zg(split[0]);
                                if (bi.oW(str3)) {
                                    x.e("MicroMsg.NetSceneDownloadPackage", "dispatch regioncode, output language unsupported");
                                } else {
                                    file2 = new File(str3);
                                    if (!file2.exists()) {
                                        file2.createNewFile();
                                    }
                                    bufferedWriter = new BufferedWriter(new FileWriter(file2));
                                    hashMap.put(split[0], bufferedWriter);
                                }
                            }
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(split[1]);
                            stringBuffer.append('|');
                            stringBuffer.append(split[2]);
                            stringBuffer.append(10);
                            bufferedWriter.write(stringBuffer.toString());
                        }
                    }
                    for (BufferedWriter bufferedWriter2 : hashMap.values()) {
                        if (bufferedWriter2 != null) {
                            bufferedWriter2.flush();
                        }
                    }
                    if (!bi.oW(str3)) {
                        for (File file22 : new File(str3).getParentFile().listFiles(new FileFilter() {
                            public final boolean accept(File file) {
                                return file.getName().endsWith("txt");
                            }
                        })) {
                            RegionCodeDecoder.cmS();
                            RegionCodeDecoder.h(file22, file22.getParentFile());
                        }
                        RegionCodeDecoder.cmS().ckJ();
                    }
                    bufferedReader.close();
                    inputStreamReader.close();
                    file.delete();
                    try {
                        fileInputStream.close();
                        for (BufferedWriter bufferedWriter22 : hashMap.values()) {
                            if (bufferedWriter22 != null) {
                                bufferedWriter22.close();
                            }
                        }
                    } catch (Throwable e2) {
                        x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e2)});
                    }
                    return true;
                } catch (Exception e3) {
                    e2 = e3;
                    try {
                        x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e2)});
                        r.Qp().bm(this.ecO, this.bJE);
                        this.diJ.a(3, 0, e2.getMessage(), this);
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e22) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e22)});
                                return false;
                            }
                        }
                        for (BufferedWriter bufferedWriter222 : hashMap.values()) {
                            if (bufferedWriter222 != null) {
                                bufferedWriter222.close();
                            }
                        }
                        return false;
                    } catch (Throwable e222) {
                        th = e222;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable e2222) {
                                x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e2222)});
                                throw th;
                            }
                        }
                        for (BufferedWriter bufferedWriter2222 : hashMap.values()) {
                            if (bufferedWriter2222 != null) {
                                bufferedWriter2222.close();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e4) {
                e2222 = e4;
                fileInputStream = null;
                x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e2222)});
                r.Qp().bm(this.ecO, this.bJE);
                this.diJ.a(3, 0, e2222.getMessage(), this);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e22222) {
                        x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e22222)});
                        return false;
                    }
                }
                for (BufferedWriter bufferedWriter22222 : hashMap.values()) {
                    if (bufferedWriter22222 != null) {
                        bufferedWriter22222.close();
                    }
                }
                return false;
            } catch (Throwable e222222) {
                th = e222222;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable e2222222) {
                        x.e("MicroMsg.NetSceneDownloadPackage", "exception:%s", new Object[]{bi.i(e2222222)});
                        throw th;
                    }
                }
                for (BufferedWriter bufferedWriter222222 : hashMap.values()) {
                    if (bufferedWriter222222 != null) {
                        bufferedWriter222222.close();
                    }
                }
                throw th;
            }
        }
        x.e("MicroMsg.NetSceneDownloadPackage", "update regioncode failed, file not exist, packagePath:" + str + " ,packageName:" + str2);
        r.Qp().bm(this.ecO, this.bJE);
        this.diJ.a(3, 0, "no regioncode file found", this);
        return false;
    }

    public final int getType() {
        return 160;
    }

    public final int Lf() {
        return this.bJE;
    }
}
