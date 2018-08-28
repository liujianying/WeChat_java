package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.modelsfs.FileOp;
import java.io.InputStream;

public final class BackwardSupportUtil {

    public static class ExifHelper {

        public static class LatLongData implements Parcelable {
            public static final Creator<LatLongData> CREATOR = new Creator<LatLongData>() {
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    LatLongData latLongData = new LatLongData();
                    latLongData.bSx = parcel.readFloat();
                    latLongData.dVI = parcel.readFloat();
                    return latLongData;
                }

                public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                    return new LatLongData[i];
                }
            };
            public float bSx;
            public float dVI;

            public LatLongData() {
                this.bSx = 0.0f;
                this.dVI = 0.0f;
            }

            public LatLongData(float f, float f2) {
                this.bSx = f;
                this.dVI = f2;
            }

            public int hashCode() {
                return ((int) (this.bSx * 10000.0f)) + ((int) (this.dVI * 10000.0f));
            }

            public boolean equals(Object obj) {
                if (!(obj instanceof LatLongData)) {
                    return false;
                }
                LatLongData latLongData = (LatLongData) obj;
                if (Math.abs(this.bSx - latLongData.bSx) >= 1.0E-6f || Math.abs(this.dVI - latLongData.dVI) >= 1.0E-6f) {
                    return false;
                }
                return true;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeFloat(this.bSx);
                parcel.writeFloat(this.dVI);
            }
        }

        public static int VX(String str) {
            if (bi.oW(str)) {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return 0;
            } else if (FileOp.cn(str)) {
                return Exif.fromFile(str).getOrientationInDegree();
            } else {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return 0;
            }
        }

        public static LatLongData VY(String str) {
            if (bi.oW(str)) {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "filepath is null or nil");
                return null;
            } else if (FileOp.cn(str)) {
                com.tencent.mm.compatible.util.Exif.a location = Exif.fromFile(str).getLocation();
                if (location == null) {
                    return null;
                }
                LatLongData latLongData = new LatLongData();
                latLongData.bSx = (float) location.latitude;
                latLongData.dVI = (float) location.longitude;
                return latLongData;
            } else {
                x.d("MicroMsg.SDK.BackwardSupportUtil", "file not exist:[%s]", str);
                return null;
            }
        }
    }

    public static class a {
        public static void c(View view, Animation animation) {
            if (VERSION.SDK_INT >= 8) {
                b bVar = new b();
                animation.cancel();
                return;
            }
            a aVar = new a();
            if (view != null) {
                view.setAnimation(null);
            }
        }
    }

    public static class b {
        public static Bitmap e(String str, float f) {
            float f2 = 160.0f * f;
            Bitmap f3 = c.f(str, f);
            if (f3 != null) {
                f3.setDensity((int) f2);
            }
            return f3;
        }

        public static int b(Context context, float f) {
            return Math.round((((float) context.getResources().getDisplayMetrics().densityDpi) * f) / 160.0f);
        }

        public static Bitmap a(InputStream inputStream, float f) {
            float f2 = 160.0f * f;
            Bitmap a = c.a(inputStream, f, 0, 0);
            if (a != null) {
                a.setDensity((int) f2);
            }
            return a;
        }

        public static String fp(Context context) {
            String str;
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            Configuration configuration = context.getResources().getConfiguration();
            String str2 = "";
            if (displayMetrics.density < 1.0f) {
                str = str2 + "LDPI";
            } else if (displayMetrics.density >= 1.5f) {
                str = str2 + "HDPI";
            } else {
                str = str2 + "MDPI";
            }
            return str + (configuration.orientation == 2 ? "_L" : "_P");
        }
    }

    public static class c {
        public static void a(ListView listView) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    bc bcVar = new bc();
                    if (listView.getFirstVisiblePosition() > 10) {
                        listView.setSelection(10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(0);
                        return;
                    }
                    return;
                }
                bb bbVar = new bb();
                listView.setSelection(0);
            }
        }

        public static void b(ListView listView, int i) {
            if (listView != null) {
                if (VERSION.SDK_INT >= 8) {
                    bc bcVar = new bc();
                    int firstVisiblePosition = listView.getFirstVisiblePosition();
                    if (firstVisiblePosition > i && firstVisiblePosition - i > 10) {
                        listView.setSelection(i + 10);
                    } else if (firstVisiblePosition < i && i - firstVisiblePosition > 10) {
                        listView.setSelection(i - 10);
                    }
                    if (VERSION.SDK_INT >= 8) {
                        listView.smoothScrollToPosition(i);
                        return;
                    }
                    return;
                }
                bb bbVar = new bb();
                listView.setSelection(i);
            }
        }
    }
}
