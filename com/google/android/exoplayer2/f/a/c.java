package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.f.h;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.au;
import com.tencent.mm.plugin.appbrand.s$l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class c extends d {
    private final i awN = new i();
    private final int awO;
    private final a[] awP;
    private a awQ;
    private b awR;
    private int awS;
    private final j awt = new j();
    private List<a> awy;
    private List<a> awz;

    public c(int i) {
        if (i == -1) {
            i = 1;
        }
        this.awO = i;
        this.awP = new a[8];
        for (int i2 = 0; i2 < 8; i2++) {
            this.awP[i2] = new a();
        }
        this.awQ = this.awP[0];
        lr();
    }

    public final void flush() {
        super.flush();
        this.awy = null;
        this.awz = null;
        this.awS = 0;
        this.awQ = this.awP[this.awS];
        lr();
        this.awR = null;
    }

    protected final boolean lo() {
        return this.awy != this.awz;
    }

    protected final d lp() {
        this.awz = this.awy;
        return new f(this.awy);
    }

    protected final void a(h hVar) {
        this.awt.m(hVar.aig.array(), hVar.aig.limit());
        while (this.awt.me() >= 3) {
            int readUnsignedByte = this.awt.readUnsignedByte() & 7;
            int i = readUnsignedByte & 3;
            Object obj = (readUnsignedByte & 4) == 4 ? 1 : null;
            byte readUnsignedByte2 = (byte) this.awt.readUnsignedByte();
            byte readUnsignedByte3 = (byte) this.awt.readUnsignedByte();
            if ((i == 2 || i == 3) && obj != null) {
                byte[] bArr;
                b bVar;
                int i2;
                if (i == 3) {
                    ly();
                    i = (readUnsignedByte2 & au.CTRL_INDEX) >> 6;
                    readUnsignedByte = readUnsignedByte2 & 63;
                    if (readUnsignedByte == 0) {
                        readUnsignedByte = 64;
                    }
                    this.awR = new b(i, readUnsignedByte);
                    bArr = this.awR.axt;
                    bVar = this.awR;
                    i2 = bVar.currentIndex;
                    bVar.currentIndex = i2 + 1;
                    bArr[i2] = readUnsignedByte3;
                } else {
                    com.google.android.exoplayer2.i.a.ao(i == 2);
                    if (this.awR != null) {
                        bArr = this.awR.axt;
                        bVar = this.awR;
                        int i3 = bVar.currentIndex;
                        bVar.currentIndex = i3 + 1;
                        bArr[i3] = readUnsignedByte2;
                        bArr = this.awR.axt;
                        bVar = this.awR;
                        i2 = bVar.currentIndex;
                        bVar.currentIndex = i2 + 1;
                        bArr[i2] = readUnsignedByte3;
                    }
                }
                if (this.awR.currentIndex == (this.awR.axs * 2) - 1) {
                    ly();
                }
            }
        }
    }

    private void ly() {
        if (this.awR != null) {
            if (this.awR.currentIndex != (this.awR.axs * 2) - 1) {
                new StringBuilder("DtvCcPacket ended prematurely; size is ").append((this.awR.axs * 2) - 1).append(", but current index is ").append(this.awR.currentIndex).append(" (sequence number ").append(this.awR.axr).append("); ignoring packet");
            } else {
                this.awN.m(this.awR.axt, this.awR.currentIndex);
                int cY = this.awN.cY(3);
                int cY2 = this.awN.cY(5);
                if (cY == 7) {
                    this.awN.cX(2);
                    cY += this.awN.cY(6);
                }
                if (cY2 == 0) {
                    if (cY != 0) {
                        new StringBuilder("serviceNumber is non-zero (").append(cY).append(") when blockSize is 0");
                    }
                } else if (cY == this.awO) {
                    Object obj = null;
                    while (this.awN.lZ() > 0) {
                        cY2 = this.awN.cY(8);
                        if (cY2 == 16) {
                            cY2 = this.awN.cY(8);
                            if (cY2 <= 31) {
                                if (cY2 > 7) {
                                    if (cY2 <= 15) {
                                        this.awN.cX(8);
                                    } else if (cY2 <= 23) {
                                        this.awN.cX(16);
                                    } else if (cY2 <= 31) {
                                        this.awN.cX(24);
                                    }
                                }
                            } else if (cY2 <= 127) {
                                switch (cY2) {
                                    case 32:
                                        this.awQ.append(' ');
                                        break;
                                    case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                                        this.awQ.append(160);
                                        break;
                                    case s$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                                        this.awQ.append(8230);
                                        break;
                                    case s$l.AppCompatTheme_dialogTheme /*42*/:
                                        this.awQ.append(352);
                                        break;
                                    case s$l.AppCompatTheme_listDividerAlertDialog /*44*/:
                                        this.awQ.append(338);
                                        break;
                                    case s$l.AppCompatTheme_homeAsUpIndicator /*48*/:
                                        this.awQ.append(9608);
                                        break;
                                    case 49:
                                        this.awQ.append(8216);
                                        break;
                                    case 50:
                                        this.awQ.append(8217);
                                        break;
                                    case 51:
                                        this.awQ.append(8220);
                                        break;
                                    case s$l.AppCompatTheme_selectableItemBackground /*52*/:
                                        this.awQ.append(8221);
                                        break;
                                    case s$l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                                        this.awQ.append(8226);
                                        break;
                                    case s$l.AppCompatTheme_activityChooserViewStyle /*57*/:
                                        this.awQ.append(8482);
                                        break;
                                    case s$l.AppCompatTheme_toolbarStyle /*58*/:
                                        this.awQ.append(353);
                                        break;
                                    case s$l.AppCompatTheme_popupMenuStyle /*60*/:
                                        this.awQ.append(339);
                                        break;
                                    case s$l.AppCompatTheme_popupWindowStyle /*61*/:
                                        this.awQ.append(8480);
                                        break;
                                    case s$l.AppCompatTheme_editTextBackground /*63*/:
                                        this.awQ.append(376);
                                        break;
                                    case 118:
                                        this.awQ.append(8539);
                                        break;
                                    case 119:
                                        this.awQ.append(8540);
                                        break;
                                    case 120:
                                        this.awQ.append(8541);
                                        break;
                                    case 121:
                                        this.awQ.append(8542);
                                        break;
                                    case 122:
                                        this.awQ.append(9474);
                                        break;
                                    case 123:
                                        this.awQ.append(9488);
                                        break;
                                    case 124:
                                        this.awQ.append(9492);
                                        break;
                                    case 125:
                                        this.awQ.append(9472);
                                        break;
                                    case 126:
                                        this.awQ.append(9496);
                                        break;
                                    case 127:
                                        this.awQ.append(9484);
                                        break;
                                }
                                obj = 1;
                            } else if (cY2 <= 159) {
                                if (cY2 <= 135) {
                                    this.awN.cX(32);
                                } else if (cY2 <= 143) {
                                    this.awN.cX(40);
                                } else if (cY2 <= 159) {
                                    this.awN.cX(2);
                                    this.awN.cX(this.awN.cY(6) * 8);
                                }
                            } else if (cY2 <= 255) {
                                if (cY2 == 160) {
                                    this.awQ.append(13252);
                                } else {
                                    this.awQ.append('_');
                                }
                                obj = 1;
                            }
                        } else if (cY2 <= 31) {
                            switch (cY2) {
                                case 0:
                                case 14:
                                    break;
                                case 3:
                                    this.awy = lq();
                                    break;
                                case 8:
                                    a aVar = this.awQ;
                                    int length = aVar.awI.length();
                                    if (length <= 0) {
                                        break;
                                    }
                                    aVar.awI.delete(length - 1, length);
                                    break;
                                case 12:
                                    lr();
                                    break;
                                case 13:
                                    this.awQ.append(10);
                                    break;
                                default:
                                    if (cY2 < 17 || cY2 > 23) {
                                        if (cY2 >= 24 && cY2 <= 31) {
                                            this.awN.cX(16);
                                            break;
                                        }
                                    }
                                    this.awN.cX(8);
                                    break;
                                    break;
                            }
                        } else if (cY2 <= 127) {
                            if (cY2 == 127) {
                                this.awQ.append(9835);
                            } else {
                                this.awQ.append((char) (cY2 & 255));
                            }
                            obj = 1;
                        } else if (cY2 <= 159) {
                            cO(cY2);
                            obj = 1;
                        } else if (cY2 <= 255) {
                            this.awQ.append((char) (cY2 & 255));
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        this.awy = lq();
                    }
                }
            }
            this.awR = null;
        }
    }

    private void cO(int i) {
        int i2;
        int i3;
        a aVar;
        switch (i) {
            case 128:
            case 129:
            case 130:
            case 131:
            case 132:
            case 133:
            case 134:
            case 135:
                i2 = i - 128;
                if (this.awS != i2) {
                    this.awS = i2;
                    this.awQ = this.awP[i2];
                    return;
                }
                return;
            case 136:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.mb()) {
                        this.awP[8 - i2].clear();
                    }
                }
                return;
            case 137:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.mb()) {
                        this.awP[8 - i2].YN = true;
                    }
                }
                return;
            case 138:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.mb()) {
                        this.awP[8 - i2].YN = false;
                    }
                }
                return;
            case 139:
                i2 = 1;
                while (true) {
                    i3 = i2;
                    if (i3 <= 8) {
                        if (this.awN.mb()) {
                            a aVar2 = this.awP[8 - i3];
                            aVar2.YN = !aVar2.YN;
                        }
                        i2 = i3 + 1;
                    } else {
                        return;
                    }
                }
            case 140:
                for (i2 = 1; i2 <= 8; i2++) {
                    if (this.awN.mb()) {
                        this.awP[8 - i2].reset();
                    }
                }
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.f.j.CTRL_INDEX /*141*/:
                this.awN.cX(8);
                return;
            case 143:
                lr();
                return;
            case 144:
                if (this.awQ.axe) {
                    this.awN.cY(4);
                    this.awN.cY(2);
                    this.awN.cY(2);
                    boolean mb = this.awN.mb();
                    boolean mb2 = this.awN.mb();
                    this.awN.cY(3);
                    this.awN.cY(3);
                    this.awQ.g(mb, mb2);
                    return;
                }
                this.awN.cX(16);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.c.CTRL_INDEX /*145*/:
                if (this.awQ.axe) {
                    i2 = a.h(this.awN.cY(2), this.awN.cY(2), this.awN.cY(2), this.awN.cY(2));
                    i3 = a.h(this.awN.cY(2), this.awN.cY(2), this.awN.cY(2), this.awN.cY(2));
                    this.awN.cX(2);
                    a.s(this.awN.cY(2), this.awN.cY(2), this.awN.cY(2));
                    this.awQ.at(i2, i3);
                    return;
                }
                this.awN.cX(24);
                return;
            case 146:
                if (this.awQ.axe) {
                    this.awN.cX(4);
                    i2 = this.awN.cY(4);
                    this.awN.cX(2);
                    this.awN.cY(6);
                    aVar = this.awQ;
                    if (aVar.row != i2) {
                        aVar.append(10);
                    }
                    aVar.row = i2;
                    return;
                }
                this.awN.cX(16);
                return;
            case 151:
                if (this.awQ.axe) {
                    i2 = a.h(this.awN.cY(2), this.awN.cY(2), this.awN.cY(2), this.awN.cY(2));
                    this.awN.cY(2);
                    a.s(this.awN.cY(2), this.awN.cY(2), this.awN.cY(2));
                    this.awN.mb();
                    this.awN.mb();
                    this.awN.cY(2);
                    this.awN.cY(2);
                    i3 = this.awN.cY(2);
                    this.awN.cX(8);
                    this.awQ.as(i2, i3);
                    return;
                }
                this.awN.cX(32);
                return;
            case com.tencent.mm.plugin.appbrand.jsapi.contact.d.CTRL_INDEX /*152*/:
            case 153:
            case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
                int i4;
                i2 = i - 152;
                aVar = this.awP[i2];
                this.awN.cX(2);
                boolean mb3 = this.awN.mb();
                boolean mb4 = this.awN.mb();
                this.awN.mb();
                int cY = this.awN.cY(3);
                boolean mb5 = this.awN.mb();
                int cY2 = this.awN.cY(7);
                int cY3 = this.awN.cY(8);
                int cY4 = this.awN.cY(4);
                int cY5 = this.awN.cY(4);
                this.awN.cX(2);
                this.awN.cY(6);
                this.awN.cX(2);
                int cY6 = this.awN.cY(3);
                int cY7 = this.awN.cY(3);
                aVar.axe = true;
                aVar.YN = mb3;
                aVar.axj = mb4;
                aVar.priority = cY;
                aVar.axf = mb5;
                aVar.axg = cY2;
                aVar.axh = cY3;
                aVar.axi = cY4;
                if (aVar.rowCount != cY5 + 1) {
                    aVar.rowCount = cY5 + 1;
                    while (true) {
                        if ((mb4 && aVar.awH.size() >= aVar.rowCount) || aVar.awH.size() >= 15) {
                            aVar.awH.remove(0);
                        }
                    }
                }
                if (!(cY6 == 0 || aVar.axl == cY6)) {
                    aVar.axl = cY6;
                    i4 = cY6 - 1;
                    aVar.as(a.axa[i4], a.awW[i4]);
                }
                if (!(cY7 == 0 || aVar.axm == cY7)) {
                    aVar.axm = cY7;
                    i4 = cY7 - 1;
                    aVar.g(false, false);
                    aVar.at(a.awT, a.axd[i4]);
                }
                if (this.awS != i2) {
                    this.awS = i2;
                    this.awQ = this.awP[i2];
                    return;
                }
                return;
            default:
                return;
        }
    }

    private List<a> lq() {
        List arrayList = new ArrayList();
        int i = 0;
        while (i < 8) {
            if (!this.awP[i].isEmpty() && this.awP[i].YN) {
                arrayList.add(this.awP[i].lz());
            }
            i++;
        }
        Collections.sort(arrayList);
        return Collections.unmodifiableList(arrayList);
    }

    private void lr() {
        for (int i = 0; i < 8; i++) {
            this.awP[i].reset();
        }
    }
}
