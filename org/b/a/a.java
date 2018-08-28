package org.b.a;

import java.io.OutputStream;
import org.b.b.b;
import org.b.d.h;
import org.b.g.d;

public final class a {
    public String scope;
    public String vKl;
    public String vKm;
    public String vKn = "oob";
    public org.b.a.a.a vKo;
    public h vKp = h.vKE;
    public OutputStream vKq = null;

    public static org.b.a.a.a Y(Class<? extends org.b.a.a.a> cls) {
        d.j(cls, "Api class cannot be null");
        try {
            return (org.b.a.a.a) cls.newInstance();
        } catch (Exception e) {
            throw new b("Error while creating the Api object", e);
        }
    }
}
