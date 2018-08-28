package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.abi;
import com.tencent.mm.protocal.c.ao;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo implements Parcelable {
    public static final Creator<CardGiftInfo> CREATOR = new 1();
    public String bYo;
    public String dxh;
    public int hvA;
    public int hvB;
    public int hvC;
    public String hvD;
    public String hvE;
    public int hvF;
    public String hvG;
    public String hvH;
    public String hvI;
    public String hvJ;
    public String hvK;
    public String hvL;
    public String hvM;
    public String hvN;
    public String hvO;
    public LinkedList<AcceptedCardItem> hvP = new LinkedList();
    public LinkedList<AccepterItem> hvQ = new LinkedList();
    public String hvR;
    public int hvS;
    public String hvT;
    public String hvU;
    public String hvm;
    public String hvn;
    public String hvo;
    public String hvp;
    public String hvq;
    public String hvr;
    public String hvs;
    public String hvt;
    public String hvu;
    public String hvv;
    public String hvw;
    public String hvx;
    public String hvy;
    public boolean hvz;
    public String toUserName;

    protected CardGiftInfo(Parcel parcel) {
        this.toUserName = parcel.readString();
        this.bYo = parcel.readString();
        this.hvm = parcel.readString();
        this.hvn = parcel.readString();
        this.hvo = parcel.readString();
        this.hvp = parcel.readString();
        this.hvq = parcel.readString();
        this.hvr = parcel.readString();
        this.hvs = parcel.readString();
        this.hvt = parcel.readString();
        this.hvu = parcel.readString();
        this.hvv = parcel.readString();
        this.hvw = parcel.readString();
        this.hvx = parcel.readString();
        this.hvy = parcel.readString();
        this.dxh = parcel.readString();
        this.hvz = parcel.readByte() != (byte) 0;
        this.hvA = parcel.readInt();
        this.hvB = parcel.readInt();
        this.hvC = parcel.readInt();
        this.hvD = parcel.readString();
        this.hvE = parcel.readString();
        this.hvF = parcel.readInt();
        this.hvG = parcel.readString();
        this.hvH = parcel.readString();
        this.hvI = parcel.readString();
        this.hvJ = parcel.readString();
        this.hvK = parcel.readString();
        this.hvL = parcel.readString();
        this.hvM = parcel.readString();
        this.hvN = parcel.readString();
        this.hvO = parcel.readString();
        parcel.readTypedList(this.hvP, AcceptedCardItem.CREATOR);
        parcel.readTypedList(this.hvQ, AccepterItem.CREATOR);
        this.hvR = parcel.readString();
        this.hvS = parcel.readInt();
        this.hvT = parcel.readString();
        this.hvU = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.toUserName);
        parcel.writeString(this.bYo);
        parcel.writeString(this.hvm);
        parcel.writeString(this.hvn);
        parcel.writeString(this.hvo);
        parcel.writeString(this.hvp);
        parcel.writeString(this.hvq);
        parcel.writeString(this.hvr);
        parcel.writeString(this.hvs);
        parcel.writeString(this.hvt);
        parcel.writeString(this.hvu);
        parcel.writeString(this.hvv);
        parcel.writeString(this.hvw);
        parcel.writeString(this.hvx);
        parcel.writeString(this.hvy);
        parcel.writeString(this.dxh);
        parcel.writeByte(this.hvz ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.hvA);
        parcel.writeInt(this.hvB);
        parcel.writeInt(this.hvC);
        parcel.writeString(this.hvD);
        parcel.writeString(this.hvE);
        parcel.writeInt(this.hvF);
        parcel.writeString(this.hvG);
        parcel.writeString(this.hvH);
        parcel.writeString(this.hvI);
        parcel.writeString(this.hvJ);
        parcel.writeString(this.hvK);
        parcel.writeString(this.hvL);
        parcel.writeString(this.hvM);
        parcel.writeString(this.hvN);
        parcel.writeString(this.hvO);
        parcel.writeTypedList(this.hvP);
        parcel.writeTypedList(this.hvQ);
        parcel.writeString(this.hvR);
        parcel.writeInt(this.hvS);
        parcel.writeString(this.hvT);
        parcel.writeString(this.hvU);
    }

    public String toString() {
        return "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.bYo + '\'' + ", fromUserImgUrl='" + this.hvm + '\'' + ", fromUserContent='" + this.hvn + '\'' + ", fromUserContentPicUrl='" + this.hvo + '\'' + ", fromUserContentVideoUrl='" + this.hvp + '\'' + ", fromUserContentThumbPicUrl='" + this.hvq + '\'' + ", picAESKey='" + this.hvr + '\'' + ", videoAESKey='" + this.hvs + '\'' + ", thumbVideoAESKey='" + this.hvt + '\'' + ", cardBackgroundPicUrl='" + this.hvu + '\'' + ", cardLogoLUrl='" + this.hvv + '\'' + ", cardTitle='" + this.hvw + '\'' + ", cardPrice='" + this.hvx + '\'' + ", footerWording='" + this.hvy + '\'' + ", color='" + this.dxh + '\'' + ", needJump=" + this.hvz + ", picDataLength=" + this.hvA + ", videoDataLength=" + this.hvB + ", thumbDataLength=" + this.hvC + ", descTitle='" + this.hvD + '\'' + ", descIconUrl='" + this.hvE + '\'' + ", descLayoutMode=" + this.hvF + ", giftingMediaTitle='" + this.hvG + '\'' + ", descriptionTitleColor='" + this.hvH + '\'' + ", cardTitleColor='" + this.hvI + '\'' + ", cardPriceTitleColor='" + this.hvJ + '\'' + ", userCardId='" + this.hvK + '\'' + ", operationTitle='" + this.hvL + '\'' + ", operationUrl='" + this.hvM + '\'' + ", cardTpId='" + this.hvN + '\'' + ", cardCode='" + this.hvO + '\'' + ", accepted_card_list_size='" + this.hvP.size() + '\'' + ", accepter_list_size='" + this.hvQ.size() + '\'' + ", accepter_list_title='" + this.hvR + '\'' + ", out_of_card='" + this.hvS + '\'' + ", operation_wxa_username='" + this.hvT + '\'' + ", operation_wxa_path='" + this.hvU + '\'' + '}';
    }

    public static CardGiftInfo a(ao aoVar) {
        LinkedList linkedList;
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = aoVar.qZX;
        cardGiftInfo.bYo = aoVar.qZY;
        cardGiftInfo.hvm = aoVar.qZZ;
        cardGiftInfo.hvn = aoVar.content;
        cardGiftInfo.hvo = aoVar.raa;
        cardGiftInfo.hvp = aoVar.rab;
        cardGiftInfo.hvq = aoVar.rac;
        cardGiftInfo.hvr = aoVar.rad;
        cardGiftInfo.hvt = aoVar.raf;
        cardGiftInfo.hvs = aoVar.rae;
        cardGiftInfo.hvu = aoVar.rag;
        cardGiftInfo.hvv = aoVar.rah;
        cardGiftInfo.hvw = aoVar.hvV;
        cardGiftInfo.hvx = aoVar.hvW;
        cardGiftInfo.hvy = aoVar.rai;
        cardGiftInfo.dxh = aoVar.dxh;
        cardGiftInfo.hvz = aoVar.raj;
        cardGiftInfo.hvA = aoVar.rak;
        cardGiftInfo.hvB = aoVar.ral;
        cardGiftInfo.hvC = aoVar.ram;
        cardGiftInfo.hvD = aoVar.ran;
        cardGiftInfo.hvE = aoVar.rao;
        cardGiftInfo.hvF = aoVar.rap;
        cardGiftInfo.hvG = aoVar.raq;
        cardGiftInfo.hvH = aoVar.rar;
        cardGiftInfo.hvI = aoVar.ras;
        cardGiftInfo.hvJ = aoVar.rat;
        cardGiftInfo.hvK = aoVar.rau;
        cardGiftInfo.hvL = aoVar.rav;
        cardGiftInfo.hvM = aoVar.raw;
        cardGiftInfo.hvN = aoVar.huU;
        cardGiftInfo.hvO = aoVar.rax;
        Iterator it = aoVar.hvP.iterator();
        while (it.hasNext()) {
            ap apVar = (ap) it.next();
            linkedList = cardGiftInfo.hvP;
            AcceptedCardItem acceptedCardItem = new AcceptedCardItem();
            acceptedCardItem.hvW = apVar.hvW;
            acceptedCardItem.hvV = apVar.hvV;
            linkedList.add(acceptedCardItem);
        }
        it = aoVar.hvQ.iterator();
        while (it.hasNext()) {
            aq aqVar = (aq) it.next();
            linkedList = cardGiftInfo.hvQ;
            AccepterItem accepterItem = new AccepterItem();
            accepterItem.hvW = aqVar.hvW;
            accepterItem.hvV = aqVar.hvV;
            accepterItem.hvY = aqVar.hvY;
            accepterItem.hvX = aqVar.hvX;
            linkedList.add(accepterItem);
        }
        cardGiftInfo.hvR = aoVar.hvR;
        cardGiftInfo.hvS = aoVar.hvS;
        cardGiftInfo.hvT = aoVar.hvT;
        cardGiftInfo.hvU = aoVar.hvU;
        return cardGiftInfo;
    }

    public static CardGiftInfo a(abi abi) {
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = abi.qZX;
        cardGiftInfo.bYo = abi.qZY;
        cardGiftInfo.hvm = abi.qZZ;
        cardGiftInfo.hvn = abi.content;
        cardGiftInfo.hvo = abi.raa;
        cardGiftInfo.hvp = abi.rab;
        cardGiftInfo.hvq = abi.rac;
        cardGiftInfo.hvr = abi.rad;
        cardGiftInfo.hvt = abi.raf;
        cardGiftInfo.hvs = abi.rae;
        cardGiftInfo.hvu = abi.rag;
        cardGiftInfo.hvv = abi.rah;
        cardGiftInfo.hvw = abi.hvV;
        cardGiftInfo.hvx = abi.hvW;
        cardGiftInfo.hvy = abi.rai;
        cardGiftInfo.dxh = abi.dxh;
        cardGiftInfo.hvz = abi.raj;
        cardGiftInfo.hvA = abi.rak;
        cardGiftInfo.hvB = abi.ral;
        cardGiftInfo.hvC = abi.ram;
        cardGiftInfo.hvD = abi.ran;
        cardGiftInfo.hvE = abi.rao;
        cardGiftInfo.hvF = abi.rap;
        cardGiftInfo.hvG = abi.raq;
        cardGiftInfo.hvH = abi.rar;
        cardGiftInfo.hvI = abi.ras;
        cardGiftInfo.hvJ = abi.rat;
        cardGiftInfo.hvK = abi.rau;
        cardGiftInfo.hvL = abi.rav;
        cardGiftInfo.hvM = abi.raw;
        cardGiftInfo.hvN = abi.huU;
        cardGiftInfo.hvO = abi.rax;
        return cardGiftInfo;
    }
}
