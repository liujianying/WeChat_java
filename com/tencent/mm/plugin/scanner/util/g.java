package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.plugin.licence.model.BankCardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qbar.QbarNative;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class g extends b {
    private int mCount = 0;
    private boolean mNd = false;
    public boolean mNe;
    private boolean mNf;
    public boolean[] mNg = new boolean[4];
    private boolean mNh;
    private boolean mNi;
    private boolean mNj;
    private Bitmap mNk;
    private final Object mNl = new Object();

    public g(a aVar, boolean z, boolean z2) {
        super(aVar);
        this.mNe = z;
        this.mNf = z2;
        x.d("MicroMsg.ScanBankCardDecoder", "isPortrait:%s, needRotate:%s", new Object[]{Boolean.valueOf(false), Boolean.valueOf(z)});
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        Throwable e;
        long currentTimeMillis;
        BankCardInfo bankCardInfo;
        int recognizeBankCardProcess;
        synchronized (this.mNl) {
            long currentTimeMillis2 = System.currentTimeMillis();
            x.d("MicroMsg.ScanBankCardDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (true == this.mNh) {
                x.d("MicroMsg.ScanBankCardDecoder", "recognize bank succeed, no need more handle");
                z = false;
            } else {
                int focusedEngineForBankcardInit;
                int i;
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.15f);
                int width = (((int) (((float) rect.width()) * (1.0f + ((min - 1.0f) * 1.6f)))) / 4) * 4;
                int height = (((int) (((float) rect.height()) * min)) / 4) * 4;
                x.d("MicroMsg.ScanBankCardDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.mNi) {
                    long currentTimeMillis3 = System.currentTimeMillis();
                    focusedEngineForBankcardInit = QbarNative.focusedEngineForBankcardInit(width, height, 8, this.mNd);
                    x.d("MicroMsg.ScanBankCardDecoder", "focusedEngineForBankcardInit, cost: " + (System.currentTimeMillis() - currentTimeMillis3));
                    if (focusedEngineForBankcardInit != 0) {
                        x.e("MicroMsg.ScanBankCardDecoder", "init failed on init focusedEngine:" + focusedEngineForBankcardInit);
                        z = false;
                    } else {
                        this.mNi = true;
                    }
                }
                if (!this.mNj && true == this.mNi) {
                    x.d("MicroMsg.ScanBankCardDecoder", "init param:%d, %d, %d, %d, %s", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height()), Boolean.valueOf(this.mNd)});
                    this.mNj = LibCardRecog.recognizeBankCardInit(width, height, this.mNd) == 0;
                }
                x.d("MicroMsg.ScanBankCardDecoder", "crop image start:%d, %d, dataLen:%d", new Object[]{Integer.valueOf(rect.left - ((width - rect.width()) / 2)), Integer.valueOf(rect.top - ((height - rect.height()) / 2)), Integer.valueOf(bArr.length)});
                String value = com.tencent.mm.k.g.AT().getValue("debug_scan_bank");
                if (value != null && value.equals("true")) {
                    this.mCount++;
                    i = point.x;
                    int i2 = point.y;
                    int i3 = this.mCount;
                    String str = "_scanImage_org.jpeg";
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    x.d("MicroMsg.ScanBankCardDecoder", "decode() compress jpeg by YuvImage");
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    FileOutputStream fileOutputStream = null;
                    FileOutputStream fileOutputStream2;
                    try {
                        fileOutputStream2 = new FileOutputStream(new File(h.getExternalStorageDirectory().getAbsolutePath() + "/test/" + String.valueOf(i3) + str));
                        try {
                            fileOutputStream2.write(toByteArray);
                            fileOutputStream2.flush();
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2, "", new Object[0]);
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                            }
                        } catch (IOException e3) {
                            e22 = e3;
                            try {
                                x.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e22.getMessage()});
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22, "", new Object[0]);
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (Throwable e222) {
                                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e222, "", new Object[0]);
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                                }
                                currentTimeMillis = System.currentTimeMillis();
                                bankCardInfo = new BankCardInfo(point.x, point.y);
                                recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.mNg);
                                x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                                if (!this.mNe) {
                                    boolean z2 = this.mNg[0];
                                    this.mNg[0] = this.mNg[2];
                                    this.mNg[2] = z2;
                                    z2 = this.mNg[1];
                                    this.mNg[1] = this.mNg[3];
                                    this.mNg[3] = z2;
                                }
                                x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                                if (recognizeBankCardProcess != 1) {
                                    x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                                    z = false;
                                } else {
                                    Options options = new Options();
                                    options.inSampleSize = 1;
                                    this.mNk = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options).copy(Config.ARGB_8888, true);
                                    if (this.mNk == null) {
                                        z = false;
                                    } else {
                                        int[] rectX = bankCardInfo.getRectX();
                                        int[] rectY = bankCardInfo.getRectY();
                                        int i4 = (rectX[bankCardInfo.getCardNumLen() - 1] - rectX[0]) + (rectX[1] - rectX[0]);
                                        recognizeBankCardProcess = (int) (((float) i4) * 0.21319798f);
                                        int i5 = (int) (((float) rectX[0]) - (((float) i4) * 0.04568528f));
                                        i = i5 > 0 ? i5 : 0;
                                        i5 = ((int) (((float) (i4 * 2)) * 0.04568528f)) + i4;
                                        focusedEngineForBankcardInit = (int) ((((float) rectY[0]) + ((((float) (rectX[1] - rectX[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                                        if (focusedEngineForBankcardInit <= 0) {
                                            focusedEngineForBankcardInit = 0;
                                        }
                                        if (i + i5 > bankCardInfo.width) {
                                            i5 = bankCardInfo.width - i;
                                        }
                                        if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                            recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                                        }
                                        this.mNk = Bitmap.createBitmap(this.mNk, i, focusedEngineForBankcardInit, i5, recognizeBankCardProcess);
                                        mMH = 3;
                                        if (this.mNf) {
                                            this.mMG = bankCardInfo.getCardNum();
                                        } else {
                                            this.mMG = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX);
                                        }
                                        this.mNh = true;
                                        x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                                        z = true;
                                    }
                                }
                                return z;
                            } catch (Throwable th) {
                                e2222 = th;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (Throwable e4) {
                                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e4, "", new Object[0]);
                                    }
                                }
                                try {
                                    byteArrayOutputStream.close();
                                } catch (Throwable e42) {
                                    x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e42, "", new Object[0]);
                                }
                                throw e2222;
                            }
                        }
                    } catch (IOException e5) {
                        e2222 = e5;
                        fileOutputStream2 = null;
                        x.e("MicroMsg.ScanBankCardDecoder", " Exception in decode() ApiTask : [%s]", new Object[]{e2222.getMessage()});
                        x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e2222, "", new Object[0]);
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (Throwable e22222) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e22222, "", new Object[0]);
                            }
                        }
                        byteArrayOutputStream.close();
                        currentTimeMillis = System.currentTimeMillis();
                        bankCardInfo = new BankCardInfo(point.x, point.y);
                        recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.mNg);
                        x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        if (this.mNe) {
                            boolean z22 = this.mNg[0];
                            this.mNg[0] = this.mNg[2];
                            this.mNg[2] = z22;
                            z22 = this.mNg[1];
                            this.mNg[1] = this.mNg[3];
                            this.mNg[3] = z22;
                        }
                        x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                        if (recognizeBankCardProcess != 1) {
                            Options options2 = new Options();
                            options2.inSampleSize = 1;
                            this.mNk = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options2).copy(Config.ARGB_8888, true);
                            if (this.mNk == null) {
                                z = false;
                            } else {
                                int[] rectX2 = bankCardInfo.getRectX();
                                int[] rectY2 = bankCardInfo.getRectY();
                                int i42 = (rectX2[bankCardInfo.getCardNumLen() - 1] - rectX2[0]) + (rectX2[1] - rectX2[0]);
                                recognizeBankCardProcess = (int) (((float) i42) * 0.21319798f);
                                int i52 = (int) (((float) rectX2[0]) - (((float) i42) * 0.04568528f));
                                i = i52 > 0 ? i52 : 0;
                                i52 = ((int) (((float) (i42 * 2)) * 0.04568528f)) + i42;
                                focusedEngineForBankcardInit = (int) ((((float) rectY2[0]) + ((((float) (rectX2[1] - rectX2[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                                if (focusedEngineForBankcardInit <= 0) {
                                    focusedEngineForBankcardInit = 0;
                                }
                                if (i + i52 > bankCardInfo.width) {
                                    i52 = bankCardInfo.width - i;
                                }
                                if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                                    recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                                }
                                this.mNk = Bitmap.createBitmap(this.mNk, i, focusedEngineForBankcardInit, i52, recognizeBankCardProcess);
                                mMH = 3;
                                if (this.mNf) {
                                    this.mMG = bankCardInfo.getCardNum();
                                } else {
                                    this.mMG = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX2);
                                }
                                this.mNh = true;
                                x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                                z = true;
                            }
                        } else {
                            x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                            z = false;
                        }
                        return z;
                    } catch (Throwable th2) {
                        e22222 = th2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e422) {
                                x.printErrStackTrace("MicroMsg.ScanBankCardDecoder", e422, "", new Object[0]);
                            }
                        }
                        byteArrayOutputStream.close();
                        throw e22222;
                    }
                }
                currentTimeMillis = System.currentTimeMillis();
                bankCardInfo = new BankCardInfo(point.x, point.y);
                recognizeBankCardProcess = LibCardRecog.recognizeBankCardProcess(bArr, point.y, point.x, r15, r16, height, width, bankCardInfo, this.mNg);
                x.d("MicroMsg.ScanBankCardDecoder", "recognize bankcard cost: " + (System.currentTimeMillis() - currentTimeMillis));
                if (this.mNe) {
                    boolean z222 = this.mNg[0];
                    this.mNg[0] = this.mNg[2];
                    this.mNg[2] = z222;
                    z222 = this.mNg[1];
                    this.mNg[1] = this.mNg[3];
                    this.mNg[3] = z222;
                }
                x.d("MicroMsg.ScanBankCardDecoder", "scan bankcard retCode:" + recognizeBankCardProcess);
                if (recognizeBankCardProcess != 1) {
                    x.d("MicroMsg.ScanBankCardDecoder", "scan bank failed:" + recognizeBankCardProcess);
                    z = false;
                } else {
                    Options options22 = new Options();
                    options22.inSampleSize = 1;
                    this.mNk = BitmapFactory.decodeByteArray(bankCardInfo.bitmapData, 0, bankCardInfo.bitmapLen, options22).copy(Config.ARGB_8888, true);
                    if (this.mNk == null) {
                        z = false;
                    } else {
                        int[] rectX22 = bankCardInfo.getRectX();
                        int[] rectY22 = bankCardInfo.getRectY();
                        int i422 = (rectX22[bankCardInfo.getCardNumLen() - 1] - rectX22[0]) + (rectX22[1] - rectX22[0]);
                        recognizeBankCardProcess = (int) (((float) i422) * 0.21319798f);
                        int i522 = (int) (((float) rectX22[0]) - (((float) i422) * 0.04568528f));
                        i = i522 > 0 ? i522 : 0;
                        i522 = ((int) (((float) (i422 * 2)) * 0.04568528f)) + i422;
                        focusedEngineForBankcardInit = (int) ((((float) rectY22[0]) + ((((float) (rectX22[1] - rectX22[0])) * 1.3333334f) / 2.0f)) - ((float) (recognizeBankCardProcess / 2)));
                        if (focusedEngineForBankcardInit <= 0) {
                            focusedEngineForBankcardInit = 0;
                        }
                        if (i + i522 > bankCardInfo.width) {
                            i522 = bankCardInfo.width - i;
                        }
                        if (focusedEngineForBankcardInit + recognizeBankCardProcess > bankCardInfo.height) {
                            recognizeBankCardProcess = bankCardInfo.height - focusedEngineForBankcardInit;
                        }
                        this.mNk = Bitmap.createBitmap(this.mNk, i, focusedEngineForBankcardInit, i522, recognizeBankCardProcess);
                        mMH = 3;
                        if (this.mNf) {
                            this.mMG = bankCardInfo.getCardNum();
                        } else {
                            this.mMG = LibCardRecog.recognizeBankCardSegmentNumber(bankCardInfo.getCardNum(), bankCardInfo.getCardNumLen(), rectX22);
                        }
                        this.mNh = true;
                        x.d("MicroMsg.ScanBankCardDecoder", "decode cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public final void ll() {
        synchronized (this.mNl) {
            if (true == this.mNi) {
                QbarNative.focusedEngineRelease();
                this.mNi = false;
            }
            if (true == this.mNj) {
                LibCardRecog.recognizeBankCardRelease();
            }
            this.mNk = null;
        }
    }

    public final void bsU() {
        ll();
    }

    public final Bitmap bta() {
        Bitmap bitmap;
        synchronized (this.mNl) {
            bitmap = this.mNk;
        }
        return bitmap;
    }
}
