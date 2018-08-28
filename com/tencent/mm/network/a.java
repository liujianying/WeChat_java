package com.tencent.mm.network;

import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.network.d.a implements c {
    byte[] ccH;
    private byte[] erT;
    private a erU = null;
    byte[] erV;
    String erW;
    private Map<String, byte[]> erX = new HashMap();
    private boolean foreground = false;
    private int uin;
    String username;

    public a(a aVar) {
        this.erU = aVar;
        Uv();
    }

    public final void reset() {
        x.i("MicroMsg.AccInfo", "reset accinfo");
        this.username = "";
        this.erT = null;
        Uv();
        this.uin = 0;
    }

    private void Uv() {
        this.ccH = bi.WP(aw.Ib().getString("server_id", ""));
    }

    public final void setUsername(String str) {
        this.username = str;
    }

    public final void x(byte[] bArr, int i) {
        x.i("MicroMsg.AccInfo", "summerauth update session info: session:%s, uin:%d -> %d stack:[%s]", new Object[]{bi.Xf(bi.bB(bArr)), Integer.valueOf(this.uin), Integer.valueOf(i), bi.cjd()});
        this.erT = bArr;
        this.uin = i;
        if (this.erU != null) {
            Ln();
        }
    }

    public final void M(byte[] bArr) {
        this.ccH = bArr;
    }

    public final void N(byte[] bArr) {
        this.erV = bArr;
    }

    public final byte[] DE() {
        return this.erT;
    }

    public final byte[] Lo() {
        return this.erV;
    }

    public final byte[] Lm() {
        return this.ccH;
    }

    public final String getUsername() {
        return this.username;
    }

    public final int Df() {
        return this.uin;
    }

    public final boolean Ln() {
        return this.erT != null && this.erT.length > 0;
    }

    public final String toString() {
        return ((((("AccInfo:\n" + "|-uin     =" + Df() + "\n") + "|-user    =" + getUsername() + "\n") + "|-wxuser  =" + LM() + "\n") + "|-session =" + bi.bB(DE()) + "\n") + "|-ecdhkey =" + bi.bB(Lo()) + "\n") + "`-cookie  =" + bi.bB(Lm());
    }

    public final void ox(String str) {
        this.erW = str;
    }

    public final String LM() {
        return this.erW;
    }

    public final void h(String str, byte[] bArr) {
        this.erX.put(str, bArr);
    }

    public final byte[] kf(String str) {
        return (byte[]) this.erX.get(str);
    }

    public final boolean Lp() {
        return this.foreground;
    }

    public final void bB(boolean z) {
        this.foreground = z;
        x.i("MicroMsg.AccInfo", "somr accinfo setForeground :%b", new Object[]{Boolean.valueOf(this.foreground)});
    }

    private void clear() {
        this.username = null;
        this.erT = null;
        this.ccH = null;
        this.uin = 0;
        this.erV = null;
        this.erW = null;
    }

    private String Uw() {
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4096);
            allocate.put(this.erT).put(this.erV).put(this.ccH).putInt(this.uin).put(this.erW.getBytes()).put(this.username.getBytes());
            return g.u(allocate.array());
        } catch (Exception e) {
            return "";
        }
    }

    public final byte[] Lq() {
        long VF = bi.VF();
        int i = bi.oW(this.username) ? 0 : bi.bC(this.erT) ? 0 : bi.bC(this.ccH) ? 0 : (this.uin == 0 || this.uin == -1) ? 0 : bi.bC(this.erV) ? 0 : bi.oW(this.erW) ? 0 : 1;
        if (i == 0) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer Error : isCacheValid== false");
            return null;
        }
        try {
            u uVar = new u();
            uVar.chE();
            uVar.Wj(this.username);
            uVar.Wj(this.erW);
            uVar.CZ(this.uin);
            uVar.bz(this.ccH);
            uVar.bz(this.erV);
            uVar.bz(this.erT);
            uVar.Wj(Uw());
            x.i("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer finish time:%s buflen:%s md5:%s", new Object[]{Long.valueOf(bi.bH(VF)), Integer.valueOf(uVar.chF().length), r6});
            return uVar.chF();
        } catch (Throwable e) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker getCacheBuffer exception:%s", new Object[]{bi.i(e)});
            return null;
        }
    }

    public final int I(byte[] bArr) {
        long VF = bi.VF();
        if (Ln()) {
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : isLogin == true ");
            return -2;
        }
        try {
            u uVar = new u();
            if (uVar.by(bArr) != 0) {
                x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : initParse: %s", new Object[]{Integer.valueOf(uVar.by(bArr))});
                return -3;
            }
            this.username = uVar.getString();
            this.erW = uVar.getString();
            this.uin = uVar.getInt();
            this.ccH = uVar.getBuffer();
            this.erV = uVar.getBuffer();
            this.erT = uVar.getBuffer();
            String string = uVar.getString();
            if (bi.oW(string) || !string.equals(Uw())) {
                clear();
                x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf Error : checksum failed");
                return -4;
            }
            x.i("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf finish time:%s  md5:%s", new Object[]{Long.valueOf(bi.bH(VF)), string});
            return 0;
        } catch (Throwable e) {
            clear();
            x.e("MicroMsg.AccInfo", "AccInfoCacheInWorker parseBuf exception:%s", new Object[]{bi.i(e)});
            return -5;
        }
    }

    public final void eK(int i) {
        x.i("MicroMsg.AccInfo", "summerauth setuin [%d -> %d], stack[%s]", new Object[]{Integer.valueOf(this.uin), Integer.valueOf(i), bi.cjd()});
        this.uin = i;
    }
}
