package com.tencent.tinker.lib.service;

import java.io.Serializable;

public final class a implements Serializable {
    public boolean bLW;
    public long grC;
    public Throwable vhq;
    public String vso;
    public String vsp;

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\nPatchResult: \n");
        stringBuffer.append("isSuccess:" + this.bLW + "\n");
        stringBuffer.append("rawPatchFilePath:" + this.vso + "\n");
        stringBuffer.append("costTime:" + this.grC + "\n");
        if (this.vsp != null) {
            stringBuffer.append("patchVersion:" + this.vsp + "\n");
        }
        if (this.vhq != null) {
            stringBuffer.append("Throwable:" + this.vhq.getMessage() + "\n");
        }
        return stringBuffer.toString();
    }
}
