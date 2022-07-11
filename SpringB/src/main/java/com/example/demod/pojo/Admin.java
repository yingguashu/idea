package com.example.demod.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.example.demod.config.LocalDateTimeConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@HeadRowHeight(value = 30) // 头部行高
@ContentRowHeight(value = 25) // 内容行高
@ColumnWidth(value = 20) // 列宽
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    //设置excel表头名称，index表示对应的第几列
    @ExcelProperty(value = "管理员编号")
    private Integer id;

    @ExcelProperty(value = "管理员名字")
    private String name;

    @ExcelProperty(value = "管理员密码")
    private String password;

    @ExcelProperty(value = "用户权限")
    private String perms;

    @ExcelProperty(value = "管理员创建时间",converter = LocalDateTimeConverter.class)
    private Long dateTime;

    @ExcelProperty(value = "管理员修改时间")
    private Date updateTime;

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", perms='" + perms + '\'' +
                ", dateTime=" + dateTime +
                ", updateTime=" + updateTime +
                ", deleted=" + deleted +
                '}';
    }

    @ExcelProperty(value = "管理员是否删除")
    private Integer deleted;



}
