package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Map;

public final class n$a {
    public static int oLE = 1;
    public static int oLF = 2;
    public static int oLG = 3;
    public static int oLH = 4;
    public static int oLI = 5;
    public static int oLJ = 0;
    public static int oLK = 1;
    public int oLB;
    public long oLC;
    public int oLD;
    public int status;

    public final boolean bKi() {
        return this.oLD == oLJ;
    }

    public final boolean bKj() {
        return this.status == oLI;
    }

    public final boolean parse(String str) {
        this.oLD = oLJ;
        try {
            Map z = bl.z(str, "voipinvitemsg");
            if (z == null) {
                return false;
            }
            if (z.get(".voipinvitemsg.roomid") != null) {
                this.oLB = bi.getInt((String) z.get(".voipinvitemsg.roomid"), 0);
            }
            if (z.get(".voipinvitemsg.key") != null) {
                this.oLC = bi.getLong((String) z.get(".voipinvitemsg.key"), 0);
            }
            if (z.get(".voipinvitemsg.status") != null) {
                this.status = bi.getInt((String) z.get(".voipinvitemsg.status"), 0);
            }
            if (z.get(".voipinvitemsg.invitetype") != null) {
                this.oLD = bi.getInt((String) z.get(".voipinvitemsg.invitetype"), 0);
            }
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoipExtension", e, "", new Object[0]);
            x.e("MicroMsg.VoipExtension", "parse voip message error: %s", new Object[]{e.getMessage()});
            return false;
        }
    }
}
