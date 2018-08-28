package com.tencent.mm.model;

import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.storage.bd;
import java.util.List;

public interface ao {
    void B(List<bd> list);

    void a(int i, String str, String str2, String str3, String str4, Bundle bundle);

    void a(bd bdVar);

    Looper getLooper();
}
