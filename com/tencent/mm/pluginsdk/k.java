package com.tencent.mm.pluginsdk;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.pluginsdk.wallet.j;
import java.util.Map;

public interface k extends a {
    int a(c cVar, boolean z);

    void a(lg lgVar, int i);

    void a(lg lgVar, int i, String str);

    boolean a(boolean z, boolean z2, Bundle bundle);

    boolean aNa();

    boolean aNb();

    boolean aNc();

    void aNe();

    j aNg();

    boolean aNh();

    boolean aNi();

    void aNj();

    boolean aNl();

    boolean aNm();

    void aNn();

    void aNo();

    void aNp();

    Map<String, String> aNq();

    com.tencent.mm.pluginsdk.wallet.k aNr();

    Map<String, String> aNs();

    boolean aNt();

    void dh(Context context);

    void di(Context context);

    void eZ(boolean z);

    int type();
}
