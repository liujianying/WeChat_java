package com.tencent.mm.plugin.appbrand.jsapi.file;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

interface e {
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    String i(ByteBuffer byteBuffer);

    ByteBuffer ty(String str);
}
