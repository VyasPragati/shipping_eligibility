package com.shipping.utility;

import java.time.Month;

public enum Season {
	SPRING, SUMMER, FALL, WINTER;
	
    static public Season of ( Month month ) {
        switch ( month ) {

            // Spring.
            case MARCH:  // Java quirk: An enum switch case label must be the unqualified name of an enum. So cannot use `Month.MARCH` here, only `MARCH`.
                return Season.SPRING;

            case APRIL:
                return Season.SPRING;

            // Summer.
            case MAY:
                return Season.SUMMER;

            case JUNE:
                return SUMMER;

            case JULY:
                return Season.SUMMER;

            case AUGUST:
                return Season.SUMMER;

            // Fall.
            case SEPTEMBER:
                return Season.FALL;

            case OCTOBER:
                return Season.FALL;

            // Winter.
            case NOVEMBER:
                return Season.WINTER;

            case DECEMBER:
                return Season.WINTER;

            case JANUARY:
                return Season.WINTER;

            case FEBRUARY:
                return Season.WINTER;

            default:
                System.out.println ( "ERROR." );  // FIXME: Handle reaching impossible point as error condition.
                return null;
        }
    }

}

