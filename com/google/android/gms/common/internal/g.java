package com.google.android.gms.common.internal;

import java.util.Arrays;

public abstract class g {
    public static final g aNA = new 9();
    public static final g aNB = new 10();
    public static final g aNC = a(0, 31).a(a(127, 159));
    public static final g aND = a(0, ' ').a(a(127, 160)).a(d(173)).a(a(1536, 1539)).a(j("۝܏ ឴឵᠎")).a(a(8192, 8207)).a(a(8232, 8239)).a(a(8287, 8292)).a(a(8298, 8303)).a(d(12288)).a(a(55296, 63743)).a(j("﻿￹￺￻"));
    public static final g aNE = a(0, 1273).a(d(1470)).a(a(1488, 1514)).a(d(1523)).a(d(1524)).a(a(1536, 1791)).a(a(1872, 1919)).a(a(3584, 3711)).a(a(7680, 8367)).a(a(8448, 8506)).a(a(64336, 65023)).a(a(65136, 65279)).a(a(65377, 65500));
    public static final g aNF = new g() {
        public final g a(g gVar) {
            w.ah(gVar);
            return this;
        }

        public final boolean e(char c) {
            return true;
        }

        public final boolean k(CharSequence charSequence) {
            w.ah(charSequence);
            return true;
        }
    };
    public static final g aNG = new 2();
    public static final g aNs = j("\t\n\u000b\f\r     　 ᠎ ").a(a(8192, 8202));
    public static final g aNt = j("\t\n\u000b\f\r     　").a(a(8192, 8198)).a(a(8200, 8202));
    public static final g aNu = a(0, 127);
    public static final g aNv;
    public static final g aNw = a(9, 13).a(a(28, ' ')).a(d(5760)).a(d(6158)).a(a(8192, 8198)).a(a(8200, 8203)).a(a(8232, 8233)).a(d(8287)).a(d(12288));
    public static final g aNx = new 1();
    public static final g aNy = new g() {
        public final boolean e(char c) {
            return Character.isLetter(c);
        }
    };
    public static final g aNz = new 8();

    static {
        g a = a('0', '9');
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            a = a.a(a(c, (char) (c + 9)));
        }
        aNv = a;
    }

    private static g a(final char c, final char c2) {
        w.au(c2 >= c);
        return new g() {
            public final boolean e(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    private static g d(char c) {
        return new 3(c);
    }

    private static g j(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return aNG;
            case 1:
                return d(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new g() {
                    public final boolean e(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] toCharArray = charSequence.toString().toCharArray();
                Arrays.sort(toCharArray);
                return new g() {
                    public final boolean e(char c) {
                        return Arrays.binarySearch(toCharArray, c) >= 0;
                    }
                };
        }
    }

    public g a(g gVar) {
        return new a(Arrays.asList(new g[]{this, (g) w.ah(gVar)}));
    }

    public abstract boolean e(char c);

    public boolean k(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!e(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
