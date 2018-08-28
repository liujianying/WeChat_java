package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.q.h;
import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public interface l {
    j a(String str, FileStructStat fileStructStat);

    j a(String str, h<ByteBuffer> hVar);

    j a(String str, File file, boolean z);

    j a(String str, InputStream inputStream, boolean z);

    j b(String str, h<List<h>> hVar);

    boolean bV(String str);

    void initialize();

    j ra(String str);

    File rb(String str);

    void release();

    j rf(String str);

    j rg(String str);

    j rh(String str);

    j ri(String str);
}
