package com.tencent.mm.plugin.cdndownloader.a;

import android.os.IInterface;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskInfo;
import com.tencent.mm.plugin.cdndownloader.ipc.CDNTaskState;

public interface a extends IInterface {
    int a(CDNTaskInfo cDNTaskInfo);

    void a(b bVar);

    void aAg();

    void aAh();

    void aAi();

    int b(CDNTaskInfo cDNTaskInfo);

    void b(b bVar);

    void od(int i);

    boolean yj(String str);

    boolean yk(String str);

    CDNTaskState yl(String str);
}
