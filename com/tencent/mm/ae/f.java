package com.tencent.mm.ae;

import com.tencent.mm.az.d;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bd.a;
import java.util.LinkedList;

public final class f extends ah {
    public final boolean gV(int i) {
        return i != 0 && i < 604307701;
    }

    public final void transfer(int i) {
        if (i != 0 && i < 604307701) {
            h.mEJ.e(336, 11, 1);
            au.HU();
            bd[] bH = c.FT().bH("fmessage", 20);
            if (bH == null) {
                x.e("MicroMsg.FMessageDataTransfer", "transfer fail, msglist is empty");
                return;
            }
            d.SF();
            x.d("MicroMsg.FMessageDataTransfer", "transfer, msgList count = " + bH.length);
            for (cm cmVar : bH) {
                if (cmVar != null && cmVar.field_msgId != 0) {
                    x.d("MicroMsg.FMessageDataTransfer", "transfer msg type = " + cmVar.getType());
                    String str = cmVar.field_content;
                    if (str != null && str.length() != 0) {
                        at atVar;
                        switch (cmVar.getType()) {
                            case 37:
                                x.d("MicroMsg.FMessageDataTransfer", "processVerifyMsg, msg content = " + cmVar.field_content);
                                bd.d YY = bd.d.YY(cmVar.field_content);
                                if (!ai.oW(YY.otZ) && (YY.scene == 18 || com.tencent.mm.model.bd.hd(YY.scene))) {
                                    x.i("MicroMsg.FMessageDataTransfer", "processVerifyMsg, skip lbs & shake, scene = " + YY.scene);
                                    break;
                                }
                                atVar = new at();
                                atVar.field_createTime = cmVar.field_createTime;
                                atVar.field_isSend = 0;
                                atVar.field_msgContent = cmVar.field_content;
                                atVar.field_svrId = cmVar.field_msgSvrId;
                                atVar.field_talker = YY.otZ;
                                switch (YY.bOh) {
                                    case 2:
                                        atVar.field_type = 1;
                                        break;
                                    case 5:
                                        atVar.field_type = 2;
                                        break;
                                    case 6:
                                        atVar.field_type = 3;
                                        break;
                                    default:
                                        atVar.field_type = 1;
                                        break;
                                }
                                d.SE().b(atVar);
                                break;
                            case 40:
                                x.d("MicroMsg.FMessageDataTransfer", "processFMessage, msg content = " + cmVar.field_content);
                                a YV = a.YV(cmVar.field_content);
                                atVar = new at();
                                atVar.field_createTime = cmVar.field_createTime;
                                atVar.field_isSend = 0;
                                atVar.field_msgContent = cmVar.field_content;
                                atVar.field_svrId = cmVar.field_msgSvrId;
                                atVar.field_talker = YV.otZ;
                                atVar.field_type = 0;
                                d.SE().b(atVar);
                                break;
                            default:
                                x.i("MicroMsg.FMessageDataTransfer", "no need to transfer, msgtype = " + cmVar.getType());
                                break;
                        }
                    }
                    x.e("MicroMsg.FMessageDataTransfer", "transfer fail, content is null, skip this msg, id = " + cmVar.field_msgId);
                } else {
                    x.e("MicroMsg.FMessageDataTransfer", "transfer fail, msg is null, skip this msg");
                }
            }
            au.HU();
            c.DT().set(143618, Integer.valueOf(0));
            d.SF().clO();
            x.d("MicroMsg.FMessageDataTransfer", "transfer, try to delete fmessage contact & conversation");
            au.HU();
            c.FR().Ym("fmessage");
            LinkedList linkedList = new LinkedList();
            linkedList.add("fmessage");
            au.HU();
            c.FW().as(linkedList);
        }
    }

    public final String getTag() {
        return "MicroMsg.FMessageDataTransfer";
    }
}
