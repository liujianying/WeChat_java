package com.tencent.mm.plugin.scanner.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import com.tencent.mm.plugin.licence.model.CardInfo;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.util.b.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class k extends b {
    private final int klc;
    private final Object lock = new Object();
    private Bitmap mNN;
    public Bitmap mNO;
    private boolean[] mNg = new boolean[4];
    private boolean mNh = false;
    private boolean mNj = false;

    public k(a aVar, int i) {
        super(aVar);
        this.klc = i;
    }

    public final boolean[] btk() {
        boolean[] zArr;
        synchronized (this.lock) {
            zArr = this.mNg;
        }
        return zArr;
    }

    public final boolean a(byte[] bArr, Point point, Rect rect) {
        boolean z;
        x.d("MicroMsg.ScanLicenceDecoder", "smoothie, decode, resolution = %s, coverage = %s, data.length = %d", new Object[]{point, rect, Integer.valueOf(bArr.length)});
        synchronized (this.lock) {
            if (!(this.mNN == null || this.mNN.isRecycled())) {
                x.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recycle last bitmap");
                this.mNN.recycle();
            }
            x.d("MicroMsg.ScanLicenceDecoder", "resolution:%s, coverage:%s", new Object[]{point, rect});
            if (this.mNh) {
                x.d("MicroMsg.ScanLicenceDecoder", "recognize id succeed, no need more handle");
                z = false;
            } else {
                int i;
                for (i = 0; i < 4; i++) {
                    this.mNg[i] = false;
                }
                float min = Math.min(Math.min(((float) point.x) / ((float) rect.width()), ((float) point.y) / ((float) rect.height())), 1.0f);
                int width = rect.width();
                int height = rect.height();
                x.d("MicroMsg.ScanLicenceDecoder", "rate:%f, cropWidth:%d, cropHeight:%d", new Object[]{Float.valueOf(min), Integer.valueOf(width), Integer.valueOf(height)});
                if (!this.mNj) {
                    x.d("MicroMsg.ScanLicenceDecoder", "init param:%d, %d, %d, %d", new Object[]{Integer.valueOf(width), Integer.valueOf(height), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
                    try {
                        LibCardRecog.recognizeCardInit(width, height, this.klc);
                        this.mNj = true;
                    } catch (Exception e) {
                        x.e("MicroMsg.ScanLicenceDecoder", "lib init failed, exp = %s", new Object[]{e});
                        this.mNj = false;
                        btl();
                        z = false;
                    }
                }
                long currentTimeMillis = System.currentTimeMillis();
                CardInfo cardInfo = new CardInfo(width, height);
                int i2 = rect.top;
                try {
                    i = LibCardRecog.recognizeCardProcess(bArr, point.y, point.x, rect.left, i2, height, width, cardInfo, this.mNg);
                    x.d("MicroMsg.ScanLicenceDecoder", "[smoothie] recognizeProcess, ret = %d", new Object[]{Integer.valueOf(i)});
                    x.d("MicroMsg.ScanLicenceDecoder", "focusedEngineProcess cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    x.d("MicroMsg.ScanLicenceDecoder", "mRecogRectEdge: %s", new Object[]{Arrays.toString(this.mNg)});
                    if (i == 0) {
                        z = false;
                    } else if (1 != i) {
                        for (i = 0; i < 4; i++) {
                            this.mNg[i] = false;
                        }
                        x.d("MicroMsg.ScanLicenceDecoder", "image is not enough clear");
                        z = false;
                    } else {
                        for (i = 0; i < 4; i++) {
                            this.mNg[i] = true;
                        }
                        this.mNN = BitmapFactory.decodeByteArray(cardInfo.bitmapData, 0, cardInfo.bitmapLen);
                        this.mNO = this.mNN.copy(Config.ARGB_8888, true);
                        this.mNh = true;
                        z = true;
                    }
                } catch (Exception e2) {
                    x.e("MicroMsg.ScanLicenceDecoder", "recognizeProcess failed, exp = %s", new Object[]{e2});
                    this.mNh = false;
                    z = false;
                }
            }
        }
        return z;
    }

    public final void ll() {
        if (!(this.mNN == null || this.mNN.isRecycled())) {
            this.mNN.recycle();
        }
        btl();
    }

    public final void bsU() {
        this.mNh = false;
    }

    private static void btl() {
        x.i("MicroMsg.ScanLicenceDecoder", "lib release");
        try {
            LibCardRecog.recognizeCardRelease();
        } catch (Exception e) {
            x.e("MicroMsg.ScanLicenceDecoder", "lib release, exp = %s", new Object[]{e});
        }
    }
}
