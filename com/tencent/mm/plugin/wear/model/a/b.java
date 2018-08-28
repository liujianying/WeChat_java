package com.tencent.mm.plugin.wear.model.a;

import android.net.Uri;
import com.google.android.gms.common.api.c;
import com.google.android.gms.wearable.Asset;
import java.util.HashSet;

public interface b {
    byte[] a(Asset asset);

    void bSt();

    c bSu();

    HashSet<String> bSv();

    boolean bSw();

    void bSx();

    void finish();

    boolean i(Uri uri);

    boolean isAvailable();

    a t(String str, byte[] bArr);

    a u(String str, byte[] bArr);
}
