package com.tencent.mm.plugin.nfc.c.a;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import com.tencent.mm.plugin.nfc.a.a;
import com.tencent.mm.plugin.nfc.a.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b implements d {
    private IsoDep lFl;

    public b(Tag tag) {
        if (tag == null) {
            x.e("MicroMsg.ApduEngineIsoDep", "[NFC]tag is null");
            throw new IllegalStateException("tag is null");
        } else {
            this.lFl = IsoDep.get(tag);
        }
    }

    public final boolean connect() {
        if (!this.lFl.isConnected()) {
            this.lFl.connect();
        }
        return true;
    }

    public final void close() {
        if (this.lFl.isConnected()) {
            this.lFl.close();
        }
    }

    public final boolean isConnected() {
        return this.lFl.isConnected();
    }

    public final boolean bjs() {
        close();
        connect();
        return true;
    }

    public final c a(a aVar) {
        if (this.lFl == null) {
            x.e("MicroMsg.ApduEngineIsoDep", "[NFC]IsoDep is null");
            throw new IllegalStateException("IsoDep is null");
        }
        connect();
        c cVar = null;
        while (true) {
            c cVar2 = new c(this.lFl.transceive(aVar.getBytes()));
            if (cVar2.lEV.length == 0) {
                return cVar;
            }
            if (cVar2.lEV.length - 2 <= 0) {
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
                aVar = new a((byte[]) com.tencent.mm.plugin.nfc.a.b.lFd.clone());
            }
        }
    }
}
