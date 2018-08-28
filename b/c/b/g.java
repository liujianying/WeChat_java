package b.c.b;

import b.e.a;
import b.e.d;

public abstract class g extends a implements d {
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return obj instanceof d ? obj.equals(cJI()) : false;
        } else {
            g gVar = (g) obj;
            if (cJJ().equals(gVar.cJJ()) && getName().equals(gVar.getName()) && cmO().equals(gVar.cmO()) && e.i(cJH(), gVar.cJH())) {
                return true;
            }
            return false;
        }
    }

    public int hashCode() {
        return (((cJJ().hashCode() * 31) + getName().hashCode()) * 31) + cmO().hashCode();
    }

    public String toString() {
        a cJI = cJI();
        if (cJI != this) {
            return cJI.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }
}
