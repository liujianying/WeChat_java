package com.tencent.mm.g.b.a;

public final class a extends com.tencent.mm.plugin.report.a {
    public String cgb = "";
    public String cgc = "";
    public int cgd = 0;

    public final int getId() {
        return 15459;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cgb);
        stringBuffer.append(str);
        stringBuffer.append(this.cgc);
        stringBuffer.append(str);
        stringBuffer.append(this.cgd);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ChatroomName:").append(this.cgb);
        stringBuffer.append("\r\n");
        stringBuffer.append("ExptScore:").append(this.cgc);
        stringBuffer.append("\r\n");
        stringBuffer.append("ExptFlag:").append(this.cgd);
        return stringBuffer.toString();
    }
}
