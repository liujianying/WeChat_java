package android.support.v7.widget;

import android.support.v4.e.a;
import android.support.v4.e.e;
import android.support.v7.widget.RecyclerView.e.c;
import android.support.v7.widget.RecyclerView.t;

final class as {
    final a<t, a> Xu = new a();
    final e<t> Xv = new e();

    as() {
    }

    final void clear() {
        this.Xu.clear();
        e eVar = this.Xv;
        int i = eVar.fi;
        Object[] objArr = eVar.tD;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        eVar.fi = 0;
        eVar.tB = false;
    }

    final void b(t tVar, c cVar) {
        a aVar = (a) this.Xu.get(tVar);
        if (aVar == null) {
            aVar = a.hj();
            this.Xu.put(tVar, aVar);
        }
        aVar.Xw = cVar;
        aVar.flags |= 4;
    }

    final boolean C(t tVar) {
        a aVar = (a) this.Xu.get(tVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    final c c(t tVar, int i) {
        c cVar = null;
        int indexOfKey = this.Xu.indexOfKey(tVar);
        if (indexOfKey >= 0) {
            a aVar = (a) this.Xu.valueAt(indexOfKey);
            if (!(aVar == null || (aVar.flags & i) == 0)) {
                aVar.flags &= i ^ -1;
                if (i == 4) {
                    cVar = aVar.Xw;
                } else if (i == 8) {
                    cVar = aVar.Xx;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.flags & 12) == 0) {
                    this.Xu.removeAt(indexOfKey);
                    a.a(aVar);
                }
            }
        }
        return cVar;
    }

    final void a(long j, t tVar) {
        this.Xv.put(j, tVar);
    }

    final void c(t tVar, c cVar) {
        a aVar = (a) this.Xu.get(tVar);
        if (aVar == null) {
            aVar = a.hj();
            this.Xu.put(tVar, aVar);
        }
        aVar.Xx = cVar;
        aVar.flags |= 8;
    }

    final void D(t tVar) {
        a aVar = (a) this.Xu.get(tVar);
        if (aVar == null) {
            aVar = a.hj();
            this.Xu.put(tVar, aVar);
        }
        aVar.flags |= 1;
    }

    final void E(t tVar) {
        a aVar = (a) this.Xu.get(tVar);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    final void a(b bVar) {
        for (int size = this.Xu.size() - 1; size >= 0; size--) {
            t tVar = (t) this.Xu.keyAt(size);
            a aVar = (a) this.Xu.removeAt(size);
            if ((aVar.flags & 3) == 3) {
                bVar.i(tVar);
            } else if ((aVar.flags & 1) != 0) {
                if (aVar.Xw == null) {
                    bVar.i(tVar);
                } else {
                    bVar.a(tVar, aVar.Xw, aVar.Xx);
                }
            } else if ((aVar.flags & 14) == 14) {
                bVar.b(tVar, aVar.Xw, aVar.Xx);
            } else if ((aVar.flags & 12) == 12) {
                bVar.c(tVar, aVar.Xw, aVar.Xx);
            } else if ((aVar.flags & 4) != 0) {
                bVar.a(tVar, aVar.Xw, null);
            } else if ((aVar.flags & 8) != 0) {
                bVar.b(tVar, aVar.Xw, aVar.Xx);
            } else {
                int i = aVar.flags;
            }
            a.a(aVar);
        }
    }

    final void F(t tVar) {
        a aVar;
        for (int size = this.Xv.size() - 1; size >= 0; size--) {
            if (tVar == this.Xv.valueAt(size)) {
                e eVar = this.Xv;
                if (eVar.tD[size] != e.tA) {
                    eVar.tD[size] = e.tA;
                    eVar.tB = true;
                }
                aVar = (a) this.Xu.remove(tVar);
                if (aVar != null) {
                    a.a(aVar);
                }
            }
        }
        aVar = (a) this.Xu.remove(tVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }
}
