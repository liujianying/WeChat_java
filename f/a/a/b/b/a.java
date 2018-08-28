package f.a.a.b.b;

import com.tencent.wcdb.FileUtils;
import java.io.UnsupportedEncodingException;

public final class a {
    private final byte[] buffer;
    private final int limit;
    private int position = 0;

    public a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.limit = i + 0;
    }

    public static int h(int i, String str) {
        if (str == null) {
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + (ec(i) + ee(bytes.length));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported.");
        }
    }

    public final void eb(int i) {
        byte b = (byte) i;
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    public final void p(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (bArr == null) {
                return;
            }
            if (this.limit - this.position >= length) {
                System.arraycopy(bArr, 0, this.buffer, this.position, length);
                this.position = length + this.position;
                return;
            }
            int i = this.limit - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            int i2 = i + 0;
            length -= i;
            this.position = this.limit;
            if (length <= this.limit) {
                System.arraycopy(bArr, i2, this.buffer, 0, length);
                this.position = length;
            }
        }
    }

    public final void aI(int i, int i2) {
        ed(f.a.a.b.a.aJ(i, i2));
    }

    public static int ec(int i) {
        return ee(f.a.a.b.a.aJ(i, 0));
    }

    public final void ed(int i) {
        while ((i & -128) != 0) {
            eb((i & 127) | FileUtils.S_IWUSR);
            i >>>= 7;
        }
        eb(i);
    }

    public static int ee(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public final void ag(long j) {
        while ((-128 & j) != 0) {
            eb((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        eb((int) j);
    }
}
