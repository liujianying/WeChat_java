package org.b.d;

import java.io.OutputStream;

public final class a {
    public final String scope;
    public final String vKl;
    public final String vKm;
    public final String vKn;
    public final h vKp;
    private final OutputStream vKq;

    public a(String str, String str2, String str3, h hVar, String str4, OutputStream outputStream) {
        this.vKl = str;
        this.vKm = str2;
        this.vKn = str3;
        this.vKp = hVar;
        this.scope = str4;
        this.vKq = outputStream;
    }

    public final void sL(String str) {
        if (this.vKq != null) {
            try {
                this.vKq.write(new StringBuilder(String.valueOf(str)).append("\n").toString().getBytes("UTF8"));
            } catch (Throwable e) {
                throw new RuntimeException("there were problems while writting to the debug stream", e);
            }
        }
    }
}
