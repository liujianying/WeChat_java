package com.tencent.mm.plugin.appbrand.r;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.memory.l;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory.DecodeResultLogger;
import com.tencent.mm.sdk.platformtools.MMNativeJpeg;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public enum a {
    ;

    public static boolean a(Options options) {
        if (options == null) {
            return false;
        }
        String str = options.outMimeType;
        if (str == null) {
            return false;
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            return true;
        }
        if (str.indexOf("jpeg") >= 0) {
            return true;
        }
        return false;
    }

    private static boolean a(String str, int i, int i2, CompressFormat compressFormat, int i3, String str2) {
        Options VZ = c.VZ(str);
        if (VZ == null || VZ.outWidth <= 0 || VZ.outHeight <= 0) {
            return false;
        }
        return a(str, VZ.outWidth, VZ.outHeight, i, i2, compressFormat, i3, str2);
    }

    private static Bitmap b(String str, Options options, DecodeResultLogger decodeResultLogger) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            x.d("MicroMsg.AppBrandImgUtil", "decodeWithRotateByExif used %dms bitmap: %s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), l.Fu().a(str, options, decodeResultLogger)});
            return l.Fu().a(str, options, decodeResultLogger);
        } catch (OutOfMemoryError e) {
            b.cou();
            x.e("MicroMsg.AppBrandImgUtil", "OutOfMemoryError e " + e.getMessage());
            return null;
        }
    }

    private static boolean a(String str, int i, int i2, int i3, int i4, CompressFormat compressFormat, int i5, String str2) {
        OutputStream outputStream = null;
        try {
            Bitmap b;
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, srcWidth: %s, srcHeight: %s, width: %s, height: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i3)});
            Options options = new Options();
            DecodeResultLogger decodeResultLogger = new DecodeResultLogger();
            double d = (((double) i2) * 1.0d) / ((double) i3);
            double d2 = (((double) i) * 1.0d) / ((double) i4);
            if (i == i4 && i2 == i3) {
                b = b(str, options, decodeResultLogger);
            } else {
                options.inSampleSize = 1;
                if (i2 > i3 || i > i4) {
                    options.inSampleSize = (int) (d < d2 ? d2 : d);
                    if (options.inSampleSize <= 1) {
                        options.inSampleSize = 1;
                    }
                }
                while (((i2 * i) / options.inSampleSize) / options.inSampleSize > 2764800) {
                    options.inSampleSize++;
                }
                x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, sampleSize: %s", new Object[]{Integer.valueOf(options.inSampleSize)});
                b = b(str, options, decodeResultLogger);
            }
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, result bm: %s", new Object[]{b});
            if (b == null) {
                return false;
            }
            int ceil;
            int i6;
            int i7;
            int i8;
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScale, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(b.getWidth()), Integer.valueOf(b.getHeight())});
            if (d < d2) {
                ceil = (int) Math.ceil(((((double) i4) * 1.0d) * ((double) i2)) / ((double) i));
                i6 = i4;
            } else {
                i6 = (int) Math.ceil(((((double) i3) * 1.0d) * ((double) i)) / ((double) i2));
                ceil = i3;
            }
            int VX = ExifHelper.VX(str);
            if (VX == 90 || VX == 270) {
                b = c.b(b, (float) VX);
                i7 = ceil;
                i8 = i6;
            } else {
                i7 = i6;
                i8 = ceil;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(b, i7, i8, true);
            if (createScaledBitmap == null) {
                createScaledBitmap = b;
            } else if (b != createScaledBitmap) {
                l.Fu().l(b);
            }
            x.i("MicroMsg.AppBrandImgUtil", "createThumbNailUnScalebyUpload, degree %d, bm.width: %s, bm.height: %s", new Object[]{Integer.valueOf(VX), Integer.valueOf(createScaledBitmap.getWidth()), Integer.valueOf(createScaledBitmap.getHeight())});
            outputStream = FileOp.jx(str2);
            c.a(createScaledBitmap, i5, compressFormat, outputStream, false);
            l.Fu().l(createScaledBitmap);
            outputStream.close();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "create thumbnail from orig failed: %s", new Object[]{str2});
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e2) {
                }
            }
            return false;
        }
    }

    public static boolean bP(String str, String str2) {
        Throwable th;
        InputStream inputStream;
        int mI = (int) FileOp.mI(str2);
        Options VZ = c.VZ(str2);
        if (VZ == null) {
            x.i("MicroMsg.AppBrandImgUtil", "compressImage, get null bitmap.option from path %s", new Object[]{str2});
            return false;
        }
        boolean z;
        boolean a;
        int i;
        int i2;
        int i3;
        int i4;
        Options options;
        InputStream inputStream2;
        InputStream iVar;
        Bitmap decodeStream;
        if (VZ != null) {
            String str3 = VZ.outMimeType;
            x.d("MicroMsg.AppBrandImgUtil", "mimetype: " + str3);
            if (str3 != null) {
                boolean z2;
                str3 = str3.toLowerCase();
                if (str3.indexOf("jpg") >= 0) {
                    z = true;
                } else if (str3.indexOf("jpeg") >= 0) {
                    z = true;
                } else if (str3.indexOf("png") >= 0) {
                    z = true;
                }
                a = a(VZ);
                i = -1;
                if (a) {
                    i = MMNativeJpeg.queryQuality(str2);
                    if (i < 70 && i > 25) {
                        i2 = i;
                        i3 = i;
                        i = 0;
                        if (a) {
                            try {
                                Exif fromFile = Exif.fromFile(str2);
                                if (fromFile != null) {
                                    i = fromFile.getOrientationInDegree() % 360;
                                    x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile.getOrientationInDegree())});
                                }
                                i4 = i;
                            } catch (Exception e) {
                                x.e("MicroMsg.AppBrandImgUtil", "get degree error " + e.getMessage());
                            }
                            x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
                            if ((VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) && VZ.outWidth * VZ.outHeight <= 10240000) {
                                if (mI >= 204800 && z && i4 == 0) {
                                    x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                                    if (FileOp.y(str2, str) >= 0) {
                                        return true;
                                    }
                                    return false;
                                }
                                options = new Options();
                                c.c(options);
                                inputStream2 = null;
                                inputStream2 = FileOp.openRead(str2);
                                if (inputStream2.markSupported() && (inputStream2 instanceof FileInputStream)) {
                                    iVar = new i((FileInputStream) inputStream2);
                                } else {
                                    iVar = inputStream2;
                                }
                                iVar.mark(1048576);
                                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                                iVar.reset();
                                if (decodeStream != null) {
                                    if (iVar != null) {
                                        try {
                                            iVar.close();
                                        } catch (IOException e2) {
                                        }
                                    }
                                    return false;
                                }
                                c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                                if (z && i4 == 0) {
                                    x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                                    if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                                        FileOp.deleteFile(str);
                                        z2 = FileOp.y(str2, str) >= 0;
                                        if (iVar == null) {
                                            return z2;
                                        }
                                        try {
                                            iVar.close();
                                            return z2;
                                        } catch (IOException e3) {
                                            return z2;
                                        }
                                    }
                                    if (iVar != null) {
                                        try {
                                            iVar.close();
                                        } catch (IOException e4) {
                                        }
                                    }
                                    return true;
                                }
                                if (iVar != null) {
                                    try {
                                        iVar.close();
                                    } catch (IOException e5) {
                                    }
                                }
                                return true;
                            } else if (mI < 102400 && z && i4 == 0) {
                                x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                                return FileOp.y(str2, str) >= 0;
                            } else if ((VZ.outWidth > 960 || VZ.outHeight > 640) && (VZ.outHeight > 960 || VZ.outWidth > 640)) {
                                i = VZ.outWidth >= VZ.outHeight ? 960 : 640;
                                int i5 = VZ.outWidth >= VZ.outHeight ? 640 : 960;
                                if (VZ.outWidth >= VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                                    int i6;
                                    x.i("MicroMsg.AppBrandImgUtil", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                                    if (VZ.outHeight <= 0) {
                                        VZ.outHeight = 1;
                                    }
                                    if (VZ.outWidth <= 0) {
                                        VZ.outWidth = 1;
                                    }
                                    if (VZ.outWidth > VZ.outHeight) {
                                        i = VZ.outWidth / VZ.outHeight;
                                    } else {
                                        i = VZ.outHeight / VZ.outWidth;
                                    }
                                    if (i == 0) {
                                        i = 1;
                                    }
                                    i2 = (int) Math.sqrt((double) (10240000 / i));
                                    if (VZ.outWidth > VZ.outHeight) {
                                        i6 = i2 * i;
                                        i5 = i2;
                                    } else {
                                        i5 = i2 * i;
                                        i6 = i2;
                                    }
                                    x.i("MicroMsg.AppBrandImgUtil", "new width height " + i6 + " " + i5 + " " + i);
                                    i2 = i6;
                                } else {
                                    i2 = i;
                                }
                                z2 = a(str2, i5, i2, CompressFormat.JPEG, i3, str);
                                if (!z || i4 != 0) {
                                    return z2;
                                }
                                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                                if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                                    return z2;
                                }
                                FileOp.deleteFile(str);
                                if (FileOp.y(str2, str) >= 0) {
                                    return true;
                                }
                                return false;
                            } else {
                                x.i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                                if (FileOp.mI(str2) < 71680) {
                                    if (z) {
                                        x.i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", new Object[]{str2});
                                        return FileOp.y(str2, str) >= 0;
                                    } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                                        return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i3, str);
                                    }
                                }
                                z2 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i3, str);
                                if (!z || i4 != 0) {
                                    return z2;
                                }
                                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                                if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                                    return z2;
                                }
                                FileOp.deleteFile(str);
                                return FileOp.y(str2, str) >= 0;
                            }
                        }
                        i4 = 0;
                        x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
                        if (VZ.outWidth < VZ.outHeight * 2) {
                        }
                        if (mI >= 204800) {
                        }
                        options = new Options();
                        c.c(options);
                        inputStream2 = null;
                        inputStream2 = FileOp.openRead(str2);
                        if (inputStream2.markSupported()) {
                        }
                        iVar = inputStream2;
                        iVar.mark(1048576);
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                            if (z && i4 == 0) {
                                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                                if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                                    FileOp.deleteFile(str);
                                    z2 = FileOp.y(str2, str) >= 0;
                                    if (iVar == null) {
                                        return z2;
                                    }
                                    try {
                                        iVar.close();
                                        return z2;
                                    } catch (IOException e32) {
                                        return z2;
                                    }
                                }
                                if (iVar != null) {
                                    try {
                                        iVar.close();
                                    } catch (IOException e42) {
                                    }
                                }
                                return true;
                            }
                            if (iVar != null) {
                                try {
                                    iVar.close();
                                } catch (IOException e52) {
                                }
                            }
                            return true;
                        }
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e22) {
                            }
                        }
                        return false;
                    }
                }
                i2 = i;
                i3 = 70;
                i = 0;
                if (a) {
                    try {
                        Exif fromFile2 = Exif.fromFile(str2);
                        if (fromFile2 != null) {
                            i = fromFile2.getOrientationInDegree() % 360;
                            x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile2.getOrientationInDegree())});
                        }
                        i4 = i;
                    } catch (Exception e6) {
                        x.e("MicroMsg.AppBrandImgUtil", "get degree error " + e6.getMessage());
                    }
                    x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
                    if ((VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) && VZ.outWidth * VZ.outHeight <= 10240000) {
                        if (mI >= 204800 && z && i4 == 0) {
                            x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                            if (FileOp.y(str2, str) >= 0) {
                                return true;
                            }
                            return false;
                        }
                        options = new Options();
                        c.c(options);
                        inputStream2 = null;
                        inputStream2 = FileOp.openRead(str2);
                        if (inputStream2.markSupported() && (inputStream2 instanceof FileInputStream)) {
                            iVar = new i((FileInputStream) inputStream2);
                        } else {
                            iVar = inputStream2;
                        }
                        iVar.mark(1048576);
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            if (iVar != null) {
                                try {
                                    iVar.close();
                                } catch (IOException e222) {
                                }
                            }
                            return false;
                        }
                        c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                        if (z && i4 == 0) {
                            x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                            if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                                FileOp.deleteFile(str);
                                z2 = FileOp.y(str2, str) >= 0;
                                if (iVar == null) {
                                    return z2;
                                }
                                try {
                                    iVar.close();
                                    return z2;
                                } catch (IOException e322) {
                                    return z2;
                                }
                            }
                            if (iVar != null) {
                                try {
                                    iVar.close();
                                } catch (IOException e422) {
                                }
                            }
                            return true;
                        }
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e522) {
                            }
                        }
                        return true;
                    } else if (mI < 102400 && z && i4 == 0) {
                        x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                        return FileOp.y(str2, str) >= 0;
                    } else if ((VZ.outWidth > 960 || VZ.outHeight > 640) && (VZ.outHeight > 960 || VZ.outWidth > 640)) {
                        i = VZ.outWidth >= VZ.outHeight ? 960 : 640;
                        int i52 = VZ.outWidth >= VZ.outHeight ? 640 : 960;
                        if (VZ.outWidth >= VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                            int i62;
                            x.i("MicroMsg.AppBrandImgUtil", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                            if (VZ.outHeight <= 0) {
                                VZ.outHeight = 1;
                            }
                            if (VZ.outWidth <= 0) {
                                VZ.outWidth = 1;
                            }
                            if (VZ.outWidth > VZ.outHeight) {
                                i = VZ.outWidth / VZ.outHeight;
                            } else {
                                i = VZ.outHeight / VZ.outWidth;
                            }
                            if (i == 0) {
                                i = 1;
                            }
                            i2 = (int) Math.sqrt((double) (10240000 / i));
                            if (VZ.outWidth > VZ.outHeight) {
                                i62 = i2 * i;
                                i52 = i2;
                            } else {
                                i52 = i2 * i;
                                i62 = i2;
                            }
                            x.i("MicroMsg.AppBrandImgUtil", "new width height " + i62 + " " + i52 + " " + i);
                            i2 = i62;
                        } else {
                            i2 = i;
                        }
                        z2 = a(str2, i52, i2, CompressFormat.JPEG, i3, str);
                        if (!z || i4 != 0) {
                            return z2;
                        }
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                            return z2;
                        }
                        FileOp.deleteFile(str);
                        if (FileOp.y(str2, str) >= 0) {
                            return true;
                        }
                        return false;
                    } else {
                        x.i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                        if (FileOp.mI(str2) < 71680) {
                            if (z) {
                                x.i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", new Object[]{str2});
                                return FileOp.y(str2, str) >= 0;
                            } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                                return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i3, str);
                            }
                        }
                        z2 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i3, str);
                        if (!z || i4 != 0) {
                            return z2;
                        }
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                            return z2;
                        }
                        FileOp.deleteFile(str);
                        return FileOp.y(str2, str) >= 0;
                    }
                }
                i4 = 0;
                x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
                if (VZ.outWidth < VZ.outHeight * 2) {
                }
                if (mI >= 204800) {
                }
                options = new Options();
                c.c(options);
                inputStream2 = null;
                inputStream2 = FileOp.openRead(str2);
                if (inputStream2.markSupported()) {
                }
                iVar = inputStream2;
                try {
                    iVar.mark(1048576);
                    decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                    iVar.reset();
                    if (decodeStream != null) {
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e2222) {
                            }
                        }
                        return false;
                    }
                    c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z && i4 == 0) {
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                            FileOp.deleteFile(str);
                            z2 = FileOp.y(str2, str) >= 0;
                            if (iVar == null) {
                                return z2;
                            }
                            try {
                                iVar.close();
                                return z2;
                            } catch (IOException e3222) {
                                return z2;
                            }
                        }
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e4222) {
                            }
                        }
                        return true;
                    }
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e5222) {
                        }
                    }
                    return true;
                } catch (Throwable e7) {
                    th = e7;
                    inputStream = iVar;
                    try {
                        x.printErrStackTrace("MicroMsg.AppBrandImgUtil", th, "Decode bitmap failed: " + str2, new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e8) {
                            }
                        }
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e9) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable e72) {
                    th = e72;
                    inputStream = iVar;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e92) {
                        }
                    }
                    throw th;
                }
            }
        }
        z = false;
        a = a(VZ);
        i = -1;
        if (a) {
            i = MMNativeJpeg.queryQuality(str2);
            if (i < 70 && i > 25) {
                i2 = i;
                i3 = i;
                i = 0;
                if (a) {
                    try {
                        Exif fromFile22 = Exif.fromFile(str2);
                        if (fromFile22 != null) {
                            i = fromFile22.getOrientationInDegree() % 360;
                            x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile22.getOrientationInDegree())});
                        }
                        i4 = i;
                    } catch (Exception e62) {
                        x.e("MicroMsg.AppBrandImgUtil", "get degree error " + e62.getMessage());
                    }
                    x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
                    if ((VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) && VZ.outWidth * VZ.outHeight <= 10240000) {
                        if (mI >= 204800 && z && i4 == 0) {
                            x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                            if (FileOp.y(str2, str) >= 0) {
                                return true;
                            }
                            return false;
                        }
                        options = new Options();
                        c.c(options);
                        inputStream2 = null;
                        inputStream2 = FileOp.openRead(str2);
                        if (inputStream2.markSupported() && (inputStream2 instanceof FileInputStream)) {
                            iVar = new i((FileInputStream) inputStream2);
                        } else {
                            iVar = inputStream2;
                        }
                        iVar.mark(1048576);
                        decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                        iVar.reset();
                        if (decodeStream != null) {
                            if (iVar != null) {
                                try {
                                    iVar.close();
                                } catch (IOException e22222) {
                                }
                            }
                            return false;
                        }
                        c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                        if (z && i4 == 0) {
                            x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                            if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                                FileOp.deleteFile(str);
                                z2 = FileOp.y(str2, str) >= 0;
                                if (iVar == null) {
                                    return z2;
                                }
                                try {
                                    iVar.close();
                                    return z2;
                                } catch (IOException e32222) {
                                    return z2;
                                }
                            }
                            if (iVar != null) {
                                try {
                                    iVar.close();
                                } catch (IOException e42222) {
                                }
                            }
                            return true;
                        }
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e52222) {
                            }
                        }
                        return true;
                    } else if (mI < 102400 && z && i4 == 0) {
                        x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                        return FileOp.y(str2, str) >= 0;
                    } else if ((VZ.outWidth > 960 || VZ.outHeight > 640) && (VZ.outHeight > 960 || VZ.outWidth > 640)) {
                        i = VZ.outWidth >= VZ.outHeight ? 960 : 640;
                        int i522 = VZ.outWidth >= VZ.outHeight ? 640 : 960;
                        if (VZ.outWidth >= VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                            int i622;
                            x.i("MicroMsg.AppBrandImgUtil", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                            if (VZ.outHeight <= 0) {
                                VZ.outHeight = 1;
                            }
                            if (VZ.outWidth <= 0) {
                                VZ.outWidth = 1;
                            }
                            if (VZ.outWidth > VZ.outHeight) {
                                i = VZ.outWidth / VZ.outHeight;
                            } else {
                                i = VZ.outHeight / VZ.outWidth;
                            }
                            if (i == 0) {
                                i = 1;
                            }
                            i2 = (int) Math.sqrt((double) (10240000 / i));
                            if (VZ.outWidth > VZ.outHeight) {
                                i622 = i2 * i;
                                i522 = i2;
                            } else {
                                i522 = i2 * i;
                                i622 = i2;
                            }
                            x.i("MicroMsg.AppBrandImgUtil", "new width height " + i622 + " " + i522 + " " + i);
                            i2 = i622;
                        } else {
                            i2 = i;
                        }
                        z2 = a(str2, i522, i2, CompressFormat.JPEG, i3, str);
                        if (!z || i4 != 0) {
                            return z2;
                        }
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                            return z2;
                        }
                        FileOp.deleteFile(str);
                        if (FileOp.y(str2, str) >= 0) {
                            return true;
                        }
                        return false;
                    } else {
                        x.i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                        if (FileOp.mI(str2) < 71680) {
                            if (z) {
                                x.i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", new Object[]{str2});
                                return FileOp.y(str2, str) >= 0;
                            } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                                return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i3, str);
                            }
                        }
                        z2 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i3, str);
                        if (!z || i4 != 0) {
                            return z2;
                        }
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                            return z2;
                        }
                        FileOp.deleteFile(str);
                        return FileOp.y(str2, str) >= 0;
                    }
                }
                i4 = 0;
                x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
                if (VZ.outWidth < VZ.outHeight * 2) {
                }
                if (mI >= 204800) {
                }
                options = new Options();
                c.c(options);
                inputStream2 = null;
                inputStream2 = FileOp.openRead(str2);
                if (inputStream2.markSupported()) {
                }
                iVar = inputStream2;
                iVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z && i4 == 0) {
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                            FileOp.deleteFile(str);
                            z2 = FileOp.y(str2, str) >= 0;
                            if (iVar == null) {
                                return z2;
                            }
                            try {
                                iVar.close();
                                return z2;
                            } catch (IOException e322222) {
                                return z2;
                            }
                        }
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e422222) {
                            }
                        }
                        return true;
                    }
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e522222) {
                        }
                    }
                    return true;
                }
                if (iVar != null) {
                    try {
                        iVar.close();
                    } catch (IOException e222222) {
                    }
                }
                return false;
            }
        }
        i2 = i;
        i3 = 70;
        i = 0;
        if (a) {
            try {
                Exif fromFile222 = Exif.fromFile(str2);
                if (fromFile222 != null) {
                    i = fromFile222.getOrientationInDegree() % 360;
                    x.i("MicroMsg.AppBrandImgUtil", "compressImage exif rotation %d", new Object[]{Integer.valueOf(fromFile222.getOrientationInDegree())});
                }
                i4 = i;
            } catch (Exception e622) {
                x.e("MicroMsg.AppBrandImgUtil", "get degree error " + e622.getMessage());
            }
            x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
            if ((VZ.outWidth < VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) && VZ.outWidth * VZ.outHeight <= 10240000) {
                if (mI >= 204800 && z && i4 == 0) {
                    x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeLong 204800");
                    if (FileOp.y(str2, str) >= 0) {
                        return true;
                    }
                    return false;
                }
                options = new Options();
                c.c(options);
                inputStream2 = null;
                inputStream2 = FileOp.openRead(str2);
                if (inputStream2.markSupported() && (inputStream2 instanceof FileInputStream)) {
                    iVar = new i((FileInputStream) inputStream2);
                } else {
                    iVar = inputStream2;
                }
                iVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e2222222) {
                        }
                    }
                    return false;
                }
                c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                if (z && i4 == 0) {
                    x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                    if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                        FileOp.deleteFile(str);
                        z2 = FileOp.y(str2, str) >= 0;
                        if (iVar == null) {
                            return z2;
                        }
                        try {
                            iVar.close();
                            return z2;
                        } catch (IOException e3222222) {
                            return z2;
                        }
                    }
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e4222222) {
                        }
                    }
                    return true;
                }
                if (iVar != null) {
                    try {
                        iVar.close();
                    } catch (IOException e5222222) {
                    }
                }
                return true;
            } else if (mI < 102400 && z && i4 == 0) {
                x.i("MicroMsg.AppBrandImgUtil", "filelen is control in picCompressAvoidanceActiveSizeNormal 102400");
                return FileOp.y(str2, str) >= 0;
            } else if ((VZ.outWidth > 960 || VZ.outHeight > 640) && (VZ.outHeight > 960 || VZ.outWidth > 640)) {
                i = VZ.outWidth >= VZ.outHeight ? 960 : 640;
                int i5222 = VZ.outWidth >= VZ.outHeight ? 640 : 960;
                if (VZ.outWidth >= VZ.outHeight * 2 || VZ.outHeight >= VZ.outWidth * 2) {
                    int i6222;
                    x.i("MicroMsg.AppBrandImgUtil", "too max pic " + VZ.outWidth + " " + VZ.outHeight);
                    if (VZ.outHeight <= 0) {
                        VZ.outHeight = 1;
                    }
                    if (VZ.outWidth <= 0) {
                        VZ.outWidth = 1;
                    }
                    if (VZ.outWidth > VZ.outHeight) {
                        i = VZ.outWidth / VZ.outHeight;
                    } else {
                        i = VZ.outHeight / VZ.outWidth;
                    }
                    if (i == 0) {
                        i = 1;
                    }
                    i2 = (int) Math.sqrt((double) (10240000 / i));
                    if (VZ.outWidth > VZ.outHeight) {
                        i6222 = i2 * i;
                        i5222 = i2;
                    } else {
                        i5222 = i2 * i;
                        i6222 = i2;
                    }
                    x.i("MicroMsg.AppBrandImgUtil", "new width height " + i6222 + " " + i5222 + " " + i);
                    i2 = i6222;
                } else {
                    i2 = i;
                }
                z2 = a(str2, i5222, i2, CompressFormat.JPEG, i3, str);
                if (!z || i4 != 0) {
                    return z2;
                }
                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                    return z2;
                }
                FileOp.deleteFile(str);
                if (FileOp.y(str2, str) >= 0) {
                    return true;
                }
                return false;
            } else {
                x.i("MicroMsg.AppBrandImgUtil", "hello ieg this is little img  %d w: %d h: %d", new Object[]{Integer.valueOf(mI), Integer.valueOf(VZ.outWidth), Integer.valueOf(VZ.outHeight)});
                if (FileOp.mI(str2) < 71680) {
                    if (z) {
                        x.i("MicroMsg.AppBrandImgUtil", "isSysSupportedPic %s", new Object[]{str2});
                        return FileOp.y(str2, str) >= 0;
                    } else if (VZ.outWidth < 150 && VZ.outHeight < 150) {
                        return a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.PNG, i3, str);
                    }
                }
                z2 = a(str2, VZ.outHeight, VZ.outWidth, CompressFormat.JPEG, i3, str);
                if (!z || i4 != 0) {
                    return z2;
                }
                x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                if ((((long) mI) - FileOp.mI(str)) * 100 >= ((long) (mI * 10))) {
                    return z2;
                }
                FileOp.deleteFile(str);
                return FileOp.y(str2, str) >= 0;
            }
        }
        i4 = 0;
        x.i("MicroMsg.AppBrandImgUtil", "option info " + VZ.outWidth + " " + VZ.outHeight + " " + z + " origQuality: " + i2 + " degree:" + i4 + " filelen " + mI + " target 960 640");
        if (VZ.outWidth < VZ.outHeight * 2) {
        }
        if (mI >= 204800) {
        }
        options = new Options();
        c.c(options);
        inputStream2 = null;
        try {
            inputStream2 = FileOp.openRead(str2);
            try {
                if (inputStream2.markSupported()) {
                }
                iVar = inputStream2;
                iVar.mark(1048576);
                decodeStream = MMBitmapFactory.decodeStream(iVar, null, options, new DecodeResultLogger(), 0, new int[0]);
                iVar.reset();
                if (decodeStream != null) {
                    c.a(c.b(decodeStream, (float) i4), i3, CompressFormat.JPEG, str, true);
                    if (z && i4 == 0) {
                        x.i("MicroMsg.AppBrandImgUtil", "filelen %d newFileLen %d picCompressAvoidanceRemainderPerc %d", new Object[]{Integer.valueOf(mI), Long.valueOf(FileOp.mI(str)), Integer.valueOf(10)});
                        if ((((long) mI) - FileOp.mI(str)) * 100 < ((long) (mI * 10))) {
                            FileOp.deleteFile(str);
                            z2 = FileOp.y(str2, str) >= 0;
                            if (iVar == null) {
                                return z2;
                            }
                            try {
                                iVar.close();
                                return z2;
                            } catch (IOException e32222222) {
                                return z2;
                            }
                        }
                        if (iVar != null) {
                            try {
                                iVar.close();
                            } catch (IOException e42222222) {
                            }
                        }
                        return true;
                    }
                    if (iVar != null) {
                        try {
                            iVar.close();
                        } catch (IOException e52222222) {
                        }
                    }
                    return true;
                }
                if (iVar != null) {
                    try {
                        iVar.close();
                    } catch (IOException e22222222) {
                    }
                }
                return false;
            } catch (Throwable th22) {
                th = th22;
                inputStream = inputStream2;
                x.printErrStackTrace("MicroMsg.AppBrandImgUtil", th, "Decode bitmap failed: " + str2, new Object[0]);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e82) {
                    }
                }
                return false;
            } catch (Throwable th222) {
                th = th222;
                inputStream = inputStream2;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e922) {
                    }
                }
                throw th;
            }
        } catch (Throwable th2222) {
            th = th2222;
            inputStream = inputStream2;
        } catch (Throwable th22222) {
            th = th22222;
            inputStream = inputStream2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e9222) {
                }
            }
            throw th;
        }
    }

    public static int vR(String str) {
        int i = 0;
        if (e.cn(str)) {
            try {
                return Exif.fromFile(str).orientation;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "duplicate exif", new Object[i]);
                return 1;
            }
        }
        x.e("MicroMsg.AppBrandImgUtil", "getExifOriention err ");
        return i;
    }

    public static int q(InputStream inputStream) {
        int i = 1;
        if (inputStream == null) {
            return i;
        }
        try {
            return Exif.fromStream(inputStream).orientation;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.AppBrandImgUtil", e, "duplicate exif", new Object[0]);
            return i;
        }
    }

    public static String lQ(int i) {
        switch (i) {
            case 0:
                return "up";
            case 1:
                return "up";
            case 2:
                return "up-mirrored";
            case 3:
                return "down";
            case 4:
                return "down-mirrored";
            case 5:
                return "left-mirrored";
            case 6:
                return "right";
            case 7:
                return "right-mirrored";
            case 8:
                return "left";
            default:
                return "up";
        }
    }

    public static String b(Options options) {
        String str = options.outMimeType;
        x.d("MicroMsg.AppBrandImgUtil", "mimetype: " + str);
        if (str == null) {
            return "unknown";
        }
        str = str.toLowerCase();
        if (str.indexOf("jpg") >= 0) {
            return "jpeg";
        }
        if (str.indexOf("jpeg") >= 0) {
            return "jpeg";
        }
        if (str.indexOf("png") >= 0) {
            return "png";
        }
        if (str.indexOf("gif") >= 0) {
            return "gif";
        }
        return "unknown";
    }
}
