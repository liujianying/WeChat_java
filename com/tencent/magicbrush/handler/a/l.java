package com.tencent.magicbrush.handler.a;

import android.graphics.Rect;
import com.tencent.magicbrush.handler.a.d.a;
import com.tencent.magicbrush.handler.a.d.c;
import java.util.ArrayList;
import java.util.Iterator;

final class l implements d {
    private a boA = new a();
    private int boB;
    private c boC = new c();
    private ArrayList<d$b> boz = new ArrayList();
    private int mHeight;
    private int mWidth;

    l() {
    }

    public final void init(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        reset();
    }

    public final void a(int i, int i2, Rect rect) {
        if (rect != null) {
            if (i <= 0 || i2 <= 0) {
                rect.setEmpty();
                return;
            }
            d$b d_b;
            int i3;
            c cVar;
            c cVar2 = this.boC;
            cVar2.x = 0;
            cVar2.y = 0;
            cVar2.width = i;
            cVar2.height = i2;
            int i4 = Integer.MAX_VALUE;
            int i5 = -1;
            int i6 = 0;
            int i7 = Integer.MAX_VALUE;
            while (true) {
                int i8 = i4;
                if (i6 >= this.boz.size()) {
                    break;
                }
                int i9;
                d_b = (d$b) this.boz.get(i6);
                if (d_b.x + i > this.mWidth - 1) {
                    i9 = -1;
                } else {
                    i3 = d_b.y;
                    i9 = i6;
                    int i10 = i;
                    while (i10 > 0) {
                        d_b = (d$b) this.boz.get(i9);
                        if (d_b.y > i3) {
                            i3 = d_b.y;
                        }
                        if (i3 + i2 > this.mHeight - 1) {
                            i9 = -1;
                            break;
                        } else {
                            i10 -= d_b.z;
                            i9++;
                        }
                    }
                    i9 = i3;
                }
                if (i9 >= 0) {
                    d_b = (d$b) this.boz.get(i6);
                    if (i9 + i2 < i8 || (i9 + i2 == i8 && d_b.z > 0 && d_b.z < i7)) {
                        i7 = i9 + i2;
                        i3 = d_b.z;
                        cVar2.x = d_b.x;
                        cVar2.y = i9;
                        i4 = i3;
                        i8 = i7;
                        i5 = i6;
                        i6++;
                    }
                }
                i4 = i7;
                i6++;
            }
            if (i5 == -1) {
                cVar2.x = -1;
                cVar2.y = -1;
                cVar2.width = 0;
                cVar2.height = 0;
                cVar = cVar2;
            } else {
                d$b d_b2;
                d_b = this.boA.td();
                d_b.x = cVar2.x;
                d_b.y = cVar2.y + i2;
                d_b.z = i;
                this.boz.add(i5, d_b);
                i4 = i5 + 1;
                while (true) {
                    i7 = i4;
                    if (i7 >= this.boz.size()) {
                        break;
                    }
                    d_b = (d$b) this.boz.get(i7);
                    d_b2 = (d$b) this.boz.get(i7 - 1);
                    if (d_b.x >= d_b2.x + d_b2.z) {
                        break;
                    }
                    i3 = (d_b2.z + d_b2.x) - d_b.x;
                    d_b.x += i3;
                    d_b.z -= i3;
                    if (d_b.z > 0) {
                        break;
                    }
                    this.boA.a((d$b) this.boz.remove(i7));
                    i4 = (i7 - 1) + 1;
                }
                i4 = 0;
                while (true) {
                    i7 = i4;
                    if (i7 >= this.boz.size() - 1) {
                        break;
                    }
                    d_b = (d$b) this.boz.get(i7);
                    d_b2 = (d$b) this.boz.get(i7 + 1);
                    if (d_b.y == d_b2.y) {
                        d_b.z = d_b2.z + d_b.z;
                        this.boA.a((d$b) this.boz.remove(i7 + 1));
                        i7--;
                    }
                    i4 = i7 + 1;
                }
                this.boB += i * i2;
                cVar = cVar2;
            }
            if (cVar.x < 0 || cVar.y < 0) {
                rect.setEmpty();
            } else {
                rect.set(cVar.x, cVar.y, (cVar.x + i) - 1, (cVar.y + i2) - 1);
            }
        }
    }

    public final void reset() {
        this.boB = 0;
        a aVar = this.boA;
        ArrayList arrayList = this.boz;
        if (!(arrayList == null || arrayList.isEmpty())) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.bnG.offer((d$b) it.next());
            }
            arrayList.clear();
        }
        d$b td = this.boA.td();
        int i = this.mWidth - 2;
        td.x = 1;
        td.y = 1;
        td.z = i;
        this.boz.add(td);
    }
}
