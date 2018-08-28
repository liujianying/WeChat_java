package com.tencent.mm.aa;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.k;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bvy;
import com.tencent.mm.protocal.c.bvz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.io.IOException;
import java.io.OutputStream;

public final class n extends l implements k {
    private String bSw;
    private int dHI;
    private int dHJ;
    private int dHK;
    private String dIa;
    private String dIb;
    private String dIc = q.GF();
    private e diJ;

    private static int af(String str, String str2) {
        int intValue;
        int intValue2;
        Options options;
        Bitmap decodeFile;
        int i = 1080;
        int i2 = 50;
        Options VZ = c.VZ(str);
        if (VZ.outHeight >= 640 || VZ.outWidth >= 640) {
            int indexOf;
            try {
                if (ao.isWifi(ad.getContext())) {
                    i2 = bi.getInt(((a) g.l(a.class)).AT().getValue("HeadImageCompressPicLevelForWifi"), 50);
                } else if (ao.is2G(ad.getContext())) {
                    i2 = bi.getInt(((a) g.l(a.class)).AT().getValue("HeadImageCompressPicLevelFor2G"), 50);
                } else if (ao.is3G(ad.getContext())) {
                    i2 = bi.getInt(((a) g.l(a.class)).AT().getValue("HeadImageCompressPicLevelFor3G"), 50);
                } else {
                    i2 = bi.getInt(((a) g.l(a.class)).AT().getValue("HeadImageCompressPicLevelFor4G"), 50);
                }
            } catch (Exception e) {
            }
            try {
                String value;
                if (ao.isWifi(ad.getContext())) {
                    value = ((a) g.l(a.class)).AT().getValue("HeadImageCompressResolutionForWifi");
                } else if (ao.is2G(ad.getContext())) {
                    value = ((a) g.l(a.class)).AT().getValue("HeadImageCompressResolutionFor2G");
                } else if (ao.is3G(ad.getContext())) {
                    value = ((a) g.l(a.class)).AT().getValue("HeadImageCompressResolutionFor3G");
                } else {
                    value = ((a) g.l(a.class)).AT().getValue("HeadImageCompressResolutionFor4G");
                }
                indexOf = value.indexOf("*");
                if (-1 != indexOf) {
                    intValue = Integer.valueOf(value.substring(0, indexOf)).intValue();
                    try {
                        intValue2 = Integer.valueOf(value.substring(indexOf + 1)).intValue();
                    } catch (Exception e2) {
                    }
                } else {
                    intValue2 = 1080;
                    intValue = 0;
                }
            } catch (Exception e3) {
                intValue = 0;
                intValue2 = 1080;
                if (intValue > 0) {
                }
                if (intValue2 >= 2160) {
                    intValue = 0;
                } else if (intValue2 > 0 || intValue <= 3240) {
                    i = intValue2;
                } else {
                    i = 0;
                    intValue = 1620;
                }
                intValue2 = VZ.outWidth <= VZ.outHeight ? VZ.outHeight : VZ.outWidth;
                indexOf = VZ.outWidth >= VZ.outHeight ? VZ.outHeight : VZ.outWidth;
                x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight));
                if (i <= 0) {
                    indexOf = intValue2 / intValue;
                    i = (VZ.outWidth * intValue) / intValue2;
                    intValue2 = (VZ.outHeight * intValue) / intValue2;
                } else {
                    intValue = indexOf / i;
                    intValue2 = (VZ.outHeight * i) / indexOf;
                    i = (i * VZ.outWidth) / indexOf;
                    indexOf = intValue;
                }
                if (intValue2 * i > 10240000) {
                    double sqrt = Math.sqrt(1.024E7d / ((double) (intValue2 * i)));
                    intValue2 = (int) (((double) intValue2) / sqrt);
                    i = (int) (((double) i) / sqrt);
                }
                options = new Options();
                options.inPreferredConfig = Config.ARGB_8888;
                if (indexOf >= 2) {
                    options.inSampleSize = indexOf;
                }
                decodeFile = c.decodeFile(str, options);
                if (decodeFile != null) {
                    Bitmap createScaledBitmap;
                    x.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
                    if (indexOf > 1) {
                        createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i, intValue2, true);
                        if (decodeFile != createScaledBitmap) {
                            x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                            decodeFile.recycle();
                        }
                        if (createScaledBitmap == null) {
                            x.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                            return 0 - com.tencent.mm.compatible.util.g.getLine();
                        }
                    }
                    createScaledBitmap = decodeFile;
                    OutputStream outputStream = null;
                    try {
                        outputStream = FileOp.jx(str2);
                        createScaledBitmap.compress(CompressFormat.JPEG, i2, outputStream);
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e4) {
                            }
                        }
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap.toString(), Long.valueOf(FileOp.mI(str)), Long.valueOf(FileOp.mI(str2)));
                        createScaledBitmap.recycle();
                        return 0;
                    } catch (Throwable e5) {
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                        x.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", bi.i(e5));
                        x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap.toString());
                        createScaledBitmap.recycle();
                        int line = 0 - com.tencent.mm.compatible.util.g.getLine();
                        if (outputStream == null) {
                            return line;
                        }
                        try {
                            outputStream.close();
                            return line;
                        } catch (IOException e6) {
                            return line;
                        }
                    } catch (Throwable th) {
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (IOException e7) {
                            }
                        }
                    }
                } else {
                    x.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(options.inSampleSize));
                    return 0 - com.tencent.mm.compatible.util.g.getLine();
                }
            }
            if (intValue > 0 && intValue2 <= 0) {
                intValue = 0;
            } else if (intValue2 >= 2160) {
                intValue = 0;
            } else if (intValue2 > 0 || intValue <= 3240) {
                i = intValue2;
            } else {
                i = 0;
                intValue = 1620;
            }
            if (VZ.outWidth <= VZ.outHeight) {
            }
            if (VZ.outWidth >= VZ.outHeight) {
            }
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG configLong:%d configShort:%d, CompressPicLevel-level:%d, srcW:%d, srcH:%d", Integer.valueOf(intValue), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight));
            if (i <= 0) {
                intValue = indexOf / i;
                intValue2 = (VZ.outHeight * i) / indexOf;
                i = (i * VZ.outWidth) / indexOf;
                indexOf = intValue;
            } else {
                indexOf = intValue2 / intValue;
                i = (VZ.outWidth * intValue) / intValue2;
                intValue2 = (VZ.outHeight * intValue) / intValue2;
            }
            if (intValue2 * i > 10240000) {
                double sqrt2 = Math.sqrt(1.024E7d / ((double) (intValue2 * i)));
                intValue2 = (int) (((double) intValue2) / sqrt2);
                i = (int) (((double) i) / sqrt2);
            }
            options = new Options();
            options.inPreferredConfig = Config.ARGB_8888;
            if (indexOf >= 2) {
                options.inSampleSize = indexOf;
            }
            decodeFile = c.decodeFile(str, options);
            if (decodeFile != null) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "decode file fail %d", Integer.valueOf(options.inSampleSize));
                return 0 - com.tencent.mm.compatible.util.g.getLine();
            }
            Bitmap createScaledBitmap2;
            x.d("MicroMsg.NetSceneUploadHDHeadImg", "dest:w:%d h:%d", Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
            if (indexOf > 1) {
                createScaledBitmap2 = Bitmap.createScaledBitmap(decodeFile, i, intValue2, true);
                if (decodeFile != createScaledBitmap2) {
                    x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", decodeFile.toString());
                    decodeFile.recycle();
                }
                if (createScaledBitmap2 == null) {
                    x.e("MicroMsg.NetSceneUploadHDHeadImg", "Scale file fail");
                    return 0 - com.tencent.mm.compatible.util.g.getLine();
                }
            }
            createScaledBitmap2 = decodeFile;
            OutputStream outputStream2 = null;
            try {
                outputStream2 = FileOp.jx(str2);
                createScaledBitmap2.compress(CompressFormat.JPEG, i2, outputStream2);
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e42) {
                    }
                }
                x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s, fileSize:%d -> %d", createScaledBitmap2.toString(), Long.valueOf(FileOp.mI(str)), Long.valueOf(FileOp.mI(str2)));
                createScaledBitmap2.recycle();
                return 0;
            } catch (Throwable e52) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "open FileOutputStream fail");
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "exception:%s", bi.i(e52));
                x.i("MicroMsg.NetSceneUploadHDHeadImg", "recycle bitmap:%s", createScaledBitmap2.toString());
                createScaledBitmap2.recycle();
                int line2 = 0 - com.tencent.mm.compatible.util.g.getLine();
                if (outputStream2 == null) {
                    return line2;
                }
                try {
                    outputStream2.close();
                    return line2;
                } catch (IOException e62) {
                    return line2;
                }
            } catch (Throwable th2) {
                if (outputStream2 != null) {
                    try {
                        outputStream2.close();
                    } catch (IOException e72) {
                    }
                }
            }
        } else {
            FileOp.y(str, str2);
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "compressBG copySrc outHeight and outWidth: %d,%d , do not scale.", Integer.valueOf(VZ.outHeight), Integer.valueOf(VZ.outWidth));
            return 0;
        }
    }

    public n(int i, String str) {
        if (i == 2) {
            this.dIc = ab.XV(this.dIc);
        }
        this.dIa = q.Kp().c(this.dIc, true, true);
        String str2 = this.dIa + ".tmp";
        if (af(str, str2) == 0) {
            this.bSw = str2;
            this.dHK = i;
            this.dIb = com.tencent.mm.a.g.u(FileOp.e(q.Kp().c(this.dIc, true, false), 0, -1));
            this.dHI = 0;
            this.dHJ = 0;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        if (this.bSw == null || this.bSw.length() == 0) {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "imgPath is null or length = 0");
            return -1;
        } else if (FileOp.cn(this.bSw)) {
            if (this.dHI == 0) {
                this.dHI = (int) FileOp.mI(this.bSw);
            }
            byte[] e = FileOp.e(this.bSw, this.dHJ, Math.min(this.dHI - this.dHJ, 8192));
            if (e == null) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "readFromFile error");
                return -1;
            }
            x.i("MicroMsg.NetSceneUploadHDHeadImg", "doScene uploadLen:%d, total: %d", Integer.valueOf(e.length), Integer.valueOf(this.dHI));
            b.a aVar = new b.a();
            aVar.dIG = new bvy();
            aVar.dIH = new bvz();
            aVar.uri = "/cgi-bin/micromsg-bin/uploadhdheadimg";
            aVar.dIF = 157;
            aVar.dII = 46;
            aVar.dIJ = 1000000046;
            com.tencent.mm.network.q KT = aVar.KT();
            bvy bvy = (bvy) KT.dID.dIL;
            bvy.rdV = this.dHI;
            bvy.rdW = this.dHJ;
            bvy.rIp = this.dHK;
            bvy.rtW = new bhy().bq(e);
            bvy.ssm = this.dIb;
            return a(eVar, KT, this);
        } else {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "The img does not exist, imgPath = " + this.bSw);
            return -1;
        }
    }

    protected final int a(com.tencent.mm.network.q qVar) {
        if (this.bSw == null || this.bSw.length() == 0) {
            return b.dJn;
        }
        return b.dJm;
    }

    protected final int Cc() {
        return HardCoderJNI.sHCDBDELAY_WRITE;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        int i4 = 0;
        bvz bvz = (bvz) ((b) qVar).dIE.dIL;
        x.d("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
        if (i2 != 4 && i3 != 0) {
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "errType:" + i2 + " errCode:" + i3);
            this.diJ.a(i2, i3, str, this);
        } else if (i2 == 4 || i2 == 5) {
            this.diJ.a(i2, i3, str, this);
            x.e("MicroMsg.NetSceneUploadHDHeadImg", "ErrType:" + i2);
        } else {
            if (qVar.Id().qWB == -4) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "retcode == %d", Integer.valueOf(qVar.Id().qWB));
                i4 = 1;
            }
            if (i4 != 0) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "handleCertainError");
                this.diJ.a(i2, i3, str, this);
                return;
            }
            this.dHJ = bvz.rdW;
            if (this.dHJ < this.dHI) {
                if (a(this.dIX, this.diJ) < 0) {
                    x.e("MicroMsg.NetSceneUploadHDHeadImg", "doScene again failed");
                    this.diJ.a(3, -1, "", this);
                }
                x.d("MicroMsg.NetSceneUploadHDHeadImg", "doScene again");
                return;
            }
            try {
                FileOp.av(this.bSw, this.dIa);
                g.Ei().DT().set(12297, bvz.ssn);
                q.Kp().f(this.dIc, c.Wb(this.dIa));
                String GF = q.GF();
                if (!bi.oW(GF)) {
                    j jVar = new j();
                    jVar.username = GF;
                    jVar.by(true);
                    jVar.bWA = 32;
                    jVar.csA = 3;
                    jVar.bWA = 34;
                    q.KH().a(jVar);
                }
                this.diJ.a(i2, i3, str, this);
            } catch (Exception e) {
                x.e("MicroMsg.NetSceneUploadHDHeadImg", "rename temp file failed :" + e.getMessage());
                this.diJ.a(3, -1, "", this);
            }
        }
    }

    protected final void cancel() {
        super.cancel();
    }

    public final int getType() {
        return 157;
    }
}
