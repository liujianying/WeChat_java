package com.tencent.mm.plugin.game.gamewebview.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.cc;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fz;
import com.tencent.mm.g.a.mk;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u$b;
import com.tencent.mm.plugin.game.gamewebview.ipc.GWMainProcessTask;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class FavUrlTask extends GWMainProcessTask {
    public static final Creator<FavUrlTask> CREATOR = new Creator<FavUrlTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FavUrlTask(parcel, (byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavUrlTask[i];
        }
    };
    public int actionType;
    public boolean bGZ;
    public boolean jHV;
    public boolean jHW;
    public Bundle jfZ;
    public int ret;
    public int type;

    /* synthetic */ FavUrlTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public final void aai() {
        switch (this.actionType) {
            case 1:
                if (this.jfZ != null) {
                    boolean a;
                    long j = this.jfZ.getLong("msg_id", Long.MIN_VALUE);
                    String string = this.jfZ.getString("sns_local_id");
                    int i = this.jfZ.getInt("news_svr_id", 0);
                    String string2 = this.jfZ.getString("news_svr_tweetid");
                    ch chVar = new ch();
                    if (Long.MIN_VALUE != j) {
                        chVar.bJF.bJJ = this.jfZ.getInt("message_index", 0);
                        a = e.a(chVar, j);
                    } else if (!bi.oW(string)) {
                        qs qsVar = new qs();
                        qsVar.cbk.cbn = string;
                        qsVar.cbk.cbo = chVar;
                        qsVar.cbk.url = this.jfZ.getString("rawUrl");
                        a.sFg.m(qsVar);
                        a = qsVar.cbl.bJm;
                    } else if (i != 0) {
                        mk mkVar = new mk();
                        mkVar.bXl.opType = 3;
                        mkVar.bXl.bXn = chVar;
                        mkVar.bXl.bXo = i;
                        mkVar.bXl.bXp = string2;
                        a.sFg.m(mkVar);
                        a = mkVar.bXm.bJm;
                    } else {
                        this.jHV = true;
                        return;
                    }
                    if (a) {
                        String oV = bi.oV(this.jfZ.getString("prePublishId"));
                        String ic = u.ic(oV);
                        u$b v = u.Hx().v(ic, true);
                        v.p("sendAppMsgScene", Integer.valueOf(2));
                        v.p("preChatName", this.jfZ.getString("preChatName"));
                        v.p("preMsgIndex", Integer.valueOf(this.jfZ.getInt("preMsgIndex")));
                        v.p("prePublishId", oV);
                        v.p("preUsername", this.jfZ.getString("preUsername"));
                        v.p("getA8KeyScene", this.jfZ.getString("getA8KeyScene"));
                        v.p("referUrl", this.jfZ.getString("referUrl"));
                        Bundle bundle = this.jfZ.getBundle("jsapiargs");
                        if (bundle != null) {
                            v.p("adExtStr", bundle.getString("key_snsad_statextstr"));
                        }
                        chVar.bJF.bJK = ic;
                        a.sFg.m(chVar);
                    } else {
                        if (chVar.bJF.bJL == 0) {
                            chVar.bJF.bJL = R.l.favorite_fail_nonsupport;
                        }
                        a.sFg.m(chVar);
                    }
                    this.ret = chVar.bJG.ret;
                    return;
                }
                return;
            case 2:
                fz fzVar = new fz();
                fzVar.bOL.type = 35;
                a.sFg.m(fzVar);
                return;
            case 3:
                this.jHW = d.QS("favorite");
                return;
            case 4:
                cc ccVar = new cc();
                ccVar.bJy.bJA = this.jfZ.getLong("fav_local_id", -1);
                a.sFg.m(ccVar);
                x.i("MicroMsg.FavUrlTask", "do del fav web url, local id %d, result %B", new Object[]{Long.valueOf(ccVar.bJy.bJA), Boolean.valueOf(ccVar.bJz.bJm)});
                this.bGZ = ccVar.bJz.bJm;
                return;
            default:
                return;
        }
    }

    public final void g(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.actionType = parcel.readInt();
        this.jfZ = parcel.readBundle();
        this.jHV = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.bGZ = z;
        this.ret = parcel.readInt();
        this.type = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.jHW = z2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.actionType);
        parcel.writeBundle(this.jfZ);
        parcel.writeByte((byte) (this.jHV ? 1 : 0));
        if (this.bGZ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.ret);
        parcel.writeInt(this.type);
        if (!this.jHW) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    private FavUrlTask(Parcel parcel) {
        g(parcel);
    }
}
