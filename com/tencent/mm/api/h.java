package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.protocal.c.biy;
import com.tencent.mm.protocal.c.bja;
import java.util.ArrayList;

public interface h extends a {
    void a(Intent intent, biy biy, int i);

    void a(Intent intent, bja bja, int i);

    boolean cB(String str);

    ArrayList<String> cC(String str);
}
