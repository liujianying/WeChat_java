package com.tencent.d.a.a;

import android.hardware.fingerprint.FingerprintManager.AuthenticationCallback;
import android.hardware.fingerprint.FingerprintManager.AuthenticationResult;
import android.hardware.fingerprint.FingerprintManager.CryptoObject;
import com.tencent.d.a.c.c;

class b$1 extends AuthenticationCallback {
    final /* synthetic */ b$a vla;

    b$1(b$a b_a) {
        this.vla = b_a;
    }

    public final void onAuthenticationError(int i, CharSequence charSequence) {
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationError", new Object[0]);
        this.vla.onAuthenticationError(i, charSequence);
    }

    public final void onAuthenticationHelp(int i, CharSequence charSequence) {
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationHelp", new Object[0]);
        this.vla.onAuthenticationHelp(i, charSequence);
    }

    public final void onAuthenticationSucceeded(AuthenticationResult authenticationResult) {
        b$c b_c;
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationSucceeded", new Object[0]);
        b$a b_a = this.vla;
        CryptoObject cryptoObject = authenticationResult.getCryptoObject();
        if (cryptoObject != null) {
            if (cryptoObject.getCipher() != null) {
                b_c = new b$c(cryptoObject.getCipher());
            } else if (cryptoObject.getSignature() != null) {
                b_c = new b$c(cryptoObject.getSignature());
            } else if (cryptoObject.getMac() != null) {
                b_c = new b$c(cryptoObject.getMac());
            }
            b_a.a(new b$b(b_c));
        }
        b_c = null;
        b_a.a(new b$b(b_c));
    }

    public final void onAuthenticationFailed() {
        c.d("Soter.FingerprintManagerCompatApi23", "hy: lowest level return onAuthenticationFailed", new Object[0]);
        this.vla.onAuthenticationFailed();
    }
}
