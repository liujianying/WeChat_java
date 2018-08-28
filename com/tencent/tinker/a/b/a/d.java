package com.tencent.tinker.a.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;

public final class d {
    private final g vpW;

    public d(g gVar) {
        this.vpW = gVar;
    }

    public final void a(e eVar) {
        g gVar = this.vpW;
        gVar.vpS.fi = 0;
        gVar.vpT = 0;
        while (true) {
            gVar = this.vpW;
            if ((gVar.vpT < gVar.vqb.length ? 1 : null) != null) {
                int i = this.vpW.vpT;
                int read = this.vpW.read();
                int i2 = read & b.CTRL_BYTE;
                if (i2 == 0 || i2 == b.CTRL_BYTE) {
                    i2 = read;
                }
                int i3;
                int i4;
                int read2;
                int i5;
                int i6;
                int HJ;
                int readInt;
                int[] iArr;
                switch (i2) {
                    case -1:
                        eVar.a(i, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, (long) b.HG(read));
                        break;
                    case 1:
                    case 4:
                    case 7:
                    case 33:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case 133:
                    case c.CTRL_INDEX /*134*/:
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
                    case n.CTRL_BYTE /*188*/:
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
                    case 201:
                    case 202:
                    case 203:
                    case 204:
                    case 205:
                    case 206:
                    case 207:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, 0, b.HG(read), this.vpW.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, (long) b.HG(read), this.vpW.read(), this.vpW.read());
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 15:
                    case 16:
                    case 17:
                    case 29:
                    case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                    case 39:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, 0, b.HG(read));
                        break;
                    case 18:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, (long) ((short) this.vpW.read()), b.HG(read));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, (long) this.vpW.readInt(), b.HG(read));
                        break;
                    case 21:
                    case 25:
                        i3 = read & b.CTRL_BYTE;
                        eVar.a(i, i3, 0, 1, 0, ((long) ((short) this.vpW.read())) << (i3 == 21 ? 16 : 48), b.HG(read));
                        break;
                    case 24:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, this.vpW.readLong(), b.HG(read));
                        break;
                    case 26:
                    case 28:
                    case 31:
                    case 34:
                    case a$k.AppCompatTheme_buttonBarPositiveButtonStyle /*96*/:
                    case a$k.AppCompatTheme_buttonBarNegativeButtonStyle /*97*/:
                    case a$k.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                    case a$k.AppCompatTheme_autoCompleteTextViewStyle /*99*/:
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
                        i3 = read & b.CTRL_BYTE;
                        eVar.a(i, i3, this.vpW.read(), b.HJ(i3), 0, 0, b.HG(read));
                        break;
                    case 27:
                        i3 = read & b.CTRL_BYTE;
                        eVar.a(i, i3, this.vpW.readInt(), b.HJ(i3), 0, 0, b.HG(read));
                        break;
                    case a$k.AppCompatTheme_actionModeCutDrawable /*32*/:
                    case a$k.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                    case a$k.AppCompatTheme_colorPrimary /*82*/:
                    case a$k.AppCompatTheme_colorPrimaryDark /*83*/:
                    case a$k.AppCompatTheme_colorAccent /*84*/:
                    case a$k.AppCompatTheme_colorControlNormal /*85*/:
                    case 86:
                    case a$k.AppCompatTheme_colorControlHighlight /*87*/:
                    case a$k.AppCompatTheme_colorButtonNormal /*88*/:
                    case a$k.AppCompatTheme_colorSwitchThumbNormal /*89*/:
                    case a$k.AppCompatTheme_controlBackground /*90*/:
                    case a$k.AppCompatTheme_alertDialogStyle /*91*/:
                    case a$k.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                    case a$k.AppCompatTheme_alertDialogCenterButtons /*93*/:
                    case a$k.AppCompatTheme_alertDialogTheme /*94*/:
                    case a$k.AppCompatTheme_textColorAlertDialogListItem /*95*/:
                        i4 = read & b.CTRL_BYTE;
                        eVar.a(i, i4, this.vpW.read(), b.HJ(i4), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case a$k.AppCompatTheme_actionModeShareDrawable /*36*/:
                    case 110:
                    case 111:
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    case 113:
                    case 114:
                        int i7 = read & b.CTRL_BYTE;
                        int i8 = (read >> 8) & 15;
                        i2 = (read >> 12) & 15;
                        read2 = this.vpW.read();
                        read = this.vpW.read();
                        i5 = read & 15;
                        i3 = (read >> 4) & 15;
                        i4 = (read >> 8) & 15;
                        i6 = (read >> 12) & 15;
                        HJ = b.HJ(i7);
                        switch (i2) {
                            case 0:
                                eVar.a(i, i7, read2, HJ, 0, 0);
                                break;
                            case 1:
                                eVar.a(i, i7, read2, HJ, 0, 0, i5);
                                break;
                            case 2:
                                eVar.a(i, i7, read2, HJ, 0, 0, i5, i3);
                                break;
                            case 3:
                                eVar.a(i, i7, read2, HJ, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                eVar.a(i, i7, read2, HJ, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                eVar.a(i, i7, read2, HJ, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new j("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case a$k.AppCompatTheme_actionModeFindDrawable /*37*/:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                        i4 = read & b.CTRL_BYTE;
                        eVar.b(i, i4, this.vpW.read(), b.HJ(i4), 0, 0, this.vpW.read(), b.HG(read));
                        break;
                    case a$k.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                    case a$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                    case a$k.AppCompatTheme_listDividerAlertDialog /*44*/:
                        i3 = read & b.CTRL_BYTE;
                        i5 = b.HG(read);
                        readInt = i + this.vpW.readInt();
                        switch (i3) {
                            case a$k.AppCompatTheme_dialogPreferredPadding /*43*/:
                            case a$k.AppCompatTheme_listDividerAlertDialog /*44*/:
                                this.vpW.fK(readInt + 1, i);
                                break;
                        }
                        eVar.a(i, i3, 0, 1, readInt, 0, i5);
                        break;
                    case a$k.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, i + ((byte) b.HG(read)), 0);
                        break;
                    case a$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, i + ((short) this.vpW.read()), (long) b.HG(read));
                        break;
                    case a$k.AppCompatTheme_dialogTheme /*42*/:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, i + this.vpW.readInt(), (long) b.HG(read));
                        break;
                    case a$k.AppCompatTheme_actionDropDownStyle /*45*/:
                    case a$k.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                    case a$k.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
                    case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
                    case a$k.AppCompatTheme_actionButtonStyle /*49*/:
                    case a$k.AppCompatTheme_searchViewStyle /*68*/:
                    case a$k.AppCompatTheme_listPreferredItemHeight /*69*/:
                    case a$k.AppCompatTheme_listPreferredItemHeightSmall /*70*/:
                    case a$k.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                    case 72:
                    case a$k.AppCompatTheme_listPreferredItemPaddingRight /*73*/:
                    case a$k.AppCompatTheme_dropDownListViewStyle /*74*/:
                    case a$k.AppCompatTheme_listPopupWindowStyle /*75*/:
                    case a$k.AppCompatTheme_textAppearanceListItem /*76*/:
                    case 77:
                    case a$k.AppCompatTheme_panelBackground /*78*/:
                    case a$k.AppCompatTheme_panelMenuListWidth /*79*/:
                    case a$k.AppCompatTheme_panelMenuListTheme /*80*/:
                    case a$k.AppCompatTheme_listChoiceBackgroundIndicator /*81*/:
                    case 144:
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
                    case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
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
                        i6 = read & b.CTRL_BYTE;
                        i5 = b.HG(read);
                        i2 = this.vpW.read();
                        eVar.a(i, i6, 0, 1, 0, 0, i5, i2 & b.CTRL_BYTE, b.HG(i2));
                        break;
                    case a$k.AppCompatTheme_buttonBarStyle /*50*/:
                    case a$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
                    case 52:
                    case a$k.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                    case a$k.AppCompatTheme_borderlessButtonStyle /*54*/:
                    case a$k.AppCompatTheme_dividerVertical /*55*/:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, i + ((short) this.vpW.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case a$k.AppCompatTheme_dividerHorizontal /*56*/:
                    case 57:
                    case a$k.AppCompatTheme_toolbarStyle /*58*/:
                    case 59:
                    case a$k.AppCompatTheme_popupMenuStyle /*60*/:
                    case a$k.AppCompatTheme_popupWindowStyle /*61*/:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, i + ((short) this.vpW.read()), 0, b.HG(read));
                        break;
                    case 208:
                    case 209:
                    case 210:
                    case 211:
                    case 212:
                    case 213:
                    case 214:
                    case 215:
                        eVar.a(i, read & b.CTRL_BYTE, 0, 1, 0, (long) ((short) this.vpW.read()), (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 216:
                    case 217:
                    case 218:
                    case 219:
                    case 220:
                    case 221:
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                    case 226:
                        i4 = read & b.CTRL_BYTE;
                        i5 = b.HG(read);
                        i2 = this.vpW.read();
                        eVar.a(i, i4, 0, 1, 0, (long) ((byte) b.HG(i2)), i5, i2 & b.CTRL_BYTE);
                        break;
                    case 256:
                        read2 = this.vpW.cGQ();
                        HJ = this.vpW.read();
                        readInt = this.vpW.readInt();
                        iArr = new int[HJ];
                        for (i2 = 0; i2 < HJ; i2++) {
                            iArr[i2] = this.vpW.readInt() + read2;
                        }
                        eVar.a(i, read, readInt, iArr);
                        break;
                    case 512:
                        read2 = this.vpW.cGQ();
                        HJ = this.vpW.read();
                        int[] iArr2 = new int[HJ];
                        iArr = new int[HJ];
                        for (i2 = 0; i2 < HJ; i2++) {
                            iArr2[i2] = this.vpW.readInt();
                        }
                        for (i2 = 0; i2 < HJ; i2++) {
                            iArr[i2] = this.vpW.readInt() + read2;
                        }
                        eVar.a(i, read, iArr2, iArr);
                        break;
                    case 768:
                        i2 = this.vpW.read();
                        int readInt2 = this.vpW.readInt();
                        Object obj;
                        switch (i2) {
                            case 1:
                                obj = new byte[readInt2];
                                Object obj2 = 1;
                                i2 = 0;
                                int i9 = 0;
                                while (i9 < readInt2) {
                                    if (obj2 != null) {
                                        i2 = this.vpW.read();
                                    }
                                    obj[i9] = (byte) (i2 & b.CTRL_BYTE);
                                    i9++;
                                    obj2 = obj2 == null ? 1 : null;
                                    i2 >>= 8;
                                }
                                eVar.a(i, read, obj, obj.length, 1);
                                break;
                            case 2:
                                obj = new short[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = (short) this.vpW.read();
                                }
                                eVar.a(i, read, obj, obj.length, 2);
                                break;
                            case 4:
                                obj = new int[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.vpW.readInt();
                                }
                                eVar.a(i, read, obj, obj.length, 4);
                                break;
                            case 8:
                                obj = new long[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.vpW.readLong();
                                }
                                eVar.a(i, read, obj, obj.length, 8);
                                break;
                            default:
                                throw new j("bogus element_width: " + a.HN(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + a.HM(i2));
                }
            }
            return;
        }
    }
}
