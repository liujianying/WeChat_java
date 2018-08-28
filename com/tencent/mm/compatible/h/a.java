package com.tencent.mm.compatible.h;

import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public int bJL;
    public String dfX;
    public long dfY;
    public int dfZ;

    public a() {
        this.dfX = null;
        this.dfY = -1;
        this.dfZ = -1;
        this.bJL = -1;
        this.dfX = null;
        this.dfY = -1;
        this.dfZ = -1;
        this.bJL = -1;
    }

    public final String zW() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.dfX);
        stringBuffer.append(",");
        stringBuffer.append(this.dfY);
        stringBuffer.append(",");
        stringBuffer.append(this.dfZ);
        stringBuffer.append(",");
        stringBuffer.append(this.bJL);
        x.d("MicroMsg.AudioRecorderInfo", " getStatInfo " + stringBuffer.toString());
        return stringBuffer.toString();
    }
}
