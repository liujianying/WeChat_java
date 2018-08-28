package com.tencent.d.a.a;

import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class a$d {
    final Signature vkX;
    final Cipher vkY;
    final Mac vkZ;

    public a$d(Signature signature) {
        this.vkX = signature;
        this.vkY = null;
        this.vkZ = null;
    }

    public a$d(Cipher cipher) {
        this.vkY = cipher;
        this.vkX = null;
        this.vkZ = null;
    }

    public a$d(Mac mac) {
        this.vkZ = mac;
        this.vkY = null;
        this.vkX = null;
    }
}
