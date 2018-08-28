package com.tencent.smtt.utils;

import java.io.InputStream;
import java.util.zip.ZipEntry;

final class k implements j$b {
    final /* synthetic */ String a;

    k(String str) {
        this.a = str;
    }

    public final boolean a(InputStream inputStream, ZipEntry zipEntry, String str) {
        try {
            return j.a(inputStream, zipEntry, this.a, str);
        } catch (Throwable e) {
            throw new Exception("copyFileIfChanged Exception", e);
        }
    }
}
