package com.tencent.tencentmap.mapsdk.a;

public class ki {
    public static double[] a(ox oxVar, ox oxVar2) {
        double d;
        double d2;
        if (Math.abs(oxVar.b - oxVar2.b) < 1.0E-6d) {
            d = Double.NaN;
            d2 = Double.NaN;
        } else if (Math.abs(oxVar.a - oxVar2.a) < 1.0E-6d) {
            d = oxVar.a;
            d2 = 0.0d;
        } else {
            d = ((oxVar2.b * oxVar.a) - (oxVar.b * oxVar2.a)) / (oxVar2.b - oxVar.a);
            d2 = (oxVar2.a - oxVar.a) / (oxVar2.b - oxVar.b);
        }
        return new double[]{d2, d};
    }

    public static double a(ox oxVar, ox oxVar2, ox oxVar3) {
        double b = b(oxVar, oxVar2);
        double b2 = b(oxVar, oxVar3);
        double b3 = b(oxVar2, oxVar3);
        if (b + b2 == b3) {
            return 0.0d;
        }
        if (b3 <= 1.0E-6d || b2 * b2 >= (b * b) + (b3 * b3)) {
            return b;
        }
        if (b * b >= (b2 * b2) + (b3 * b3)) {
            return b2;
        }
        double d = ((b + b2) + b3) / 2.0d;
        return (Math.sqrt((((d - b) * d) * (d - b2)) * (d - b3)) * 2.0d) / b3;
    }

    public static ox b(ox oxVar, ox oxVar2, ox oxVar3) {
        double d;
        double d2;
        double[] a = a(oxVar2, oxVar3);
        if (Double.isNaN(a[0])) {
            d = oxVar2.b;
            d2 = oxVar.a;
        } else if (a[0] == 0.0d) {
            d = oxVar.b;
            d2 = oxVar2.a;
        } else {
            d2 = a[0];
            d = d2 * d2;
            d = (((oxVar2.b * d) + ((oxVar.a - oxVar2.a) * d2)) + oxVar.b) / (d + 1.0d);
            d2 = (d2 * (d - oxVar2.b)) + oxVar2.a;
        }
        return new ox(d2, d);
    }

    public static ox a(ox oxVar, ox oxVar2, int i) {
        double d;
        double d2;
        if (oxVar2.b > oxVar.b) {
            d = oxVar.b - ((double) i);
        } else {
            d = oxVar.b + ((double) i);
        }
        if (oxVar2.a > oxVar.a) {
            d2 = oxVar.a - ((double) i);
        } else {
            d2 = oxVar.a + ((double) i);
        }
        return new ox(d2, d);
    }

    public static double b(ox oxVar, ox oxVar2) {
        double d = oxVar.b - oxVar2.b;
        double d2 = oxVar.a - oxVar2.a;
        return Math.sqrt((d * d) + (d2 * d2));
    }

    public static double c(ox oxVar, ox oxVar2) {
        double d = oxVar.b;
        double d2 = oxVar.a;
        d *= 0.01745329251994329d;
        d2 *= 0.01745329251994329d;
        double d3 = oxVar2.b * 0.01745329251994329d;
        double d4 = oxVar2.a * 0.01745329251994329d;
        double sin = Math.sin(d);
        double sin2 = Math.sin(d2);
        d = Math.cos(d);
        d2 = Math.cos(d2);
        double sin3 = Math.sin(d3);
        double sin4 = Math.sin(d4);
        d3 = Math.cos(d3);
        d4 = Math.cos(d4);
        r18 = new double[3];
        double[] dArr = new double[]{d * d2, d2 * sin, sin2};
        dArr[0] = d4 * d3;
        dArr[1] = d4 * sin3;
        dArr[2] = sin4;
        return Math.asin(Math.sqrt((((r18[0] - dArr[0]) * (r18[0] - dArr[0])) + ((r18[1] - dArr[1]) * (r18[1] - dArr[1]))) + ((r18[2] - dArr[2]) * (r18[2] - dArr[2]))) / 2.0d) * 1.27420015798544E7d;
    }

    public static boolean a(ox oxVar, double d, ox oxVar2, ox oxVar3) {
        if (a(oxVar, oxVar2, oxVar3) - d > 1.0E-6d) {
            return false;
        }
        return c(b(oxVar, oxVar2, oxVar3), oxVar2, oxVar3);
    }

    public static boolean c(ox oxVar, ox oxVar2, ox oxVar3) {
        return (b(oxVar2, oxVar3) - b(oxVar, oxVar2)) - b(oxVar, oxVar3) < 1.0E-6d;
    }
}
