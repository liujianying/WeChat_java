package com.google.android.exoplayer2.c.b;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.b.a.a;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.i.c;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.t;
import com.tencent.map.lib.mapstructure.MapRouteSectionWithName;
import com.tencent.mm.plugin.appbrand.jsapi.h.f;
import com.tencent.mm.plugin.sns.i$l;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class b {
    private static final int akP = t.aE("meta");
    private static final int alh = t.aE("vide");
    private static final int ali = t.aE("soun");
    private static final int alj = t.aE("text");
    private static final int alk = t.aE("sbtl");
    private static final int all = t.aE("subt");
    private static final int alm = t.aE("clcp");
    private static final int aln = t.aE("cenc");

    public static e a(a aVar, com.google.android.exoplayer2.c.b.a.b bVar, long j, DrmInitData drmInitData, boolean z) {
        a cw = aVar.cw(a.ajS);
        j jVar = cw.cv(a.akg).alg;
        jVar.setPosition(16);
        int readInt = jVar.readInt();
        int i = readInt == ali ? 1 : readInt == alh ? 2 : (readInt == alj || readInt == alk || readInt == all || readInt == alm) ? 3 : readInt == akP ? 4 : -1;
        if (i == -1) {
            return null;
        }
        int i2;
        long j2;
        long j3;
        j jVar2 = aVar.cv(a.akc).alg;
        jVar2.setPosition(8);
        int cs = a.cs(jVar2.readInt());
        jVar2.da(cs == 0 ? 8 : 16);
        int readInt2 = jVar2.readInt();
        jVar2.da(4);
        Object obj = 1;
        int i3 = jVar2.position;
        readInt = cs == 0 ? 4 : 8;
        for (i2 = 0; i2 < readInt; i2++) {
            if (jVar2.data[i3 + i2] != (byte) -1) {
                obj = null;
                break;
            }
        }
        if (obj != null) {
            jVar2.da(readInt);
            j2 = -9223372036854775807L;
        } else {
            j2 = cs == 0 ? jVar2.ba() : jVar2.mi();
            if (j2 == 0) {
                j2 = -9223372036854775807L;
            }
        }
        jVar2.da(16);
        i2 = jVar2.readInt();
        cs = jVar2.readInt();
        jVar2.da(4);
        i3 = jVar2.readInt();
        int readInt3 = jVar2.readInt();
        i2 = (i2 == 0 && cs == 65536 && i3 == -65536 && readInt3 == 0) ? 90 : (i2 == 0 && cs == -65536 && i3 == 65536 && readInt3 == 0) ? f.CTRL_INDEX : (i2 == -65536 && cs == 0 && i3 == 0 && readInt3 == -65536) ? 180 : 0;
        b bVar2 = new b(readInt2, j2, i2);
        if (j == -9223372036854775807L) {
            j2 = bVar2.duration;
        } else {
            j2 = j;
        }
        jVar2 = bVar.alg;
        jVar2.setPosition(8);
        jVar2.da(a.cs(jVar2.readInt()) == 0 ? 8 : 16);
        long ba = jVar2.ba();
        if (j2 == -9223372036854775807L) {
            j3 = -9223372036854775807L;
        } else {
            j3 = t.a(j2, 1000000, ba);
        }
        a cw2 = cw.cw(a.ajT).cw(a.ajU);
        j jVar3 = cw.cv(a.akf).alg;
        jVar3.setPosition(8);
        readInt3 = a.cs(jVar3.readInt());
        jVar3.da(readInt3 == 0 ? 8 : 16);
        long ba2 = jVar3.ba();
        jVar3.da(readInt3 == 0 ? 4 : 8);
        readInt = jVar3.readUnsignedShort();
        Pair create = Pair.create(Long.valueOf(ba2), ((char) (((readInt >> 10) & 31) + 96)) + ((char) (((readInt >> 5) & 31) + 96)) + ((char) ((readInt & 31) + 96)));
        a a = a(cw2.cv(a.akh).alg, bVar2.id, bVar2.aeb, (String) create.second, drmInitData);
        long[] jArr = null;
        long[] jArr2 = null;
        if (!z) {
            Pair a2 = a(aVar.cw(a.akd));
            jArr2 = (long[]) a2.second;
            jArr = (long[]) a2.first;
        }
        if (a.aep == null) {
            return null;
        }
        return new e(bVar2.id, i, ((Long) create.first).longValue(), ba, j3, a.aep, a.alq, a.alo, a.alp, jArr, jArr2);
    }

    private static a a(j jVar, int i, int i2, String str, DrmInitData drmInitData) {
        jVar.setPosition(12);
        int readInt = jVar.readInt();
        a aVar = new a(readInt);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= readInt) {
                return aVar;
            }
            int i5 = jVar.position;
            int readInt2 = jVar.readInt();
            com.google.android.exoplayer2.i.a.b(readInt2 > 0, "childAtomSize should be positive");
            i3 = jVar.readInt();
            int readUnsignedShort;
            int readUnsignedShort2;
            int i6;
            int intValue;
            DrmInitData drmInitData2;
            int i7;
            String str2;
            String str3;
            int i8;
            if (i3 == a.ajp || i3 == a.ajq || i3 == a.akn || i3 == a.akz || i3 == a.ajr || i3 == a.ajs || i3 == a.ajt || i3 == a.akY || i3 == a.akZ) {
                DrmInitData drmInitData3;
                jVar.setPosition((i5 + 8) + 8);
                jVar.da(16);
                readUnsignedShort = jVar.readUnsignedShort();
                readUnsignedShort2 = jVar.readUnsignedShort();
                Object i82 = null;
                float f = 1.0f;
                jVar.da(50);
                i6 = jVar.position;
                if (i3 == a.akn) {
                    Pair a = a(jVar, i5, readInt2);
                    if (a != null) {
                        intValue = ((Integer) a.first).intValue();
                        if (drmInitData == null) {
                            drmInitData2 = null;
                        } else {
                            drmInitData2 = drmInitData.ai(((f) a.second).amk);
                        }
                        aVar.alo[i4] = (f) a.second;
                        i3 = intValue;
                    } else {
                        drmInitData2 = drmInitData;
                    }
                    jVar.setPosition(i6);
                    drmInitData3 = drmInitData2;
                    i7 = i3;
                } else {
                    drmInitData3 = drmInitData;
                    i7 = i3;
                }
                List list = null;
                str2 = null;
                byte[] bArr = null;
                int i9 = -1;
                while (i6 - i5 < readInt2) {
                    jVar.setPosition(i6);
                    int i10 = jVar.position;
                    int readInt3 = jVar.readInt();
                    if (readInt3 != 0 || jVar.position - i5 != readInt2) {
                        boolean z;
                        if (readInt3 > 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        com.google.android.exoplayer2.i.a.b(z, "childAtomSize should be positive");
                        i3 = jVar.readInt();
                        if (i3 == a.ajV) {
                            if (str2 == null) {
                                z = true;
                            } else {
                                z = false;
                            }
                            com.google.android.exoplayer2.i.a.ap(z);
                            str2 = "video/avc";
                            jVar.setPosition(i10 + 8);
                            com.google.android.exoplayer2.video.a m = com.google.android.exoplayer2.video.a.m(jVar);
                            list = m.adY;
                            aVar.alp = m.alp;
                            if (i82 == null) {
                                f = m.aCi;
                            }
                        } else if (i3 == a.ajW) {
                            com.google.android.exoplayer2.i.a.ap(str2 == null);
                            str2 = "video/hevc";
                            jVar.setPosition(i10 + 8);
                            com.google.android.exoplayer2.video.b o = com.google.android.exoplayer2.video.b.o(jVar);
                            list = o.adY;
                            aVar.alp = o.alp;
                        } else if (i3 == a.ala) {
                            com.google.android.exoplayer2.i.a.ap(str2 == null);
                            str2 = i7 == a.akY ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        } else if (i3 == a.aju) {
                            com.google.android.exoplayer2.i.a.ap(str2 == null);
                            str2 = "video/3gpp";
                        } else if (i3 == a.ajX) {
                            com.google.android.exoplayer2.i.a.ap(str2 == null);
                            Pair b = b(jVar, i10);
                            str3 = (String) b.first;
                            list = Collections.singletonList(b.second);
                            str2 = str3;
                        } else if (i3 == a.akw) {
                            jVar.setPosition(i10 + 8);
                            f = ((float) jVar.mh()) / ((float) jVar.mh());
                            i82 = 1;
                        } else if (i3 == a.akW) {
                            i3 = i10 + 8;
                            while (i3 - i10 < readInt3) {
                                jVar.setPosition(i3);
                                int readInt4 = jVar.readInt();
                                if (jVar.readInt() == a.akX) {
                                    bArr = Arrays.copyOfRange(jVar.data, i3, readInt4 + i3);
                                } else {
                                    i3 += readInt4;
                                }
                            }
                            bArr = null;
                        } else if (i3 == a.akV) {
                            i3 = jVar.readUnsignedByte();
                            jVar.da(3);
                            if (i3 == 0) {
                                switch (jVar.readUnsignedByte()) {
                                    case 0:
                                        i9 = 0;
                                        break;
                                    case 1:
                                        i9 = 1;
                                        break;
                                    case 2:
                                        i9 = 2;
                                        break;
                                    case 3:
                                        i9 = 3;
                                        break;
                                    default:
                                        break;
                                }
                            }
                        }
                        i6 += readInt3;
                    } else if (str2 != null) {
                        aVar.aep = Format.a(Integer.toString(i), str2, readUnsignedShort, readUnsignedShort2, list, i2, f, bArr, i9, drmInitData3);
                    }
                }
                if (str2 != null) {
                    aVar.aep = Format.a(Integer.toString(i), str2, readUnsignedShort, readUnsignedShort2, list, i2, f, bArr, i9, drmInitData3);
                }
            } else if (i3 == a.ajw || i3 == a.ako || i3 == a.ajB || i3 == a.ajD || i3 == a.ajF || i3 == a.ajI || i3 == a.ajG || i3 == a.ajH || i3 == a.akM || i3 == a.akN || i3 == a.ajz || i3 == a.ajA || i3 == a.ajx || i3 == a.alc) {
                Pair a2;
                DrmInitData drmInitData4;
                jVar.setPosition((i5 + 8) + 8);
                jVar.da(8);
                intValue = jVar.readUnsignedShort();
                jVar.da(6);
                byte[] bArr2 = jVar.data;
                readUnsignedShort = jVar.position;
                jVar.position = readUnsignedShort + 1;
                int i11 = (bArr2[readUnsignedShort] & 255) << 8;
                byte[] bArr3 = jVar.data;
                readUnsignedShort2 = jVar.position;
                jVar.position = readUnsignedShort2 + 1;
                i7 = i11 | (bArr3[readUnsignedShort2] & 255);
                jVar.position += 2;
                i82 = jVar.position;
                if (i3 == a.ako) {
                    a2 = a(jVar, i5, readInt2);
                    if (a2 != null) {
                        readUnsignedShort = ((Integer) a2.first).intValue();
                        drmInitData2 = drmInitData == null ? null : drmInitData.ai(((f) a2.second).amk);
                        aVar.alo[i4] = (f) a2.second;
                        i3 = readUnsignedShort;
                    } else {
                        drmInitData2 = drmInitData;
                    }
                    jVar.setPosition(i82);
                    drmInitData4 = drmInitData2;
                } else {
                    drmInitData4 = drmInitData;
                }
                str3 = i3 == a.ajB ? "audio/ac3" : i3 == a.ajD ? "audio/eac3" : i3 == a.ajF ? "audio/vnd.dts" : (i3 == a.ajG || i3 == a.ajH) ? "audio/vnd.dts.hd" : i3 == a.ajI ? "audio/vnd.dts.hd;profile=lbr" : i3 == a.akM ? "audio/3gpp" : i3 == a.akN ? "audio/amr-wb" : (i3 == a.ajz || i3 == a.ajA) ? "audio/raw" : i3 == a.ajx ? "audio/mpeg" : i3 == a.alc ? "audio/alac" : null;
                Object obj = null;
                str2 = str3;
                while (i82 - i5 < readInt2) {
                    jVar.setPosition(i82);
                    i6 = jVar.readInt();
                    com.google.android.exoplayer2.i.a.b(i6 > 0, "childAtomSize should be positive");
                    i3 = jVar.readInt();
                    if (i3 == a.ajX) {
                        Object obj2;
                        if (i3 == a.ajX) {
                            i3 = i82;
                        } else {
                            readUnsignedShort = jVar.position;
                            while (readUnsignedShort - i82 < i6) {
                                jVar.setPosition(readUnsignedShort);
                                readUnsignedShort2 = jVar.readInt();
                                com.google.android.exoplayer2.i.a.b(readUnsignedShort2 > 0, "childAtomSize should be positive");
                                if (jVar.readInt() == a.ajX) {
                                    i3 = readUnsignedShort;
                                } else {
                                    readUnsignedShort += readUnsignedShort2;
                                }
                            }
                            i3 = -1;
                        }
                        if (i3 != -1) {
                            Pair b2 = b(jVar, i3);
                            str2 = (String) b2.first;
                            obj2 = (byte[]) b2.second;
                            if ("audio/mp4a-latm".equals(str2)) {
                                a2 = c.i(obj2);
                                i7 = ((Integer) a2.first).intValue();
                                intValue = ((Integer) a2.second).intValue();
                            }
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    } else if (i3 == a.ajC) {
                        jVar.setPosition(i82 + 8);
                        aVar.aep = com.google.android.exoplayer2.a.a.a(jVar, Integer.toString(i), str, drmInitData4);
                    } else if (i3 == a.ajE) {
                        jVar.setPosition(i82 + 8);
                        aVar.aep = com.google.android.exoplayer2.a.a.b(jVar, Integer.toString(i), str, drmInitData4);
                    } else if (i3 == a.ajJ) {
                        aVar.aep = Format.a(Integer.toString(i), str2, -1, -1, intValue, i7, null, drmInitData4, str);
                    } else if (i3 == a.alc) {
                        obj = new byte[i6];
                        jVar.setPosition(i82);
                        jVar.readBytes(obj, 0, i6);
                    }
                    i82 += i6;
                }
                if (aVar.aep == null && str2 != null) {
                    aVar.aep = Format.a(Integer.toString(i), str2, -1, -1, intValue, i7, "audio/raw".equals(str2) ? 2 : -1, obj == null ? null : Collections.singletonList(obj), drmInitData4, str);
                }
            } else if (i3 == a.akx || i3 == a.akI || i3 == a.akJ || i3 == a.akK || i3 == a.akL) {
                String str4;
                jVar.setPosition((i5 + 8) + 8);
                List list2 = null;
                long j = Long.MAX_VALUE;
                if (i3 == a.akx) {
                    str4 = "application/ttml+xml";
                } else if (i3 == a.akI) {
                    str4 = "application/x-quicktime-tx3g";
                    i3 = (readInt2 - 8) - 8;
                    Object obj3 = new byte[i3];
                    jVar.readBytes(obj3, 0, i3);
                    list2 = Collections.singletonList(obj3);
                } else if (i3 == a.akJ) {
                    str4 = "application/x-mp4-vtt";
                } else if (i3 == a.akK) {
                    str4 = "application/ttml+xml";
                    j = 0;
                } else if (i3 == a.akL) {
                    str4 = "application/x-mp4-cea-608";
                    aVar.alq = 1;
                } else {
                    throw new IllegalStateException();
                }
                aVar.aep = Format.a(Integer.toString(i), str4, 0, str, -1, j, list2);
            } else if (i3 == a.alb) {
                aVar.aep = Format.h(Integer.toString(i), "application/x-camera-motion");
            }
            jVar.setPosition(i5 + readInt2);
            i3 = i4 + 1;
        }
    }

    private static Pair<long[], long[]> a(a aVar) {
        if (aVar != null) {
            com.google.android.exoplayer2.c.b.a.b cv = aVar.cv(a.ake);
            if (cv != null) {
                j jVar = cv.alg;
                jVar.setPosition(8);
                int cs = a.cs(jVar.readInt());
                int mh = jVar.mh();
                Object obj = new long[mh];
                Object obj2 = new long[mh];
                for (int i = 0; i < mh; i++) {
                    obj[i] = cs == 1 ? jVar.mi() : jVar.ba();
                    obj2[i] = cs == 1 ? jVar.readLong() : (long) jVar.readInt();
                    byte[] bArr = jVar.data;
                    int i2 = jVar.position;
                    jVar.position = i2 + 1;
                    int i3 = (bArr[i2] & 255) << 8;
                    byte[] bArr2 = jVar.data;
                    int i4 = jVar.position;
                    jVar.position = i4 + 1;
                    if (((short) (i3 | (bArr2[i4] & 255))) != (short) 1) {
                        throw new IllegalArgumentException("Unsupported media rate.");
                    }
                    jVar.da(2);
                }
                return Pair.create(obj, obj2);
            }
        }
        return Pair.create(null, null);
    }

    private static Pair<String, byte[]> b(j jVar, int i) {
        Object obj = null;
        jVar.setPosition((i + 8) + 4);
        jVar.da(1);
        a(jVar);
        jVar.da(2);
        int readUnsignedByte = jVar.readUnsignedByte();
        if ((readUnsignedByte & MapRouteSectionWithName.kMaxRoadNameLength) != 0) {
            jVar.da(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            jVar.da(jVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            jVar.da(2);
        }
        jVar.da(1);
        a(jVar);
        switch (jVar.readUnsignedByte()) {
            case i$l.AppCompatTheme_actionModeCutDrawable /*32*/:
                obj = "video/mp4v-es";
                break;
            case i$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                obj = "video/avc";
                break;
            case i$l.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                obj = "video/hevc";
                break;
            case i$l.AppCompatTheme_imageButtonStyle /*64*/:
            case i$l.AppCompatTheme_checkboxStyle /*102*/:
            case i$l.AppCompatTheme_checkedTextViewStyle /*103*/:
            case i$l.AppCompatTheme_editTextStyle /*104*/:
                obj = "audio/mp4a-latm";
                break;
            case i$l.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
            case i$l.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                obj = "video/mpeg2";
                break;
            case i$l.AppCompatTheme_ratingBarStyleIndicator /*107*/:
                return Pair.create("audio/mpeg", null);
            case 165:
                obj = "audio/ac3";
                break;
            case 166:
                obj = "audio/eac3";
                break;
            case 169:
            case 172:
                return Pair.create("audio/vnd.dts", null);
            case 170:
            case 171:
                return Pair.create("audio/vnd.dts.hd", null);
        }
        jVar.da(12);
        jVar.da(1);
        readUnsignedByte = a(jVar);
        Object obj2 = new byte[readUnsignedByte];
        jVar.readBytes(obj2, 0, readUnsignedByte);
        return Pair.create(obj, obj2);
    }

    private static Pair<Integer, f> a(j jVar, int i, int i2) {
        int i3 = jVar.position;
        while (true) {
            int i4 = i3;
            if (i4 - i >= i2) {
                return null;
            }
            jVar.setPosition(i4);
            int readInt = jVar.readInt();
            com.google.android.exoplayer2.i.a.b(readInt > 0, "childAtomSize should be positive");
            if (jVar.readInt() == a.akj) {
                int readInt2;
                Pair<Integer, f> create;
                int i5 = i4 + 8;
                int i6 = -1;
                int i7 = 0;
                String str = null;
                Integer num = null;
                while (i5 - i4 < readInt) {
                    Integer valueOf;
                    jVar.setPosition(i5);
                    readInt2 = jVar.readInt();
                    i3 = jVar.readInt();
                    if (i3 == a.akp) {
                        valueOf = Integer.valueOf(jVar.readInt());
                    } else if (i3 == a.akk) {
                        jVar.da(4);
                        str = jVar.readString(4);
                        valueOf = num;
                    } else if (i3 == a.akl) {
                        valueOf = num;
                        i7 = readInt2;
                        i6 = i5;
                    } else {
                        valueOf = num;
                    }
                    i5 += readInt2;
                    num = valueOf;
                }
                if ("cenc".equals(str) || "cbc1".equals(str) || "cens".equals(str) || "cbcs".equals(str)) {
                    Object fVar;
                    com.google.android.exoplayer2.i.a.b(num != null, "frma atom is mandatory");
                    com.google.android.exoplayer2.i.a.b(i6 != -1, "schi atom is mandatory");
                    i3 = i6 + 8;
                    while (i3 - i6 < i7) {
                        jVar.setPosition(i3);
                        readInt2 = jVar.readInt();
                        if (jVar.readInt() == a.akm) {
                            i3 = a.cs(jVar.readInt());
                            jVar.da(1);
                            i5 = 0;
                            int i8 = 0;
                            if (i3 == 0) {
                                jVar.da(1);
                            } else {
                                i3 = jVar.readUnsignedByte();
                                i5 = (i3 & 240) >> 4;
                                i8 = i3 & 15;
                            }
                            boolean z = jVar.readUnsignedByte() == 1;
                            readInt2 = jVar.readUnsignedByte();
                            byte[] bArr = new byte[16];
                            jVar.readBytes(bArr, 0, 16);
                            byte[] bArr2 = null;
                            if (z && readInt2 == 0) {
                                i3 = jVar.readUnsignedByte();
                                bArr2 = new byte[i3];
                                jVar.readBytes(bArr2, 0, i3);
                            }
                            fVar = new f(z, str, readInt2, bArr, i5, i8, bArr2);
                            com.google.android.exoplayer2.i.a.b(fVar == null, "tenc atom is mandatory");
                            create = Pair.create(num, fVar);
                        } else {
                            i3 += readInt2;
                        }
                    }
                    fVar = null;
                    if (fVar == null) {
                    }
                    com.google.android.exoplayer2.i.a.b(fVar == null, "tenc atom is mandatory");
                    create = Pair.create(num, fVar);
                } else {
                    create = null;
                }
                if (create != null) {
                    return create;
                }
            }
            i3 = i4 + readInt;
        }
    }

    private static int a(j jVar) {
        int readUnsignedByte = jVar.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & MapRouteSectionWithName.kMaxRoadNameLength) == MapRouteSectionWithName.kMaxRoadNameLength) {
            readUnsignedByte = jVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
