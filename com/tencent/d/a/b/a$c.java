package com.tencent.d.a.b;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Date;
import javax.security.auth.x500.X500Principal;

class a$c extends a {
    private final String vld;
    private int vle;
    private int vlf = -1;
    private AlgorithmParameterSpec vlg;
    private X500Principal vlh;
    private BigInteger vli;
    private Date vlj;
    private Date vlk;
    private Date vll;
    private Date vlm;
    private Date vln;
    private String[] vlo;
    private String[] vlp;
    private String[] vlq;
    private String[] vlr;
    private boolean vls = true;
    private boolean vlt;
    private int vlu = -1;

    public a$c(String str) {
        if (str == null) {
            throw new NullPointerException("keystoreAlias == null");
        } else if (str.isEmpty()) {
            throw new IllegalArgumentException("keystoreAlias must not be empty");
        } else {
            this.vld = str;
            this.vle = 4;
        }
    }

    public final a M(String... strArr) {
        this.vlo = O(strArr);
        return this;
    }

    public final a N(String... strArr) {
        this.vlq = O(strArr);
        return this;
    }

    public final a cFI() {
        this.vlt = true;
        return this;
    }

    public final AlgorithmParameterSpec cFH() {
        return (AlgorithmParameterSpec) Class.forName("android.security.keystore.KeyGenParameterSpec").getConstructor(new Class[]{String.class, Integer.TYPE, AlgorithmParameterSpec.class, X500Principal.class, BigInteger.class, Date.class, Date.class, Date.class, Date.class, Date.class, Integer.TYPE, String[].class, String[].class, String[].class, String[].class, Boolean.TYPE, Boolean.TYPE, Integer.TYPE}).newInstance(new Object[]{this.vld, Integer.valueOf(this.vlf), this.vlg, this.vlh, this.vli, this.vlj, this.vlk, this.vll, this.vlm, this.vln, Integer.valueOf(this.vle), this.vlo, this.vlp, this.vlq, this.vlr, Boolean.valueOf(this.vls), Boolean.valueOf(this.vlt), Integer.valueOf(this.vlu)});
    }
}
