package android.support.b;

import android.support.b.a.a;
import android.support.b.a.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

class a$c {
    public final int format;
    public final int lQ;
    public final byte[] lR;

    /* synthetic */ a$c(int i, int i2, byte[] bArr, byte b) {
        this(i, i2, bArr);
    }

    a$c(int i, int i2, byte[] bArr) {
        this.format = i;
        this.lQ = i2;
        this.lR = bArr;
    }

    public static a$c a(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.aW()[3] * iArr.length)]);
        wrap.order(byteOrder);
        for (int i : iArr) {
            wrap.putShort((short) i);
        }
        return new a$c(3, iArr.length, wrap.array());
    }

    public static a$c a(int i, ByteOrder byteOrder) {
        return a(new int[]{i}, byteOrder);
    }

    public static a$c a(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.aW()[4] * jArr.length)]);
        wrap.order(byteOrder);
        for (long j : jArr) {
            wrap.putInt((int) j);
        }
        return new a$c(4, jArr.length, wrap.array());
    }

    public static a$c a(long j, ByteOrder byteOrder) {
        return a(new long[]{j}, byteOrder);
    }

    public static a$c b(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.aW()[9] * iArr.length)]);
        wrap.order(byteOrder);
        for (int putInt : iArr) {
            wrap.putInt(putInt);
        }
        return new a$c(9, iArr.length, wrap.array());
    }

    public static a$c E(String str) {
        byte[] bytes = (str + 0).getBytes(a.aX());
        return new a$c(2, bytes.length, bytes);
    }

    public static a$c a(e[] eVarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.aW()[5] * eVarArr.length)]);
        wrap.order(byteOrder);
        for (e eVar : eVarArr) {
            wrap.putInt((int) eVar.lU);
            wrap.putInt((int) eVar.lV);
        }
        return new a$c(5, eVarArr.length, wrap.array());
    }

    public static a$c a(e eVar, ByteOrder byteOrder) {
        return a(new e[]{eVar}, byteOrder);
    }

    public static a$c b(e[] eVarArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.aW()[10] * eVarArr.length)]);
        wrap.order(byteOrder);
        for (e eVar : eVarArr) {
            wrap.putInt((int) eVar.lU);
            wrap.putInt((int) eVar.lV);
        }
        return new a$c(10, eVarArr.length, wrap.array());
    }

    public static a$c a(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[(a.aW()[12] * dArr.length)]);
        wrap.order(byteOrder);
        for (double putDouble : dArr) {
            wrap.putDouble(putDouble);
        }
        return new a$c(12, dArr.length, wrap.array());
    }

    public final String toString() {
        return "(" + a.aY()[this.format] + ", data length:" + this.lR.length + ")";
    }

    final Object a(ByteOrder byteOrder) {
        a aVar;
        Throwable th;
        int i = 1;
        int i2 = 0;
        a aVar2;
        try {
            aVar2 = new a(this.lR);
            try {
                aVar2.lO = byteOrder;
                Object str;
                int i3;
                switch (this.format) {
                    case 1:
                    case 6:
                        if (this.lR.length != 1 || this.lR[0] < (byte) 0 || this.lR[0] > (byte) 1) {
                            str = new String(this.lR, a.aX());
                            try {
                                aVar2.close();
                                return str;
                            } catch (IOException e) {
                                return str;
                            }
                        }
                        str = new String(new char[]{(char) (this.lR[0] + 48)});
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e2) {
                            return str;
                        }
                    case 2:
                    case 7:
                        StringBuilder stringBuilder;
                        if (this.lQ >= a.aZ().length) {
                            for (int i4 = 0; i4 < a.aZ().length; i4++) {
                                if (this.lR[i4] != a.aZ()[i4]) {
                                    i = 0;
                                    if (i != 0) {
                                        i = a.aZ().length;
                                        stringBuilder = new StringBuilder();
                                        while (i < this.lQ) {
                                            byte b = this.lR[i];
                                            if (b != (byte) 0) {
                                                if (b >= (byte) 32) {
                                                    stringBuilder.append((char) b);
                                                } else {
                                                    stringBuilder.append('?');
                                                }
                                                i++;
                                            }
                                        }
                                        str = stringBuilder.toString();
                                        aVar2.close();
                                        return str;
                                    }
                                }
                            }
                            if (i != 0) {
                                i = a.aZ().length;
                                stringBuilder = new StringBuilder();
                                while (i < this.lQ) {
                                    byte b2 = this.lR[i];
                                    if (b2 != (byte) 0) {
                                        if (b2 >= (byte) 32) {
                                            stringBuilder.append((char) b2);
                                        } else {
                                            stringBuilder.append('?');
                                        }
                                        i++;
                                    }
                                }
                                str = stringBuilder.toString();
                                aVar2.close();
                                return str;
                            }
                        }
                        i = 0;
                        stringBuilder = new StringBuilder();
                        while (i < this.lQ) {
                            byte b22 = this.lR[i];
                            if (b22 != (byte) 0) {
                                if (b22 >= (byte) 32) {
                                    stringBuilder.append((char) b22);
                                } else {
                                    stringBuilder.append('?');
                                }
                                i++;
                            }
                        }
                        str = stringBuilder.toString();
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e3) {
                            return str;
                        }
                    case 3:
                        str = new int[this.lQ];
                        while (i2 < this.lQ) {
                            str[i2] = aVar2.readUnsignedShort();
                            i2++;
                        }
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e4) {
                            return str;
                        }
                    case 4:
                        str = new long[this.lQ];
                        while (i2 < this.lQ) {
                            str[i2] = aVar2.ba();
                            i2++;
                        }
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e5) {
                            return str;
                        }
                    case 5:
                        str = new e[this.lQ];
                        while (true) {
                            i3 = i2;
                            if (i3 < this.lQ) {
                                str[i3] = new e(aVar2.ba(), aVar2.ba(), (byte) 0);
                                i2 = i3 + 1;
                            } else {
                                try {
                                    aVar2.close();
                                    return str;
                                } catch (IOException e6) {
                                    return str;
                                }
                            }
                        }
                    case 8:
                        str = new int[this.lQ];
                        while (i2 < this.lQ) {
                            str[i2] = aVar2.readShort();
                            i2++;
                        }
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e7) {
                            return str;
                        }
                    case 9:
                        str = new int[this.lQ];
                        while (i2 < this.lQ) {
                            str[i2] = aVar2.readInt();
                            i2++;
                        }
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e8) {
                            return str;
                        }
                    case 10:
                        str = new e[this.lQ];
                        while (true) {
                            i3 = i2;
                            if (i3 < this.lQ) {
                                str[i3] = new e((long) aVar2.readInt(), (long) aVar2.readInt(), (byte) 0);
                                i2 = i3 + 1;
                            } else {
                                try {
                                    aVar2.close();
                                    return str;
                                } catch (IOException e9) {
                                    return str;
                                }
                            }
                        }
                    case 11:
                        str = new double[this.lQ];
                        while (i2 < this.lQ) {
                            str[i2] = (double) aVar2.readFloat();
                            i2++;
                        }
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e10) {
                            return str;
                        }
                    case 12:
                        str = new double[this.lQ];
                        while (i2 < this.lQ) {
                            str[i2] = aVar2.readDouble();
                            i2++;
                        }
                        try {
                            aVar2.close();
                            return str;
                        } catch (IOException e11) {
                            return str;
                        }
                    default:
                        try {
                            aVar2.close();
                        } catch (IOException e12) {
                        }
                        return null;
                }
            } catch (IOException e13) {
                aVar = aVar2;
            } catch (Throwable th2) {
                th = th2;
                if (aVar2 != null) {
                    try {
                        aVar2.close();
                    } catch (IOException e14) {
                    }
                }
                throw th;
            }
        } catch (IOException e15) {
            aVar = null;
            if (aVar != null) {
                try {
                    aVar.close();
                } catch (IOException e16) {
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            aVar2 = null;
            if (aVar2 != null) {
                try {
                    aVar2.close();
                } catch (IOException e142) {
                }
            }
            throw th;
        }
    }

    public final int b(ByteOrder byteOrder) {
        Object a = a(byteOrder);
        if (a == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        } else if (a instanceof String) {
            return Integer.parseInt((String) a);
        } else {
            if (a instanceof long[]) {
                long[] jArr = (long[]) a;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else if (a instanceof int[]) {
                int[] iArr = (int[]) a;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            } else {
                throw new NumberFormatException("Couldn't find a integer value");
            }
        }
    }

    public final String c(ByteOrder byteOrder) {
        int i = 0;
        Object a = a(byteOrder);
        if (a == null) {
            return null;
        }
        if (a instanceof String) {
            return (String) a;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (a instanceof long[]) {
            long[] jArr = (long[]) a;
            while (i < jArr.length) {
                stringBuilder.append(jArr[i]);
                if (i + 1 != jArr.length) {
                    stringBuilder.append(",");
                }
                i++;
            }
            return stringBuilder.toString();
        } else if (a instanceof int[]) {
            int[] iArr = (int[]) a;
            while (i < iArr.length) {
                stringBuilder.append(iArr[i]);
                if (i + 1 != iArr.length) {
                    stringBuilder.append(",");
                }
                i++;
            }
            return stringBuilder.toString();
        } else if (a instanceof double[]) {
            double[] dArr = (double[]) a;
            while (i < dArr.length) {
                stringBuilder.append(dArr[i]);
                if (i + 1 != dArr.length) {
                    stringBuilder.append(",");
                }
                i++;
            }
            return stringBuilder.toString();
        } else if (!(a instanceof e[])) {
            return null;
        } else {
            e[] eVarArr = (e[]) a;
            while (i < eVarArr.length) {
                stringBuilder.append(eVarArr[i].lU);
                stringBuilder.append('/');
                stringBuilder.append(eVarArr[i].lV);
                if (i + 1 != eVarArr.length) {
                    stringBuilder.append(",");
                }
                i++;
            }
            return stringBuilder.toString();
        }
    }

    public final int size() {
        return a.aW()[this.format] * this.lQ;
    }
}
