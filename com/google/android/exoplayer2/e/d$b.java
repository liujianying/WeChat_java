package com.google.android.exoplayer2.e;

public class d$b extends Exception {
    /* synthetic */ d$b(Throwable th, byte b) {
        this(th);
    }

    private d$b(Throwable th) {
        super("Failed to query underlying media codecs", th);
    }
}
