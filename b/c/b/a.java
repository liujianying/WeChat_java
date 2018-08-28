package b.c.b;

import b.e.c;
import java.io.Serializable;

public abstract class a implements b.e.a, Serializable {
    public static final Object vGC = a.cJK();
    private transient b.e.a vGA;
    protected final Object vGB;

    protected abstract b.e.a cJG();

    public a() {
        this(vGC);
    }

    private a(Object obj) {
        this.vGB = obj;
    }

    public final Object cJH() {
        return this.vGB;
    }

    public final b.e.a cJI() {
        b.e.a aVar = this.vGA;
        if (aVar != null) {
            return aVar;
        }
        aVar = cJG();
        this.vGA = aVar;
        return aVar;
    }

    public c cJJ() {
        throw new AbstractMethodError();
    }

    public String getName() {
        throw new AbstractMethodError();
    }

    public String cmO() {
        throw new AbstractMethodError();
    }
}
