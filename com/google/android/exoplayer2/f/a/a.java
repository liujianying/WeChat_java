package com.google.android.exoplayer2.f.a;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aq;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wxpay.a$k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends d {
    private static final int[] Ab = new int[]{-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    private static final int[] awn = new int[]{11, 1, 3, 12, 14, 5, 7, 9};
    private static final int[] awo = new int[]{0, 4, 8, 12, 16, 20, 24, 28};
    private static final int[] awp = new int[]{32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, MMGIFException.D_GIF_ERR_IMAGE_DEFECT, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    private static final int[] awq = new int[]{174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, d.CTRL_BYTE, 226, 234, 238, 244, 251};
    private static final int[] awr = new int[]{193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, be.CTRL_INDEX, 219, 171, 187};
    private static final int[] aws = new int[]{195, GameJsApiGetOpenDeviceId.CTRL_BYTE, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    private int awA;
    private int awB;
    private boolean awC;
    private byte awD;
    private byte awE;
    private final j awt = new j();
    private final int awu;
    private final int awv;
    private final LinkedList<a> aww = new LinkedList();
    private a awx = new a(0, 4);
    private List<com.google.android.exoplayer2.f.a> awy;
    private List<com.google.android.exoplayer2.f.a> awz;

    private static class a {
        int acd;
        private int awA;
        int awB;
        final List<CharacterStyle> awF = new ArrayList();
        final List<a> awG = new ArrayList();
        final List<SpannableString> awH = new LinkedList();
        final SpannableStringBuilder awI = new SpannableStringBuilder();
        int awJ;
        int awK;
        int row;

        public a(int i, int i2) {
            reset(i, i2);
        }

        public final void reset(int i, int i2) {
            this.awF.clear();
            this.awG.clear();
            this.awH.clear();
            this.awI.clear();
            this.row = 15;
            this.acd = 0;
            this.awJ = 0;
            this.awA = i;
            this.awB = i2;
            this.awK = -1;
        }

        public final boolean isEmpty() {
            return this.awF.isEmpty() && this.awG.isEmpty() && this.awH.isEmpty() && this.awI.length() == 0;
        }

        public final void lu() {
            int length = this.awI.length();
            if (length > 0) {
                this.awI.delete(length - 1, length);
            }
        }

        public final void lv() {
            this.awH.add(lw());
            this.awI.clear();
            this.awF.clear();
            this.awG.clear();
            this.awK = -1;
            int min = Math.min(this.awB, this.row);
            while (this.awH.size() >= min) {
                this.awH.remove(0);
            }
        }

        public final void a(CharacterStyle characterStyle) {
            this.awF.add(characterStyle);
        }

        public final void a(CharacterStyle characterStyle, int i) {
            this.awG.add(new a(characterStyle, this.awI.length(), i));
        }

        public final void append(char c) {
            this.awI.append(c);
        }

        private SpannableString lw() {
            int i = 0;
            int length = this.awI.length();
            for (int i2 = 0; i2 < this.awF.size(); i2++) {
                this.awI.setSpan(this.awF.get(i2), 0, length, 33);
            }
            while (true) {
                int i3 = i;
                if (i3 >= this.awG.size()) {
                    break;
                }
                a aVar = (a) this.awG.get(i3);
                if (i3 < this.awG.size() - aVar.awM) {
                    i = ((a) this.awG.get(aVar.awM + i3)).start;
                } else {
                    i = length;
                }
                this.awI.setSpan(aVar.awL, aVar.start, i, 33);
                i = i3 + 1;
            }
            if (this.awK != -1) {
                this.awI.setSpan(new UnderlineSpan(), this.awK, length, 33);
            }
            return new SpannableString(this.awI);
        }

        public final com.google.android.exoplayer2.f.a lx() {
            int i;
            int i2 = 2;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (i = 0; i < this.awH.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.awH.get(i));
                spannableStringBuilder.append(10);
            }
            spannableStringBuilder.append(lw());
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            float f;
            int i3;
            int i4;
            int i5 = this.acd + this.awJ;
            i = (32 - i5) - spannableStringBuilder.length();
            int i6 = i5 - i;
            if (this.awA == 2 && Math.abs(i6) < 3) {
                f = 0.5f;
                i3 = 1;
            } else if (this.awA != 2 || i6 <= 0) {
                f = ((((float) i5) / 32.0f) * 0.8f) + 0.1f;
                i3 = 0;
            } else {
                f = ((((float) (32 - i)) / 32.0f) * 0.8f) + 0.1f;
                i3 = 2;
            }
            if (this.awA == 1 || this.row > 7) {
                i4 = (this.row - 15) - 2;
            } else {
                i4 = this.row;
                i2 = 0;
            }
            return new com.google.android.exoplayer2.f.a(spannableStringBuilder, Alignment.ALIGN_NORMAL, (float) i4, 1, i2, f, i3, Float.MIN_VALUE);
        }

        public final String toString() {
            return this.awI.toString();
        }
    }

    public final /* bridge */ /* synthetic */ void O(long j) {
        super.O(j);
    }

    public final /* bridge */ /* synthetic */ i ls() {
        return super.ls();
    }

    public final /* bridge */ /* synthetic */ h lt() {
        return super.lt();
    }

    public a(String str, int i) {
        this.awu = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        switch (i) {
            case 3:
            case 4:
                this.awv = 2;
                break;
            default:
                this.awv = 1;
                break;
        }
        cN(0);
        lr();
    }

    public final void flush() {
        super.flush();
        this.awy = null;
        this.awz = null;
        cN(0);
        lr();
        this.awB = 4;
        this.awC = false;
        this.awD = (byte) 0;
        this.awE = (byte) 0;
    }

    public final void release() {
    }

    protected final boolean lo() {
        return this.awy != this.awz;
    }

    protected final com.google.android.exoplayer2.f.d lp() {
        this.awz = this.awy;
        return new f(this.awy);
    }

    protected final void a(h hVar) {
        this.awt.m(hVar.aig.array(), hVar.aig.limit());
        boolean z = false;
        boolean z2 = false;
        while (this.awt.me() >= this.awu) {
            int i;
            if (this.awu == 2) {
                i = -4;
            } else {
                i = (byte) this.awt.readUnsignedByte();
            }
            byte readUnsignedByte = (byte) (this.awt.readUnsignedByte() & 127);
            byte readUnsignedByte2 = (byte) (this.awt.readUnsignedByte() & 127);
            if ((i & 6) == 4 && ((this.awv != 1 || (i & 1) == 0) && ((this.awv != 2 || (i & 1) == 1) && !(readUnsignedByte == (byte) 0 && readUnsignedByte2 == (byte) 0)))) {
                if ((readUnsignedByte & 247) == 17 && (readUnsignedByte2 & aq.CTRL_BYTE) == 48) {
                    this.awx.append((char) awq[readUnsignedByte2 & 15]);
                    z2 = true;
                } else if ((readUnsignedByte & 246) == 18 && (readUnsignedByte2 & 224) == 32) {
                    this.awx.lu();
                    if ((readUnsignedByte & 1) == 0) {
                        this.awx.append((char) awr[readUnsignedByte2 & 31]);
                        z2 = true;
                    } else {
                        this.awx.append((char) aws[readUnsignedByte2 & 31]);
                        z2 = true;
                    }
                } else if ((readUnsignedByte & 224) == 0) {
                    if ((readUnsignedByte & aq.CTRL_BYTE) == 16) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        if (this.awC && this.awD == readUnsignedByte && this.awE == readUnsignedByte2) {
                            this.awC = false;
                            z = true;
                            z2 = true;
                        } else {
                            this.awC = true;
                            this.awD = readUnsignedByte;
                            this.awE = readUnsignedByte2;
                        }
                    }
                    z = (readUnsignedByte & 247) == 17 && (readUnsignedByte2 & aq.CTRL_BYTE) == 32;
                    int i2;
                    if (!z) {
                        z = (readUnsignedByte & aq.CTRL_BYTE) == 16 && (readUnsignedByte2 & 192) == 64;
                        if (!z) {
                            z = (readUnsignedByte & 247) == 23 && readUnsignedByte2 >= (byte) 33 && readUnsignedByte2 <= (byte) 35;
                            if (!z) {
                                z = (readUnsignedByte & 247) == 20 && (readUnsignedByte2 & aq.CTRL_BYTE) == 32;
                                if (z) {
                                    switch (readUnsignedByte2) {
                                        case a$k.AppCompatTheme_actionModeCutDrawable /*32*/:
                                            cN(2);
                                            break;
                                        case a$k.AppCompatTheme_actionModeFindDrawable /*37*/:
                                            this.awB = 2;
                                            cN(1);
                                            break;
                                        case a$k.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                                            this.awB = 3;
                                            cN(1);
                                            break;
                                        case (byte) 39:
                                            this.awB = 4;
                                            cN(1);
                                            break;
                                        case a$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                                            cN(3);
                                            break;
                                        default:
                                            if (this.awA != 0) {
                                                switch (readUnsignedByte2) {
                                                    case (byte) 33:
                                                        this.awx.lu();
                                                        break;
                                                    case a$k.AppCompatTheme_listDividerAlertDialog /*44*/:
                                                        this.awy = null;
                                                        if (this.awA == 1 || this.awA == 3) {
                                                            lr();
                                                            break;
                                                        }
                                                    case a$k.AppCompatTheme_actionDropDownStyle /*45*/:
                                                        if (this.awA == 1 && !this.awx.isEmpty()) {
                                                            this.awx.lv();
                                                            break;
                                                        }
                                                    case a$k.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                                                        lr();
                                                        break;
                                                    case a$k.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                                                        this.awy = lq();
                                                        lr();
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                            }
                            this.awx.awJ = readUnsignedByte2 - 32;
                        } else {
                            i2 = awn[readUnsignedByte & 7];
                            if ((readUnsignedByte2 & 32) != 0) {
                                i2++;
                            }
                            if (i2 != this.awx.row) {
                                if (!(this.awA == 1 || this.awx.isEmpty())) {
                                    this.awx = new a(this.awA, this.awB);
                                    this.aww.add(this.awx);
                                }
                                this.awx.row = i2;
                            }
                            if ((readUnsignedByte2 & 1) == 1) {
                                this.awx.a(new UnderlineSpan());
                            }
                            i2 = (readUnsignedByte2 >> 1) & 15;
                            if (i2 > 7) {
                                this.awx.acd = awo[i2 & 7];
                            } else if (i2 == 7) {
                                this.awx.a(new StyleSpan(2));
                                this.awx.a(new ForegroundColorSpan(-1));
                            } else {
                                this.awx.a(new ForegroundColorSpan(Ab[i2]));
                            }
                        }
                    } else {
                        z = (readUnsignedByte2 & 1) == 1;
                        a aVar = this.awx;
                        if (z) {
                            aVar.awK = aVar.awI.length();
                        } else if (aVar.awK != -1) {
                            aVar.awI.setSpan(new UnderlineSpan(), aVar.awK, aVar.awI.length(), 33);
                            aVar.awK = -1;
                        }
                        i2 = (readUnsignedByte2 >> 1) & 15;
                        if (i2 == 7) {
                            this.awx.a(new StyleSpan(2), 2);
                            this.awx.a(new ForegroundColorSpan(-1), 1);
                        } else {
                            this.awx.a(new ForegroundColorSpan(Ab[i2]), 1);
                        }
                    }
                    z = z2;
                    z2 = true;
                } else {
                    this.awx.append(b(readUnsignedByte));
                    if ((readUnsignedByte2 & 224) != 0) {
                        this.awx.append(b(readUnsignedByte2));
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            if (!z) {
                this.awC = false;
            }
            if (this.awA == 1 || this.awA == 3) {
                this.awy = lq();
            }
        }
    }

    private List<com.google.android.exoplayer2.f.a> lq() {
        List<com.google.android.exoplayer2.f.a> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.aww.size()) {
                return arrayList;
            }
            com.google.android.exoplayer2.f.a lx = ((a) this.aww.get(i2)).lx();
            if (lx != null) {
                arrayList.add(lx);
            }
            i = i2 + 1;
        }
    }

    private void cN(int i) {
        if (this.awA != i) {
            int i2 = this.awA;
            this.awA = i;
            lr();
            if (i2 == 3 || i == 1 || i == 0) {
                this.awy = null;
            }
        }
    }

    private void lr() {
        this.awx.reset(this.awA, this.awB);
        this.aww.clear();
        this.aww.add(this.awx);
    }

    private static char b(byte b) {
        return (char) awp[(b & 127) - 32];
    }
}
