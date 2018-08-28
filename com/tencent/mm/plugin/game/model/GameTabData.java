package com.tencent.mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.db;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.ui.tab.GameTabHomeUI;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

public class GameTabData implements Parcelable {
    public static final Creator<GameTabData> CREATOR = new 1();
    public LinkedHashMap<String, TabItem> jOi;
    public StatusBar jOj;

    /* synthetic */ GameTabData(Parcel parcel, byte b) {
        this(parcel);
    }

    public final List<TabItem> aUC() {
        List<TabItem> arrayList = new ArrayList();
        if (this.jOi != null) {
            arrayList.addAll(this.jOi.values());
        }
        return arrayList;
    }

    public GameTabData() {
        this.jOi = new LinkedHashMap();
        this.jOj = new StatusBar();
    }

    private GameTabData(Parcel parcel) {
        g(parcel);
    }

    public int describeContents() {
        return 0;
    }

    private void g(Parcel parcel) {
        int readInt = parcel.readInt();
        if (this.jOi == null) {
            this.jOi = new LinkedHashMap();
        }
        for (int i = 0; i < readInt; i++) {
            TabItem tabItem = (TabItem) parcel.readParcelable(TabItem.class.getClassLoader());
            if (tabItem != null) {
                this.jOi.put(tabItem.jOl, tabItem);
            }
        }
        this.jOj = (StatusBar) parcel.readParcelable(StatusBar.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.jOi.size());
        for (Entry value : this.jOi.entrySet()) {
            parcel.writeParcelable((Parcelable) value.getValue(), i);
        }
        parcel.writeParcelable(this.jOj, i);
    }

    public static GameTabData bn(List<ak> list) {
        if (bi.cX(list)) {
            return null;
        }
        GameTabData gameTabData = new GameTabData();
        db aTN = h.aTL().aTN();
        if (aTN != null) {
            gameTabData.jOj.jOk = aTN.jOk;
            gameTabData.jOj.color = c.parseColor(aTN.dxh);
        }
        int i = 0;
        for (ak akVar : list) {
            if (!(akVar == null || bi.oW(akVar.jQM))) {
                TabItem tabItem = new TabItem();
                tabItem.jOl = akVar.jQM;
                tabItem.title = akVar.bHD;
                tabItem.jOm = akVar.jQN;
                tabItem.jOn = akVar.jQO;
                tabItem.jumpUrl = akVar.jOU;
                tabItem.jOq = akVar.jQP;
                tabItem.jOr = akVar.jQQ;
                if (tabItem.jOn) {
                    tabItem.jOs = GameTabHomeUI.class.getName();
                } else {
                    int i2 = i + 1;
                    i %= 3;
                    tabItem.jOs = "com.tencent.mm.plugin.game.ui.tab.GameTabWebUI" + (i != 0 ? String.valueOf(i) : "");
                    i = i2;
                }
                tabItem.jOt = false;
                tabItem.bYq = akVar.jQR;
                tabItem.jOu = akVar.jPC;
                tabItem.jLt = akVar.jPA;
                gameTabData.jOi.put(tabItem.jOl, tabItem);
            }
        }
        return gameTabData;
    }
}
