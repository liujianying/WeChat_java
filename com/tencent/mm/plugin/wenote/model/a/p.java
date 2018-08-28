package com.tencent.mm.plugin.wenote.model.a;

import java.io.Serializable;

public final class p implements Serializable {
    public boolean qpf = false;
    public long qpg = -1;
    public long qph = -1;
    public boolean qpi = false;
    public String qpj = "";
    public String qpk = "";
    public int qpl = 0;
    public int qpm = 0;

    public final String bZi() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("topIsOpenFromSession=").append(this.qpf).append(" topLocalId=").append(this.qpg).append(" topMsgId=").append(this.qph).append(" topTitle=").append(this.qpj).append(" topNoteXml=").append(this.qpk).append(" topLastPosition=").append(this.qpl).append(" topLastOffset=").append(this.qpm);
        return stringBuilder.toString();
    }
}
