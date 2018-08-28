package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.z;
import android.support.v7.view.menu.l.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements l {
    protected LayoutInflater Bc;
    public Context HF;
    protected LayoutInflater HG;
    private int HH;
    private int HI;
    public m HJ;
    public a bp;
    public f bq;
    public Context mContext;
    public int mId;

    public abstract void a(h hVar, m.a aVar);

    public b(Context context, int i, int i2) {
        this.HF = context;
        this.HG = LayoutInflater.from(context);
        this.HH = i;
        this.HI = i2;
    }

    public void a(Context context, f fVar) {
        this.mContext = context;
        this.Bc = LayoutInflater.from(this.mContext);
        this.bq = fVar;
    }

    public m e(ViewGroup viewGroup) {
        if (this.HJ == null) {
            this.HJ = (m) this.HG.inflate(this.HH, viewGroup, false);
            this.HJ.a(this.bq);
            n(true);
        }
        return this.HJ;
    }

    public void n(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.HJ;
        if (viewGroup != null) {
            int i;
            if (this.bq != null) {
                this.bq.dO();
                ArrayList dN = this.bq.dN();
                int size = dN.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    h hVar = (h) dN.get(i2);
                    if (e(hVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        h itemData = childAt instanceof m.a ? ((m.a) childAt).getItemData() : null;
                        View a = a(hVar, childAt, viewGroup);
                        if (hVar != itemData) {
                            a.setPressed(false);
                            z.aa(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.HJ).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!c(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean c(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        m.a aVar;
        if (view instanceof m.a) {
            aVar = (m.a) view;
        } else {
            aVar = (m.a) this.HG.inflate(this.HI, viewGroup, false);
        }
        a(hVar, aVar);
        return (View) aVar;
    }

    public boolean e(h hVar) {
        return true;
    }

    public void a(f fVar, boolean z) {
        if (this.bp != null) {
            this.bp.a(fVar, z);
        }
    }

    public boolean a(p pVar) {
        if (this.bp != null) {
            return this.bp.d(pVar);
        }
        return false;
    }

    public boolean N() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.mId;
    }
}
