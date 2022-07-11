package com.example.demod.config;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalDateTimeConverter implements Converter<String> {
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public WriteCellData<?> convertToExcelData(String value, ExcelContentProperty contentProperty,
                                               GlobalConfiguration globalConfiguration) throws Exception {
        System.out.println("excel调用2");
        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String formatdate = format.format(value);
        System.out.println(formatdate);
        return new WriteCellData<>(String.format("标题：%s（自定义）", value));
    }

    @Override //数据写入excel的时候转换
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        System.out.println("excel调用3");
        SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd hh:mm:ss");
        String value = context.getValue();
        Long lo= Long.valueOf(value);
        System.out.println("excel调用3"+lo);
        String formatdate = format.format(new Date(lo));
        System.out.println(formatdate);
        return new WriteCellData<>(formatdate);
    }
}
