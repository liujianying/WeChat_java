package com.tencent.mm.plugin.api.recordView;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.plugin.mmsight.model.e.b;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

class f$5 implements b {
    final /* synthetic */ f fbE;
    final /* synthetic */ e fbG;
    final /* synthetic */ boolean fbH;

    f$5(f fVar, boolean z, e eVar) {
        this.fbE = fVar;
        this.fbH = z;
        this.fbG = eVar;
    }

    public final void a(byte[] bArr, int i, int i2, int i3, int i4) {
        if (this.fbH) {
            this.fbE.fbj.bdR();
        }
        if (bArr == null || i < 0 || i2 < 0 || i3 < 0) {
            x.e("MicroMsg.MMSightRecordViewImpl", "onPictureYuvTaken, data is null!!");
            this.fbG.aiP();
            return;
        }
        try {
            byte[] bArr2;
            int i5;
            int i6;
            YuvImage yuvImage;
            OutputStream byteArrayOutputStream;
            byte[] toByteArray;
            Bitmap decodeByteArray;
            Bitmap b;
            if (this.fbE.fbt) {
                this.fbE.ZV();
                if (this.fbE.fbj.lfW) {
                    if (this.fbE.fbv.y < i) {
                        bArr2 = new byte[(((this.fbE.fbv.x * this.fbE.fbv.y) * 3) >> 1)];
                        SightVideoJNI.cropCameraDataLongEdge(bArr, bArr2, i, this.fbE.fbv.y, i2);
                        i = this.fbE.fbv.y;
                        i5 = this.fbE.fbv.x;
                        i6 = i;
                        yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                        byteArrayOutputStream = new ByteArrayOutputStream();
                        yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                        toByteArray = byteArrayOutputStream.toByteArray();
                        decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                        if (i4 == 180) {
                            i3 += 180;
                            if (i3 > 360) {
                                i3 -= 360;
                            }
                        }
                        b = c.b(decodeByteArray, (float) i3);
                        decodeByteArray.recycle();
                        this.fbG.v(b);
                    }
                } else if (this.fbE.fbv.x < i2) {
                    bArr2 = new byte[(((this.fbE.fbv.x * this.fbE.fbv.y) * 3) >> 1)];
                    SightVideoJNI.cropCameraData(bArr, bArr2, i, i2, this.fbE.fbv.x);
                    i5 = this.fbE.fbv.x;
                    i6 = this.fbE.fbv.y;
                    yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
                    toByteArray = byteArrayOutputStream.toByteArray();
                    decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
                    if (i4 == 180) {
                        i3 += 180;
                        if (i3 > 360) {
                            i3 -= 360;
                        }
                    }
                    b = c.b(decodeByteArray, (float) i3);
                    decodeByteArray.recycle();
                    this.fbG.v(b);
                }
            }
            i5 = i2;
            i6 = i;
            bArr2 = bArr;
            yuvImage = new YuvImage(bArr2, 17, i6, i5, null);
            byteArrayOutputStream = new ByteArrayOutputStream();
            yuvImage.compressToJpeg(new Rect(0, 0, i6, i5), 100, byteArrayOutputStream);
            toByteArray = byteArrayOutputStream.toByteArray();
            decodeByteArray = MMBitmapFactory.decodeByteArray(toByteArray, 0, toByteArray.length);
            if (i4 == 180) {
                i3 += 180;
                if (i3 > 360) {
                    i3 -= 360;
                }
            }
            b = c.b(decodeByteArray, (float) i3);
            decodeByteArray.recycle();
            this.fbG.v(b);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMSightRecordViewImpl", e, "saveCaptureYuvDataToBitmap error: %s", new Object[]{e.getMessage()});
            this.fbG.aiP();
        }
    }
}
