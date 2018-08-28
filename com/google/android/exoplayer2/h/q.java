package com.google.android.exoplayer2.h;

import com.google.android.exoplayer2.i.l;

public interface q extends f {
    public static final l<String> aBB = new 1();

    public static final class d extends c {
        public final String aBC;

        public d(String str, i iVar) {
            super("Invalid content type: " + str, iVar);
            this.aBC = str;
        }
    }
}
