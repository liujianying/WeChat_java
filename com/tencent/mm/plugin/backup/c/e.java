package com.tencent.mm.plugin.backup.c;

import android.os.Looper;
import com.tencent.mm.lan_cs.Server;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.a.g;
import com.tencent.mm.plugin.backup.b.a.1;
import com.tencent.mm.plugin.backup.d.a;
import com.tencent.mm.plugin.backup.d.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class e {
    com.tencent.mm.plugin.backup.a.e gRx;
    LinkedList<pw> gUH;
    String gUI;
    private String gUJ = "";
    private boolean gUK = false;
    a gUL;
    private al gUM = new al(Looper.getMainLooper(), new 1(this), true);
    final com.tencent.mm.ab.e gUN = new 2(this);
    final com.tencent.mm.ab.e gUO = new 3(this);

    public e(a aVar, com.tencent.mm.plugin.backup.a.e eVar) {
        this.gUL = aVar;
        this.gRx = eVar;
    }

    public final void start() {
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[]{Boolean.valueOf(this.gUK), Boolean.valueOf(this.gUM.ciq()), this, bi.cjd()});
        if (!this.gUK) {
            this.gUK = true;
            if (arM()) {
                this.gUJ = null;
                arL();
            } else {
                this.gRx.gRC = -4;
                this.gUL.l(-4, null);
            }
            this.gUM.J(500, 500);
        }
    }

    public final void stop() {
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
        this.gUK = false;
        au.DF().b(704, this.gUN);
        au.DF().b(1000, this.gUO);
        this.gUM.SO();
    }

    final void arL() {
        String cQ = g.cQ(ad.getContext());
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[]{cQ, this.gUJ, Boolean.valueOf(au.HX()), Boolean.valueOf(au.Dr())});
        if (!cQ.equals(this.gUJ) && au.HX()) {
            this.gUJ = cQ;
            if (arM()) {
                this.gUK = false;
                if (au.Dr()) {
                    x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
                    au.DF().a(1000, this.gUO);
                    au.DF().a(new a(this.gUH, this.gUI, b.arv().gTH), 0);
                    return;
                }
                x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
                au.DF().a(704, this.gUN);
                au.DF().a(new b(this.gUH, this.gUI), 0);
                return;
            }
            this.gUK = false;
        }
    }

    private boolean arM() {
        this.gUH = new LinkedList();
        PString pString = new PString();
        PInt pInt = new PInt();
        this.gUI = g.cQ(ad.getContext());
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[]{this.gUI});
        if (bi.oW(this.gUI)) {
            this.gRx.gRC = -4;
            this.gUL.l(-4, null);
            this.gUJ = "";
            return false;
        }
        int i;
        com.tencent.mm.plugin.backup.b.a arw = b.arv().arw();
        arw.mode = 0;
        x.i("MicroMsg.BackupCEngine", "listen, before server.stop");
        Java2C.stop();
        x.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
        Server.duG = new 1(arw);
        Object[] access$000 = Java2C.access$000();
        if (access$000 == null || access$000.length != 3) {
            x.e("MicroMsg.BackupCEngine", "listen error");
            i = 0;
        } else {
            x.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", new Object[]{access$000[0], access$000[1], access$000[2]});
            if (((Integer) access$000[0]).intValue() != 1) {
                i = 0;
            } else {
                pString.value = (String) access$000[1];
                pInt.value = ((Integer) access$000[2]).intValue();
                arw.mode = 1;
                i = 1;
            }
        }
        if (i == 0) {
            this.gRx.gRC = -4;
            this.gUL.l(-4, null);
            this.gUJ = "";
            return false;
        }
        x.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[]{pString.value, Integer.valueOf(pInt.value)});
        pw pwVar = new pw();
        pwVar.rud = pString.value;
        pwVar.rue = new LinkedList();
        pwVar.rue.add(Integer.valueOf(pInt.value));
        this.gUH.add(pwVar);
        return true;
    }
}
