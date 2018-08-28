package com.google.android.exoplayer2.f.b;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Region.Op;
import android.util.SparseArray;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.i.t;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.plugin.appbrand.jsapi.share.d;
import com.tencent.mm.plugin.game.f$k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class b {
    private static final byte[] axA = new byte[]{(byte) 0, (byte) 7, (byte) 8, (byte) 15};
    private static final byte[] axB = new byte[]{(byte) 0, (byte) 119, (byte) -120, (byte) -1};
    private static final byte[] axC = new byte[]{(byte) 0, (byte) 17, (byte) 34, (byte) 51, (byte) 68, (byte) 85, (byte) 102, (byte) 119, (byte) -120, (byte) -103, (byte) -86, (byte) -69, (byte) -52, (byte) -35, (byte) -18, (byte) -1};
    private final Paint axD = new Paint();
    private final Paint axE;
    private final Canvas axF;
    private final b axG;
    private final a axH;
    final h axI;
    private Bitmap bitmap;

    public b(int i, int i2) {
        this.axD.setStyle(Style.FILL_AND_STROKE);
        this.axD.setXfermode(new PorterDuffXfermode(Mode.SRC));
        this.axD.setPathEffect(null);
        this.axE = new Paint();
        this.axE.setStyle(Style.FILL);
        this.axE.setXfermode(new PorterDuffXfermode(Mode.DST_OVER));
        this.axE.setPathEffect(null);
        this.axF = new Canvas();
        this.axG = new b(719, 575, 0, 719, 0, 575);
        this.axH = new a(0, lA(), lB(), lC());
        this.axI = new h(i, i2);
    }

    public final List<a> f(byte[] bArr, int i) {
        int cY;
        int cY2;
        int ma;
        int cY3;
        int cY4;
        a b;
        i iVar = new i(bArr, i);
        while (iVar.lZ() >= 48 && iVar.cY(8) == 15) {
            h hVar = this.axI;
            cY = iVar.cY(8);
            int cY5 = iVar.cY(16);
            cY2 = iVar.cY(16);
            ma = iVar.ma() + cY2;
            if (cY2 * 8 > iVar.lZ()) {
                iVar.cX(iVar.lZ());
            } else {
                int cY6;
                int cY7;
                d dVar;
                switch (cY) {
                    case 16:
                        if (cY5 == hVar.ayk) {
                            d dVar2 = hVar.ayr;
                            cY3 = iVar.cY(8);
                            cY4 = iVar.cY(4);
                            cY6 = iVar.cY(2);
                            iVar.cX(2);
                            cY = cY2 - 2;
                            SparseArray sparseArray = new SparseArray();
                            while (cY > 0) {
                                cY7 = iVar.cY(8);
                                iVar.cX(8);
                                cY -= 6;
                                sparseArray.put(cY7, new e(iVar.cY(16), iVar.cY(16)));
                            }
                            dVar = new d(cY3, cY4, cY6, sparseArray);
                            if (dVar.state == 0) {
                                if (!(dVar2 == null || dVar2.version == dVar.version)) {
                                    hVar.ayr = dVar;
                                    break;
                                }
                            }
                            hVar.ayr = dVar;
                            hVar.axU.clear();
                            hVar.aym.clear();
                            hVar.ayn.clear();
                            break;
                        }
                        break;
                    case 17:
                        dVar = hVar.ayr;
                        if (cY5 == hVar.ayk && dVar != null) {
                            f a = a(iVar, cY2);
                            if (dVar.state == 0) {
                                a.a((f) hVar.axU.get(a.id));
                            }
                            hVar.axU.put(a.id, a);
                            break;
                        }
                    case 18:
                        if (cY5 != hVar.ayk) {
                            if (cY5 == hVar.ayl) {
                                b = b(iVar, cY2);
                                hVar.ayo.put(b.id, b);
                                break;
                            }
                        }
                        b = b(iVar, cY2);
                        hVar.aym.put(b.id, b);
                        break;
                        break;
                    case 19:
                        c b2;
                        if (cY5 != hVar.ayk) {
                            if (cY5 == hVar.ayl) {
                                b2 = b(iVar);
                                hVar.ayp.put(b2.id, b2);
                                break;
                            }
                        }
                        b2 = b(iVar);
                        hVar.ayn.put(b2.id, b2);
                        break;
                        break;
                    case 20:
                        if (cY5 == hVar.ayk) {
                            iVar.cX(4);
                            boolean mb = iVar.mb();
                            iVar.cX(3);
                            cY5 = iVar.cY(16);
                            cY2 = iVar.cY(16);
                            if (mb) {
                                cY3 = iVar.cY(16);
                                cY4 = iVar.cY(16);
                                cY6 = iVar.cY(16);
                                cY7 = iVar.cY(16);
                            } else {
                                cY3 = 0;
                                cY6 = 0;
                                cY7 = cY2;
                                cY4 = cY5;
                            }
                            hVar.ayq = new b(cY5, cY2, cY3, cY4, cY6, cY7);
                            break;
                        }
                        break;
                }
                cY5 = ma - iVar.ma();
                com.google.android.exoplayer2.i.a.ap(iVar.aCq == 0);
                iVar.aCp += cY5;
                iVar.md();
            }
        }
        if (this.axI.ayr == null) {
            return Collections.emptyList();
        }
        b bVar;
        if (this.axI.ayq != null) {
            bVar = this.axI.ayq;
        } else {
            bVar = this.axG;
        }
        if (!(this.bitmap != null && bVar.width + 1 == this.bitmap.getWidth() && bVar.height + 1 == this.bitmap.getHeight())) {
            this.bitmap = Bitmap.createBitmap(bVar.width + 1, bVar.height + 1, Config.ARGB_8888);
            this.axF.setBitmap(this.bitmap);
        }
        List<a> arrayList = new ArrayList();
        SparseArray sparseArray2 = this.axI.ayr.axU;
        cY = 0;
        while (true) {
            ma = cY;
            if (ma >= sparseArray2.size()) {
                return arrayList;
            }
            a aVar;
            SparseArray sparseArray3;
            e eVar = (e) sparseArray2.valueAt(ma);
            f fVar = (f) this.axI.axU.get(sparseArray2.keyAt(ma));
            int i2 = eVar.axV + bVar.axM;
            int i3 = eVar.axW + bVar.axO;
            this.axF.clipRect((float) i2, (float) i3, (float) Math.min(fVar.width + i2, bVar.axN), (float) Math.min(fVar.height + i3, bVar.axP), Op.REPLACE);
            b = (a) this.axI.aym.get(fVar.aya);
            if (b == null) {
                b = (a) this.axI.ayo.get(fVar.aya);
                if (b == null) {
                    aVar = this.axH;
                    sparseArray3 = fVar.aye;
                    cY = 0;
                    while (true) {
                        int i4 = cY;
                        if (i4 < sparseArray3.size()) {
                            c cVar;
                            cY2 = sparseArray3.keyAt(i4);
                            g gVar = (g) sparseArray3.valueAt(i4);
                            c cVar2 = (c) this.axI.ayn.get(cY2);
                            if (cVar2 == null) {
                                cVar = (c) this.axI.ayp.get(cY2);
                            } else {
                                cVar = cVar2;
                            }
                            if (cVar != null) {
                                Paint paint = cVar.axQ ? null : this.axD;
                                cY2 = fVar.axZ;
                                cY3 = i2 + gVar.ayg;
                                cY4 = i3 + gVar.ayh;
                                Canvas canvas = this.axF;
                                int[] iArr = cY2 == 3 ? aVar.axL : cY2 == 2 ? aVar.axK : aVar.axJ;
                                a(cVar.axR, iArr, cY2, cY3, cY4, paint, canvas);
                                a(cVar.axS, iArr, cY2, cY3, cY4 + 1, paint, canvas);
                            }
                            cY = i4 + 1;
                        } else {
                            if (fVar.axX) {
                                if (fVar.axZ == 3) {
                                    cY = aVar.axL[fVar.ayb];
                                } else if (fVar.axZ == 2) {
                                    cY = aVar.axK[fVar.ayc];
                                } else {
                                    cY = aVar.axJ[fVar.ayd];
                                }
                                this.axE.setColor(cY);
                                this.axF.drawRect((float) i2, (float) i3, (float) (fVar.width + i2), (float) (fVar.height + i3), this.axE);
                            }
                            arrayList.add(new a(Bitmap.createBitmap(this.bitmap, i2, i3, fVar.width, fVar.height), ((float) i2) / ((float) bVar.width), ((float) i3) / ((float) bVar.height), ((float) fVar.width) / ((float) bVar.width), ((float) fVar.height) / ((float) bVar.height)));
                            this.axF.drawColor(0, Mode.CLEAR);
                            cY = ma + 1;
                        }
                    }
                }
            }
            aVar = b;
            sparseArray3 = fVar.aye;
            cY = 0;
            while (true) {
                int i42 = cY;
                if (i42 < sparseArray3.size()) {
                    c cVar3;
                    cY2 = sparseArray3.keyAt(i42);
                    g gVar2 = (g) sparseArray3.valueAt(i42);
                    c cVar22 = (c) this.axI.ayn.get(cY2);
                    if (cVar22 == null) {
                        cVar3 = (c) this.axI.ayp.get(cY2);
                    } else {
                        cVar3 = cVar22;
                    }
                    if (cVar3 != null) {
                        Paint paint2 = cVar3.axQ ? null : this.axD;
                        cY2 = fVar.axZ;
                        cY3 = i2 + gVar2.ayg;
                        cY4 = i3 + gVar2.ayh;
                        Canvas canvas2 = this.axF;
                        int[] iArr2 = cY2 == 3 ? aVar.axL : cY2 == 2 ? aVar.axK : aVar.axJ;
                        a(cVar3.axR, iArr2, cY2, cY3, cY4, paint2, canvas2);
                        a(cVar3.axS, iArr2, cY2, cY3, cY4 + 1, paint2, canvas2);
                    }
                    cY = i42 + 1;
                } else {
                    if (fVar.axX) {
                        if (fVar.axZ == 3) {
                            cY = aVar.axL[fVar.ayb];
                        } else if (fVar.axZ == 2) {
                            cY = aVar.axK[fVar.ayc];
                        } else {
                            cY = aVar.axJ[fVar.ayd];
                        }
                        this.axE.setColor(cY);
                        this.axF.drawRect((float) i2, (float) i3, (float) (fVar.width + i2), (float) (fVar.height + i3), this.axE);
                    }
                    arrayList.add(new a(Bitmap.createBitmap(this.bitmap, i2, i3, fVar.width, fVar.height), ((float) i2) / ((float) bVar.width), ((float) i3) / ((float) bVar.height), ((float) fVar.width) / ((float) bVar.width), ((float) fVar.height) / ((float) bVar.height)));
                    this.axF.drawColor(0, Mode.CLEAR);
                    cY = ma + 1;
                }
            }
        }
    }

    private static f a(i iVar, int i) {
        int cY = iVar.cY(8);
        iVar.cX(4);
        boolean mb = iVar.mb();
        iVar.cX(3);
        int cY2 = iVar.cY(16);
        int cY3 = iVar.cY(16);
        int cY4 = iVar.cY(3);
        int cY5 = iVar.cY(3);
        iVar.cX(2);
        int cY6 = iVar.cY(8);
        int cY7 = iVar.cY(8);
        int cY8 = iVar.cY(4);
        int cY9 = iVar.cY(2);
        iVar.cX(2);
        int i2 = i - 10;
        SparseArray sparseArray = new SparseArray();
        while (i2 > 0) {
            int cY10 = iVar.cY(16);
            int cY11 = iVar.cY(2);
            int cY12 = iVar.cY(2);
            int cY13 = iVar.cY(12);
            iVar.cX(4);
            int cY14 = iVar.cY(12);
            int i3 = i2 - 6;
            int i4 = 0;
            int i5 = 0;
            if (cY11 == 1 || cY11 == 2) {
                i4 = iVar.cY(8);
                i5 = iVar.cY(8);
                i3 -= 2;
            }
            i2 = i3;
            sparseArray.put(cY10, new g(cY11, cY12, cY13, cY14, i4, i5));
        }
        return new f(cY, mb, cY2, cY3, cY4, cY5, cY6, cY7, cY8, cY9, sparseArray);
    }

    private static a b(i iVar, int i) {
        int cY = iVar.cY(8);
        iVar.cX(8);
        int i2 = i - 2;
        int[] lA = lA();
        int[] lB = lB();
        int[] lC = lC();
        while (i2 > 0) {
            int[] iArr;
            int cY2;
            int cY3;
            int cY4;
            int cY5 = iVar.cY(8);
            int cY6 = iVar.cY(8);
            i2 -= 2;
            if ((cY6 & 128) != 0) {
                iArr = lA;
            } else if ((cY6 & 64) != 0) {
                iArr = lB;
            } else {
                iArr = lC;
            }
            if ((cY6 & 1) != 0) {
                cY2 = iVar.cY(8);
                cY3 = iVar.cY(8);
                cY4 = iVar.cY(8);
                cY6 = iVar.cY(8);
                i2 -= 4;
            } else {
                cY2 = iVar.cY(6) << 2;
                cY3 = iVar.cY(4) << 4;
                cY4 = iVar.cY(4) << 4;
                cY6 = iVar.cY(2) << 6;
                i2 -= 2;
            }
            if (cY2 == 0) {
                cY3 = 0;
                cY4 = 0;
                cY6 = 255;
            }
            iArr[cY5] = i((byte) (255 - (cY6 & 255)), t.u((int) (((double) cY2) + (1.402d * ((double) (cY3 - 128)))), 0, 255), t.u((int) ((((double) cY2) - (0.34414d * ((double) (cY4 - 128)))) - (0.71414d * ((double) (cY3 - 128)))), 0, 255), t.u((int) (((double) cY2) + (1.772d * ((double) (cY4 - 128)))), 0, 255));
        }
        return new a(cY, lA, lB, lC);
    }

    private static c b(i iVar) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3 = null;
        int cY = iVar.cY(16);
        iVar.cX(4);
        int cY2 = iVar.cY(2);
        boolean mb = iVar.mb();
        iVar.cX(1);
        if (cY2 == 1) {
            iVar.cX(iVar.cY(8) * 16);
            bArr = null;
            bArr2 = null;
        } else if (cY2 == 0) {
            cY2 = iVar.cY(16);
            int cY3 = iVar.cY(16);
            if (cY2 > 0) {
                bArr3 = new byte[cY2];
                iVar.n(bArr3, cY2);
            }
            if (cY3 > 0) {
                bArr = new byte[cY3];
                iVar.n(bArr, cY3);
                bArr2 = bArr3;
            } else {
                bArr = bArr3;
                bArr2 = bArr3;
            }
        } else {
            bArr = null;
            bArr2 = null;
        }
        return new c(cY, mb, bArr2, bArr);
    }

    private static int[] lA() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    private static int[] lB() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                int i2;
                if ((i & 1) != 0) {
                    i2 = 255;
                } else {
                    i2 = 0;
                }
                iArr[i] = i(255, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                iArr[i] = i(255, (i & 1) != 0 ? 127 : 0, (i & 2) != 0 ? 127 : 0, (i & 4) != 0 ? 127 : 0);
            }
        }
        return iArr;
    }

    private static int[] lC() {
        int[] iArr = new int[GLIcon.TOP];
        iArr[0] = 0;
        for (int i = 0; i < GLIcon.TOP; i++) {
            if (i >= 8) {
                switch (i & 136) {
                    case 0:
                        iArr[i] = i(255, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 64) != 0 ? 170 : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 8:
                        iArr[i] = i(127, ((i & 1) != 0 ? 85 : 0) + ((i & 16) != 0 ? 170 : 0), ((i & 2) != 0 ? 85 : 0) + ((i & 32) != 0 ? 170 : 0), ((i & 64) != 0 ? 170 : 0) + ((i & 4) != 0 ? 85 : 0));
                        break;
                    case 128:
                        iArr[i] = i(255, (((i & 1) != 0 ? 43 : 0) + 127) + ((i & 16) != 0 ? 85 : 0), (((i & 2) != 0 ? 43 : 0) + 127) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + (((i & 4) != 0 ? 43 : 0) + 127));
                        break;
                    case 136:
                        iArr[i] = i(255, ((i & 1) != 0 ? 43 : 0) + ((i & 16) != 0 ? 85 : 0), ((i & 2) != 0 ? 43 : 0) + ((i & 32) != 0 ? 85 : 0), ((i & 64) != 0 ? 85 : 0) + ((i & 4) != 0 ? 43 : 0));
                        break;
                    default:
                        break;
                }
            }
            int i2;
            if ((i & 1) != 0) {
                i2 = 255;
            } else {
                i2 = 0;
            }
            iArr[i] = i(63, i2, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
        }
        return iArr;
    }

    private static int i(int i, int i2, int i3, int i4) {
        return (((i << 24) | (i2 << 16)) | (i3 << 8)) | i4;
    }

    private static void a(byte[] bArr, int[] iArr, int i, int i2, int i3, Paint paint, Canvas canvas) {
        i iVar = new i(bArr);
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        int i4 = i2;
        while (iVar.lZ() != 0) {
            int cY;
            byte[] bArr4;
            Object obj;
            int i5;
            int i6;
            int i7;
            Object i72;
            switch (iVar.cY(8)) {
                case 16:
                    if (i == 3) {
                        bArr4 = bArr2 == null ? axB : bArr2;
                    } else if (i == 2) {
                        bArr4 = bArr3 == null ? axA : bArr3;
                    } else {
                        bArr4 = null;
                    }
                    obj = null;
                    i5 = i4;
                    while (true) {
                        cY = iVar.cY(2);
                        if (cY == 0) {
                            if (!iVar.mb()) {
                                if (!iVar.mb()) {
                                    switch (iVar.cY(2)) {
                                        case 0:
                                            cY = 0;
                                            i6 = 0;
                                            i72 = 1;
                                            break;
                                        case 1:
                                            cY = 0;
                                            i6 = 2;
                                            i72 = obj;
                                            break;
                                        case 2:
                                            i4 = iVar.cY(4) + 12;
                                            cY = iVar.cY(2);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        case 3:
                                            i4 = iVar.cY(8) + 29;
                                            cY = iVar.cY(2);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        default:
                                            cY = 0;
                                            i6 = 0;
                                            i72 = obj;
                                            break;
                                    }
                                }
                                cY = 0;
                                i6 = 1;
                                i72 = obj;
                            } else {
                                i4 = iVar.cY(3) + 3;
                                cY = iVar.cY(2);
                                i6 = i4;
                                i72 = obj;
                            }
                        } else {
                            i6 = 1;
                            i72 = obj;
                        }
                        if (!(i6 == 0 || paint == null)) {
                            if (bArr4 != null) {
                                cY = bArr4[cY];
                            }
                            paint.setColor(iArr[cY]);
                            canvas.drawRect((float) i5, (float) i3, (float) (i5 + i6), (float) (i3 + 1), paint);
                        }
                        cY = i5 + i6;
                        if (i72 != null) {
                            iVar.mc();
                            i4 = cY;
                            continue;
                        } else {
                            obj = i72;
                            i5 = cY;
                        }
                    }
                case 17:
                    if (i == 3) {
                        bArr4 = axC;
                    } else {
                        bArr4 = null;
                    }
                    obj = null;
                    i5 = i4;
                    while (true) {
                        cY = iVar.cY(4);
                        if (cY == 0) {
                            if (iVar.mb()) {
                                if (iVar.mb()) {
                                    switch (iVar.cY(2)) {
                                        case 0:
                                            cY = 0;
                                            i6 = 1;
                                            i72 = obj;
                                            break;
                                        case 1:
                                            cY = 0;
                                            i6 = 2;
                                            i72 = obj;
                                            break;
                                        case 2:
                                            i4 = iVar.cY(4) + 9;
                                            cY = iVar.cY(4);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        case 3:
                                            i4 = iVar.cY(8) + 25;
                                            cY = iVar.cY(4);
                                            i6 = i4;
                                            i72 = obj;
                                            break;
                                        default:
                                            cY = 0;
                                            i6 = 0;
                                            i72 = obj;
                                            break;
                                    }
                                }
                                i4 = iVar.cY(2) + 4;
                                cY = iVar.cY(4);
                                i6 = i4;
                                i72 = obj;
                            } else {
                                cY = iVar.cY(3);
                                if (cY != 0) {
                                    i4 = cY + 2;
                                    cY = 0;
                                    i6 = i4;
                                    i72 = obj;
                                } else {
                                    cY = 0;
                                    i6 = 0;
                                    i72 = 1;
                                }
                            }
                        } else {
                            i6 = 1;
                            i72 = obj;
                        }
                        if (!(i6 == 0 || paint == null)) {
                            if (bArr4 != null) {
                                cY = bArr4[cY];
                            }
                            paint.setColor(iArr[cY]);
                            canvas.drawRect((float) i5, (float) i3, (float) (i5 + i6), (float) (i3 + 1), paint);
                        }
                        cY = i5 + i6;
                        if (i72 != null) {
                            iVar.mc();
                            i4 = cY;
                            continue;
                        } else {
                            obj = i72;
                            i5 = cY;
                        }
                    }
                case 18:
                    obj = null;
                    i72 = i4;
                    while (true) {
                        Object obj2;
                        cY = iVar.cY(8);
                        if (cY != 0) {
                            i5 = 1;
                            obj2 = obj;
                        } else if (iVar.mb()) {
                            i4 = iVar.cY(7);
                            cY = iVar.cY(8);
                            i5 = i4;
                            obj2 = obj;
                        } else {
                            int cY2 = iVar.cY(7);
                            if (cY2 != 0) {
                                cY = 0;
                                i5 = cY2;
                                obj2 = obj;
                            } else {
                                cY = 0;
                                i5 = 0;
                                int obj22 = 1;
                            }
                        }
                        if (!(i5 == 0 || paint == null)) {
                            paint.setColor(iArr[cY]);
                            canvas.drawRect((float) i72, (float) i3, (float) (i72 + i5), (float) (i3 + 1), paint);
                        }
                        cY = i72 + i5;
                        if (obj22 != null) {
                            i4 = cY;
                            continue;
                        } else {
                            obj = obj22;
                            i72 = cY;
                        }
                    }
                case f$k.AppCompatTheme_actionModeCutDrawable /*32*/:
                    bArr3 = a(4, 4, iVar);
                    continue;
                case 33:
                    bArr2 = a(4, 8, iVar);
                    continue;
                case 34:
                    bArr2 = a(16, 8, iVar);
                    continue;
                case d.CTRL_INDEX /*240*/:
                    i3 += 2;
                    cY = i2;
                    break;
                default:
                    cY = i4;
                    break;
            }
            i4 = cY;
        }
    }

    private static byte[] a(int i, int i2, i iVar) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) iVar.cY(i2);
        }
        return bArr;
    }
}
