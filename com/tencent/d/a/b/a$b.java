package com.tencent.d.a.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.security.keystore.KeyGenParameterSpec.Builder;
import java.security.spec.AlgorithmParameterSpec;

@TargetApi(23)
class a$b extends a {
    private Builder vlc = null;

    public a$b(String str) {
        this.vlc = new Builder(str, 4);
    }

    public final AlgorithmParameterSpec cFH() {
        return this.vlc.build();
    }

    @SuppressLint({"WrongConstant"})
    public final a M(String... strArr) {
        this.vlc.setDigests(strArr);
        return this;
    }

    @SuppressLint({"WrongConstant"})
    public final a N(String... strArr) {
        this.vlc.setSignaturePaddings(strArr);
        return this;
    }

    public final a cFI() {
        this.vlc.setUserAuthenticationRequired(true);
        return this;
    }
}
