package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a.b;
import com.google.android.gms.common.api.k.a;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public interface c {
    ConnectionResult a(TimeUnit timeUnit);

    <A extends b, R extends g, T extends a<R, A>> T a(T t);

    void a(b bVar);

    void a(c cVar);

    void a(String str, PrintWriter printWriter);

    <A extends b, T extends a<? extends g, A>> T b(T t);

    void b(b bVar);

    void b(c cVar);

    void connect();

    void disconnect();

    Looper getLooper();

    boolean isConnected();

    boolean isConnecting();
}
