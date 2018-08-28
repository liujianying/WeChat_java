package com.google.android.exoplayer2.metadata.id3;

import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public static final int amG = t.aE("ID3");
    private final a aqQ;

    public a() {
        this(null);
    }

    public a(a aVar) {
        this.aqQ = aVar;
    }

    public final Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.aig;
        return c(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata c(byte[] bArr, int i) {
        b bVar;
        int readUnsignedByte;
        int mg;
        int readInt;
        boolean z = true;
        List arrayList = new ArrayList();
        j jVar = new j(bArr, i);
        if (jVar.me() < 10) {
            bVar = null;
        } else if (jVar.mf() != amG) {
            bVar = null;
        } else {
            int i2;
            readUnsignedByte = jVar.readUnsignedByte();
            jVar.da(1);
            int readUnsignedByte2 = jVar.readUnsignedByte();
            mg = jVar.mg();
            if (readUnsignedByte == 2) {
                if ((readUnsignedByte2 & 64) != 0) {
                    bVar = null;
                } else {
                    i2 = mg;
                }
            } else if (readUnsignedByte == 3) {
                if ((readUnsignedByte2 & 64) != 0) {
                    readInt = jVar.readInt();
                    jVar.da(readInt);
                    mg -= readInt + 4;
                }
                i2 = mg;
            } else if (readUnsignedByte == 4) {
                if ((readUnsignedByte2 & 64) != 0) {
                    readInt = jVar.mg();
                    jVar.da(readInt - 4);
                    mg -= readInt;
                }
                if ((readUnsignedByte2 & 16) != 0) {
                    mg -= 10;
                }
                i2 = mg;
            } else {
                bVar = null;
            }
            boolean z2 = readUnsignedByte < 4 && (readUnsignedByte2 & 128) != 0;
            bVar = new b(readUnsignedByte, z2, i2);
        }
        if (bVar == null) {
            return null;
        }
        readUnsignedByte = jVar.position;
        mg = bVar.aqR == 2 ? 6 : 10;
        readInt = bVar.aqT;
        if (bVar.aqS) {
            readInt = d(jVar, bVar.aqT);
        }
        jVar.cZ(readInt + readUnsignedByte);
        if (a(jVar, bVar.aqR, mg, false)) {
            z = false;
        } else if (!(bVar.aqR == 4 && a(jVar, 4, mg, true))) {
            new StringBuilder("Failed to validate ID3 tag with majorVersion=").append(bVar.aqR);
            return null;
        }
        while (jVar.me() >= mg) {
            Id3Frame a = a(bVar.aqR, jVar, z, mg, this.aqQ);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return new Metadata(arrayList);
    }

    private static boolean a(j jVar, int i, int i2, boolean z) {
        int i3 = jVar.position;
        while (jVar.me() >= i2) {
            try {
                int readInt;
                long ba;
                int readUnsignedShort;
                if (i >= 3) {
                    readInt = jVar.readInt();
                    ba = jVar.ba();
                    readUnsignedShort = jVar.readUnsignedShort();
                } else {
                    readInt = jVar.mf();
                    ba = (long) jVar.mf();
                    readUnsignedShort = 0;
                }
                if (readInt == 0 && ba == 0 && readUnsignedShort == 0) {
                    jVar.setPosition(i3);
                    return true;
                }
                long j;
                Object obj;
                if (i != 4 || z) {
                    j = ba;
                } else if ((8421504 & ba) != 0) {
                    jVar.setPosition(i3);
                    return false;
                } else {
                    j = (((ba >> 24) & 255) << 21) | (((255 & ba) | (((ba >> 8) & 255) << 7)) | (((ba >> 16) & 255) << 14));
                }
                Object obj2 = null;
                if (i == 4) {
                    obj2 = (readUnsignedShort & 64) != 0 ? 1 : null;
                    obj = (readUnsignedShort & 1) != 0 ? 1 : null;
                } else if (i == 3) {
                    obj2 = (readUnsignedShort & 32) != 0 ? 1 : null;
                    obj = (readUnsignedShort & 128) != 0 ? 1 : null;
                } else {
                    obj = null;
                }
                int i4 = 0;
                if (obj2 != null) {
                    i4 = 1;
                }
                if (obj != null) {
                    i4 += 4;
                }
                if (j < ((long) i4)) {
                    jVar.setPosition(i3);
                    return false;
                } else if (((long) jVar.me()) < j) {
                    return false;
                } else {
                    jVar.da((int) j);
                }
            } finally {
                jVar.setPosition(i3);
            }
        }
        jVar.setPosition(i3);
        return true;
    }

    private static Id3Frame a(int i, j jVar, boolean z, int i2, a aVar) {
        int mh;
        int readUnsignedByte = jVar.readUnsignedByte();
        int readUnsignedByte2 = jVar.readUnsignedByte();
        int readUnsignedByte3 = jVar.readUnsignedByte();
        int readUnsignedByte4 = i >= 3 ? jVar.readUnsignedByte() : 0;
        if (i == 4) {
            mh = jVar.mh();
            if (!z) {
                mh = (((mh & 255) | (((mh >> 8) & 255) << 7)) | (((mh >> 16) & 255) << 14)) | (((mh >> 24) & 255) << 21);
            }
        } else if (i == 3) {
            mh = jVar.mh();
        } else {
            mh = jVar.mf();
        }
        int readUnsignedShort = i >= 3 ? jVar.readUnsignedShort() : 0;
        if (readUnsignedByte == 0 && readUnsignedByte2 == 0 && readUnsignedByte3 == 0 && readUnsignedByte4 == 0 && mh == 0 && readUnsignedShort == 0) {
            jVar.setPosition(jVar.limit);
            return null;
        }
        int i3 = jVar.position + mh;
        if (i3 > jVar.limit) {
            jVar.setPosition(jVar.limit);
            return null;
        } else if (aVar == null || aVar.f(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)) {
            int i4;
            Object obj = null;
            Object obj2 = null;
            Object obj3 = null;
            Object i42 = null;
            Object obj4 = null;
            Object obj5;
            if (i == 3) {
                Object obj6;
                obj5 = (readUnsignedShort & 128) != 0 ? 1 : null;
                obj2 = (readUnsignedShort & 64) != 0 ? 1 : null;
                if ((readUnsignedShort & 32) != 0) {
                    obj6 = 1;
                } else {
                    obj6 = null;
                }
                i42 = obj5;
                obj4 = obj6;
                obj = obj5;
            } else if (i == 4) {
                obj5 = (readUnsignedShort & 64) != 0 ? 1 : null;
                obj = (readUnsignedShort & 8) != 0 ? 1 : null;
                obj2 = (readUnsignedShort & 4) != 0 ? 1 : null;
                obj3 = (readUnsignedShort & 2) != 0 ? 1 : null;
                if ((readUnsignedShort & 1) != 0) {
                    i42 = 1;
                    obj4 = obj5;
                } else {
                    i42 = null;
                    obj4 = obj5;
                }
            }
            if (obj == null && obj2 == null) {
                int i5;
                Id3Frame id3Frame;
                if (obj4 != null) {
                    i5 = mh - 1;
                    jVar.da(1);
                } else {
                    i5 = mh;
                }
                if (i42 != null) {
                    i5 -= 4;
                    jVar.da(4);
                }
                if (obj3 != null) {
                    i5 = d(jVar, i5);
                }
                int readUnsignedByte5;
                String cD;
                byte[] bArr;
                int g;
                String str;
                byte[] bArr2;
                int g2;
                String cD2;
                if (readUnsignedByte == 84 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        cD = cD(readUnsignedByte5);
                        bArr = new byte[(i5 - 1)];
                        jVar.readBytes(bArr, 0, i5 - 1);
                        g = g(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, g, cD);
                        g += cE(readUnsignedByte5);
                        if (g < bArr.length) {
                            cD = new String(bArr, g, g(bArr, g, readUnsignedByte5) - g, cD);
                        } else {
                            cD = "";
                        }
                        id3Frame = new TextInformationFrame("TXXX", str, cD);
                    }
                } else if (readUnsignedByte == 84) {
                    cD = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        String cD3 = cD(readUnsignedByte5);
                        byte[] bArr3 = new byte[(i5 - 1)];
                        jVar.readBytes(bArr3, 0, i5 - 1);
                        id3Frame = new TextInformationFrame(cD, null, new String(bArr3, 0, g(bArr3, 0, readUnsignedByte5), cD3));
                    }
                } else if (readUnsignedByte == 87 && readUnsignedByte2 == 88 && readUnsignedByte3 == 88 && (i == 2 || readUnsignedByte4 == 88)) {
                    if (i5 <= 0) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        cD = cD(readUnsignedByte5);
                        bArr = new byte[(i5 - 1)];
                        jVar.readBytes(bArr, 0, i5 - 1);
                        g = g(bArr, 0, readUnsignedByte5);
                        str = new String(bArr, 0, g, cD);
                        i42 = g + cE(readUnsignedByte5);
                        id3Frame = new UrlLinkFrame("WXXX", str, i42 < bArr.length ? new String(bArr, i42, d(bArr, i42) - i42, "ISO-8859-1") : "");
                    }
                } else if (readUnsignedByte == 87) {
                    cD = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr2 = new byte[i5];
                    jVar.readBytes(bArr2, 0, i5);
                    id3Frame = new UrlLinkFrame(cD, null, new String(bArr2, 0, d(bArr2, 0), "ISO-8859-1"));
                } else if (readUnsignedByte == 80 && readUnsignedByte2 == 82 && readUnsignedByte3 == 73 && readUnsignedByte4 == 86) {
                    bArr2 = new byte[i5];
                    jVar.readBytes(bArr2, 0, i5);
                    i42 = d(bArr2, 0);
                    id3Frame = new PrivFrame(new String(bArr2, 0, i42, "ISO-8859-1"), h(bArr2, i42 + 1, bArr2.length));
                } else if (readUnsignedByte == 71 && readUnsignedByte2 == 69 && readUnsignedByte3 == 79 && (readUnsignedByte4 == 66 || i == 2)) {
                    readUnsignedByte5 = jVar.readUnsignedByte();
                    cD = cD(readUnsignedByte5);
                    bArr = new byte[(i5 - 1)];
                    jVar.readBytes(bArr, 0, i5 - 1);
                    g = d(bArr, 0);
                    str = new String(bArr, 0, g, "ISO-8859-1");
                    g++;
                    g2 = g(bArr, g, readUnsignedByte5);
                    String str2 = new String(bArr, g, g2 - g, cD);
                    g = cE(readUnsignedByte5) + g2;
                    g2 = g(bArr, g, readUnsignedByte5);
                    id3Frame = new GeobFrame(str, str2, new String(bArr, g, g2 - g, cD), h(bArr, cE(readUnsignedByte5) + g2, bArr.length));
                } else if (!i != 2 ? !(readUnsignedByte == 80 && readUnsignedByte2 == 73 && readUnsignedByte3 == 67) : !(readUnsignedByte == 65 && readUnsignedByte2 == 80 && readUnsignedByte3 == 73 && readUnsignedByte4 == 67)) {
                    int readUnsignedByte6 = jVar.readUnsignedByte();
                    cD2 = cD(readUnsignedByte6);
                    byte[] bArr4 = new byte[(i5 - 1)];
                    jVar.readBytes(bArr4, 0, i5 - 1);
                    if (i == 2) {
                        readUnsignedByte5 = 2;
                        cD = "image/" + t.aC(new String(bArr4, 0, 3, "ISO-8859-1"));
                        if (cD.equals("image/jpg")) {
                            cD = "image/jpeg";
                        }
                    } else {
                        readUnsignedByte5 = d(bArr4, 0);
                        cD = t.aC(new String(bArr4, 0, readUnsignedByte5, "ISO-8859-1"));
                        if (cD.indexOf(47) == -1) {
                            cD = "image/" + cD;
                        }
                    }
                    g2 = bArr4[readUnsignedByte5 + 1] & 255;
                    readUnsignedByte5 += 2;
                    mh = g(bArr4, readUnsignedByte5, readUnsignedByte6);
                    id3Frame = new ApicFrame(cD, new String(bArr4, readUnsignedByte5, mh - readUnsignedByte5, cD2), g2, h(bArr4, cE(readUnsignedByte6) + mh, bArr4.length));
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 79 && readUnsignedByte3 == 77 && (readUnsignedByte4 == 77 || i == 2)) {
                    if (i5 < 4) {
                        id3Frame = null;
                    } else {
                        readUnsignedByte5 = jVar.readUnsignedByte();
                        cD = cD(readUnsignedByte5);
                        bArr = new byte[3];
                        jVar.readBytes(bArr, 0, 3);
                        cD2 = new String(bArr, 0, 3);
                        bArr = new byte[(i5 - 4)];
                        jVar.readBytes(bArr, 0, i5 - 4);
                        int g3 = g(bArr, 0, readUnsignedByte5);
                        String str3 = new String(bArr, 0, g3, cD);
                        g3 += cE(readUnsignedByte5);
                        id3Frame = new CommentFrame(cD2, str3, g3 < bArr.length ? new String(bArr, g3, g(bArr, g3, readUnsignedByte5) - g3, cD) : "");
                    }
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 72 && readUnsignedByte3 == 65 && readUnsignedByte4 == 80) {
                    id3Frame = a(jVar, i5, i, z, i2, aVar);
                } else if (readUnsignedByte == 67 && readUnsignedByte2 == 84 && readUnsignedByte3 == 79 && readUnsignedByte4 == 67) {
                    id3Frame = b(jVar, i5, i, z, i2, aVar);
                } else {
                    cD = g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4);
                    bArr = new byte[i5];
                    jVar.readBytes(bArr, 0, i5);
                    id3Frame = new BinaryFrame(cD, bArr);
                }
                if (id3Frame == null) {
                    try {
                        new StringBuilder("Failed to decode frame: id=").append(g(i, readUnsignedByte, readUnsignedByte2, readUnsignedByte3, readUnsignedByte4)).append(", frameSize=").append(i5);
                    } catch (UnsupportedEncodingException e) {
                        jVar.setPosition(i3);
                        return null;
                    } catch (Throwable th) {
                        jVar.setPosition(i3);
                    }
                }
                jVar.setPosition(i3);
                return id3Frame;
            }
            jVar.setPosition(i3);
            return null;
        } else {
            jVar.setPosition(i3);
            return null;
        }
    }

    private static ChapterFrame a(j jVar, int i, int i2, boolean z, int i3, a aVar) {
        int i4 = jVar.position;
        int d = d(jVar.data, i4);
        String str = new String(jVar.data, i4, d - i4, "ISO-8859-1");
        jVar.setPosition(d + 1);
        d = jVar.readInt();
        int readInt = jVar.readInt();
        long ba = jVar.ba();
        if (ba == 4294967295L) {
            ba = -1;
        }
        long ba2 = jVar.ba();
        if (ba2 == 4294967295L) {
            ba2 = -1;
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (jVar.position < i4) {
            Id3Frame a = a(i2, jVar, z, i3, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, d, readInt, ba, ba2, id3FrameArr);
    }

    private static ChapterTocFrame b(j jVar, int i, int i2, boolean z, int i3, a aVar) {
        int i4 = jVar.position;
        int d = d(jVar.data, i4);
        String str = new String(jVar.data, i4, d - i4, "ISO-8859-1");
        jVar.setPosition(d + 1);
        d = jVar.readUnsignedByte();
        boolean z2 = (d & 2) != 0;
        boolean z3 = (d & 1) != 0;
        int readUnsignedByte = jVar.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte];
        for (d = 0; d < readUnsignedByte; d++) {
            int i5 = jVar.position;
            int d2 = d(jVar.data, i5);
            strArr[d] = new String(jVar.data, i5, d2 - i5, "ISO-8859-1");
            jVar.setPosition(d2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        i4 += i;
        while (jVar.position < i4) {
            Id3Frame a = a(i2, jVar, z, i3, aVar);
            if (a != null) {
                arrayList.add(a);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static int d(j jVar, int i) {
        Object obj = jVar.data;
        int i2 = jVar.position;
        int i3 = i;
        while (i2 + 1 < i3) {
            if ((obj[i2] & 255) == 255 && obj[i2 + 1] == (byte) 0) {
                System.arraycopy(obj, i2 + 2, obj, i2 + 1, (i3 - i2) - 2);
                i3--;
            }
            i2++;
        }
        return i3;
    }

    private static String cD(int i) {
        switch (i) {
            case 0:
                return "ISO-8859-1";
            case 1:
                return "UTF-16";
            case 2:
                return "UTF-16BE";
            case 3:
                return "UTF-8";
            default:
                return "ISO-8859-1";
        }
    }

    private static String g(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static int g(byte[] bArr, int i, int i2) {
        int d = d(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return d;
        }
        while (d < bArr.length - 1) {
            if (d % 2 == 0 && bArr[d + 1] == (byte) 0) {
                return d;
            }
            d = d(bArr, d + 1);
        }
        return bArr.length;
    }

    private static int d(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == (byte) 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static int cE(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static byte[] h(byte[] bArr, int i, int i2) {
        if (i2 <= i) {
            return new byte[0];
        }
        return Arrays.copyOfRange(bArr, i, i2);
    }
}
