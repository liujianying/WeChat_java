package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.Format;
import java.util.Comparator;

final class a$a implements Comparator<Format> {
    private a$a() {
    }

    /* synthetic */ a$a(byte b) {
        this();
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((Format) obj2).bitrate - ((Format) obj).bitrate;
    }
}
