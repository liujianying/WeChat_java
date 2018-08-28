package android.support.v7.widget;

import android.support.v4.a.a;
import android.support.v4.view.ai;
import android.support.v4.view.z;
import android.support.v7.widget.RecyclerView.t;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends aj {
    private ArrayList<t> NN = new ArrayList();
    private ArrayList<t> NO = new ArrayList();
    private ArrayList<b> NP = new ArrayList();
    private ArrayList<a> NQ = new ArrayList();
    ArrayList<ArrayList<t>> NR = new ArrayList();
    ArrayList<ArrayList<b>> NS = new ArrayList();
    ArrayList<ArrayList<a>> NT = new ArrayList();
    ArrayList<t> NU = new ArrayList();
    ArrayList<t> NV = new ArrayList();
    ArrayList<t> NW = new ArrayList();
    ArrayList<t> NX = new ArrayList();

    public void eR() {
        int i;
        int i2;
        int i3;
        int i4 = !this.NN.isEmpty() ? 1 : 0;
        if (this.NP.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.NQ.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.NO.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            ArrayList arrayList;
            Runnable 1;
            Iterator it = this.NN.iterator();
            while (it.hasNext()) {
                t tVar = (t) it.next();
                ai U = z.U(tVar.SU);
                this.NW.add(tVar);
                U.h(this.RW).t(0.0f).a(new 4(this, tVar, U)).start();
            }
            this.NN.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.NP);
                this.NS.add(arrayList);
                this.NP.clear();
                1 = new 1(this, arrayList);
                if (i4 != 0) {
                    z.a(((b) arrayList.get(0)).Oq.SU, 1, this.RW);
                } else {
                    1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.NQ);
                this.NT.add(arrayList);
                this.NQ.clear();
                1 = new 2(this, arrayList);
                if (i4 != 0) {
                    z.a(((a) arrayList.get(0)).Ok.SU, 1, this.RW);
                } else {
                    1.run();
                }
            }
            if (i3 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.NO);
                this.NR.add(arrayList2);
                this.NO.clear();
                Runnable 3 = new 3(this, arrayList2);
                if (i4 == 0 && i == 0 && i2 == 0) {
                    3.run();
                    return;
                }
                long j;
                long j2;
                long j3 = i4 != 0 ? this.RW : 0;
                if (i != 0) {
                    j = this.RX;
                } else {
                    j = 0;
                }
                if (i2 != 0) {
                    j2 = this.RY;
                } else {
                    j2 = 0;
                }
                z.a(((t) arrayList2.get(0)).SU, 3, j3 + Math.max(j, j2));
            }
        }
    }

    public boolean b(t tVar) {
        e(tVar);
        this.NN.add(tVar);
        return true;
    }

    public boolean c(t tVar) {
        e(tVar);
        z.d(tVar.SU, 0.0f);
        this.NO.add(tVar);
        return true;
    }

    public boolean a(t tVar, int i, int i2, int i3, int i4) {
        View view = tVar.SU;
        int Q = (int) (((float) i) + z.Q(tVar.SU));
        int R = (int) (((float) i2) + z.R(tVar.SU));
        e(tVar);
        int i5 = i3 - Q;
        int i6 = i4 - R;
        if (i5 == 0 && i6 == 0) {
            y(tVar);
            return false;
        }
        if (i5 != 0) {
            z.b(view, (float) (-i5));
        }
        if (i6 != 0) {
            z.c(view, (float) (-i6));
        }
        this.NP.add(new b(tVar, Q, R, i3, i4, (byte) 0));
        return true;
    }

    public boolean a(t tVar, t tVar2, int i, int i2, int i3, int i4) {
        if (tVar == tVar2) {
            return a(tVar, i, i2, i3, i4);
        }
        float Q = z.Q(tVar.SU);
        float R = z.R(tVar.SU);
        float G = z.G(tVar.SU);
        e(tVar);
        int i5 = (int) (((float) (i3 - i)) - Q);
        int i6 = (int) (((float) (i4 - i2)) - R);
        z.b(tVar.SU, Q);
        z.c(tVar.SU, R);
        z.d(tVar.SU, G);
        if (tVar2 != null) {
            e(tVar2);
            z.b(tVar2.SU, (float) (-i5));
            z.c(tVar2.SU, (float) (-i6));
            z.d(tVar2.SU, 0.0f);
        }
        this.NQ.add(new a(tVar, tVar2, i, i2, i3, i4, (byte) 0));
        return true;
    }

    private void a(List<a> list, t tVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, tVar) && aVar.Ok == null && aVar.Ol == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.Ok != null) {
            a(aVar, aVar.Ok);
        }
        if (aVar.Ol != null) {
            a(aVar, aVar.Ol);
        }
    }

    private boolean a(a aVar, t tVar) {
        if (aVar.Ol == tVar) {
            aVar.Ol = null;
        } else if (aVar.Ok != tVar) {
            return false;
        } else {
            aVar.Ok = null;
        }
        z.d(tVar.SU, 1.0f);
        z.b(tVar.SU, 0.0f);
        z.c(tVar.SU, 0.0f);
        k(tVar);
        return true;
    }

    public void d(t tVar) {
        int size;
        ArrayList arrayList;
        View view = tVar.SU;
        z.U(view).cancel();
        for (size = this.NP.size() - 1; size >= 0; size--) {
            if (((b) this.NP.get(size)).Oq == tVar) {
                z.c(view, 0.0f);
                z.b(view, 0.0f);
                y(tVar);
                this.NP.remove(size);
            }
        }
        a(this.NQ, tVar);
        if (this.NN.remove(tVar)) {
            z.d(view, 1.0f);
            k(tVar);
        }
        if (this.NO.remove(tVar)) {
            z.d(view, 1.0f);
            k(tVar);
        }
        for (size = this.NT.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.NT.get(size);
            a(list, tVar);
            if (list.isEmpty()) {
                this.NT.remove(size);
            }
        }
        for (int size2 = this.NS.size() - 1; size2 >= 0; size2--) {
            arrayList = (ArrayList) this.NS.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).Oq == tVar) {
                    z.c(view, 0.0f);
                    z.b(view, 0.0f);
                    y(tVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.NS.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.NR.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.NR.get(size);
            if (arrayList.remove(tVar)) {
                z.d(view, 1.0f);
                k(tVar);
                if (arrayList.isEmpty()) {
                    this.NR.remove(size);
                }
            }
        }
        this.NW.remove(tVar);
        this.NU.remove(tVar);
        this.NX.remove(tVar);
        this.NV.remove(tVar);
        eS();
    }

    private void e(t tVar) {
        a.v(tVar.SU);
        d(tVar);
    }

    public boolean isRunning() {
        return (this.NO.isEmpty() && this.NQ.isEmpty() && this.NP.isEmpty() && this.NN.isEmpty() && this.NV.isEmpty() && this.NW.isEmpty() && this.NU.isEmpty() && this.NX.isEmpty() && this.NS.isEmpty() && this.NR.isEmpty() && this.NT.isEmpty()) ? false : true;
    }

    final void eS() {
        if (!isRunning()) {
            fZ();
        }
    }

    public final void eT() {
        int size;
        for (size = this.NP.size() - 1; size >= 0; size--) {
            b bVar = (b) this.NP.get(size);
            View view = bVar.Oq.SU;
            z.c(view, 0.0f);
            z.b(view, 0.0f);
            y(bVar.Oq);
            this.NP.remove(size);
        }
        for (size = this.NN.size() - 1; size >= 0; size--) {
            k((t) this.NN.get(size));
            this.NN.remove(size);
        }
        for (size = this.NO.size() - 1; size >= 0; size--) {
            t tVar = (t) this.NO.get(size);
            z.d(tVar.SU, 1.0f);
            k(tVar);
            this.NO.remove(size);
        }
        for (size = this.NQ.size() - 1; size >= 0; size--) {
            a((a) this.NQ.get(size));
        }
        this.NQ.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.NS.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.NS.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.Oq.SU;
                    z.c(view2, 0.0f);
                    z.b(view2, 0.0f);
                    y(bVar2.Oq);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.NS.remove(arrayList);
                    }
                }
            }
            for (size2 = this.NR.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.NR.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    t tVar2 = (t) arrayList.get(size3);
                    z.d(tVar2.SU, 1.0f);
                    k(tVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.NR.remove(arrayList);
                    }
                }
            }
            for (size2 = this.NT.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.NT.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.NT.remove(arrayList);
                    }
                }
            }
            j(this.NW);
            j(this.NV);
            j(this.NU);
            j(this.NX);
            fZ();
        }
    }

    private static void j(List<t> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            z.U(((t) list.get(size)).SU).cancel();
        }
    }

    public boolean a(t tVar, List<Object> list) {
        return !list.isEmpty() || super.a(tVar, list);
    }
}
