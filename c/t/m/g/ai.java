package c.t.m.g;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

class ai extends SSLSocketFactory {
    public boolean a = false;
    private String b;

    public ai(String str) {
        ai.class.getSimpleName();
        this.b = str;
    }

    public Socket createSocket() {
        return null;
    }

    public Socket createSocket(String str, int i) {
        return null;
    }

    public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i) {
        return null;
    }

    public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) {
        return null;
    }

    public Socket createSocket(Socket socket, String str, int i, boolean z) {
        if (TextUtils.isEmpty(this.b)) {
            throw new IOException("Halley set empty bizHost");
        }
        new StringBuilder("customized createSocket. host: ").append(this.b);
        try {
            if (VERSION.SDK_INT < 17) {
                SSLSocket sSLSocket = (SSLSocket) ((SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(m.a()))).createSocket(socket, this.b, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                sSLSocket.getClass().getMethod("setHostname", new Class[]{String.class}).invoke(sSLSocket, new Object[]{this.b});
                sSLSocket.startHandshake();
                return sSLSocket;
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getInsecure(10000, new SSLSessionCache(m.a()));
            Socket socket2 = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.b, i, z);
            sSLCertificateSocketFactory.setUseSessionTickets(socket2, true);
            socket2.setEnabledProtocols(socket2.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(socket2, this.b);
            socket2.startHandshake();
            return socket2;
        } catch (Throwable th) {
            this.a = true;
            IOException iOException = new IOException("HalleySNI exception: " + th);
        }
    }

    public boolean equals(Object obj) {
        if (TextUtils.isEmpty(this.b) || !(obj instanceof ai)) {
            return false;
        }
        CharSequence charSequence = ((ai) obj).b;
        return !TextUtils.isEmpty(charSequence) ? this.b.equals(charSequence) : false;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}
