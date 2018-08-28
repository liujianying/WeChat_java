package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.sdk.platformtools.x;

class l$b implements Runnable {
    final /* synthetic */ l oKN;
    boolean oKO = false;
    boolean oKP = false;

    l$b(l lVar) {
        this.oKN = lVar;
    }

    public final void run() {
        while (this.oKN.oKv == 2 && !this.oKP) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.oKN.oHa.bJW() && this.oKN.oHa.oJX.videoDecode(this.oKN.oHa.oJX.oPf) == 1) {
                int i = this.oKN.oHa.oJX.field_remoteImgWidth;
                int i2 = this.oKN.oHa.oJX.field_remoteImgHeight;
                boolean z = i == 0 && i2 < 3;
                if (z) {
                    if (!this.oKO) {
                        l lVar = this.oKN;
                        lVar.oKJ |= 1;
                        this.oKN.oHa.oJY.setHWDecMode(this.oKN.oKJ);
                        x.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to HW dec");
                    }
                    if (v2protocal.oPU != null) {
                        try {
                            i = this.oKN.oHa.oJX.field_remoteImgLength;
                            x.d("MicroMsg.Voip.VoipDeviceHandler", "steve:video decode successfully!..len=" + i);
                            i2 = this.oKN.oHa.oJX.field_remoteImgHeight;
                            byte[] bArr = new byte[i];
                            this.oKN.oHa.oJX.getVideoHWDecode(this.oKN.oHa.oJX.oPf, bArr, i);
                            v2protocal.oPU.Q(bArr, i2);
                            x.d("MicroMsg.Voip.VoipDeviceHandler", "steve: fill in AvcDecoder take time = " + (System.currentTimeMillis() - currentTimeMillis) + ", startTime = " + currentTimeMillis);
                        } catch (Exception e) {
                            x.e("EncodeDecode", "interrupted while waiting");
                            x.e("MicroMsg.Voip.VoipDeviceHandler", " error:" + e.toString());
                        }
                    }
                } else {
                    if (this.oKO) {
                        l lVar2 = this.oKN;
                        lVar2.oKJ &= -2;
                        if (v2protocal.oPU != null) {
                            v2protocal.oPU.oHX = false;
                        }
                        this.oKN.oHa.oJY.setHWDecMode(this.oKN.oKJ);
                        x.i("MicroMsg.Voip.VoipDeviceHandler", "steve: change to SW dec");
                    }
                    if (this.oKN.oHa.oJX.field_remoteImgLength > 0 && this.oKN.oHa.oJY != null) {
                        v2protocal v2protocal = this.oKN.oHa.oJX;
                        v2protocal.oPE++;
                        this.oKN.oHa.oJY.b(i, i2, this.oKN.oHa.oJX.oPf);
                    }
                }
                this.oKO = z;
            }
            try {
                Thread.sleep(10);
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Voip.VoipDeviceHandler", e2, "", new Object[0]);
            }
        }
    }
}
