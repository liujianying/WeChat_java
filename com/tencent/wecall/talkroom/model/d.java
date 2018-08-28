package com.tencent.wecall.talkroom.model;

import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public final class d {
    private String oeK;
    av vxf;
    private aw vxg;

    public d(av avVar) {
        a(avVar);
    }

    public d(av avVar, aw awVar) {
        a(avVar);
        if (awVar == null) {
            c.x("tagorewang:TalkRoomMember", new Object[]{"set null profile"});
            return;
        }
        this.vxg = awVar;
    }

    public final void a(av avVar) {
        if (avVar == null) {
            c.x("tagorewang:TalkRoomMember", new Object[]{"set null info"});
            return;
        }
        this.vxf = avVar;
    }

    public final String cHI() {
        if (this.vxf != null) {
            return this.vxf.vez;
        }
        return "";
    }

    public final String getDisplayName() {
        try {
            String str = this.oeK;
            if (str == null || str.trim().length() == 0) {
                return str;
            }
            char[] toCharArray = str.trim().toCharArray();
            int i = 0;
            for (char c : toCharArray) {
                i = c >= 161 ? i + 2 : i + 1;
            }
            if (i <= 10) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                i = toCharArray[i2] >= 161 ? i + 2 : i + 1;
                if (i + 1 > 10) {
                    break;
                }
                stringBuilder.append(toCharArray[i2]);
            }
            stringBuilder.append(8230);
            return stringBuilder.toString();
        } catch (Exception e) {
            c.x("tagorewang:TalkRoomMember", new Object[]{"getDisplayName err: ", e});
            return this.oeK;
        }
    }

    public final int getState() {
        if (this.vxf == null) {
            return 0;
        }
        return this.vxf.status;
    }

    public final int cHJ() {
        if (this.vxf == null) {
            return -1;
        }
        return this.vxf.kpU;
    }

    public final String toString() {
        int i = 0;
        if (this.vxf != null) {
            i = this.vxf.qXJ;
        } else if (this.vxg != null) {
            i = this.vxg.qXJ;
        }
        if (this.vxf == null || this.vxg == null) {
            return "invlaid TalkRoomMember which uuid is " + i;
        }
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        av avVar = this.vxf;
        if (avVar == null) {
            str = "null";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(avVar.qXJ);
            stringBuilder.append(" openClientId:").append(avVar.vfv);
            stringBuilder.append(" invite uuid: ").append(avVar.vfr);
            stringBuilder.append(" member id:").append(avVar.kpU);
            stringBuilder.append(" status: ").append(avVar.status);
            stringBuilder.append(" reason: ").append(avVar.aAk);
            str = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(str).append(" ");
        aw awVar = this.vxg;
        if (awVar == null) {
            str = "null";
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(awVar.qXJ);
            stringBuilder3.append(" user name: ").append(awVar.username);
            stringBuilder3.append(" head url: ").append(awVar.mpV);
            str = stringBuilder3.toString();
        }
        stringBuilder.append(str);
        return stringBuilder2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        return g.equals(cHI(), ((d) obj).cHI());
    }

    public final int hashCode() {
        String cHI = cHI();
        return cHI == null ? 0 : cHI.hashCode();
    }

    public final boolean cHK() {
        return g.equals(a.cEG(), cHI());
    }
}
