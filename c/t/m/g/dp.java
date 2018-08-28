package c.t.m.g;

import android.annotation.SuppressLint;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class dp extends ds {
    public a a = a.a;
    public int b = 460;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = Integer.MAX_VALUE;
    public int h = Integer.MAX_VALUE;
    private final long i = System.currentTimeMillis();
    private List<NeighboringCellInfo> j;

    private dp() {
    }

    @Nullable
    public static dp a(ct ctVar, CellLocation cellLocation, SignalStrength signalStrength) {
        if (!ctVar.b() || cellLocation == null) {
            return null;
        }
        TelephonyManager telephonyManager = ctVar.e;
        dp dpVar = new dp();
        try {
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                dpVar.a = a.c;
                dpVar.a(telephonyManager);
                dpVar.c = cdmaCellLocation.getSystemId();
                dpVar.d = cdmaCellLocation.getNetworkId();
                dpVar.e = cdmaCellLocation.getBaseStationId();
                dpVar.g = cdmaCellLocation.getBaseStationLatitude();
                dpVar.h = cdmaCellLocation.getBaseStationLongitude();
                if (signalStrength == null) {
                    dpVar.f = -1;
                    return dpVar;
                }
                dpVar.f = signalStrength.getCdmaDbm();
                return dpVar;
            }
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            dpVar.a = a.b;
            dpVar.a(telephonyManager);
            dpVar.d = gsmCellLocation.getLac();
            dpVar.e = gsmCellLocation.getCid();
            if (signalStrength == null) {
                dpVar.f = -1;
                return dpVar;
            }
            dpVar.f = (signalStrength.getGsmSignalStrength() * 2) - 113;
            return dpVar;
        } catch (Throwable th) {
            th.toString();
            return dpVar;
        }
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public static dp a(ct ctVar, CellInfo cellInfo) {
        int i = -88;
        if (cellInfo == null) {
            return null;
        }
        TelephonyManager telephonyManager = ctVar.e;
        dp dpVar = new dp();
        try {
            int dbm;
            if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                dpVar.a = a.c;
                dpVar.a(telephonyManager);
                dpVar.c = cellIdentity.getSystemId();
                dpVar.d = cellIdentity.getNetworkId();
                dpVar.e = cellIdentity.getBasestationId();
                dpVar.g = cellIdentity.getLatitude();
                dpVar.h = cellIdentity.getLongitude();
                dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                dpVar.f = i;
                return dpVar;
            } else if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                dpVar.a = a.b;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                dpVar.d = cellIdentity2.getLac();
                dpVar.e = cellIdentity2.getCid();
                dpVar.b = cellIdentity2.getMcc();
                dpVar.c = cellIdentity2.getMnc();
                dbm = cellInfoGsm.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                dpVar.f = i;
                return dpVar;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                dpVar.a = a.d;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                dpVar.d = cellIdentity3.getLac();
                dpVar.e = cellIdentity3.getCid();
                dpVar.b = cellIdentity3.getMcc();
                dpVar.c = cellIdentity3.getMnc();
                dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                dpVar.f = i;
                return dpVar;
            } else if (!(cellInfo instanceof CellInfoLte)) {
                return dpVar;
            } else {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                dpVar.a = a.e;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                dpVar.d = cellIdentity4.getTac();
                dpVar.e = cellIdentity4.getCi();
                dpVar.b = cellIdentity4.getMcc();
                dpVar.c = cellIdentity4.getMnc();
                dbm = cellInfoLte.getCellSignalStrength().getDbm();
                if (dbm <= -110 || dbm >= -40) {
                    dbm = -88;
                }
                dpVar.f = dbm;
                return dpVar;
            }
        } catch (Throwable th) {
            th.toString();
            return dpVar;
        }
    }

    private void a(TelephonyManager telephonyManager) {
        int[] iArr = new int[2];
        ec.a(telephonyManager, iArr);
        if (iArr[0] > 0 && iArr[1] >= 0) {
            this.b = iArr[0];
            this.c = iArr[1];
        }
    }

    @NonNull
    public final synchronized List<NeighboringCellInfo> a() {
        if (this.j == null) {
            this.j = Collections.emptyList();
        }
        return this.j;
    }

    public final synchronized void a(@Nullable List<NeighboringCellInfo> list) {
        if (list != null) {
            this.j = Collections.unmodifiableList(list);
        } else {
            this.j = Collections.emptyList();
        }
    }

    public final String b() {
        return this.b + this.c + this.d + this.e;
    }

    public final String toString() {
        return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
    }
}
