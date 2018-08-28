package org.b.f;

import java.util.Random;

public final class d implements c {
    private a vKU = new a();

    public final String getNonce() {
        return String.valueOf(cKF().longValue() + ((long) Integer.valueOf(new Random().nextInt()).intValue()));
    }

    public final String cKE() {
        return String.valueOf(cKF());
    }

    private static Long cKF() {
        return Long.valueOf(Long.valueOf(System.currentTimeMillis()).longValue() / 1000);
    }
}
