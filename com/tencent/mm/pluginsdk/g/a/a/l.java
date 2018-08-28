package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.a.g;
import com.tencent.mm.a.q;
import com.tencent.mm.jni.utils.UtilsJni;
import com.tencent.mm.plugin.game.f$k;
import com.tencent.mm.pluginsdk.g.a.d.a;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

final class l {
    private final int bIC;
    private final int bID;
    private final int bIE;
    private final boolean bIF;
    private final boolean bIJ;
    final String filePath;
    private final String qBB;
    private final int qBC;
    private final byte[] qBD;
    private final String qBE;
    private final long qBG;
    private final String qBH;
    private final int qBI;
    private final int qBJ;
    final String qBy;
    volatile String qCH = null;
    volatile String qCI = null;
    final boolean qCf;
    final boolean qCg;
    volatile int state = -1;
    private final String url;

    l(int i, int i2, String str, boolean z, boolean z2, String str2, int i3, boolean z3, boolean z4, byte[] bArr, String str3, String str4, long j, String str5, int i4, int i5, int i6) {
        this.qBy = i.ex(i, i2);
        this.bIC = i;
        this.bID = i2;
        this.filePath = str;
        this.qCg = z;
        this.qCf = z2;
        this.qBB = str2;
        this.qBC = i3;
        this.qBD = bArr;
        this.qBE = str3;
        this.bIJ = z3;
        this.bIF = z4;
        this.qBH = str4;
        this.qBG = j;
        this.url = str5;
        this.qBI = i4;
        this.qBJ = i5;
        this.bIE = i6;
    }

    final l ccw() {
        Throwable e;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), file_state = %s, before do decrypt, inPath = %s, outPath = %s, (key == empty) = %b", new Object[]{this.qBy, ccz(), this.qCH, this.qCI, Boolean.valueOf(bi.oW(this.qBB))});
        if (1 == this.state) {
            if (bi.oW(this.qBB)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), invalid encrypt key", new Object[]{this.qBy});
                this.qCH = null;
                this.state = 8;
                j.n(this.qBG, 54);
                j.n(this.qBG, 45);
            } else {
                boolean z;
                try {
                    String str = this.qCH;
                    String str2 = this.qCI;
                    String str3 = this.qBB;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file = new File(str2);
                        file.getParentFile().mkdirs();
                        file.delete();
                        byte[] Tq = a.Tq(str);
                        if (bi.bC(Tq)) {
                            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "read bytes empty");
                            j.n(this.qBG, 56);
                            j.n(this.qBG, 45);
                            j.n(this.qBG, 18);
                            z = false;
                        } else {
                            Tq = MMProtocalJni.aesDecrypt(Tq, str3.getBytes());
                            if (bi.bC(Tq)) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypted bytes empty");
                                j.n(this.qBG, 55);
                                j.n(this.qBG, 45);
                                j.n(this.qBG, 18);
                                z = false;
                            } else {
                                z = a.v(str2, Tq);
                                if (!z) {
                                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "decrypt write bytes fail");
                                    j.n(this.qBG, 57);
                                    j.n(this.qBG, 45);
                                    j.n(this.qBG, 18);
                                }
                            }
                        }
                    } else {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[]{str});
                        z = false;
                    }
                    try {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), decrypt done, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                    } catch (Exception e2) {
                        e = e2;
                        x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[]{this.qBy, e});
                        j.n(this.qBG, 45);
                        j.n(this.qBG, 18);
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                        if (z) {
                            j.n(this.qBG, 17);
                            this.qCH = this.qCI;
                            if (this.qCf) {
                                this.qCI = this.filePath + ".decompressed";
                                this.state = 2;
                            } else {
                                this.state = 4;
                            }
                        } else {
                            this.qCH = null;
                            this.state = 8;
                        }
                        return this;
                    }
                } catch (Exception e3) {
                    e = e3;
                    z = false;
                    x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), error = %s", new Object[]{this.qBy, e});
                    j.n(this.qBG, 45);
                    j.n(this.qBG, 18);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                    if (z) {
                        j.n(this.qBG, 17);
                        this.qCH = this.qCI;
                        if (this.qCf) {
                            this.qCI = this.filePath + ".decompressed";
                            this.state = 2;
                        } else {
                            this.state = 4;
                        }
                    } else {
                        this.qCH = null;
                        this.state = 8;
                    }
                    return this;
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decrypt(), after try-catch, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                if (z) {
                    this.qCH = null;
                    this.state = 8;
                } else {
                    j.n(this.qBG, 17);
                    this.qCH = this.qCI;
                    if (this.qCf) {
                        this.qCI = this.filePath + ".decompressed";
                        this.state = 2;
                    } else {
                        this.state = 4;
                    }
                }
            }
        }
        return this;
    }

    final l ccx() {
        Throwable e;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), file_state = %s, before do decompress, inPath = %s, outPath = %s", new Object[]{this.qBy, ccz(), this.qCH, this.qCI});
        if (2 == this.state) {
            boolean z;
            try {
                String str = this.qCH;
                String str2 = this.qCI;
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    new File(str2).delete();
                    byte[] x = q.x(a.Tq(str));
                    if (bi.bC(x)) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "uncompressed bytes empty");
                        z = false;
                    } else {
                        z = a.v(str2, x);
                    }
                } else {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "inFile(%s) not exists", new Object[]{str});
                    z = false;
                }
                try {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), decompress done, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                } catch (Exception e2) {
                    e = e2;
                    x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[]{this.qBy, e});
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                    if (z) {
                        this.qCH = this.qCI;
                        this.state = 4;
                        j.n(this.qBG, 19);
                    } else {
                        this.qCH = null;
                        this.state = 8;
                        j.n(this.qBG, 20);
                        j.n(this.qBG, 46);
                        if (this.qCg) {
                            j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, false, false, this.qBH);
                        } else if (this.qCf && this.bIF) {
                            j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, false, this.bIJ, false, this.qBH);
                        }
                    }
                    return this;
                }
            } catch (Exception e3) {
                e = e3;
                z = false;
                x.printErrStackTrace("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", e, "", new Object[0]);
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), error = %s", new Object[]{this.qBy, e});
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
                if (z) {
                    this.qCH = null;
                    this.state = 8;
                    j.n(this.qBG, 20);
                    j.n(this.qBG, 46);
                    if (this.qCg) {
                        j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, false, false, this.qBH);
                    } else if (this.qCf && this.bIF) {
                        j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, false, this.bIJ, false, this.qBH);
                    }
                } else {
                    this.qCH = this.qCI;
                    this.state = 4;
                    j.n(this.qBG, 19);
                }
                return this;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: decompress(), after try-catch, ret = %b", new Object[]{this.qBy, Boolean.valueOf(z)});
            if (z) {
                this.qCH = this.qCI;
                this.state = 4;
                j.n(this.qBG, 19);
            } else {
                this.qCH = null;
                this.state = 8;
                j.n(this.qBG, 20);
                j.n(this.qBG, 46);
                if (this.qCg) {
                    j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, false, false, this.qBH);
                } else if (this.qCf && this.bIF) {
                    j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, false, this.bIJ, false, this.qBH);
                }
            }
        } else if (8 == this.state && this.qCg) {
            j.a(this.bIC, this.bID, this.qBC, this.bIJ, false, false, false, this.qBH);
        }
        return this;
    }

    final String ccy() {
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSum(), state " + ccz(), new Object[]{this.qBy});
        if (16 == this.state) {
            return this.qCH;
        }
        if (4 != this.state && 32 != this.state) {
            return null;
        }
        String str;
        if (!bi.oW(this.qCH)) {
            String str2;
            String str3 = "MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer";
            String str4 = "%s: checkSumImpl(), state = %s, originalMd5 = %s, eccSig.size = %s";
            Object[] objArr = new Object[4];
            objArr[0] = this.qBy;
            objArr[1] = ccz();
            objArr[2] = this.qBE;
            if (this.qBD == null) {
                str2 = "null";
            } else {
                str2 = String.valueOf(this.qBD.length);
            }
            objArr[3] = str2;
            x.i(str3, str4, objArr);
            if (bi.oW(this.qBE) || !bi.oV(g.cu(this.qCH)).equals(this.qBE)) {
                if (this.state == 4) {
                    j.n(this.qBG, 24);
                }
                if (!bi.bC(this.qBD) && UtilsJni.doEcdsaSHAVerify(i.qCi, a.Tq(this.qCH), this.qBD) > 0) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, ecc check ok", new Object[]{this.qBy, ccz()});
                    if (this.state == 4) {
                        j.n(this.qBG, 25);
                    }
                    str = this.qCH;
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[]{this.qBy, str});
                    if (this.state == 4) {
                        return str;
                    }
                    if (bi.oW(str) && !this.qCf) {
                        j.n(this.qBG, 58);
                        j.n(this.qBG, 45);
                    }
                    if (bi.oW(str)) {
                        if (this.qCg) {
                            j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, true, false, this.qBH);
                            return str;
                        } else if (!this.qCf || !this.bIF) {
                            return str;
                        } else {
                            j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, false, this.bIJ, true, this.qBH);
                            return str;
                        }
                    } else if (this.qCg) {
                        j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, true, true, this.qBH);
                        return str;
                    } else if (!this.qCf || !this.bIF) {
                        return str;
                    } else {
                        j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, true, this.bIJ, true, this.qBH);
                        return str;
                    }
                } else if (this.state == 4) {
                    j.n(this.qBG, 26);
                }
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl(), state = %s, md5 ok", new Object[]{this.qBy, ccz()});
                if (this.state == 4) {
                    j.n(this.qBG, 23);
                }
                str = this.qCH;
                x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[]{this.qBy, str});
                if (this.state == 4) {
                    return str;
                }
                if (bi.oW(str) && !this.qCf) {
                    j.n(this.qBG, 58);
                    j.n(this.qBG, 45);
                }
                if (bi.oW(str)) {
                    if (this.qCg) {
                        j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, true, false, this.qBH);
                        return str;
                    } else if (!this.qCf || !this.bIF) {
                        return str;
                    } else {
                        j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, false, this.bIJ, true, this.qBH);
                        return str;
                    }
                } else if (this.qCg) {
                    j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, true, true, this.qBH);
                    return str;
                } else if (!this.qCf || !this.bIF) {
                    return str;
                } else {
                    j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, true, this.bIJ, true, this.qBH);
                    return str;
                }
            }
        }
        str = null;
        x.i("MicroMsg.ResDownloader.CheckResUpdate.FileDecryptPerformer", "%s: checkSumImpl return = %s", new Object[]{this.qBy, str});
        if (this.state == 4) {
            return str;
        }
        if (bi.oW(str) && !this.qCf) {
            j.n(this.qBG, 58);
            j.n(this.qBG, 45);
        }
        if (bi.oW(str)) {
            if (this.qCg) {
                j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, true, false, this.qBH);
                return str;
            } else if (!this.qCf || !this.bIF) {
                return str;
            } else {
                j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, false, this.bIJ, true, this.qBH);
                return str;
            }
        } else if (this.qCg) {
            j.a(this.bIC, this.bID, this.qBC, this.bIJ, true, true, true, this.qBH);
            return str;
        } else if (!this.qCf || !this.bIF) {
            return str;
        } else {
            j.a(this.bIC, this.bID, this.url, this.bIE, this.qBI > this.qBJ ? j.a.qCz : j.a.qCx, true, this.bIJ, true, this.qBH);
            return str;
        }
    }

    final String ccz() {
        switch (this.state) {
            case 1:
                return "state_decrypt";
            case 2:
                return "state_decompress";
            case 4:
                return "state_check_sum";
            case 8:
                return "state_file_invalid";
            case 16:
                return "state_file_valid";
            case f$k.AppCompatTheme_actionModeCutDrawable /*32*/:
                return "state_pre_verify_check_sum";
            default:
                return this.state;
        }
    }
}
