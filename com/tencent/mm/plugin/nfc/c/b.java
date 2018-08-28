package com.tencent.mm.plugin.nfc.c;

import android.nfc.Tag;

public abstract class b {
    public Tag lFg;
    public byte[] lFh = null;

    public boolean a(Tag tag) {
        this.lFg = tag;
        if (tag != null) {
            this.lFh = tag.getId();
        }
        return true;
    }
}
