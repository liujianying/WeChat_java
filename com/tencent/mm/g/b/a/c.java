package com.tencent.mm.g.b.a;

import com.tencent.mm.plugin.report.a;

public final class c extends a {
    public int cgm = 0;
    public int cgn = 0;
    public int cgo = 0;
    public String cgp;
    public String cgq;
    public String cgr;
    public String cgs;
    public String cgt;
    public String cgu;
    public String cgv;
    public String cgw;

    public final int getId() {
        return 15548;
    }

    public final String wE() {
        String str = ",";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.cgm);
        stringBuffer.append(str);
        stringBuffer.append(this.cgn);
        stringBuffer.append(str);
        stringBuffer.append(this.cgo);
        stringBuffer.append(str);
        stringBuffer.append(this.cgp);
        stringBuffer.append(str);
        stringBuffer.append(this.cgq);
        stringBuffer.append(str);
        stringBuffer.append(this.cgr);
        stringBuffer.append(str);
        stringBuffer.append(this.cgs);
        stringBuffer.append(str);
        stringBuffer.append(this.cgt);
        stringBuffer.append(str);
        stringBuffer.append(this.cgu);
        stringBuffer.append(str);
        stringBuffer.append(this.cgv);
        stringBuffer.append(str);
        stringBuffer.append(this.cgw);
        str = stringBuffer.toString();
        KD(str);
        return str;
    }

    public final String wF() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CgiCmd:").append(this.cgm);
        stringBuffer.append("\r\n");
        stringBuffer.append("ErrType:").append(this.cgn);
        stringBuffer.append("\r\n");
        stringBuffer.append("ErrCode:").append(this.cgo);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptKey:").append(this.cgp);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptUserinfo:").append(this.cgq);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptCellinfoLength:").append(this.cgr);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptCellinfo_01:").append(this.cgs);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptCellinfo_02:").append(this.cgt);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptCellinfo_03:").append(this.cgu);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptCellinfo_04:").append(this.cgv);
        stringBuffer.append("\r\n");
        stringBuffer.append("EncryptCellinfo_05:").append(this.cgw);
        return stringBuffer.toString();
    }
}
