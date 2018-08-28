package com.tencent.mm.ui.transmit;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ak.e;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.ui.transmit.MsgRetransmitUI.4;

class MsgRetransmitUI$4$1 implements OnClickListener {
    final /* synthetic */ 4 uDM;

    MsgRetransmitUI$4$1(4 4) {
        this.uDM = 4;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (MsgRetransmitUI.e(this.uDM.uDL) != null) {
            au.DF().c(MsgRetransmitUI.e(this.uDM.uDL));
            int i2 = (int) MsgRetransmitUI.e(this.uDM.uDL).dVh;
            e hQ = o.Pf().hQ(i2);
            if (hQ != null) {
                g Pf = o.Pf();
                e hQ2 = Pf.hQ(i2);
                if (hQ2 != null && hQ2.dTK == ((long) i2)) {
                    FileOp.deleteFile(Pf.o(hQ2.dTL, "", ""));
                    FileOp.deleteFile(Pf.o(hQ2.dTN, "", ""));
                    FileOp.deleteFile(Pf.o(hQ2.dTN, "", "") + "hd");
                    Pf.dCZ.delete("ImgInfo2", "id=?", new String[]{String.valueOf(i2)});
                    if (hQ2.ON()) {
                        e hQ3 = Pf.hQ(hQ2.dTU);
                        if (hQ3 != null) {
                            FileOp.deleteFile(Pf.o(hQ3.dTL, "", ""));
                            FileOp.deleteFile(Pf.o(hQ3.dTN, "", ""));
                            FileOp.deleteFile(Pf.o(hQ3.dTN, "", "") + "hd");
                            Pf.dCZ.delete("ImgInfo2", "id=?", new String[]{hQ3.dTK});
                        }
                    }
                }
                au.HU();
                c.FT().dX(hQ.dTS);
            }
        }
        Toast.makeText(this.uDM.uDL, R.l.msgretr_share_cancel, 1).show();
        this.uDM.uDL.finish();
    }
}
