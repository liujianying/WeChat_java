package com.tencent.mm.plugin.webview.stub;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.webview.stub.e.a;
import java.util.List;
import java.util.Map;

public abstract class d$a extends Binder implements d {
    public d$a() {
        attachInterface(this, "com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
    }

    public static d Y(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
        if (queryLocalInterface == null || !(queryLocalInterface instanceof d)) {
            return new a(iBinder);
        }
        return (d) queryLocalInterface;
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        Bundle bundle = null;
        int i3 = 0;
        boolean QS;
        String gT;
        int ej;
        int readInt;
        Bundle bundle2;
        List MM;
        String readString;
        boolean z;
        String readString2;
        String[] bVp;
        switch (i) {
            case 1:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = QS(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(QS ? 1 : 0);
                return true;
            case 2:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = gT(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case 3:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = he(parcel.readString());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 4:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = hO(parcel.readString());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 5:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = hf(parcel.readString());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 6:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = QO(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case 7:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = zZ();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 8:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = isSDCardAvailable();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 9:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = aSn();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 10:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = Hm();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 11:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ej = ej(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(ej);
                return true;
            case 12:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ek(parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 13:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = aU(parcel.readInt(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case 14:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                a(readInt, bundle2, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 15:
                IBinder asBinder;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                b S = S(bundle2);
                parcel2.writeNoException();
                if (S != null) {
                    asBinder = S.asBinder();
                }
                parcel2.writeStrongBinder(asBinder);
                return true;
            case 16:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                QS = T(bundle2);
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 17:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ej = QV(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeInt(ej);
                return true;
            case 18:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                favEditTag();
                parcel2.writeNoException();
                return true;
            case 19:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                QS = s(readInt, bundle2);
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 20:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = s(parcel.readLong(), parcel.readString());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 21:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QW(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 22:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = MN();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 23:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                MM = MM();
                parcel2.writeNoException();
                parcel2.writeStringList(MM);
                return true;
            case 24:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                g(parcel.readInt(), parcel.createStringArrayList());
                parcel2.writeNoException();
                return true;
            case 25:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readString = parcel.readString();
                boolean z2 = parcel.readInt() != 0;
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                QS = a(readString, z2, bundle2);
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case 26:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = QP(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case 27:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                cw(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModeCloseButtonStyle /*28*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                be(gT, z);
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModeBackground /*29*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = da(parcel.readString());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_actionModeSplitBackground /*30*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                j(readInt, bundle2);
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModeCloseDrawable /*31*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                bundle2 = p(readInt, bundle2);
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case 32:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = parcel.readString();
                if (parcel.readInt() != 0) {
                    z = true;
                }
                i(gT, z, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModeCopyDrawable /*33*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bundle2 = At(parcel.readInt());
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case s$l.AppCompatTheme_actionModePasteDrawable /*34*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = Au(parcel.readInt());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_actionModeSelectAllDrawable /*35*/:
                Bundle bundle3;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readString2 = parcel.readString();
                readString = parcel.readString();
                String readString3 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle3 = null;
                }
                if (parcel.readInt() != 0) {
                    bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                }
                QS = a(readString2, readString, readString3, bundle3, bundle, parcel.readInt());
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_actionModeShareDrawable /*36*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                H(parcel.readString(), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModeFindDrawable /*37*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readString2 = parcel.readString();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                a(readString2, bundle2, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QQ(parcel.readString());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_actionModePopupWindowStyle /*39*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = QR(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_textAppearanceLargePopupMenu /*40*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ab(parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_textAppearanceSmallPopupMenu /*41*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                a(a.Z(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_dialogTheme /*42*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Av(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_dialogPreferredPadding /*43*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bVp = bVp();
                parcel2.writeNoException();
                parcel2.writeStringArray(bVp);
                return true;
            case s$l.AppCompatTheme_listDividerAlertDialog /*44*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = bVq();
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_actionDropDownStyle /*45*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = Dp(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_dropdownListPreferredItemHeight /*46*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = bVr();
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case 47:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = QT(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_homeAsUpIndicator /*48*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Map bVt = bVt();
                parcel2.writeNoException();
                parcel2.writeMap(bVt);
                return true;
            case 49:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = fq(parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case 50:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QU(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 51:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = cx(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_selectableItemBackground /*52*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = getLanguage();
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_selectableItemBackgroundBorderless /*53*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = bVs();
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_borderlessButtonStyle /*54*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ej = bVu();
                parcel2.writeNoException();
                parcel2.writeInt(ej);
                return true;
            case s$l.AppCompatTheme_dividerVertical /*55*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ej = bVv();
                parcel2.writeNoException();
                parcel2.writeInt(ej);
                return true;
            case s$l.AppCompatTheme_dividerHorizontal /*56*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bVw();
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_activityChooserViewStyle /*57*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bVx();
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_toolbarStyle /*58*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Aw(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_toolbarNavigationButtonStyle /*59*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Ax(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_popupMenuStyle /*60*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                Ar(parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_popupWindowStyle /*61*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                cy(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_editTextColor /*62*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = bVy();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_editTextBackground /*63*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                gT = QY(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(gT);
                return true;
            case s$l.AppCompatTheme_imageButtonStyle /*64*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = bVA();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_textAppearanceSearchResultTitle /*65*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = bVz();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_textAppearanceSearchResultSubtitle /*66*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QS = bVD();
                parcel2.writeNoException();
                if (QS) {
                    i3 = 1;
                }
                parcel2.writeInt(i3);
                return true;
            case s$l.AppCompatTheme_textColorSearchUrl /*67*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                c(parcel.readString(), parcel.createIntArray());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_searchViewStyle /*68*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                QX(parcel.readString());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_listPreferredItemHeight /*69*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                h(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            case 70:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                bundle2 = g(readInt, bundle2);
                parcel2.writeNoException();
                if (bundle2 != null) {
                    parcel2.writeInt(1);
                    bundle2.writeToParcel(parcel2, 1);
                    return true;
                }
                parcel2.writeInt(0);
                return true;
            case s$l.AppCompatTheme_listPreferredItemHeightLarge /*71*/:
                Intent intent;
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    intent = (Intent) Intent.CREATOR.createFromParcel(parcel);
                } else {
                    intent = null;
                }
                aj(intent);
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_listPreferredItemPaddingLeft /*72*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                z(parcel.readInt(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_listPreferredItemPaddingRight /*73*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                MM = bVB();
                parcel2.writeNoException();
                parcel2.writeStringList(MM);
                return true;
            case s$l.AppCompatTheme_dropDownListViewStyle /*74*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                b(bundle2, parcel.readInt());
                parcel2.writeNoException();
                return true;
            case s$l.AppCompatTheme_listPopupWindowStyle /*75*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                ej = bVC();
                parcel2.writeNoException();
                parcel2.writeInt(ej);
                return true;
            case s$l.AppCompatTheme_textAppearanceListItem /*76*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                bVp = bVE();
                parcel2.writeNoException();
                parcel2.writeStringArray(bVp);
                return true;
            case s$l.AppCompatTheme_textAppearanceListItemSmall /*77*/:
                parcel.enforceInterface("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                readInt = parcel.readInt();
                if (parcel.readInt() != 0) {
                    bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                } else {
                    bundle2 = null;
                }
                r(readInt, bundle2);
                parcel2.writeNoException();
                return true;
            case 1598968902:
                parcel2.writeString("com.tencent.mm.plugin.webview.stub.WebViewStub_AIDL");
                return true;
            default:
                return super.onTransact(i, parcel, parcel2, i2);
        }
    }
}
