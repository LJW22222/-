package com.ljw.syncpay.domain.user.support;

public class CouponDiscount {

    public static int discount(int coupon, int amount) {
        if (coupon < 0) {
            throw new IllegalArgumentException("비정상적인 쿠폰 할인율입니다.");
        }
        if (coupon == 0) {
            return 0;
        }
        double discount = amount * (coupon / 100.0);
        if (5000 - discount <= 0) {
            return 5000;
        }
        return (int) Math.round(discount);
    }
}
