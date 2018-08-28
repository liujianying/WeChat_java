package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class fq {
    private int a;
    private String b = "";
    private Socket c = null;
    private String d;
    private int e = -1;
    private int f = -1;
    private ep g;

    public void a() {
        SocketAddress inetSocketAddress;
        InetAddress inetAddress = null;
        fx.c("ConnectorImpl", "Thread:" + Thread.currentThread().getName() + " isDaemon:" + Thread.currentThread().isDaemon());
        long currentTimeMillis = System.currentTimeMillis();
        if (TextUtils.isEmpty(this.b)) {
            inetSocketAddress = new InetSocketAddress(this.g.a(), this.g.b());
            this.e = 0;
        } else {
            try {
                inetAddress = InetAddress.getByName(this.b);
            } catch (Exception e) {
                e.getClass().getSimpleName();
                this.d = "Dns InetAddress exception: domain" + this.b;
            }
            try {
                this.e = (int) (System.currentTimeMillis() - currentTimeMillis);
                inetSocketAddress = new InetSocketAddress(inetAddress.getHostAddress(), 14000);
            } catch (Exception e2) {
                this.d = fz.a(e2);
                return;
            }
        }
        Socket socket = new Socket();
        try {
            currentTimeMillis = System.currentTimeMillis();
            this.a = dx.a().b.a;
            socket.connect(inetSocketAddress, this.a);
            if (socket.isConnected() && !socket.isClosed()) {
                this.c = socket;
                this.f = (int) (System.currentTimeMillis() - currentTimeMillis);
            }
        } catch (Exception e22) {
            e22.getClass().getSimpleName();
            this.d = fz.a(e22);
            this.f = (int) (System.currentTimeMillis() - 0);
            this.c = null;
        }
        System.currentTimeMillis();
    }

    public void a(ep epVar) {
        this.g = epVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void b() {
        try {
            this.c.close();
        } catch (IOException e) {
        }
    }

    public void b(String str) {
        this.d = str;
    }

    public Socket c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }
}
