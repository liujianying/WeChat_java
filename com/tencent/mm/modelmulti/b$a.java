package com.tencent.mm.modelmulti;

public class b$a {
    final String dYN;
    final int dYO;
    final int dYP;
    final int dYQ;
    final int dYR;

    public b$a(String str, int i, int i2, int i3, int i4) {
        this.dYN = str;
        this.dYO = i;
        this.dYP = i2;
        this.dYQ = i3;
        this.dYR = i4;
    }

    public final boolean equals(Object obj) {
        if (hashCode() == obj.hashCode()) {
            return true;
        }
        if (!(obj instanceof b$a)) {
            return false;
        }
        b$a b_a = (b$a) obj;
        if (this.dYO == b_a.dYO && this.dYP == b_a.dYP && this.dYQ == b_a.dYQ && this.dYR == b_a.dYR && this.dYN.equals(b_a.dYN)) {
            return true;
        }
        return false;
    }

    public final String toString() {
        return "GetChatRoomMsgInfo chatroomId[" + this.dYN + "], filterSeq[" + this.dYO + "], msgSeq[" + this.dYP + "], needCount[" + this.dYQ + "], upDownFlag[" + this.dYR + "], hash[" + hashCode() + "]";
    }
}
