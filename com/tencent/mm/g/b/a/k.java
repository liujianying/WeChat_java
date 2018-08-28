package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;

public final class k extends a {
    public long cir = 0;
    public long cis = 0;
    public long cit = 0;
    public long ciu = 0;
    public long civ = 0;

    public final int getId() {
        return 15401;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cir);
        stringBuffer.append(str);
        stringBuffer.append(this.cis);
        stringBuffer.append(str);
        stringBuffer.append(this.cit);
        stringBuffer.append(str);
        stringBuffer.append(this.ciu);
        stringBuffer.append(str);
        stringBuffer.append(this.civ);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("AllPackageSize:").append(this.cir);
        stringBuffer.append("\r\n");
        stringBuffer.append("AllPackageClientStoragePercent:").append(this.cis);
        stringBuffer.append("\r\n");
        stringBuffer.append("ClientStorageFreePercent:").append(this.cit);
        stringBuffer.append("\r\n");
        stringBuffer.append("AbtestStatus:").append(this.ciu);
        stringBuffer.append("\r\n");
        stringBuffer.append("WeappCountThatHasPackage:").append(this.civ);
        return stringBuffer.toString();
    }
}
