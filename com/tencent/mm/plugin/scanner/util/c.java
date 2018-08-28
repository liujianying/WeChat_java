package com.tencent.mm.plugin.scanner.util;

import android.graphics.Rect;
import com.tencent.mm.sdk.platformtools.x;
import g.a;

public final class c extends a {
    public final byte[] bYC;
    public int height;
    public int left;
    final int mML;
    final int mMM;
    public int top;
    public int width;

    public c(byte[] bArr, int i, int i2, Rect rect) {
        int i3 = 0;
        super(rect.width(), rect.height());
        x.v("MicroMsg.scanner.PlanarYUVLuminanceSource", "init yuvData.len: %d,  dataW: %d, dataH: %d, left: %d, top: %d, width: %d, height: %d ", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.width()), Integer.valueOf(rect.height())});
        this.bYC = bArr;
        this.mML = i;
        this.mMM = i2;
        int i4 = (rect.left < 0 || rect.left >= i) ? 0 : rect.left;
        this.left = i4;
        if (rect.top >= 0 && rect.top < i2) {
            i3 = rect.top;
        }
        this.top = i3;
        this.width = this.left + rect.width() > i ? i - this.left : rect.width();
        this.height = this.top + rect.height() > i2 ? i2 - this.top : rect.height();
        if (this.left + this.width > i || this.top + this.height > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
    }

    public final byte[] m(int i, byte[] bArr) {
        if (i < 0 || i >= this.height) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i);
        }
        Object bArr2;
        if (bArr2 == null || bArr2.length < this.width) {
            bArr2 = new byte[this.width];
        }
        System.arraycopy(this.bYC, ((this.top + i) * this.mML) + this.left, bArr2, 0, this.width);
        return bArr2;
    }

    public static void bsV() {
        l btm = l.btm();
        if (btm.mNQ != null) {
            btm.mNQ = null;
        }
        if (btm.mNR != null) {
            btm.mNR = null;
        }
        System.gc();
    }

    public final byte[] bsW() {
        if (this.width == this.mML && this.height == this.mMM) {
            return this.bYC;
        }
        try {
            int i = this.width * this.height;
            l btm = l.btm();
            if (btm.mNQ == null) {
                btm.mNQ = new byte[i];
            } else if (btm.mNQ.length != i) {
                btm.mNQ = null;
                btm.mNQ = new byte[i];
            }
            byte[] bArr = btm.mNQ;
            int i2 = (this.top * this.mML) + this.left;
            if (this.width == this.mML) {
                System.arraycopy(this.bYC, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.bYC;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.mML;
            }
            return bArr;
        } catch (Exception e) {
            x.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.bYC.length + " dataWidth:" + this.mML + " dataHeight:" + this.mMM + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }

    public final byte[] bsX() {
        if (this.width == this.mML && this.height == this.mMM) {
            return this.bYC;
        }
        try {
            int i = this.width * this.height;
            byte[] bArr = new byte[i];
            int i2 = (this.top * this.mML) + this.left;
            if (this.width == this.mML) {
                System.arraycopy(this.bYC, i2, bArr, 0, i);
                return bArr;
            }
            Object obj = this.bYC;
            for (int i3 = 0; i3 < this.height; i3++) {
                System.arraycopy(obj, i2, bArr, this.width * i3, this.width);
                i2 += this.mML;
            }
            return bArr;
        } catch (Exception e) {
            x.e("MicroMsg.scanner.PlanarYUVLuminanceSource", " yuvData.len:" + this.bYC.length + " dataWidth:" + this.mML + " dataHeight:" + this.mMM + " left:" + this.left + " top:" + this.top + " width:" + this.width + " height:" + this.height + " tStr:" + e.toString());
            return null;
        }
    }
}
