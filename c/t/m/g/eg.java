package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import java.util.List;

public final class eg {
    private static eg a = null;

    public static eg a() {
        if (a == null) {
            a = new eg();
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public static int a(Context context) {
        int i;
        Object obj;
        Object obj2;
        int i2;
        boolean isProviderEnabled;
        boolean z;
        if (context == null) {
            return -1;
        }
        int i3;
        LocationManager locationManager;
        boolean b = b(context);
        try {
            Object i4;
            WifiManager wifiManager = (WifiManager) context.getSystemService(TencentExtraKeys.LOCATION_SOURCE_WIFI);
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                try {
                    if (VERSION.SDK_INT < 18 || !wifiManager.isScanAlwaysAvailable()) {
                        i4 = 1;
                    } else {
                        obj = 1;
                        obj2 = 1;
                        i2 = i3;
                        locationManager = (LocationManager) context.getSystemService("location");
                        if (locationManager == null) {
                            try {
                                i3 = Secure.getInt(context.getContentResolver(), "location_mode");
                            } catch (Throwable th) {
                                i3 = 0;
                            }
                            try {
                                isProviderEnabled = locationManager.isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS);
                                List allProviders = locationManager.getAllProviders();
                                if (allProviders == null) {
                                    z = false;
                                } else {
                                    z = allProviders.contains(TencentExtraKeys.LOCATION_SOURCE_GPS);
                                }
                            } catch (Exception e) {
                                i4 = i3;
                                z = false;
                                i3 = i4;
                                isProviderEnabled = false;
                                if (b) {
                                    i4 = 1;
                                } else {
                                    i4 = 0;
                                }
                                if (i2 == 0) {
                                    i4 += 2;
                                }
                                if (!isProviderEnabled) {
                                    i4 += 4;
                                }
                                if (obj == null) {
                                    i4 += 8;
                                }
                                if (!z) {
                                    i4 += 16;
                                }
                                if (obj2 == null) {
                                    i4 += 32;
                                }
                                switch (i3) {
                                    case 0:
                                        return i4 + 64;
                                    case 1:
                                        return i4 + 128;
                                    case 2:
                                        return i4 + 256;
                                    case 3:
                                        return i4 + 512;
                                    default:
                                        return i4;
                                }
                            }
                        }
                        z = false;
                        i3 = 0;
                        isProviderEnabled = false;
                        if (b) {
                            i4 = 1;
                        } else {
                            i4 = 0;
                        }
                        if (i2 == 0) {
                            i4 += 2;
                        }
                        if (isProviderEnabled) {
                            i4 += 4;
                        }
                        if (obj == null) {
                            i4 += 8;
                        }
                        if (z) {
                            i4 += 16;
                        }
                        if (obj2 == null) {
                            i4 += 32;
                        }
                        switch (i3) {
                            case 0:
                                return i4 + 64;
                            case 1:
                                return i4 + 128;
                            case 2:
                                return i4 + 256;
                            case 3:
                                return i4 + 512;
                            default:
                                return i4;
                        }
                    }
                } catch (Throwable th2) {
                    obj = null;
                    obj2 = null;
                    i2 = i3;
                    locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager == null) {
                        try {
                            i3 = Secure.getInt(context.getContentResolver(), "location_mode");
                        } catch (Throwable th3) {
                            i3 = 0;
                        }
                        try {
                            isProviderEnabled = locationManager.isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS);
                            List allProviders2 = locationManager.getAllProviders();
                            if (allProviders2 == null) {
                                z = false;
                            } else {
                                z = allProviders2.contains(TencentExtraKeys.LOCATION_SOURCE_GPS);
                            }
                        } catch (Exception e2) {
                            i4 = i3;
                            z = false;
                            i3 = i4;
                            isProviderEnabled = false;
                            if (b) {
                                i4 = 1;
                            } else {
                                i4 = 0;
                            }
                            if (i2 == 0) {
                                i4 += 2;
                            }
                            if (!isProviderEnabled) {
                                i4 += 4;
                            }
                            if (obj == null) {
                                i4 += 8;
                            }
                            if (!z) {
                                i4 += 16;
                            }
                            if (obj2 == null) {
                                i4 += 32;
                            }
                            switch (i3) {
                                case 0:
                                    return i4 + 64;
                                case 1:
                                    return i4 + 128;
                                case 2:
                                    return i4 + 256;
                                case 3:
                                    return i4 + 512;
                                default:
                                    return i4;
                            }
                        }
                    }
                    z = false;
                    i3 = 0;
                    isProviderEnabled = false;
                    if (b) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    if (i2 == 0) {
                        i4 += 2;
                    }
                    if (isProviderEnabled) {
                        i4 += 4;
                    }
                    if (obj == null) {
                        i4 += 8;
                    }
                    if (z) {
                        i4 += 16;
                    }
                    if (obj2 == null) {
                        i4 += 32;
                    }
                    switch (i3) {
                        case 0:
                            return i4 + 64;
                        case 1:
                            return i4 + 128;
                        case 2:
                            return i4 + 256;
                        case 3:
                            return i4 + 512;
                        default:
                            return i4;
                    }
                }
            }
            i4 = null;
            i3 = 0;
            obj = i4;
            obj2 = null;
            i2 = i3;
        } catch (Throwable th4) {
            i3 = 0;
            obj = null;
            obj2 = null;
            i2 = i3;
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                z = false;
                i3 = 0;
                isProviderEnabled = false;
            } else {
                try {
                    i3 = Secure.getInt(context.getContentResolver(), "location_mode");
                } catch (Throwable th32) {
                    i3 = 0;
                }
                try {
                    isProviderEnabled = locationManager.isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS);
                    List allProviders22 = locationManager.getAllProviders();
                    if (allProviders22 == null) {
                        z = false;
                    } else {
                        z = allProviders22.contains(TencentExtraKeys.LOCATION_SOURCE_GPS);
                    }
                } catch (Exception e22) {
                    i4 = i3;
                    z = false;
                    i3 = i4;
                    isProviderEnabled = false;
                    if (b) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    if (i2 == 0) {
                        i4 += 2;
                    }
                    if (!isProviderEnabled) {
                        i4 += 4;
                    }
                    if (obj == null) {
                        i4 += 8;
                    }
                    if (!z) {
                        i4 += 16;
                    }
                    if (obj2 == null) {
                        i4 += 32;
                    }
                    switch (i3) {
                        case 0:
                            return i4 + 64;
                        case 1:
                            return i4 + 128;
                        case 2:
                            return i4 + 256;
                        case 3:
                            return i4 + 512;
                        default:
                            return i4;
                    }
                }
            }
            if (b) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i2 == 0) {
                i4 += 2;
            }
            if (isProviderEnabled) {
                i4 += 4;
            }
            if (obj == null) {
                i4 += 8;
            }
            if (z) {
                i4 += 16;
            }
            if (obj2 == null) {
                i4 += 32;
            }
            switch (i3) {
                case 0:
                    return i4 + 64;
                case 1:
                    return i4 + 128;
                case 2:
                    return i4 + 256;
                case 3:
                    return i4 + 512;
                default:
                    return i4;
            }
        }
        try {
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                z = false;
                i3 = 0;
                isProviderEnabled = false;
            } else {
                try {
                    i3 = Secure.getInt(context.getContentResolver(), "location_mode");
                } catch (Throwable th322) {
                    i3 = 0;
                }
                try {
                    isProviderEnabled = locationManager.isProviderEnabled(TencentExtraKeys.LOCATION_SOURCE_GPS);
                    List allProviders222 = locationManager.getAllProviders();
                    if (allProviders222 == null) {
                        z = false;
                    } else {
                        z = allProviders222.contains(TencentExtraKeys.LOCATION_SOURCE_GPS);
                    }
                } catch (Exception e222) {
                    i4 = i3;
                    z = false;
                    i3 = i4;
                    isProviderEnabled = false;
                    if (b) {
                        i4 = 1;
                    } else {
                        i4 = 0;
                    }
                    if (i2 == 0) {
                        i4 += 2;
                    }
                    if (!isProviderEnabled) {
                        i4 += 4;
                    }
                    if (obj == null) {
                        i4 += 8;
                    }
                    if (!z) {
                        i4 += 16;
                    }
                    if (obj2 == null) {
                        i4 += 32;
                    }
                    switch (i3) {
                        case 0:
                            return i4 + 64;
                        case 1:
                            return i4 + 128;
                        case 2:
                            return i4 + 256;
                        case 3:
                            return i4 + 512;
                        default:
                            return i4;
                    }
                }
            }
        } catch (Exception e3) {
            i4 = 0;
            z = false;
            i3 = i4;
            isProviderEnabled = false;
            if (b) {
                i4 = 0;
            } else {
                i4 = 1;
            }
            if (i2 == 0) {
                i4 += 2;
            }
            if (isProviderEnabled) {
                i4 += 4;
            }
            if (obj == null) {
                i4 += 8;
            }
            if (z) {
                i4 += 16;
            }
            if (obj2 == null) {
                i4 += 32;
            }
            switch (i3) {
                case 0:
                    return i4 + 64;
                case 1:
                    return i4 + 128;
                case 2:
                    return i4 + 256;
                case 3:
                    return i4 + 512;
                default:
                    return i4;
            }
        }
        if (b) {
            i4 = 0;
        } else {
            i4 = 1;
        }
        if (i2 == 0) {
            i4 += 2;
        }
        if (isProviderEnabled) {
            i4 += 4;
        }
        if (obj == null) {
            i4 += 8;
        }
        if (z) {
            i4 += 16;
        }
        if (obj2 == null) {
            i4 += 32;
        }
        switch (i3) {
            case 0:
                return i4 + 64;
            case 1:
                return i4 + 128;
            case 2:
                return i4 + 256;
            case 3:
                return i4 + 512;
            default:
                return i4;
        }
    }

    private static boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }
}
