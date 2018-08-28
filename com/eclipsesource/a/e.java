package com.eclipsesource.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class e extends h implements Iterable<b> {
    public final List<String> abF = new ArrayList();
    public transient a abG = new a();
    public final List<h> abz = new ArrayList();

    public final e a(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (hVar == null) {
            throw new NullPointerException("value is null");
        } else {
            this.abG.h(str, this.abF.size());
            this.abF.add(str);
            this.abz.add(hVar);
            return this;
        }
    }

    public final e g(String str, int i) {
        b(str, a.bX(i));
        return this;
    }

    public final e b(String str, h hVar) {
        if (str == null) {
            throw new NullPointerException("name is null");
        } else if (hVar == null) {
            throw new NullPointerException("value is null");
        } else {
            int indexOf = indexOf(str);
            if (indexOf != -1) {
                this.abz.set(indexOf, hVar);
            } else {
                this.abG.h(str, this.abF.size());
                this.abF.add(str);
                this.abz.add(hVar);
            }
            return this;
        }
    }

    public final h W(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        int indexOf = indexOf(str);
        return indexOf != -1 ? (h) this.abz.get(indexOf) : null;
    }

    public final Iterator<b> iterator() {
        return new 1(this, this.abF.iterator(), this.abz.iterator());
    }

    final void a(i iVar) {
        iVar.ii();
        Iterator it = this.abz.iterator();
        Object obj = 1;
        for (String ab : this.abF) {
            if (obj == null) {
                iVar.il();
            }
            iVar.ab(ab);
            iVar.ik();
            ((h) it.next()).a(iVar);
            obj = null;
        }
        iVar.ij();
    }

    public final boolean isObject() {
        return true;
    }

    public final e hV() {
        return this;
    }

    public final int hashCode() {
        return ((this.abF.hashCode() + 31) * 31) + this.abz.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        e eVar = (e) obj;
        if (this.abF.equals(eVar.abF) && this.abz.equals(eVar.abz)) {
            return true;
        }
        return false;
    }

    public final int indexOf(String str) {
        a aVar = this.abG;
        int i = (aVar.abK[aVar.U(str)] & 255) - 1;
        return (i == -1 || !str.equals(this.abF.get(i))) ? this.abF.lastIndexOf(str) : i;
    }
}
