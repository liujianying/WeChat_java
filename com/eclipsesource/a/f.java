package com.eclipsesource.a;

import com.tencent.mm.plugin.appbrand.s$l;
import java.io.Reader;
import java.io.StringReader;

final class f {
    private final Reader abM;
    private final char[] abN;
    private int abO;
    private int abP;
    private int abQ;
    private StringBuilder abR;
    private int abS;
    private int fill;
    private int index;
    private int line;

    f(String str) {
        this(new StringReader(str), Math.max(10, Math.min(1024, str.length())));
    }

    private f(Reader reader, int i) {
        this.abM = reader;
        this.abN = new char[i];
        this.line = 1;
        this.abS = -1;
    }

    final h hW() {
        h bVar;
        switch (this.abQ) {
            case s$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                return new g(hX());
            case s$l.AppCompatTheme_actionDropDownStyle /*45*/:
            case s$l.AppCompatTheme_homeAsUpIndicator /*48*/:
            case 49:
            case 50:
            case 51:
            case s$l.AppCompatTheme_selectableItemBackground /*52*/:
            case s$l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
            case s$l.AppCompatTheme_borderlessButtonStyle /*54*/:
            case s$l.AppCompatTheme_dividerVertical /*55*/:
            case s$l.AppCompatTheme_dividerHorizontal /*56*/:
            case s$l.AppCompatTheme_activityChooserViewStyle /*57*/:
                ib();
                c('-');
                int i = this.abQ;
                if (hY()) {
                    if (i != 48) {
                        do {
                        } while (hY());
                    }
                    if (c('.')) {
                        if (hY()) {
                            do {
                            } while (hY());
                        } else {
                            throw X("digit");
                        }
                    }
                    if (!c('e') && !c('E')) {
                        return new d(ic());
                    }
                    if (!c('+')) {
                        c('-');
                    }
                    if (hY()) {
                        do {
                        } while (hY());
                        return new d(ic());
                    }
                    throw X("digit");
                }
                throw X("digit");
            case s$l.AppCompatTheme_alertDialogStyle /*91*/:
                ia();
                bVar = new b();
                hZ();
                if (c(']')) {
                    return bVar;
                }
                do {
                    hZ();
                    bVar.a(hW());
                    hZ();
                } while (c(','));
                if (c(']')) {
                    return bVar;
                }
                throw X("',' or ']'");
            case s$l.AppCompatTheme_checkboxStyle /*102*/:
                ia();
                b('a');
                b('l');
                b('s');
                b('e');
                return a.aby;
            case s$l.AppCompatTheme_spinnerStyle /*110*/:
                ia();
                b('u');
                b('l');
                b('l');
                return a.abw;
            case 116:
                ia();
                b('r');
                b('u');
                b('e');
                return a.abx;
            case 123:
                ia();
                bVar = new e();
                hZ();
                if (c('}')) {
                    return bVar;
                }
                do {
                    hZ();
                    if (this.abQ != 34) {
                        throw X("name");
                    }
                    String hX = hX();
                    hZ();
                    if (c(':')) {
                        hZ();
                        bVar.a(hX, hW());
                        hZ();
                    } else {
                        throw X("':'");
                    }
                } while (c(','));
                if (c('}')) {
                    return bVar;
                }
                throw X("',' or '}'");
            default:
                throw X("value");
        }
    }

    private void b(char c) {
        if (!c(c)) {
            throw X("'" + c + "'");
        }
    }

    private String hX() {
        ia();
        ib();
        while (this.abQ != 34) {
            if (this.abQ == 92) {
                this.abR.append(this.abN, this.abS, (this.abQ == -1 ? this.index : this.index - 1) - this.abS);
                this.abS = -1;
                ia();
                switch (this.abQ) {
                    case s$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                    case 47:
                    case s$l.AppCompatTheme_alertDialogButtonGroupStyle /*92*/:
                        this.abR.append((char) this.abQ);
                        break;
                    case s$l.AppCompatTheme_buttonBarNeutralButtonStyle /*98*/:
                        this.abR.append(8);
                        break;
                    case s$l.AppCompatTheme_checkboxStyle /*102*/:
                        this.abR.append(12);
                        break;
                    case s$l.AppCompatTheme_spinnerStyle /*110*/:
                        this.abR.append(10);
                        break;
                    case 114:
                        this.abR.append(13);
                        break;
                    case 116:
                        this.abR.append(9);
                        break;
                    case 117:
                        char[] cArr = new char[4];
                        for (int i = 0; i < 4; i++) {
                            ia();
                            Object obj = ((this.abQ < 48 || this.abQ > 57) && ((this.abQ < 97 || this.abQ > s$l.AppCompatTheme_checkboxStyle) && (this.abQ < 65 || this.abQ > 70))) ? null : 1;
                            if (obj == null) {
                                throw X("hexadecimal digit");
                            }
                            cArr[i] = (char) this.abQ;
                        }
                        this.abR.append((char) Integer.parseInt(new String(cArr), 16));
                        break;
                    default:
                        throw X("valid escape sequence");
                }
                ia();
                ib();
            } else if (this.abQ < 32) {
                throw X("valid string character");
            } else {
                ia();
            }
        }
        String ic = ic();
        ia();
        return ic;
    }

    private boolean c(char c) {
        if (this.abQ != c) {
            return false;
        }
        ia();
        return true;
    }

    private boolean hY() {
        boolean z;
        if (this.abQ < 48 || this.abQ > 57) {
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            return false;
        }
        ia();
        return true;
    }

    final void hZ() {
        while (true) {
            Object obj = (this.abQ == 32 || this.abQ == 9 || this.abQ == 10 || this.abQ == 13) ? 1 : null;
            if (obj != null) {
                ia();
            } else {
                return;
            }
        }
    }

    final void ia() {
        if (this.index == this.fill) {
            if (this.abS != -1) {
                this.abR.append(this.abN, this.abS, this.fill - this.abS);
                this.abS = 0;
            }
            this.abO += this.fill;
            this.fill = this.abM.read(this.abN, 0, this.abN.length);
            this.index = 0;
            if (this.fill == -1) {
                this.abQ = -1;
                return;
            }
        }
        if (this.abQ == 10) {
            this.line++;
            this.abP = this.abO + this.index;
        }
        char[] cArr = this.abN;
        int i = this.index;
        this.index = i + 1;
        this.abQ = cArr[i];
    }

    private void ib() {
        if (this.abR == null) {
            this.abR = new StringBuilder();
        }
        this.abS = this.index - 1;
    }

    private String ic() {
        String stringBuilder;
        int i = this.abQ == -1 ? this.index : this.index - 1;
        if (this.abR.length() > 0) {
            this.abR.append(this.abN, this.abS, i - this.abS);
            stringBuilder = this.abR.toString();
            this.abR.setLength(0);
        } else {
            stringBuilder = new String(this.abN, this.abS, i - this.abS);
        }
        this.abS = -1;
        return stringBuilder;
    }

    private j X(String str) {
        if (id()) {
            return Y("Unexpected end of input");
        }
        return Y("Expected " + str);
    }

    final j Y(String str) {
        int i = this.abO + this.index;
        int i2 = i - this.abP;
        if (!id()) {
            i--;
        }
        return new j(str, i, this.line, i2 - 1);
    }

    final boolean id() {
        return this.abQ == -1;
    }
}
