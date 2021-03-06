/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
package net.sf.companymanager.qbe;

/*
 * Copyright 2012 JAXIO http://www.jaxio.com Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.metamodel.SingularAttribute;


/**
 * Type safe {@link Range}s for commons types
 */
public class Ranges {
    public static class RangeBigDecimal<E> extends Range<E, BigDecimal> {

        public static <E> RangeBigDecimal<E> rangeBigDecimal(final SingularAttribute<E, BigDecimal> field) {
            return new RangeBigDecimal<E>(field);
        }

        public static <E> RangeBigDecimal<E> rangeBigDecimal(final SingularAttribute<E, BigDecimal> field,
                final BigDecimal from, final BigDecimal to) {
            return new RangeBigDecimal<E>(field, from, to);
        }

        public RangeBigDecimal(final SingularAttribute<E, BigDecimal> field) {
            super(field);
        }

        public RangeBigDecimal(final SingularAttribute<E, BigDecimal> field, final BigDecimal from, final BigDecimal to) {
            super(field, from, to);
        }
    }

    public static class RangeBigInteger<E> extends Range<E, BigInteger> {

        public static <E> RangeBigInteger<E> rangeBigInteger(final SingularAttribute<E, BigInteger> field) {
            return new RangeBigInteger<E>(field);
        }

        public static <E> RangeBigInteger<E> rangeBigInteger(final SingularAttribute<E, BigInteger> field,
                final BigInteger from, final BigInteger to) {
            return new RangeBigInteger<E>(field, from, to);
        }

        public RangeBigInteger(final SingularAttribute<E, BigInteger> field) {
            super(field);
        }

        public RangeBigInteger(final SingularAttribute<E, BigInteger> field, final BigInteger from, final BigInteger to) {
            super(field, from, to);
        }
    }

    public static class RangeDate<E> extends Range<E, Date> {
        public static <T> RangeDate<T> after(final SingularAttribute<T, Date> field, final Date from) {
            RangeDate<T> rangeDate = new RangeDate<T>(field);
            rangeDate.setFrom(from);
            return rangeDate;
        }

        public static <T> RangeDate<T> before(final SingularAttribute<T, Date> field, final Date to) {
            RangeDate<T> rangeDate = new RangeDate<T>(field);
            rangeDate.setTo(to);
            return rangeDate;
        }

        public static <T> RangeDate<T> rangeDate(final SingularAttribute<T, Date> field) {
            return new RangeDate<T>(field);
        }

        public static <T> RangeDate<T> rangeDate(final SingularAttribute<T, Date> field, final Date from, final Date to) {
            return new RangeDate<T>(field, from, to);
        }

        public RangeDate(final SingularAttribute<E, Date> field) {
            super(field);
        }

        public RangeDate(final SingularAttribute<E, Date> field, final Date from, final Date to) {
            super(field, from, to);
        }
    }

    public static class RangeDouble<E> extends Range<E, Double> {

        public static <E> RangeDouble<E> rangeDouble(final SingularAttribute<E, Double> field) {
            return new RangeDouble<E>(field);
        }

        public static <E> RangeDouble<E> rangeDouble(final SingularAttribute<E, Double> field, final Double from,
                final Double to) {
            return new RangeDouble<E>(field, from, to);
        }

        public RangeDouble(final SingularAttribute<E, Double> field) {
            super(field);
        }

        public RangeDouble(final SingularAttribute<E, Double> field, final Double from, final Double to) {
            super(field, from, to);
        }
    }

    public static class RangeFloat<E> extends Range<E, Float> {

        public static <E> RangeFloat<E> rangeFloat(final SingularAttribute<E, Float> field) {
            return new RangeFloat<E>(field);
        }

        public static <E> RangeFloat<E> rangeFloat(final SingularAttribute<E, Float> field, final Float from,
                final Float to) {
            return new RangeFloat<E>(field, from, to);
        }

        public RangeFloat(final SingularAttribute<E, Float> field) {
            super(field);
        }

        public RangeFloat(final SingularAttribute<E, Float> field, final Float from, final Float to) {
            super(field, from, to);
        }
    }

    public static class RangeInteger<E> extends Range<E, Integer> {

        public static <E> RangeInteger<E> rangeInteger(final SingularAttribute<E, Integer> field) {
            return new RangeInteger<E>(field);
        }

        public static <E> RangeInteger<E> rangeInteger(final SingularAttribute<E, Integer> field, final Integer from,
                final Integer to) {
            return new RangeInteger<E>(field, from, to);
        }

        public RangeInteger(final SingularAttribute<E, Integer> field) {
            super(field);
        }

        public RangeInteger(final SingularAttribute<E, Integer> field, final Integer from, final Integer to) {
            super(field, from, to);
        }
    }

    public static class RangeLocalDate<E> extends Range<E, LocalDate> {

        public static <E> RangeLocalDate<E> after(final SingularAttribute<E, LocalDate> field, final LocalDate from) {
            RangeLocalDate<E> rangeLocalDate = new RangeLocalDate<E>(field);
            rangeLocalDate.setFrom(from);
            return rangeLocalDate;
        }

        public static <E> RangeLocalDate<E> before(final SingularAttribute<E, LocalDate> field, final LocalDate to) {
            RangeLocalDate<E> rangeLocalDate = new RangeLocalDate<E>(field);
            rangeLocalDate.setTo(to);
            return rangeLocalDate;
        }

        public static <E> RangeLocalDate<E> rangeLocalDate(final SingularAttribute<E, LocalDate> field) {
            return new RangeLocalDate<E>(field);
        }

        public static <E> RangeLocalDate<E> rangeLocalDate(final SingularAttribute<E, LocalDate> field,
                final LocalDate from, final LocalDate to) {
            return new RangeLocalDate<E>(field, from, to);
        }

        public RangeLocalDate(final SingularAttribute<E, LocalDate> field) {
            super(field);
        }

        public RangeLocalDate(final SingularAttribute<E, LocalDate> field, final LocalDate from, final LocalDate to) {
            super(field, from, to);
        }
    }

    public static class RangeLocalDateTime<E> extends Range<E, LocalDateTime> {

        public static <E> RangeLocalDateTime<E> after(final SingularAttribute<E, LocalDateTime> field,
                final LocalDateTime from) {
            RangeLocalDateTime<E> rangeLocalDateTime = new RangeLocalDateTime<E>(field);
            rangeLocalDateTime.setFrom(from);
            return rangeLocalDateTime;
        }

        public static <E> RangeLocalDateTime<E> before(final SingularAttribute<E, LocalDateTime> field,
                final LocalDateTime to) {
            RangeLocalDateTime<E> rangeLocalDateTime = new RangeLocalDateTime<E>(field);
            rangeLocalDateTime.setTo(to);
            return rangeLocalDateTime;
        }

        public static <E> RangeLocalDateTime<E> rangeLocalDateTime(final SingularAttribute<E, LocalDateTime> field) {
            return new RangeLocalDateTime<E>(field);
        }

        public static <E> RangeLocalDateTime<E> rangeLocalDateTime(final SingularAttribute<E, LocalDateTime> field,
                final LocalDateTime from, final LocalDateTime to) {
            return new RangeLocalDateTime<E>(field, from, to);
        }

        public RangeLocalDateTime(final SingularAttribute<E, LocalDateTime> field) {
            super(field);
        }

        public RangeLocalDateTime(final SingularAttribute<E, LocalDateTime> field, final LocalDateTime from,
                final LocalDateTime to) {
            super(field, from, to);
        }
    }

    public static class RangeLong<E> extends Range<E, Long> {

        public static <E> RangeLong<E> rangeLong(final SingularAttribute<E, Long> field) {
            return new RangeLong<E>(field);
        }

        public static <E> RangeLong<E> rangeLong(final SingularAttribute<E, Long> field, final Long from, final Long to) {
            return new RangeLong<E>(field, from, to);
        }

        public RangeLong(final SingularAttribute<E, Long> field) {
            super(field);
        }

        public RangeLong(final SingularAttribute<E, Long> field, final Long from, final Long to) {
            super(field, from, to);
        }
    }
}
