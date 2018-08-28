package com.tencent.mm.network;

import com.tencent.mm.network.a.b;
import com.tencent.mm.protocal.x;
import java.util.List;

public interface e {
    boolean Lh();

    c Lr();

    i Ls();

    void Lt();

    void Lu();

    int a(r rVar, l lVar);

    int a(String str, boolean z, List<String> list);

    void a(int i, String str, int i2, boolean z);

    void a(b bVar);

    void a(h hVar);

    void a(o oVar);

    void a(x xVar);

    void a(boolean z, String str, String str2, int[] iArr, int[] iArr2, int i, int i2, String str3, String str4);

    void bC(boolean z);

    void bD(boolean z);

    void bE(boolean z);

    void bF(boolean z);

    void cancel(int i);

    int getHostByName(String str, List<String> list);

    String[] getIPsString(boolean z);

    String getIspId();

    String getNetworkServerIp();

    void keepSignalling();

    void kg(String str);

    void kh(String str);

    void reportFailIp(String str);

    void reset();

    void setHostInfo(String[] strArr, String[] strArr2, int[] iArr);

    void setSignallingStrategy(long j, long j2);

    void stopSignalling();
}
