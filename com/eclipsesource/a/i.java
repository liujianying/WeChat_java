package com.eclipsesource.a;

import java.io.Writer;

class i {
    private static final char[] abT = new char[]{'\\', '\"'};
    private static final char[] abU = new char[]{'\\', '\\'};
    private static final char[] abV = new char[]{'\\', 'n'};
    private static final char[] abW = new char[]{'\\', 'r'};
    private static final char[] abX = new char[]{'\\', 't'};
    private static final char[] abY = new char[]{'\\', 'u', '2', '0', '2', '8'};
    private static final char[] abZ = new char[]{'\\', 'u', '2', '0', '2', '9'};
    private static final char[] aca = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    protected final Writer acb;

    i(Writer writer) {
        this.acb = writer;
    }

    protected final void Z(String str) {
        this.acb.write(str);
    }

    protected final void aa(String str) {
        this.acb.write(str);
    }

    protected final void writeString(String str) {
        this.acb.write(34);
        ac(str);
        this.acb.write(34);
    }

    protected void if() {
        this.acb.write(91);
    }

    protected void ig() {
        this.acb.write(93);
    }

    protected void ih() {
        this.acb.write(44);
    }

    protected void ii() {
        this.acb.write(123);
    }

    protected void ij() {
        this.acb.write(125);
    }

    protected final void ab(String str) {
        this.acb.write(34);
        ac(str);
        this.acb.write(34);
    }

    protected void ik() {
        this.acb.write(58);
    }

    protected void il() {
        this.acb.write(44);
    }

    private void ac(String str) {
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            char[] cArr = charAt > '\\' ? (charAt < 8232 || charAt > 8233) ? null : charAt == 8232 ? abY : abZ : charAt == '\\' ? abU : charAt > '\"' ? null : charAt == '\"' ? abT : charAt > 31 ? null : charAt == 10 ? abV : charAt == 13 ? abW : charAt == 9 ? abX : new char[]{'\\', 'u', '0', '0', aca[(charAt >> 4) & 15], aca[charAt & 15]};
            if (cArr != null) {
                this.acb.write(str, i, i2 - i);
                this.acb.write(cArr);
                i = i2 + 1;
            }
        }
        this.acb.write(str, i, length - i);
    }
}
