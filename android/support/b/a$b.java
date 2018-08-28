package android.support.b;

import com.tencent.smtt.sdk.WebView;
import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.nio.ByteOrder;

class a$b extends FilterOutputStream {
    ByteOrder lO;
    private final OutputStream lP;

    public a$b(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.lP = outputStream;
        this.lO = byteOrder;
    }

    public final void write(byte[] bArr) {
        this.lP.write(bArr);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.lP.write(bArr, i, i2);
    }

    public final void writeByte(int i) {
        this.lP.write(i);
    }

    public final void writeShort(short s) {
        if (this.lO == ByteOrder.LITTLE_ENDIAN) {
            this.lP.write((s >>> 0) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((s >>> 8) & WebView.NORMAL_MODE_ALPHA);
        } else if (this.lO == ByteOrder.BIG_ENDIAN) {
            this.lP.write((s >>> 8) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((s >>> 0) & WebView.NORMAL_MODE_ALPHA);
        }
    }

    public final void writeInt(int i) {
        if (this.lO == ByteOrder.LITTLE_ENDIAN) {
            this.lP.write((i >>> 0) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((i >>> 8) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((i >>> 16) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((i >>> 24) & WebView.NORMAL_MODE_ALPHA);
        } else if (this.lO == ByteOrder.BIG_ENDIAN) {
            this.lP.write((i >>> 24) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((i >>> 16) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((i >>> 8) & WebView.NORMAL_MODE_ALPHA);
            this.lP.write((i >>> 0) & WebView.NORMAL_MODE_ALPHA);
        }
    }
}
