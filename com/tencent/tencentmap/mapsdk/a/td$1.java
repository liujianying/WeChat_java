package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import com.tencent.tencentmap.mapsdk.a.tc.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public /* synthetic */ class td$1 {
    ArrayList<tc> a = null;
    ArrayList<tc> b = null;
    ArrayList<tc> c = null;
    tg d;
    private sl e;
    private sh f;
    private int g = 0;
    private List<su> h;
    private PaintFlagsDrawFilter i;

    public td$1(sl slVar) {
        this.e = slVar;
        this.f = slVar.c();
        this.d = new tg(slVar);
        this.h = new ArrayList();
    }

    public static int a(a aVar) {
        switch (to.a[aVar.ordinal()]) {
            case 1:
                return sn.g();
            case 2:
                return sn.b();
            case 3:
                return sn.d();
            default:
                return -1;
        }
    }

    private ArrayList<tc> a(int i) {
        return a(this.f.b(), i, this.f.getWidth(), this.f.getHeight(), this.e.f().d());
    }

    private static void a(ArrayList<tc> arrayList) {
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((tc) it.next()).c();
            }
            arrayList.clear();
        }
    }

    private static void a(ArrayList<tc> arrayList, ArrayList<tc> arrayList2, ArrayList<tc> arrayList3) {
        if (arrayList != null && arrayList.size() != 0) {
            tc tcVar;
            for (int i = 0; i < arrayList.size(); i++) {
                tcVar = (tc) arrayList.get(i);
                if (tcVar != null) {
                    List b;
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                            tc tcVar2 = (tc) arrayList2.get(i2);
                            if (tcVar2.equals(tcVar)) {
                                b = tcVar2.b();
                                arrayList2.remove(i2);
                                break;
                            }
                        }
                    }
                    b = null;
                    if ((b == null || tcVar.a(b)) && arrayList3 != null) {
                        arrayList3.add(tcVar);
                    }
                }
            }
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    tcVar = (tc) it.next();
                    if (!(tcVar == null || tcVar.b() == null)) {
                        try {
                            tcVar.c();
                        } catch (Exception e) {
                        }
                    }
                }
                arrayList2.clear();
            }
        }
    }

    private static void a(List<tc> list, su suVar) {
        if (list != null) {
            for (tc a : list) {
                a.a(suVar);
            }
        }
    }

    private boolean a(Canvas canvas, ArrayList<tc> arrayList) {
        double b = this.f.d().b();
        PointF a = this.f.a();
        boolean z = true;
        if (arrayList != null && arrayList.size() > 0) {
            int a2 = ((tc) arrayList.get(0)).a();
            int a3 = this.f.d().a();
            if (this.e.f().e()) {
                a3--;
            }
            b *= Math.pow(2.0d, (double) (a3 - a2));
            if (b != 1.0d) {
                Matrix matrix = new Matrix();
                canvas.save();
                matrix.reset();
                matrix.postScale((float) b, (float) b, a.x, a.y);
                canvas.concat(matrix);
            }
            int i = 0;
            while (i < arrayList.size()) {
                try {
                    tc tcVar = (tc) arrayList.get(i);
                    boolean z2 = (tcVar == null || tcVar.a(canvas)) ? z : false;
                    i++;
                    z = z2;
                } catch (Throwable th) {
                }
            }
            if (b != 1.0d) {
                canvas.restore();
            }
        }
        return z;
    }

    private static void b(List<tc> list, su suVar) {
        if (list != null) {
            for (tc b : list) {
                b.b(suVar);
            }
        }
    }

    PointF a(int i, int i2, int i3, int i4, PointF pointF, int i5, int i6, int i7, int i8) {
        PointF pointF2 = new PointF();
        if (i < 0 || i2 < 0 || ((double) i) >= Math.pow(2.0d, (double) i8) || ((double) i2) >= Math.pow(2.0d, (double) i8)) {
            return null;
        }
        pointF2.x = ((float) ((i - i3) * i7)) + pointF.x;
        pointF2.y = ((float) ((i2 - i4) * i7)) + pointF.y;
        return (pointF2.x + ((float) i7) <= 0.0f || pointF2.x >= ((float) i5) || pointF2.y + ((float) i7) <= 0.0f || pointF2.y >= ((float) i6)) ? null : pointF2;
    }

    public su a(rg rgVar) {
        su suVar = new su(this.e, rgVar);
        this.h.add(suVar);
        a(this.b, suVar);
        a(null, suVar);
        a(this.c, suVar);
        this.e.a(false, false);
        return suVar;
    }

    public ArrayList<tc> a(ru ruVar, int i, int i2, int i3, int i4) {
        int i5 = 0;
        if (this.e.f().e()) {
            i5 = 1;
        }
        double c = rs.c((double) (i5 + i));
        a c2 = this.e.f().c();
        new StringBuilder("mapSource:").append(c2);
        int b = (int) ((ruVar.b() - -2.003750834E7d) / (((double) i4) * c));
        int a = (int) ((2.003750834E7d - ruVar.a()) / (((double) i4) * c));
        ru ruVar2 = new ru((((double) (b * i4)) * c) - 2.1525280871514951E-7d, 2.003750834E7d - (((double) (a * i4)) * c));
        PointF a2 = this.f.a();
        PointF pointF = new PointF();
        pointF.x = (float) (((ruVar2.b() - ruVar.b()) / c) + ((double) a2.x));
        pointF.y = (float) (((double) a2.y) - ((ruVar2.a() - ruVar.a()) / c));
        tc tcVar = new tc(this.e, b, a, i, a(c2), c2, this.h);
        tcVar.a(pointF);
        ArrayList<tc> arrayList = new ArrayList();
        arrayList.add(tcVar);
        i5 = 1;
        while (true) {
            int i6;
            PointF a3;
            int i7 = i5;
            Object obj = null;
            for (i6 = b - i7; i6 <= b + i7; i6++) {
                tc tcVar2;
                int i8 = a + i7;
                a3 = a(i6, i8, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    tcVar2 = new tc(this.e, i6, i8, i, a(c2), c2, this.h);
                    tcVar2.a(a3);
                    arrayList.add(tcVar2);
                }
                i8 = a - i7;
                a3 = a(i6, i8, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    tcVar2 = new tc(this.e, i6, i8, i, a(c2), c2, this.h);
                    tcVar2.a(a3);
                    arrayList.add(tcVar2);
                }
            }
            for (i6 = (a + i7) - 1; i6 > a - i7; i6--) {
                tc tcVar3;
                int i9 = b + i7;
                a3 = a(i9, i6, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    tcVar3 = new tc(this.e, i9, i6, i, a(c2), c2, this.h);
                    tcVar3.a(a3);
                    arrayList.add(tcVar3);
                }
                i9 = b - i7;
                a3 = a(i9, i6, b, a, pointF, i2, i3, i4, i);
                if (a3 != null) {
                    if (obj == null) {
                        obj = 1;
                    }
                    tcVar3 = new tc(this.e, i9, i6, i, a(c2), c2, this.h);
                    tcVar3.a(a3);
                    arrayList.add(tcVar3);
                }
            }
            if (obj == null) {
                return arrayList;
            }
            i5 = i7 + 1;
        }
    }

    public void a() {
        a(null);
        a(this.b);
        a(this.c);
        this.d.a();
    }

    public void a(boolean z, boolean z2) {
        ArrayList arrayList;
        int i;
        ArrayList arrayList2;
        if (!z) {
            a aVar = a.a;
            aVar = this.e.l() == 2 ? a.c : (!sn.h() || this.f.d().a() <= 7 || b()) ? a.a : a.b;
            if (this.e.f().c() != aVar) {
                this.e.f().a(aVar);
                if (this.b != null) {
                    this.b.clear();
                }
                if (this.c != null) {
                    this.c.clear();
                }
            }
        }
        if (this.e.f().e()) {
            this.e.f().a(512);
        } else {
            this.e.f().a(256);
        }
        int a = this.f.d().a();
        int i2 = this.e.f().e() ? a - 1 : a;
        if (this.b == null || this.b.size() <= 0) {
            arrayList = null;
            i = -1;
        } else {
            i = ((tc) this.b.get(0)).a();
            arrayList = this.b;
        }
        int i3 = i - i2;
        if (i3 != 0 || z2) {
            if (this.c == null || this.c.size() <= 0) {
                arrayList2 = null;
                i = -1;
            } else {
                i = ((tc) this.c.get(0)).a();
                arrayList2 = this.c;
            }
            if (i2 == i && i != -1) {
                this.b = arrayList2;
            }
            if (Math.abs(i3) == 1) {
                this.c = arrayList;
            }
        }
        ArrayList arrayList3 = new ArrayList();
        if (this.c != null && this.c.size() > 0) {
            arrayList2 = a(((tc) this.c.get(0)).a());
            a(arrayList2, this.c, null);
            this.c = arrayList2;
        }
        arrayList2 = a(i2);
        a(arrayList2, this.b, arrayList3);
        this.b = arrayList2;
        this.d.a(arrayList3);
        this.e.c().invalidate();
    }

    public boolean a(Canvas canvas) {
        a(canvas, null);
        a(canvas, this.c);
        if (this.i == null) {
            this.i = new PaintFlagsDrawFilter(0, 2);
        }
        canvas.setDrawFilter(this.i);
        boolean a = a(canvas, this.b);
        canvas.setDrawFilter(null);
        if (!a) {
            return false;
        }
        if (this.c != null) {
            this.c.clear();
        }
        return true;
    }

    public boolean a(su suVar) {
        boolean remove = this.h.remove(suVar);
        if (remove) {
            b(this.b, suVar);
            b(null, suVar);
            b(this.c, suVar);
        }
        this.e.a(false, false);
        return remove;
    }

    public boolean b() {
        ru[] b = this.e.b().b();
        sk.a();
        ru[] c = sk.c("china");
        boolean z = false;
        for (ru a : b) {
            z |= sk.a(a, c);
            if (z) {
                return true;
            }
        }
        return z;
    }
}
