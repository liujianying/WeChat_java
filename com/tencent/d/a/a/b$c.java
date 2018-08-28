package com.tencent.d.a.a;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class b$c {
    final Signature vkX;
    final Cipher vkY;
    final Mac vkZ;

    public b$c(Signature signature) {
        this.vkX = signature;
        this.vkY = null;
        this.vkZ = null;
    }

    public b$c(Cipher cipher) {
        this.vkY = cipher;
        this.vkX = null;
        this.vkZ = null;
    }

    public b$c(Mac mac) {
        this.vkZ = mac;
        this.vkY = null;
        this.vkX = null;
    }
}
