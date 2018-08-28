package com.tencent.mm.plugin.webview.fts.ui;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import com.tencent.mm.plugin.webview.fts.c.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class b {
    private MMWebView dEn;
    List<a> goM;
    public int goN = -1;
    public float[] goO;
    View goP;
    public int goR = -1;
    public ag mHandler;
    public a pQJ;
    com.tencent.mm.plugin.webview.fts.c.b.b pQK;

    /* renamed from: com.tencent.mm.plugin.webview.fts.ui.b$3 */
    class AnonymousClass3 extends bd<Boolean> {
        final /* synthetic */ int Xt;
        final /* synthetic */ int fKG;
        final /* synthetic */ float[] goU;

        public AnonymousClass3(Boolean bool, int i, float[] fArr, int i2) {
            this.fKG = i;
            this.goU = fArr;
            this.Xt = i2;
            super(1000, bool, (byte) 0);
        }

        protected final /* synthetic */ Object run() {
            return Boolean.valueOf(b.this.a(this.fKG, this.goU, this.Xt));
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public b(MMWebView mMWebView, com.tencent.mm.plugin.webview.fts.c.b.b bVar) {
        this.dEn = mMWebView;
        this.mHandler = new ag(Looper.getMainLooper());
        this.goM = new LinkedList();
        this.goP = new View(mMWebView.getContext());
        this.pQK = bVar;
    }

    final boolean a(View view, int i, int i2, float[] fArr, int i3) {
        int i4 = 0;
        if (view == null || fArr == null || fArr.length < 5) {
            return false;
        }
        ViewGroup ls = ls(i2);
        if (ls == null || lx(i) != null) {
            return false;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        int i5 = (int) fArr[4];
        LayoutParams layoutParams = new LayoutParams((int) fArr[2], (int) fArr[3]);
        int bO = bO(i2, i5);
        if (bO < 0) {
            bO = 0;
        }
        if (bO > ls.getChildCount()) {
            bO = ls.getChildCount();
        }
        if (i3 != Integer.MAX_VALUE && i3 >= 0) {
            if (i3 != 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        ls.addView(view, bO, layoutParams);
        view.setX(f);
        view.setY(f2);
        c(view, i, i2, i5);
        return true;
    }

    final ViewGroup ls(int i) {
        if (i == 0) {
            ViewGroup topView = this.dEn.getTopView();
            if (topView instanceof AbsoluteLayout) {
                return topView;
            }
            return null;
        }
        a Aj = Aj(i);
        if (Aj == null) {
            return null;
        }
        View view = (View) Aj.gpb.get();
        return view instanceof ViewGroup ? (ViewGroup) view : null;
    }

    public final boolean a(int i, float[] fArr, int i2) {
        if (lz(i)) {
            return true;
        }
        a Aj = Aj(i);
        if (Aj == null) {
            return false;
        }
        View view = (View) Aj.gpb.get();
        ViewGroup ls = ls(Aj.gpc);
        if (ls == null) {
            return false;
        }
        if (i2 >= 0 && i2 != Integer.MAX_VALUE) {
            view.setVisibility(i2 == 0 ? 0 : 8);
        }
        if (fArr == null || fArr.length < 5) {
            return true;
        }
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        int i3 = (int) fArr[4];
        this.goM.remove(Aj);
        if (Aj.z != i3) {
            ls.removeView(view);
            if (a(view, i, Aj.gpc, fArr, i2)) {
                return true;
            }
            a(Aj);
            return false;
        }
        LayoutParams layoutParams = view.getLayoutParams();
        if (f3 != Float.MAX_VALUE) {
            layoutParams.width = (int) f3;
        }
        if (f4 != Float.MAX_VALUE) {
            layoutParams.height = (int) f4;
        }
        if (f != Float.MAX_VALUE) {
            view.setX(f);
        }
        if (f2 != Float.MAX_VALUE) {
            view.setY(f2);
        }
        view.requestLayout();
        c(view, i, Aj.gpc, i3);
        int indexOfChild = ls.indexOfChild(this.goP);
        if (ls.indexOfChild(view) == -1 && indexOfChild != -1) {
            ls.addView(view, indexOfChild);
            ls.removeView(this.goP);
        }
        return true;
    }

    final void a(a aVar) {
        this.goM.removeAll(b(aVar));
    }

    private List<a> b(a aVar) {
        List<a> linkedList = new LinkedList();
        for (a aVar2 : this.goM) {
            if (aVar2.gpc == aVar.id) {
                linkedList.addAll(b(aVar2));
            }
        }
        linkedList.add(aVar);
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
            a aVar = (a) it.next();
            if (i == aVar.gpc && i2 >= aVar.z) {
                i4++;
            }
            i3 = i4;
        }
    }

    public final a Aj(int i) {
        for (a aVar : this.goM) {
            if (aVar.id == i) {
                return aVar;
            }
        }
        return null;
    }

    public final View lx(int i) {
        a Aj = Aj(i);
        return Aj == null ? null : (View) Aj.gpb.get();
    }

    private void c(View view, int i, int i2, int i3) {
        this.goM.add(new a(view, i, i2, i3));
    }

    public final boolean lz(int i) {
        return this.goR == i || this.goN == i;
    }

    final boolean lB(int i) {
        if (i != this.goN || Aj(i) == null) {
            return false;
        }
        this.pQK.bTT();
        return true;
    }
}
