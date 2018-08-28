package com.tencent.mm.plugin.mmsight.model.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class n$9 implements Runnable {
    final /* synthetic */ byte[] fZh;
    final /* synthetic */ n ljp;

    n$9(n nVar, byte[] bArr) {
        this.ljp = nVar;
        this.fZh = bArr;
    }

    public final void run() {
        n nVar = this.ljp;
        byte[] bArr = this.fZh;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    if (bi.oW(nVar.bOX)) {
                        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, thumbpath is null");
                        nVar.liK = false;
                        return;
                    }
                    int width;
                    Bitmap b;
                    int i = (nVar.liD == 0 || nVar.liD == 180) ? nVar.liB : nVar.liC;
                    int i2 = (nVar.liD == 0 || nVar.liD == 180) ? nVar.liC : nVar.liB;
                    YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
                    Rect rect = new Rect(0, 0, i, i2);
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(rect, 100, byteArrayOutputStream);
                    byte[] toByteArray = byteArrayOutputStream.toByteArray();
                    Bitmap decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (nVar.lem != null && Math.min(decodeByteArray.getWidth(), decodeByteArray.getHeight()) > nVar.lem.dQS) {
                        width = decodeByteArray.getWidth();
                        i = decodeByteArray.getHeight();
                        int i3 = nVar.lem.dQS > 0 ? nVar.lem.dQS : nVar.lem.width;
                        if (width < i) {
                            width = (int) (((float) i) / ((((float) width) * 1.0f) / ((float) i3)));
                            i = i3;
                        } else {
                            i = (int) (((float) width) / ((((float) i) * 1.0f) / ((float) i3)));
                            width = i3;
                        }
                        decodeByteArray = Bitmap.createScaledBitmap(decodeByteArray, i, width, true);
                    }
                    if (!nVar.faL || nVar.liN == 180) {
                        width = nVar.liD;
                        if (nVar.liN == 180) {
                            width += 180;
                            if (width > 360) {
                                width -= 360;
                            }
                        }
                        b = c.b(decodeByteArray, (float) width);
                    } else if (Math.abs(nVar.liD - nVar.liN) == 0) {
                        b = c.b(decodeByteArray, 180.0f);
                        decodeByteArray.recycle();
                    } else {
                        b = decodeByteArray;
                    }
                    c.a(b, 60, CompressFormat.JPEG, nVar.bOX, true);
                    x.i("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb to: %s, cameraOrientation: %s, width: %s, height: %s %s", new Object[]{nVar.bOX, Integer.valueOf(nVar.liD), Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight()), Long.valueOf(FileOp.mI(nVar.bOX))});
                    return;
                }
            } catch (Exception e) {
                x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumb error: %s", new Object[]{e.getMessage()});
                nVar.liK = false;
                return;
            }
        }
        x.e("MicroMsg.MMSightMediaCodecMP4MuxRecorder", "saveVideoThumbImpl, data is null");
        nVar.liK = false;
    }
}
