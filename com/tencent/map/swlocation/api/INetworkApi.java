package com.tencent.map.swlocation.api;

import com.d.a.a.q;

public interface INetworkApi extends q {
    @Deprecated
    byte[] httpRequest(String str, byte[] bArr);

    byte[] httpRequest(byte[] bArr);
}
