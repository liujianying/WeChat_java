package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.compatible.e.m;

public final class a {
    public static final int ovJ;
    private static int ovW;

    static {
        int zj = m.zj();
        ovW = zj;
        ovJ = (zj & 1024) != 0 ? 16000 : 8000;
    }
}
