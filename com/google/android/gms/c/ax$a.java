package com.google.android.gms.c;

import java.io.IOException;

public class ax$a extends IOException {
    ax$a(int i, int i2) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
    }
}
