package com.tencent.tinker.a.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.f.e;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;

public final class f extends e {
    private final h vpY;
    private final c vpZ;
    private final boolean vqa = true;

    public f(h hVar, c cVar) {
        super(null);
        this.vpY = hVar;
        this.vpZ = cVar;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.vqa) {
            i5 = this.vpZ.HL(i5);
        }
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.vpY.c((short) i2);
                return;
            case 36:
            case 110:
            case 111:
            case TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW /*112*/:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 114:
                this.vpY.a(b.fL(i2, b.fM(0, 0)), (short) i3, b.B(0, 0, 0, 0));
                return;
            case 40:
                byte b;
                if (this.vqa) {
                    b = i5 - this.vpY.vpT;
                    if (b == ((byte) b)) {
                        this.vpY.c(b.fL(i2, b & 255));
                        return;
                    } else if (b != ((short) b)) {
                        this.vpY.a((short) 42, (short) b, (short) (b >> 16));
                        return;
                    } else {
                        this.vpY.c((short) 41, (short) b);
                        return;
                    }
                }
                b = i5 - this.vpY.vpT;
                if (b != ((byte) b)) {
                    throw new j("Target out of range: " + a.HP(b) + ", perhaps you need to enable force jumbo mode.");
                }
                this.vpY.c(b.fL(i2, b & 255));
                return;
            case 41:
                short s;
                if (this.vqa) {
                    short s2 = i5 - this.vpY.vpT;
                    if (s2 != ((short) s2)) {
                        this.vpY.a((short) 42, (short) s2, (short) (s2 >> 16));
                        return;
                    }
                    s = (short) i2;
                    this.vpY.c(s, (short) s2);
                    return;
                }
                s = (short) i2;
                this.vpY.c(s, b.fN(i5, this.vpY.vpT));
                return;
            case 42:
                int i6 = i5 - this.vpY.vpT;
                this.vpY.a((short) i2, (short) i6, (short) (i6 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.vqa) {
            i5 = this.vpZ.HL(i5);
        }
        int i7;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 29:
            case 30:
            case 39:
                this.vpY.c(b.fL(i2, i6));
                return;
            case 18:
                short s = (short) i2;
                h hVar = this.vpY;
                if (j < -8 || j > 7) {
                    throw new j("Literal out of range: " + a.gW(j));
                }
                hVar.c(b.fL(s, b.fM(i6, ((int) j) & 15)));
                return;
            case 19:
            case 22:
                this.vpY.c(b.fL(i2, i6), b.gV(j));
                return;
            case 20:
            case 23:
                if (j != ((long) ((int) j))) {
                    throw new j("Literal out of range: " + a.gW(j));
                }
                i7 = (int) j;
                this.vpY.a(b.fL(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 21:
            case 25:
                this.vpY.c(b.fL(i2, i6), (short) ((int) (j >> (i2 == 21 ? 16 : 48))));
                return;
            case 24:
                h hVar2 = this.vpY;
                short s2 = (short) ((int) j);
                short s3 = (short) ((int) (j >> 16));
                short s4 = (short) ((int) (j >> 32));
                short s5 = (short) ((int) (j >> 48));
                hVar2.c(b.fL(i2, i6));
                hVar2.c(s2);
                hVar2.c(s3);
                hVar2.c(s4);
                hVar2.c(s5);
                return;
            case 26:
                if (this.vqa) {
                    if (i3 > 65535) {
                        this.vpY.a(b.fL(27, i6), (short) i3, (short) (i3 >> 16));
                        return;
                    } else {
                        this.vpY.c(b.fL(i2, i6), (short) i3);
                        return;
                    }
                } else if (i3 > 65535) {
                    throw new j("string index out of bound: " + a.HM(i3) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.vpY.c(b.fL(i2, i6), (short) i3);
                    return;
                }
            case 27:
                this.vpY.a(b.fL(i2, i6), (short) i3, (short) (i3 >> 16));
                return;
            case 28:
            case 31:
            case 34:
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
                this.vpY.c(b.fL(i2, i6), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW /*112*/:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 114:
                this.vpY.a(b.fL(i2, b.fM(0, 1)), (short) i3, b.B(i6, 0, 0, 0));
                return;
            case 38:
            case 43:
            case 44:
                switch (i2) {
                    case 43:
                    case 44:
                        this.vpY.fK(i5, this.vpY.vpT);
                        break;
                }
                i7 = i5 - this.vpY.vpT;
                this.vpY.a(b.fL(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
                this.vpY.c(b.fL(i2, i6), b.fN(i5, this.vpY.vpT));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.vqa) {
            i5 = this.vpZ.HL(i5);
        }
        switch (i2) {
            case 1:
            case 4:
            case 7:
            case 33:
            case TbsListener$ErrorCode.DOWNLOAD_RETRYTIMES302_EXCEED /*123*/:
            case TbsListener$ErrorCode.DOWNLOAD_REDIRECT_EMPTY /*124*/:
            case TbsListener$ErrorCode.DOWNLOAD_THROWABLE /*125*/:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 188:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case TbsListener$ErrorCode.EXCEED_UNZIP_RETRY_NUM /*201*/:
            case TbsListener$ErrorCode.APK_PATH_ERROR /*202*/:
            case TbsListener$ErrorCode.APK_VERSION_ERROR /*203*/:
            case TbsListener$ErrorCode.APK_INVALID /*204*/:
            case 205:
            case TbsListener$ErrorCode.UNZIP_IO_ERROR /*206*/:
            case TbsListener$ErrorCode.UNZIP_OTHER_ERROR /*207*/:
                this.vpY.c(b.fL((short) i2, b.fM(i6, i7)));
                return;
            case 2:
            case 5:
            case 8:
                this.vpY.c(b.fL(i2, i6), b.HI(i7));
                return;
            case 3:
            case 6:
            case 9:
                this.vpY.a((short) i2, b.HH(i6), b.HI(i7));
                return;
            case 32:
            case 35:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                this.vpY.c(b.fL(i2, b.fM(i6, i7)), (short) i3);
                return;
            case 36:
            case 110:
            case 111:
            case TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW /*112*/:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 114:
                this.vpY.a(b.fL(i2, b.fM(0, 2)), (short) i3, b.B(i6, i7, 0, 0));
                return;
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
                this.vpY.c(b.fL(i2, b.fM(i6, i7)), b.fN(i5, this.vpY.vpT));
                return;
            case TbsListener$ErrorCode.EXCEED_DEXOPT_RETRY_NUM /*208*/:
            case 209:
            case 210:
            case 211:
            case TbsListener$ErrorCode.COPY_FAIL /*212*/:
            case 213:
            case 214:
            case 215:
                this.vpY.c(b.fL(i2, b.fM(i6, i7)), b.gV(j));
                return;
            case 216:
            case TbsListener$ErrorCode.INCR_UPDATE_FAIL /*217*/:
            case TbsListener$ErrorCode.INCR_UPDATE_EXCEPTION /*218*/:
            case TbsListener$ErrorCode.RENAME_EXCEPTION /*219*/:
            case TbsListener$ErrorCode.COPY_INSTALL_SUCCESS /*220*/:
            case TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS /*221*/:
            case TbsListener$ErrorCode.UNLZMA_FAIURE /*222*/:
            case TbsListener$ErrorCode.EXCEED_LZMA_RETRY_NUM /*223*/:
            case TbsListener$ErrorCode.EXCEED_INCR_UPDATE /*224*/:
            case TbsListener$ErrorCode.CREATE_TEMP_CONF_ERROR /*225*/:
            case TbsListener$ErrorCode.DEXOAT_EXCEPTION /*226*/:
                h hVar = this.vpY;
                short fL = b.fL(i2, i6);
                if (j != ((long) ((byte) ((int) j)))) {
                    throw new j("Literal out of range: " + a.gW(j));
                }
                hVar.c(fL, b.fL(i7, ((int) j) & 255));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW /*112*/:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 114:
                this.vpY.a(b.fL(i2, b.fM(0, 3)), (short) i3, b.B(i6, i7, i8, 0));
                return;
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case e.CTRL_INDEX /*144*/:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
            case 167:
            case 168:
            case 169:
            case 170:
            case 171:
            case 172:
            case 173:
            case 174:
            case 175:
                this.vpY.c(b.fL(i2, i6), b.fL(i7, i8));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW /*112*/:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 114:
                this.vpY.a(b.fL(i2, b.fM(0, 4)), (short) i3, b.B(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        switch (i2) {
            case 36:
            case 110:
            case 111:
            case TbsListener$ErrorCode.DOWNLOAD_OVER_FLOW /*112*/:
            case TbsListener$ErrorCode.DOWNLOAD_FILE_CONTENTLENGTH_NOT_MATCH /*113*/:
            case 114:
                this.vpY.a(b.fL(i2, b.fM(i10, 5)), (short) i3, b.B(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        switch (i2) {
            case 37:
            case 116:
            case 117:
            case 118:
            case 119:
            case TbsListener$ErrorCode.DOWNLOAD_HAS_LOCAL_TBS_ERROR /*120*/:
                this.vpY.a(b.fL(i2, i7), (short) i3, b.HH(i6));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        int length;
        int i3 = 0;
        int cGQ = this.vpY.cGQ();
        this.vpY.c((short) i2);
        this.vpY.c(b.HF(iArr2.length));
        for (int writeInt : iArr) {
            this.vpY.writeInt(writeInt);
        }
        if (this.vqa) {
            length = iArr2.length;
            while (i3 < length) {
                this.vpY.writeInt(this.vpZ.HL(iArr2[i3]) - cGQ);
                i3++;
            }
            return;
        }
        length = iArr2.length;
        while (i3 < length) {
            this.vpY.writeInt(iArr2[i3] - cGQ);
            i3++;
        }
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int cGQ = this.vpY.cGQ();
        this.vpY.c((short) i2);
        this.vpY.c(b.HF(iArr.length));
        this.vpY.writeInt(i3);
        int length;
        if (this.vqa) {
            length = iArr.length;
            while (i4 < length) {
                this.vpY.writeInt(this.vpZ.HL(iArr[i4]) - cGQ);
                i4++;
            }
            return;
        }
        length = iArr.length;
        while (i4 < length) {
            this.vpY.writeInt(iArr[i4] - cGQ);
            i4++;
        }
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        int i5 = 0;
        this.vpY.c((short) i2);
        this.vpY.c((short) i4);
        this.vpY.writeInt(i3);
        h hVar;
        int length;
        switch (i4) {
            case 1:
                h hVar2 = this.vpY;
                int i6 = 1;
                int i7 = 0;
                for (byte b : (byte[]) obj) {
                    if (i6 != 0) {
                        i7 = b & 255;
                        i6 = 0;
                    } else {
                        i7 |= b << 8;
                        hVar2.c((short) i7);
                        i6 = 1;
                    }
                }
                if (i6 == 0) {
                    hVar2.c((short) i7);
                    return;
                }
                return;
            case 2:
                hVar = this.vpY;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i5 < length) {
                    hVar.c(sArr[i5]);
                    i5++;
                }
                return;
            case 4:
                hVar = this.vpY;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i5 < length) {
                    hVar.writeInt(iArr[i5]);
                    i5++;
                }
                return;
            case 8:
                hVar = this.vpY;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i5 < length) {
                    long j = jArr[i5];
                    hVar.c((short) ((int) j));
                    hVar.c((short) ((int) (j >> 16)));
                    hVar.c((short) ((int) (j >> 32)));
                    hVar.c((short) ((int) (j >> 48)));
                    i5++;
                }
                return;
            default:
                throw new j("bogus element_width: " + a.HN(i4));
        }
    }
}
