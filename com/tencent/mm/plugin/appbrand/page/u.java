package com.tencent.mm.plugin.appbrand.page;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.o;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.p;
import com.tencent.mm.plugin.appbrand.page.z.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class u {
    c gnB;
    private ViewGroup goL;
    List<b> goM;
    int goN = -1;
    float[] goO;
    View goP;
    y goQ;
    int goR = -1;
    ag mHandler;

    public u(ViewGroup viewGroup) {
        this.goL = viewGroup;
        this.mHandler = new ag(Looper.getMainLooper());
        this.goM = new LinkedList();
        this.goP = new View(viewGroup.getContext());
    }

    public final void setFullscreenImpl(c cVar) {
        this.gnB = cVar;
        this.gnB.a(new 1(this));
    }

    public final boolean a(View view, int i, int i2, float[] fArr, int i3, boolean z) {
        2 2 = new 2(this, Boolean.valueOf(false), view, i, i2, fArr, i3, z);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 2.a(null)).booleanValue();
        }
        return ((Boolean) 2.a(this.mHandler)).booleanValue();
    }

    final boolean b(View view, int i, int i2, float[] fArr, int i3, boolean z) {
        if (view == null || fArr == null || fArr.length < 5) {
            return false;
        }
        ViewGroup ls = ls(i2);
        if (ls == null) {
            return false;
        }
        if (lx(i) != null) {
            return false;
        }
        int i4;
        float f;
        float f2;
        float f3 = fArr[0];
        float f4 = fArr[1];
        int i5 = (int) fArr[4];
        LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
        int bO = bO(i2, i5);
        if (bO < 0) {
            i4 = 0;
        } else {
            i4 = bO;
        }
        if (ls instanceof o) {
            bO = ((o) ls).getTargetViewChildCount();
        } else {
            bO = ls.getChildCount();
        }
        if (i4 > bO) {
            i4 = bO;
        }
        if (i3 >= 0) {
            view.setVisibility(i3 == 0 ? 0 : 4);
        }
        ls.addView(view, i4, layoutParams);
        b bVar = new b(view, i, i2, i5, z);
        this.goM.add(bVar);
        if (i2 == 0 && (ls instanceof z) && z) {
            a aVar = new a((byte) 0);
            aVar.view = view;
            aVar.x = f3;
            aVar.y = f4;
            aVar.goZ = (float) this.goL.getScrollX();
            aVar.gpa = (float) this.goL.getScrollY();
            f = f3 + aVar.goZ;
            float f5 = aVar.gpa + f4;
            ((z) ls).a(aVar);
            bVar.gpe = aVar;
            f2 = f5;
        } else {
            f2 = f4;
            f = f3;
        }
        view.setX(f);
        view.setY(f2);
        return true;
    }

    final ViewGroup ls(int i) {
        if (i == 0) {
            return this.goL;
        }
        b lv = lv(i);
        if (lv == null) {
            return null;
        }
        View view = (View) lv.gpb.get();
        return ((view instanceof p) && (view instanceof ViewGroup)) ? (ViewGroup) view : null;
    }

    public final boolean lt(int i) {
        3 3 = new 3(this, Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 3.a(null)).booleanValue();
        }
        return ((Boolean) 3.a(this.mHandler)).booleanValue();
    }

    final boolean lu(int i) {
        b lv = lv(i);
        if (lv == null) {
            return false;
        }
        lB(i);
        a(lv);
        ViewGroup ls = ls(lv.gpc);
        if (ls == null) {
            return false;
        }
        this.goM.remove(lv);
        ls.removeView((View) lv.gpb.get());
        if (lv.gpc == 0 && (ls instanceof z) && lv.gpd) {
            ((z) ls).b(lv.gpe);
        }
        return true;
    }

    public final boolean a(int i, float[] fArr, int i2, Boolean bool) {
        5 5 = new 5(this, Boolean.valueOf(false), i, fArr, i2, bool);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 5.a(null)).booleanValue();
        }
        return ((Boolean) 5.a(this.mHandler)).booleanValue();
    }

    final boolean b(int i, float[] fArr, int i2, Boolean bool) {
        if (lz(i)) {
            return true;
        }
        b lv = lv(i);
        if (lv == null) {
            return false;
        }
        View view = (View) lv.gpb.get();
        ViewGroup ls = ls(lv.gpc);
        if (ls == null) {
            return false;
        }
        if (i2 >= 0) {
            view.setVisibility(i2 == 0 ? 0 : 4);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        boolean booleanValue = bool != null ? bool.booleanValue() : lv.gpd;
        if (lv.z != i3) {
            this.goM.remove(lv);
            ls.removeView(view);
            if (b(view, i, lv.gpc, fArr, i2, booleanValue)) {
                return true;
            }
            a(lv);
            return false;
        }
        a aVar;
        float f5;
        float f6;
        LayoutParams layoutParams;
        a aVar2 = lv.gpe;
        if (lv.gpc == 0 && (ls instanceof z) && booleanValue != lv.gpd) {
            if (booleanValue) {
                if (aVar2 == null) {
                    aVar = new a((byte) 0);
                    aVar.view = view;
                    lv.gpe = aVar;
                    aVar2 = aVar;
                }
                ((z) ls).a(aVar2);
                aVar = aVar2;
                if (aVar == null) {
                    aVar.x = f;
                    aVar.y = f2;
                    aVar.goZ = (float) this.goL.getScrollX();
                    aVar.gpa = (float) this.goL.getScrollY();
                    f5 = aVar.goZ + f;
                    f6 = aVar.gpa + f2;
                } else {
                    f6 = f2;
                    f5 = f;
                }
                layoutParams = view.getLayoutParams();
                layoutParams.width = (int) f3;
                layoutParams.height = (int) f4;
                view.setX(f5);
                view.setY(f6);
                view.requestLayout();
                i3 = ls.indexOfChild(this.goP);
                if (ls.indexOfChild(view) == -1 && i3 != -1) {
                    ls.addView(view, i3);
                    ls.removeView(this.goP);
                }
                return true;
            }
            ((z) ls).b(lv.gpe);
        }
        aVar = aVar2;
        if (aVar == null) {
            f6 = f2;
            f5 = f;
        } else {
            aVar.x = f;
            aVar.y = f2;
            aVar.goZ = (float) this.goL.getScrollX();
            aVar.gpa = (float) this.goL.getScrollY();
            f5 = aVar.goZ + f;
            f6 = aVar.gpa + f2;
        }
        layoutParams = view.getLayoutParams();
        layoutParams.width = (int) f3;
        layoutParams.height = (int) f4;
        view.setX(f5);
        view.setY(f6);
        view.requestLayout();
        i3 = ls.indexOfChild(this.goP);
        ls.addView(view, i3);
        ls.removeView(this.goP);
        return true;
    }

    private void a(b bVar) {
        this.goM.removeAll(b(bVar));
    }

    private List<b> b(b bVar) {
        List<b> linkedList = new LinkedList();
        for (b bVar2 : this.goM) {
            if (bVar2.gpc == bVar.id) {
                linkedList.addAll(b(bVar2));
            }
        }
        linkedList.add(bVar);
        return linkedList;
    }

    private int bO(int i, int i2) {
        int i3 = 0;
        Iterator it = this.goM.iterator();
        while (true) {
            int i4 = i3;
            if (!it.hasNext()) {
                return i4;
            }
            b bVar = (b) it.next();
            if (i == bVar.gpc && i2 >= bVar.z) {
                i4++;
            }
            i3 = i4;
        }
    }

    public final b lv(int i) {
        for (b bVar : this.goM) {
            if (bVar.id == i) {
                return bVar;
            }
        }
        return null;
    }

    public final boolean lw(int i) {
        return lv(i) != null;
    }

    public final View lx(int i) {
        b lv = lv(i);
        return lv == null ? null : (View) lv.gpb.get();
    }

    public final b ly(int i) {
        return com.tencent.mm.model.u.Hx().ib(hashCode() + "#" + i);
    }

    public final b E(int i, boolean z) {
        return com.tencent.mm.model.u.Hx().v(hashCode() + "#" + i, z);
    }

    public final boolean lz(int i) {
        return this.goR == i || this.goN == i;
    }

    public final boolean a(int i, y yVar, int i2) {
        6 6 = new 6(this, Boolean.valueOf(false), i, yVar, i2);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 6.a(null)).booleanValue();
        }
        return ((Boolean) 6.a(this.mHandler)).booleanValue();
    }

    public final boolean lA(int i) {
        7 7 = new 7(this, Boolean.valueOf(false), i);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            return ((Boolean) 7.a(null)).booleanValue();
        }
        return ((Boolean) 7.a(this.mHandler)).booleanValue();
    }

    final boolean lB(int i) {
        if (i != this.goN || lv(i) == null) {
            return false;
        }
        this.gnB.alE();
        return true;
    }
}
