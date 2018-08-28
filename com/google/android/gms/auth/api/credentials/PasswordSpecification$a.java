package com.google.android.gms.auth.api.credentials;

import android.text.TextUtils;
import com.google.android.gms.auth.api.credentials.PasswordSpecification.b;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PasswordSpecification$a {
    private final List<String> aIV = new ArrayList();
    private final List<Integer> aIW = new ArrayList();
    private int aIX = 12;
    private int aIY = 16;
    private final TreeSet<Character> aJb = new TreeSet();

    private static TreeSet<Character> n(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new b(str2 + " cannot be null or empty");
        }
        TreeSet<Character> treeSet = new TreeSet();
        for (char c : str.toCharArray()) {
            if (PasswordSpecification.dh(c)) {
                throw new b(str2 + " must only contain ASCII printable characters");
            }
            treeSet.add(Character.valueOf(c));
        }
        return treeSet;
    }

    public final PasswordSpecification$a bb(String str) {
        this.aJb.addAll(n(str, "allowedChars"));
        return this;
    }

    public final PasswordSpecification$a bc(String str) {
        this.aIV.add(PasswordSpecification.b(n(str, "requiredChars")));
        this.aIW.add(Integer.valueOf(1));
        return this;
    }

    public final PasswordSpecification$a on() {
        this.aIX = 12;
        this.aIY = 16;
        return this;
    }

    public final PasswordSpecification oo() {
        if (this.aJb.isEmpty()) {
            throw new b("no allowed characters specified");
        }
        int i = 0;
        for (Integer intValue : this.aIW) {
            i = intValue.intValue() + i;
        }
        if (i > this.aIY) {
            throw new b("required character count cannot be greater than the max password size");
        }
        boolean[] zArr = new boolean[95];
        for (String toCharArray : this.aIV) {
            for (char c : toCharArray.toCharArray()) {
                if (zArr[c - 32]) {
                    throw new b("character " + c + " occurs in more than one required character set");
                }
                zArr[c - 32] = true;
            }
        }
        return new PasswordSpecification(1, PasswordSpecification.b(this.aJb), this.aIV, this.aIW, this.aIX, this.aIY);
    }
}
