package com.tencent.tinker.a.b.a;

import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;

public final class b {
    public static short fL(int i, int i2) {
        if ((i & -256) != 0) {
            throw new IllegalArgumentException("bogus lowByte");
        } else if ((i2 & -256) == 0) {
            return (short) ((i2 << 8) | i);
        } else {
            throw new IllegalArgumentException("bogus highByte");
        }
    }

    public static short B(int i, int i2, int i3, int i4) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble0");
        } else if ((i2 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble1");
        } else if ((i3 & -16) != 0) {
            throw new IllegalArgumentException("bogus nibble2");
        } else if ((i4 & -16) == 0) {
            return (short) ((((i2 << 4) | i) | (i3 << 8)) | (i4 << 12));
        } else {
            throw new IllegalArgumentException("bogus nibble3");
        }
    }

    public static int fM(int i, int i2) {
        if ((i & -16) != 0) {
            throw new IllegalArgumentException("bogus lowNibble");
        } else if ((i2 & -16) == 0) {
            return (i2 << 4) | i;
        } else {
            throw new IllegalArgumentException("bogus highNibble");
        }
    }

    public static short HF(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new IllegalArgumentException("bogus unsigned code unit");
    }

    public static int HG(int i) {
        return (i >> 8) & com.tencent.mm.plugin.game.gamewebview.jsapi.biz.b.CTRL_BYTE;
    }

    public static short fN(int i, int i2) {
        short s = i - i2;
        if (s == ((short) s)) {
            return (short) s;
        }
        throw new j("Target out of range: " + a.HP(s) + ", perhaps you need to enable force jumbo mode.");
    }

    public static short gV(long j) {
        if (j == ((long) ((short) ((int) j)))) {
            return (short) ((int) j);
        }
        throw new j("Literal out of range: " + a.gW(j));
    }

    public static short HH(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new j("Register A out of range: " + a.gW((long) i));
    }

    public static short HI(int i) {
        if ((-65536 & i) == 0) {
            return (short) i;
        }
        throw new j("Register B out of range: " + a.gW((long) i));
    }

    public static int HJ(int i) {
        switch (i) {
            case -1:
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 29:
            case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
            case 33:
            case a$k.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
            case 39:
            case a$k.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
            case a$k.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
            case a$k.AppCompatTheme_dialogTheme /*42*/:
            case a$k.AppCompatTheme_dialogPreferredPadding /*43*/:
            case a$k.AppCompatTheme_listDividerAlertDialog /*44*/:
            case a$k.AppCompatTheme_actionDropDownStyle /*45*/:
            case a$k.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
            case a$k.AppCompatTheme_spinnerDropDownItemStyle /*47*/:
            case a$k.AppCompatTheme_homeAsUpIndicator /*48*/:
            case a$k.AppCompatTheme_actionButtonStyle /*49*/:
            case a$k.AppCompatTheme_buttonBarStyle /*50*/:
            case a$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
            case 52:
            case a$k.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
            case a$k.AppCompatTheme_borderlessButtonStyle /*54*/:
            case a$k.AppCompatTheme_dividerVertical /*55*/:
            case a$k.AppCompatTheme_dividerHorizontal /*56*/:
            case 57:
            case a$k.AppCompatTheme_toolbarStyle /*58*/:
            case 59:
            case a$k.AppCompatTheme_popupMenuStyle /*60*/:
            case a$k.AppCompatTheme_popupWindowStyle /*61*/:
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
            case 226:
            case 256:
            case 512:
            case 768:
                return 1;
            case 26:
            case 27:
                return 3;
            case 28:
            case 31:
            case a$k.AppCompatTheme_actionModeCutDrawable /*32*/:
            case 34:
            case a$k.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
            case a$k.AppCompatTheme_actionModeShareDrawable /*36*/:
            case a$k.AppCompatTheme_actionModeFindDrawable /*37*/:
                return 2;
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
                return 5;
            case 110:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                return 4;
            default:
                return 0;
        }
    }
}
