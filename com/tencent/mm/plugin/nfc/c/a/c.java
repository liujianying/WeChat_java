package com.tencent.mm.plugin.nfc.c.a;

import android.nfc.Tag;
import android.nfc.tech.NfcA;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.b;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements d {
    private NfcA lFm;

    public c(Tag tag) {
        this.lFm = NfcA.get(tag);
    }

    public final com.tencent.mm.plugin.nfc.a.c a(a aVar) {
        if (this.lFm == null) {
            x.e("MicroMsg.ApduEngineNfcA", "[NFC]NfcA is null");
            throw new IllegalStateException("NfcA is null");
        }
        connect();
        com.tencent.mm.plugin.nfc.a.c cVar = null;
        while (true) {
            com.tencent.mm.plugin.nfc.a.c cVar2 = new com.tencent.mm.plugin.nfc.a.c(this.lFm.transceive(aVar.getBytes()));
            if (cVar2.lEV.length == 0) {
                return cVar;
            }
            if (cVar2.lEV.length - 2 < 0) {
                return cVar2;
            }
            if (cVar2.bjp() == (short) 108) {
                aVar.tX(cVar2.bjq());
            } else {
                if (cVar == null) {
                    cVar = cVar2;
                } else {
                    cVar.a(cVar2);
                }
                if (cVar2.bjp() != (short) 97) {
                    return cVar;
                }
                if (cVar2.bjq() != (short) 0) {
                    aVar = new a((byte[]) b.lFd.clone());
                } else {
                    cVar.lEV[cVar.lEV.length - 1] = (byte) -112;
                    return cVar;
                }
            }
        }
    }

    public final boolean connect() {
        if (!this.lFm.isConnected()) {
            this.lFm.connect();
        }
        return true;
    }

    public final void close() {
        if (this.lFm.isConnected()) {
            this.lFm.close();
        }
    }

    public final boolean isConnected() {
        return this.lFm.isConnected();
    }

    public final boolean bjs() {
        close();
        connect();
        return true;
    }
}
