package com.google.android.gms.c;

import com.tencent.smtt.sdk.WebView;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;

public final class ax {
    final ByteBuffer aZX;

    private ax(ByteBuffer byteBuffer) {
        this.aZX = byteBuffer;
    }

    private ax(byte[] bArr, int i) {
        this(ByteBuffer.wrap(bArr, 0, i));
    }

    private static int a(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char charAt;
        int length = charSequence.length();
        int i3 = 0;
        int i4 = i + i2;
        while (i3 < length && i3 + i < i4) {
            charAt = charSequence.charAt(i3);
            if (charAt >= 128) {
                break;
            }
            bArr[i + i3] = (byte) charAt;
            i3++;
        }
        if (i3 == length) {
            return i + length;
        }
        int i5 = i + i3;
        while (i3 < length) {
            int i6;
            char charAt2 = charSequence.charAt(i3);
            int i7;
            if (charAt2 < 128 && i5 < i4) {
                i6 = i5 + 1;
                bArr[i5] = (byte) charAt2;
            } else if (charAt2 < 2048 && i5 <= i4 - 2) {
                i7 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 6) | 960);
                i6 = i7 + 1;
                bArr[i7] = (byte) ((charAt2 & 63) | 128);
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i5 <= i4 - 3) {
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 >>> 12) | 480);
                i5 = i6 + 1;
                bArr[i6] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i6 = i5 + 1;
                bArr[i5] = (byte) ((charAt2 & 63) | 128);
            } else if (i5 <= i4 - 4) {
                if (i3 + 1 != charSequence.length()) {
                    i3++;
                    charAt = charSequence.charAt(i3);
                    if (Character.isSurrogatePair(charAt2, charAt)) {
                        int toCodePoint = Character.toCodePoint(charAt2, charAt);
                        i6 = i5 + 1;
                        bArr[i5] = (byte) ((toCodePoint >>> 18) | 240);
                        i5 = i6 + 1;
                        bArr[i6] = (byte) (((toCodePoint >>> 12) & 63) | 128);
                        i7 = i5 + 1;
                        bArr[i5] = (byte) (((toCodePoint >>> 6) & 63) | 128);
                        i6 = i7 + 1;
                        bArr[i7] = (byte) ((toCodePoint & 63) | 128);
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i3 - 1));
            } else {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i5);
            }
            i3++;
            i5 = i6;
        }
        return i5;
    }

    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byteBuffer.position(a(charSequence, byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining()) - byteBuffer.arrayOffset());
            } catch (Throwable e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            b(charSequence, byteBuffer);
        }
    }

    public static int aA(int i, int i2) {
        return dI(i) + dG(i2);
    }

    public static int ad(long j) {
        return (-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10;
    }

    private void ae(long j) {
        while ((-128 & j) != 0) {
            dH((((int) j) & 127) | 128);
            j >>>= 7;
        }
        dH((int) j);
    }

    public static int b(int i, be beVar) {
        int dI = dI(i);
        int qS = beVar.qS();
        return dI + (qS + dK(qS));
    }

    private static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt < 128) {
                byteBuffer.put((byte) charAt);
            } else if (charAt < 2048) {
                byteBuffer.put((byte) ((charAt >>> 6) | 960));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else if (charAt < 55296 || 57343 < charAt) {
                byteBuffer.put((byte) ((charAt >>> 12) | 480));
                byteBuffer.put((byte) (((charAt >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt & 63) | 128));
            } else {
                if (i + 1 != charSequence.length()) {
                    i++;
                    char charAt2 = charSequence.charAt(i);
                    if (Character.isSurrogatePair(charAt, charAt2)) {
                        int toCodePoint = Character.toCodePoint(charAt, charAt2);
                        byteBuffer.put((byte) ((toCodePoint >>> 18) | 240));
                        byteBuffer.put((byte) (((toCodePoint >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((toCodePoint >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((toCodePoint & 63) | 128));
                    }
                }
                throw new IllegalArgumentException("Unpaired surrogate at index " + (i - 1));
            }
            i++;
        }
    }

    public static int bu(String str) {
        int l = l(str);
        return l + dK(l);
    }

    public static int dG(int i) {
        return i >= 0 ? dK(i) : 10;
    }

    public static int dI(int i) {
        return dK(bh.aC(i, 0));
    }

    public static int dK(int i) {
        return (i & -128) == 0 ? 1 : (i & -16384) == 0 ? 2 : (-2097152 & i) == 0 ? 3 : (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int dL(int i) {
        return (i << 1) ^ (i >> 31);
    }

    public static int f(int i, String str) {
        return dI(i) + bu(str);
    }

    public static int h(int i, long j) {
        return dI(i) + ad(j);
    }

    private static int l(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (i2 < length) {
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                throw new IllegalArgumentException("Unpaired surrogate at index " + i2);
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i += i3;
                if (i < length) {
                    return i;
                }
                throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
            }
        }
        i = i3;
        if (i < length) {
            return i;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (((long) i) + 4294967296L));
    }

    public static ax p(byte[] bArr, int i) {
        return new ax(bArr, i);
    }

    public final void a(int i, be beVar) {
        aB(i, 2);
        b(beVar);
    }

    public final void aB(int i, int i2) {
        dJ(bh.aC(i, i2));
    }

    public final void az(int i, int i2) {
        aB(i, 0);
        if (i2 >= 0) {
            dJ(i2);
        } else {
            ae((long) i2);
        }
    }

    public final void b(be beVar) {
        dJ(beVar.qR());
        beVar.a(this);
    }

    public final void d(int i, float f) {
        aB(i, 5);
        int floatToIntBits = Float.floatToIntBits(f);
        dH(floatToIntBits & WebView.NORMAL_MODE_ALPHA);
        dH((floatToIntBits >> 8) & WebView.NORMAL_MODE_ALPHA);
        dH((floatToIntBits >> 16) & WebView.NORMAL_MODE_ALPHA);
        dH((floatToIntBits >> 24) & WebView.NORMAL_MODE_ALPHA);
    }

    public final void dH(int i) {
        byte b = (byte) i;
        if (this.aZX.hasRemaining()) {
            this.aZX.put(b);
            return;
        }
        throw new a(this.aZX.position(), this.aZX.limit());
    }

    public final void dJ(int i) {
        while ((i & -128) != 0) {
            dH((i & 127) | 128);
            i >>>= 7;
        }
        dH(i);
    }

    public final void e(int i, String str) {
        aB(i, 2);
        try {
            int dK = dK(str.length());
            if (dK == dK(str.length() * 3)) {
                int position = this.aZX.position();
                this.aZX.position(position + dK);
                a((CharSequence) str, this.aZX);
                int position2 = this.aZX.position();
                this.aZX.position(position);
                dJ((position2 - position) - dK);
                this.aZX.position(position2);
                return;
            }
            dJ(l(str));
            a((CharSequence) str, this.aZX);
        } catch (BufferOverflowException e) {
            throw new a(this.aZX.position(), this.aZX.limit());
        }
    }

    public final void g(int i, long j) {
        aB(i, 0);
        ae(j);
    }

    public final void m(byte[] bArr) {
        int length = bArr.length;
        if (this.aZX.remaining() >= length) {
            this.aZX.put(bArr, 0, length);
            return;
        }
        throw new a(this.aZX.position(), this.aZX.limit());
    }

    public final void s(int i, boolean z) {
        int i2 = 0;
        aB(i, 0);
        if (z) {
            i2 = 1;
        }
        dH(i2);
    }
}
