package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import android.text.style.ParagraphStyle;

public enum q {
    NONE("", "", "", "", false),
    NOTEUL("<wx-ul>", "</wx-ul>", "<wx-li>", "</wx-li>", true),
    NOTEOL("<wx-ol>", "</wx-ol>", "<wx-li>", "</wx-li>", true),
    NOTETODO("", "", "<wn-todo checked=\"1\" >", "</wn-todo>", true);
    
    public String qtj;
    public String qtk;
    public boolean qtl;
    public String qtm;
    public String qtn;
    public boolean qto;
    public boolean qtp;

    public static q a(ParagraphStyle paragraphStyle) {
        if (paragraphStyle instanceof d) {
            return NOTEUL;
        }
        if (paragraphStyle instanceof m) {
            return NOTEOL;
        }
        return paragraphStyle instanceof k ? NOTETODO : null;
    }

    private q(String str, String str2, String str3, String str4, boolean z) {
        this.qtp = false;
        this.qtj = str;
        this.qtk = str2;
        this.qtm = str3;
        this.qtn = str4;
        this.qtl = false;
        this.qto = z;
    }

    public final boolean caL() {
        return this == NOTEUL;
    }

    public final boolean caM() {
        return this == NOTEOL;
    }

    public final boolean caN() {
        return this == NOTETODO;
    }
}
