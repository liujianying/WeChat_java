package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class l$6 implements Runnable {
    final /* synthetic */ byte[] fZh;
    final /* synthetic */ l liS;

    l$6(l lVar, byte[] bArr) {
        this.liS = lVar;
        this.fZh = bArr;
    }

    public final void run() {
        l lVar = this.liS;
        byte[] bArr = this.fZh;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (bi.oW(lVar.bOX)) {
                        x.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, thumbpath is null");
                        lVar.liK = false;
                        return;
                    }
                    int width;
                    Bitmap b;
                    int i = (lVar.liD == 0 || lVar.liD == 180) ? lVar.liB : lVar.liC;
                    int i2 = (lVar.liD == 0 || lVar.liD == 180) ? lVar.liC : lVar.liB;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    Rect rect = new Rect(0, 0, i, i2);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (lVar.lem != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > lVar.lem.dQS) {
                        width = decodeByteArray.getWidth();
                        i = decodeByteArray.getHeight();
                        int i3 = lVar.lem.dQS > 0 ? lVar.lem.dQS : lVar.lem.width;
                        if (width < i) {
                            width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            i = i3;
                        } else {
                            i = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                            width = i3;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i, width, true);
                    }
                    if (!lVar.faL || lVar.liN == 180) {
                        width = lVar.liD;
                        if (lVar.liN == 180) {
                            width += 180;
                            if (width > 360) {
                                width -= 360;
                            }
                        }
                        b = c.b(decodeByteArray, (float) width);
                    } else if (Math.abs(lVar.liD - lVar.liN) == 0) {
                        b = c.b(decodeByteArray, 180.0f);
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    c.a(b, 60, CompressFormat.JPEG, lVar.bOX, true);
                    x.i("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s", new Object[]{lVar.bOX, Integer.valueOf(lVar.liD), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                lVar.liK = false;
                return;
            }
        }
        x.e("MicroMsg.MMSightFFMpegRecorder", "saveVideoThumbImpl, data is null");
        lVar.liK = false;
    }
}
