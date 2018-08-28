package android.support.v7.widget;

import android.support.v4.e.i.a;
import android.support.v4.e.i.b;
import java.util.ArrayList;
import java.util.List;

final class e implements aa$a {
    private a<b> LQ;
    final ArrayList<b> LR;
    final ArrayList<b> LS;
    final a LT;
    Runnable LU;
    final boolean LV;
    final aa LW;
    int LX;

    e(a aVar) {
        this(aVar, (byte) 0);
    }

    private e(a aVar, byte b) {
        this.LQ = new b(30);
        this.LR = new ArrayList();
        this.LS = new ArrayList();
        this.LX = 0;
        this.LT = aVar;
        this.LV = false;
        this.LW = new aa(this);
    }

    final void reset() {
        i(this.LR);
        i(this.LS);
        this.LX = 0;
    }

    final void eC() {
        aa aaVar = this.LW;
        List list = this.LR;
        while (true) {
            int i;
            int i2;
            b bVar;
            Object obj;
            int i3;
            Object obj2 = null;
            int size = list.size() - 1;
            while (size >= 0) {
                Object obj3;
                if (((b) list.get(size)).nc != 8) {
                    obj3 = 1;
                } else if (obj2 != null) {
                    i = size;
                    if (i != -1) {
                        i2 = i + 1;
                        bVar = (b) list.get(i);
                        b bVar2 = (b) list.get(i2);
                        Object obj4;
                        switch (bVar2.nc) {
                            case 1:
                                size = 0;
                                if (bVar.Ma < bVar2.LY) {
                                    size = -1;
                                }
                                if (bVar.LY < bVar2.LY) {
                                    size++;
                                }
                                if (bVar2.LY <= bVar.LY) {
                                    bVar.LY += bVar2.Ma;
                                }
                                if (bVar2.LY <= bVar.Ma) {
                                    bVar.Ma += bVar2.Ma;
                                }
                                bVar2.LY = size + bVar2.LY;
                                list.set(i, bVar2);
                                list.set(i2, bVar);
                                break;
                            case 2:
                                b bVar3 = null;
                                obj = null;
                                if (bVar.LY < bVar.Ma) {
                                    obj4 = null;
                                    if (bVar2.LY == bVar.LY && bVar2.Ma == bVar.Ma - bVar.LY) {
                                        obj = 1;
                                    }
                                } else {
                                    obj4 = 1;
                                    if (bVar2.LY == bVar.Ma + 1 && bVar2.Ma == bVar.LY - bVar.Ma) {
                                        obj = 1;
                                    }
                                }
                                if (bVar.Ma >= bVar2.LY) {
                                    if (bVar.Ma < bVar2.LY + bVar2.Ma) {
                                        bVar2.Ma--;
                                        bVar.nc = 2;
                                        bVar.Ma = 1;
                                        if (bVar2.Ma == 0) {
                                            list.remove(i2);
                                            aaVar.QF.c(bVar2);
                                            break;
                                        }
                                        break;
                                    }
                                }
                                bVar2.LY--;
                                if (bVar.LY <= bVar2.LY) {
                                    bVar2.LY++;
                                } else if (bVar.LY < bVar2.LY + bVar2.Ma) {
                                    bVar3 = aaVar.QF.a(2, bVar.LY + 1, (bVar2.LY + bVar2.Ma) - bVar.LY, null);
                                    bVar2.Ma = bVar.LY - bVar2.LY;
                                }
                                if (obj != null) {
                                    list.set(i, bVar2);
                                    list.remove(i2);
                                    aaVar.QF.c(bVar);
                                    break;
                                }
                                if (obj4 != null) {
                                    if (bVar3 != null) {
                                        if (bVar.LY > bVar3.LY) {
                                            bVar.LY -= bVar3.Ma;
                                        }
                                        if (bVar.Ma > bVar3.LY) {
                                            bVar.Ma -= bVar3.Ma;
                                        }
                                    }
                                    if (bVar.LY > bVar2.LY) {
                                        bVar.LY -= bVar2.Ma;
                                    }
                                    if (bVar.Ma > bVar2.LY) {
                                        bVar.Ma -= bVar2.Ma;
                                    }
                                } else {
                                    if (bVar3 != null) {
                                        if (bVar.LY >= bVar3.LY) {
                                            bVar.LY -= bVar3.Ma;
                                        }
                                        if (bVar.Ma >= bVar3.LY) {
                                            bVar.Ma -= bVar3.Ma;
                                        }
                                    }
                                    if (bVar.LY >= bVar2.LY) {
                                        bVar.LY -= bVar2.Ma;
                                    }
                                    if (bVar.Ma >= bVar2.LY) {
                                        bVar.Ma -= bVar2.Ma;
                                    }
                                }
                                list.set(i, bVar2);
                                if (bVar.LY != bVar.Ma) {
                                    list.set(i2, bVar);
                                } else {
                                    list.remove(i2);
                                }
                                if (bVar3 != null) {
                                    list.add(i, bVar3);
                                    break;
                                }
                                break;
                            case 4:
                                obj4 = null;
                                obj = null;
                                if (bVar.Ma < bVar2.LY) {
                                    bVar2.LY--;
                                } else if (bVar.Ma < bVar2.LY + bVar2.Ma) {
                                    bVar2.Ma--;
                                    obj4 = aaVar.QF.a(4, bVar.LY, 1, bVar2.LZ);
                                }
                                if (bVar.LY <= bVar2.LY) {
                                    bVar2.LY++;
                                } else if (bVar.LY < bVar2.LY + bVar2.Ma) {
                                    i3 = (bVar2.LY + bVar2.Ma) - bVar.LY;
                                    obj = aaVar.QF.a(4, bVar.LY + 1, i3, bVar2.LZ);
                                    bVar2.Ma -= i3;
                                }
                                list.set(i2, bVar);
                                if (bVar2.Ma > 0) {
                                    list.set(i, bVar2);
                                } else {
                                    list.remove(i);
                                    aaVar.QF.c(bVar2);
                                }
                                if (obj4 != null) {
                                    list.add(i, obj4);
                                }
                                if (obj != null) {
                                    list.add(i, obj);
                                    break;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    i2 = this.LR.size();
                    for (i = 0; i < i2; i++) {
                        bVar = (b) this.LR.get(i);
                        int i4;
                        int i5;
                        int i6;
                        switch (bVar.nc) {
                            case 1:
                                b(bVar);
                                break;
                            case 2:
                                int i7 = bVar.LY;
                                i4 = bVar.LY + bVar.Ma;
                                i5 = -1;
                                size = bVar.LY;
                                int i8 = 0;
                                while (size < i4) {
                                    i6 = 0;
                                    if (this.LT.aS(size) != null || aP(size)) {
                                        if (i5 == 0) {
                                            a(a(2, i7, i8, null));
                                            i6 = 1;
                                        }
                                        i5 = 1;
                                    } else {
                                        if (i5 == 1) {
                                            b(a(2, i7, i8, null));
                                            i6 = 1;
                                        }
                                        i5 = 0;
                                    }
                                    if (i6 != 0) {
                                        i6 = size - i8;
                                        size = i4 - i8;
                                        i3 = 1;
                                    } else {
                                        i3 = i8 + 1;
                                    }
                                    i4 = size;
                                    size = i6 + 1;
                                    i8 = i3;
                                }
                                if (i8 != bVar.Ma) {
                                    c(bVar);
                                    bVar = a(2, i7, i8, null);
                                }
                                if (i5 == 0) {
                                    a(bVar);
                                    break;
                                } else {
                                    b(bVar);
                                    break;
                                }
                                break;
                            case 4:
                                size = bVar.LY;
                                i6 = 0;
                                i5 = bVar.LY + bVar.Ma;
                                i3 = -1;
                                i4 = bVar.LY;
                                while (i4 < i5) {
                                    if (this.LT.aS(i4) != null || aP(i4)) {
                                        if (i3 == 0) {
                                            a(a(4, size, i6, bVar.LZ));
                                            i6 = 0;
                                            size = i4;
                                        }
                                        i3 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            b(a(4, size, i6, bVar.LZ));
                                            i6 = 0;
                                            size = i4;
                                        }
                                        i3 = 0;
                                    }
                                    i6++;
                                    i4++;
                                }
                                if (i6 != bVar.Ma) {
                                    obj = bVar.LZ;
                                    c(bVar);
                                    bVar = a(4, size, i6, obj);
                                }
                                if (i3 == 0) {
                                    a(bVar);
                                    break;
                                } else {
                                    b(bVar);
                                    break;
                                }
                                break;
                            case 8:
                                b(bVar);
                                break;
                        }
                        if (this.LU != null) {
                            this.LU.run();
                        }
                    }
                    this.LR.clear();
                    return;
                } else {
                    obj3 = obj2;
                }
                size--;
                obj2 = obj3;
            }
            i = -1;
            if (i != -1) {
                i2 = i + 1;
                bVar = (b) list.get(i);
                b bVar22 = (b) list.get(i2);
                Object obj42;
                switch (bVar22.nc) {
                    case 1:
                        size = 0;
                        if (bVar.Ma < bVar22.LY) {
                            size = -1;
                        }
                        if (bVar.LY < bVar22.LY) {
                            size++;
                        }
                        if (bVar22.LY <= bVar.LY) {
                            bVar.LY += bVar22.Ma;
                        }
                        if (bVar22.LY <= bVar.Ma) {
                            bVar.Ma += bVar22.Ma;
                        }
                        bVar22.LY = size + bVar22.LY;
                        list.set(i, bVar22);
                        list.set(i2, bVar);
                        break;
                    case 2:
                        b bVar32 = null;
                        obj = null;
                        if (bVar.LY < bVar.Ma) {
                            obj42 = null;
                            if (bVar22.LY == bVar.LY && bVar22.Ma == bVar.Ma - bVar.LY) {
                                obj = 1;
                            }
                        } else {
                            obj42 = 1;
                            if (bVar22.LY == bVar.Ma + 1 && bVar22.Ma == bVar.LY - bVar.Ma) {
                                obj = 1;
                            }
                        }
                        if (bVar.Ma >= bVar22.LY) {
                            if (bVar.Ma < bVar22.LY + bVar22.Ma) {
                                bVar22.Ma--;
                                bVar.nc = 2;
                                bVar.Ma = 1;
                                if (bVar22.Ma == 0) {
                                    list.remove(i2);
                                    aaVar.QF.c(bVar22);
                                    break;
                                }
                                break;
                            }
                        }
                        bVar22.LY--;
                        if (bVar.LY <= bVar22.LY) {
                            bVar22.LY++;
                        } else if (bVar.LY < bVar22.LY + bVar22.Ma) {
                            bVar32 = aaVar.QF.a(2, bVar.LY + 1, (bVar22.LY + bVar22.Ma) - bVar.LY, null);
                            bVar22.Ma = bVar.LY - bVar22.LY;
                        }
                        if (obj != null) {
                            list.set(i, bVar22);
                            list.remove(i2);
                            aaVar.QF.c(bVar);
                            break;
                        }
                        if (obj42 != null) {
                            if (bVar32 != null) {
                                if (bVar.LY > bVar32.LY) {
                                    bVar.LY -= bVar32.Ma;
                                }
                                if (bVar.Ma > bVar32.LY) {
                                    bVar.Ma -= bVar32.Ma;
                                }
                            }
                            if (bVar.LY > bVar22.LY) {
                                bVar.LY -= bVar22.Ma;
                            }
                            if (bVar.Ma > bVar22.LY) {
                                bVar.Ma -= bVar22.Ma;
                            }
                        } else {
                            if (bVar32 != null) {
                                if (bVar.LY >= bVar32.LY) {
                                    bVar.LY -= bVar32.Ma;
                                }
                                if (bVar.Ma >= bVar32.LY) {
                                    bVar.Ma -= bVar32.Ma;
                                }
                            }
                            if (bVar.LY >= bVar22.LY) {
                                bVar.LY -= bVar22.Ma;
                            }
                            if (bVar.Ma >= bVar22.LY) {
                                bVar.Ma -= bVar22.Ma;
                            }
                        }
                        list.set(i, bVar22);
                        if (bVar.LY != bVar.Ma) {
                            list.set(i2, bVar);
                        } else {
                            list.remove(i2);
                        }
                        if (bVar32 != null) {
                            list.add(i, bVar32);
                            break;
                        }
                        break;
                    case 4:
                        obj42 = null;
                        obj = null;
                        if (bVar.Ma < bVar22.LY) {
                            bVar22.LY--;
                        } else if (bVar.Ma < bVar22.LY + bVar22.Ma) {
                            bVar22.Ma--;
                            obj42 = aaVar.QF.a(4, bVar.LY, 1, bVar22.LZ);
                        }
                        if (bVar.LY <= bVar22.LY) {
                            bVar22.LY++;
                        } else if (bVar.LY < bVar22.LY + bVar22.Ma) {
                            i3 = (bVar22.LY + bVar22.Ma) - bVar.LY;
                            obj = aaVar.QF.a(4, bVar.LY + 1, i3, bVar22.LZ);
                            bVar22.Ma -= i3;
                        }
                        list.set(i2, bVar);
                        if (bVar22.Ma > 0) {
                            list.set(i, bVar22);
                        } else {
                            list.remove(i);
                            aaVar.QF.c(bVar22);
                        }
                        if (obj42 != null) {
                            list.add(i, obj42);
                        }
                        if (obj != null) {
                            list.add(i, obj);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            i2 = this.LR.size();
            for (i = 0; i < i2; i++) {
                bVar = (b) this.LR.get(i);
                int i42;
                int i52;
                int i62;
                switch (bVar.nc) {
                    case 1:
                        b(bVar);
                        break;
                    case 2:
                        int i72 = bVar.LY;
                        i42 = bVar.LY + bVar.Ma;
                        i52 = -1;
                        size = bVar.LY;
                        int i82 = 0;
                        while (size < i42) {
                            i62 = 0;
                            if (this.LT.aS(size) != null || aP(size)) {
                                if (i52 == 0) {
                                    a(a(2, i72, i82, null));
                                    i62 = 1;
                                }
                                i52 = 1;
                            } else {
                                if (i52 == 1) {
                                    b(a(2, i72, i82, null));
                                    i62 = 1;
                                }
                                i52 = 0;
                            }
                            if (i62 != 0) {
                                i62 = size - i82;
                                size = i42 - i82;
                                i3 = 1;
                            } else {
                                i3 = i82 + 1;
                            }
                            i42 = size;
                            size = i62 + 1;
                            i82 = i3;
                        }
                        if (i82 != bVar.Ma) {
                            c(bVar);
                            bVar = a(2, i72, i82, null);
                        }
                        if (i52 == 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                        break;
                    case 4:
                        size = bVar.LY;
                        i62 = 0;
                        i52 = bVar.LY + bVar.Ma;
                        i3 = -1;
                        i42 = bVar.LY;
                        while (i42 < i52) {
                            if (this.LT.aS(i42) != null || aP(i42)) {
                                if (i3 == 0) {
                                    a(a(4, size, i62, bVar.LZ));
                                    i62 = 0;
                                    size = i42;
                                }
                                i3 = 1;
                            } else {
                                if (i3 == 1) {
                                    b(a(4, size, i62, bVar.LZ));
                                    i62 = 0;
                                    size = i42;
                                }
                                i3 = 0;
                            }
                            i62++;
                            i42++;
                        }
                        if (i62 != bVar.Ma) {
                            obj = bVar.LZ;
                            c(bVar);
                            bVar = a(4, size, i62, obj);
                        }
                        if (i3 == 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                        break;
                    case 8:
                        b(bVar);
                        break;
                }
                if (this.LU != null) {
                    this.LU.run();
                }
            }
            this.LR.clear();
            return;
        }
    }

    final void eD() {
        int size = this.LS.size();
        for (int i = 0; i < size; i++) {
            this.LT.e((b) this.LS.get(i));
        }
        i(this.LS);
        this.LX = 0;
    }

    private void a(b bVar) {
        if (bVar.nc == 1 || bVar.nc == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int y = y(bVar.LY, bVar.nc);
        int i2 = bVar.LY;
        switch (bVar.nc) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i3 = 1;
        for (int i4 = 1; i4 < bVar.Ma; i4++) {
            Object obj;
            int y2 = y(bVar.LY + (i * i4), bVar.nc);
            int obj2;
            switch (bVar.nc) {
                case 2:
                    if (y2 != y) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = 1;
                        break;
                    }
                case 4:
                    if (y2 != y + 1) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = 1;
                        break;
                    }
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 != null) {
                i3++;
            } else {
                b a = a(bVar.nc, y, i3, bVar.LZ);
                a(a, i2);
                c(a);
                if (bVar.nc == 4) {
                    i2 += i3;
                }
                i3 = 1;
                y = y2;
            }
        }
        Object obj3 = bVar.LZ;
        c(bVar);
        if (i3 > 0) {
            b a2 = a(bVar.nc, y, i3, obj3);
            a(a2, i2);
            c(a2);
        }
    }

    private void a(b bVar, int i) {
        this.LT.d(bVar);
        switch (bVar.nc) {
            case 2:
                this.LT.A(i, bVar.Ma);
                return;
            case 4:
                this.LT.a(i, bVar.Ma, bVar.LZ);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int y(int i, int i2) {
        b bVar;
        int i3;
        int size = this.LS.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            bVar = (b) this.LS.get(size);
            if (bVar.nc == 8) {
                int i6;
                if (bVar.LY < bVar.Ma) {
                    i6 = bVar.LY;
                    i3 = bVar.Ma;
                } else {
                    i6 = bVar.Ma;
                    i3 = bVar.LY;
                }
                if (i4 < i6 || i4 > i3) {
                    if (i4 < bVar.LY) {
                        if (i2 == 1) {
                            bVar.LY++;
                            bVar.Ma++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            bVar.LY--;
                            bVar.Ma--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == bVar.LY) {
                    if (i2 == 1) {
                        bVar.Ma++;
                    } else if (i2 == 2) {
                        bVar.Ma--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.LY++;
                    } else if (i2 == 2) {
                        bVar.LY--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (bVar.LY <= i4) {
                    if (bVar.nc == 1) {
                        i5 = i4 - bVar.Ma;
                    } else if (bVar.nc == 2) {
                        i5 = bVar.Ma + i4;
                    }
                } else if (i2 == 1) {
                    bVar.LY++;
                    i5 = i4;
                } else if (i2 == 2) {
                    bVar.LY--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.LS.size() - 1; i3 >= 0; i3--) {
            bVar = (b) this.LS.get(i3);
            if (bVar.nc == 8) {
                if (bVar.Ma == bVar.LY || bVar.Ma < 0) {
                    this.LS.remove(i3);
                    c(bVar);
                }
            } else if (bVar.Ma <= 0) {
                this.LS.remove(i3);
                c(bVar);
            }
        }
        return i4;
    }

    private boolean aP(int i) {
        int size = this.LS.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.LS.get(i2);
            if (bVar.nc == 8) {
                if (z(bVar.Ma, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.nc == 1) {
                int i3 = bVar.LY + bVar.Ma;
                for (int i4 = bVar.LY; i4 < i3; i4++) {
                    if (z(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void b(b bVar) {
        this.LS.add(bVar);
        switch (bVar.nc) {
            case 1:
                this.LT.C(bVar.LY, bVar.Ma);
                return;
            case 2:
                this.LT.B(bVar.LY, bVar.Ma);
                return;
            case 4:
                this.LT.a(bVar.LY, bVar.Ma, bVar.LZ);
                return;
            case 8:
                this.LT.D(bVar.LY, bVar.Ma);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    final boolean eE() {
        return this.LR.size() > 0;
    }

    final boolean aQ(int i) {
        return (this.LX & i) != 0;
    }

    final int aR(int i) {
        return z(i, 0);
    }

    final int z(int i, int i2) {
        int size = this.LS.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = (b) this.LS.get(i2);
            if (bVar.nc == 8) {
                if (bVar.LY == i3) {
                    i3 = bVar.Ma;
                } else {
                    if (bVar.LY < i3) {
                        i3--;
                    }
                    if (bVar.Ma <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.LY > i3) {
                continue;
            } else if (bVar.nc == 2) {
                if (i3 < bVar.LY + bVar.Ma) {
                    return -1;
                }
                i3 -= bVar.Ma;
            } else if (bVar.nc == 1) {
                i3 += bVar.Ma;
            }
            i2++;
        }
        return i3;
    }

    final void eF() {
        eD();
        int size = this.LR.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.LR.get(i);
            switch (bVar.nc) {
                case 1:
                    this.LT.e(bVar);
                    this.LT.C(bVar.LY, bVar.Ma);
                    break;
                case 2:
                    this.LT.e(bVar);
                    this.LT.A(bVar.LY, bVar.Ma);
                    break;
                case 4:
                    this.LT.e(bVar);
                    this.LT.a(bVar.LY, bVar.Ma, bVar.LZ);
                    break;
                case 8:
                    this.LT.e(bVar);
                    this.LT.D(bVar.LY, bVar.Ma);
                    break;
            }
            if (this.LU != null) {
                this.LU.run();
            }
        }
        i(this.LR);
        this.LX = 0;
    }

    public final b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.LQ.bW();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.nc = i;
        bVar.LY = i2;
        bVar.Ma = i3;
        bVar.LZ = obj;
        return bVar;
    }

    public final void c(b bVar) {
        if (!this.LV) {
            bVar.LZ = null;
            this.LQ.j(bVar);
        }
    }

    private void i(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c((b) list.get(i));
        }
        list.clear();
    }
}
