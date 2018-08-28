package com.google.android.exoplayer2.i;

import com.google.android.exoplayer2.d.b;
import com.tencent.smtt.sdk.WebView;
import java.nio.charset.Charset;

public final class j {
    public byte[] data;
    public int limit;
    public int position;

    public j(int i) {
        this.data = new byte[i];
        this.limit = i;
    }

    public j(byte[] bArr) {
        this.data = bArr;
        this.limit = bArr.length;
    }

    public j(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
    }

    public final void reset(int i) {
        m(capacity() < i ? new byte[i] : this.data, i);
    }

    public final void m(byte[] bArr, int i) {
        this.data = bArr;
        this.limit = i;
        this.position = 0;
    }

    public final int me() {
        return this.limit - this.position;
    }

    public final void cZ(int i) {
        boolean z = i >= 0 && i <= this.data.length;
        a.ao(z);
        this.limit = i;
    }

    public final int capacity() {
        return this.data == null ? 0 : this.data.length;
    }

    public final void setPosition(int i) {
        boolean z = true;
        if (i < 0 || i > this.limit) {
            b.i("ExoPlayer", "position%d, limit:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(this.limit)});
        }
        if (i < 0 || i > this.limit) {
            z = false;
        }
        a.ao(z);
        this.position = i;
    }

    public final void da(int i) {
        setPosition(this.position + i);
    }

    public final void c(i iVar, int i) {
        readBytes(iVar.data, 0, i);
        iVar.setPosition(0);
    }

    public final void readBytes(byte[] bArr, int i, int i2) {
        System.arraycopy(this.data, this.position, bArr, i, i2);
        this.position += i2;
    }

    public final int readUnsignedByte() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        return bArr[i] & WebView.NORMAL_MODE_ALPHA;
    }

    public final int readUnsignedShort() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & WebView.NORMAL_MODE_ALPHA) << 8;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & WebView.NORMAL_MODE_ALPHA);
    }

    public final int mf() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & WebView.NORMAL_MODE_ALPHA) << 16;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & WebView.NORMAL_MODE_ALPHA) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & WebView.NORMAL_MODE_ALPHA);
    }

    public final long ba() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 24;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final int readInt() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        int i2 = (bArr[i] & WebView.NORMAL_MODE_ALPHA) << 24;
        byte[] bArr2 = this.data;
        int i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & WebView.NORMAL_MODE_ALPHA) << 16;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        i2 |= (bArr2[i3] & WebView.NORMAL_MODE_ALPHA) << 8;
        bArr2 = this.data;
        i3 = this.position;
        this.position = i3 + 1;
        return i2 | (bArr2[i3] & WebView.NORMAL_MODE_ALPHA);
    }

    public final long readLong() {
        byte[] bArr = this.data;
        int i = this.position;
        this.position = i + 1;
        long j = (((long) bArr[i]) & 255) << 56;
        byte[] bArr2 = this.data;
        int i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 48;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 40;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 32;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 24;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 16;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        j |= (((long) bArr2[i2]) & 255) << 8;
        bArr2 = this.data;
        i2 = this.position;
        this.position = i2 + 1;
        return j | (((long) bArr2[i2]) & 255);
    }

    public final int mg() {
        return (((readUnsignedByte() << 21) | (readUnsignedByte() << 14)) | (readUnsignedByte() << 7)) | readUnsignedByte();
    }

    public final int mh() {
        int readInt = readInt();
        if (readInt >= 0) {
            return readInt;
        }
        throw new IllegalStateException("Top bit not zero: " + readInt);
    }

    public final long mi() {
        long readLong = readLong();
        if (readLong >= 0) {
            return readLong;
        }
        throw new IllegalStateException("Top bit not zero: " + readLong);
    }

    public final String readString(int i) {
        return a(i, Charset.forName("UTF-8"));
    }

    public final String a(int i, Charset charset) {
        String str = new String(this.data, this.position, i, charset);
        this.position += i;
        return str;
    }

    public final String mj() {
        if (me() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && this.data[i] != (byte) 0) {
            i++;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position < this.limit) {
            this.position++;
        }
        return str;
    }

    public final String readLine() {
        if (me() == 0) {
            return null;
        }
        int i = this.position;
        while (i < this.limit && !t.dd(this.data[i])) {
            i++;
        }
        if (i - this.position >= 3 && this.data[this.position] == (byte) -17 && this.data[this.position + 1] == (byte) -69 && this.data[this.position + 2] == (byte) -65) {
            this.position += 3;
        }
        String str = new String(this.data, this.position, i - this.position);
        this.position = i;
        if (this.position == this.limit) {
            return str;
        }
        if (this.data[this.position] == (byte) 13) {
            this.position++;
            if (this.position == this.limit) {
                return str;
            }
        }
        if (this.data[this.position] == (byte) 10) {
            this.position++;
        }
        return str;
    }
}
