package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.ab.l;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.model.a.m;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bzt;
import com.tencent.mm.protocal.c.bzu;
import com.tencent.mm.protocal.c.caf;
import com.tencent.mm.protocal.c.cak;
import com.tencent.mm.protocal.c.cav;
import com.tencent.mm.protocal.c.cax;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class t {
    j oHa = null;
    caf oNI = new caf();
    private bzu oNJ = null;
    private int oNK = 0;

    public t(j jVar) {
        this.oHa = jVar;
    }

    private void a(bzu bzu) {
        if (bzu == null) {
            a.eT("MicroMsg.Voip.VoipSyncHandle", "failed to pushVoipCmdList , VoipCmdList = null");
            this.oNK++;
            return;
        }
        if (this.oNJ == null) {
            this.oNJ = new bzu();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < bzu.hbF) {
                this.oNJ.hbG.add((bzt) bzu.hbG.get(i2));
                i = i2 + 1;
            } else {
                this.oNJ.hbF = this.oNJ.hbG.size();
                return;
            }
        }
    }

    private void b(bzu bzu) {
        if (this.oNJ != null && this.oNJ.hbF > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.oNJ.hbF) {
                    bzu.hbG.add((bzt) this.oNJ.hbG.get(i2));
                    i = i2 + 1;
                } else {
                    bzu.hbF = bzu.hbG.size();
                    bLl();
                    return;
                }
            }
        }
    }

    public final void bLl() {
        if (this.oNJ != null) {
            this.oNJ.hbG.clear();
            this.oNJ.hbF = 0;
            this.oNJ = null;
            this.oNK = 0;
        }
    }

    public final int a(bzu bzu, boolean z, int i) {
        if (this.oHa.oJX.kpo == 0) {
            a.eT("MicroMsg.Voip.VoipSyncHandle", g.Ac() + "failed to do voip sync , roomid = 0");
        } else if (this.oHa.oKd) {
            a.eT("MicroMsg.Voip.VoipSyncHandle", g.Ac() + "voip syncing, push to cache...");
            a(bzu);
        } else {
            bzu bzu2;
            this.oHa.oKd = true;
            if (bzu == null) {
                bzu2 = new bzu();
                bzu2.hbF = 0;
                bzu2.hbG = new LinkedList();
            } else {
                bzu2 = bzu;
            }
            b(bzu2);
            this.oNK = 0;
            if (this.oHa.oKb == null) {
                this.oHa.oKb = "".getBytes();
            }
            a.eU("MicroMsg.Voip.VoipSyncHandle", "____doVoipSync, fromjni:" + z + ",cmdList:" + bzu2.hbF + ",syncKey.length:" + this.oHa.oKb.length + ",selector:" + i);
            new m(this.oHa.oJX.kpo, bzu2, this.oHa.oKb, this.oHa.oJX.kpp, i).bLp();
        }
        return 0;
    }

    public final void a(cav cav, int i) {
        a.eU("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged:  status:" + cav.hcd);
        if (cav.hcd == 1) {
            m mVar;
            this.oHa.oJw = true;
            if (1 == i) {
                mVar = this.oHa.oJX.oPS;
                if (0 == mVar.oLs) {
                    mVar.oLs = System.currentTimeMillis();
                    a.eU("MicroMsg.VoipDailReport", "accept received timestamp:" + mVar.oLs);
                }
            }
            if (3 == i) {
                mVar = this.oHa.oJX.oPS;
                if (0 == mVar.oLt) {
                    mVar.oLt = System.currentTimeMillis();
                    a.eU("MicroMsg.VoipDailReport", "sync accept received timestamp:" + mVar.oLt);
                }
            }
            a.eU("MicroMsg.Voip.VoipSyncHandle", "zhengxue[DataAccept]onVoipSyncStatus:ACCEPTdata Flag: " + i);
            this.oHa.oJY.aWJ();
            i.bJI().oNa.bLk();
            this.oHa.oJx = true;
            if (this.oHa.oJz) {
                this.oHa.oJz = false;
                if (this.oHa.oJv) {
                    a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus:ACCEPT, pre-connect already success");
                    this.oHa.bJT();
                } else if (this.oHa.oJy) {
                    a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect already fail");
                    this.oHa.o(1, -9000, "");
                } else {
                    a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACCEPT, pre-connect still connecting...");
                }
            }
            h.mEJ.h(11519, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(2)});
            this.oHa.bJZ();
            this.oHa.bKb();
        } else if (cav.hcd == 6) {
            a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACKED");
            a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: try use pre-connect");
            this.oHa.oJz = true;
            this.oHa.oJX.oON = 1;
            this.oHa.bJZ();
        } else if (cav.hcd == 8) {
            a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus: ACK BUSY");
            this.oHa.oJX.oPS.oKR = 211;
            this.oHa.oJX.oPS.oKQ = 11;
            this.oHa.oJX.oPS.oLc = 12;
            h.mEJ.h(11519, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(3)});
            this.oHa.o(1, 211, "");
            this.oHa.bKb();
        } else if (cav.hcd == 2) {
            a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_REJECT");
            this.oHa.oJX.oPS.oKQ = s$l.AppCompatTheme_checkedTextViewStyle;
            this.oHa.oJX.oPS.oLc = 4;
            this.oHa.oJX.oPS.oLj = (int) (System.currentTimeMillis() - this.oHa.oJX.oPS.beginTime);
            h.mEJ.h(11519, new Object[]{Integer.valueOf(i.bJI().bKS()), Long.valueOf(i.bJI().bKT()), Long.valueOf(i.bJI().bKU()), Integer.valueOf(1)});
            this.oHa.bKb();
            this.oHa.o(4, 0, "");
        } else if (cav.hcd == 3) {
            this.oHa.oJX.oPS.oLc = 5;
        } else if (cav.hcd == 4) {
            a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus...MM_VOIP_SYNC_STATUS_SHUTDOWN");
            if (this.oHa.mStatus < 6) {
                this.oHa.oJX.oPS.oLd = 1;
            }
            this.oHa.oJX.oPS.oKQ = s$l.AppCompatTheme_spinnerStyle;
            this.oHa.o(6, 0, "");
            this.oHa.bKb();
        } else {
            a.eU("MicroMsg.Voip.VoipSyncHandle", "onStatusChanged: unknow status:" + cav.hcd);
        }
    }

    public final void a(cak cak) {
        au.Em().H(new 1(this, cak));
    }

    public final void b(cak cak) {
        j jVar = this.oHa;
        jVar.oJX.oOo = cak.rfy.siK.toByteArray();
        jVar.bKa();
    }

    public final void c(bhy bhy) {
        int aV = a.aV(bhy.siK.toByteArray());
        a.eU("MicroMsg.Voip.VoipSyncHandle", "voipSync remote status changed, status = " + aV);
        j jVar = this.oHa;
        aV &= 255;
        if (8 == aV || 9 == aV) {
            jVar.oJP = aV;
        } else {
            jVar.oJN = aV;
            jVar.oJL = aV;
        }
        if (1 == aV || 3 == aV) {
            jVar.yw(2);
        }
        jVar.oJY.yF(aV);
    }

    public final void o(l lVar) {
        x.i("MicroMsg.Voip.VoipSyncHandle", "____VoipSyncResp");
        this.oHa.oKd = false;
        cax cax = (cax) ((m) lVar).bLq();
        this.oHa.oJX.parseSyncKeyBuff(this.oHa.oKb, this.oHa.oKb.length);
        int i = this.oHa.oJX.field_statusSyncKey;
        int i2 = this.oHa.oJX.field_relayDataSyncKey;
        int i3 = this.oHa.oJX.field_connectingStatusKey;
        this.oHa.oJX.parseSyncKeyBuff(cax.rny.siK.toByteArray(), cax.rny.siI);
        int i4 = this.oHa.oJX.field_statusSyncKey;
        int i5 = this.oHa.oJX.field_relayDataSyncKey;
        int i6 = this.oHa.oJX.field_connectingStatusKey;
        x.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: oldStatusSyncKey:" + i + " oldRelayDataSyncKey:" + i2 + " oldConnectingStatusSyncKey:" + i3);
        x.i("MicroMsg.Voip.VoipSyncHandle", "VoipSyncResp: newStatusSyncKey:" + i4 + " newRelayDataSyncKey:" + i5 + " newConnectingStatusSyncKey:" + i6);
        this.oHa.oKb = cax.rny.siK.toByteArray();
        x.i("MicroMsg.Voip.VoipSyncHandle", "voipSync response: continueflag=" + cax.rlm);
        LinkedList linkedList = cax.sxi.hbG;
        if (linkedList != null && linkedList.size() != 0) {
            x.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size" + linkedList.size());
            x.i("MicroMsg.Voip.VoipSyncHandle", " syncOnSceneEnd cmdlist size:" + linkedList.size() + ",selector = " + ((m) lVar).bLo());
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= linkedList.size()) {
                    break;
                }
                bzt bzt = (bzt) linkedList.get(i8);
                int i9 = bzt.rtM;
                x.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp, item cmdid:" + i9);
                if (i9 == 1) {
                    if (i4 > i) {
                        if (this.oHa.oJX.kpo == 0) {
                            a.eT("MicroMsg.Voip.VoipSyncHandle", "voipSyncStatus ignored , roomid = 0");
                        } else {
                            try {
                                cav cav = (cav) new cav().aG(bzt.rtN.siK.toByteArray());
                                a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncStatus in...from user=" + bzt.jTv + ",itemStatus =  " + cav.hcd);
                                a(cav, 3);
                            } catch (Throwable e) {
                                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 2) {
                    if (i5 > i2) {
                        if (this.oHa.oJX.kpo == 0) {
                            a.eT("MicroMsg.Voip.VoipSyncHandle", "RelayData ignored , roomid = 0");
                        } else {
                            try {
                                cak cak = (cak) new cak().aG(bzt.rtN.siK.toByteArray());
                                a.eU("MicroMsg.Voip.VoipSyncHandle", "onVoipSyncRelayData ...relayType = " + cak.hcE + ",from user = " + bzt.jTv);
                                if (cak.hcE == 5) {
                                    a(cak);
                                } else if (cak.hcE == 3) {
                                    this.oHa.aR(cak.rfy.siK.toByteArray());
                                    if (!(cak.rfy == null || cak.rfy.siK == null)) {
                                        this.oNI.suL = cak;
                                    }
                                } else if (cak.hcE == 2) {
                                    this.oHa.aQ(cak.rfy.siK.toByteArray());
                                    if (!(cak.rfy == null || cak.rfy.siK == null)) {
                                        this.oNI.suK = cak;
                                    }
                                } else if (cak.hcE == 1) {
                                    b(cak);
                                }
                            } catch (Throwable e2) {
                                x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e2, "", new Object[0]);
                            }
                        }
                    }
                } else if (i9 == 3 && i6 > i3) {
                    if (this.oHa.oJX.kpo == 0) {
                        x.e("MicroMsg.Voip.VoipSyncHandle", "voipSync(ClientStatus) ignored , roomid = 0");
                    } else {
                        try {
                            bhy br = new bhy().br(bzt.rtN.siK.toByteArray());
                            if (bzt.jTv.equals(q.GF())) {
                                a.eT("MicroMsg.Voip.VoipSyncHandle", "svr response: local connecting status changed.");
                            } else {
                                c(br);
                            }
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.Voip.VoipSyncHandle", e22, "", new Object[0]);
                        }
                    }
                }
                i7 = i8 + 1;
            }
        }
        x.i("MicroMsg.Voip.VoipSyncHandle", "__parse sync resp end");
        if ((this.oNJ != null && this.oNJ.hbF > 0) || this.oNK > 0) {
            a(null, false, 7);
        }
    }
}
