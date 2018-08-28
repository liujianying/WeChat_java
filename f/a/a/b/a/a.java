package f.a.a.b.a;

import com.tencent.wcdb.FileUtils;
import java.io.InputStream;
import java.util.LinkedList;

public final class a {
    private int bfH = 0;
    public int bfI;
    public int bfJ = 0;
    private int bfK = Integer.MAX_VALUE;
    private int bfN = 67108864;
    public byte[] buffer;
    public int bufferSize;
    private InputStream vHG;
    private int vHH = 0;

    public final double readDouble() {
        byte sc = sc();
        byte sc2 = sc();
        return Double.longBitsToDouble(((((((((((long) sc2) & 255) << 8) | (((long) sc) & 255)) | ((((long) sc()) & 255) << 16)) | ((((long) sc()) & 255) << 24)) | ((((long) sc()) & 255) << 32)) | ((((long) sc()) & 255) << 40)) | ((((long) sc()) & 255) << 48)) | ((((long) sc()) & 255) << 56));
    }

    public final float readFloat() {
        return Float.intBitsToFloat((((sc() & 255) | ((sc() & 255) << 8)) | ((sc() & 255) << 16)) | ((sc() & 255) << 24));
    }

    public final LinkedList<byte[]> IC(int i) {
        LinkedList<byte[]> linkedList = new LinkedList();
        int rY = rY();
        try {
            Object obj = new byte[rY];
            System.arraycopy(this.buffer, this.bfI, obj, 0, rY);
            linkedList.add(obj);
            this.bfI = rY + this.bfI;
            rY = this.bfI;
            if (this.bfI == this.bufferSize) {
                return linkedList;
            }
            int[] ID = ID(rY);
            rY = ID[0];
            while (f.a.a.b.a.eg(rY) == i) {
                this.bfI = ID[1];
                rY = rY();
                obj = new byte[rY];
                System.arraycopy(this.buffer, this.bfI, obj, 0, rY);
                linkedList.add(obj);
                this.bfI = rY + this.bfI;
                if (this.bfI == this.bufferSize) {
                    break;
                }
                ID = ID(this.bfI);
                rY = ID[0];
            }
            return linkedList;
        } catch (OutOfMemoryError e) {
            throw new OutOfMemoryError("alloc bytes:" + rY);
        }
    }

    public final String readString() {
        int rY = rY();
        if (rY >= this.bufferSize - this.bfI || rY <= 0) {
            return new String(dY(rY), "UTF-8");
        }
        String str = new String(this.buffer, this.bfI, rY, "UTF-8");
        this.bfI = rY + this.bfI;
        return str;
    }

    private int[] ID(int i) {
        byte b = this.buffer[i];
        int i2 = i + 1;
        if (b >= (byte) 0) {
            return new int[]{b, i2};
        }
        int i3;
        int i4 = b & 127;
        byte b2 = this.buffer[i2];
        if (b2 >= (byte) 0) {
            i3 = i2 + 1;
            i4 |= b2 << 7;
        } else {
            i4 |= (b2 & 127) << 7;
            b2 = this.buffer[i2];
            if (b2 >= (byte) 0) {
                i3 = i2 + 1;
                i4 |= b2 << 14;
            } else {
                i4 |= (b2 & 127) << 14;
                b2 = this.buffer[i2];
                if (b2 >= (byte) 0) {
                    i3 = i2 + 1;
                    i4 |= b2 << 21;
                } else {
                    i4 |= (b2 & 127) << 21;
                    b2 = this.buffer[i2];
                    i4 |= b2 << 28;
                    i3 = i2 + 1;
                    if (b2 < (byte) 0) {
                        for (i4 = 0; i4 < 5; i4++) {
                            if (this.buffer[i3] >= (byte) 0) {
                                i3++;
                                return new int[]{b2, i3};
                            }
                        }
                        throw b.cJV();
                    }
                }
            }
        }
        return new int[]{i4, i3};
    }

    public final int rY() {
        byte sc = sc();
        if (sc >= (byte) 0) {
            return sc;
        }
        int i = sc & 127;
        byte sc2 = sc();
        if (sc2 >= (byte) 0) {
            return i | (sc2 << 7);
        }
        i |= (sc2 & 127) << 7;
        sc2 = sc();
        if (sc2 >= (byte) 0) {
            return i | (sc2 << 14);
        }
        i |= (sc2 & 127) << 14;
        sc2 = sc();
        if (sc2 >= (byte) 0) {
            return i | (sc2 << 21);
        }
        i |= (sc2 & 127) << 21;
        sc2 = sc();
        i |= sc2 << 28;
        if (sc2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (sc() >= (byte) 0) {
                return i;
            }
        }
        throw b.cJV();
    }

    public final long rZ() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte sc = sc();
            j |= ((long) (sc & 127)) << i;
            if ((sc & FileUtils.S_IWUSR) == 0) {
                return j;
            }
        }
        throw b.cJV();
    }

    public a(byte[] bArr, int i) {
        this.buffer = bArr;
        this.bufferSize = i + 0;
        this.bfI = 0;
        this.vHG = null;
    }

    public final boolean nb(boolean z) {
        if (this.bfI < this.bufferSize) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.vHH + this.bufferSize != this.bfK) {
            this.vHH += this.bufferSize;
            this.bfI = 0;
            this.bufferSize = this.vHG == null ? -1 : this.vHG.read(this.buffer);
            if (this.bufferSize == -1) {
                this.bufferSize = 0;
                if (!z) {
                    return false;
                }
                throw b.cJT();
            }
            this.bufferSize += this.bfH;
            int i = this.vHH + this.bufferSize;
            if (i > this.bfK) {
                this.bfH = i - this.bfK;
                this.bufferSize -= this.bfH;
            } else {
                this.bfH = 0;
            }
            i = (this.vHH + this.bufferSize) + this.bfH;
            if (i <= this.bfN && i >= 0) {
                return true;
            }
            throw b.cJX();
        } else if (!z) {
            return false;
        } else {
            throw b.cJT();
        }
    }

    private byte sc() {
        if (this.bfI == this.bufferSize) {
            nb(true);
        }
        byte[] bArr = this.buffer;
        int i = this.bfI;
        this.bfI = i + 1;
        return bArr[i];
    }

    public final byte[] dY(int i) {
        int i2;
        if (i < 0) {
            throw b.cJU();
        } else if ((this.vHH + this.bfI) + i > this.bfK) {
            dZ((this.bfK - this.vHH) - this.bfI);
            throw b.cJT();
        } else if (i <= this.bufferSize - this.bfI) {
            Object obj = new byte[i];
            System.arraycopy(this.buffer, this.bfI, obj, 0, i);
            this.bfI += i;
            return obj;
        } else if (i < 2048) {
            Object obj2 = new byte[i];
            i2 = this.bufferSize - this.bfI;
            System.arraycopy(this.buffer, this.bfI, obj2, 0, i2);
            this.bfI = this.bufferSize;
            nb(true);
            while (i - i2 > this.bufferSize) {
                System.arraycopy(this.buffer, 0, obj2, i2, this.bufferSize);
                i2 += this.bufferSize;
                this.bfI = this.bufferSize;
                nb(true);
            }
            System.arraycopy(this.buffer, 0, obj2, i2, i - i2);
            this.bfI = i - i2;
            return obj2;
        } else {
            int read;
            int i3 = this.bfI;
            int i4 = this.bufferSize;
            this.vHH += this.bufferSize;
            this.bfI = 0;
            this.bufferSize = 0;
            i2 = i - (i4 - i3);
            LinkedList linkedList = new LinkedList();
            int i5 = i2;
            while (i5 > 0) {
                Object obj3 = new byte[Math.min(i5, 2048)];
                i2 = 0;
                while (i2 < obj3.length) {
                    read = this.vHG == null ? -1 : this.vHG.read(obj3, i2, obj3.length - i2);
                    if (read == -1) {
                        throw b.cJT();
                    }
                    this.vHH += read;
                    i2 += read;
                }
                i2 = i5 - obj3.length;
                linkedList.add(obj3);
                i5 = i2;
            }
            Object obj4 = new byte[i];
            i2 = i4 - i3;
            System.arraycopy(this.buffer, i3, obj4, 0, i2);
            read = 0;
            while (true) {
                int i6 = i2;
                if (read >= linkedList.size()) {
                    return obj4;
                }
                byte[] bArr = (byte[]) linkedList.get(read);
                System.arraycopy(bArr, 0, obj4, i6, bArr.length);
                i6 += bArr.length;
                i2 = read + 1;
            }
        }
    }

    private void dZ(int i) {
        if (i < 0) {
            throw b.cJU();
        } else if ((this.vHH + this.bfI) + i > this.bfK) {
            dZ((this.bfK - this.vHH) - this.bfI);
            throw b.cJT();
        } else if (i < this.bufferSize - this.bfI) {
            this.bfI += i;
        } else {
            int i2 = this.bufferSize - this.bfI;
            this.vHH += i2;
            this.bfI = 0;
            this.bufferSize = 0;
            int i3 = i2;
            while (i3 < i) {
                i2 = this.vHG == null ? -1 : (int) this.vHG.skip((long) (i - i3));
                if (i2 <= 0) {
                    throw b.cJT();
                }
                i3 += i2;
                this.vHH = i2 + this.vHH;
            }
        }
    }
}
