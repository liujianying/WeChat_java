package com.tencent.mm.plugin.scanner.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class j extends b {
    private Object dMd = new Object();
    private byte[] fOM;
    private boolean jAi = false;
    public boolean lhy = true;
    private boolean mJI = false;
    private float mKP = 1.0f;
    private final int mNE = 25;
    private boolean mNF = false;
    private final int mNG = 1;
    private int mNH = 0;
    private boolean mNI;
    private volatile boolean mNJ;
    public volatile boolean mNK;
    private long mNL;
    private int outHeight;
    private int outWidth;
    private int quality = 50;

    public j(a aVar, int i, float f, boolean z, boolean z2) {
        super(aVar);
        this.quality = i;
        this.mKP = f;
        this.lhy = z2;
        this.mNI = z;
        x.i("MicroMsg.scanner.ScanImageDecoder", "quality = [%s], scaleRate = [%s], needRotate = [%s], ocrMode=[%s]", new Object[]{Integer.valueOf(i), Float.valueOf(f), Boolean.valueOf(z2), Boolean.valueOf(z)});
    }

    @TargetApi(8)
    public final boolean a(byte[] bArr, Point point, Rect rect) {
        if (this.jAi) {
            x.e("MicroMsg.scanner.ScanImageDecoder", "decode() is decoding, return false");
            return false;
        }
        this.jAi = true;
        if (bArr == null || point == null || rect == null) {
            boolean z;
            String str = "MicroMsg.scanner.ScanImageDecoder";
            String str2 = "decode() data null:[%s], resolution null:[%s], coverage null:[%s]";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(bArr == null);
            if (point == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            if (rect == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            x.e(str, str2, objArr);
            this.jAi = false;
            return false;
        }
        try {
            if (this.mNH <= 0) {
                this.mNH++;
                this.jAi = false;
                return false;
            }
            synchronized (this.dMd) {
                int width;
                Rect rect2 = new Rect();
                int height;
                if (d.zf() || this.lhy) {
                    width = rect.width() % 4;
                    height = rect.height() % 4;
                    rect2.left = rect.left;
                    rect2.right = rect.right - width;
                    rect2.top = rect.top;
                    rect2.bottom = rect.bottom - height;
                    if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                        this.jAi = false;
                        return false;
                    }
                }
                rect2.left = (point.x / 2) - rect.height();
                rect2.right = (point.x / 2) + rect.height();
                rect2.top = (point.y / 2) - (rect.width() / 2);
                rect2.bottom = (point.y / 2) + (rect.width() / 2);
                if (rect2.left < 0) {
                    rect2.left = 0;
                }
                if (rect2.right > point.x - 1) {
                    rect2.right = point.x - 1;
                }
                if (rect2.top < 0) {
                    rect2.top = 0;
                }
                if (rect2.bottom > point.y - 1) {
                    rect2.bottom = point.y - 1;
                }
                width = rect2.width() % 4;
                height = rect2.height() % 4;
                if (width != 0) {
                    rect2.right -= width;
                }
                if (height != 0) {
                    rect2.bottom -= height;
                }
                if (rect2.right <= rect2.left || rect2.bottom <= rect2.top) {
                    this.jAi = false;
                    return false;
                }
                c cVar = new c(bArr, point.x, point.y, rect2);
                if (cVar.height == 0 || cVar.width == 0) {
                    this.jAi = false;
                    return false;
                } else if (this.mJI) {
                    x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 1");
                    return false;
                } else {
                    byte[] bsW = cVar.bsW();
                    if (bsW == null) {
                        this.jAi = false;
                        return false;
                    }
                    if (!this.mNF) {
                        if (d.zf()) {
                            width = a(rect2.width(), rect2.height(), this.mNI, vI(q.deM.dda));
                            x.d("MicroMsg.scanner.ScanImageDecoder", "Focus init Landscape params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[]{Integer.valueOf(rect2.width()), Integer.valueOf(rect2.height()), Boolean.valueOf(this.mNI), Integer.valueOf(q.deM.dda)});
                        } else {
                            width = a(rect2.height(), rect2.width(), this.mNI, vI(q.deM.dda));
                            x.d("MicroMsg.scanner.ScanImageDecoder", "Focus init params1=[%s] params2=[%s] params3=[%s], focusThreshold=[%s]", new Object[]{Integer.valueOf(rect2.height()), Integer.valueOf(rect2.width()), Boolean.valueOf(this.mNI), Integer.valueOf(q.deM.dda)});
                        }
                        if (width == -1) {
                            x.e("MicroMsg.scanner.ScanImageDecoder", "error in Focus init = [%s]", new Object[]{Integer.valueOf(width)});
                            return false;
                        }
                        this.mNF = true;
                    }
                    boolean[] zArr = new boolean[2];
                    long VG = bi.VG();
                    QbarNative.FocusPro(bsW, d.zf(), zArr);
                    x.d("MicroMsg.scanner.ScanImageDecoder", "is best:%s, need focus:%s, cost:%s", new Object[]{Boolean.valueOf(zArr[0]), Boolean.valueOf(zArr[1]), Long.valueOf(bi.bI(VG))});
                    this.mNJ = zArr[0];
                    this.mNK = zArr[1];
                    if (this.mNL == 0) {
                        this.mNL = System.currentTimeMillis();
                    }
                    if (!this.mNK && System.currentTimeMillis() - this.mNL > 9000) {
                        x.d("MicroMsg.scanner.ScanImageDecoder", "reach focus interfal");
                        this.mNK = true;
                        this.mNL = System.currentTimeMillis();
                    }
                    if (this.mNJ) {
                        if (this.mJI) {
                            x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 2");
                            return false;
                        }
                        this.outWidth = cVar.width;
                        this.outHeight = cVar.height;
                        int i = 0;
                        width = 0;
                        if (!d.zf()) {
                            i = 1;
                            this.outWidth = cVar.height;
                            this.outHeight = cVar.width;
                        }
                        if (((double) this.mKP) < 0.9d) {
                            width = 1;
                            this.outWidth /= 2;
                            this.outHeight /= 2;
                        }
                        if (this.fOM == null) {
                            this.fOM = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            x.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes = null, new byte[%s]", new Object[]{Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2)});
                        } else if (this.fOM.length != ((this.outWidth * this.outHeight) * 3) / 2) {
                            this.fOM = null;
                            this.fOM = new byte[(((this.outWidth * this.outHeight) * 3) / 2)];
                            x.v("MicroMsg.scanner.ScanImageDecoder", "tempOutBytes size change, new byte[%s]", new Object[]{Integer.valueOf(((this.outWidth * this.outHeight) * 3) / 2)});
                        }
                        x.d("MicroMsg.scanner.ScanImageDecoder", "decode() imgRet = [%s], outWidth = [%s], outHeight = [%s], imgRotate=[%s], imgScale=[%s]", new Object[]{Integer.valueOf(QbarNative.a(this.fOM, bsW, this.outWidth, this.outHeight, width)), Integer.valueOf(this.outWidth), Integer.valueOf(this.outHeight), Integer.valueOf(i), Integer.valueOf(width)});
                        if (QbarNative.a(this.fOM, bsW, this.outWidth, this.outHeight, width) != 1) {
                            this.mMF = null;
                            this.jAi = false;
                            return false;
                        } else if (this.mJI) {
                            x.w("MicroMsg.scanner.ScanImageDecoder", "isReleasing, return false 3");
                            return false;
                        } else {
                            if (com.tencent.mm.compatible.util.d.fR(8)) {
                                com.tencent.mm.compatible.a.a.a(8, new 1(this));
                            } else {
                                x.d("MicroMsg.scanner.ScanImageDecoder", "decode() compress jpeg by PlanarYUVLuminanceSource");
                                c cVar2 = new c(this.fOM, this.outWidth, this.outHeight, new Rect(0, 0, this.outWidth, this.outHeight));
                                int[] iArr = new int[(cVar2.width * cVar2.height)];
                                QbarNative.a(cVar2.bYC, iArr, cVar2.mML, cVar2.mMM, cVar2.left, cVar2.top, cVar2.width, cVar2.height);
                                QbarNative.nativeRelease();
                                Bitmap createBitmap = Bitmap.createBitmap(cVar2.width, cVar2.height, Config.ARGB_8888);
                                createBitmap.setPixels(iArr, 0, cVar2.width, 0, 0, cVar2.width, cVar2.height);
                                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                createBitmap.compress(CompressFormat.JPEG, this.quality, byteArrayOutputStream);
                                this.mMF = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                if (af.exa) {
                                    c.a(createBitmap, this.quality, CompressFormat.JPEG, h.getExternalStorageDirectory().getAbsolutePath() + "/_scanImage_.JPEG", false);
                                }
                                createBitmap.recycle();
                            }
                            x.i("MicroMsg.scanner.ScanImageDecoder", "decode() finish greyData.length = [%s]", new Object[]{Integer.valueOf(this.mMF.length)});
                            this.jAi = false;
                            return true;
                        }
                    }
                }
            }
        } catch (Throwable e) {
            x.e("MicroMsg.scanner.ScanImageDecoder", " Exception in decode(): [%s]", new Object[]{e.toString()});
            x.printErrStackTrace("MicroMsg.scanner.ScanImageDecoder", e, "", new Object[0]);
        }
        this.mMF = null;
        this.jAi = false;
        return false;
    }

    public final void ll() {
        x.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder start");
        this.mJI = true;
        if (this.dMd != null) {
            synchronized (this.dMd) {
                if (this.mNF) {
                    x.d("sizepara", "ImgProcessScan.FocusRelease() = [%s]", new Object[]{Integer.valueOf(0)});
                    this.mNF = false;
                    x.d("MicroMsg.scanner.ScanImageDecoder", "ImgProcessScan.Release() = [%s]", new Object[]{Integer.valueOf(QbarNative.FocusRelease())});
                }
            }
        }
        this.fOM = null;
        c.bsV();
        x.d("MicroMsg.scanner.ScanImageDecoder", "releaseDecoder done");
    }

    public final void bsU() {
        if (this.mNF) {
            ll();
        }
        this.jAi = false;
        this.mJI = false;
        this.mNF = false;
    }

    private static int a(int i, int i2, boolean z, int i3) {
        if (i <= 0 || i2 <= 0) {
            return -1;
        }
        if (i3 == 1) {
            return QbarNative.FocusInit(i, i2, z, 6, b.CTRL_INDEX);
        }
        if (i3 == 2) {
            return QbarNative.FocusInit(i, i2, z, 8, 120);
        }
        if (i3 == 4) {
            return QbarNative.FocusInit(i, i2, z, 13, 80);
        }
        if (i3 == 5) {
            return QbarNative.FocusInit(i, i2, z, 15, 65);
        }
        return QbarNative.FocusInit(i, i2, z, 10, 100);
    }

    private static int vI(int i) {
        if (i <= 0 || i > 5) {
            return 3;
        }
        return i;
    }
}
