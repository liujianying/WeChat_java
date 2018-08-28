package com.tencent.tinker.a.b.a;

import android.support.design.a$i;
import com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.jsapi.f.h;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.au;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.tinker.a.c.b;

public final class c extends e {
    private final b vpU = new b();
    private int vpV = 0;

    public c() {
        super(null);
    }

    private void HK(int i) {
        if (i != this.vpV) {
            b bVar = this.vpU;
            int i2 = this.vpV;
            if (bVar.fi == 0 || i > bVar.tU[bVar.fi - 1]) {
                bVar.tU = b.d(bVar.tU, bVar.fi, i);
                bVar.vqe = b.d(bVar.vqe, bVar.fi, i2);
                bVar.fi++;
                return;
            }
            bVar.put(i, i2);
        }
    }

    public final int HL(int i) {
        int indexOfKey = this.vpU.indexOfKey(i);
        return indexOfKey < 0 ? i : this.vpU.vqe[indexOfKey];
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        HK(i);
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.vpV++;
                return;
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
            case 111:
            case 112:
            case 113:
            case 114:
                this.vpV += 3;
                return;
            case 40:
                byte b = i5 - this.vpV;
                if (b == ((byte) b)) {
                    this.vpV++;
                    return;
                } else if (b != ((short) b)) {
                    this.vpV += 3;
                    return;
                } else {
                    this.vpV += 2;
                    return;
                }
            case 41:
                short s = i5 - this.vpV;
                if (s != ((short) s)) {
                    this.vpV += 3;
                    return;
                } else {
                    this.vpV += 2;
                    return;
                }
            case a$i.AppCompatTheme_dialogTheme /*42*/:
                this.vpV += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        HK(i);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
            case 18:
            case a$i.AppCompatTheme_actionModeBackground /*29*/:
            case 30:
            case a$i.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                this.vpV++;
                return;
            case 19:
            case 21:
            case 22:
            case 25:
            case a$i.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
            case a$i.AppCompatTheme_actionModeCloseDrawable /*31*/:
            case a$i.AppCompatTheme_actionModePasteDrawable /*34*/:
            case a$i.AppCompatTheme_dividerHorizontal /*56*/:
            case a$i.AppCompatTheme_activityChooserViewStyle /*57*/:
            case 58:
            case a$i.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
            case 60:
            case 61:
            case 96:
            case 97:
            case 98:
            case 99:
            case a$i.AppCompatTheme_buttonStyle /*100*/:
            case 101:
            case 102:
            case 103:
            case a$i.AppCompatTheme_editTextStyle /*104*/:
            case a$i.AppCompatTheme_radioButtonStyle /*105*/:
            case a$i.AppCompatTheme_ratingBarStyle /*106*/:
            case a$i.AppCompatTheme_ratingBarStyleIndicator /*107*/:
            case 108:
            case a$i.AppCompatTheme_seekBarStyle /*109*/:
                this.vpV += 2;
                return;
            case 20:
            case 23:
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$i.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
            case a$i.AppCompatTheme_dialogPreferredPadding /*43*/:
            case a$i.AppCompatTheme_listDividerAlertDialog /*44*/:
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
            case 111:
            case 112:
            case 113:
            case 114:
                this.vpV += 3;
                return;
            case 24:
                this.vpV += 5;
                return;
            case 26:
                if (i3 > 65535) {
                    this.vpV += 3;
                    return;
                } else {
                    this.vpV += 2;
                    return;
                }
            case a$i.AppCompatTheme_actionModeStyle /*27*/:
                this.vpV += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        HK(i);
        switch (i2) {
            case 1:
            case 4:
            case 7:
            case a$i.AppCompatTheme_actionModeCopyDrawable /*33*/:
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
            case d.CTRL_INDEX /*133*/:
            case 134:
            case 135:
            case h.CTRL_INDEX /*136*/:
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
            case au.CTRL_BYTE /*182*/:
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
            case JsApiChooseMedia.CTRL_INDEX /*193*/:
            case 194:
            case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
            case 201:
            case 202:
            case com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX /*203*/:
            case 204:
            case 205:
            case 206:
            case 207:
                this.vpV++;
                return;
            case 2:
            case 5:
            case 8:
                this.vpV += 2;
                return;
            case 3:
            case 6:
            case 9:
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
            case 111:
            case 112:
            case 113:
            case 114:
                this.vpV += 3;
                return;
            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
            case a$i.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 82:
            case 83:
            case a$i.AppCompatTheme_colorAccent /*84*/:
            case 85:
            case a$i.AppCompatTheme_colorControlActivated /*86*/:
            case a$i.AppCompatTheme_colorControlHighlight /*87*/:
            case a$i.AppCompatTheme_colorButtonNormal /*88*/:
            case a$i.AppCompatTheme_colorSwitchThumbNormal /*89*/:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 208:
            case 209:
            case 210:
            case 211:
            case 212:
            case 213:
            case 214:
            case 215:
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
            case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*226*/:
                this.vpV += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        HK(i);
        switch (i2) {
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
            case 111:
            case 112:
            case 113:
            case 114:
                this.vpV += 3;
                return;
            case a$i.AppCompatTheme_actionDropDownStyle /*45*/:
            case a$i.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
            case a$i.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
            case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
            case a$i.AppCompatTheme_actionButtonStyle /*49*/:
            case a$i.AppCompatTheme_searchViewStyle /*68*/:
            case 69:
            case 70:
            case a$i.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
            case a$i.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
            case a$i.AppCompatTheme_listPreferredItemPaddingRight /*73*/:
            case 74:
            case a$i.AppCompatTheme_listPopupWindowStyle /*75*/:
            case a$i.AppCompatTheme_textAppearanceListItem /*76*/:
            case a$i.AppCompatTheme_textAppearanceListItemSmall /*77*/:
            case a$i.AppCompatTheme_panelBackground /*78*/:
            case a$i.AppCompatTheme_panelMenuListWidth /*79*/:
            case 80:
            case 81:
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
                this.vpV += 2;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        HK(i);
        switch (i2) {
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
            case 111:
            case 112:
            case 113:
            case 114:
                this.vpV += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        HK(i);
        switch (i2) {
            case a$i.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$i.AppCompatTheme_spinnerStyle /*110*/:
            case 111:
            case 112:
            case 113:
            case 114:
                this.vpV += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        HK(i);
        switch (i2) {
            case a$i.AppCompatTheme_actionModeFindDrawable /*37*/:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.vpV += 3;
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.HO(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        HK(i);
        this.vpV += 2;
        this.vpV += iArr.length * 2;
        this.vpV += iArr2.length * 2;
    }

    public final void a(int i, int i2, int i3, int[] iArr) {
        HK(i);
        this.vpV += 4;
        this.vpV += iArr.length * 2;
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        HK(i);
        this.vpV += 4;
        switch (i4) {
            case 1:
                int length = ((byte[]) obj).length;
                this.vpV = ((length & 1) + (length >> 1)) + this.vpV;
                return;
            case 2:
                this.vpV += ((short[]) obj).length * 1;
                return;
            case 4:
                this.vpV += ((int[]) obj).length * 2;
                return;
            case 8:
                this.vpV += ((long[]) obj).length * 4;
                return;
            default:
                throw new j("bogus element_width: " + a.HN(i4));
        }
    }
}
