package com.example.dynamic01.config;

import com.example.dynamic01.enums.DataSourceTypeEnum;
import org.springframework.beans.factory.annotation.Value;

public class DynamicDBType {
    @Value("${spring.datasource.slavecnt}")
    private static int slaveCnt;

    private static final ThreadLocal<DataSourceTypeEnum> CONTEXT_HAND = new ThreadLocal<>();

    public static void set(DataSourceTypeEnum dbTypeEnum) {
        CONTEXT_HAND.set(dbTypeEnum);
    }

    public static void master() {
        set(DataSourceTypeEnum.MASTER);
    }

    public static void slave() {
        set(DataSourceTypeEnum.SLAVE);
    }

    public static DataSourceTypeEnum get() {
        return CONTEXT_HAND.get();
    }
}
